package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepo;
import com.example.demo.repository.MyRepository;
@Service
public class BookRepoImpl implements BookRepo{

	@Autowired
	MyRepository repo;
	
	@Override
	public String addBook(Book book) {
		repo.save(book);
		return "Book Saved Succesfully";

	}
	@Override
	public String deleteBook(Integer id) {
		 repo.deleteById(id);
		return "delete successfully";
	}
	@Override
	public Book findBook(Integer id) {
		Book book = repo.findById(id).get();
		return book;
	}
	
	@Override
	public List<Book> showBooks() {
		List<Book> list = repo.findAll();
		return list;
	}
	@Override
	public String updaterBook(Book book) {
		repo.save(book);
		return "Book updated succesfully";
	}
	
	
}
