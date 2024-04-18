package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.service.CompanyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/bshoper")
public class HomeController {
	/*
	 * 예시파일을 사용하는 상태 
	 */ 
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("")
	public String companyListAll(Model model) {
		log.info("companyList()..");
		model.addAttribute("lists", companyService.showListDS());
		return "/company/showindex";
	}
}
