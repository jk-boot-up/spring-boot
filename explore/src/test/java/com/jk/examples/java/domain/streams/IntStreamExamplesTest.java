package com.jk.examples.java.domain.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Configuration
@ComponentScan(basePackageClasses = IntStreamExamplesTestContext.class)
class IntStreamExamplesTestContext {
    // place holder context
}

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = IntStreamExamplesTestContext.class)
public class IntStreamExamplesTest {

    @Autowired
    private IntStreamExamples intStreamExamples;

    @Test
    public void streamCreation() {
        IntStream is = intStreamExamples.getStream(1, 2, 3);
        assertEquals(6, is.sum());
        // stream from Stream.of from sequence of values
        assertEquals(6, Stream.of(1, 2, 3).mapToInt(i -> i).sum());
        assertEquals(6, IntStream.of(1, 2, 3).sum());
        // stream from builder
        assertEquals(6, Stream.builder().add(1).add(2).add(3).build().mapToInt(i -> (int) i).sum());
        //  stream from collection
        assertEquals(6, Arrays.asList(1, 2, 3).stream().mapToInt(i -> (int) i).sum());
        // stream from array
        int[] ints =  { 1, 2, 3 };
        assertEquals(6, Arrays.stream(ints).sum());
        // empty stream
        assertEquals(0, Stream.empty().mapToInt(i -> (int) i).sum());
        // infinite stream from Stream.iterate
        assertEquals(6, Stream.iterate(1, i -> i+1).limit(3).mapToInt(i -> (int)i).sum());
        // infinite stream from Stream.generate
        assertEquals(3, Stream.generate(() -> {return (int) Math.random();}).limit(3).mapToInt(i -> (int) i + 2).count());
        // from spliterator
        assertEquals(6, StreamSupport.stream(Arrays.asList(1, 2, 3).spliterator(), false).mapToInt(i -> (int) i).sum());
        // from iterable
        Iterable<Integer> iterable = Arrays.asList(1, 2, 3);
        assertEquals(6, StreamSupport.stream(iterable.spliterator(), false).mapToInt(i -> (int) i ).sum());
    }



}
