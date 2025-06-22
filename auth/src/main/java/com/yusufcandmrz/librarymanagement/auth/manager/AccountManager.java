package com.yusufcandmrz.librarymanagement.auth.manager;

import com.yusufcandmrz.librarymanagement.auth.dto.request.AccountCreateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account", url = "http://localhost:8011/account")
public interface AccountManager {

    @PostMapping()
    public void createAccount(@RequestBody AccountCreateRequest request);
}
