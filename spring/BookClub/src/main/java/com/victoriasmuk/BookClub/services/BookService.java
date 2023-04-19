package com.victoriasmuk.BookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victoriasmuk.BookClub.models.Book;
import com.victoriasmuk.BookClub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;

	public List<Book> getAll() {
		return (List<Book>) bookRepo.findAll();
	}
	public Book getOne(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {
			return null;
		}
	}
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
