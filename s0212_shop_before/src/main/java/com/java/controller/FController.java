package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class FController {
		
		@Autowired
		BoardService boardService;
	
	
		// 메인페이지 오픈
		@GetMapping("/")
		public String index() {
			return "index";
		}
		
		// 글 작성페이지 오픈
		@GetMapping("/board/bwrite")
		public String bwrite() {
			return "bwrite";
		}
		
		
		// 글 작성페이지 - 파일업로드 기능
		@PostMapping("/board/bwrite")
		public String bwrite(BoardDto bdto,
				@RequestParam MultipartFile files) throws Exception {
		
			bdto.setBfile(""); // 파일 첨부가 되지 않았을 경우
			
			if(!files.isEmpty()) { // 파일 첨부가 되어 있으면
				
				// 파일이 2개 이상일 경우, 2번 이상 실행
//				for(MultipartFile file :files) {
					// 최초 파일 이름 -> 중복 방지를 위해 파일 이름 변경
					String origin = files.getOriginalFilename(); 
					System.out.println("최초파일이름: "+origin);
					long time = System.currentTimeMillis();
					
					// 랜덤 문자 생성 객체 UUID  -> long time = System.currentTimeMillis(); 랑 같은 의미
	//				UUID uuid = UUID.randomUUID();
	//				String uname = uuid+"_"+origin;
					
					
					String realFileName = String.format("%d_%s",time,origin);
					System.out.println("변경파일이름: "+realFileName);
					
					// 파일 저장 위치
	//				String url = "C:/worksts/s0212/src/main/resources/static/upload/";
					String url = "C:/upload/board/";
	//				String url = "C:/upload/";
					
					// 파일 저장
					File f = new File(url+realFileName);
					
					// 파일업로드
					try {
						files.transferTo(f);
						// dto에 파일 이름 저장
						bdto.setBfile(realFileName);
					} catch (Exception e) {e.printStackTrace();} 
					
//				}
				
			} else {
				bdto.setBfile("");
				
			} // isEmpty
			
			boardService.bwrite(bdto);
			
			System.out.println("파일 업로드 완료");
			
//			return "redirect:/?fname="+realFileName;
			return "redirect:/board/blist";
		}
		
		
		// 게시판 전체 리스트
		@GetMapping("/board/blist")
		public String blist(Model model) {
			ArrayList<BoardDto> list = boardService.blist();
			model.addAttribute("list",list);
			return "blist";
		}
		
		// 게시글 상세보기
		@GetMapping("/board/bview")
		public String bview(int bno, Model model) {
			BoardDto baordDto = boardService.bview(bno);
			model.addAttribute("bdto",baordDto);
			return "bview";
		}
		
		
		
		
		
		
		
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		
		// 2개이상 파일 업로드 (예시) - 뭔가 오류가 났다
//		@PostMapping("/board/bwrite")
//		public String bwrite(BoardDto bdto,
//				List<MultipartFile> files) throws Exception {
//			
//			String realFileName ="";
//			
//			if(!files.isEmpty()) { // 파일 첨부가 되어 있으면
//				
//				// 파일이 2개 이상일 경우, 2번 이상 실행
//				for(MultipartFile file :files) {
//					
//					// 최초 파일 이름 -> 중복 방지를 위해 파일 이름 변경
//					String origin = files.getOriginalFilename();
//					System.out.println("최초파일이름: "+origin);
//					long time = System.currentTimeMillis();
//					
//					// 랜덤 문자 생성 객체 UUID  -> long time = System.currentTimeMillis(); 랑 같은 의미
////				UUID uuid = UUID.randomUUID();
////				String uname = uuid+"_"+origin;
//					
//					
//					realFileName = String.format("%d_%s",time,origin);
//					System.out.println("변경파일이름: "+realFileName);
//					
//					// 파일 저장 위치
////					String url = "C:/worksts/s0212/src/main/resources/static/upload/";
//					String url = "C:/upload/board/";
////					String url = "C:/upload/";
//					
//					// 파일 저장
//					File f = new File(url+realFileName);
//					
//					// 파일업로드
//					files.transferTo(f);
////					try {
////						files.transferTo(f);
////						// dto에 파일 이름 저장
////						bdto.setBfile(realFileName);
////					} catch (Exception e) {e.printStackTrace();} 
//					
//				} // for
//				
//				// dto에 파일 이름 저장
//				bdto.setBfile(realFileName);
//			} else {
//				bdto.setBfile("");
//				
//			} // isEmpty
//			
//			boardService.bwrite(bdto);
//			System.out.println("파일 업로드 완료");
//			
////			return "redirect:/?fname="+realFileName;
//			return "redirect:/board/blist";
//		}

}
