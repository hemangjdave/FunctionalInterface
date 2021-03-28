package com.techrevolution.functionalinterface.ch7.longproblems.second;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Slf4j
public class SpeechDetactor2 {

    private static final Map<String, List<String>> listMap = new HashMap<>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        SpeechDetactor2 detactor2 = new SpeechDetactor2();
        listMap.put("Articles", detactor2.getArticles());
        listMap.put("Propositions", detactor2.getPrepositions());
        listMap.put("Verbs", detactor2.getVerbs());
        String userSentence = detactor2.getUserSentence();
        // a programmer below compiled a program
        String[] strings = userSentence.split(" ");
        Stream.of(strings).forEach(detactor2::findWordType);
        long endTime = System.nanoTime();
        log.info("starttime is:--{}" , startTime);
        log.info("endtime is:--{}" , endTime);
        long totalTimetaken = (endTime - startTime)/1000000;
        log.info("total time taken:--{}" , totalTimetaken);
    }

    private void findWordType(String word) {

        Optional<Map.Entry<String, List<String>>> first
                = listMap.entrySet()
                .stream()
                .filter(stringListEntry -> stringListEntry.getValue().contains(word.toLowerCase()))
                .findFirst();

        if (first.isPresent()) {
            log.info(word + " is " + first.get().getKey().toUpperCase());
        } else {
            log.info(word + " is NOUN");
        }
    }

    private String getUserSentence() {
        Supplier<String> stringSupplier = () -> {
            try (Scanner scanner = new Scanner(System.in)) {
                log.info("Enter your sentence:--");
                return scanner.nextLine();
            }
        };

        return stringSupplier.get();
    }

    private List<String> getArticles() {
        return List.of("a", "an", "the");
    }

    private List<String> getPrepositions() {
        return List.of("of", "in", "on", "beside", "under", "above", "below");
    }

    private List<String> getVerbs() {
        return List.of("is", "was", "compiled");
    }
}
