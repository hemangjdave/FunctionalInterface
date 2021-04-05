package com.techrevolution.functionalinterface.ch10.shortproblem.third;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;

@Slf4j
public class SortedListOfA {
    public static void main(String[] args) {
        ArrayList<A> aList = new ArrayList<>();

        aList.add(new A("Sally","Jones" , 3));
        aList.add(new A("Sally","Seashell" , 4));
        aList.add(new A("Harry","Jones" , 1));
        aList.add(new A("Harry","Homeowner" ,  5));
        aList.add(new A("Harry","Homeowner" ,  2));

        ArrayList<A> finalList = (ArrayList<A>) aList.clone();

        log.info("------FIRST COMPARE BY FIELD S1--------------");
        Comparator<A> comparator = Comparator.comparing(A::getS1);
        aList.sort(comparator);
        aList.forEach(a -> log.info(String.valueOf(a)));

        //A{s1='Harry', s2='Jones', i=1}
        //A{s1='Harry', s2='Homeowner', i=5}
        //A{s1='Harry', s2='Homeowner', i=2}
        //A{s1='Sally', s2='Jones', i=3}
        //A{s1='Sally', s2='Seashell', i=4}

        log.info("------SECOND COMPARATOR WITH REVERSED ORDER OF FIELD s2------------");
        Comparator<A> secondComparator = Comparator.comparing(A::getS2).reversed();
        aList.sort(secondComparator);
        aList.forEach(a -> log.info(String.valueOf(a)));

        //A{s1='Sally', s2='Seashell', i=4}
        //A{s1='Harry', s2='Jones', i=1}
        //A{s1='Sally', s2='Jones', i=3}
        //A{s1='Harry', s2='Homeowner', i=5}
        //A{s1='Harry', s2='Homeowner', i=2}

        log.info("---------NATURAL ORDERING BY FIELD I2-------------------");
        Comparator<A> thirdComparator = Comparator.comparing(A::getI);
        aList.sort(thirdComparator);
        aList.forEach(a -> log.info(String.valueOf(a)));

        log.info("----------------------FINAL OPERATOR OF COMBINATION OF ALL ABOVE----------------");
        Comparator<A> finalComparator = thirdComparator.thenComparing(secondComparator).thenComparing(comparator);
        finalList.sort(finalComparator);
        finalList.forEach(a -> log.info(String.valueOf(a)));

        //A{s1='Harry', s2='Jones', i=1}
        //A{s1='Harry', s2='Homeowner', i=2}
        //A{s1='Sally', s2='Jones', i=3}
        //A{s1='Sally', s2='Seashell', i=4}
        //A{s1='Harry', s2='Homeowner', i=5}
    }
}
