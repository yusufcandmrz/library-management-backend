package com.yusufcandmrz.librarymanagement.account.controller;

import com.yusufcandmrz.librarymanagement.account.entity.Account;
import com.yusufcandmrz.librarymanagement.account.request.AccountCreateRequest;
import com.yusufcandmrz.librarymanagement.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {

    AccountService accountService;

    @Autowired
    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public Account createAccount(AccountCreateRequest request) {
        return accountService.createAccount(request);
    }
}
