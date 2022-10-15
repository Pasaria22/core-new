package com.example.demo.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "SHOE")
@Getter
@Setter
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "COLOR", nullable = false)
    private int color;

    @Column(name = "SIZE")
    private int size;

    @Column(name = "QUANTITY")
    private int quantity;

    public Shoe() {
    }

    public Shoe(Long id, int color, int size, int quantity) {
        this.id = id;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }


}
