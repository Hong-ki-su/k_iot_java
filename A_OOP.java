package org.example.chapter11;

// OOP (object oriented programming)
// 객체 지향 프로그래밍

// soLid 원칙 principle
// : 객체 지향 프로그래밍 5가지 소프트웨어 개발 원칙
// srp ocp lsp isp dsp
// 소프트웨어 설게에서 유지보수성 확장성을 높임
// 다양한 디자인 패턴
// 다양한 디자인 패턴 설게 원칙에 따라 만들어짐

// 디자인 패턴
// : 소프트웨어 개발 과정에서 자주 발생하는 문제들에 대한 일반적인 해결책

// SOLID 원칙 착용시 주의점
// : 적용순서 X
// : 모두 적용  X
// : 서로 독립적 개념 X 개념적으로 연관 X
// : 상속 캡슐화 추상화 다형성 oop의 4가지 특성

// : spr (single responsibility principle) 단일 책임 원칙
// 클래스는 단 한가자의 책임만을 가져야함
// 한 가지 역활만 당담 / 하나의 변화 이유만을 가져야함
// >> 하나의 클래스 가지는 하나의 역활과 관련된 변경사항만 클래스에 영향을 마쳐야 함

// 1) 잘못된 설계 예시
class SchoolHelper {
    void cleanClassroom() {
        System.out.println("교실을 청소합니다");
    }
    void prepareLuch() {
        System.out.println("급식을 준비합니다");
    }
}

// 2) 올바른 설계 예시
class Janitor {
    void cleanClassroom() {
        System.out.println("교실을 청소합니다");
    }
}

class LuchStaff {
    void prepareLunch() {
        System.out.println("급식을 준비합니다");
    }
}

// 2. OCP (open closed principle)
// : 소포트웨어 엔티티 (클래스 모듈 함수 등) 확장에는 열려있어야 하고 수정에는 닫혀있어야 한다

class LunchMenu {
    void serveLunch(String studentType) {
     if (studentType.equals("일반 학생")) {
         System.out.println("알레르기가 없습니다.");
     } else if (studentType.equals("땅콩 알레르기")) {
         System.out.println("땅콩 알레르기가 있습니다");
     }
    }
}

// 2) 올바른 설계 예시
interface LunchMenuInterface {
    void serveLunch();
}

class RegularStudent implements LunchMenuInterface {
    @Override
    public void serveLunch() {
        System.out.println("일반 학생 알레르기가 없습니다");
    }
}
class VegetableStudent implements LunchMenuInterface {
    @Override
    public void serveLunch() {
        System.out.println("체식 학생 셀러드를 제공합니다");
    }
}

class AllergyStudent implements LunchMenuInterface {
    @Override
    public void serveLunch() {
        System.out.println("알레르기 학생 - 특별 배식구 이동하세요 ");
    }
}

// 추상 클래스와 이터페이스를 사용하여 상속 구현을 통한 클래스 관계 구촉

// 3. lsp (Liskov Substution principle)
// : 상의 클래스 객체를 하위 클래스와 객체로 치환하더라도 프로그램의 동작이 일관되게 유지되어야 함
// : 자식 클래스 부모 클래스의 기능을 완전하게 대체 할 수 있음

// 1) 잘못된 설계 예시
class Student {
    void playSoccer() {
        System.out.println("축구를 할 수 있습니다");
    }
}
class InjuredStudent extends Student {
    @Override
    void playSoccer() {
        System.out.println("다쳐서 축구를 할 수 없습니다");
    }
}

// 2) 올바른 설계 예시
abstract class StudentAbstractract {
    abstract void activity();
}
class SoccerPlayer extends StudentAbstractract {
    @Override
    void activity() {
        System.out.println("축구를 합니다");
    }
}

class InjuredSoccerPlayer extends StudentAbstractract {
    @Override
    void activity() {
        System.out.println("다쳐서 축구를 할 수 없습니다. 재활 훈련을 합니다");
    }
}

public class A_OOP {
    public static void main(String[] args) {

    }
}
