package com.bug.jpa.domain.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.bug.jpa.domain.User;
import com.bug.jpa.domain.UserHistory;
import com.bug.jpa.repository.UserHistoryRepository;
import com.bug.jpa.support.BeanUtils;

public class UserEntityListener {
	
	@PrePersist
	@PreUpdate
	public void prePersistAndpreUpdate(Object o) {
		
		UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
		
		User user = (User) o;
		
		UserHistory userHistory = new UserHistory();
		
		userHistory.setUserId(user.getId());
		userHistory.setName(user.getName());
		userHistory.setEmail(user.getEmail());
		
		userHistoryRepository.save(userHistory);
	}

}
