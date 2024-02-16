package com.ex.peer.controller;

import com.ex.peer.controller.dto.AccountCreateAccountDto;
import com.ex.peer.controller.dto.AccountResponseDto;
import com.ex.peer.controller.dto.LoginRequestDto;
import com.ex.peer.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    public final AccountService accountService;

    @PostMapping  //생성(등록)
    private AccountResponseDto createAccount(@RequestBody AccountCreateAccountDto request){
        return accountService.createAccount(request);

    }

    @GetMapping  //조회 -> (권장사항 : body 작성하지 않기)
    private List<AccountResponseDto> findAccountList(){
        return accountService.findAccountList();
    }


    /**
     * email
     * password
     * => return :id
     */

    @PostMapping("/login") // 정석적인 로그인 방법은 아님
    private AccountResponseDto login(@RequestBody LoginRequestDto requestDto){
        return accountService.findByEmailAndPassword(requestDto);
    }
}

