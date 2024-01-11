package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Book;

public interface BookRepo {

	public String addBook(Book book);
	public List<Book> showBooks();
	public String deleteBook(Integer id);
	public Book findBook(Integer id);
	public String updaterBook(Book book);
}
