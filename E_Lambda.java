package org.example.chapter14;

/*
== 람다식
함수형 인터페이스 를 간결하여 구현하는 코드식
딱 한가지 일을 처라히는 메서드

1. predicate<T> 판단하다
: 입력값을 받아 조건을 검사하는데 사용
메서드: boolean text : 주어진 입력 값이 조건을 만족하여 true
and (predicate other), or (predicate other) negate();

negate 부정하다 현재의 결과를역전

2 Function <T, R>
: 입력값을 받아 특정 연산을 수행한후 결과를 반환
andThen 현재 결과를 다른 Function 입력으로 연결
compose 다른 Function의 결과를 현재 입력으로 연결

@FunctionalInterface
interface predicate

R apply (T, t);

3. consumer
: 입력 값을 받아 소비하는데 사용
메서드 void accept(T t) 입력값을 소비

interface Consumer<T>
void accept(T t)

4. supplier<T>
:값을공급 생성 하는데 사용 입력 값이 필요로 하지 않음
외부에서 값을 가져오거나 데이터를 생성하여 반환하는 역활
메서드
interface supplier
 */


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class E_Lambda {
    public static void main(String[] args) {
        System.out.println("predicate");
        Predicate<Integer> isEven =  n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;

        System.out.println(isEven.test(11));
        System.out.println(isPositive.test(10));

        // 논리값
        // 논리 연산자 처럼 조건을 연결
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
        System.out.println(isEvenAndPositive.test(4));
        System.out.println(isEvenAndPositive.test(-4));

        System.out.println("Function");
        // 매개변수 문자열 1개 반환값
        Function<String, Integer> stringLength = s -> s.length();
        Function<Integer, Integer> square = n -> n * n;
        Function<String, String> upperString = s -> s.toUpperCase();

        System.out.println("홍기수 메롱");
        System.out.println("nice to meet you");

        Function<String, Integer> LengthAndSquare = stringLength.andThen(square);
        System.out.println(LengthAndSquare.apply("이 문자열 길이의 제곱값은?"));

        System.out.println("consumer");
        Consumer<String> printMessage = msg -> System.out.println(msg);
        Consumer<String> printLength = msg -> System.out.println(msg.length());

        printMessage.accept("안녕하세요");
        printLength.accept("1234567");

        Consumer<String> combinedConsumer = printMessage.andThen(printLength);
        combinedConsumer.accept("123");

        System.out.println("Supplier");

        // MAth.random(); 0.0 과 1.0사이의
        Supplier<Double> randomValue = () -> Math.random();

      //  Supplier<Double> random

        System.out.println(randomValue.get());
    }
}
