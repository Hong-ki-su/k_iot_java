package org.example.chapter15.c_board_app.entity;

/*
=== entity(실제)
: 현실 서계에서 구별 가능한 개별적인 항복이나 객체를 나타냄
- 객체지향 프로그래밍에서 클래스의 인스턴스로 표현
>> 데이터의 집합

model
: 일반적인 데이터를 표현하고 처리하는 일련의 규칙과 메서드를 정으;하는 부분


계시판
id: 게시판 고유 번호
title; 게시판 제목
content 게시판 내용
author 게시판 작성자
 */

import lombok.Data;

@Data
public class Board {
    private Long id;
    private String title;
    private String content;
    private String author;

    public Board(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
