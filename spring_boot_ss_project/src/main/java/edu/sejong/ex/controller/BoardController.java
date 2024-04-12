package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.vo.BoardVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	/*
	 * 예시파일을 사용하는 상태 
	 */ 
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/list.do")
	public String BoardList(Model model) {
		log.info("BoardList()..");
		model.addAttribute("boards", boardService.showList());
		//return "/board/list";
		return "/board/boardlist";
	}
	
		
	@PostMapping("/write.do")
	public String addOne(BoardVo boardVo) {
		log.info("addOne()..");
		boardService.add(boardVo);
		return "redirect:/board/list.do";
	}
	
	@GetMapping("/delete.do")
	@PostMapping("/delete.do")
	public String removeOne(@RequestParam("bid")int bid ,BoardVo boardVo) {
		log.info("removeOne()..");
		boardService.remove(bid, boardVo);
		return "redirect:/board/list.do";
	}
	
	@GetMapping("/content_view")
	public String showOne(@RequestParam("bid")int bid, Model model) {
		model.addAttribute("content_view", boardService.showContent(bid));
		return "/board/content_view";
	}
}
