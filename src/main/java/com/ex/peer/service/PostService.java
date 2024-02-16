package com.ex.peer.service;


import com.ex.peer.controller.dto.PostModifyRequestDto;
import com.ex.peer.controller.dto.PostRequestDto;
import com.ex.peer.controller.dto.PostResponseDto;
import com.ex.peer.domain.account.AccountRepository;
import com.ex.peer.domain.post.Post;
import com.ex.peer.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final AccountRepository accountRepository;

    public PostResponseDto createPost(PostRequestDto request){
        return PostResponseDto.from(postRepository.save(Post.builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .account(accountRepository.findById(request.getAccountId()).orElseThrow(()->new IllegalArgumentException("존재하지않는계정입니다")))
                .build())
        );
    }





    public List<PostResponseDto> findPostList(){
        return postRepository.findAll()
                .stream()
                .map(PostResponseDto::from)
                .collect(Collectors.toList());
    }

    public PostResponseDto findPost(Long postId){
        return PostResponseDto.from(
                postRepository.findById(postId)
                        .orElseThrow(()-> new IllegalArgumentException("해당하는 게시글이 없습니다."))
        );
    }

    public PostResponseDto modifyPost(Long postId, PostModifyRequestDto requestDto) {
        Post post=postRepository.findById(postId)
                .orElseThrow(()->new IllegalArgumentException("해당하는 게시글이 없습니다"));
        post.update(requestDto.getTitle(),requestDto.getContents());
        return PostResponseDto.from(postRepository.save(post));

    }

    public void removePost(Long postId) {
        //방법1
        //쿼리1
        /*postRepository.delete(
                //쿼리2
            postRepository.findById(postId).orElseThrow(()->new IllegalArgumentException("해당하는 게시글이 없습니다"))
            );*/

        //방법2
        postRepository.deleteById(postId);
    }

}
