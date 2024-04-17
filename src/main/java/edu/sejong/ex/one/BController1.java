package edu.sejong.ex.one;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/*
1.interface IBDao를  XML namespac에 매핑 <mapper namespace="edu.bit.ex.board1.IBDao"> 
2.sqlSession.getMapper(IBDao.class)를 이용.
* 
* 
* */
@Controller
public class BController1 {

	@Autowired
	BService1 bservice;
	
	@RequestMapping("/one")
	public String list(Model model) throws Exception{
		System.out.println("one()");	
		
		model.addAttribute("boards", bservice.selectBoardList());			
		return "/board/list";		
	}

}
