package com.java.dto;

import java.time.LocalDate;
import java.time.LocalTime;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ConcertScheduleDto {
	
	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_seq")
    @SequenceGenerator(name = "schedule_seq", sequenceName = "schedule_seq", allocationSize = 1)
	@Column(name = "schedule_no", nullable = false)
    private int scheduleNo; // 스케줄 고유 번호

    @Column(name = "schedule_date", nullable = false)
    private LocalDate scheduleDate; // 스케줄 날짜

    @Column(name = "schedule_start_time", nullable = false)
    private LocalTime scheduleStartTime; // 스케줄 시작 시간

    // Concert 엔티티와의 관계 설정 (ManyToOne)
    @ManyToOne
    @JoinColumn(name = "concert_no", nullable = false) // 외래 키 지정
    private ConcertDto concertDto; 
	
	

} 