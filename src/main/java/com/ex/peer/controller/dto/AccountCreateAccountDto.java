package com.ex.peer.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class AccountCreateAccountDto {
    private String email;
    private String nickname;
    private String password;
}
