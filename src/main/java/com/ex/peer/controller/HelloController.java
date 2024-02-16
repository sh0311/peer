package com.ex.peer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor //HelloController의 생성자를 자동으로 만들어주도록 하기 위해
public class HelloController {
    @GetMapping
    public String hello(){
        return "Hello peer coaching!";
    }
}
