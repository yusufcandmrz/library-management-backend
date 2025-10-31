package com.yusufcandmrz.librarymanagement.controller;

import com.yusufcandmrz.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api")
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(name = "/books")
    public ResponseEntity<String> addBook() {
        return new ResponseEntity<>("Book added",HttpStatus.OK);
    }

    //TODO Add Book: POST -> /books
    //TODO List Books: GET -> /books
    //TODO Get Book by ID: GET -> /books/{id}
    //TODO Update Book: POST -> /books/{id}
    //TODO Delete Book: DELETE -> /books/{id}
}
