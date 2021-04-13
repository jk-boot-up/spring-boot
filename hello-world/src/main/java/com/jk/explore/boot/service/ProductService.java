package com.jk.explore.boot.service;

import com.jk.explore.boot.domain.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ReentrantReadWriteLock productsRWLock = new ReentrantReadWriteLock();

    private List<Product> products;

    public ProductService() {

    }

    @PostConstruct
    public void init() {
        productsRWLock.writeLock().lock();
        products = new ArrayList<>();
        products.add(new Product.Builder().withId("1").withName("iPad").withBrand("Apple").withDescription("Apple iPad")
                .withSpec((Map<String, Object>) new HashMap<>().put("price", Integer.valueOf(10000))).build());
        products.add(new Product.Builder().withId("2").withName("iPhone").withBrand("Apple").withDescription("Apple iPhone")
                .withSpec((Map<String, Object>) new HashMap<>().put("price", Integer.valueOf(70000))).build());
        productsRWLock.writeLock().unlock();

    }

    public Product getById(String id) {
        Product results = null;
        productsRWLock.readLock().lock();
        if(products != null) {
             results = products.stream().filter(product -> {return product.getId().equals(id); }).findFirst().get();
        }
        productsRWLock.readLock().unlock();
        return results;
    }

    public List<Product> getAll() {
        productsRWLock.readLock().lock();
        List<Product> all = new ArrayList<>(products);
        productsRWLock.readLock().unlock();
        return all;
    }

    public void updateById(Product product) {
        Product old = getById(product.getId());
        if (old == null) {
            return;
        }
        productsRWLock.writeLock().lock();
        if(product.getName() != null) {
            old.setName(product.getName());
        }
        if(product.getBrand() != null) {
            old.setBrand(product.getBrand());
        }
        if(product.getDescription() != null) {
            old.setDescription(product.getDescription());
        }
        if(product.getSpec() != null) {
            product.getSpec().entrySet().stream().forEach(
                    entry -> old.getSpec().put(entry.getKey(), entry.getValue())
            );
        }
        productsRWLock.writeLock().unlock();
    }

    public void deleteById(String id) {
        Product product = getById(id);
        if (product != null) {
            productsRWLock.writeLock().lock();
            products = products.stream().filter(product1 -> !product1.getId().equals(id)).collect(Collectors.toList());
            productsRWLock.writeLock().unlock();
        }
    }

}
