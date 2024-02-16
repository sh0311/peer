package com.ex.peer.controller.dto;

import com.ex.peer.domain.post.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class PostResponseDto {
    private Long postId;
    private String title;
    private String contents;
    private AccountResponseDto account;

    public static PostResponseDto from(Post post){
        return new PostResponseDto(
                post.getId(), post.getTitle(), post.getContents(), AccountResponseDto.from(post.getAccount())
        );

    }
}

