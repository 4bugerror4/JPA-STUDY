package com.bug.jpa.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest // mock mvc 생성
public class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void helloWorld() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello-world")) // 테스트 할 URL
			.andDo(print()) // 출력
			.andExpect(status().isOk()) // 상태코드
			.andExpect(content().string("hello world222")); // 컨텐트(body) 내용
	}

}
