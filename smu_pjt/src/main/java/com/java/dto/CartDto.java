package com.java.dto;
import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class CartDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cart_no; // 장바구니 고유번호
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private MemberDto member;  // :로켓: 회원 테이블과 연결 (외래키)
    @Column(length=1000)
    private String cart_viewed_items; // 최근 본 상품(상세보기 클릭시 관련된 DB넘어오면 DB 추가)
    @Column(length=2000)
    private String cart_items; // 장바구니 상품
    @Column(length=1000)
    private String cart_restock_items; // 재입고 알림 상품(재고량 0의 알림표시 클릭 시 DB 추가)
    @Column(length=2000)
    private String cart_related_items; // 유사 상품
    @Column
    private int cart_purchase_count; // 구매 횟수
    @Column
    private int cart_total_amount; // 총 금액
    @Column
    private Timestamp cart_date; // 장바구니 업데이트 날짜
}