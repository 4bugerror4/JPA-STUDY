package com.bug.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bug.jpa.domain.Book;

@SpringBootTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	void bookTest() {
		Book book = new Book();
		book.setName("안녕JPA");
		book.setAuthor("whoami");
		
		bookRepository.save(book);
		
		System.out.println(bookRepository.findById(1L));
	}
	
	@Test
	void bookUpdateTest() {
		
		Book book = bookRepository.findById(1L).orElseThrow(() -> null);
		book.setAuthor("에러버그22");
		
		Book updateBook = bookRepository.save(book);
		
		System.out.println(bookRepository.findByName(updateBook.getName()));
	}

}
