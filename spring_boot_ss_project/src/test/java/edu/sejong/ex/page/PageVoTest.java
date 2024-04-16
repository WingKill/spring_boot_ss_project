package edu.sejong.ex.page;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.vo.BoardVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class PageVoTest {

	@Autowired
	BoardMapper boardMapper;

	@Test
	void test() {
		assertNotNull(boardMapper);
	}

	@Test
	void testSelectListWithPaging() {
		Criteria criteria = new Criteria();
		assertNotNull(criteria);		

		List<BoardVo> boards = boardMapper.selectListWithPaging(criteria);

		for (BoardVo board : boardMapper.selectListWithPaging(criteria)) {
			log.info("==확인==" + board);
		}

		criteria.setPageNum(3);
		criteria.setAmount(10);

		boards = boardMapper.selectListWithPaging(criteria);

		for (BoardVo board : boards) {
			log.info("2차 확인 : " + board);
		}

	}

	@Test
	void testSelectTotalCount() {
		log.info("개수 : " + boardMapper.selectTotalCount());
	}
}
