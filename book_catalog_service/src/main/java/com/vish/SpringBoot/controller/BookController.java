package com.vish.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vish.SpringBoot.entity.Book;
import com.vish.SpringBoot.service.BookService;

@ResponseBody
@RestController
public class BookController {
	 @Autowired
	 private final BookService bookService;

	    public BookController(BookService bookService){
	        this.bookService=bookService;
	    }

	    @PostMapping("/saveBook")
	    public ResponseEntity addExpense(@RequestBody Book book) {
	        bookService.addBook(book);
	        System.out.println("Book "+book.getId()+" Created...");
	        return ResponseEntity.status(HttpStatus.CREATED).build();
	    }

	    @PutMapping("/saveBook")
	    public ResponseEntity updateExpense(@RequestBody Book book) {
	        bookService.updateBook(book);
	        System.out.println("Book "+book.getId()+" Updated...");
	        return ResponseEntity.status(HttpStatus.OK).build();
	    }

	    @GetMapping("/books")
	    public ResponseEntity<List<Book>> getAllBooks() {
	        return ResponseEntity.ok(bookService.getAllBooks());
	    }

	    @GetMapping("/{name}")
	    public ResponseEntity getExpenseByName(@PathVariable String name) {
	        return ResponseEntity.ok(bookService.getBookByName(name));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity deleteExpense(@PathVariable Integer id) {
	        bookService.deleteBook(id);
	        System.out.println("Book "+id+" Deleted...");
	        return ResponseEntity.noContent().build();
	    }
	

}
