package com.techrevolution.functionalinterface.ch11.shortproblem.second;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;

@Slf4j
public class OptionalWithException {
    public static void main(String[] args) {
        new OptionalWithException().run();
    }

    private void run(){
        Supplier<Optional<Integer>> supplier = () -> {
            Scanner scanner = new Scanner(System.in);
            log.info("Please enter number between 1 to 5 or Q to quit...");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                return Optional.empty();
            } else {
                return Optional.of(Integer.parseInt(input));
            }
        };
        int a = 0;
        while (true) {
            Optional<Integer> integerOptional = supplier.get();
            Integer integer = integerOptional.orElseThrow(() -> new RuntimeException("User has quit the program..."));
            log.info(String.valueOf(integer));
        }
    }
}
