package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVo;

@Mapper
public interface BoardMapper {
	@Select("SELECT * FROM MVC_BOARD ORDER BY bgroup desc, bstep asc")
	List<BoardVo> selectList2();
	
	List<BoardVo> selectList();
	int insertBoard(BoardVo boardVo);
	int deleteBoard(BoardVo boardVo);
	BoardVo read(int bnum);
	int updateBoard(BoardVo boardVo);
	int updateHit(int bnum);
	
	// 댓글 관련
	int updateShape(BoardVo boardVo);
	int insertReply(BoardVo boardVo);
	
	// 페이징 관련
	List<BoardVo> selectListWithPaging(Criteria cri);
	int selectTotalCount();
}
