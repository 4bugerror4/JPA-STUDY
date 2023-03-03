package com.bug.jpa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.jpa.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	// JPA Query Method
	List<User> findByName(String username); // 유저이름으로 찾기
	
	// Select
	User findByEmail(String email);
	User getByEmail(String email);
	User readByEmail(String email);
	User queryByEmail(String email);
	User searchByEmail(String email);
	User streamByEmail(String email);
	User findUserByEmail(String email);
	
	// Limit First(n), Top(n) n이 복수면 리턴타입을 List로 받아야 함
	User findFirst1ByName(String username);
	User findTop1ByName(String username);

	// AND, OR
	List<User> findByEmailAndName(String email, String name); // 두개 다 참 일때
	List<User> findByEmailOrName(String email, String name); // 둘 중에 하나라도 참이면
	
	// After, Before
	List<User> findByCreatedAtAfter(LocalDateTime yesterday); // 기존 날짜보다 큰것
	List<User> findByCreatedAtBefore(LocalDateTime yesterday); // 기존 날짜보다 큰것
	List<User> findByIdAfter(Long id);
	List<User> findByIdBefore(Long id);
	
	// GreaterThan
	List<User> findByIdGreaterThan(Long id); // After랑 동일
	List<User> findByIdGreaterThanEqual(Long id); // 포함
	
	// BetWeen (특정 범위 값)
	List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);
	List<User> findByIdBetween(Long id1, Long id2);
	List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2); // 위에 between을 풀어 쓸 경우
	
	// Null (빈 값)
	List<User> findByIdIsNotNull(); // Null이 아닌 값 반환
	// List<User> findByIdIsNotEmpty(); // Collection Type의 Not Empty를 Check [잘 사용하지 않음]
	
	// In, Not In (포함, 미포함)
	List<User> findByNameIn(List<String> name);
	
	// Like
	List<User> findByNameStartingWith(String name);
	List<User> findByNameEndingWith(String name);
	List<User> findByNameContaining(String name);
	
	// Sort
	List<User> findTop1ByNameOrderByIdDesc(String name); // 역순
	List<User> findTop1ByNameOrderByIdDescEmailAsc(String name); // OrderBy에서는 And를 사용하지 않고 바로 붙여줌
	List<User> findFirstByName(String name, Sort sort);
	
	// Page
	Page<User> findByName(String name, Pageable pageable); // Page == Response Value, Pageable == Request Value
	
	
}
