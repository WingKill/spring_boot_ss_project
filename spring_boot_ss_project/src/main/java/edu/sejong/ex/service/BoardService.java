package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.BoardVo;

public interface BoardService {
	List<BoardVo> showList();
	int addBoard(BoardVo boardVo);
	int removeBoard(int bid, BoardVo boardVo);	
	BoardVo showContent(int bnum);
	int modifyBoard(BoardVo boardVo);
	
	int uphit(BoardVo boardVo);
	// 댓글
	void writeReply(BoardVo boardVo);
}
