package edu.sejong.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpDeptVo {
	private int empNo;
	private String ename;
	private String job;
	private String mgr;
	private String hiredate;
	private int sal;
	private String comm;
	private int eDeptno;
	private int dDeptno;
	private String dname;
	private String loc;
}
