package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.DeptEmpVo;
import edu.sejong.ex.vo.DeptSalGradeEmpVo;
import edu.sejong.ex.vo.EmpDeptVo;
import edu.sejong.ex.vo.SalGradeEmpVo;

@Mapper
public interface CompanyMapper {
	// 내가 작성했던 코드 내역
	List<EmpDeptVo> selectEmpDeptList();
	
	
	List<DeptEmpVo> selectDeptEmpList();
	
	List<SalGradeEmpVo> selectSalGradeEmpList(); 
	
	List<DeptSalGradeEmpVo> selectDeptSalGradeEmpList();
}
