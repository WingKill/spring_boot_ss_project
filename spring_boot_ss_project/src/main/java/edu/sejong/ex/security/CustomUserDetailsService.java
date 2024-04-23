package edu.sejong.ex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.UserMapper;
import edu.sejong.ex.vo.UserDetailsVO;
import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("load User By UserVo member : " + username);
		
		UserVO user = userMapper.selectUserAuths(username);
		
		log.warn("load User By UserVo mapper : " + user);
		
		return user == null ? null : new UserDetailsVO(user);
	}
	
}