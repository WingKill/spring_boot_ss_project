package edu.sejong.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.UserMapper;
import edu.sejong.ex.vo.AuthVo;
import edu.sejong.ex.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
//	@Override
//	public void signUp(UserVo userVo, AuthVo authVo) {
//		userVo.getAuthorities().add(authVo);
//		userMapper.insertUser(userVo);
//		userMapper.insertAuthorities(userVo);
//	}

}
