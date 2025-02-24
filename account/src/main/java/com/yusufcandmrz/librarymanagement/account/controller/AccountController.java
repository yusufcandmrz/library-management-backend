package com.yusufcandmrz.librarymanagement.account.controller;

import com.yusufcandmrz.librarymanagement.account.entity.Account;
import com.yusufcandmrz.librarymanagement.account.dto.request.AccountCreateRequest;
import com.yusufcandmrz.librarymanagement.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    AccountService accountService;

    @Autowired
    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountCreateRequest request) {
        Account account = accountService.createAccount(request);
        return new ResponseEntity<Account>(account, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> readAccountById(@PathVariable UUID id) {
        Account account = accountService.readAccountById(id);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountById(@PathVariable UUID id) {
        accountService.deleteAccountById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
