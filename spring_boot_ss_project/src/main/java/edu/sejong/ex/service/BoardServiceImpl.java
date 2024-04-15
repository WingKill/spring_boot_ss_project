package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.vo.BoardVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVo> showList() {
		log.info("showList()..");
		return boardMapper.selectList();
	}

	@Override
	public int add(BoardVo boardVo) {
		log.info("add()..");
		return boardMapper.insert(boardVo);
	}

	@Override
	public int remove(int bid, BoardVo boardVo) {
		log.info("remove()..");
		boardVo.setBid(bid);
		return boardMapper.delete(boardVo);
	}

	@Override
	public BoardVo showContent(int bnum) {
		log.info("showContent()..");
		return boardMapper.read(bnum);
	}

	@Override
	public int modify(BoardVo boardVo) {
		log.info("showContent()..");
		return boardMapper.update(boardVo);
	}

}
