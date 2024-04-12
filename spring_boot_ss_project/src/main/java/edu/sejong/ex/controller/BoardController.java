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

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/list.do")
	public String BoardList(Model model) {
		model.addAttribute("boards", boardService.showList());
		return "/board/board_list";
	}
	
	@PostMapping("/write.do")
	public String BoardAdd(BoardVo boardVo) {
		boardService.add(boardVo);
		return "redirect:/board/list.do";
	}
	
	@PostMapping("/delete.do")
	public String removeOne(@RequestParam("bid")int bid ,BoardVo boardVo) {
		boardService.remove(bid, boardVo);
		return "redirect:/board/list.do";
	}
}
