package com.java.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SaleConcertDto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_concert_seq")
    @SequenceGenerator(name = "sale_concert_seq", sequenceName = "sale_concert_seq", allocationSize = 1)
	@Column(name = "sale_concert_no", nullable = false)
    private int saleConcertNo; // 판매 콘서트 고유 번호
	
	
	@ManyToOne
	@JoinColumn(name = "concert_no", nullable = false)
	private ConcertDto concertDto;  // 콘서트 전체 기준


	@Column(name = "total_ticket_count", nullable = true)
	private Integer totalTicketCount;  // 해당 콘서트의 전체 티켓 개수 (온라인은 0)

	@Column(name = "available_ticket_count", nullable = true)
	private Integer availableTicketCount;  // 판매 가능한 티켓 개수 (온라인은 0)
	
	@Column(name = "ticket_type", nullable = false)
	private String ticketType;  // "offline" 또는 "online"
	
	@Column(name = "rsv_open_date", nullable = false)
    private LocalDate rsvOpenDate; // 티켓 예약 오픈 날짜
	
	@Column(name = "sale_start_date", nullable = false)
    private LocalDate saleStartDate;  // 티켓 판매 시작일

    @Column(name = "sale_end_date", nullable = false)
    private LocalDate saleEndDate;  // 티켓 판매 종료일

    @Transient
	public boolean isSoldOut(int bookedTickets) {
    	if ("online".equals(ticketType)) {
            return false; // 온라인은 무조건 판매 가능
        }
	    return bookedTickets >= totalTicketCount;
	}  // 솔드아웃 여부 판단 (true: 솔드아웃)
    
    @Transient
	public int getRemainingTickets(int bookedTickets) {
    	if ("online".equals(ticketType)) {
            return Integer.MAX_VALUE; // 온라인은 무제한
        }
	    return Math.max(totalTicketCount - bookedTickets, 0);
	} // 남은 티켓 개수 계산
	
	
}
