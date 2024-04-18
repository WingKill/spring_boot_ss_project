package edu.sejong.ex.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.UserVo;

@Mapper
public interface UserMapper {
	UserVo selectUserAuths(String username);

	public int insertUser(UserVo userVo);

	public void insertAuthorities(UserVo userVo);
}
