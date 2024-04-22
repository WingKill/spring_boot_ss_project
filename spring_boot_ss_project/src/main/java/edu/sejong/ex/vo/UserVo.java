package edu.sejong.ex.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVo {
	private String userName;
	private String password;
	private String enabled;
	
	private List<AuthVo> authorities;

	public UserVo(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}	
}