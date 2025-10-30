package com.yusufcandmrz.librarymanagement.entity;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private boolean available = true;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;
}
