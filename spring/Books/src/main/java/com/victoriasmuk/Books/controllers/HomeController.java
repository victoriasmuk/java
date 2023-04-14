package com.victoriasmuk.Books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.victoriasmuk.Books.models.Book;
import com.victoriasmuk.Books.services.BookService;


@Controller
public class HomeController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String bookBoard(Model model) {
		List<Book> bookList = bookService.allBooks();
		model.addAttribute("bookList", bookList);
		return "dashboard.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String bookDetails(@PathVariable("id")Long id, Model model) {
		Book oneBook = bookService.findBook(id);
		model.addAttribute("oneBook", oneBook);
		return "bookDetails.jsp";
	}
}