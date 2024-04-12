package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVo> showList() {
		return boardMapper.selectList();
	}

	@Override
	public int add(BoardVo boardVo) {
		return boardMapper.insert(boardVo);
	}

	@Override
	public int remove(int bid, BoardVo boardVo) {
		boardVo.setBid(bid);
		return boardMapper.delete(boardVo);
	}

	@Override
	public BoardVo showContent(int bnum) {
		return boardMapper.read(bnum);
	}

}
