package com.sparta.testlevel1.repository;

import com.sparta.testlevel1.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //안해도 내부적으로 bean으로 등록 해준다함
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByModifiedAtDesc();


    // cf.   Optional<Board> findByTitle(String title);  "Board에서 title(매개변수)인 것을 찾아주겠다."  이런것도 만들수있음.
}
