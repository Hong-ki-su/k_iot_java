package org.example.chapter15;

/*
=== Optional 클래스는
값이 있을수도 있고 없을수도 있는 객체를 감싸는 컨테이너
null 값을 다룰때 발생하는 NullPointException 방지
null 체크를 명시적으로 안전하게 처리
함수형 프로그래밍
 */

import java.util.Optional;

class Person {
    String name;
}

public class E_Optional {
    static String findNameById(int id) {
        return null; // 실제 DB나 Map에서 검색 과정 >>
    }
    public static void main(String[] args) {
      String name = null;
     //   System.out.println(name.length());

        Person p = null;
      //   System.out.println(p.name);

        String[] arr = new String[3];
        arr[0] = "abc";
        // arr[1] arr[2]
       // System.out.println();

        String result = findNameById(123);
      //  System.out.println(result.toUpperCase());

        // 1. Optional 클래스
        // : null 아닌 값을 포함하거나 값이 상태를 나타낼수 없음
        // - 값을 명시적으로 검사하고 처리하는 방식

        // Optional 생성방법
        // Optional.of(T-value): null이 아닌 값을 감쌈
       // Optional<String> optional0 = Optional.of(null);
        Optional<String> optional1 = Optional.of("Hello Optional!");

        // Optional.ofNullable(T-value): null 여부 상관없이 optional 생성
        Optional<String> optional2 = Optional.ofNullable(null);

        // Optional.empty(): 비어있는 Optional 생성
        Optional<String> optional3 = Optional.empty();

        // 3. Optional 값 확인 메서드
        // 1) isPresent(); 값이 공개하면 true 존재하지 않을 경우 false
        // 2) isEmpty: 값이 존재하여 false 존재하지 않을 경우
        System.out.println(optional1.isPresent());
        System.out.println(optional1.isEmpty());

        System.out.println(optional2.isPresent());
        System.out.println(optional2.isEmpty());

        // 4. Optional에서 값 추출메서드
        // get()
        // 값이 없는 상태 null 에서 호출 시 예외 발생
        System.out.println(optional1.get());
     //   System.out.println(optional2.get());

        // 5. Optional 기본값 처리
        // >> 값을 확인하고 존재하며 반환 존재하지 않으면 (빈 Optional) 예외처리
        // 1) .orElse(T Other)
        // 2) .orElseGet(Supplier<T>): 값이 없을 경우 함수형 인터페이스로 값을 생성하여 반환
        // 3) .orElseThrow(Supplier<Throwable>)

        // cf) Supplier<T>: 공급하다
        // - T 타임의 값을 생성하여 반환

        System.out.println(optional2.orElse("기본값 반환"));
        System.out.println(optional2.orElseGet(() -> "값을 생성하여 반환"));

        try {
            // throwable >> Exception 예외 Erro 오류
            optional3.orElseThrow(() -> new Error("값이 없을 경우 예외 발생"));
       // optional3.orElseThrow(() -> new Error("값이 없을 경우 예외 발생"));
        } catch (Error e) {
            System.out.println("에외가 발생했습니다: " + e.getMessage());
        }

        System.out.println("정상적인 코드 흐름");

        // Optional 사용 시 주의사항
        // 1) 필드에 사용 X
        // 2) 메서드 매개변수로 사용 X
        // >> 반환값으로 사용
        // 3) 값이
    }
}
