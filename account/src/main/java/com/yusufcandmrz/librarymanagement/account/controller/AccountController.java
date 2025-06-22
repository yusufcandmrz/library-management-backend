package com.yusufcandmrz.librarymanagement.account.controller;

import com.yusufcandmrz.librarymanagement.account.dto.request.AccountCreateRequest;
import com.yusufcandmrz.librarymanagement.account.dto.response.AccountDto;
import com.yusufcandmrz.librarymanagement.account.service.AccountService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    AccountService accountService;

    @Autowired
    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping()
    public ResponseEntity<Void> createAccount(@RequestBody AccountCreateRequest request) {
        accountService.createAccount(request);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> readAccountById(@PathVariable UUID id) {
        return new ResponseEntity<AccountDto>(accountService.readAccountById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountById(@PathVariable UUID id) {
        accountService.deleteAccountById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
