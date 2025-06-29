package com.yusufcandmrz.librarymanagement.auth.repository;

import com.yusufcandmrz.librarymanagement.auth.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthRepository extends JpaRepository<Auth, UUID> {

    @Query("SELECT COUNT(a) > 0 FROM Auth a WHERE a.email = :email AND a.status = Status.ACTIVE")
    public Boolean existsByEmailAndActive(@Param("email") String email);

    @Query("SELECT COUNT(a) > 0 FROM Auth a WHERE a.email = :email AND a.password = :password AND a.status = Status.ACTIVE")
    public Boolean existsByEmailAndPasswordAndActive(@Param("email") String email, @Param("password") String password);
}