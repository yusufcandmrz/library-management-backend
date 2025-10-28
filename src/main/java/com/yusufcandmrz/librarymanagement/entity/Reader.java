package com.yusufcandmrz.librarymanagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    //TODO add a relation
    private List<Book> borrowedBooks;
}
