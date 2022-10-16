package com.example.demo.core.service;


import com.example.demo.dto.enums.State;
import com.example.demo.dto.in.ShoesIn;
import com.example.demo.dto.out.v2.NewShoe;

import java.util.List;

public interface ShoeService {

    List<NewShoe> findAllStock();

    State findState(long size);

    ShoesIn patchStock(ShoesIn shoesIn);
}
