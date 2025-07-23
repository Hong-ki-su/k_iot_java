package org.example.chapter15.c_board_app.controller;

import org.example.chapter15.c_board_app.dto.BoardRequestDto;
import org.example.chapter15.c_board_app.dto.BoardResponseDto;
import org.example.chapter15.c_board_app.service.BoardService;

import java.util.List;

public class BoardController {
    private final BoardService boardService;

    public BoardController() {
        this.boardService = new BoardController();

        public void createBoard(BoardRequestDto dto) {
            if (isValidRequest(dto)) {
             boardService.createdBoard(dto);
                System.out.println("개시글이 등록되었습니다");
            } else {
                System.out.println("입력값이 유효하지 않습니다");
            }
        }

        public boardResponseDto getBoardById(Long id) {
            BoardResponseDto dto = null;

            try {
                dto = boardService.findBoardById(id)
            }
            return dto;
        }

        public void updateBoard(Long id, BoardRequestDto dto) {
            if (isVaildRequest(dto)) {
                boardService.updateBoard(id, dto);
                System.out.println("게시글이 수정되엇습니다");
            } else {
                System.out.println("입력값이 유효하지 않습니다);
            }
        }

        public List<BoardResponseDto> getAllBoards () {
            List<BoardRespo>
        }

        public boolean isVaildRequst(BoardRequestDto dto) {
            String title = dto.getTitle();
            String content = dto.getContent();
            String author = dto.getAuthor();

            boolean result = title != null && !title.isEmpty()
                    && content != null && !content.isEmpty()
                    && author != null && !author.isEmpty();

            return result;
        }
    }
}
