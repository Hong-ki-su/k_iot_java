package org.example.chapter15.c_board_app.dto;

// DB

import org.example.chapter15.c_board_app.entity.Board;




public class BoardResponseDto {
    private Long id;
    private String title;
    private String author;

    public BoardResponseDto(Board board) {
        this.id = board,getId();
        this.title = board.getTitle();
        this.author = board.getAuthor();
    }
    public static BoardRespondeDto fromEntity(Board board) {

}
