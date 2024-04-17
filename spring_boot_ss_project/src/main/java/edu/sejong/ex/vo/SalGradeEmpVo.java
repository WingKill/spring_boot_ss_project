package edu.sejong.ex.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SalGradeEmpVo {
	private int grade;
	private int losal;
	private int hisal;
	private List<EmpVo> empList;
}
