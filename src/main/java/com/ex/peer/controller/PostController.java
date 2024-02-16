package com.ex.peer.controller;

import com.ex.peer.controller.dto.PostModifyRequestDto;
import com.ex.peer.controller.dto.PostRequestDto;
import com.ex.peer.controller.dto.PostResponseDto;
import com.ex.peer.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    private PostResponseDto createPost(@RequestBody PostRequestDto request){
        return postService.createPost(request);
    }

    /**
     * 6회차 시작
     * 1) /posts 전체조회 get
     * 2) /posts 개별조회 get
     */


    @GetMapping("/all")
    public List<PostResponseDto> findPostList(){
        return postService.findPostList();  //post 2
    }



    @GetMapping("/{postId}")
    public PostResponseDto findPost(@PathVariable Long postId){
        return postService.findPost(postId);  //post2
    }

    @PutMapping("/{postId}")
    public PostResponseDto modifyPost(@PathVariable Long postId, @RequestBody PostModifyRequestDto requestDto){
        return  postService.modifyPost(postId, requestDto);

    }

    @DeleteMapping("/{postId}")
    public String removePost(@PathVariable Long postId){
        postService.removePost(postId);
        return "정상적으로 삭제되었습니다.";
    }
}
