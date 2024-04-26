package edu.sejong.ex.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class AuthVOTest {
	
	@Test
	void testAuthVO() {
		AuthVO authVO = new AuthVO();
		
		assertNotNull(authVO);
	}

	@Test
	void testGetUserName() {
		AuthVO authVO = new AuthVO();
		assertNotNull(authVO);
		
		authVO.setUserName("홍길동");
		assertEquals("홍길동", authVO.getUserName());
	}
	
	
}
