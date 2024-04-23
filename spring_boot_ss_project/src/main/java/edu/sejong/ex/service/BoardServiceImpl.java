package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> showList() {
		log.info("showList()..");
		return boardMapper.selectList();
	}

	@Override
	public int addBoard(BoardVO boardVo) {
		log.info("add()..");
		return boardMapper.insertBoard(boardVo);
	}

	@Override
	public int removeBoard(int bid, BoardVO boardVo) {
		log.info("remove()..");
		boardVo.setBid(bid);
		return boardMapper.deleteBoard(boardVo);
	}

	@Override
	public BoardVO showContent(int bnum) {
		log.info("showContent()..");
		boardMapper.updateHit(bnum);
		return boardMapper.read(bnum);
	}

	@Override
	public int modifyBoard(BoardVO boardVo) {
		log.info("modifyBoard()..");
		return boardMapper.updateBoard(boardVo);
	}
	
	// 댓글 관련
	
	
	@Override
	public void writeReply(BoardVO boardVo) {
		log.info("writeReply()..");
		boardMapper.updateShape(boardVo);
		boardMapper.insertReply(boardVo);
	}

	@Override
	public BoardVO showReply(BoardVO boardVo) {
		log.info("showReply()..");
		int bnum = boardVo.getBid();
		return boardMapper.read(bnum);
	}

	// 페이징 관련
	
	@Override
	public int getTotal() {
		log.info("getTotal()..");
		return boardMapper.selectTotalCount();
	}

	@Override
	public List<BoardVO> showListWithPaging(Criteria criteria) {
		log.info("showListWithPaging()..");
		return boardMapper.selectListWithPaging(criteria);
	}
}
