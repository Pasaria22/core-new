package com.example.demo.core.repository;



import com.example.demo.dto.out.v2.ResultQueryDto;
import com.example.demo.entity.ShoeEntity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoeRepository extends JpaRepository<ShoeEntity, Long> {
    @Query("SELECT new com.example.demo.dto.out.v2.ResultQueryDto(shoe.color, shoe.size, count(*)) FROM ShoeEntity shoe GROUP BY shoe.color, shoe.size")
    List<ResultQueryDto> countAllShoesGroupByColorAndSize();


    @Query("SELECT COUNT(*) FROM ShoeEntity")
    long countAll();
}
