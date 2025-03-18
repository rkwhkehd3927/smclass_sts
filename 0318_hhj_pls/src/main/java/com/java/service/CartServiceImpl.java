package com.java.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.AddressDto;
import com.java.dto.CartDto;
import com.java.dto.MemberDto;
import com.java.dto.ShopDto;
import com.java.repository.AddressRepository;
import com.java.repository.CartRepository;
import com.java.repository.MRepository;
import com.java.repository.ShopRepository;

@Service
public class CartServiceImpl implements CartService {
	@Autowired CartRepository cartRepository;
	@Autowired MRepository memberRepository;
	@Autowired ShopRepository shopRepository;
	
	// 장바구니 리스트
	@Override
	public List<CartDto> findByMemberNickname(String sessionNick) {
		List<CartDto> cList = cartRepository.findByMemberNickname(sessionNick);
		return cList;
	}

	// 장바구니 삭제
	@Override
	public boolean deleteCartItem(int cartNo) {
	    try {
	        if (cartRepository.existsById(cartNo)) {  // 해당 cartNo가 존재하는지 확인
	        	cartRepository.deleteById(cartNo);   // 장바구니에서 삭제
	            return true; // 삭제 성공
	        } else {
	            return false; // 해당 cartNo가 없음
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false; // 삭제 중 오류 발생
	    }
	}

	// 장바구니 물건 담기
		@Override
		public CartDto addToCart(String memberNickname, String cartItemsJson, String cartCategory, int quantity, int finalPrice) {
		    System.out.println("Searching for member with nickname: " + memberNickname);
		    Optional<MemberDto> memberOpt = memberRepository.findByMemberNickname(memberNickname);
		    System.out.println("Member found: " + memberOpt.isPresent());
		    
		    System.out.println("장바구니 JSON 데이터: " + cartItemsJson);
		    // 1. 회원 조회
		    MemberDto member = memberRepository.findByMemberNickname(memberNickname)
		        .orElseThrow(() -> new RuntimeException("회원을 찾을 수 없습니다."));
		    System.out.println("조회결과 : " + member);
		    
		    // 2. 장바구니 DTO 생성 및 필드 설정
		    CartDto cartDto = new CartDto();
		    cartDto.setMember(member);
		    cartDto.setCart_items(cartItemsJson);            // 장바구니에 담긴 상품 정보 (JSON 문자열)
		    cartDto.setCart_category(cartCategory);           // 예: "굿즈" (필요에 따라 전달받은 값 사용)
		    cartDto.setCart_purchase_count(quantity);         // 구매(추가) 수량
		    cartDto.setCart_total_amount(finalPrice);          // 총 금액 (단가 × 수량)
		    cartDto.setCart_date(new Timestamp(System.currentTimeMillis())); // 현재 시간
		    
		    // 3. 저장 및 반환
		    return cartRepository.save(cartDto);
		}

	
	//구매제한개수 확인하기
	@Override
	public int getCartItemQuantity(String memberNickname, int shopNo) {
	    // 사용자의 장바구니 목록 가져오기
	    List<CartDto> userCarts = findByMemberNickname(memberNickname);
	    
	    int totalQuantity = 0;
	    
	    // 각 장바구니를 확인
	    for (CartDto cart : userCarts) {
	        if (cart.getCart_items() != null) {
	            try {
	                // JSON 문자열 파싱
	                ObjectMapper mapper = new ObjectMapper();
	                List<Map<String, Object>> items = mapper.readValue(
	                    cart.getCart_items(), 
	                    new TypeReference<List<Map<String, Object>>>() {}
	                );
	                
	                // 상품 번호가 일치하는 항목 찾기
	                for (Map<String, Object> item : items) {
	                    if (Integer.parseInt(item.get("shopNo").toString()) == shopNo) {
	                        // 수량 더하기
	                        totalQuantity += Integer.parseInt(item.get("quantity").toString());
	                    }
	                }
	            } catch (Exception e) {
	                System.out.println("JSON 파싱 오류: " + e.getMessage());
	            }
	        }
	    }
	    
	    return totalQuantity;
	}

	// 최근 본 상품 추가
	@Override
	public void updateViewedItems(String memberNickname, int shopNo) {
	    // 🛒 회원의 장바구니 조회 (해당 회원의 장바구니 리스트 중 첫 번째 아이템 사용)
	    List<CartDto> cartList = cartRepository.findByMemberNickname(memberNickname);
	    CartDto cart = cartList.isEmpty() ? null : cartList.get(0);  // 없으면 null

	    // 🔹 장바구니가 없으면 새로 생성
	    if (cart == null) {
	        Optional<MemberDto> memberOpt = memberRepository.findByMemberNickname(memberNickname);
	        if (!memberOpt.isPresent()) {
	            throw new RuntimeException("회원을 찾을 수 없습니다.");
	        }

	        cart = new CartDto();
	        cart.setMember(memberOpt.get());
	    }

	    // 🔹 기존 `cart_viewed_items` 조회
	    String viewedItems = cart.getCart_viewed_items();
	    List<String> viewedList = new ArrayList<>();

	    if (viewedItems != null && !viewedItems.isEmpty()) {
	        viewedList = new ArrayList<>(Arrays.asList(viewedItems.split(","))); // 문자열 → 리스트 변환
	    }

	    // 🔹 동일한 상품이 이미 있으면 제거
	    viewedList.remove(String.valueOf(shopNo));

	    // 🔹 새 상품을 리스트의 마지막에 추가
	    viewedList.add(String.valueOf(shopNo));

	    // 🔹 최대 5개까지만 저장 (FIFO 방식)
	    while (viewedList.size() > 7) {
	        viewedList.remove(0); // 가장 오래된 상품 제거
	    }

	    // 🔹 리스트를 문자열로 변환 후 DB 업데이트
	    cart.setCart_viewed_items(String.join(",", viewedList));
	    cartRepository.save(cart);
	}


	// 최근 본 상품 조회
	// 최근 본 상품 조회 (최대 7개 지원)
	@Override
	public List<ShopDto> getRecentViewedItems(String memberNickname) {
	    List<CartDto> cList = cartRepository.findByMemberNickname(memberNickname);
	    
	    if (cList.isEmpty()) return new ArrayList<>();

	    CartDto cart = cList.get(0); 
	    String viewedItems = cart.getCart_viewed_items(); // "778899001,556677891,112244668,334455668"

	    if (viewedItems == null || viewedItems.isEmpty()) return new ArrayList<>();

	    // 🔹 shop_no를 리스트로 변환
	    List<Integer> shopNoList = Arrays.stream(viewedItems.split(","))
	                                     .map(Integer::parseInt)
	                                     .collect(Collectors.toList());

	    // 🔹 최대 7개까지만 유지 (더 많으면 자름)
	    if (shopNoList.size() > 7) {
	        shopNoList = shopNoList.subList(0, 7);
	    }

	    // 🔹 7개보다 적으면 더미 값 추가 (오라클에서 오류 방지)
	    while (shopNoList.size() < 7) {
	        shopNoList.add(-1);
	    }

	    // 🔹 최신순 정렬 유지한 상태로 조회
	    return shopRepository.findByShopNoIn(shopNoList, 
	                                         shopNoList.get(0), shopNoList.get(1), 
	                                         shopNoList.get(2), shopNoList.get(3), 
	                                         shopNoList.get(4), shopNoList.get(5), 
	                                         shopNoList.get(6));
	}

	@Override
	public CartDto addToCart(String memberNickname, String cartItems) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearCart(String nickName) {
		cartRepository.clearCart(nickName);
		
	}
	

	

}
