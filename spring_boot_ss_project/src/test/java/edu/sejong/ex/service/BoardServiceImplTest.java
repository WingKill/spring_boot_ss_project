package edu.sejong.ex.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.BoardVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BoardServiceImplTest {

	@Autowired
	private BoardService boardService;
	
	@Test
	void test() {
		assertNotNull(boardService);
	}
	
	@Test
	void testShowList() {
		for(BoardVo boardVo : boardService.showList()) {
			log.info("=====확인=====================" +  boardVo);
		}		
	}

	@Test
	void testAdd() {
		boardService.add(new BoardVo(59,"1","1","1"));
		for(BoardVo boardVo : boardService.showList()) {
			log.info("=====확인=====================" +  boardVo);
		}
	}

	@Test
	void testRemove() {
		BoardVo boardVoOne = new BoardVo();
		boardService.remove(59, boardVoOne);
		for(BoardVo boardVo : boardService.showList()) {
			log.info("=====확인=====================" +  boardVo);
		}
	}

	@Test
	void testShowContent() {
		log.info("=== 확인 === " + boardService.showContent(1));	
	}
	
	@Test
	void testModify() {
		BoardVo boardVo = new BoardVo();
		boardVo.setBid(1);
		boardVo.setBtitle("테스트제목3");
		boardVo.setBcontent("테스트내용3");
		boardService.modify(boardVo);
		log.info("=== 확인 === " + boardService.showContent(1));	
	}
}
