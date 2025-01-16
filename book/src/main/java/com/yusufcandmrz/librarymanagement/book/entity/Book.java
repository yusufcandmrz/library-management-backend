package com.yusufcandmrz.librarymanagement.book.entity;

import java.util.List;
import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private String author;
    private String isbn; // Unique
    private List<Category> categories;
    private String translator;
    private Publisher publisher;
    private String status; //(Enum: 'AVAILABLE', 'BORROWED', 'RESERVED', 'LOST')
    private String createdAt;
    private String updatedAt;
}