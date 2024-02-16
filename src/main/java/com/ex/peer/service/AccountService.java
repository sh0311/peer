package com.ex.peer.service;

import com.ex.peer.controller.dto.AccountCreateAccountDto;
import com.ex.peer.controller.dto.AccountResponseDto;
import com.ex.peer.controller.dto.LoginRequestDto;
import com.ex.peer.domain.account.Account;
import com.ex.peer.domain.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountResponseDto createAccount(AccountCreateAccountDto request) {
        Account account = accountRepository.save(Account.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password((request.getPassword()))
                .build());
        return AccountResponseDto.from(account);
    }


    public List<AccountResponseDto> findAccountList() {
        return accountRepository.findAll()
                .stream()
                .map(AccountResponseDto::from)
                .collect(Collectors.toList()); // select * from account
    }



    public AccountResponseDto findByEmailAndPassword(LoginRequestDto requestDto){
        return AccountResponseDto.from(
                accountRepository.findByEmailAndPassword(requestDto.getEmail(), requestDto.getPassword())
                .orElseThrow(()->new IllegalArgumentException("이메일과 패스워드가 일치하지 않습니다"))); // 못찾으면 던진다
    }
}

