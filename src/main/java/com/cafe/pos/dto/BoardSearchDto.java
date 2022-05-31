package com.cafe.pos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardSearchDto {

    private String type;

    private String keyword; //입력

    private String searchBy;    //검색조건

    private String searchQuery = "";  //검색어 입력

}
