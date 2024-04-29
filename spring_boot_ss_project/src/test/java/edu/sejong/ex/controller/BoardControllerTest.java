package edu.sejong.ex.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Disabled
	@Test
	void testHome() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
			   .andExpect(MockMvcResultMatchers.status().isOk())
			   .andDo(print());
	}

	@Disabled
	@Test
	void testBoard() throws Exception{		
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
			   .andExpect(MockMvcResultMatchers.status().isOk())			 
               .andDo(print());
	}
	
	@Test
	void testBoardLists() throws Exception{		
//		mockMvc.perform(MockMvcRequestBuilders.get("/board/list2"))
//			   .andExpect(MockMvcResultMatchers.status().isOk())
//			   .andExpect(MockMvcResultMatchers.view().name("/board/boardlist2"))
//               .andExpect(MockMvcResultMatchers.model().attributeExists("boards"))
//               .andExpect(MockMvcResultMatchers.model().attributeExists("pageMaker"))
//               .andExpect(MockMvcResultMatchers.model().attribute("pageMaker", Matchers.hasProperty("criteria")))
//               .andExpect(MockMvcResultMatchers.model().attribute("pageMaker", Matchers.hasProperty("criteria", Matchers.hasProperty("pageNum", equalTo(1)))))
//               .andExpect(MockMvcResultMatchers.model().attribute("pageMaker", Matchers.hasProperty("criteria", Matchers.hasProperty("amount", equalTo(10)))))
//               .andDo(print());
		
//		mockMvc.perform(MockMvcRequestBuilders.get("/board/list2?pageNum=1&amount=10"))
//				.andExpect(MockMvcResultMatchers.status().isOk())			 
//		        .andDo(print());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/board/list2")
				.param("pageNum", "2")
				.param("amount", "10"))
				.andExpect(MockMvcResultMatchers.status().isOk())			 
				.andDo(print());
		
	}
	
	@Disabled
	@Test
	void testBoardJson() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/boards/list"))
			   .andExpect(MockMvcResultMatchers.status().isOk())
			   .andDo(print());
	}
}
