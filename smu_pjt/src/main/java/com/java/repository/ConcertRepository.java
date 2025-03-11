package com.java.repository;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.ConcertDto;
import com.java.dto.SaleConcertDto;

public interface ConcertRepository extends JpaRepository<ConcertDto, Integer>{



}
