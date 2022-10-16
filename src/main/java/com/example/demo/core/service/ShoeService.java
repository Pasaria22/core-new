package com.example.demo.core.service;


import com.example.demo.entity.ShoeEntity;
import com.example.demo.dto.enums.State;
import com.example.demo.dto.out.updated.NewShoe;

import java.util.List;

public interface ShoeService {

    List<ShoeEntity> findAllByColor(int color);

    List<NewShoe> findAllStock();

    State findState(int size);
}
