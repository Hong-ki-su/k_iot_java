package org.example.chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



/*
1. 컬렉션 프레임 워크
2. 스트림 API
3. 람다 표현식 & 메서드 참조
 */
@AllArgsConstructor
@Getter
@ToString
class StudentClass {
    private String name;
    private int age;
    private double grade;
}

public class J_Practice {
    public static void main(String[] args) {
        List<StudentClass> studentClasses = Arrays.asList(
        new StudentClass ("오신혁",25,4.3),
        new StudentClass ("김세훈",30,4.5),
        new StudentClass ("권민현",27,4.0),
        new StudentClass ("안미향",29,3.8),
        new StudentClass ("김태양",20,3.9)

        );

        // 1 학점
        List<StudentClass> filteredStudents = studentClasses.stream()
                .filter(student -> student.getGrade() >= 4.0)
                .collect(Collectors.toList());

        System.out.println("학점이 4.0이상인 학생");
        filteredStudents.forEach(System.out::println);

        // 2.
        List<String> studentNames = studentClasses.stream()
                .map(student -> student.getName())
                .collect(Collectors.toList());
      // .map(StudentClass::getName)
           //     .collect(Collectors.toList());

        System.out.println("학생 이름 목록");
        System.out.println(studentNames);

        // 3.
        List<StudentClass> sortedStudents = studentClasses.stream()
                .sorted(Comparator.comparingDouble(s -> s.getGrade()))
                .sorted(Comparator.comparingDouble(StudentClass::getGrade).reversed()) // 내림 차순 정렬
                .collect(Collectors.toList());

        System.out.println("점수 순으로 정렬된 학생");
        sortedStudents.forEach(System.out::println);

        // 4. 학생들 중 이름에 민 자가 포함된 학생 필터링
        List<StudentClass> studentWithMin = studentClasses.stream()
                .filter(studentClass -> studentClass.getName().contains("민"))
                .collect(Collectors.toList());

        System.out.println("이름에 민이 들어간 학생");
        studentWithMin.forEach(System.out::println);


    }
}
