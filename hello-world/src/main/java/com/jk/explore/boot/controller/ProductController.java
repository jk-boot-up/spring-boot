package com.jk.explore.boot.controller;


import com.jk.explore.boot.AlreadyExistsException;
import com.jk.explore.boot.domain.Product;
import com.jk.explore.boot.service.ProductService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Product product) {
        try {
            getProductService().create(product);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (AlreadyExistsException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }
}
