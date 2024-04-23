package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.BoardVO;
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
		for(BoardVO boardVo : boardMapper.selectList()) {
			log.info("=====확인=====================" +  boardVo);			
		}		
	}

	@Test
	void testInsertBoard() {
		boardMapper.insertBoard(new BoardVO("user","hello","hi"));
		for(BoardVO boardVo : boardMapper.selectList()) {
			log.info("=====확인=====================" +  boardVo);			
		}	
	}

	@Test
	void testDeleteBoard() {
		BoardVO boardVoOne = new BoardVO();
		boardVoOne.setBid(59);
		boardMapper.deleteBoard(boardVoOne);
		for(BoardVO boardVo : boardMapper.selectList()) {
			log.info("=====확인=====================" +  boardVo);			
		}	
	}
	
	@Test
	void testRead() {
		BoardVO boardVo = boardMapper.read(1);
		log.info("=====확인=====================" + boardVo);
	}
	
	@Test
	void testUpdateBoard() {
		BoardVO boardVo = new BoardVO();
		boardVo.setBid(1);
		boardVo.setBtitle("테스트제목2");
		boardVo.setBcontent("테스트내용2");
		boardMapper.updateBoard(boardVo);
		log.info("=== 수정 확인 === " + boardMapper.read(1));
	}
	
	@Test
	void testUpdateHit() {
		BoardVO boardVo = boardMapper.read(1);
		log.info("=====기존 조회수===== : " + boardVo.getBhit());
		
		boardMapper.updateHit(1);
		// 조회수 업데이트 여부를 확인하기 위해 다시 불러오기
		boardVo = boardMapper.read(1);
		log.info("=====이후 조회수===== : " + boardVo.getBhit());
	}
	
	@Test
	void testInsertReply() {
		boardMapper.insertReply(new BoardVO("답글테스터","답글제목1","답글내용1",1,0,0));
		for(BoardVO boardVo : boardMapper.selectList()) {
			log.info("=====확인=====================" +  boardVo);			
		}	
	}
	
	@Test
	void testUpdateShape() {
		//BoardVo boardVo = new BoardVo("답글테스터2","답글제목2","답글내용2",2,0,0);
		BoardVO boardVo = new BoardVO("답글테스터3","답글제목3","답글내용3",2,0,0);
		boardMapper.updateShape(boardVo);
		boardMapper.insertReply(boardVo);
		for(BoardVO board : boardMapper.selectList()) {
			log.info("=====확인=====================" +  board);			
		}
	}
	

}
