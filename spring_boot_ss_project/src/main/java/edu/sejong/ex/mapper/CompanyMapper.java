package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.sejong.ex.vo.DeptEmpVO;
import edu.sejong.ex.vo.DeptSalGradeEmpVO;
import edu.sejong.ex.vo.EmpDeptVO;
import edu.sejong.ex.vo.EmpVO;
import edu.sejong.ex.vo.SalGradeEmpVO;

@Mapper
public interface CompanyMapper {
	// 내가 작성했던 코드 내역
	List<EmpDeptVO> selectEmpDeptList();
	
	
	List<DeptEmpVO> selectDeptEmpList();
	
	List<SalGradeEmpVO> selectSalGradeEmpList(); 
	
	List<DeptSalGradeEmpVO> selectDeptSalGradeEmpList();
	
	@Select("select * from emp where ename=#{ename}")
	EmpVO selectEmp(String ename);
}
