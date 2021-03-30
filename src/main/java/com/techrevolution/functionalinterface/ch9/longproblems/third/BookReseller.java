package com.techrevolution.functionalinterface.ch9.longproblems.third;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class BookReseller {
    public static void main(String[] args) {
        Map<String, Book> bookMap = new HashMap<>();
        bookMap.put("Moby-Dick", new Book("Herman Melville", 19.99f, 25));
        bookMap.put("The Zen of java programming", new Book("Java J. guru", 15.99f, 5));
        bookMap.put("Frakenstein", new Book("Merry Shelley", 12.99f, 10));

        log.info("----------BEFORE PERFORMING ANY OPERATION--------------------");
        printBook(bookMap);

        bookMap.compute("Frakenstein", (key, value) -> null);
        log.info("----------AFTER REMOVING Fankenstein from map----------------------");
        printBook(bookMap);

        bookMap.computeIfAbsent(
                "Dracula",
                string -> new Book("Bram Stoker", 14.99f, 13)
        );
        log.info("-------AFTER ADDING DRACULA to the map----------------------");
        printBook(bookMap);

        bookMap.merge(
                "The Zen of java programming",
                new Book(null, 13.99f, 0),
                (oldbook, newbook)
                        -> new Book(oldbook.getBookName(), newbook.getPrice() , oldbook.getCopyAvailable())
        );
        log.info("------------------AFTER CHANGING THE PRICE of THE ZEN OF PROGRAMMING from 15.99$ to 13.99$--------");
        printBook(bookMap);

        bookMap.merge(
                "Moby-Dick",
                new Book(null, 0, 24),
                (oldbook, newbook)
                        -> new Book(oldbook.getBookName(), oldbook.getPrice(), newbook.getCopyAvailable())
        );
        log.info("---------------AFTER CHANGING THE Moby-Dick copies from 25 to 24-------------------");
        printBook(bookMap);
    }

    private static void printBook(Map<String, Book> map) {
        map.forEach((key , value) -> log.info(key + " :-- " + value));
    }
}
