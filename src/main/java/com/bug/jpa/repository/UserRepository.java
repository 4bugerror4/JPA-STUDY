package com.bug.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.jpa.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
