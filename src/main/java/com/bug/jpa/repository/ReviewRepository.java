package com.bug.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.jpa.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
