package com.jk.explore.boot.service;

import com.jk.explore.boot.domain.Product;
import com.jk.explore.boot.domain.excption.ResourceAlreadyExistsException;
import com.jk.explore.boot.domain.excption.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    private ReentrantReadWriteLock productsRWLock = new ReentrantReadWriteLock();

    private List<Product> products;

    public ProductService() {

    }

    @PostConstruct
    public void init() {
        try {
            productsRWLock.writeLock().lock();
            products = new ArrayList<>();
            Map<String, String> iPadSpec  = new HashMap<>();
            iPadSpec.put("price", String.valueOf(10000));
            Map<String, String> iPhoneSpec  = new HashMap<>();
            iPhoneSpec.put("price", String.valueOf(50000));
            products.add(new Product.Builder().withId("1").withName("iPad").withBrand("Apple").withDescription("Apple iPad")
                    .withSpec(iPadSpec).build());
            products.add(new Product.Builder().withId("2").withName("iPhone").withBrand("Apple").withDescription("Apple iPhone")
                    .withSpec(iPhoneSpec).build());
        } finally {
            productsRWLock.writeLock().unlock();
        }
    }

    public Product getById(String id) {
        try {
            productsRWLock.readLock().lock();
            Product results = null;
            if(products != null) {
                results = products.stream().filter(product -> {return product.getId().equals(id); }).findFirst().get();
            }
            return results;
        } finally {
            productsRWLock.readLock().unlock();
        }
    }

    public List<Product> getAll() {
        try {
            productsRWLock.readLock().lock();
            List<Product> all = new ArrayList<>(products);
            return all;
        } finally {
            productsRWLock.readLock().unlock();
        }
    }

    public void updateById(Product product) {
        try {
            productsRWLock.writeLock().lock();
            Product old = getById(product.getId());
            if (old == null) {
                return;
            }
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
        } finally {
            productsRWLock.writeLock().unlock();
        }
    }

    public void deleteById(String id) throws ResourceNotFoundException {
        try {
            productsRWLock.writeLock().lock();
            Product product = getById(id);
            if (product != null) {
                products = products.stream().filter(product1 -> !product1.getId().equals(id)).collect(Collectors.toList());
            } else {
                throw new ResourceNotFoundException("Product not found with id: " + id + " to proceed with deletion");
            }
        } finally {
            productsRWLock.writeLock().unlock();
        }

    }

    public void create(Product product) throws ResourceAlreadyExistsException {
        try {
            productsRWLock.writeLock().lock();
            if (product != null) {
                Optional<Product> duplicateProduct = products.stream().filter(product1 -> product1.getId().equals(product.getId())).findFirst();
                if(duplicateProduct.isPresent()) {
                    log.info("product with id :{} already exists in collection", product.getId());
                    throw new ResourceAlreadyExistsException("Product with id "+ product.getId()+" already present");
                } else {
                    products.add(product);
                }
            }
        } finally {
            productsRWLock.writeLock().unlock();
        }

    }

}
