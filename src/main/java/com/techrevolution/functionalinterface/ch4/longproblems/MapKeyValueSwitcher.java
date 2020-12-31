package com.techrevolution.functionalinterface.ch4.longproblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Animal {
    private final String type;
    private final String description;

    public Animal(String brede, String description) {
        this.type = brede;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "animal type is:--" + type + " and animal description is:--" + description;
    }
}

public class MapKeyValueSwitcher {
    public static void main(String[] args) {
        var map = createAnimalMap();
        Objects.requireNonNull(map);
        System.out.println("Original map is:--");
        System.out.println(map);
        var convertedMap = getListToMapFunctionImpl().andThen(getMapToListFunction()).apply(map);
        System.out.println("Switched map will be:--");
        System.out.println(convertedMap);
    }

    private static Function<Map<String, Animal>, List<Animal>> getListToMapFunctionImpl() {
        return animalMap -> new ArrayList<>(animalMap.values());
    }

    private static Function<List<Animal>, Map<String, String>> getMapToListFunction() {
        return animals -> animals.stream()
                .collect(Collectors.toMap(
                        Animal::getDescription, Animal::getType
                ));
    }

    private static HashMap<String, Animal> createAnimalMap() {
        Animal animal1 = new Animal("dog", "wolf descedent");
        Animal animal2 = new Animal("cat", "feeling with nine lives");
        Animal animal3 = new Animal("rat", "rodent with long tail");
        var map = new HashMap<String, Animal>();
        map.put(animal1.getType(), animal1);
        map.put(animal2.getType(), animal2);
        map.put(animal3.getType(), animal3);
        return map;
    }
}
