package com.ex.peer.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmailAndPassword(String Email, String Password); }// Account 못찾을수도 있다.(그럼 account에 빈 객체가 들어가게 됨) 따라서 Oprional 붙여주기(비어있는지 아닌지 확인해줌)
//
