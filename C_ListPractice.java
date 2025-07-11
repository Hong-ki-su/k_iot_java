package org.example.chapter10;

// === 이벤트 관리 시스템 === //
// : 이벤트 참가자 명단 & 대기열 관리를 위한 시스템
// - 참가자는 사전 등록된 명단을 통해 이벤트 참가
// - 명단이 가득 찰 경우 대기열 추가, 참가자가 떠나면 대기열의 다음 사람이 추가

// 1) 이벤트 참가자 명단 관리: 사전 등록, 당일 추가 참가자 등록 X
// : ArrayList (목록 추가/삭제 X, 참가자 조회 O)

// 2) 대기열 관리
// : 이벤트의 한정된 좌석, 좌석이 모두 차면 추가 참가자는 대기열에 등록
// : LinkedList (목록 추가/삭제 O, 참가자 조회 X)

import java.util.ArrayList;
import java.util.LinkedList;

class EventManagement {
    ArrayList<String> participantList = new ArrayList<>();
    LinkedList<String> waitingQueue = new LinkedList<>();

    void addParticipant(String name) {
        participantList.add(name);
    }
    void addToWaitingQueue(String name) {
        waitingQueue.add(name);
    }
    void leaveParticipant(String name) {
        if (waitingQueue.size() > 0) {
            String newParticipant = waitingQueue.remove(0);
            addParticipant(newParticipant);
        }
    }

    boolean checkParticipant(String name) {
        return participantList.contains(name);
    }
}

public class C_ListPractice {
    public static void main(String[] args) {
        EventManagement eventManagement = new EventManagement();

        eventManagement.addParticipant("홍기수");
        eventManagement.addParticipant("김채환");
        eventManagement.addParticipant("김건영");
        eventManagement.addParticipant("박성준");
        eventManagement.addParticipant("오제욱");

        eventManagement.addToWaitingQueue("최동욱");
        eventManagement.addToWaitingQueue("김희성");
        eventManagement.addToWaitingQueue("이은우");
        eventManagement.addToWaitingQueue("최현우");

        System.out.println(eventManagement.participantList);
        System.out.println(eventManagement.waitingQueue);

        eventManagement.addToWaitingQueue("이혜지");
        eventManagement.addToWaitingQueue("김준일");

        eventManagement.leaveParticipant("이승아");
        eventManagement.leaveParticipant("조승범");
        eventManagement.leaveParticipant("윤대휘");

        System.out.println(eventManagement.participantList);


        System.out.println(eventManagement.waitingQueue);

        System.out.println(eventManagement.checkParticipant("조승범")); // true
        System.out.println(eventManagement.checkParticipant("최현우")); // false
    }
}


