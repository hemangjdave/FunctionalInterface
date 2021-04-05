package com.techrevolution.functionalinterface.ch10.shortproblem.second;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;

@Slf4j
public class FinalComparator {
    public static void main(String[] args) {

        A o1 = new A("Hemang", "Dave", 28);
        A o2 = new A("Helu", "Dave", 28);

        log.info("First Comparator with natural order....");
        Comparator<A> comparator = Comparator.comparing(A::getS1);
        log.info("" +comparator.compare(o1, o2));

        log.info("Second comparator with reverse ordering");
        comparator = Comparator.comparing(A::getS1).reversed();
        log.info("" +comparator.compare(o1, o2));

        log.info("Third comparator with reverse ordering of field s2");
        comparator = Comparator.comparing(A::getS2);
        log.info("" +comparator.compare(o1, o2));

        log.info("Fourth comparator with natural ordering of field i");
        comparator = Comparator.comparing(A::getI);
        log.info("" +comparator.compare(o1, o2));
    }
}
