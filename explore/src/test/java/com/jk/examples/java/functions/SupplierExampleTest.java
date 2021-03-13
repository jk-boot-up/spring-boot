package com.jk.examples.java.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Configuration
@ComponentScan(basePackageClasses = SupplierExample.class)
class SupplierExampleTestContext {
    // context for test class
}

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SupplierExampleTestContext.class)
public class SupplierExampleTest {

    private SupplierExample supplierExample;

    @BeforeEach
    public void setUp() {
        supplierExample = new SupplierExample();
    }

    @Test
    public void getRandomInteger() {
        Integer randomInt = supplierExample.getRandomIntegerSupplier().get();
        Assertions.assertNotNull(randomInt);
    }


}
