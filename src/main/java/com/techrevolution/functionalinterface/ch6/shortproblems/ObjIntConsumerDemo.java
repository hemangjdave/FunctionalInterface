package com.techrevolution.functionalinterface.ch6.shortproblems;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.function.ObjIntConsumer;

@Slf4j
public class ObjIntConsumerDemo {
    public static void main(String[] args) {
        String[] strings = new String[3];
        ObjIntConsumer<String> objIntConsumer
                = ((s, value) -> strings[value] = s);
        for (var i = 0; i < strings.length; i++) {
            objIntConsumer.accept("Hemang", i);
        }
        log.info(Arrays.deepToString(strings));
    }
}
