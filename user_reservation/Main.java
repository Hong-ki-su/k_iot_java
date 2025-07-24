package org.example.user_reservation;

/*
프로젝트 개요
온라인 예약 시스템

사용자가 회원가입 후 로그인을 해야 만 예약 시스템 접근 가능
예약은 등록 조회 취소 기능을 포함
사용자가는 시스템 활용이 끝나면 로그아웃 가능

1 기능
사용자 관리

2 프로그램 구성 요소
모델: 사용자가 예약 정보 시스템 클래스
서비스: 사용자, 예약 관련 비지니스 로직
컨트롤러: 사용자의 요청을 처리하고 응답하고 역활

3. 프로젝트 구조
entity: UserService, ReservationService interface
각각 Impl class
 */

import org.example.user_reservation.controller.ReservationController;

public class Main {
    public static void main(String[] args) {
    ReservationController controller = new ReservationController();
    controller.run();
    }
}
