package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	void testUserMapper() {
		assertNotNull(userMapper);
	}
	
	@Test
	void testGetUser() {
		UserVO user = userMapper.getUser("admin");
		assertNotNull(user);
		
		System.out.println(user);
	}
	
	@Disabled
	@Test
	void testInsertUser() {
			UserVO user = new UserVO();
			user.setUsername("admin2");
			user.setPassword(new BCryptPasswordEncoder().encode("admin2"));
			user.setEnabled("1");
			
			userMapper.insertUser(user);
			userMapper.insertAuthoruties(user);
			
	}
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	void testMatcher() {
		
		UserVO user = userMapper.getUser("admin2");
		boolean isMatch = passwordEncoder.matches("admin2", user.getPassword());


		assertEquals(isMatch, true);
			
	}

}
