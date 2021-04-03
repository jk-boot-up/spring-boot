package com.jk.examples.java.domain.streams;



import com.jk.examples.java.domain.streams.SimpleSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class SimpleSumTest {
    public SimpleSum simpleSum = new SimpleSum();

    @Test
    public void findSumOfEvenNumbers() {
        List<Integer> mixedNumbers = new ArrayList<Integer>();
        mixedNumbers.add(10);
        mixedNumbers.add(5);
        mixedNumbers.add(3);
        mixedNumbers.add(8);
        mixedNumbers.add(1);
        Integer sum = simpleSum.findSumOfEvenNumbers(mixedNumbers);
        Assertions.assertEquals(18, sum);
    }
}
