package edu.sejong.ex.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.DeptEmpVo;
import edu.sejong.ex.vo.DeptSalGradeEmpVo;
import edu.sejong.ex.vo.EmpVo;
import edu.sejong.ex.vo.SalGradeEmpVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class CompanyServiceImplTest {

	@Autowired
	CompanyService companyService;
	
	@Test
	void test() {
		assertNotNull(companyService);
	}
	
	@Test
	void testShowList() {
		for(DeptEmpVo deptEmp : companyService.showList()) {
			log.info("정보 : " + deptEmp);
			for(EmpVo emp : deptEmp.getEmpList()) {
				log.info("리스트 : " + emp);
			}
		}
	}
	
	@Test
	void testShowListWithGrade() {
		for(SalGradeEmpVo salEmpVo : companyService.showListWithGrade()) {
			log.info("정보 : " + salEmpVo);
			for(EmpVo emp : salEmpVo.getEmpList()) {
				log.info("리스트 : " + emp);
			}
		}
	}
	
//	@Test
//	void testShowListDS() {
//		for(DeptSalGradeEmpVo DsgEmp : companyService.showListDS()) {
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
	void testShowListDS() {
		for (DeptSalGradeEmpVo dsgEmp : companyService.showListDS()) {
			log.info("부서  : " + dsgEmp);
			log.info("등급 : " + dsgEmp.getSalGrade());

			for (EmpVo emp : dsgEmp.getEmpList()) {
				log.info("사원정보 : " + emp);
			}
		}		
	}
}
