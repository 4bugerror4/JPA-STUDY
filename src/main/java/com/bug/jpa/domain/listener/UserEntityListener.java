package com.bug.jpa.domain.listener;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

import com.bug.jpa.domain.User;
import com.bug.jpa.domain.UserHistory;
import com.bug.jpa.repository.UserHistoryRepository;
import com.bug.jpa.support.BeanUtils;

public class UserEntityListener {
	
	// DB에 저장, 수정 된 후 history테이블에 바로 저장
	@PostPersist
	@PostUpdate
	public void prePersistAndpreUpdate(Object o) {
		
		UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
		
		User user = (User) o;
		
		UserHistory userHistory = new UserHistory();
		
		userHistory.setName(user.getName());
		userHistory.setEmail(user.getEmail());
		userHistory.setUser(user);
		
		userHistoryRepository.save(userHistory);
	}

}
