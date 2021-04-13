package com.jk.explore.boot.controller;


import com.jk.explore.boot.domain.Product;
import com.jk.explore.boot.service.ProductService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Getter
@Slf4j
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public List<Product> all() {
        return getProductService().getAll();
    }

    @RequestMapping("/products/{id}")
    public Product byId(@PathVariable String id) {
        return getProductService().getById(id);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        getProductService().deleteById(id);
    }
}
