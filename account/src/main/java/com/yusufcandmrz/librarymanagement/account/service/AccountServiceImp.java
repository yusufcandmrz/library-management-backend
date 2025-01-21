package com.yusufcandmrz.librarymanagement.account.service;

import com.yusufcandmrz.librarymanagement.account.entity.Account;
import com.yusufcandmrz.librarymanagement.account.repository.AccountRepository;
import com.yusufcandmrz.librarymanagement.account.request.AccountCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImp implements AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(AccountCreateRequest request) {
        if (!request.isPasswordMatch()) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        Account account = new Account();
        account.setFirstName(request.getFirstName());
        account.setLastName(request.getLastName());
        account.setEmail(request.getEmail());
        account.setPassword(request.getPassword());
        account.setRole(request.getRole());
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        account.setCreatedAt(currentTime);
        account.setUpdatedAt(currentTime);
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
