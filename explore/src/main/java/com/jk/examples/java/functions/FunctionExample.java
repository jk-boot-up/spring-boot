package com.jk.examples.java.functions;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

@Component
@Getter @Setter @Slf4j
public class FunctionExample {

    private final Function<Integer, Integer> squareFunction;
    private Function<Integer, Integer> composedEvenSquareFunction;
    private Function<Integer, Integer> SquareAndThenCubeFunction;
    private Function<Integer, Integer> composedEvenSquareAndThenCubeFunction;
    private AtomicInteger functionCallCount = new AtomicInteger();

    public FunctionExample() {
        squareFunction = integer -> {
            log.info("square function execution started");
            functionCallCount.getAndIncrement();
            return integer * integer;
        };
        composedEvenSquareFunction = squareFunction.compose(integer -> {
             if (integer % 2 == 0) {
                 return integer;
             }
             return 0;
        });
        SquareAndThenCubeFunction = squareFunction.andThen(integer ->
                integer * integer * integer);
        composedEvenSquareAndThenCubeFunction = composedEvenSquareFunction.andThen(integer ->
                integer * integer * integer);
    }

}
