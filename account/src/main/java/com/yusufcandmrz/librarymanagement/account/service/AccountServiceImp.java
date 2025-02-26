package com.yusufcandmrz.librarymanagement.account.service;

import com.yusufcandmrz.librarymanagement.account.entity.Account;
import com.yusufcandmrz.librarymanagement.account.repository.AccountRepository;
import com.yusufcandmrz.librarymanagement.account.dto.request.AccountCreateRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class AccountServiceImp implements AccountService {

    AccountRepository accountRepository;
    ModelMapper modelMapper;

    @Autowired
    public AccountServiceImp(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Account createAccount(AccountCreateRequest request) {
        Account account = modelMapper.map(request, Account.class);
        return accountRepository.save(account);
    }

    @Override
    public Account readAccountById(UUID id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account did not found"));
    }

    @Override
    public void deleteAccountById(UUID id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account did not found"));
        accountRepository.delete(account);
    }
}
