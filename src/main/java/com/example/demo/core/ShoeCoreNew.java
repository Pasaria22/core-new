package com.example.demo.core;

import com.example.demo.core.service.ShoeService;
import com.example.demo.dto.in.ShoeFilter;
import com.example.demo.dto.in.ShoeFilter.Color;
import com.example.demo.dto.in.ShoesIn;
import com.example.demo.dto.out.Shoe;
import com.example.demo.dto.out.Shoes;
import com.example.demo.dto.out.v2.NewShoe;
import com.example.demo.dto.out.v2.Stock;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Implementation(version = 2)
public class ShoeCoreNew extends AbstractShoeCore {


    private final ShoeService shoeService;

    public ShoeCoreNew(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    @Override
    public Shoes search(final ShoeFilter filter) {
        return Shoes.builder()
                .shoes(List.of(Shoe.builder()
                        .name("New shoe")
                        .color(filter.getColor().orElse(Color.BLACK))
                        .size(filter.getSize().orElse(BigInteger.TWO))
                        .build()))
                .build();
    }

    @Override
    public Stock findAllStock() {
        List<NewShoe> allStock = shoeService.findAllStock();
        Long size = allStock.stream().collect(Collectors.summingLong(NewShoe::getQuantity));
        return Stock.builder()
                .state(shoeService.findState(size))
                .shoes(allStock).build();
    }

    @Override
    public ShoesIn patchStock(ShoesIn shoesIn) {
        return shoeService.patchStock(shoesIn);
    }
}
