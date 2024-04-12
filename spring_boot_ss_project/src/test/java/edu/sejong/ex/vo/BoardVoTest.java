package edu.sejong.ex.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class BoardVoTest {

	@Test
	void test() {
		BoardVo boardVo = new BoardVo();
		boardVo.setBid(1);
		assertNotNull(boardVo);
		log.info("주소 : " + boardVo);
		log.info("글번호: " + boardVo.getBid());
	}

}
