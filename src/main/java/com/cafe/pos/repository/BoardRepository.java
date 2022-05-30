package com.cafe.pos.repository;

import com.cafe.pos.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board,Long> {

    @Modifying
    @Query("update Board b set b.hit = b.hit + 1 where b.id = :id")
    int updateView(Long id);

    void deleteById(Long id);



}
