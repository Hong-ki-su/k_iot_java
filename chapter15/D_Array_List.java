package org.example.chapter15;

/*
=== 배열 VS 리스트
공통점 순서O 인덱스 번호로 접근 가능

1. array 배열
: 정적 자료구조
크기 고정 - 생성시 지정한 크기 변경 불가
연속된 메모리 공간에 저장
데이터기 동일한 타입이어야 함

2. List
동적 자료구조
크기 기변
메모리 공간이 불연속적
다양한 구현체 존재

List <> 컬렉션 프레임워크 불변 리스트 가변 리스트 모두 할당 가능
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class D_Array_List {
    public static void main(String[] args) {
       // List 생성 방법
       // 1. new Arraylist
        // 가변 O
        List<String> list = new ArrayList<>();

        // Arrays.asList();
        // 가변  X
        // 가짜 ArrayList: Arrays 클래스 내부에서 구현된 별개의 Arraylist (컬렉션 프레임워크 X)
        // 배열을 리스트로 변환

        List<String> asListVar = Arrays.asList("a", "b");

       // list.of
        // 불변 O (길이 조정 수정 불기)
        // 가변 O

        List<String> listOfvar = List.of("a", "b");

        // stream of().collect(collectors.tolist)
        // 가변 O

        List<String> collectVar = Stream.of("a", "b").Collectors.toList());

        // List.copyOf();
        // 불변 O (길이 조정. 수정 불가)
        // 기존 리스트의 불변 복사본 생성
    }
}
