package org.example.chapter15.c_board_app.service;

import org.example.chapter15.c_board_app.dto.BoardRequestDto;
import org.example.chapter15.c_board_app.dto.BoardResponseDto;

import java.util.List;

public interface BoardService {
    void createdBoard(BoardRequestDto board);

    List<BoardResponseDto> findAllBoards();

    BoardResponseDto findBoardById(Long id);

    void updateBoard(Long)

    void deleteBoard(Long id);
}
