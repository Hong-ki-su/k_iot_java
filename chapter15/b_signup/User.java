package org.example.chapter15.b_signup;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private Long id; // 사용자 데이터의 구분값 - 데이터 저장소에
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String nickname;
    private String signUpDate;
}
