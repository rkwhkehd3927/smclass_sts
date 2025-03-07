package com.java.dto;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamicInsert
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ArtistDto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_no")
    private int artistNo; // 아티스트 고유 번호

    @Column(name = "artist_group_name", length = 30)
    private String artistGroupName; // 그룹 이름

    @Column(name = "artist_group_image", length = 100)
    private String artistGroupImage; // 그룹 이미지

}
