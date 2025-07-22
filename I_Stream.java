package org.example.chapter14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class I_Stream {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> newNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList()); // 최종연산 - 변경이 가능한 리스트로 반환 / java 8 이상 권장!!!

        // . stream() 으로 생성된 스트림은 일회성으로 사용 가능
        // 메서드 체이닝으로 여러가지 적용이 가능

        Stream<Integer> stream = newNumbers.stream();

       stream
                .map(n -> n % 2 == 0)
                .toList(); // 최종 연산 - 불변 리스트 빈환

      // a.add(100);

        System.out.println(numbers);
        System.out.println(newNumbers);
    }
}
