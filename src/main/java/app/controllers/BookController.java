package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import app.entities.Book;
import app.entities.MyBookList;
import app.repositories.BookRepository;
import app.repositories.MyBookRepository;

import java.util.*;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private MyBookRepository myBookRepository;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		return new ModelAndView("bookList","book",bookRepository.findAll());
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bookRepository.save(b);
		return "redirect:/available_books";
	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		model.addAttribute("book",myBookRepository.findAll());
		return "myBooks";
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=bookRepository.findById(id).get();
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookRepository.save(mb);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b=bookRepository.findById(id).get();
		model.addAttribute("book",b);
		return "bookEdit";
	}

	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		bookRepository.deleteById(id);
		return "redirect:/available_books";
	}

	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id")int id) {
		myBookRepository.deleteById(id);
		return "redirect:/my_books";
	}
}