package com.cafe.pos.config;

//import com.cafe.pos.service.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.sql.DataSource;


//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {

//    @Autowired
//    MemberService memberService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.formLogin()
//                .loginPage("/member/login")
//                .defaultSuccessUrl("/")
//                .usernameParameter("email")
//                .failureUrl("/member/login/error")
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
//                .logoutSuccessUrl("/");
//
//        http.authorizeRequests()
//                .mvcMatchers("/","/member/**").permitAll()
//                .mvcMatchers("/signup/**").hasRole("ADMIN")
//                .anyRequest().authenticated();
//
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(memberService)
//                .passwordEncoder(passwordEncoder());
//    }


}
