package org.example.chapter15;

/*
1. collect  메서드
: 스트림의 요소를 변환 집계하여 최종 결과를 생성하는데 사용
- 스트림의 종결 작업 중 하나
특정 컨테이너 list, set, Map으로 변환 || 값을 합산 집계사용

2. Collect 클래스
: 다양한 Collectors를 제공하여 collect() 메서드와 결합해 하나의 결과를 반환
다양한 성적으로 제공
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C_Collect {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("java", "python", "javascript");

        List<String> upperLanguages = Languages.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        String result = upperLanguages.stream()
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(result);

        Map<Character, List<String>> groupedByFirstChar = upperLanguages.stream()
                .collect(Collectors.groupingBy(language -> language.charAt(0)));

        System.out.println(groupedByFirstChar);

        Map<Boolean, List<Integer>> partitioned = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println(partitioned);
    }
}
