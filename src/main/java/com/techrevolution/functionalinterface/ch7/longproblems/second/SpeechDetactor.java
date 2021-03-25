package com.techrevolution.functionalinterface.ch7.longproblems.second;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Slf4j
public class SpeechDetactor {

    private List<Wordings> wordings = new ArrayList<>();

    public static void main(String[] args) {
        SpeechDetactor detactor = new SpeechDetactor();
        detactor.run();
        String userSentence = detactor.getUserSentence();
        Stream.of(userSentence.split(" ")).forEach(detactor::determineWordPart);
    }

    private void determineWordPart(String word) {
        for (Wordings wording : wordings) {
            List<String> wordList = wording.getWordList();
            if (wordList.contains(word.toLowerCase())) {
                log.info(word + ":" + wording.getWordName().toUpperCase());
                return;
            }
        }
        log.info(word + ": NOUN");
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

    private void run() {
        wordings.add(Wordings.builder().wordName("Articles").wordList(getArticles()).build());
        wordings.add(Wordings.builder().wordName("Preposition").wordList(getPrepositions()).build());
        wordings.add(Wordings.builder().wordName("Verb").wordList(getVerbs()).build());
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
