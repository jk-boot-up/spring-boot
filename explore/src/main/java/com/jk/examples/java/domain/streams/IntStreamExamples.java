package com.jk.examples.java.domain.streams;

import com.google.common.primitives.Ints;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.PrimitiveIterator;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

@Component
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class IntStreamExamples {

    public IntStream getStream(int ... values) {
        IntStream intStream = IntStream.of(values);
        log.info("Created stream for given int values");
        return intStream;
    }

    public IntStream range(int startInc, int endExc) {
        IntStream intStream = IntStream.range(startInc, endExc);
        log.info("Created stream for given int range");
        return intStream;
    }

    public PrimitiveIterator.OfInt iterator(int startInc, int endExc) {
        IntStream intStream = IntStream.range(startInc, endExc);
        PrimitiveIterator.OfInt iterator = intStream.iterator();
        log.info("Created iterator for given int range");
        return iterator;
    }

    public IntStream iterate(int seed, IntUnaryOperator integerUnaryOperator) {
        log.info("Created infinite stream for given seed and unary operator");
        return IntStream.iterate(seed, integerUnaryOperator);
    }

    public IntStream limitedFilterWithSeedAndPredicate(IntPredicate intPredicate, long limit, int seed) {
        return IntStream.iterate(seed, (i) -> i).limit(limit).filter(intPredicate);
    }

    public void forEach(IntStream intStream) {
        intStream.forEach(System.out::println);
    }



}
