package com.yusufcandmrz.librarymanagement.account.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yusufcandmrz.librarymanagement.account.entity.Account;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query("SELECT a FROM Account a WHERE a.id = :id AND a.status = Status.ACTIVE")
    public Account findByIdAndActive(@Param("id") UUID id);
}
