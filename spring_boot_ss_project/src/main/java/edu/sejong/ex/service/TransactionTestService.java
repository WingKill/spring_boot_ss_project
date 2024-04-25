package edu.sejong.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransactionTestService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Transactional
	public void transactionTest1() {
		log.info("transactionTest1() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션1");
		boardVO.setBname("트랜잭션1");
		boardVO.setBtitle("트랜잭션1");
		
		boardMapper.insertBoard(boardVO);
		
		BoardVO boardVO2 = new BoardVO();
		boardVO2.setBcontent("트랜잭션2");
		boardVO2.setBname("트랜잭션2");
		boardVO2.setBtitle("트랜잭션2");
		
		boardMapper.insertBoard(boardVO2);
	}
}
