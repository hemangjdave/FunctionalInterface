package com.techrevolution.functionalinterface.ch6.longproblems;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class EntertainmentConsumers {
    public static void main(String[] args) {
        EntertainmentSystem entertainmentSystem = new EntertainmentSystem(
                List.of(
                        new Dvd("Ae dil hai muskil", "SomeCompany", 1),
                        new Dvd("Hasta rahe tu", "TechRevolution", 1)
                ),
                List.of(
                        new AudioFiles("Rehna hai tere dil mai", "mp3", 1),
                        new AudioFiles("Hum sath sath hai", "mp3", 1)
                ),
                List.of(
                        new EBooks("JavaConcurrency", 450, 1),
                        new EBooks("Effective Java", 500, 2)
                )
        );
        List<String> titleList = new ArrayList<>();
        Consumer<EntertainmentSystem> consumer = entertainmentSystem1 -> {
            entertainmentSystem1.getDvdList().forEach(dvd -> titleList.add(dvd.getTitle()));
            entertainmentSystem1.getEBooksList().forEach(eBooks -> titleList.add(eBooks.getTitle()));
            entertainmentSystem1.getAudioFilesList().forEach(audioFiles -> titleList.add(audioFiles.getTitle()));
        };
        consumer.accept(entertainmentSystem);
        log.info("Titles of all the items in entertainment system are:--");
        log.info(String.valueOf(titleList));
    }
}
