package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.DeptEmpVo;
import edu.sejong.ex.vo.DeptSalGradeEmpVo;
import edu.sejong.ex.vo.SalGradeEmpVo;

public interface CompanyService {
	List<DeptEmpVo> showList();
	
	List<SalGradeEmpVo> showListWithGrade();
	
	List<DeptSalGradeEmpVo> showListDS();

}
