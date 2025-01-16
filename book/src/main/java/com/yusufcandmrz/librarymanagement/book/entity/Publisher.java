package com.yusufcandmrz.librarymanagement.book.entity;

import java.util.UUID;

public class Publisher {
    private UUID id;
    private String name;
    private String contactEmail;
    private String contactPhone;
    private String status; //(Enum: 'ACTIVE', 'INACTIVE')
    private String createdAt;
    private String updatedAt;
}
