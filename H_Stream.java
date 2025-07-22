package org.example.chapter14;

/*
스트림 API
자바 8버전 도입된 기능들 컬렉션 또는 배열에 저장된 데이터를 선언형 방식으로 처리를 할 수 있게 지원하는 도구
데이터 필터링 메핑 변환 잡계 등 다양한 작업 수행
데이터 필터링 매핑 가독성 높음 코드 작성 가능

1. 스트림의 3 단계구조
스트림은 데이터를 소스로 부터 연속적으로 처리하는 파이프라인 구축

데이터 파이프라인
데이터 사용하는 단계 흐름 절차

1) 소스
스트림의 시작점
컬렉션 배열 또는 파일을 소스로 사용

2) 중간 연산
데이터를 가공하는 단계 필터링 매핑 통계
스트림으로 결과가 반환되기 때문에 메서드 체이닝 가능
자연 처리 : 최종 연산이 실행되기 전까지 동작하지 않음
filter 필터링 (5, 4, 3, 2, 1) >> 4, 2
map 변환 4, 2  >> 16, 4

3) 최종 연산
스트림을 소모하고 결과를 샐성
모든 데이터를 처리한 후 결과를 반환하거나 출략하는 연산
이후 스트림 재사용 불가!!

2. stream API 특징
불변성 : 원본 데이터를 변경하지 않음 새로운 값 반환
자연 처리 : 중간 연산은 실제로 실행되지 않음 최종 연산이 처리됨
일회성 : 스트림은 한 번만 사용 가능
선언형 : 간결한 문법 사용 가능

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class H_Stream {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("정지훈");
        names.add("정은혜 : )");
        names.add("최광섭");
        names.add("손태경 : )");
        names.add("박진영");
        names.add("박진영");

        System.out.println(names);

        Stream<String> streamNames = names.stream();

        // 2. 중간 연산
        // 스트림워크 데이터
        // 스트림 소스에 원하는 기능 사용
        // 전체 스트림을 순회하여 각 키워드는 기능을 수행

        // 스트림 중간 연산 내부의 람다식
        // 스트림 내부의 요소값을 하나씩 매개변수에 담음
        // 구현부에 인자로 해당 매개변수 일치하는 값을 전달하는 경우 메서드 참조 타입

       // streamNames.filter(name -> name.length() >= 3)
      //  streamNames.filter(name -> name + "님");

      // 3. 최종연산
      // 스트림 소모 + 결과 생성
      // forEach: 각 요소의 대해 동작 수행
      // collect: 컬렉션 반환
      // reduce : 모든 요소를 하나의 값으로 줄임
      // count: 요소의 개수를 반환

        // 해당 문자열로 시작 여부를 반환 boolean
        // 해당 문자열 포 함여부를 반환 boolean
      streamNames.filter(name -> name.startsWith("정"))
              .map(name -> name + "님")
           //   .forEach(name -> System.out.println(name));
              .forEach(System.out::println);

      names.stream()
              .filter(name -> name.length() == 3)
              .forEach(System.out::println);

        System.out.println("중복 제거 후 오름차순 정렬하여 출력");
        names.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("총 인원 수 출력");
        long count = names.stream().count();
        System.out.println("총 인원 수 : " + count);

        System.out.println("이름 중 2번째 이후 사람 2명만 출력");
        names.stream()
                .skip(2)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("이름 길이의 합 구하기");
        int totalLength = names.stream()
                .map(name -> name.length())
                // reduce 초기값 합산식
                // reduce 최신값
                // reduce
        .reduce(0, Integer::sum);

        System.out.println("이름 길이 합산: " + totalLength);

        // 7)
        System.out.println("모든 이름을 하나의 문자열로 합치기 콤마 구분");
        String result = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println("합틴 이름들: " + result);

        // 8)
        System.out.println("이름 길이 기준 내림차순 정렬");
        names.stream()
                .sorted()
                .forEach(System.out::println);
      //  System.out.println("이름 길이 기준 내림차순 정렬");

        names.stream()
                // b.length() - a.length() 는 문자열 길이 차이를 이용하여 정렬 순서 경정
                // b가 더 크면 양수
                // >> 더 큰 값을 앞으로 정렬 (양수면 자리바꿈 음수면 a가 먼저 0이면 그대로)
                .sorted((a, b) -> b.length() - a.length())
                .forEach(System.out::println);

        System.out.println("이름을 길이로 그룹화");
        Map<Integer, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(String::length));


        }
    }

