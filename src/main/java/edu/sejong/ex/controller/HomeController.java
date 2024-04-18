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
import edu.sejong.ex.service.EmpService;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	private EmpService empService;	
	
	@GetMapping("/index")
	public String index(Model model) {
		log.info("index()..");
		
		model.addAttribute("deptEmps",empService.getDeptEmpList());	
		
		return "index";
	}
	
	

}
