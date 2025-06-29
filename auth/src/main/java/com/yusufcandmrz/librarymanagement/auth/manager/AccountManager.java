package com.yusufcandmrz.librarymanagement.auth.manager;

import com.yusufcandmrz.librarymanagement.auth.dto.request.AccountCreateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "account", url = "http://localhost:8011/account")
public interface AccountManager {

    @PostMapping()
    public void createAccount(@RequestBody AccountCreateRequest request);

    @DeleteMapping("/{id}")
    public void deleteAccountById(@PathVariable UUID id);
}
