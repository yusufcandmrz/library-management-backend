package com.yusufcandmrz.librarymanagement.account.entity;

import jakarta.persistence.Entity;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Account {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role; //(Enum: 'ACTIVE', 'INACTIVE')
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
