package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVO;

public interface BoardService {
	List<BoardVO> showList();
	int addBoard(BoardVO boardVo);
	int removeBoard(int bid, BoardVO boardVo);	
	BoardVO showContent(int bnum); // 조회수 처리가 내장되어 있음.
	int modifyBoard(BoardVO boardVo);
	
	
	// 댓글
	void writeReply(BoardVO boardVo);
	BoardVO showReply(BoardVO boardVo);
	
	// 페이징
	public int getTotal();
	public List<BoardVO> showListWithPaging(Criteria criteria);
}
