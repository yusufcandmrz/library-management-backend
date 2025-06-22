package com.yusufcandmrz.librarymanagement.account.service.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusufcandmrz.librarymanagement.account.dto.response.AccountDto;
import com.yusufcandmrz.librarymanagement.account.entity.Account;
import com.yusufcandmrz.librarymanagement.account.entity.Status;
import com.yusufcandmrz.librarymanagement.account.repository.AccountRepository;
import com.yusufcandmrz.librarymanagement.account.dto.request.AccountCreateRequest;
import com.yusufcandmrz.librarymanagement.account.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImp implements AccountService {

    AccountRepository accountRepository;
    ModelMapper modelMapper;
    ObjectMapper objectMapper;

    @Autowired
    public AccountServiceImp(AccountRepository accountRepository, ModelMapper modelMapper, ObjectMapper objectMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
    }

    public void createAccount(AccountCreateRequest request) {
        Account account = modelMapper.map(request, Account.class);
        accountRepository.save(account);
    }

    @Override
    public AccountDto readAccountById(UUID id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account did not found"));
        return convertToDto(account);
    }

    @Override
    public void deleteAccountById(UUID id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account did not found"));
        account.setStatus(Status.INACTIVE);
        accountRepository.save(account);
    }

    private AccountDto convertToDto(Account account) {
        return modelMapper.map(account, AccountDto.class);
    }

    /* @KafkaListener(topics = "auth.topics", groupId = "auth.groupId")
    public void authKafkaConsumer(String message) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(message);
        if ("AUTH_REGISTERED".equals(jsonNode.get("event").asText())) {
            UUID id = UUID.fromString(jsonNode.get("id").asText());
            String email = jsonNode.get("email").asText();
            System.out.println("USER REGISTERED -> id: " + id + ", email: " + email);
        }
    } */
}
