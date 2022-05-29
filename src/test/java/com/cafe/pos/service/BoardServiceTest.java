package com.cafe.pos.service;

import com.cafe.pos.dto.BoardFormDto;
import com.cafe.pos.entity.Board;
import com.cafe.pos.repository.BoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class BoardServiceTest {

    @Autowired
    BoardService boardService;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Autowired
    BoardRepository boardRepository;

//    @Test
//    @DisplayName("등록 테스트")
//     public Board save() throws Exception{
//        Board board = new Board();
//
//        board.setUsername("이름");
//        board.setTitle("제목");
//        board.setContent("내용");
//        board.setRegTime(LocalDateTime.now());
//
//        return boardRepository.save(board);
//    }


}