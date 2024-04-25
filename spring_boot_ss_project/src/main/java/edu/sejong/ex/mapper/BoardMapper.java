package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> selectList();
	int insertBoard(BoardVO boardVo);
	int deleteBoard(BoardVO boardVo);
	BoardVO read(int bnum);
	int updateBoard(BoardVO boardVo);
	int updateHit(int bnum);
	
	// 댓글 관련
	int updateShape(BoardVO boardVo);
	int insertReply(BoardVO boardVo);
	
	// 페이징 관련
	List<BoardVO> selectListWithPaging(Criteria cri);
	int selectTotalCount();
}
