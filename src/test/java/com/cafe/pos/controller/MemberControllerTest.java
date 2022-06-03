package com.cafe.pos.controller;

import com.cafe.pos.entity.Member;
import com.cafe.pos.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@TestPropertySource(locations = "classpath:application.properties")
class MemberControllerTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember(String email, String password){
        Member member = new Member();
        member.setUserid("pan5158");
        member.setName("홍길동");
        member.setEmail("test@test.com");
        member.setPassword(password);
        member.setPhone("010-1111-2222");
        return memberService.save(member);
    }

    @Test
    @DisplayName("로그인 성공 테스트")
    public void loginSuccessTest() throws Exception{
        String email = "test@email.com";
        String password = "1234";
        this.createMember(email,password);
        mockMvc.perform(formLogin().userParameter("email")
                .loginProcessingUrl("/")
                .user(email).password(password))
                        .andExpect(SecurityMockMvcResultMatchers.authenticated());
        
//        mockMvc.perform(formLogin().userParameter("email")
//                        .loginProcessingUrl("/members/login")
//                        .user(email).password(password))
//                .andExpect(SecurityMockMvcResultMatchers.authenticated());
    }



}