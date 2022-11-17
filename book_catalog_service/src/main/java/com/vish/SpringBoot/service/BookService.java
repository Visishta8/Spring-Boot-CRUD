package com.vish.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.vish.SpringBoot.entity.Book;
import com.vish.SpringBoot.repository.BookRepository;

@Service
public class BookService {
	@Autowired
    private BookRepository bookRepository;
	
	@Autowired
	private SequenceGeneratorService service;

    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public void addBook(Book book){
    	//generate sequence code
    	book.setId(service.getIncSequenceNumber(Book.SEQUENCE_NAME));
        bookRepository.insert(book);
    }
	
	public void updateBook(@RequestBody Book book) {
		Book savedBook = bookRepository.findByName(book.getName())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Book by Name %s", book.getName())));
        savedBook.setName(book.getName());
        savedBook.setPrice(book.getPrice());

        bookRepository.save(savedBook);
	}
	
	public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookByName(String name){
        return bookRepository.findByName(name).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Book by Name %s", name)));
    }

    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
        service.getDecSequenceNumber(id);
    }

}
