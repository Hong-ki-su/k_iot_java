package org.example.chapter16;

/*
=== Dto Vo Dao Entity
: 데이터 목적에 따라 정의하는 구조

1) dto : 데이터를 정달하기 위한 객체
2) vo : 값 자체를 표현하는 객체
3) dao : 데이터베이스에 접근하는 역활을 하는 객체
4) entity : 실제 DB 테이블과 매핑되는 클래스
 */

import lombok.*;

import java.util.Date;

// dto
// : 계층간 데이터 교환을 위해 사용하는 객체
// 로직을 가지지 않는 순수한 데이터 객체
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class UserSignInRequestDto {
    private String userId;
    private String password;
}

// vo
// : 특정 값을 표현하는 객체
// - 주로 사용자 주소 이름 좌표 등 도메인에서 의미 있는 값을 표현
// 불변성 : 생성시 내용 변경 불가
@AllArgsConstructor
@Getter
@EqualsAndHashCode
class Address {
    // 데이터 식별 값 필요 없음
    //
    private final String city;
    private final String zipcode;
}

// 3) dao
// : 데이터베이스 접근 객체
// 서비스 모델과 데이터베이스 연결하는 역활
// DB 접근해 crud 작업을 딤당
// 일반적으로 jdbc 또는 jpa mybatis를 통해 구현
// Spring 기반 프로젝트 Repository 또는 Mapper로 대체됨

// jdbc
class UserResponsesDto {
    public UserResponsesDto(String id, String nickname) {
    }

    class UserDto {
        public UserResponsesDto getUserById(String userId) {
            String id = "qwe";
            String nickname = "개구리";

            return new UserResponsesDto(id, nickname);
        }
    }
}

// 4) Entity
// : 실제 데이터 베이스 의 테불릿에 해당하는 데이터 구조 매핑되는 클래스
// jpa 와 같은 ORM 툴에서 사용
// DB 각 레코드와 매핑
@Getter
@Setter
class User {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;
    private Date createdAt;
}

public class D_Data {
    public static void main(String[] args) {

    }
}
