package com.jk.examples.java.domain.streams;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleSum {

    public int findSumOfEvenNumbers(List<Integer> mixedNumbersList) {
        return mixedNumbersList.stream().filter(i -> i%2==0).mapToInt(i -> i).sum();
    }
}
