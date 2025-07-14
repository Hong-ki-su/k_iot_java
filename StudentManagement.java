package org.example.chapter12;

/*
== 학생 관리 시스템
: HVC 패턴 적용
학생 데이터 에 대한 crud

1. 요구 사항 정리
2. 학생 추가 기능
3. 학생 전체 조회
4. 특정 핟생 조회 가능
5 학생 삭제 기능
6. 프로그램 종료

2) HVC
model student
field (학생 고유 번호)
학생 고유 번호, 이름,나이.학번 생성일
method
getter/setter tostring

view
: 사용자와 상호작용할 수 있는 메뉴를 표시
각 요청에 따라서 controller 에게 요청값과 행위를 전달

3) controller
학생 데이터 저장
5 가지 기능
 */

import org.example.chapter12.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        List<Student> dummyStudents = new ArrayList<>();
        dummyStudents.add(new Student(1, "홍기수",25,"1111"));
        dummyStudents.add(new Student(2, "이도경",29,"2222"));
        dummyStudents.add(new Student(3,"조승범",30,"1234"));

        public StudentView(Scanner.)
    }
}
