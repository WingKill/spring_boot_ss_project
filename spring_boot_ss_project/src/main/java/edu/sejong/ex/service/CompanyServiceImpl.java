package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.CompanyMapper;
import edu.sejong.ex.vo.DeptEmpVo;
import edu.sejong.ex.vo.DeptSalGradeEmpVo;
import edu.sejong.ex.vo.SalGradeEmpVo;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyMapper companyMapper;
	
	@Override
	public List<DeptEmpVo> showList() {
		return companyMapper.selectDeptEmpList();
	}

	@Override
	public List<SalGradeEmpVo> showListWithGrade() {
		return companyMapper.selectSalGradeEmpList();
	}

	@Override
	public List<DeptSalGradeEmpVo> showListDS() {
		return companyMapper.selectDeptSalGradeEmpList();
	}
	

}
