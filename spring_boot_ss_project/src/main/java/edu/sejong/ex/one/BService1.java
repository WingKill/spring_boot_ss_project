package edu.sejong.ex.one;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.vo.BoardVo;

@Service
public class BService1 {
	
	@Autowired
	//private SqlSession sqlSession;
	private SqlSessionTemplate sqlSession;
	
	public List<BoardVo> selectBoardList() throws Exception{
		IBDao dao = sqlSession.getMapper(IBDao.class);
		return dao.listDao();
	}
}
