package com.bug.jpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@EntityListeners(value = MyEntityListener.class)
public class Book extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String category;
	
	private Long authorId;
	
//	private Long publisherId;
	
	// mappedBy = 연관관계 주인X DB테이블에 컬럼을 생성 X
	// StackOverFlowError = 무한참조 ToString 호출 때문에 계속 불러옴
	@ToString.Exclude // Tostring 호출 제외
	@OneToOne(mappedBy = "book")
	private BookReviewInfo bookReviewInfo;
	
	@OneToMany
	@JoinColumn(name =  "book_id")
	@ToString.Exclude
	private List<Review> reviews =  new ArrayList<>();
	
	@ManyToOne
	@ToString.Exclude
	private Publisher publisher;
	
//	private LocalDateTime createdAt;
//	private LocalDateTime updatedAt;

}
