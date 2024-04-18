package edu.sejong.ex.vo;

import java.util.List;

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
public class DeptSalGradeEmpVo {
	private int deptno;
	private String dname;
	private String loc;
	
	private SalGradeVo salGrade;
	private List<EmpVo> empList;
	// private List<SalGradeEmpVo> empList;	
}
