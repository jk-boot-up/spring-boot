package com.jk.explore.boot;


import com.jk.explore.boot.business.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @RequestMapping("/products")
    public List<Product> allProducts() {
        return Arrays.asList(new Product("124AKSDJFDS123456", "iPad", "Apple iPad", "Apple"));
    }
}
