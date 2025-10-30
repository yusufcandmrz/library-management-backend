package com.yusufcandmrz.librarymanagement.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "reader")
    private Set<Book> borrowedBooks;
}
