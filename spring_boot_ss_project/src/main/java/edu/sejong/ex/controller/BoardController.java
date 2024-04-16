package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.page.PageVo;
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

	@GetMapping("/list")
	public String BoardList(Model model) {
		log.info("BoardList()..");
		model.addAttribute("boards", boardService.showList());
		//return "/board/list";
		return "/board/boardlist";
	}
	
	@GetMapping("/list2")
	public String BoardList2(Criteria criteria, Model model) {
		log.info("BoardList2()..");
		model.addAttribute("boards", boardService.showListWithPaging(criteria));
		
		int total = boardService.getTotal();
		model.addAttribute("pageMaker", new PageVo(total, criteria));
		
		return "/board/boardlist2";
	}
	
		
	@PostMapping("/write")
	public String addOne(BoardVo boardVo) {
		log.info("addOne()..");
		boardService.addBoard(boardVo);
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete")
	@PostMapping("/delete")
	public String removeOne(@RequestParam("bid")int bid ,BoardVo boardVo) {
		log.info("removeOne()..");
		boardService.removeBoard(bid, boardVo);
		return "redirect:/board/list";
	}
	
	@GetMapping("/content_view")
	public String showView(BoardVo boardVo, Model model) {
		log.info("showView()..");
		model.addAttribute("content_view", boardService.showContent(boardVo.getBid()));
		return "/board/content_view";
	}
	
	@PostMapping("/modify_view")
	public String modifyView(BoardVo boardVo, Model model) {
		log.info("modifyView()..");
		model.addAttribute("modify_view", boardVo);
		return "/board/modify_view";
	}
	
	@GetMapping("/write_view")
	public String writeView() {
		log.info("writeView()..");
		return "/board/write_view";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVo boardVo) {
		boardService.modifyBoard(boardVo);
		return "redirect:/board/list";
	}

	//댓글 관련
	
	@GetMapping("/reply_view")
	public String replyView(BoardVo boardVo, Model model) {
		log.info("replyView()..");
		model.addAttribute("reply_view", boardService.showReply(boardVo));
		return "/board/reply_view";
	}
	
	@PostMapping("/reply")
	public String reply(BoardVo boardVo) {
		log.info("reply()..");
		boardService.writeReply(boardVo);
		return "redirect:/board/list";
	}
}
