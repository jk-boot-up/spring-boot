package com.jk.examples.java.streams.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamedNumbers {

    private List<Integer> numbers = null;

    // Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

    public StreamedNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public final List<Integer> getNumbers(int j) {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer getSumOfSquares() {
        List<Integer> squares = getNumbers().stream().map(i -> i*i).collect(Collectors.toList());
        return squares.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        StreamedNumbers numbers = new StreamedNumbers(Arrays.asList(1,2,3,4,5,6));
        System.out.println(numbers.getSumOfSquares());
    }
}
