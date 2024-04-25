package edu.sejong.ex.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
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
	   
	   //return "redirect:/elogin";
	   return "redirect:/login";
   }
   
  
   @GetMapping("/loginInfo")
   public String loginInfo(Authentication authentication, Principal principal, Model model) {
	   // 로그인 정보를 체크하는 첫번째 방법 - Principal principal 객체를 갖고 오기
	   if(principal != null) {
		   System.out.println("타입 정보 : " + principal.getClass());
		   System.out.println("ID 정보 : " + principal.getName());
	   }
	   
	   // 로그인 정보를 체크하는 두번째 방법 - Authentication authentication 객체를 갖고 오기
	   if(authentication != null) {
		   System.out.println("타입 정보 : " + authentication.getClass());
		   UserDetails user = (UserDetails) authentication.getPrincipal();
		   System.out.println("아이디 : " + user.getUsername());
		   System.out.println("패스워드 : " + user.getPassword());
		   System.out.println("권한들 : " + user.getAuthorities());
	   }	   
	   WebAuthenticationDetails web = (WebAuthenticationDetails) authentication.getDetails();
	   
	   System.out.println("세션 ID : " + web.getSessionId() );
	   System.out.println("접속 IP : " + web.getRemoteAddress() );
	   
	   // 로그인 정보를 체크하는 세 번째 방법 - SecurityContextHolder 를 바로 가져오기 
	   
	   UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   if(user != null) {
		   System.out.println("아이디 : " + user.getUsername());
		   System.out.println("패스워드 : " + user.getPassword());
		   System.out.println("권한들 : " + user.getAuthorities());
	   }
	   
	   return "login/login";
   }
}