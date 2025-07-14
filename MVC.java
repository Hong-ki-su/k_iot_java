package org.example.chapter12;
/*
=== MVC 패턴
model view controller
사용자가 인터페이스를 설게하는 소프트웨어 디자인 패턴중 하나
세 가지 구성 요소로 나누어 개발을 진행

디자인 패턴: 소프트웨어 디자인 과정에서 자주 발생하는 문제들을 대한 일반적인 해결책

1. model
: 애플리케이션 데이터와 비지니스 로직 당담
: DB 파일 시스템 외부 서비스와의 통신을 통해 데이터를 저장하고 검색
: 상태 변경에 대한 view Controller 에게 알릴 수 있는 메거니즘 제공

 view
 : 사용자 에게 데이터를 표시하는 방법을 정의
 model 정보를 표시 사용자 액션을 controller 에게 전달
 model 이 가진 정보를 사용자가 이해 할 수 있는 형태로 변환

 controller
 사용자의 입력을 처리하고 model view 사이의 상호작용을 관리
 사용자의 입력에 반응하여 model 을 업데이트 하고 필요한 경우 view 새롭게 출력

 MVC
 역활 분담
 각 구성 요소가 독립적인 기능을 책임 > 코드 관리 & 확장 용이

 유지 보수 용이
 애플리케이션 비지니스, 로직과 사용자 인터페이스가 분리되어 유지 보수가 쉬움

 MVC 패턴 단점
 복잡성 증가
 간단한 애플리케이션 구현에는 MVC >> Controller >> view
 학습 곡선 높음
 이해하고 사용하기 까지 일정한 학습 필요

 MVC 패턴의 작동 원리
 view >> Controller >> Model >> Controller >> view
 */


// 학교 급식 시스템
// model : 급식표 - 급식 메뉴가 적힌 종이
// view : 칠판 - 학생들이 확인하는 곳
// Controller : 영

class LunchMenu {
    private String menu;

    public String getMenu() {return menu;}
    public void setMenu(String menu) {this.menu = menu;}
}

class LunchView {
    public void displayMenu(String menu) {
        if (menu == null || menu.isBlank()) {
            System.out.println("오늘 급식이 없습니다.");
        }
        System.out.println("오늘 급식 메뉴는 " + menu);
    }

    class LunchController {
        private LunchMenu model;
        private LunchView view;

        public LunchController(LunchMenu Model, LunchView view) {
            this.model = model;
            this.view = view;
        }
        public void setView() {

        }
       public void studentRequestMenu() {

       }
    }
}

public class MVC {
    public static void main(String[] args) {

    }
}
