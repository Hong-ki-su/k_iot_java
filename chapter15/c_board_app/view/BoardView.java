package org.example.chapter15.c_board_app.view;

import org.example.chapter15.c_board_app.controller.BoardController;
import org.example.chapter15.c_board_app.dto.BoardRequestDto;
import org.example.chapter15.c_board_app.dto.BoardResponseDto;

import java.util.List;
import java.util.Scanner;

public class BoardView {
    public static void main(String[] args) {
        BoardController boardController = new BoardController();
        Scanner sc = new Scanner(System.in);

        While(true) {
            try {
                System.out.println("1. 게시글 등록");
                System.out.println("2.게시글 전체 조회");
                System.out.println("3. 게시글 단건 조회");
                System.out.println("4. 게시글 수정");
                System.out.println("5. 게시글 삭제");
                System.out.println("0. 프로그램 종료");

                System.out.println("메뉴를 선택해주세요");


                case 1: {
                    System.out.println("게시글 등록(제목, 내용, 작성자를 입력해주세요");

                    System.out.println("제목: ");
                    String title = sc.nextLine();
                    System.out.println("내용: ");
                    String content = sc.nextLine();
                    System.out.println("작성자: ");
                    String author = sc.nextLine();
                }
                case 2: {
                    System.out.println("게시글 전체 조회");
                    List<BoardResponseDto> dtos = boardController.getAllBoards();
                    dtos.forEach(System.out::println);
                }
                case 3: {
                    System.out.println("게시글 단건 조회");
                    System.out.println("조회할 ");
                }
                case 4: {
                    System.out.println("게시글 등록(제목, 내용, 작성자를 입력해주세요");

                    System.out.println("수정할 게시글 ID: ");
                    Long updatedId = sc.nextLong();
                    sc.nextLine();

                    System.out.println("새 제목: ");
                    String title = sc.nextLine();
                    System.out.println("새 내용: ");
                    String content = sc.nextLine();

                    BoardRequestDto dto = new BoardRequestDto(title, content, "수정은 작성자 X");
                    boardController.

                }
                case 5: {
                    System.out.println("게시글 삭제");
                    System.out.println("삭제할 게시글 ID");
                    Long id = sc.nextLong();
                    break;
                }
                case 0:
                    System.out.println("프로그램 종료합니다");
                    sc.close();



            } catch (IllegalArgumentException e) {
                System.out.println("id값을 확인해주세요 " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
