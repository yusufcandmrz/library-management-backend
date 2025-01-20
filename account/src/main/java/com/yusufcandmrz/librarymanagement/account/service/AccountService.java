package com.yusufcandmrz.librarymanagement.account.service;

import com.yusufcandmrz.librarymanagement.account.entity.Account;
import com.yusufcandmrz.librarymanagement.account.request.AccountCreateRequest;
import com.yusufcandmrz.librarymanagement.account.request.AccountUpdateRequest;

import java.util.UUID;

public interface AccountService {

    public Account createAccount(AccountCreateRequest accountCreateRequest);
    public Account readAccountById(UUID id);
    public Account updateAccount(AccountUpdateRequest accountUpdateRequest);
    public void deleteAccountById(UUID id);
}
