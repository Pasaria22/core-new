package com.example.demo.core.service.impl;


import com.example.demo.entity.ShoeEntity;
import com.example.demo.core.repository.ShoeRepository;
import com.example.demo.core.service.ShoeService;
import com.example.demo.dto.enums.State;
import com.example.demo.dto.in.ShoeFilter;
import com.example.demo.dto.out.updated.NewShoe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoeServiceImpl implements ShoeService {

    private final ShoeRepository shoeRepository;

    public ShoeServiceImpl(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    @Override
    public List<ShoeEntity> findAllByColor(int color) {
        return shoeRepository.findAllByColor(color);
    }

    @Override
    public List<NewShoe> findAllStock() {
        ShoeFilter.Color[] values = ShoeFilter.Color.values();
        List<NewShoe> newShoesList = new ArrayList<>();


        List<ShoeEntity> shoes = Arrays.stream(values).limit(30).map(value -> findAllByColor(value.ordinal())).flatMap(Collection::stream).collect(Collectors.toList());

/*
        NewShoe newShoe = NewShoe.builder()
                .color(ShoeFilter.Color.BLACK)
                //.quantity(quantity)
                .size(shoes.get(i).getSize()).build();*/


        return newShoesList;
    }


    @Override
    public State findState(int size) {
        if (size < 30 && size != 0) {
            return State.SOME;
        }
        if (size == 30) {
            return State.FULL;
        }
        return State.EMPTY;
    }
}