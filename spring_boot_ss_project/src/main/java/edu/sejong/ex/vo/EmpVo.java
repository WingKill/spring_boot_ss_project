package edu.sejong.ex.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//이름       널?       유형           
//-------- -------- ------------ 
//EMPNO    NOT NULL NUMBER(4)    
//ENAME             VARCHAR2(10) 
//JOB               VARCHAR2(9)  
//MGR               NUMBER(4)    
//HIREDATE          DATE         
//SAL               NUMBER(7,2)  
//COMM              NUMBER(7,2)  
//DEPTNO            NUMBER(2)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpVo {
	private int empNo;
	private String ename;
	private String job;
	private String mgr;
	private Timestamp hiredate;
	private int sal;
	private String comm;
	private int deptno;
	
	private SalGradeVo salGrade;
	
	public int getRandomNum() {
		return (int)(Math.random()*6 + 1);
	}
}
