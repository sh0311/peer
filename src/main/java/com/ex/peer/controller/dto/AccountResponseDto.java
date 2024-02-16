package com.ex.peer.controller.dto;

import com.ex.peer.domain.account.Account;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
public class AccountResponseDto {
    private Long id;
    private String email;
    private String nickname;

    public static AccountResponseDto from(Account entity){
        return new AccountResponseDto(entity.getId(), entity.getEmail(), entity.getNickname());
    }

}

