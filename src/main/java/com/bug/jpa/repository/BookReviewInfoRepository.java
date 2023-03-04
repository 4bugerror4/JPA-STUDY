package com.bug.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.jpa.domain.BookReviewInfo;

public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo, Long> {

}
