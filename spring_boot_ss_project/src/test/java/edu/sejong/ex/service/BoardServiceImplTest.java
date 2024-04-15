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
	void testAddBoard() {
		boardService.addBoard(new BoardVo(59,"1","1","1"));
		for(BoardVo boardVo : boardService.showList()) {
			log.info("=====확인=====================" +  boardVo);
		}
	}

	@Test
	void testRemoveBoard() {
		BoardVo boardVoOne = new BoardVo();
		boardService.removeBoard(59, boardVoOne);
		for(BoardVo boardVo : boardService.showList()) {
			log.info("=====확인=====================" +  boardVo);
		}
	}

	@Test
	void testShowContent() {
		log.info("=== 확인 === " + boardService.showContent(1));	
	}
	
	@Test
	void testModifyBoard() {
		BoardVo boardVo = new BoardVo();
		boardVo.setBid(1);
		boardVo.setBtitle("테스트제목3");
		boardVo.setBcontent("테스트내용3");
		boardService.modifyBoard(boardVo);
		log.info("=== 확인 === " + boardService.showContent(1));	
	}
	
	@Test
	void testUpHit() {
		BoardVo boardVo = boardService.showContent(1);
		log.info("=== 조회전 === " + boardVo.getBhit());
		boardService.uphit(boardVo);
		boardVo = boardService.showContent(1);
		log.info("=== 조회후 === " + boardVo.getBhit());	
	}
	
	@Test
	void testInsertReply() {
		boardService.writeReply(new BoardVo("답글테수튕","답글제몱","답글내룡",1,0,0));
		for(BoardVo boardVo : boardService.showList()) {
			log.info("=====확인=====================" +  boardVo);			
		}	
	}
}
