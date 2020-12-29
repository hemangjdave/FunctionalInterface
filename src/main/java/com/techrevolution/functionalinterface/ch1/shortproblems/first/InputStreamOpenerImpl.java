package com.techrevolution.functionalinterface.ch1.shortproblems.first;

import java.io.*;

public class InputStreamOpenerImpl {

    private static InputStream getInputStream(String fileName) throws FileNotFoundException {
        return new FileInputStream(fileName);
    }

    public static void main(String[] args) {

        InputStreamOpener inputStreamOpener
                = (str -> new DataInputStream(getInputStream(str)));

        InputStreamOpener objInputStreamOpener
                = (str -> new ObjectInputStream(getInputStream(str)));

        InputStreamOpener bufferedInputStreamInputStreamOpener
                = (str -> new BufferedInputStream(getInputStream(str)));
    }
}
