package com.techrevolution.functionalinterface.ch1.longproblems.first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToStringImpl {
    public static void main(String[] args) {

        //This implementation is for List<String>
        //Output of the following implementation will be [Hemang,Dave,Shiva]
        ToString<List<String>> listToString = ToStringImpl::convertListToString;
        System.out.println(listToString.convert(Arrays.asList("Hemang", "Dave", "Shiva")));

        //This implementation is for List<String>
        //Output of the following implementation will be {Hemang:29, Shiva:30}
        Map<String, Integer> integerMap = new HashMap<>();
        integerMap.put("Hemang", 29);
        integerMap.put("Shiva", 30);
        integerMap.put("Niramay", 17);
        ToString<Map<String, Integer>> mapToString = ToStringImpl::convertMapToString;
        System.out.println(mapToString.convert(integerMap));
    }

    private static String convertMapToString(Map<String, Integer> integerMap) {
        StringBuilder builder = getDefaultStringpart();
        integerMap.forEach((key, value) -> builder.append(key)
                .append(":")
                .append(value)
                .append(","));
        return getEndPartOfBuilder(builder);
    }

    private static String convertListToString(List<String> list) {
        StringBuilder builder = getDefaultStringpart();
        list.forEach(s -> builder.append(s).append(","));
        return getEndPartOfBuilder(builder);
    }

    private static String getEndPartOfBuilder(StringBuilder builder){
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    private static StringBuilder getDefaultStringpart(){
        StringBuilder builder = new StringBuilder(32);
        builder.append("[");
        return builder;
    }
}
