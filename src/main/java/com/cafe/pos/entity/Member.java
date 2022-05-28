package com.cafe.pos.entity;

import com.cafe.pos.constant.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "member")
@Getter @Setter
@ToString
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userid;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String phone;

    private LocalDate joinDate;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

}
