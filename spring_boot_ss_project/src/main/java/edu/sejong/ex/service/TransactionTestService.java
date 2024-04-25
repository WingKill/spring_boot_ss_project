package edu.sejong.ex.service;

import java.sql.SQLException;

import javax.management.RuntimeErrorException;

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

	public void transactionTest2() {
		log.info("transactionTest2() 테스트");

		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션1");
		boardVO.setBname("트랜잭션1");
		boardVO.setBtitle("트랜잭션1");

		boardMapper.insertBoard(boardVO);

		BoardVO boardVO2 = new BoardVO();
		boardVO2.setBcontent("트랜잭션2");
		boardVO2.setBname("트랜잭션2");
		boardVO2.setBtitle("트랜잭션2");

		// 일부러 트랜잭션을 위한 테스트로 null 값을 넣음
		boardVO2 = null;
		boardMapper.insertBoard(boardVO2);
	}

	@Transactional // 해당 함수 내에서 에러가 발생할 경우, 롤백(rollback).
	public void transactionTest3() {
		log.info("transactionTest3() 테스트");

		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션3");
		boardVO.setBname("트랜잭션3");
		boardVO.setBtitle("트랜잭션3");

		boardMapper.insertBoard(boardVO);

		BoardVO boardVO2 = new BoardVO();
		boardVO2.setBcontent("트랜잭션3");
		boardVO2.setBname("트랜잭션3");
		boardVO2.setBtitle("트랜잭션3");

		// 일부러 트랜잭션을 위한 테스트로 null 값을 넣음
		boardVO2 = null;
		boardMapper.insertBoard(boardVO2);
	}

	@Transactional // 롤백함
	public void transactionTest4() {
		log.info("transactionTest4() 테스트");

		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션4");
		boardVO.setBname("트랜잭션4");
		boardVO.setBtitle("트랜잭션4");

		boardMapper.insertBoard(boardVO);

		throw new RuntimeException("RuntimeException for rollback");
	}

	// CheckedException 테스트(롤백 안함)
	@Transactional // 롤백 안함
	public void transactionTest5() throws SQLException {
		log.info("transactionTest5() 테스트");

		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션5");
		boardVO.setBname("트랜잭션5");
		boardVO.setBtitle("트랜잭션5");

		boardMapper.insertBoard(boardVO);

		throw new SQLException("SQLException for rollback");
	}

	// @Transactional의 rollbackFor 옵션을 이용하면 Rollback이 되는 클래스를 지정가능함.
	// Exception예외로 롤백을 하려면 다음과 같이 지정하면됩니다. 
	// @Transactional(rollbackFor = Exception.class)
	// 여러개의 예외를 지정할 수도 있습니다. 
	// @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	@Transactional(rollbackFor = Exception.class) // 롤백함
	public void transactionTest6() throws SQLException {

		log.info("transetionTest6() 테스트");

		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션6");
		boardVO.setBname("트랜잭션6");
		boardVO.setBtitle("트랜잭션6");

		boardMapper.insertBoard(boardVO);

		throw new SQLException("SQLException for rollback");
	}
	
	
	// 특정 에러만 선택하여 롤백을 진행하고 싶을 때
	@Transactional(rollbackFor = SQLException.class) 
	public void transactionTest7() throws SQLException {

		log.info("transetionTest7() 테스트");

		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션7");
		boardVO.setBname("트랜잭션7");
		boardVO.setBtitle("트랜잭션7");

		boardMapper.insertBoard(boardVO);

		throw new SQLException("SQLException for rollback");
	}
}
