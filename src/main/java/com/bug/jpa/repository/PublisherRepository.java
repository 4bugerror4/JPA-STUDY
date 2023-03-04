package com.bug.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.jpa.domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
