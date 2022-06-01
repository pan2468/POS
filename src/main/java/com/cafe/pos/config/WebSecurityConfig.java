package com.cafe.pos.config;

import com.cafe.pos.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired MemberService memberService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
                http
                    .authorizeRequests() // 6
                    .antMatchers("/member/login", "/board/list","/css/**").permitAll() // 누구나 접근 허용
                    .antMatchers("/admin").hasRole("ADMIN") // ADMIN만 접근 가능
                .and()
                    .formLogin() // 7
                    .loginPage("/member/login") // 로그인 페이지 링크
                    .defaultSuccessUrl("/board/list") // 로그인 성공 후 리다이렉트 주소
                .and()
                    .logout() // 8
                    .logoutSuccessUrl("/member/login") // 로그아웃 성공시 리다이렉트 주소
                    .invalidateHttpSession(true) // 세션 날리기
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }




}
