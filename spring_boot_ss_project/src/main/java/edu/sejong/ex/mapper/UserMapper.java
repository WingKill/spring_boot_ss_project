package edu.sejong.ex.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.UserVO;

@Mapper
public interface UserMapper {
	UserVO selectUserAuths(String username);

	public int insertUser(UserVO userVo);

	public void insertAuthority(UserVO userVo);
}
