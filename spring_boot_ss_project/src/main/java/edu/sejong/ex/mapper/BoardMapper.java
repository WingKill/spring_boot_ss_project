package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.BoardVo;

@Mapper
public interface BoardMapper {
	List<BoardVo> selectList();
	int insert(BoardVo boardVo);
	int delete(BoardVo boardVo);
}
