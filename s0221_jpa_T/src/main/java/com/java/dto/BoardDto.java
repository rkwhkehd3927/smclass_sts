package com.java.dto;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BoardDto {
	
//	@SequenceGenerator(
//	name = "board_seq_generator",  // 시퀀스 이름
//	sequenceName = "boarddto_seq",  // 생성된 시퀀스 이름
//	initialValue = 1,  // 시작값
//	allocationSize = 1)  // 메모리를 통한 할당범위
	
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ←↑ 시퀀스 자동생성
	private int bno;
	@Column(nullable = false, length=100)
	private String btitle;
	
	@Lob // 대용량 데이터
	private String bcontent;
	
	@ManyToOne(fetch = FetchType.EAGER) // 하나의 id로 여러 게시글은 작성할 수 있으나, 여러 id로 하나의(같은) 게시글의 작성자가 될 수 없음(boarddto가 ManyToOne)
	@JoinColumn(name="id") // Fk키가 id라고 설정 //	select * from boarddto, memberdto where boarddto.id = memberdto.id
	private MemberDto memberDto; // memberdto 테이블 primary key - 객체타입 입력 불가
//	private String id; // db에서도 id만 저장
	
	private int bgroup;
	@ColumnDefault("0") // 숫자 "0", 문자 "'남자'" 
	private int bstep;
	@ColumnDefault("0") // 숫자 "0", 문자 "'남자'" 
	private int bindent;
	@ColumnDefault("0") // 숫자 "0", 문자 "'남자'" 
	private int bhit;
	@UpdateTimestamp // 자동 시간 입력
	private Timestamp bdate;
	
	@Column(nullable = true,length=100)
	private String bfile;
	
	
	// CboardDto의 boardDto 컬럼을 넣어줌 (BoardDto boardDto 이름을 가져옴)
	// mappedBy 연관관계 주인이 아님 - FK 생성하지 말기
	// 테이블을 join 해서 가져오는 것만 하면 됨
	@OneToMany(mappedBy = "boardDto",fetch = FetchType.EAGER) // foreign key 생성 안함
	private List<CboardDto> clist; 
	
	

}
