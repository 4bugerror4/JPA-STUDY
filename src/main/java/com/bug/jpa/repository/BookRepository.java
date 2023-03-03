package com.bug.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.jpa.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	Book findByName(String name);

}
