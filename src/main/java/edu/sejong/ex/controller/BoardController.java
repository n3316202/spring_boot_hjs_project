package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.page.PageVO;
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
	
	@GetMapping("/list2")
	public String list2(Criteria criteria, Model model) {
		log.info("list()2..");
		
		model.addAttribute("boards", boardService.getListWithPaging(criteria));	
		
		int total = boardService.getTotal();		
		model.addAttribute("pageMaker",new PageVO(criteria,total) );	
		
		return "/board/list2";
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
	
	@PostMapping("/write")
	public String write(BoardVO boardVO) {
		log.info("write()..");
		
		boardService.writeBoard(boardVO);
		
		return "redirect:/board/list";
	}
	
	//http://localhost:8282/board/reply_view?bid=44
	
	@GetMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model) {
		log.info("reply_view()..");
		
		model.addAttribute("reply_view", boardService.get(boardVO.getBid()));	  
		
		return "/board/reply_view";
	}
	
	
	@PostMapping("/modify")
	public String modify(BoardVO boardVO) {
		log.info("modify()..");
		
		boardService.modifyBoard(boardVO);
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/reply")
	public String reply(BoardVO boardVO) {
		log.info("reply()..");
		
		boardService.writeReply(boardVO);
		
		return "redirect:/board/list";
	}

}
