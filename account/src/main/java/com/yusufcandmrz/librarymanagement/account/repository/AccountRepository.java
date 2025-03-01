package com.yusufcandmrz.librarymanagement.account.repository;

import com.yusufcandmrz.librarymanagement.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
}
