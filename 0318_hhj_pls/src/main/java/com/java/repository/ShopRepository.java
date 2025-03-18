package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.dto.ShopDto;

public interface ShopRepository extends JpaRepository<ShopDto, Integer>{

	//아티스트전체
	@Query(value = "SELECT * FROM shopdto WHERE artist_no = :artistNo", nativeQuery = true)
	List<ShopDto> findByNo(@Param("artistNo") int artistNo);

	@Query(value = "SELECT * FROM shopdto " +
            "WHERE shop_no IN (:shopNoList) " +
            "ORDER BY DECODE(shop_no, " +
            ":shopNo1, 7, :shopNo2, 6, :shopNo3, 5, " +
            ":shopNo4, 4, :shopNo5, 3, :shopNo6, 2, :shopNo7, 1, 999) ASC",
    nativeQuery = true)
List<ShopDto> findByShopNoIn(@Param("shopNoList") List<Integer> shopNoList,
                          @Param("shopNo1") Integer shopNo1,
                          @Param("shopNo2") Integer shopNo2,
                          @Param("shopNo3") Integer shopNo3,
                          @Param("shopNo4") Integer shopNo4,
                          @Param("shopNo5") Integer shopNo5,
                          @Param("shopNo6") Integer shopNo6,
                          @Param("shopNo7") Integer shopNo7);


}