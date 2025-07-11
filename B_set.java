package org.example.chapter10;

/*
    === set 인터페이스
    : 증복 X 순서 X
    - 증복된 요소를 포함하지 않는 객체의 집합
    - 객체가 저장 순서를 가지지 않음
    null 요소 포함 가능

    list 요소 포함 가능

    == 종류
    1. hashset
    : 가장 많이 사용되는 set 구현체
    빠른 데이터 접근
    정렬 또는 순서 보장 X

    2. linkedHashset
    : hash set + 순서O

    3. treeset
    : 데이터가 자동 정렬 증목 제거 + 정렬된 순서가 유지가 필요한 경우
 */

import java.util.HashSet;
import java.util.Set;

public class B_set {
    public static void main(String[] args) {
     // set
     // add remove contains size isEmpty

     Set<String> students = new HashSet<>();

     students.add("홍기수");
     students.add("정은헤");
     students.add("김희성");
     students.add("손태경");

        System.out.println(students);

        students.add("김희성");
        System.out.println(students);

        boolean result = students.remove("손태경");
        System.out.println(result);
        System.out.println(students);

        boolean falseResult = students.remove("홍기수");
        System.out.println(students.size());

        System.out.println(students.contains("손태경"));
        System.out.println(students.contains("홍기수"));
        System.out.println(students.contains("김희성"));

        System.out.println(students.isEmpty());
        students.clear();
        System.out.println(students.isEmpty());
    }
}
