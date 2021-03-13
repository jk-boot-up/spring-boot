package com.jk.examples.java.domain.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Configuration
@ComponentScan(basePackageClasses = FunctionExample.class)
class FunctionExampleTestContext {
    // test context
}

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = FunctionExampleTestContext.class)
public class FunctionExampleTest {

    @Autowired
    private FunctionExample functionExample;

    @Test
    public void apply() {
        Assertions.assertNotNull(functionExample);
        functionExample.getFunctionCallCount().getAndSet(0);
        assertEquals(25, functionExample.getSquareFunction().apply(5));
        assertEquals(100, functionExample.getSquareFunction().apply(10));
        assertEquals(400, functionExample.getSquareFunction().apply(20));
        assertEquals(3, functionExample.getFunctionCallCount().get());
    }

    @Test
    public void compose() {
        functionExample.getFunctionCallCount().getAndSet(0);
        assertEquals(4, functionExample.getComposedEvenSquareFunction().apply(2));
        assertEquals(0, functionExample.getComposedEvenSquareFunction().apply(3));
        assertEquals(2, functionExample.getFunctionCallCount().get());
    }

    @Test
    public void andThen() {
        functionExample.getFunctionCallCount().getAndSet(0);
        assertEquals(64, functionExample.getSquareAndThenCubeFunction().apply(2));
        assertEquals(1, functionExample.getFunctionCallCount().get());
    }

    @Test
    public void composeAndThen() {
        functionExample.getFunctionCallCount().getAndSet(0);
        assertEquals(64, functionExample.getComposedEvenSquareAndThenCubeFunction().apply(2));
        assertEquals(0, functionExample.getComposedEvenSquareAndThenCubeFunction().apply(3));
        assertEquals(2, functionExample.getFunctionCallCount().get());
    }


}
