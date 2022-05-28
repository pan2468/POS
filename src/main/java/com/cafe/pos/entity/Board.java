package com.cafe.pos.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "board")
@Getter
@Setter
@ToString
public class Board {

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @NotNull
    @Size(min=2,max = 30, message = "제목은 2자이상 30자 이하입니다.")
    private String title;
    private String content;


    private LocalDate regTime;

    private int hit;

//    public void updateItem(BoardFormDto boardFormDto){
//        this.id = boardFormDto.getId();
//        this.username = boardFormDto.getUsername();
//        this.title = boardFormDto.getTitle();
//        this.content = boardFormDto.getContent();
//        this.regTime = boardFormDto.getRegTime();
//        this.hit = boardFormDto.getHit();
//    }

}
