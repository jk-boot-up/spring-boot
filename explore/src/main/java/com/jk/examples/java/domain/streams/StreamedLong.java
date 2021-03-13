package com.jk.examples.java.domain.streams;

import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

public class StreamedLong {

    private List<Long> numbers; // = Arrays.asList(1L, 2L, 3L, 4L);

    public StreamedLong(List<Long> numbers) {
        this.numbers = numbers;
    }

    public List<Long> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Long> numbers) {
        this.numbers = numbers;
    }

    public Long findSumOfOddNummbers() {
        return getNumbers().stream().filter(aLong -> aLong % 2 != 0).mapToLong(value -> value.longValue()).sum();
    }

    public static void main(String [] args) {
        StreamedLong streamedLong = new StreamedLong(Arrays.asList(1L, 2L, 3L, 4L));
        System.out.println(streamedLong.findSumOfOddNummbers());
        Assert.isTrue(streamedLong.findSumOfOddNummbers() == 4, "Asserted getSumOfOddNummbers()");
    }
}
