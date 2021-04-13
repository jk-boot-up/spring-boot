package com.jk.explore.boot.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Slf4j
public class Product {

    private String id;
    private String name;
    private String description;
    private String brand;
    private Map<String, String> spec;

    public static class Builder {
        private String id;
        private String name;
        private String description;
        private String brand;
        private Map<String, String> spec = new HashMap<>();

        public Builder() {

        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder withSpec(Map<String, String> spec) {
            this.spec = spec;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.id = this.id;
            product.name = this.name;
            product.description = this.description;
            product.brand = this.brand;
            product.spec = this.spec;
            return product;
        }

    }
}
