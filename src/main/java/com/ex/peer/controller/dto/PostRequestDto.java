package com.ex.peer.controller.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class PostRequestDto {
    private String title;
    private String contents;
    private Long accountId;}
