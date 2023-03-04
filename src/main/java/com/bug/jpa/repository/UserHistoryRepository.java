package com.bug.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.jpa.domain.UserHistory;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
	
	List<UserHistory> findByUserId(Long userId);

}
