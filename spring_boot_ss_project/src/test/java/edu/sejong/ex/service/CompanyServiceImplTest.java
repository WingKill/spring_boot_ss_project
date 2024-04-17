package edu.sejong.ex.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.DeptEmpVo;
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
		}
	}
}
