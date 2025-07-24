package org.example.chapter16;

/*
Wrapper 클래스
: 기본 데이터 타입을 객체로 다루기 위해 사용

기본 타입
byte short long int char float double boolean
>> 각 데이터 타입의 해당하는 Wrapper 클래스가 존재

java lang 패키지에 정의
컬렉션 프레임워크에서는 내부에 객체만을 저장
기본 타입을 Wrapper 클래스로 변환하여 저장
>> Integer Character 등

박 & 언박싱
: 기본타입 과 해당 타입의 Wrapper 클래스간의 자동 변환
자바 컴파일러 자동처리

박싱
기본 >> Wrapper 클래스의 객체로 변환

언박싱
Wrapper 클래스의 객체 >> 기본 타입으로 변환

장단점
장점: 기본타입과 객체 타입 간의 호환이 용이
단점:
 */

public class A_Wrapper {
    public static void main(String[] args) {
    int i = 5;
    Integer iObject = i;
        System.out.println(iObject);

        // Wrapper 객체생성 : 객체 타입
        Integer integerValue = Integer.valueOf(15);
        int iValue = integerValue;
        System.out.println(iValue);

        // Wrapper 클래스의 내부 메서드
        // cf) toString() 메서드

        Integer MyInteger = Integer.valueOf(20);

        int myInt = MyInteger.intValue();
        System.out.println(myInt);

        Object obj = Integer.valueOf(100);
      //  int x = obj; - 자동 언박싱 불가 Object 타입은 컴파일 에러
        int x = ((Integer)obj).intValue();

        Integer a = null;
       // int abc = a;
        int abc = (a != null) ? a.intValue() : 0;
        System.out.println(abc);

        // 2) ParseInt(String s): 문자열을 기본 int 타입으로 파싱
        // String >> IntegerIntValue >> int
        int parseIntValue = Integer.parseInt("123");
        System.out.println(parseIntValue);

     //   int parseIntValue2 = Integer.parseInt("abc");

        // 3) a.compareTo(Integer anotherInt)
        // : 두 Integer 객체를 비교하여 같으면 0, 호출 객체 a가 크면은 양수 더 작으면 음수
        Integer anotherInt = Integer.valueOf(20);
        int result = MyInteger.compareTo(anotherInt);
        System.out.println(result);
     }
}
