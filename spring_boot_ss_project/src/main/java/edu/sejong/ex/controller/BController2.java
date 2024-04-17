package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.one.BService2;
import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.page.PageVo;
import edu.sejong.ex.service.BoardService;


/*
 * 마이바티스 2번째 사용 방법
 * 1. interface는 필요가 없음
 * 2. sqlSession에서 제공하는 함수(selectList, selectOne)를 이용함
 * 3. 쿼리 구현을 위한  XML이 필요. 해당 XML의 namespace는 개발자가 정함
 */
@Controller
@RequestMapping("/two")
public class BController2 {
	@Autowired
	private BService2 bService2;
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception{
		System.out.println("list()..");
		model.addAttribute("boards", bService2.selectBoardList());
		return "/board/list";
	}
	
	@RequestMapping("/list2")
	public String list2(Model model, Criteria criteria) throws Exception{
		System.out.println("list2()..");
		//model.addAttribute("boards", bService2.selectBoardList());
		model.addAttribute("boards", bService2.selectBoardPagingList(criteria));
		int total = bService2.selectBoardTotal();
		model.addAttribute("pageMaker", new PageVo(total, criteria));
		return "/board/list";
	}
}
