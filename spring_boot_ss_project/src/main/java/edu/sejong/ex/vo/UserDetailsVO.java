package edu.sejong.ex.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.sejong.ex.security.CustomNoOpPasswordEncoder;
import edu.sejong.ex.vo.AuthVO;
import edu.sejong.ex.vo.UserVO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Setter
public class UserDetailsVO implements UserDetails {

	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	
	// 테스트 코드
	private String email = "admin@admin.com";
	private EmpVO emp = null;
	private CartVO cart = new CartVO();
	
	
	public String getEmail() {
		return this.email;
	}
	
	public EmpVO getEmp() {
		return this.emp;
	}
	
	public CartVO getCart() {
		return this.cart;
	}
	
	public UserDetailsVO(UserVO user) {
		this.setUsername(user.getUserName());
		this.setPassword(user.getPassword());
		this.setAuthorities(user);
	}
	
	public UserDetailsVO(UserVO user, EmpVO empVO) {
		this.setUsername(user.getUserName());
		this.setPassword(user.getPassword());
		this.setAuthorities(user);
		
		this.emp = empVO;
	}
	
	public UserDetailsVO(EmpVO empVO) {
		log.info("===");
		log.info("UserDetailsVO로 들어온 EmpVO : " + empVO);
		log.info("===");
		this.setUsername(empVO.getEname());
		this.setPassword(String.valueOf((empVO.getEmpNo())));
		this.setAuthorities("ROLE_USER");
	}

	private void setAuthorities(String authority) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();	
		authorities.add(new SimpleGrantedAuthority(authority));
		this.authorities = authorities;
	}
	
	
	private void setAuthorities(UserVO userVO) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for(AuthVO authVo : userVO.getAuthorities()) {
			authorities.add(new SimpleGrantedAuthority(authVo.getAuthority()));
		}
		
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;		
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
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
