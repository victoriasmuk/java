package com.victoriasmuk.Books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victoriasmuk.Books.models.Book;
import com.victoriasmuk.Books.services.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class APIController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> findAllBooks() {
		return bookService.allBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book oneBook(@PathVariable("id")Long id) {
		return bookService.findBook(id);
	}
	
	@PostMapping("/books")
	public Book addBook(
			@Valid @ModelAttribute("newBook") Book newBook, BindingResult result
			) {
		return bookService.createBook(newBook);
	}
	
	@PutMapping("/books/{id}")
	public Book editBook(
			@PathVariable("id")Long id,
			@Valid @ModelAttribute("oneBook") Book oneBook, BindingResult result
			) {
		return bookService.updateBook(oneBook);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id")Long id) {
		bookService.removeBook(id);
	}
}
