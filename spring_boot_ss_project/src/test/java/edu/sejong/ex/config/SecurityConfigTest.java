package edu.sejong.ex.config;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class SecurityConfigTest {

	@Autowired
	private MockMvc mockMvc;

	
	// 관리자(ROLE_ADMIN)
	@Test
	@WithMockUser(username = "admin", password = "admin", authorities = "ROLE_ADMIN")
	void testAdminPage() throws Exception {
		// 관리자 홈
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminHome"))
		   	   .andExpect(MockMvcResultMatchers.status().isOk())			 
		   	   .andDo(print());
		
		// 관리자 회원 관리 페이지
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/memberList"))
		   	   .andExpect(MockMvcResultMatchers.status().isOk())			 
		   	   .andDo(print());
				
		// 관리자 상품 관리 페이지
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/productManagement"))
		   	   .andExpect(MockMvcResultMatchers.status().isOk())			 
		   	   .andDo(print());
	}

	// 유저(ROLE_USER)
	@Test
	@WithMockUser(username = "user", password = "user", authorities = "ROLE_USER")
	void testUserPage() throws Exception {
		// 관리자 홈
		mockMvc.perform(MockMvcRequestBuilders.get("/user/userHome"))
		   	   .andExpect(MockMvcResultMatchers.status().isOk())			 
		   	   .andDo(print());
	}
	
}
