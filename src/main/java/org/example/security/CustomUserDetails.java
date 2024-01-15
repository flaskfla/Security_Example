package org.example.security;

import org.example.member.Member;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
    //Spring Security는 유저 인증과정에서 UserDetails를 참조하여 인증
    //UserDetails를 상속하여 DB위에서 선언한 사용자 정보 토대로 인증
    private final Member member;

    public CustomUserDetails(Member member){
        this.member = member;
    }
    public final Member getMember(){
        return member;
    }
    @Override
    public String getPassword(){
        return member.getPassword();
    }
}
