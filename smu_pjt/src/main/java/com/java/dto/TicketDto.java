package com.java.dto;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Entity
public class TicketDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_seq")
    @SequenceGenerator(name = "shop_seq", sequenceName = "shop_seq", allocationSize = 1)
    private int ticket_no;                  // 티켓고유번호
    @Column(nullable = false, length=30)
    private String ticket_title;            // 티켓명
    @Column(length=1000)
    private String ticket_content;          // 티켓설명
    @Column(nullable = false)
    private int ticket_price;               // 가격
    @Column(nullable = false)
    private int ticket_quantity;            // 재고수량
    @CreationTimestamp
    private Timestamp ticket_date;          // 등록일
    @Column(nullable = false, length=10)
    private String ticket_type;             // 티켓 유형 (offline, online)
    @Column
    private Timestamp ticket_valid_from;    // 티켓 사용 가능 시작일
    @Column
    private Timestamp ticket_valid_to;      // 티켓 사용 가능 종료일
    @Column(length = 8)
    private String redeem_code;             // 리딤 코드 (랜덤 8자리, 온라인 티켓용)
    @Column(nullable = false)
    private boolean is_restreaming_allowed; // 재스트리밍 가능 여부 (온라인 티켓용)
//    @ManyToOne
//    @JoinColumn(name = "artist_group_name")  // 외래키로 artist와 연결
//    private ArtistDto ticket_group_name;
}
