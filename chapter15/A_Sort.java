package org.example.chapter15;
/*
=== 스트림 API
1. 스트림 생성
2. 중간 가공 절차
Function : 입력 값을 받아 특정 연산후 반환
filter: 입력 값을 받아 조건을 검사
sorted : 입력값에 대한 비교
3. 최종 절차
collect
forEach

자바의 정렬
: 데이터를 특정 기준 순서에 따라 나열
EX) 오름차순 (1, ㄱ ㅏ ㅁ 부터)
    내림차순 (큰 수 ㅎ ㅣ z 부터)
    문자열 길이 순 정렬

    2. 배열 (Arrays 클래스) 정렬
    Arrays 클래스의 정적메서드 sort 사용
    오름 차순 정렬만 지원
    내림차순 정렬 - Comparator 클래스 사용 reverseOrder 정적 메서드를 사용

    3. 리스트 인터페이스 정렬
    Collections.sort()
    List 인터페이스의 sort() 메서드를 사용
 */

import java.util.*;
import java.util.stream.Collectors;

public class A_Sort {
    public static void main(String[] args) {
      int[] numbers = {5, 3, 2, 7, 1};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        // 내림 차순
        // comparator 클래스의 reverseOrder()
        // Comparator<T>를 반환 하는 메서드 (객체 타입 간의 비교 - 기본 데이터 타입 비교 안됨)
        Integer[] nums = {5, 3, 2, 7, 1};
        Arrays.sort(nums, Collections.reverseOrder());

        System.out.println(nums[0]);
        System.out.println(nums[4]);

        // [2] 리스트 정렬
        // 오름차순
        List<Integer> list = new ArrayList<>(List.of(4, 2, 6, 1, 3));

        list.sort(null);

        // list.sort()는 내부적으로  Comparator을 전달 받음
        // >> 비교 기준을 정해주는 클래스
        // 1) null
        // : 기본 정렬 (오름차순) - String, Integer, Double 등의 단일 데이터는 Comprable를 이미 구현
        // 2) Comparator
        // : 지정한 Compraotr 기주능로 정렬
        List<String> listA = new ArrayList<>(List.of("aaa", "aaaaa", "aa", "a", "aaaaaa"));
        listA.sort(Comparator.comparingInt(String::length));
        System.out.println(listA);

        System.out.println(list);

        // == 내림 차순 정렬
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        // == Comparator 클래스
        // : 사용자 정의 기준 정렬

        List<String> names = new ArrayList<>(List.of("Tom", "Jarry", "Pororo", "Loopy"));

        // 문자열 기준 정렬
        // 전체 순회 > 각 이름의 길이를 반환 > 오름차순 정렬\
        names.sort(Comparator.comparingInt(name -> name.length()));
        names.sort(Comparator.comparingInt(String::length));

        System.out.println(names);

        // Comparator: 두개의 객체를 비교하여 로직을 담는 인터페이스
        // >> 아떤 기준으로 정렬할지 개발자가 결정

        // 3 스트림 API
        List<Integer> listNumber = new ArrayList<>(List.of(7, 2, 4, 5, 1));

        List<Integer> sortedNumber = listNumber.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedNumber);
        System.out.println(listNumber);
        // 스트림 API를 사용한 정렬 시 원본데이터에 대한 불변성이 유지됨
        // 새로 정렬된 리스트를 반환

        // 내림차순
        List<Integer> sortedReverseNumber = listNumber.stream()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());

        // 정렬식 (내림차순)
        // (a, b) -> b - a
        // : a와 b는 리스트안에 두개의 요소
        // 두 요소를 비교항 결과를 반환
        // 1) 반환값이 양수: b가 a보다 앞에 옴
        // 2) 반환값이 0: 순서변경 안됨
        // 3) 반환값이 음수: a가 b보다 앞에 옴

        List<String> charNames = new ArrayList<>(List.of("Tom", "Jarry", "Pororo", "Loopy"));

        List<String> sortedChar = charNames.stream()
                .sorted((n1, n2) -> n1.length() - n2.length()) // 오름차순
                .collect(Collectors.toList());

        System.out.println(sortedChar);
    }
}
