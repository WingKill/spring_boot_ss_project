package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.AuthVo;
import edu.sejong.ex.vo.UserVo;
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
		UserVo user = userMapper.selectUserAuths("admin");
		log.info("유저정보 : "+user);
		for(AuthVo auth : user.getAuthorities()) {
			log.info("권한정보 : "+auth);
		}	
	}

	@Test
	void testInsertUser() {
		UserVo user = new UserVo("hello","hihello");
		log.info("삽입여부 : "+userMapper.insertUser(user));
	}
	
	@Test
	void testInsertAuthorities() {
		List<AuthVo> auths = new ArrayList<AuthVo>();
		AuthVo authVo = new AuthVo("hello","ROLE_USER");
		auths.add(authVo);
		UserVo user = new UserVo("hello","hihello");
		user.setAuthorities(auths);
		userMapper.insertAuthorities(user);		
		log.info("유저정보 : "+userMapper.selectUserAuths("hello"));
	}
}
