package edu.sejong.ex.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVO;
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
		for(BoardVO boardVo : boardService.showList()) {
			log.info("=====확인=====================" +  boardVo);
		}		
	}

	@Test
	void testAddBoard() {
		boardService.addBoard(new BoardVO(59,"1","1","1"));
		for(BoardVO boardVo : boardService.showList()) {
			log.info("=====확인=====================" +  boardVo);
		}
	}

	@Test
	void testRemoveBoard() {
		BoardVO boardVoOne = new BoardVO();
		boardService.removeBoard(59, boardVoOne);
		for(BoardVO boardVo : boardService.showList()) {
			log.info("=====확인=====================" +  boardVo);
		}
	}

	@Test
	void testShowContent() {
		BoardVO boardVoOne = new BoardVO();
		boardVoOne.setBid(1);
		log.info("=== 확인 === " + boardService.showContent(1));	
	}
	
	@Test
	void testModifyBoard() {
		BoardVO boardVo = new BoardVO();
		boardVo.setBid(1);
		boardVo.setBtitle("테스트제목3");
		boardVo.setBcontent("테스트내용3");
		boardService.modifyBoard(boardVo);
		log.info("=== 확인 === " + boardService.showContent(1));	
	}
	
	@Test
	void testUpHit() {
		BoardVO boardVo = boardService.showContent(1);
		log.info("=== 조회전 === " + boardVo.getBhit());
		boardVo = boardService.showContent(1);
		log.info("=== 조회후 === " + boardVo.getBhit());	
	}
	
	@Test
	void testInsertReply() {
		boardService.writeReply(new BoardVO("답글테수튕","답글제몱","답글내룡",1,0,0));
		for(BoardVO boardVo : boardService.showList()) {
			log.info("=====확인=====================" +  boardVo);			
		}	
	}
	
	@Test
	void testShowReply() {
		BoardVO boardVo = new BoardVO();
		boardVo.setBid(2);
		log.info("=== 확인 === " + boardService.showReply(boardVo));	
	}
	
	@Test
	void testGetTotal() {
		log.info("=== 확인  개수 === " + boardService.getTotal());	
	}
	
	@Test
	void testShowListWithPaging() {
		Criteria criteria = new Criteria();
		log.info("=== 확인 === " + boardService.showListWithPaging(criteria));	
	}
}
