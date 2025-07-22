package org.example.chapter14;

/*
학생 점수 커리시스템
람다식 및 주요 함수형 인터페이스 활용
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class F_Practice {
    public static void main(String[] args) {
      // 학생 이름의
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("홍기수",90);
        studentScores.put("김채환",80);
        studentScores.put("최동욱",95);
        studentScores.put("박성준",85);
        studentScores.put("오제욱",100);

        Predicate<Integer> isPass = score -> score >= 90;

        // Function : 점수를 학점 으로 변환하는 함수
        Function<Integer, String> gradeFunction = score -> {
            if (score > 100 || score < 0) return "X";
            else if (score >= 90) return "A";
            else if (score >= 80) return "B";
            else if (score >= 70) return "C";
            else return "F";
        };

        // 1) 전달받은 문자열 길이 만큼 문자출력
        // 문자열 repect(int): int의 수 만큼 해당 문자열 반복해 새로운 문자열
        Consumer<String> line = s -> System.out.println("=".repeat(s.length()));

        Consumer<String> printHeader = title -> {
            line.accept(title);
            System.out.println(title);
            line.accept(title);
        };

        // 3) 학생 1명 정보를 출력하는 함수
        Consumer<Map.Entry<String, Integer>> printStudentInfo = entry -> {
            String name = entry.getKey();
            int score = entry.getValue();
            String grade = gradeFunction.apply(score);
            boolean pass = isPass.test(score);

            // Map 인터페이스 안에 정의된 중첩 인터페이스
            // Map
            Map<String, Integer> map = new HashMap<>();
            map.put("Apple", 3); // Apple 사과는 3개 각요소를 Map.Entry<String, Integer>
            map.put("Banana", 5);

            System.out.println(name + " | 점수: " + score + " | 등급: " + grade + " | " + (pass ? "합격" : "불합격"));
        };

        // supplier 무작위로 보너스 점수를 생성하는 공급자 함수
        // 0 ~ 5 점 중 하나를 빈환함

        Supplier<Integer> bounsSupplier = () -> new Random().nextInt(6);

        printHeader.accept("학생 점수 처리 결과");


    }
}
