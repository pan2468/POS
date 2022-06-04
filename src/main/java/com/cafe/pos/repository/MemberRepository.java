package com.cafe.pos.repository;

import com.cafe.pos.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

     Member findByEmail(String email);

    //Member findByEmailOrPassword(String email, String password);

    //Member findByUserid(String userid);

    //Member findByUseridOrPassword(String userid, String password);



}
