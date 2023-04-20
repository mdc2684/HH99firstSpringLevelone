package com.sparta.testlevel1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@Entity(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z]).{4,10}" , message = "영문자와 숫자로 이루어진 4~10자여야합니다 ")
    private String username;

    @Column(nullable = false)
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z]).{8,15}")
    private String password;

    public User(String username, String password) { // 초기화
        this.username = username;
        this.password = password;

    }

}
