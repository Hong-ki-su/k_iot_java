package org.example.chapter12;
/*
=== 도서 관리 시스템

1. 요구 사항 분석
새로운 도서 추가
모든 도서 정보 출력
도서 검색

2. 프로그램 구조
model 도서 정보 당담
book 클래스 : 도서 정보 저장 (제목 저자 출판사 등

view 사용자 인터페이스 UI 당담
BookView 클래스 : 사용자의 입력을 받아 controller에게 전달 & Controller 받은 정보를 출력



 */

import org.example.chapter12.controller.BookController;
import org.example.chapter12.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        //
        List<Book> dummyBooks = new ArrayList<>();
        dummyBooks.add(new Book("java","홍기수","코리아"));
        dummyBooks.add(new Book("java catch","김희성","나이스"));


        BookController controller = new BookController(dummyBooks);
                Scanner sc = new Scanner(System.in);


    }
}
