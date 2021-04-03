package com.jk.explore.boot.business;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Product {

    private String id;
    private String name;
    private String description;
    private String brand;

    public Product() {
    }

    public Product(String id, String name, String description, String brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
    }
}
