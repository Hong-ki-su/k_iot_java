package org.example.chapter14;

// chapter14
// 내부 클래스 익명 클래스  람다식
// 람다식 stream API

/*
 === 내부 클래스 (중첩) inner class , nested class
 다른 클래스 내부에 선언된 또 다른 클래스 의미
 즉 클래스 안의 클래스

 1. 코드가독성 향상 - 코드의 구조 파악 용이
 2. 캡슐화 강화 - 외부에 공개할 필요가 없는 클래스는 내부로 김춤
 3. 외부 클래스 맴버 접근 - 내부 클래스는 외부 클래스의 필드와 메서드에 직접 접근가능

 4. 비정적 내부 클래스
 외부 클래스의 인스턴스 속함

 1. 정적 내부 클래스
 : 외부 클래스 정적 맴버에만 속함
 외부 클래스 인스턴스 없이 생성 가능

 2. 메서드 내부 클래스
 메서드 내에서 정의된 내부 클래스
 해당 메서드 내에서만 사용 가능
 매서드 지역 변수에만 접근 가능
 로컬 변수 final 경우에만

 3. 익명 클래스
 이름이 없는 내부 클래스
 주로 인터페이스나 추상 클래스의 구현에 사용
 즉시 객체 생성 + 일회성 사용
 */

class OuterClass {
    private String outerField = "외부 클래스의 인스턴스 필드";
    static String staticField = "외부 클래스의 정적 필드";

    class InnerClass {
        void display() {
            // 외부 클래스의 인스턴스 맴버에 접근 가능
            System.out.println("외부 클래스 필드에 접근: " + outerField);

            System.out.println("외부 클래스 정적 필드에 접근: " + staticField);
        }
    }

    // 2. 정적 내부 클래스 - 인스턴스화 없이 시용 가능
    static class StaticClass {
        void display() {
       //     System.out.println("외부 클래스 필드에 접근: " + outerField);

            System.out.println("외부 클래스 정적 필드에 접근: " + staticField);
        }
    }

    // 3. 매
    void outerMethod() {
        // 지역 변수는 암목적으로 final 간주
        // 재할당이 이루어지면 final 사라짐
        String localVar = "메서드 로컬 변수";
    //    localVar = "메서드 로컬 변수 값 변경";

        final String localFinalVar = "매서드 로컬 변수";

        class MethodClass {
            void display() {
                System.out.println("로컬 변수에 접근 " + localVar);
                System.out.println("로컬 변수에 접근 " + localFinalVar);
            }
        }

        System.out.println("외부 클래스의 메서드를 호출");

        // 로컬 클래스의 인스턴스화
        // 메서드 내부에서 쓰이기 때문에 인스턴스화
    }
}

// 추상 클래스
abstract class AbstractClass {
abstract void display();

}
interface InterfaceClass {
    // 인터페이스 일반 구현 메서드를 가질 수 없음
    // >> 추상메서드에 abstract 생략 가능

    // 필드: public static final 생략
    // 메서드 : public abstract  생략

    // +) static 메서드, default 메서드는 구현 가능
    void something();
}

public class A_Inner {
    public static void main(String[] args) {
        System.out.println("=== 비정적 내부 클래스 ===");

        OuterClass outerClass1 = new OuterClass();

        // 2) 외부 클래스의 인스턴스 처럼 사용
        // >> 외부 클래스 타입 내부 클래스 티입 변수명
        OuterClass.InnerClass innerClass = outerClass1.new InnerClass();

        innerClass.display();

        System.out.println("정적 내부 클래스 ");
        // 1. 외부 클래스 인스턴스화 필요 없음
        // 외부 클래스타입 내부 클래스 타입 변수명 = new
        OuterClass.StaticClass staticClass = new OuterClass.StaticClass();

        staticClass.display();

        System.out.println("메서드 내부 클래스 (지역  클래스)");
        OuterClass outerClass2 = new OuterClass();
        outerClass2.outerMethod();

        System.out.println("익명 내부 클래스");
        // 클래스 타입 변수명 = new 클래스명
        // 메서드 구현

        AbstractClass abstractClass1 = new AbstractClass() {
            @Override
            void display() {
                System.out.println("익명 내부 클래스1");
            }
        }; // 세미콜론 필수

        abstractClass1.display();

        AbstractClass abstractClass2 = new AbstractClass() {
            @Override
            void display() {
                System.out.println("익명 내부 클래스 - 추상 클래스2");
            }
        };

        abstractClass2.display();

        System.out.println(abstractClass1 == abstractClass2);

        // 클래스 정의가 외부에서 재사용 할 필요가

        InterfaceClass interfaceClass = new InterfaceClass() {
            @Override
            public void something() {
                System.out.println("안녕하세요 인터페이스로 구현한 익명 클래스입니다");
            }
        };

        interfaceClass.something();
    }
}
