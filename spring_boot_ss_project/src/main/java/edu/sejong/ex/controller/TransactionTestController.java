package edu.sejong.ex.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.service.TransactionTestService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/tx/*")
public class TransactionTestController {

	@Autowired
	private TransactionTestService transactionTestService;
	
	@GetMapping("/{num}")
	public void transaction(@PathVariable("num")int num) throws SQLException {
		log.info("transaction()..");
		
		if(num == 1) {
			transactionTestService.transactionTest1();
		}
		
		if(num == 2) {
			transactionTestService.transactionTest2();
		}	
		
		if(num == 3) {
			transactionTestService.transactionTest3();
		}
		
		if(num == 4) {
			transactionTestService.transactionTest4();
		}
		
		if(num == 5) {
			transactionTestService.transactionTest5();
		}
		
		if(num == 6) {
			transactionTestService.transactionTest6();
		}
		
		if(num == 7) {
			transactionTestService.transactionTest7();
		}
	}
}
