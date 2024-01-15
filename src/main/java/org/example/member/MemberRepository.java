package org.example.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //사용자를 조회하기 위한 Repository
    //account를 이용하여 조회
    Optional<Member> findByAccount(String account);




}
