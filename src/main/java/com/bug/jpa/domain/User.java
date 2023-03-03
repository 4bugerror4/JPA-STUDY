package com.bug.jpa.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor // NonNull이 설정 되어있지 않다면 NoArgConstructor랑 동일
@Builder
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull // 필수 값
	private String name;

	@NonNull // 필수 값
	private String email;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public User(@NonNull String name, @NonNull String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.name = name;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

}
