package com.cafe.pos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Getter @Setter
public class BoardFormDto {

    private Long id;

    @NotBlank(message = "이름을 입력해주세요.")
    private String username;

    @NotNull
    @Size(min=2,max = 30, message = "제목은 2자이상 30자 이하입니다.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regTime;

    private int hit;

}
