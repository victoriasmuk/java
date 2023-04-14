package com.victoriasmuk.Books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.victoriasmuk.Books.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findAll();
}