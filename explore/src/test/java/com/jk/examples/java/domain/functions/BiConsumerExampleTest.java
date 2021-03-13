package com.jk.examples.java.domain.functions;

import com.jk.examples.java.domain.functions.BiConsumerExample;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Configuration
@ComponentScan(basePackageClasses = BiConsumerExample.class)
class BiConsumerExampleContext {
    // context class for test
}

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BiConsumerExampleContext.class)
public class BiConsumerExampleTest {

    @Autowired
    private BiConsumerExample biConsumerExample;

    @Test
    public void updatePersonSalary() {
        Assertions.assertNotNull(biConsumerExample.getPersonSalary());
        Assertions.assertNotNull(biConsumerExample.getPersonSalaryMap());
        Assertions.assertEquals(0, biConsumerExample.getPersonSalaryMap().size());
        biConsumerExample.getPersonSalary().accept("PersonX", 1000);
        biConsumerExample.getPersonSalary().accept("PersonY", 2000);
        biConsumerExample.getPersonSalary().accept("PersonZ", 3000);
        System.out.println(biConsumerExample.getPersonSalaryMap());
        Assertions.assertNotNull(biConsumerExample.getPersonSalaryMap());
        Assertions.assertEquals(3, biConsumerExample.getPersonSalaryMap().size());
    }
}
