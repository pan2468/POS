package com.cafe.pos.controller;

import com.cafe.pos.entity.Board;
import com.cafe.pos.entity.Member;
import com.cafe.pos.repository.MemberRepository;
import com.cafe.pos.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

     private final MemberService memberService;
     private final MemberRepository memberRepository;

    @GetMapping("/login")
    public String login(){ // 로그인 페이지

        return "member/memberLoginForm";
    }

//    @PostMapping("/login")
//    public String loginProcess(){
//        return "board/list";
//    }

    @GetMapping("/sign")
    public String sign(Member member){ // 회원 가입 페이지

        return "member/sign_up";
    }


    @PostMapping("/admin")
    public String sign_up(Member member){ // 회원 가입 후
        member.setJoinDate(LocalDate.now());
        memberService.save(member);
        return "redirect:/member/admin";
    }

    @GetMapping("/admin")
    public String admin(Model model){ //관리자 페이지지

        List<Member> members = memberService.adminList();

        model.addAttribute("members",members);

        return "member/admin";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg","아이디 또는 비밀번호를 확인해주세요.");
        return "member/memberLoginForm";
    }



}
