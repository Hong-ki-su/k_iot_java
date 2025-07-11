package org.example.chapter10;

// map 인터피에스
// 키는 값 쌍으로 요소를 요소를 저장하는 데이터 구조
// 키는 고유한
// 동일한 키에 서로 다른 키에 동일한 값은 가능

// Map 인터페이스 종류
// hashset
// 가장 많은 사용 키와 값에

// LinkedHadhmap
// Hashmap + 삽입 순서 유자
// 빠른 검색 삽입 선능 제공

// 3. treeMap
// : 키에따라 자동 정렬가능
// 키에 null 허용 X

import java.util.*;

public class E_map {
    public static void main(String[] args) {
     // map 인터페이스 메서드
     // map 타입 값 타입 인스턴스 명

        Map<String, Integer> studentAges = new HashMap<>();

        studentAges.put("홍기수", 20);
        studentAges.put("김지선", 25);
        studentAges.put("김동주", 30);

        System.out.println(studentAges);

        System.out.println(studentAges.get("홍기수"));

        studentAges.remove("김동주");
        System.out.println(studentAges);

        System.out.println(studentAges.containsKey("이승아"));
        System.out.println(studentAges.containsValue(30));

        System.out.println(studentAges.containsKey("김지선"));
        System.out.println(studentAges.containsValue(20));

        System.out.println(studentAges.size());

        System.out.println(studentAges.keySet());

        Collection<Integer> listAges = studentAges.values();
        System.out.println(listAges);

        //cf
        List<Integer> changeList = new ArrayList<>(listAges);
        System.out.println(changeList);

        System.out.println(studentAges.entrySet());
    }
}
