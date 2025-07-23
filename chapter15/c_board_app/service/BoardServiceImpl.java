package org.example.chapter15.c_board_app.service;

import org.example.chapter15.c_board_app.dto.BoardRequestDto;
import org.example.chapter15.c_board_app.dto.BoardResponseDto;
import org.example.chapter15.c_board_app.entity.Board;
import org.example.chapter15.c_board_app.repository.BoardRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BoardServiceImpl implements BoardService{
    private final BoardRepository repository;

    public BoardServiceImpl() {
        super();
    }

    @Override
    public void  createBoard(BoardRequestDto dto) {
        List<Board> boardList = repository.findAll();

        List<BoardResponseDto> boardResponseDtos = boardList.stream()
                .map(BoardResponseDto::fromEntity)
                .collect(Collectors.toList());

        return boardResponseDtos;
    }

    @Override
    public BoardResponseDto findBoardByIda(Long id) {
        Optional<Board> board = repository.findById();
    }

    @Override
    public void updateBoard(long id, BoardRequestDto dto) {
        Board existingBoard = repository.findById(id)
                .orElsethrow(() -> new IllegalAccessException("해당 id의 게시글을 찾을 수 없습니다"))

                existingBoard.setTitle(dto.getTitle())
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
