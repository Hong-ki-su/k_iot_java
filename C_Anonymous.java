package org.example.chapter14;

// 성적 계산

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class Student {
    private String name;
    private int score;
}

// interface
interface Grading {
    String calculateGrade(Student student);
}

public class C_Anonymous {
    public static void main(String[] args) {
      Student student1 = new Student("홍기수",90);
      Student student2 = new Student("김희성",95);
      Student student3 = new Student("김채환",80);
      Student student4 = new Student("최동욱",70);
      Student student5 = new Student("김건영",60);
      Student student6 = new Student("오제욱",50);

      Student[] students = { student1, student2, student3, student4, student5, student6};

      Grading grading = new Grading() {
          @Override
          public String calculateGrade(Student student) {
              int score = student.getScore();

              if(score > 100 || score < 0) {
                  System.out.println("잘못된 점수입니다");
                  return null;
              } else if (score >= 90) {
                  return "A";
              }  else if (score >= 80) {
                  return "B";
              }  else if (score >= 70) {
                 return "C";
              }  else if (score >= 60) {
                 return "D";
              }  else if (score >= 50) {
                 return "F";
              }

              return "";
          }
      };
      for (Student s: students) {
          String grade = grading.calculateGrade(s);

          if (grade != null) {
              System.out.println(s.getName() + "의 성적: " + grade);
          }
      }
    }
}
