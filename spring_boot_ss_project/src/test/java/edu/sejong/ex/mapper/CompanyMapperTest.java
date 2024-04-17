package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.DeptEmpVo;
import edu.sejong.ex.vo.EmpDeptVo;
import edu.sejong.ex.vo.EmpVo;
import edu.sejong.ex.vo.SalGradeEmpVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class CompanyMapperTest {

	@Autowired
	private CompanyMapper empMapper;
		
	@Test
	void test() {
		assertNotNull(empMapper);
	}
	
	// 기존에 테스트했던, 내가 작성한 코드 테스트 내역
	@Disabled
	@Test
	void testEmpDeptList() {
		for(EmpDeptVo empDept : empMapper.selectEmpDeptList()) {
			log.info("정보 : " + empDept);
		}		 		 
	}
	
	@Test
	void testDeptEmpList() {
		for(DeptEmpVo deptEmp : empMapper.selectDeptEmpList()) {
			log.info("번호 :  " + deptEmp.getDeptno());
			log.info("이름 : " + deptEmp.getDname());
			for(EmpVo emp : deptEmp.getEmpList()) {
				log.info("해당 정보 : " + emp);
			}
		}
	}
	
	@Test
	void testSelectSalGradeEmpList() {
		for(SalGradeEmpVo salGradeEmp : empMapper.selectSalGradeEmpList()) {
			for(EmpVo emp : salGradeEmp.getEmpList()) {
				log.info(salGradeEmp.getGrade() + "등급 : " + emp);
			}
		}
	}

}
