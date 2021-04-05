package com.techrevolution.functionalinterface.ch11.shortproblem.first;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;

@Slf4j
public class NullOptionalWithSupplier {
    public static void main(String[] args) {
        new NullOptionalWithSupplier().run();
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
        while (true) {
            Optional<Integer> integerOptional = supplier.get();
            if (integerOptional.isEmpty()) {
                break;
            } else {
                log.info(String.valueOf(integerOptional.get()));
            }
        }
    }
}
