package com.sparta.testlevel1.service;

import com.sparta.testlevel1.dto.BoardRequestDto;
import com.sparta.testlevel1.entity.Board;
import com.sparta.testlevel1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Repository 데이터베이스에 잘 연결해주면되는 역할

@Service //전부 비지니스로직?을 수행하는 Bean(객체)로 등록,
@RequiredArgsConstructor // final 찾아서 주입
public class BoardService {

    //데이터베이스와 연결을 해야하기 때문에 BoardRepository를 사용할수있도록 추가
    private final BoardRepository boardRepository;

    @Transactional  //?
    public Board createBoard(BoardRequestDto boardRequestDto) {
        // 데이터베이스 연결해서 저장하려면 Board클래스를 인스턴스로 만들어서 그 값을 사용해서 저장해야한다.
        Board board = new Board(boardRequestDto);
        boardRepository.save(board);
        // save()를 사용해서 board인스턴스를 넣어주면 자동으로쿼리가 생성되면서 데이터베이스에 연결되며 저장이된다.
        return board;  //return 게시글 작성 성공.
    }


    public List<Board> getBoardList() {
        //최근순서로하기위해 repository로가서 findAllByOrderByModifiedAtDesc()메서드만들기
        return boardRepository.findAllByOrderByModifiedAtDesc();

    }

    @Transactional
    public Board update(Long id, BoardRequestDto boardRequestDto) {
        // 수정할 데이터가 존재하는지 확인하는 과정 먼저 필요
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        if (board.getPassword().equals(boardRequestDto.getPassword())) {
            board.update(boardRequestDto);
            return board;
        } else {
            return board;  // 타입은 Board인데 비밀번호가 다를때 클라에게 메시지를 어떻게 보낼수있을까
        }
    }

    @Transactional
    public String deleteBoard(Long id, String password) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        if (board.getPassword().equals(password)) {
            boardRepository.deleteById(id);
            return "성공적으로 삭제했습니다.";

        } else {
            return "비밀번호가다릅니다";
        }
    }

    // 게시글 하나만 조회하기
    @Transactional
    public Optional<Board> getBoardone(Long id) {
        return boardRepository.findById(id); // (id) -> 클라에서 받아온 id

    }
}
