package com.example.demo.core.service.impl;


import com.example.demo.core.repository.ShoeRepository;
import com.example.demo.core.service.ShoeService;
import com.example.demo.dto.enums.State;
import com.example.demo.dto.in.ShoeFilter;
import com.example.demo.dto.in.ShoesIn;
import com.example.demo.dto.out.v2.NewShoe;
import com.example.demo.dto.out.v2.ResultQueryDto;
import com.example.demo.entity.ShoeEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoeServiceImpl implements ShoeService {

    private final ShoeRepository shoeRepository;

    public ShoeServiceImpl(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    @Override
    public List<NewShoe> findAllStock() {
        List<NewShoe> newShoesList = new ArrayList<>();
        List<ResultQueryDto> resultQueryDtos = shoeRepository.countAllShoesGroupByColorAndSize();
        resultQueryDtos.stream().map(resultQueryDto -> newShoesList.add(
                NewShoe.builder()
                        .color(ShoeFilter.Color.values()[resultQueryDto.getColor()])
                        .quantity(resultQueryDto.getQuantity())
                        .size(resultQueryDto.getSize()).build())).collect(Collectors.toList());
        return newShoesList;
    }


    @Override
    public State findState(long size) {
        if (size < 30 && size != 0) {
            return State.SOME;
        }
        if (size == 30) {
            return State.FULL;
        }
        return State.EMPTY;
    }

    @Override
    public ShoesIn patchStock(ShoesIn shoesIn) {
        long fields = shoeRepository.countAll();
        if (shoesIn.getQuantity() < (30 - fields)) {
            for (int i = 0; i < shoesIn.getQuantity(); i ++) {
                shoeRepository.save(new ShoeEntity(shoesIn.getName(), shoesIn.getSize(), shoesIn.getColor()));
            }
        } else {
            throw new RuntimeException("No es posible añadir más stock a la tienda");
        }

        return shoesIn;
    }
}