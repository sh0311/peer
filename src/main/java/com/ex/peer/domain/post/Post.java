package com.ex.peer.domain.post;

import com.ex.peer.domain.account.Account;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 *
 * 1. PostRepository 생성
 * 2. PostRepository를 final Service
 * 3. Controller "/posts"
 * 4. 3번에서 만든 Controller에서 "posts" Post 생성하는 API
 */
@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String contents;

    @ManyToOne
    @JoinColumn(name="account")
    private Account account;

    @Builder
    public Post(String title,String contents, Account account){
        this.title=title;
        this.contents=contents;
        this.account=account;
    }


    public void update(String title, String contents) {
        this.title=title;
        this.contents=contents;
    }
}