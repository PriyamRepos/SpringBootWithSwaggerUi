package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepo;

@Controller
public class MyController {

	@Autowired
	BookRepo repo;

	@PostMapping("/add")
	public ResponseEntity<String> addBook(@RequestBody Book book) {

		String msg = repo.addBook(book);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateBook(@RequestBody Book book) {
		String msg = repo.updaterBook(book);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@GetMapping("/show")
	public ResponseEntity<List<Book>> showBook() {
		List<Book> books = repo.showBooks();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer id) {

		String msg = repo.deleteBook(id);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@GetMapping("/find")
	public ResponseEntity<Book> find(@RequestParam("id") Integer id) {
		Book book = repo.findBook(id);
		System.out.println(book);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
}
