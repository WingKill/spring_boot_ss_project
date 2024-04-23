package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.CompanyMapper;
import edu.sejong.ex.vo.DeptEmpVO;
import edu.sejong.ex.vo.DeptSalGradeEmpVO;
import edu.sejong.ex.vo.SalGradeEmpVO;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyMapper companyMapper;
	
	@Override
	public List<DeptEmpVO> showList() {
		return companyMapper.selectDeptEmpList();
	}

	@Override
	public List<SalGradeEmpVO> showListWithGrade() {
		return companyMapper.selectSalGradeEmpList();
	}

	@Override
	public List<DeptSalGradeEmpVO> showListDS() {
		return companyMapper.selectDeptSalGradeEmpList();
	}
	

}
