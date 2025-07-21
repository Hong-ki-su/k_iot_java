package org.example.chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class School {
    private String schoolName;

    // 내부 클래스 - 학생
    @AllArgsConstructor
    class Student {
        private int studentId;
        private String studentName;

        public void displayInfo() {
            System.out.println("학교명: " + schoolName + ", 학생 이름: " + studentName);
        }
    }

    //
    static class Principal {
        private static Principal instance;

        private Principal() {}

        public static Principal getInstance() {
            if (instance == null) {
                instance = new Principal();
            }
            return instance;
        }

        public void displayInfo() {
            System.out.println("훈화 말씀: 공부 열심히 밥 잘 먹고 일찍 자고 알어나기");
        }
    }
}

public class B_Inner {
    public static void main(String[] args) {
        School school = new School("유성초등학교");

        School.Student student1 = school.new Student(43,"홍기수");
        student1.displayInfo();

        School.Principal principal = School.Principal.getInstance();

        principal.displayInfo();
    }
}
