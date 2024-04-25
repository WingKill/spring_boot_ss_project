package edu.sejong.ex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.CompanyMapper;
import edu.sejong.ex.vo.EmpDetailsVO;
import edu.sejong.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpCustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("load User By UserVO member : " + username);
		
		EmpVO empVO = companyMapper.selectEmp(username);
		log.warn("queried by empVO mapper : " + empVO);

		return empVO == null ? null : new EmpDetailsVO(empVO);
	}
	
}
