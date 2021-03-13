package com.jk.examples.java.domain.functions;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Getter
@Setter
@Slf4j
public class ConsumerExample {

    private Consumer<String> stringConsumer;

    public ConsumerExample() {
        stringConsumer = (inputName) -> {
            System.out.println("Hello " + inputName);
        };
        stringConsumer.andThen(stringConsumer);
    }

}
