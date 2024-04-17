package edu.sejong.ex.one;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.vo.BoardVo;

@Service
public class BService2 {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<BoardVo> selectBoardList() throws Exception{
		return sqlSession.selectList("board.selectBoardList");
	}
}
