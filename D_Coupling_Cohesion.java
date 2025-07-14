package org.example.chapter11;

/*
=== 결합도 VS 응집도
모듈
소프트웨어 각 기능별로 나눈 소스 단위
모듈화 : 하나의 큰 소프트웨어 분리시키는 과정

줄은 소프트웨어 일수록 모듈의 독립성이 높다
>> 모듈의 독립성

1. 결합도 (낮은 결합도)
: 두개의 클래스나 모듈이 얼마나 강하게 연결되어 있는지 나타냄
모듈과 모듈 간의 의존도

- 낮은 결합도 : 두 모듈이 서로 독립적으로 동작
- 높은 결합도 : 두 모듈이 서로 얽혀져 동작

2. 응집도
: 하나의 클래스나 모듈 안에서 관련된 작업들끼리 얼마나 잘 모여 있는지를 나타냄
>> 한 모듈 내의 구성 요소들 연관성

- 낮은 응집도: 하나의 클래스가 너무 많은 일을 하거나 관련 없는 일을 하는 것
- 높은 응집도 : 하나의 클래스가 관련된 일들만 하고 해당 일을 잘 명시

>> 높은 응집도
: 낮은 결합도 + 높은 결합도
>> 각 클래스나 모듈이 독립적으로 동작 + 본인의 역활에 충실
>> 각 클래스 간의 의존성을 줄이고 변경에 강한 구조를 작성
 */

// 1.


        interface Teacher {
            void teach();
        }
        class KoreaTeacher implements Teacher {
            @Override
            public void teach() {
                System.out.println("국어 선생님은 국어를 가르칩니다 ");
            }
        }

        class MathTeacher implements Teacher {
            @Override
            public void teach() {
                System.out.println("수학 선생님은 수학을 가르칩니다 ");
            }
        }

        class ClassRoom {
            private Teacher teacher;

            public ClassRoom(Teacher teacher) {
                this.teacher = teacher;
            }

            public void StartClass() {
                teacher.teach();
            }
        }

        // 2
class StudentCohesion {
            private String name;

            public StudentCohesion(String name) {
                this.name = name;
            }
            public String getName() {return name;}
        }
        class Attendance {
            public void checkAttendance(Teacher teacher, StudentCohesion studentCohesion) {
                System.out.println(studentCohesion.getName() + "학생이 출석하였습니다");
                teacher.teach();
            }
        }

        // 의존성 주의
 // : 객체가 필요한 의존 객체를 직젖 생성하지 않고
// : 결합도 모아짐
// : 테스트 정의



       // 제어의 역전
// : 객체의 생성과 관리를 개발자가 아닌 외부 컨테이너 담당하게 하는 구조
// : 개발자가 객체를 생성하는 것이 아니라 프레임워크가 대신 처리 해주는곳
// : IOC 컨테이너가 해당 역활 담당
public class D_Coupling_Cohesion {
    public static void main(String[] args) {
        Teacher KoreanTeacher = new KoreaTeacher();
        Teacher mathTeacher = new MathTeacher();

        // ClassRoom이 교사 객체를 직접 생성하지 않는 외부에서 주입
        // classRoom이
        ClassRoom koreanClass = new ClassRoom(KoreanTeacher);
        ClassRoom MathClass = new ClassRoom(mathTeacher);

        StudentCohesion student = new StudentCohesion("홍기수");
        Attendance attendance = new Attendance();
        attendance.checkAttendance(mathTeacher,student);
    }
}
