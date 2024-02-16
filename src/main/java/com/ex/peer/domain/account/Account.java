package com.ex.peer.domain.account;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Account {
    @Id  // pk라서
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto Increment 때문에 사용
    private Long id;

    @Column(length=45)
    private String nickname;

    @Column(length=60)
    private String email;

    @Column(length=60)
    private String password;

    @Builder
    public Account(String nickname, String email,String password){
        this.nickname=nickname;
        this.email=email;
        this.password=password;
    }

}
