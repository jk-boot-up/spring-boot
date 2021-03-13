package com.jk.examples.java.domain.functions;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.function.Supplier;

@Component
@Getter @Setter @Slf4j
public class SupplierExample {

    private final Supplier<Integer> randomIntegerSupplier;

    private final Random random;

    public SupplierExample() {
        this.random = new Random();
        this.randomIntegerSupplier = () -> {
//            Random random = new Random();
//            return random.nextInt();
//            Math.random().
//            Assert that lambda function can access class variables
            log.info("Started lambda execution");
            return getRandom().nextInt();
        };
    }

}
