package com.hiringchallenge.talkinglands;

import com.hiringchallenge.talkinglands.repository.UserRepository;
import com.hiringchallenge.talkinglands.service.UserService;
import com.hiringchallenge.talkinglands.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
class TalkingLandsApplicationTests {
	@Configuration
	static class TestConfig {
		@Bean
		public UserRepository userRepository() {
			return Mockito.mock(UserRepository.class);
		}

		@Bean
		public UserService userService(UserRepository userRepository) {
			return new UserServiceImpl(userRepository);
		}
	}
	@Test
	void contextLoads() {
		// The test will pass if the application context loads successfully
	}
}
