package com.sparta.testlevel1.controller;

import com.sparta.testlevel1.dto.BoardRequestDto;
import com.sparta.testlevel1.entity.Board;
import com.sparta.testlevel1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 메인페이지
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    // 작성하기
    @PostMapping("/api/board")
    public Board createBoard(@RequestBody BoardRequestDto boardrequestDto) {  // Dto로 받아올꺼니까 여기서 Dto작성하러Go
        // 서비스개발하러Go
        return boardService.createBoard(boardrequestDto); // 클라에서 가져온 dto 사용
    }

    //모든 게시글 조회하기
    @GetMapping("/api/board")
    public List<Board> getBoard() {
        return boardService.getBoardList();
    }
    //// 선택 게시글 조회하기
    @GetMapping("/api/board/{id}")
    public Optional<Board> getBoardone(@PathVariable Long id) {
        return boardService.getBoardone(id);
    }

    //수정하기
    @PutMapping("/api/board/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto) {
        return boardService.update(id, boardRequestDto);
    }

    //삭제하기
    @DeleteMapping("/api/board/{id}")
    public Long deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto) {


        return boardService.deleteBoard(id,boardRequestDto.getPassword());
    }


}
