package com.bug.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.bug.jpa.domain.Book;
import com.bug.jpa.domain.Publisher;
import com.bug.jpa.domain.Review;
import com.bug.jpa.domain.User;

@SpringBootTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void bookTest() {
		Book book = new Book();
		book.setName("안녕JPA");
		book.setAuthorId(1L);
//		book.setPublisherId(1L);
		
		bookRepository.save(book);
		
		System.out.println(bookRepository.findById(1L));
	}
	
	@Test
	@Transactional
	void bookRelationTest() {
		givenBookAndReview();
		
		User user = userRepository.findByEmail("momo@nate.com");
		
		System.out.println("Review : " + user.getReviews());
		System.out.println("Book : " + user.getReviews().get(0).getBook());
		System.out.println("Publisher : " + user.getReviews().get(0).getBook().getPublisher());
	}
	
	private void givenBookAndReview() {
		givenReview(givenBook(givenPublisher()), givenUser());
	}
	
	private User givenUser() {
		
		return userRepository.findByEmail("momo@nate.com");
	}
	
	private void givenReview(Book book, User user) {
		Review review = new Review();
		review.setTitle("리뷰 제목");
		review.setContent("리뷰 내용");
		review.setScore(5.0f);
		review.setUser(user);
		review.setBook(book);
		
		reviewRepository.save(review);
	}
	
	private Book givenBook(Publisher publisher) {
		Book book = new Book();
		book.setName("첫번째 책입니다.");
		book.setPublisher(publisher);
		
		return bookRepository.save(book);
	}
	
	private Publisher givenPublisher() {
		Publisher publisher = new Publisher();
		publisher.setName("알라알라");
		
		return publisherRepository.save(publisher);
	}
}
