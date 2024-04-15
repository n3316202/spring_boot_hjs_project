package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model) {
		log.info("list()..");
		
		model.addAttribute("boards",boardService.getList());	
		
		return "/board/list";
	}
	
	//http://localhost:8282/board/content_view?bid=3
	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO,Model model) {
		log.info("content_view()..");
		
		model.addAttribute("content_view",boardService.get(boardVO.getBid()));	
		
		return "/board/content_view";
	}
	
	//http://localhost:8282/board/delete?bid=3
	@GetMapping("/delete")
	public String delete(BoardVO boardVO,Model model) {
		log.info("delete()..");
		
		int bid = boardVO.getBid();		
		boardService.remove(bid);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/write_view")
	public String write_view() {
		log.info("write_view()..");		
		return "/board/write_view";
	}

}
