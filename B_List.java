package org.example.chapter10;

// === list 인터페이스
// list User userList = new ArrayList();

// 1. 특성
// : 순서유지 증복 저장 가능 (인덱스를 통해 정확한 위치 지정 가능)
// - 저장된 순서에 따라 데이터를 관리하는 다양한 메서드를 지원

// 2. 종류

// 1) Arraylist
// : 내부에서 배열을 사용한 요소 저장
// - 빠른 읽기 성능 / 느린 삽입 삭제 성능
// 빠른 조회 기능에 적합

// Ex 사과 버리기 - 사과를 일렬로 정렬가능
// 추가 가능 공간에 대한 정리 (중간에 삽입시
// 꺼내디 : 순차적인 수를 사용하여 생성

// 2) linkedlist
// : 내부에서 이중 연결 리스트를 사용한 요소 저장
// : 빠른 삽입 삭제 성능 / 느린 읽기 가능
// :

// EX 기차 - 칸마다 서로 연결 주의
// 새로운 건 추가 삭제 - 앞귀 칸에 연결만 하면 가능 >> 속도 빠름
// - 특정 칸을 찾기

import java.util.ArrayList;
import java.util.LinkedList;

public class B_List {
    public static void main(String[] args) {
     // list 인터페이스 주요 메서드
        System.out.println("=== arraylist & linkedList===");

        // List 인터페이스 >> Abstract 추상 클래스
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        // 데이터 추가
        arrayList.add("java");
        arrayList.add(0,"Python");
        arrayList.add("javaScript");

        linkedList.add("mango");

        System.out.println(arrayList);

        String firstElement = arrayList.get(0);
        System.out.println(firstElement);

        arrayList.set(2,"TypeScript");
        System.out.println(arrayList);

        String removedElement = arrayList.remove(1);
        System.out.println(removedElement);
        System.out.println(arrayList);

        // 데이터 크기
        System.out.println(arrayList.size());
        System.out.println(linkedList.size());

        // 데이터 삭제
        arrayList.clear();
        System.out.println(arrayList.size());

        // 데이터 포함 여부 확인
        // 리스트
        System.out.println(linkedList.contains("orange"));
        System.out.println(linkedList.contains("strawberry"));

        // arraylist linkedlist 성능  비교
        ArrayList<Integer> arraylistTest = new ArrayList<>();

        // cf 클래스 구조의 객체 타입 데이터
        // : 클래스 구조는 객체 타입의 데이터만 삽입 가능

        long startTime = System.nanoTime();
        // 1초 = 1000000000
        System.out.println(startTime);

        for (int i = 0; i < 222222; i++) {
            arraylistTest.add(0,i);
        }
        long endTime = System.nanoTime();

        System.out.println("Arraylist 삽입시간: " + (endTime - startTime) + "ns");

        //
        LinkedList<Integer> linkedListTest = new LinkedList<>();
        startTime = System.nanoTime();


        }
    }

