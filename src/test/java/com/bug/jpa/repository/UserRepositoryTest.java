package com.bug.jpa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.bug.jpa.domain.User;

@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void create() {
		
		User user1 = new User("jack", "jack@nate.com", LocalDateTime.now(), LocalDateTime.now());
		User user2 = new User("steve", "steve@nate.com", LocalDateTime.now(), LocalDateTime.now());
		User user3 = new User("rara", "rara@nate.com", LocalDateTime.now(), LocalDateTime.now());
		User user4 = new User("nana", "nana@nate.com", LocalDateTime.now(), LocalDateTime.now());
		User user5 = new User("kaka", "kaka@nate.com", LocalDateTime.now(), LocalDateTime.now());
		userRepository.saveAll(Lists.newArrayList(user1, user2, user3, user4, user5)); // 여러 값 저장
		 
		User user6 = new User("rara", "rara@another.com"); // 하나 값 저장
		userRepository.save(user6);
		
	}
	
	@Test
	void read() {
		
		List<User> getUsersOrderByName = userRepository.findAll(Sort.by(Direction.DESC, "name")); // 이름기준 내림차순
		List<User> getUsersSelectId  = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L)); // 설절한 아이디의 값만 출력
		User getUser = userRepository.findById(1L).orElseThrow(() -> null);
		Long getUserCount = userRepository.count(); // DB에 컬럼이 총 몇개
		boolean isExistId = userRepository.existsById(1L); // DB에 해당 값의 ID가 존재하는지
		
		getUsersOrderByName.forEach(System.out::println);
		System.out.println("================================");
		getUsersSelectId.forEach(System.out::println);
		System.out.println("================================");
		System.out.println(getUser);
		System.out.println("================================");
		System.out.println(getUserCount);
		System.out.println("================================");
		System.out.println(isExistId);
		
	}
	
	@Test
	void update() {
		User getUser = userRepository.findById(1L).orElseThrow(() -> null);
		System.out.println("기존 유저 정보 : " + getUser);
		
		getUser.setName("bravo");
		getUser.setEmail("bravo@gmail.com");
		
		System.out.println("변경 된 유저 정보 : " + getUser);
	}
	
	@Test
	void delete() {
		// userRepository.delete(userRepository.findById(6L).orElseThrow(() -> new IllegalAccessError("해당 번호의 유저는 존재하지 않습니다."))); // 객체를 이용해서 삭제
		
		// userRepository.deleteAll(); // 전체 삭제
		// userRepository.deleteAllInBatch(); 위에 코드랑 동일 성능 차이
		
		// userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L))); // 해당 아이디를 가진 객체들만 삭제
		// userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L))); // 위에 코드랑 동일 한데 성능 차이
		
		userRepository.deleteById(6L);
		
		userRepository.findAll().forEach(System.out::println);
	}
	
	@Test
	void page() {
		Page<User> getUsers = userRepository.findAll(PageRequest.of(1, 3));
		
		System.out.println("page : " + getUsers);
		System.out.println("totalElements : " + getUsers.getTotalElements()); // 총 개 수
		System.out.println("totalPages : " + getUsers.getTotalPages()); // 총 페이지 수
		System.out.println("numberOfElements : " + getUsers.getNumberOfElements()); // 현재 페이지의 총 개 수
		System.out.println("sort : " + getUsers.getSort());
		System.out.println("size : " + getUsers.getSize()); // 나눈 크키
		
		getUsers.getContent().forEach(System.out::println);
	}
	
	@Test
	void select() {
//		System.out.println(userRepository.findByName("rara"));
//		
//		System.out.println("findByEmail : " + userRepository.findByEmail("rara@nate.com"));
//		System.out.println("getByEmail : " + userRepository.getByEmail("rara@nate.com"));
//		System.out.println("readByEmail : " + userRepository.readByEmail("rara@nate.com"));
//		System.out.println("queryByEmail : " + userRepository.queryByEmail("rara@nate.com"));
//		System.out.println("searchByEmail : " + userRepository.searchByEmail("rara@nate.com"));
//		System.out.println("streamByEmail : " + userRepository.streamByEmail("rara@nate.com"));
//		System.out.println("findUserByEmail : " + userRepository.findUserByEmail("rara@nate.com"));
//		
//		System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("rara"));
//		System.out.println("findTop1ByName : " + userRepository.findTop1ByName("rara"));
//		System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("rara@nate.com", "rara"));
//		System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("rara@nate.com", "nana"));
//		
//		System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//		System.out.println("findByCreatedAtBefore : " + userRepository.findByCreatedAtBefore(LocalDateTime.now().minusDays(1L)));
//		
//		System.out.println("findByIdAfter : " + userRepository.findByIdAfter(3L));
//		System.out.println("findByIdBefore : " + userRepository.findByIdBefore(3L));
//		
//		System.out.println("findByIdGreaterThan : " + userRepository.findByIdGreaterThan(3L));
//		System.out.println("findByIdGreaterThanEqual : " + userRepository.findByIdGreaterThanEqual(3L));
//		
//		System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
//		System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
//		System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));
		
		System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
		System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("rara", "nana")));
		
		System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("ra"));
		System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("a"));
		System.out.println("findByNameContaining : " + userRepository.findByNameContaining("ev"));
		
	}
	
	@Test
	void pagingAndSorting() {
		// Sort
		System.out.println("findByTop1ByName : " + userRepository.findTop1ByName("rara"));
		System.out.println("findTop1ByNameOrderByIdDesc : " + userRepository.findTop1ByNameOrderByIdDesc("rara"));
		System.out.println("findTop1ByNameOrderByIdDescEmailAsc : " + userRepository.findTop1ByNameOrderByIdDescEmailAsc("rara"));
		System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("rara", Sort.by(Order.asc("id"))));
		System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("rara", Sort.by(Order.desc("id"))));
		System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("rara", Sort.by(Order.desc("id"), Order.asc("email"))));
		System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("rara", getSort()));
		
		// Page
		
		System.out.println("findByNameWithPaging : " + userRepository.findByName("rara", PageRequest.of(0, 1, Sort.by(Order.desc("id")))).getContent());
	}
	
	private static Sort getSort() {
		return Sort.by(
					Order.desc("id"),
					Order.asc("email"),
					Order.desc("createdAt"),
					Order.asc("updatedAt")
				);
	}
	
	@Test
	void listenerTest() {
		User user = new User();
		user.setName("momo");
		user.setEmail("momo@nate.com");
		
		userRepository.save(user);
		
		User user2 = userRepository.findById(1L).orElseThrow(() -> null);
		user2.setName("momomomomomomomo");
		
		userRepository.save(user2);
		
		userRepository.deleteById(4L);
	}

}








