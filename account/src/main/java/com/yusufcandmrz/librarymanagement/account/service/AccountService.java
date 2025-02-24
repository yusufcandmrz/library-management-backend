package com.yusufcandmrz.librarymanagement.account.service;

import com.yusufcandmrz.librarymanagement.account.entity.Account;
import com.yusufcandmrz.librarymanagement.account.dto.request.AccountCreateRequest;

import java.util.UUID;

public interface AccountService {

    public Account createAccount(AccountCreateRequest request);

    public Account readAccountById(UUID id);

    public void deleteAccountById(UUID id);
}
