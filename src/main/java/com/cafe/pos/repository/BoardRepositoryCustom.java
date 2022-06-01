package com.cafe.pos.repository;

import com.cafe.pos.dto.BoardSearchDto;
import com.cafe.pos.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {

    Page<Board> getBoardPage(Pageable pageable, BoardSearchDto boardSearchDto);

}
