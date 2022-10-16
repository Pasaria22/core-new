package com.example.demo.core.repository;



import com.example.demo.entity.ShoeEntity;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoeRepository extends JpaRepository<ShoeEntity, Long> {
    List<ShoeEntity> findAllByColor(int color);
}
