package com.java.dto;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamicInsert // 데이터값이 null일 경우 컬럼에서 제외
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity // jpa 자동생성(table명:MemberDto,column명:변수명)
public class MemberDto {
	
	@Id // primary key
	@Column(name = "member_id", nullable = false,length=30)
	private String memberId;			// 아이디
	
	@Column(name = "member_pw", nullable = false,length=30)
	private String memberPw;			// 패스워드
	
	@Column(name = "member_name", nullable = false,length=20)
	private String memberName;		// 실명
	
	@Column(name = "member_nickname", nullable = false,length=20)
	private String memberNickname;    // 닉네임
	
	@Column(name = "member_email", nullable = false,length=30)
	private String memberEmail;       // 이메일
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "member_birth", nullable = false,length=20)
	private Date memberBirth;         // 생년월일 (DATE 타입)
	
	@Column(name = "member_phone", nullable = false,length=20)
	private String memberPhone;       // 전화번호
	
	@ColumnDefault("'남자'")
	@Column(name = "member_gender", nullable = false, length = 20)
	private String memberGender;		//성별
	
	@Column(name = "member_address", nullable = false,length=50)  
	private String memberAddress;		// 주소
	
	@Column(name = "member_country", nullable = false, length = 20)
	private String memberCountry; // 국가/지역

	@Column(name = "member_membership", nullable = false, length = 20)
	private String memberMembership; // 멤버십 등급

	@Column(name = "member_usertype", nullable = false, length = 20)
	private String memberUsertype; // 사용자 유형

	@CreationTimestamp // 시스템 시간 자동 입력
	@Column(name = "member_date") // 수정 불가 설정
	private Timestamp memberDate; // 가입일

	@Column(name = "member_notification_enabled", length = 255)
	private String memberNotificationEnabled; // 알림 설정 (선택 사항)
	
	@Column(name = "community_cnt", columnDefinition = "INT DEFAULT 0")
	private int communityCnt; // 커뮤니티 작성 수 (기본값 0)
	
	@Column(name = "comment_cnt", columnDefinition = "INT DEFAULT 0")
	private int commentCnt; // 댓글 작성 수 (기본값 0)
	
}