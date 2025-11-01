package com.yusufcandmrz.librarymanagement.service.imp;

import com.yusufcandmrz.librarymanagement.dto.AddBookRequest;
import com.yusufcandmrz.librarymanagement.dto.UpdateBookRequest;
import com.yusufcandmrz.librarymanagement.entity.Book;
import com.yusufcandmrz.librarymanagement.service.BookService;

import java.util.List;

public class BookServiceImp implements BookService {
    @Override
    public void addBook(AddBookRequest request) {

    }

    @Override
    public List<Book> getBookList() {
        return List.of();
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public void updateBookById(Long id, UpdateBookRequest request) {

    }

    @Override
    public void deleteBookById(Long id) {

    }
}
