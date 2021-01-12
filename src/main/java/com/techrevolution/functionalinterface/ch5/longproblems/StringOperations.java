package com.techrevolution.functionalinterface.ch5.longproblems;

import lombok.extern.slf4j.Slf4j;

import java.util.function.UnaryOperator;

@Slf4j
public class StringOperations {
    public static void main(String[] args) {
        String string = "The fault lies not from our stars";
        UnaryOperator<String> firstOperator = s -> s.concat(" but from ourselves");
        UnaryOperator<String> secondOperator = s -> s.replace("from", "in");
        UnaryOperator<String> thirdOperator = String::toUpperCase;
        log.info(firstOperator.apply(string));
        log.info(secondOperator.apply(string));
        log.info(thirdOperator.apply(string));
    }
}
