package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Book;

public interface BookService {
	public List<Book> findByAuthorName(String authorName);
public List<Book> findAllBooks();
}