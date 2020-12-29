package com.techrevolution.functionalinterface.ch1.shortproblems.first;

import java.io.IOException;
import java.io.InputStream;

@FunctionalInterface
public interface InputStreamOpener {
    InputStream open(String str) throws IOException;
}
