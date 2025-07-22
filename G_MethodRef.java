package org.example.chapter14;

/*
=== 메서드 참조
함다 표현식을 다 간편하게 자성히기 위한 문법
메서드 호출만 하는

: 람다 표현식을 작성 방법
매개변수 -> 실행문

1. 정적 메서드
클래스 static 메서드 참조
ClassName staticMethod(); >> ClassName

2. 인스턴스 메서드 참조
객체 인스턴스 를 반드시 생성하여 사용하는 메서드
특정 객체의 인스턴스 메서드 참조
instance instanceMethod();

3. 생성자 메서드 참조
객체 생성용 생성자 참조
new ClassName(); className::new

4. 임의 객체의 인스턴스 메서드
특정 객체가 아닌 여러 객체에 공통된 인스턴스 메서드 사용 할때
모든 객체가 Object 내의 인스턴스 메서드 포함
 */

import java.util.function.Function;
import java.util.function.Supplier;

class StaticMethod {
    // 정적메서드: 인스턴스 없이 바로 사용가능
    static int doubleValue(int x) {
        return x * 2;
    }
}

class Person {
    private String name;

    public Person() {
        this.name = "이름 미상";
    }

    public Person (String name) {
        this.name = name;
    }
    public String getName() {return name;}
}

public class G_MethodRef {
    public static void main(String[] args) {
        Function<Integer, Integer> doubleLambda = x -> StaticMethod.doubleValue(x);
        Function<Integer, Integer>doubleLambdaRef = StaticMethod::doubleValue;

        System.out.println(doubleLambdaRef.apply(5));
        System.out.println(doubleLambdaRef.apply(10));

        // 2 인스턴스 메서드 참조
        // 문자열 객체의 메서드 사용
        // Object 를 상속받는
        String hello = "Hello";
        // 1)
        Supplier<String> toUpperLambda = () -> hello.toUpperCase();
        Supplier<String> toUpperLambdaRef = hello::toUpperCase;

        System.out.println(toUpperLambda.get());
        System.out.println(toUpperLambdaRef.get());

        Supplier<Person> personLambda = () -> new Person("홍기수");
        Supplier<Person> personLambda2 = () -> new Person();
        // 메서드 참조
        Supplier<Person> personLambdaRef = Person::new;

        Person p1 = personLambda.get();
        Person p2 = personLambda.get();

        System.out.println(p1.getName());
        System.out.println(p2.getName());

        String[] names = {"seungah", "dokyeoung", "seungbeom"};

        Function<String, String> toUpperFunc = String::toUpperCase;

        for (String name: names) {
            // 호출시점에 매개변수로 돌아온 객체의 메서드
            String upper = toUpperFunc.apply(name);
            System.out.println(upper);
        }

    }
}
