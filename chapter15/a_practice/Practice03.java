package org.example.chapter15.a_practice;

// Optional 예시: 사용자 조회


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

;

public class Practice03 {
    @AllArgsConstructor
    @Getter
    static class User {
        private String id;
        private String name;
    }

    static class UserRepository {
        private final Map<String, User> userDb = new HashMap<>();

        public UserRepository() {
            userDb.put("user01", new User("User01","홍기수"));
            userDb.put("user02", new User("User02","이승아"));
        }
        public Optional<User> findById(String id) {
            return Optional.ofNullable(userDb.get(id));
        }
    }

    public static void main(String[] args) {
        UserRepository repo = new UserRepository();

        Optional<User> user1 = repo.findById("user01");
        user1.ifPresent(u -> System.out.println("사용자 이름: " + u.getName()));

        User user2 = repo.findById("user00").orElse(new User("default", "기본 사용자"));
        System.out.println("사용자 이름: " + user2.getName());

        User user3 = repo.findById("user99").orElseGet(() -> new User("temp", "임시 사용자"));
        System.out.println("사용자 이름: " + user3.getName());

        try {
            User user4 = repo.findById("user404")
                    .orElseThrow(() -> new Exception("사용자를 찾을수 없습니다"));
        } catch (Exception e) {
            System.out.println("예외");
        }
    }
}
