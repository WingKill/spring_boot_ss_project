package edu.sejong.ex.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Setter
public class EmpDetailsVO implements UserDetails {

	private EmpVO emp = null;
		
	public EmpDetailsVO(EmpVO empVO) {
		this.emp = empVO;
		log.info("emp : " + this.emp);
	}

	public EmpVO getEmp() {
		return emp;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return String.valueOf(emp.getEmpNo());		
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return emp.getEname();
	}

	// 계정이 만료되지 않았는가?
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	// 계정이 잠기지 않았는가?
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	// 패스워드가 만료되지 않았는가?
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	// 계정이 활성화되어 있는가?
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
