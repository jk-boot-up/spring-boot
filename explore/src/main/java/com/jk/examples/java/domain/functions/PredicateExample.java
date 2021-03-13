package com.jk.examples.java.domain.functions;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Slf4j
@Getter
@Setter
public class PredicateExample {

    private Predicate<Integer> evenIntPredicate;

    private Predicate<Integer> oddIntPredicate;

    private Predicate<Integer> evenIntPredicateAndNegative;

    public PredicateExample() {
        evenIntPredicate = integer -> {
            if(integer % 2 == 0) {
                return true;
            } else {
                return false;
            }
        };
        oddIntPredicate = evenIntPredicate.negate();
        evenIntPredicateAndNegative = evenIntPredicate.and(
                integer -> {
                    if(integer < 0) {
                        return true;
                    }
                    return false;
                }
        );
    }

}
