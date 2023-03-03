package com.bug.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bug.jpa.domain.User;

@SpringBootTest
public class UserHistoryRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserHistoryRepository userHistoryRepository;
	
	@Test
	void userHistory() {
		User user = new User();
		user.setName("hoho");
		user.setEmail("hoho@nate.com");
		
		userRepository.save(user);
		
		user.setName("hoho-new");
		
		userRepository.save(user);
		
		userHistoryRepository.findAll().forEach(System.out::println);
	}

}
