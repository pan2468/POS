package com.cafe.pos.service;

import com.cafe.pos.entity.Board;
import com.cafe.pos.entity.Member;
import com.cafe.pos.repository.BoardRepository;
import com.cafe.pos.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> boardList(){

        return boardRepository.findAll();
    }

    public Board save(Board board){

        return boardRepository.save(board);
    }

}
