package com.trivia;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TriviaBackendApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void test_first() {
		System.out.println("test_first");
		String[] answers = new String[4];
		System.out.println(answers.length);
		answers[0] = "up";
		answers[1] = "down";
		answers[2] = "right";
		answers[3] = "left";
		
		System.out.println(Arrays.toString(answers));
	}

}
