package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;
import com.java.service.MemberServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
			@Autowired MemberService memberService;
			@Autowired HttpSession session;
	
			// 회원가입
			@GetMapping("/member")
			public String member() {
				return "member";
			}
			
			
			@PostMapping("/member")
			public String member(MemberDto mdto) {
				memberService.save(mdto);
				return "redirect:/";
			}
			
			// 전체 회원 리스트 - selectAll()
			@GetMapping("/mlist")
			public String mlist(Model model) {
				List<MemberDto> list = memberService.findAll();
				model.addAttribute("list",list);
				return "mlist";
			}
			
			// 회원정보 상세
			@GetMapping("/meminfo")
			public String meminfo(String id,Model model) {
				// 회원 정보 1명 - selectOne()
				MemberDto memberDto = memberService.findById(id);
				model.addAttribute("mdto",memberDto);
				return "meminfo";
			}
			
			// 회원 정보 수정
			@GetMapping("/memUpdate")
			public String memUpdate(String id,Model model) {
				// 회원 정보 1명 - selectOne()
				MemberDto memberDto = memberService.findById(id);
				model.addAttribute("mdto",memberDto);
				return "memUpdate";
			}
			
			// 회원 정보 수정 저장
			@PostMapping("/memUpdate")
			public String memUpdate(MemberDto mdto,Model model) {
				// 회원 정보 1명 - selectOne()
				MemberDto memberDto = memberService.findById(mdto.getId());
				memberDto.setPw(mdto.getPw());
				memberDto.setName(mdto.getName());
				memberDto.setPhone(mdto.getPhone());
				memberDto.setGender(mdto.getGender());
				memberDto.setHobby(mdto.getHobby());
				memberDto.setMdate(mdto.getMdate());  // 날짜 확인 필요
				memberService.save(mdto); // id가 존재하면 update 실행, id가 존재하지 않으면 save 실행
				System.out.println("수정 완료!");
				
				return "redirect:/mlist";
			}
			
			// 회원 정보 삭제
			@ResponseBody // 데이터로 전송
			@PostMapping("/memDelete")
			public String memDelete(String id) {
				System.out.println("id: "+id);
				memberService.deleteById(id);
				
				// 삭제 성공시 "1" 전송
				return "1";
			}
			
			// 로그인
			@GetMapping("/login")
			public String login() {
				return "login";
			}
			
			// 로그인
			@PostMapping("/login")
			public String login(String id,String pw) {
				MemberDto memberDto = memberService.findByIdAndPw(id,pw);
				if(memberDto != null) {
					System.out.println("로그인 완료");
					session.setAttribute("session_id", id);
					return "redirect:/";
				} else {
					System.out.println("로그인 실패");
				}
				return "redirect:/login?loginChk=0";
			}

}
