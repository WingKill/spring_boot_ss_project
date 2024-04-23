package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.DeptEmpVO;
import edu.sejong.ex.vo.DeptSalGradeEmpVO;
import edu.sejong.ex.vo.SalGradeEmpVO;

public interface CompanyService {
	List<DeptEmpVO> showList();
	
	List<SalGradeEmpVO> showListWithGrade();
	
	List<DeptSalGradeEmpVO> showListDS();

}
