package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.DeptEmpVO;
import edu.sejong.ex.vo.DeptSalGradeEmpVO;
import edu.sejong.ex.vo.EmpDeptVO;
import edu.sejong.ex.vo.EmpVO;
import edu.sejong.ex.vo.SalGradeEmpVO;
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
		for(EmpDeptVO empDept : empMapper.selectEmpDeptList()) {
			log.info("정보 : " + empDept);
		}		 		 
	}
	
	@Test
	void testDeptEmpList() {
		for(DeptEmpVO deptEmp : empMapper.selectDeptEmpList()) {
			log.info("번호 :  " + deptEmp);
			for(EmpVO emp : deptEmp.getEmpList()) {
				log.info("해당 정보 : " + emp);
			}
		}
	}
	
	@Test
	void testSelectSalGradeEmpList() {
		for(SalGradeEmpVO salGradeEmp : empMapper.selectSalGradeEmpList()) {
			log.info("번호 :  " + salGradeEmp);
			for(EmpVO emp : salGradeEmp.getEmpList()) {
				log.info(salGradeEmp.getGrade() + "등급 : " + emp);
			}
		}
	}
	
//	@Test
//	void testSelectDeptSalGradeEmpList() {
//		for(DeptSalGradeEmpVo DsgEmp : empMapper.selectDeptSalGradeEmpList()) {
//			log.info("부서  : " + DsgEmp);
//			for(SalGradeEmpVo salGradeEmp : DsgEmp.getEmpList()) {
//				log.info("등급  : " + salGradeEmp);
//				for(EmpVo emp : salGradeEmp.getEmpList()) {
//					log.info("사원정보 : " + emp);
//				}
//			}
//		}		
//	}
	
	@Test
	void testSelectDeptSalGradeEmpList() {
		for (DeptSalGradeEmpVO dsgEmp : empMapper.selectDeptSalGradeEmpList()) {
			log.info("부서  : " + dsgEmp);
			for (EmpVO emp : dsgEmp.getEmpList()) {
				log.info("사원정보 : " + emp);
				log.info("등급 : " + emp.getSalGrade().getGrade());
			}
		}
	}
}
