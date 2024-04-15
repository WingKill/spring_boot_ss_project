package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.BoardVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	void test() {
		assertNotNull(boardMapper);
	}
	
	@Test
	void testSelectList() {
		for(BoardVo boardVo : boardMapper.selectList()) {
			log.info("=====확인=====================" +  boardVo);			
		}		
	}

	@Test
	void testInsert() {
		boardMapper.insert(new BoardVo(59,"1","1","1"));
		for(BoardVo boardVo : boardMapper.selectList()) {
			log.info("=====확인=====================" +  boardVo);			
		}	
	}

	@Test
	void testDelete() {
		BoardVo boardVoOne = new BoardVo();
		boardVoOne.setBid(59);
		boardMapper.delete(boardVoOne);
		for(BoardVo boardVo : boardMapper.selectList()) {
			log.info("=====확인=====================" +  boardVo);			
		}	
	}
	
	@Test
	void testRead() {
		BoardVo boardVo = boardMapper.read(1);
		log.info("=====확인=====================" + boardVo);
	}
	
	@Test
	void testUpdate() {
		BoardVo boardVo = new BoardVo();
		boardVo.setBid(1);
		boardVo.setBtitle("테스트제목2");
		boardVo.setBcontent("테스트내용2");
		boardMapper.update(boardVo);
		log.info("=== 수정 확인 === " + boardMapper.read(1));
	}
}
