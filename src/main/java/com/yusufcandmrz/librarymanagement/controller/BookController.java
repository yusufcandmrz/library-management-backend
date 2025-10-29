package com.yusufcandmrz.librarymanagement.controller;

import com.yusufcandmrz.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //TODO Add Book: POST -> /books
    //TODO List Books: GET -> /books
    //TODO Get Book by ID: GET -> /books/{id}
    //TODO Update Book: POST -> /books/{id}
    //TODO Delete Book: DELETE -> /books/{id}
}
