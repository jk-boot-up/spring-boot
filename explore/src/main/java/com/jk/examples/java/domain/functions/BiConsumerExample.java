package com.jk.examples.java.domain.functions;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@Component
@Getter @Setter @Slf4j
public class BiConsumerExample {

    private final BiConsumer<String, Integer> personSalary;

    private final Map<String, Integer> personSalaryMap;

    public BiConsumerExample() {
        personSalaryMap = new HashMap<>();
        personSalary = (String name, Integer salary) -> {
            log.info(String.format("Salary of %s is %d", name, salary));
            getPersonSalaryMap().put(name, salary);
        };
    }

}
