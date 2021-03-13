package com.jk.examples.java.domain.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.function.Consumer;

@Configuration
@ComponentScan(basePackageClasses = ConsumerExample.class)
class ConsumerExampleTestContext {
    // test context for bean creation
}

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ConsumerExampleTestContext.class)
public class ConsumerExampleTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ConsumerExample consumerExample;

    @Test
    public void consumerCreated() {
        Assertions.assertNotNull(consumerExample);
    }

    @Test
    public void consumeTwice() {
        consumerExample.getStringConsumer().andThen(consumerExample.getStringConsumer()).accept("ABCD");
    }

    @Test
    public void consumeOnce() {
        consumerExample.getStringConsumer().accept("ABCD");
    }

    @Test
    public void consumeThrice() {
        Consumer<String> chainedConsumer = consumerExample.getStringConsumer().andThen(consumerExample.getStringConsumer()).andThen(consumerExample.getStringConsumer());
        chainedConsumer.accept("ABCD");
    }
}
