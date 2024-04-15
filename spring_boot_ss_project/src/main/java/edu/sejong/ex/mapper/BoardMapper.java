package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.BoardVo;

@Mapper
public interface BoardMapper {
	List<BoardVo> selectList();
	int insertBoard(BoardVo boardVo);
	int deleteBoard(BoardVo boardVo);
	BoardVo read(int bnum);
	int updateBoard(BoardVo boardVo);
	int updateHit(int bnum);
	
	// 댓글 관련
	int updateShape(BoardVo boardVo);
	int insertReply(BoardVo boardVo);
}
