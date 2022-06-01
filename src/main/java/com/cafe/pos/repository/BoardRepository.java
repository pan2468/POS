package com.cafe.pos.repository;


import com.cafe.pos.dto.BoardSearchDto;
import com.cafe.pos.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BoardRepository extends JpaRepository<Board,Long>, QuerydslPredicateExecutor<Board>,BoardRepositoryCustom{

    @Modifying
    @Query("update Board b set b.hit = b.hit + 1 where b.id = :id")
    int updateView(@Param("id") Long id);

    void deleteById(Long id);

}
