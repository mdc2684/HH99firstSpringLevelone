package com.sparta.testlevel1.entity;


import com.sparta.testlevel1.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter  // 눈에는 안보이지만 title.getTitle() 같은 각각 메서드를 모두 만들어줌.
@Entity
@NoArgsConstructor
public class Board extends Timestamped {   // 게시판에 대한 정보를 가지고 있는 클래스, 속성을 가지고있다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY 테이블마다 각각 독립적 ID 부여하겠다.
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;


    public Board(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
        this.author = boardRequestDto.getAuthor();
        this.password = boardRequestDto.getPassword();

    }

    public void update(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
        this.author = boardRequestDto.getAuthor();
        this.password = boardRequestDto.getPassword();
    }
}
