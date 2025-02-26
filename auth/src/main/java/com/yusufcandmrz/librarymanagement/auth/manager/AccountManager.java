package com.yusufcandmrz.librarymanagement.auth.manager;

import com.yusufcandmrz.librarymanagement.auth.dto.request.AccountCreateRequest;
import com.yusufcandmrz.librarymanagement.auth.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account", url = "http://localhost:8011/account")
public interface AccountManager {

    @PostMapping()
    public ResponseEntity<Account> createAccount(@RequestBody AccountCreateRequest request);
}
