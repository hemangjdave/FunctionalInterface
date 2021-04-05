package com.techrevolution.functionalinterface.ch11.shortproblem.third;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class SingleChainOfOptional {
    public static void main(String[] args) {
        new SingleChainOfOptional().run();
    }

    private void run() {
        String string = "Optionals are optional";

        Stream<String> stringStream = Stream.of(string.split(" "))
                .filter(s -> s.equalsIgnoreCase("optional"))
                .map(s -> "mandatory")
                .map(s -> string.replace("optional", s));

        String s = stringStream.findFirst().get();
        log.info(s);
    }
}
