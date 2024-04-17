package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.EmpDeptVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class EmpMapperTest {

	@Autowired
	private EmpMapper empMapper;
		
	@Test
	void test() {
		assertNotNull(empMapper);
	}
	
	@Test
	void testSelectJoinList1() {
		for(EmpDeptVo empDept : empMapper.selectJoinList1()) {
			log.info("정보 : " + empDept);
		}		 
	}

}
