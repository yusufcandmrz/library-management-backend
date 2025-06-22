package com.yusufcandmrz.librarymanagement.account.service;

import com.yusufcandmrz.librarymanagement.account.dto.request.AccountCreateRequest;
import com.yusufcandmrz.librarymanagement.account.dto.response.AccountDto;

import java.util.UUID;

public interface AccountService {

    public void createAccount(AccountCreateRequest request);

    public AccountDto readAccountById(UUID id);

    public void deleteAccountById(UUID id);
}
