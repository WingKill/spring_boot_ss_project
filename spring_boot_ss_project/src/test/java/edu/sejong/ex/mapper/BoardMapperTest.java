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
	void testInsertBoard() {
		boardMapper.insertBoard(new BoardVo("user","hello","hi"));
		for(BoardVo boardVo : boardMapper.selectList()) {
			log.info("=====확인=====================" +  boardVo);			
		}	
	}

	@Test
	void testDeleteBoard() {
		BoardVo boardVoOne = new BoardVo();
		boardVoOne.setBid(59);
		boardMapper.deleteBoard(boardVoOne);
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
	void testUpdateBoard() {
		BoardVo boardVo = new BoardVo();
		boardVo.setBid(1);
		boardVo.setBtitle("테스트제목2");
		boardVo.setBcontent("테스트내용2");
		boardMapper.updateBoard(boardVo);
		log.info("=== 수정 확인 === " + boardMapper.read(1));
	}
	
	@Test
	void testUpdateHit() {
		BoardVo boardVo = boardMapper.read(1);
		log.info("=====기존 조회수===== : " + boardVo.getBhit());
		
		boardMapper.updateHit(1);
		// 조회수 업데이트 여부를 확인하기 위해 다시 불러오기
		boardVo = boardMapper.read(1);
		log.info("=====이후 조회수===== : " + boardVo.getBhit());
	}
	
	@Test
	void testInsertReply() {
		boardMapper.insertReply(new BoardVo("답글테스터","답글제목1","답글내용1",1,0,0));
		for(BoardVo boardVo : boardMapper.selectList()) {
			log.info("=====확인=====================" +  boardVo);			
		}	
	}
	
	@Test
	void testUpdateShape() {
		//BoardVo boardVo = new BoardVo("답글테스터2","답글제목2","답글내용2",2,0,0);
		BoardVo boardVo = new BoardVo("답글테스터3","답글제목3","답글내용3",2,0,0);
		boardMapper.updateShape(boardVo);
		boardMapper.insertReply(boardVo);
		for(BoardVo board : boardMapper.selectList()) {
			log.info("=====확인=====================" +  board);			
		}
	}
}
