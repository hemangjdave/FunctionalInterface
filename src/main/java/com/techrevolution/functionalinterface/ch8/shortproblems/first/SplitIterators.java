package com.techrevolution.functionalinterface.ch8.shortproblems.first;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Spliterator;

@Slf4j
public class SplitIterators {
    public static void main(String[] args) {
        List<String> strings = List.of("Hemang", "Dave", "Krutarth", "Dave", "Sanjay");
        Spliterator<String> spliterator = strings.spliterator();
//        spliterator.forEachRemaining(s -> log.info("In List<String> :--" + s));


        Spliterator<String> firstHalf = spliterator.trySplit();
        firstHalf.forEachRemaining(s -> log.info("In FirstHalf :--" + s));
        spliterator.forEachRemaining(s -> log.info("In SecondHalf :--" + s));

    }
}
