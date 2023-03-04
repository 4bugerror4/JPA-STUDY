package com.bug.jpa.repository;

import java.time.LocalDateTime;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bug.jpa.domain.Book;
import com.bug.jpa.domain.BookReviewInfo;
import com.bug.jpa.domain.User;

@SpringBootTest
public class BookReviewInfoRepositoryTest {
	
	@Autowired
	private BookReviewInfoRepository bookReviewInfoRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void crudTest() {
		BookReviewInfo bookReviewInfo = new BookReviewInfo();
		bookReviewInfo.setBook(givenBook());
		bookReviewInfo.setAverageReviewScore(4.5f);
		bookReviewInfo.setReviewCount(2);
		
		bookReviewInfoRepository.save(bookReviewInfo);
		
		System.out.println(">>>> " + bookReviewInfoRepository.findAll());
		
	}

	
	@Test
	void crudTest2() {
		
		saveUsers();
		givenBookReviewInfo();
		
		Book result = bookReviewInfoRepository.findById(1L).orElseThrow(() -> null).getBook();
		System.out.println(">>> " + result);
		
		BookReviewInfo result2 = bookRepository.findById(1L).orElseThrow(() -> null).getBookReviewInfo();
		System.out.println(">>> " + result2);
		
	}
	
	private Book givenBook() {
		
		Book book = new Book();
		book.setName("JPA 패키지");
		book.setAuthorId(1L);
//		book.setPublisherId(1L);
		
		return bookRepository.save(book);
	}
	
	private void givenBookReviewInfo() {
		BookReviewInfo bookReviewInfo = new BookReviewInfo();
		bookReviewInfo.setBook(givenBook());
		bookReviewInfo.setAverageReviewScore(4.5f);
		bookReviewInfo.setReviewCount(2);
		
		bookReviewInfoRepository.save(bookReviewInfo);
		System.out.println(">>> " + bookReviewInfoRepository.findAll());
	}
	
	private void saveUsers() {
		
		User user1 = new User("jack", "jack@nate.com", LocalDateTime.now(), LocalDateTime.now());
		User user2 = new User("steve", "steve@nate.com", LocalDateTime.now(), LocalDateTime.now());
		User user3 = new User("rara", "rara@nate.com", LocalDateTime.now(), LocalDateTime.now());
		User user4 = new User("nana", "nana@nate.com", LocalDateTime.now(), LocalDateTime.now());
		User user5 = new User("kaka", "kaka@nate.com", LocalDateTime.now(), LocalDateTime.now());
		userRepository.saveAll(Lists.newArrayList(user1, user2, user3, user4, user5)); // 여러 값 저장
		
		userRepository.findAll().forEach(System.out::println);
	}
}
