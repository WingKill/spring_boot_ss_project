package edu.sejong.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
 
   @GetMapping("/login")
   public String login(Model model) {
      log.info("login()..");
      
      return "login/login";
   }
   
//   @GetMapping("/elogin")
//   public String elogin(Model model) {
//      log.info("elogin()..");
//      
//      return "login/elogin";
//   }
   
   @GetMapping("/logout")
   public String logout(Model model) {
	   log.info("logout()..");
	   
	   return "redirect:/elogin";
   }
}