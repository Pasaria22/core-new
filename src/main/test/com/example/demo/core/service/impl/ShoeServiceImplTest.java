package com.example.demo.core.service.impl;



import com.example.demo.core.repository.ShoeRepository;
import com.example.demo.dto.in.ShoesIn;
import com.example.demo.dto.out.v2.NewShoe;
import com.example.demo.dto.out.v2.ResultQueryDto;
import com.example.demo.entity.ShoeEntity;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ShoeServiceImplTest {

    private static final int SIZE = 8;

    @Mock
    ShoeRepository shoeRepository;

    @InjectMocks
    ShoeServiceImpl shoeService;




    @Test
    public void findAllStock() {
        MockitoAnnotations.openMocks(this);
        UtilsTests utilsTests = new UtilsTests();
        List<NewShoe> listNewShoe = utilsTests.createListNewShoe();
        List<ResultQueryDto> listResultQueryDto = utilsTests.createListResultQueryDto();
        when(shoeRepository.countAllShoesGroupByColorAndSize()).thenReturn(listResultQueryDto);


        List<NewShoe> response = shoeService.findAllStock();

        assertEquals(SIZE, response.size());
        assertEquals(listNewShoe.get(1).getQuantity(), response.get(1).getQuantity());


    }

    @Test
    public void patchStockWithJustOneShoesIn() {
        MockitoAnnotations.openMocks(this);
        UtilsTests utilsTests = new UtilsTests();
        ShoesIn shoesIn = utilsTests.createShoesIn();

        ShoeEntity shoe = new ShoeEntity(shoesIn.getName(), shoesIn.getSize(), shoesIn.getColor());

        when(shoeRepository.save(shoe)).thenReturn(shoe);
        shoeService.patchStock(shoesIn);

        assertNotNull(shoe);

    }
    
}
