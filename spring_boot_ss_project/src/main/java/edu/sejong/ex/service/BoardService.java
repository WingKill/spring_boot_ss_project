package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.BoardVo;

public interface BoardService {
	List<BoardVo> showList();
	int add(BoardVo boardVo);
	int remove(int bid, BoardVo boardVo);	
	BoardVo showContent(int bnum);
}
