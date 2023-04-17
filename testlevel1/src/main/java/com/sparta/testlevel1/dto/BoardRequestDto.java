package com.sparta.testlevel1.dto;

import lombok.Getter;

// entity board는 원본데이터니까 안정성을 위해 바로 쓰지말고 Dto로 따로 저장해서 사용
@Getter
public class BoardRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;
}
