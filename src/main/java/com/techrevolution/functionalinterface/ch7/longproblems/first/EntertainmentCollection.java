package com.techrevolution.functionalinterface.ch7.longproblems.first;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

@Slf4j
public class EntertainmentCollection {

    private final List<FileFormat> fileFormats = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        EntertainmentCollection entertainmentCollection = new EntertainmentCollection();
        entertainmentCollection.run();
        entertainmentCollection.printCollectedObjects();
    }

    private void printCollectedObjects() {
        fileFormats.forEach(fileFormat -> log.info("Constructed Objects are:--{}", fileFormat));
    }

    private void run() throws FileNotFoundException {
        File file = new File("src/main/resources/entertainment.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String formatName = scanner.nextLine();
                log.info(formatName);
                processEntertainmentFile(formatName);
            }
        }
    }

    private void processEntertainmentFile(String dataInfo) {
        String[] strings = dataInfo.split(",");
        String formatName = strings[0];
        if (formatName.equals(DataFormat.DVD.toString())) {
            fileFormats.add(dvdSupplier(strings[1], strings[2], getIntFromString(3, strings)).get());
        } else if (formatName.equals(DataFormat.AUD.toString())) {
            fileFormats.add(audioFilesSupplier(strings[1], strings[2], getIntFromString(3, strings)).get());
        } else {
            fileFormats.add(eBooksSupplier(strings[1], getIntFromString(2, strings), getIntFromString(3, strings)).get());
        }
    }

    private int getIntFromString(int i, String[] strings) {
        return Integer.parseInt(strings[i]);
    }

    private Supplier<EBooks> eBooksSupplier(String title, int numofpages, int memorysize) {
        return () -> EBooks.builder()
                .title(title)
                .numOfPages(numofpages)
                .memorySize(memorysize)
                .build();
    }

    private Supplier<AudioFiles> audioFilesSupplier(String title, String format, int memorysize) {
        return () -> AudioFiles.builder()
                .title(title)
                .format(format)
                .memorySize(memorysize)
                .build();
    }

    private Supplier<Dvd> dvdSupplier(String title, String companyName, int memorySize) {
        return () -> Dvd.builder()
                .companyName(companyName)
                .title(title)
                .memorySize(memorySize)
                .build();
    }
}
