package com.yusufcandmrz.librarymanagement.book.entity;

import java.sql.Timestamp;
import java.util.UUID;

public class Category {
    private UUID id;
    private String name;
    private String status; //(Enum: 'ACTIVE', 'INACTIVE')
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
