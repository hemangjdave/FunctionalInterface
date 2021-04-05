package com.techrevolution.functionalinterface.ch10.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;

@Slf4j
public class StudentComparator {
    public static void main(String[] args) {


        Student student1 = new Student("Sanjay", 1002, 8.87);
        Student student2 = new Student("Sanjay", 1001, 8.97);
        Student student3 = new Student("Sanjay", 1003, 9.01);


        Map<String, Student> studentMap = Map.of("S123", student1, "S234", student2, "S456", student3);

        Comparator<Map.Entry<String, Student>> comparator = (entry1, entry2) -> entry2.getValue().getCgpa().compareTo(entry1.getValue().getCgpa());

        Optional<Map<String, Student>> optional = Optional.of(studentMap);
        optional.get()
                .entrySet().stream()
                .sorted(
                        comparator
//                        Comparator.comparingDouble(map -> map.getValue().getCgpa())
                ).forEach(
                stringStudentEntry
                        -> log.info(stringStudentEntry.getKey() + " :-- " + stringStudentEntry.getValue())
        );


        log.info("--------------------------DONE ---------------------------------------------------------");

        Function<Student, Double> function1 = Student::getCgpa;
        Function<Student, Integer> function2 = Student::getId;
        Function<Student, String> function3 = Student::getName;
        List<Student> studentList = Arrays.asList(student1, student2, student3);

        Comparator<Student> comparator1 = Comparator.comparing(function1);
        log.info("------------SORTING BY CGPA----------------------");
        studentList.sort(comparator1);
        studentList.forEach(student -> log.info(student.toString()));

        Comparator<Student> comparator2 = Comparator.comparing(function2);
        log.info("------------SORTING BY ID-------------------------");
        studentList.sort(comparator2);
        studentList.forEach(student -> log.info(student.toString()));

        Comparator<Student> comparator3 = Comparator.comparing(function3);
        log.info("------------SORTING BY NAME------------------------");
        studentList.sort(comparator3);
        studentList.forEach(student -> log.info(student.toString()));

        log.info("--------------SORTING BY ALL COMPARATORS-------------");
        studentList.sort(comparator3.thenComparing(comparator2).thenComparing(comparator1));
        studentList.forEach(student -> log.info(student.toString()));

    }
}
