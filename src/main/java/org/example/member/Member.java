package org.example.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder@AllArgsConstructor@NoArgsConstructor
public class Member {

    //사용자 정의
    //사용자는 아이디, 비밀번호, 닉네임, 이름, 권한(목록)을 가진다

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String account;

    private String password;
    private String nickname;
    private String name;

    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Default
    private List<Authority> roles = new ArrayList<>();

    public void setRoles(List<Authority> role){
        this.roles = role;
        role.forEach(o -> o.setMember(this));
    }

}
