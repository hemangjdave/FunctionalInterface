package com.techrevolution.functionalinterface.ch11.shortproblem.third;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
public class SingleChainOfOptional {

    public static final String OPTIONAL = "optional";

    public static void main(String[] args) {
        new SingleChainOfOptional().run();
    }

    private void run() {
        String string = "Optionals are optional";

        Optional.of(string)
                .map(s -> string.replace(OPTIONAL, "mandatory"))
                .filter(s -> s.toCharArray().length > 20)
                .ifPresent(log::info);

        Optional.of(string)
                .stream()
                .filter(s -> s.contains(OPTIONAL))
                .forEach(log::info);

        Stream<String> stringStream = Stream.of(string.split(" "))
                .filter(s -> s.equalsIgnoreCase(OPTIONAL))
                .map(s -> "mandatory")
                .map(s -> string.replace(OPTIONAL, s));

        String s = stringStream.findFirst().orElse(null);
        log.info(s);
    }
}
