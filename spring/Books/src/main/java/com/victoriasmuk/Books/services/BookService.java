package com.victoriasmuk.Books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victoriasmuk.Books.models.Book;
import com.victoriasmuk.Books.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
//	FIND ALL
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
//	FIND ONE
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
//	CREATE
	public Book createBook(Book newBook) {
		return bookRepo.save(newBook);
	}
//	UPDATE
	public Book updateBook(Book oneBook) {
		return bookRepo.save(oneBook);
	}
//	DELETE
	public void removeBook(Long id) {
		bookRepo.deleteById(id);
	}
}
