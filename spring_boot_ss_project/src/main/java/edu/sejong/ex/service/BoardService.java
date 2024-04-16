package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVo;

public interface BoardService {
	List<BoardVo> showList();
	int addBoard(BoardVo boardVo);
	int removeBoard(int bid, BoardVo boardVo);	
	BoardVo showContent(int bnum); // 조회수 처리가 내장되어 있음.
	int modifyBoard(BoardVo boardVo);
	
	
	// 댓글
	void writeReply(BoardVo boardVo);
	BoardVo showReply(BoardVo boardVo);
	
	// 페이징
	public int getTotal();
	public List<BoardVo> showListWithPaging(Criteria criteria);
}
