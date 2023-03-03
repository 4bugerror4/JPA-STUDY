package com.bug.jpa.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bug.jpa.domain.listener.MyEntityListener;
import com.bug.jpa.domain.listener.UserEntityListener;

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
@EntityListeners(value = {MyEntityListener.class, UserEntityListener.class})
public class User implements Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull // 필수 값
	private String name;

	@NonNull // 필수 값
	private String email;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	// @Transient DB에 컬럼을 생성하지 않고, 객체에서만 필드를 사용하고 싶을 때
	// private String testData;

	// @Enumerated(EnumType.STRING) String으로 설정 안해주면 ORDINAL이 default이기때문에 0, 1 숫자로 컬럼 값에 들어감
	// private Gender gender;

	public User(@NonNull String name, @NonNull String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.name = name;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	// Event
//	@PrePersist
//	public void prePersist() {
//		this.createdAt = LocalDateTime.now();
//		this.updatedAt = LocalDateTime.now();
//	}
//	
//	@PostPersist
//	public void postPersist() {
//		System.out.println(">>>> postPersist()");
//	}
//	
//	@PreUpdate
//	public void preUpdate() {
//		this.updatedAt = LocalDateTime.now();
//	}
//	
//	@PostUpdate
//	public void postUpdate() {
//		System.out.println(">>>> postUpdate()");
//	}
//	
//	@PreRemove
//	public void preRemove() {
//		System.out.println(">>>> preRemove()");
//	}
//	
//	@PostRemove
//	public void postRemove() {
//		System.out.println(">>>> postRemove()");
//	}
//	
//	@PostLoad
//	public void postLoad() {
//		System.out.println(">>>> postLoad()");
//	}

}
