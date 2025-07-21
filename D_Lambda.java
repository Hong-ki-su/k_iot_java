package org.example.chapter14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*
=== 람다 표현식
함수형 인터페이스 구현 사용 자바 8부터 도입
함수를 하나의 식으로 간결하게 표현


함수형 인터페이스
: 추상 메서드가 단 하나만 존재하는 인터페이스
인터페이스에
디폴트 메서드 static 메서드는 여러개 존재가능
 */
@FunctionalInterface
interface MyFunctionalInterface {
    void doSomething();
 //   void anotherSomething();
    // >> 함수형 인터페이스 단 하나의 추상메서드 가짐
}

/*
1. 람다식 기본형태

메서드 기본 형태
접근 제어자 반환타입 메서드명
구현부

람다식
: 추상메서드 간결하게 구현하는 것이 목표

인터페이스 추상메서드 public abstract 생략

구현부 작성 끝

>> 매개변수 : 인터페이스 메서드 매개변수와 동일
>> 활살표로 매개변수 실행문 구분
실행문 : 메서드 몸체 {}
 */

// 람다식 시용 예제
// 1
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}

// 2) 매개변수
@FunctionalInterface
interface NoParams {
    void sayHello();
}

// 3) 매개변수
@FunctionalInterface
interface OneParams {
    void print(String message);
}

@FunctionalInterface
interface Operation {
    void operate(int a, int b);
}

@FunctionalInterface
interface StringLength {
    static Function<String, Integer> andThen(Function<Integer, Integer> square) {
    }

    int getLength(String str);
}

public class D_Lambda {
    public static void main(String[] args) {
        System.out.println("=== 익명 클래스를 사용한 추상메서드 구현");
        Calculator calculator1 = new Calculator() {
            @Override
            public int add(int a, int b) {
                return 0;
            }
        };

        System.out.println("익명클래스 결과: " + calculator1.add(3,5));

        System.out.println("람다식을 사용한 추상 메서드 구현");
        Calculator calculator2 = (int a, int b) -> {
            int result = a + b;
            return result; //
        };
        System.out.println("람다식 결과1: " + calculator2.add(4,9));

        // cf 람다식의 경우 구현부가 한 줄 일 때 중괄호 생략 가능
        // >> return
        Calculator calculator3 = (int a, int b) -> a + b;
        System.out.println("람다식 결과2: " + calculator3.add(7,8));

        System.out.println("매개변수 가 없는 추상 메서드 표현");
        NoParams noParams = () -> {
            String a = "HI";
            String b = "Hello";
            System.out.println(a + b);
        };
        noParams.sayHello();

        NoParams noparams2 = () -> System.out.println("매개변수 없고 반환값고 없음");
        noparams2.sayHello(); // 매개변수 없고 반환값도 없음
        //

        System.out.println("매개변수 하나인 추상 메서드 표현");
        OneParams oneParams = Stringmessage -> System.out.println("출력: " + Stringmessage);
        oneParams.print("안녕");

        System.out.println("실행문이 여러 줄인 추상 메서드 표현");
        Operation operation = (int a, int b) -> {
            System.out.println("함");
            System.out.println("차");
        };
        operation.operate(3,4);

        System.out.println("반환값이 있는 추상메서드 표현 ");
        StringLength stringLength = Stringstr -> Stringstr.length();

        System.out.println("문자열의 길이: " + stringLength.getLength("Lambda"));

        // 여러줄의 코드가 ㅅ
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println(numbers);

        for (Integer num: numbers) {
            System.out.println(num);
        }

        numbers.forEach(num -> System.out.println(num));
    }
}
