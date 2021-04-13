package com.techrevolution.functionalinterface.ch12.practice;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Stream;

@Setter
@AllArgsConstructor
@Builder
class Student {
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

@AllArgsConstructor
@Builder
@Getter
class School {
    private String subject;
    private List<Student> list;

    @Override
    public String toString() {
        return "School{" +
                "subject='" + subject + '\'' +
                '}';
    }
}

@Slf4j
public class MapVsFlatmap {
    public static void main(String[] args) {

        log.info("-----------------map method-------------------------------");
        getStream()
                .map(School::getList)
                .forEach(students -> log.info(String.valueOf(students)));
        log.info("-----------------flatmap method-------------------------------");
        getStream()
                .flatMap(school -> school.getList().stream())
                .forEach(student -> log.info(String.valueOf(student)));
    }

    private static Stream<School> getStream() {
        return Stream.of(
                School.builder().subject("Java").list(
                        List.of(
                                Student.builder().firstName("Hemang").lastName("Dave").build(),
                                Student.builder().firstName("Nishit").lastName("Kasani").build(),
                                Student.builder().firstName("Krutarth").lastName("Dave").build()
                        )
                ).build()
        );
    }

}
