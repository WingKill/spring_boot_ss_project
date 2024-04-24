package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.sejong.ex.vo.AuthVO;
import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void test() {
		assertNotNull(userMapper);
	}

	@Test
	void testSelectUserAuthLists() {
		UserVO user = userMapper.selectUserAuths("admin3");
		log.info("유저정보 : " + user);
		for (AuthVO auth : user.getAuthorities()) {
			log.info("권한정보 : " + auth);
		}
	}

	@Test
	void testInsertUser() {

//		UserVO user = new UserVO();
//		user.setUserName("admin2");
//		user.setPassword(new BCryptPasswordEncoder().encode("admin2"));
//		user.setEnabled("1");
//		
//		userMapper.insertUser(user);
//		userMapper.insertAuthority(user);

//		UserVO user = new UserVO();
//		user.setUserName("admin3");
//		user.setPassword(new BCryptPasswordEncoder().encode("admin3"));
//		user.setEnabled("1");
//		
//		userMapper.insertUser(user);
//		userMapper.insertAuthorityAdmin(user);

		UserVO user = new UserVO();
		user.setUserName("user2");
		user.setPassword(passwordEncoder.encode("user2"));
		user.setEnabled("1");

		userMapper.insertUser(user);
		userMapper.insertAuthority(user);
	}

	@Test
	void testMatcher() {
		UserVO user = userMapper.selectUserAuths("admin2");
		boolean isMatch = passwordEncoder.matches("admin2", user.getPassword());
		assertEquals(isMatch, true);
	}

}
