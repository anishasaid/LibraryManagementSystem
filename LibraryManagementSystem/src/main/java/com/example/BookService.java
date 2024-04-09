package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	//fetch all books
	public List<Book> findAll(){
		return bookRepo.findAll();
	}
	
	//fetch specific book
	public Book findById(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	//add book
	public Book save(Book book) {
		return bookRepo.save(book);
	}
	
	//delete book
	public void deleteById(Long id) {
		bookRepo.deleteById(id);
	}
	
	//borrow a book
	public Book borrowBook(Long bookId, Long userId) {
		
		Book book =  findById(bookId);
		User user = userRepo.findById(userId).orElse(null);
		
		if(book != null && !book.isBorrowed() && user != null) {
			book.setBorrowedBy(user);
			book.setBorrowed(true);
			
			return save(book);
		}
		
		return null;
	}
	
	//return a book
	public Book returnBook(Long bookId) {
		
		Book book = findById(bookId);
		
		if(book != null && book.isBorrowed()) {
			book.setBorrowedBy(null);
			book.setBorrowed(false);
			
			return save(book);
		}
		
		return null;
	}
	
}













