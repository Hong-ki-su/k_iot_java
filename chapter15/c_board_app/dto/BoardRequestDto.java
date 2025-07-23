package org.example.chapter15.c_board_app.dto;

// BoardRequestDto

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.example.chapter15.c_board_app.entity.Board;

@AllArgsConstructor
@Getter
@ToString
public class BoardRequestDto {
    private String title;
    private String content;
    private String author;

    public Board toEntity() {
        return new Board(title, content, author);
    }
}
