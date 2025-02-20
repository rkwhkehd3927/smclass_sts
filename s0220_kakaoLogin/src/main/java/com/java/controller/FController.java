package com.java.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.AttributedString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.KakaoProfile;
import com.java.dto.OauthToken;

import ch.qos.logback.classic.html.UrlCssBuilder;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
		@Autowired HttpSession session;
	
	
		// 메인페이지 오픈
		@GetMapping("/")
		public String index() {
			return "index";
		}
		
		// 로그인페이지 오픈
		@GetMapping("/login")
		public String login() {
			return "login";
		}
		
		// redirect
		@RequestMapping("/kakao/oauth")
//		@ResponseBody // 일단 데이터로 받아놓기
		public String oauth(String code) { 
			System.out.println("kakao oauth code: "+code);
			// code: code
			String grant_type = "authorization_code";
			String client_id = "ab1c813023e446159cce99efdf101322";
			String redirect_uri = "http://localhost:8181/kakao/oauth";
			String content_type = "application/x-www-form-urlencoded;charset=utf-8";
			
			// httpURL 전송: HttpURLConnection
//			URL url = new URL(UrlCssBuilder.toString());
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			conn.setRequestMethod("GET");
			
			// httpURL 전송: RestTemplates
			RestTemplate rt = new RestTemplate();
			// header
			HttpHeaders headers = new HttpHeaders();
			headers.add("content_type", content_type);
			
			// 데이터 묶기
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			params.add("grant_type", grant_type);
			params.add("client_id", client_id);
			params.add("redirect_uri", redirect_uri);
			params.add("code", code);
			
			// headers, 데이터 4개 묶기
			HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = 
					new HttpEntity<>(params,headers);
			
			// http 요청 url
			String oauthUrl = "https://kauth.kakao.com/oauth/token";
			
			// http 에 데이터 전송 - 토큰키 받기
			ResponseEntity<String> response = 
			rt.exchange(oauthUrl, HttpMethod.POST, kakaoTokenRequest, String.class);
			
			System.out.println("kakaoToken response: "+response);
			
			// response 에서 받은 데이터(json)를 dto(OauthToken) 파일에 저장
			ObjectMapper objectMapper = new ObjectMapper();
			OauthToken oauthToken = null;
			
			try {
				// response 에서 받은 데이터(json)를 dto(OauthToken) 파일에 저장
				oauthToken = objectMapper.readValue(response.getBody(), OauthToken.class);
			} catch (Exception e) {e.printStackTrace();}
						
			System.out.println("oauthToken 객체에서 access_token 출력: "+oauthToken.getAccess_token());
			
			
			// ---------------------------------------------------------------------
			
			// access_token 분리하여 전송하면, 회원정보 아이디, 닉네임, 사진, 성별 등을 받아옴
			String access_token = oauthToken.getAccess_token();
			String authorization = "Bearer "+access_token;
			content_type = "application/x-www-form-urlencoded;charset=utf-8"; // 위에서 이미 선언
			
			
			// httpURL 전송: RestTemplates
			RestTemplate rt2 = new RestTemplate();
			
			// header
			HttpHeaders headers2 = new HttpHeaders();
			headers2.add("Authorization", authorization);
			headers2.add("Content_type", content_type);
			
			// 여기는 데이터 묶기가 없음
			
			// 1개로 묶기(헤더만 묶기)
			HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest2 =
					new HttpEntity<>(headers2);
			
			// url
			String oauthUrl2 = "https://kapi.kakao.com/v2/user/me";
			
			// http 에 데이터 전송 - 카카오 회원정보 : 닉네임, 사진, 아이디, 성별 등을 받을 수 있음
			ResponseEntity<String> response2 = 
			rt.exchange(oauthUrl2, HttpMethod.POST,kakaoTokenRequest2,String.class);
			
			System.out.println("kakaoToken response2: "+response2);
			
			
			System.out.println("회원정보 출력: "+response2.getBody());
			// response 에서 받은 데이터(json)를 dto(KakaoProfile) 객체 저장
			ObjectMapper objectMapper2 = new ObjectMapper();
			KakaoProfile kakaoProfile = null;
			
			try {
				// response 에서 받은 데이터(json)를 dto(KakaoProfile) 객체 저장
				kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
			} catch (Exception e) {e.printStackTrace();}
						
			System.out.println("kakaoProfile 객체에서 nickname 출력: "+kakaoProfile.getProperties().getNickname());
			System.out.println("kakaoProfile 객체에서 id 출력: "+kakaoProfile.getId()); // type Long
			System.out.println("kakaoProfile 객체에서 image 출력: "+kakaoProfile.getProperties().getProfile_image()); // type Long
			
			// 세션 저장 - 로그인 시켜주기
			session.setAttribute("kakaoProfile_nickname", kakaoProfile.getProperties().getNickname());
			session.setAttribute("kakaoProfile_id", kakaoProfile.getId());
			
			
			return "redirect:/";
		}
		
}
