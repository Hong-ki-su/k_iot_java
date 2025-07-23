package org.example.chapter15.c_board_app.repository;

import org.example.chapter15.c_board_app.entity.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoardRepository {
    private final List<Board> boardStorage = new ArrayList<>();
    private Long idSequence = 1L;

    public void save(Board board) {
        board.setId(idSequence++);
        boardStorage.add(board);
    }

    public List<Board> findAll() {
        return new ArrayList<>(boardStorage);
    }

    public Optional<Board> findById(Long id) {
        return boardStorage.stream()
                .filter(board -> board.getId() == id)
                .findFirst();
    }

    public void delete(Long id) {
        // remove
        // 조건에 부합하는 것은 삭제 그렇지 않은 것은 리스트에 남겨둠
        boardStorage.removeIf(board -> board.getId() == id);
    }
}
