package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.sejong.ex.service.CompanyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

   @Autowired
   private CompanyService companyService;   
   
   @GetMapping("/")
   public String home(Model model) {
      log.info("home()..");
      
      return "home";
   }
   
   @GetMapping("/index")
   public String index(Model model) {
      log.info("index()..");
      
      model.addAttribute("list",companyService.showList());   
      
      return "index";
   }
   
   @GetMapping("/user/userHome")
   public void userHome() {
	   log.info("userHome()..");
   }
   
   @GetMapping("/admin/adminHome")
   public void adminHome() {
	   log.info("adminHome()..");
   }
}