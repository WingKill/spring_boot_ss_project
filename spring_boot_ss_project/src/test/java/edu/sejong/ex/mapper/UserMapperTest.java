package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.sejong.ex.vo.AuthVO;
import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	void test() {
		assertNotNull(userMapper);
	}
	
	@Test
	void testSelectUserAuthLists() {
		UserVO user = userMapper.selectUserAuths("admin");
		log.info("유저정보 : "+user);
		for(AuthVO auth : user.getAuthorities()) {
			log.info("권한정보 : "+auth);
		}	
	}

	@Test
	void testInsertUser() {
//		UserVO user = new UserVO("admin2","admin2");
//		log.info("삽입여부 : "+userMapper.insertUser(user));
		UserVO user = new UserVO();
		user.setUserName("admin2");
		user.setPassword(new BCryptPasswordEncoder().encode("admin2"));
		user.setEnabled("1");
		
		userMapper.insertUser(user);
		userMapper.insertAuthority(user);
	}
	
//	@Test
//	void testInsertAuthorities() {
//		List<AuthVO> auths = new ArrayList<AuthVO>();
//		AuthVO authVo = new AuthVO("hello","ROLE_USER");
//		auths.add(authVo);
//		UserVO user = new UserVO("hello","hihello");
//		user.setAuthorities(auths);
//		userMapper.insertAuthority(user);		
//		log.info("유저정보 : "+userMapper.selectUserAuths("hello"));
//	}
}
