package com.yusufcandmrz.librarymanagement.auth.repository;

import com.yusufcandmrz.librarymanagement.auth.dto.request.LoginRequest;
import com.yusufcandmrz.librarymanagement.auth.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthRepository extends JpaRepository<Auth, UUID> {

    public Boolean existsByUsername(String username);

    public Boolean existsByUsernameAndPassword(String username, String password);
}