package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.service.TransactionTestService;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/tx/*")
public class TransactionTestController {

	@Autowired
	private TransactionTestService transactionTestService;
	
	@GetMapping("/{num}")
	public void transaction(@PathVariable("num")int num) {
		log.info("transaction()..");
		
		if(num == 1) {
			transactionTestService.transactionTest1();
		}		
	}
}
