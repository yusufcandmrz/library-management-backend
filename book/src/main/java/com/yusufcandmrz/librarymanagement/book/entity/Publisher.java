package com.yusufcandmrz.librarymanagement.book.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

public class Publisher {

    @Id
    @GeneratedValue()
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "contact_email", unique = true)
    private String contactEmail;

    @Column(name = "contact_phone", unique = true)
    private String contactPhone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "publisher", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Book> booksList;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;
}
