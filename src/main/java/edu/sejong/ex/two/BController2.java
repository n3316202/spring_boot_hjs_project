package edu.sejong.ex.two;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class BController2{

	@Autowired
	private BService2 bservice;
	
	@RequestMapping("/two")
	public String list(Model model) throws Exception{
		System.out.println("two()");	
		
		model.addAttribute("boards", bservice.selectBoardList());			
		return "/board/list";		
	}

}
