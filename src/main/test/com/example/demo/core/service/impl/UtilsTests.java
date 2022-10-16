package com.example.demo.core.service.impl;

import com.example.demo.dto.in.ShoeFilter;
import com.example.demo.dto.in.ShoesIn;
import com.example.demo.dto.out.v2.NewShoe;
import com.example.demo.dto.out.v2.ResultQueryDto;

import java.util.ArrayList;
import java.util.List;

public class UtilsTests {


    private static final long QUANTITY = 3L;
    private static final int SIZE = 5;
    private static final int COLOR = 0;
    private static final String NAME = "NAME";


    //List<ResultQueryDto>

    public ResultQueryDto createResultQueryDto() {
        ResultQueryDto resultQueryDto = new ResultQueryDto();
        resultQueryDto.setQuantity(QUANTITY);
        resultQueryDto.setColor(COLOR);
        resultQueryDto.setSize(SIZE);

        return resultQueryDto;
    }

    public List<ResultQueryDto> createListResultQueryDto() {
        List<ResultQueryDto> resultQueryDtoList = new ArrayList<>();
        resultQueryDtoList.add(createResultQueryDto());
        resultQueryDtoList.add(createResultQueryDto());
        resultQueryDtoList.add(createResultQueryDto());
        resultQueryDtoList.add(createResultQueryDto());
        resultQueryDtoList.add(createResultQueryDto());
        resultQueryDtoList.add(createResultQueryDto());
        resultQueryDtoList.add(createResultQueryDto());
        resultQueryDtoList.add(createResultQueryDto());
        return resultQueryDtoList;
    }
    public NewShoe createNewShoe() {

        return  NewShoe.builder()
                .color(ShoeFilter.Color.BLACK)
                .quantity(QUANTITY)
                .size(SIZE)
                .build();
    }


    public List<NewShoe> createListNewShoe() {
        List<NewShoe> newShoeList = new ArrayList<>();

        newShoeList.add(createNewShoe());
        newShoeList.add(createNewShoe());
        newShoeList.add(createNewShoe());
        newShoeList.add(createNewShoe());
        newShoeList.add(createNewShoe());
        newShoeList.add(createNewShoe());
        newShoeList.add(createNewShoe());
        newShoeList.add(createNewShoe());

        return newShoeList;
    }


    public ShoesIn createShoesIn() {
        ShoesIn shoesIn = new ShoesIn();

        shoesIn.setColor(COLOR);
        shoesIn.setQuantity(QUANTITY);
        shoesIn.setName(NAME);
        shoesIn.setSize(SIZE);

        return shoesIn;
    }

    public List<ShoesIn> createShoesInList() {
        List<ShoesIn> shoesInList = new ArrayList<>();

        shoesInList.add(createShoesIn());
        shoesInList.add(createShoesIn());
        shoesInList.add(createShoesIn());
        shoesInList.add(createShoesIn());

        return shoesInList;

    }

}
