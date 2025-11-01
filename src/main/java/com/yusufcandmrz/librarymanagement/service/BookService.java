package com.yusufcandmrz.librarymanagement.service;

import com.yusufcandmrz.librarymanagement.dto.AddBookRequest;
import com.yusufcandmrz.librarymanagement.dto.UpdateBookRequest;
import com.yusufcandmrz.librarymanagement.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public void addBook(AddBookRequest request);

    public List<Book> getBookList();

    public Book getBookById(Long id);

    public void updateBookById(Long id, UpdateBookRequest request);

    public void deleteBookById(Long id);
}
