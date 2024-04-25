package edu.sejong.ex.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.page.PageVO;
import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.service.TransactionTestService;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/tx/*")
public class TransactionTestController {

	 @Autowired
	 private TransactionTestService transactionTestService;
	
	@GetMapping("/{num}")
	public String transaction(@PathVariable("num") int num) throws SQLException {
		log.info("transaction()..============" + num);
		
		if(num == 1) {
			transactionTestService.transetionTest1();
		}
		
		if(num == 2) {
			transactionTestService.transetionTest2();
		}
		
		if(num == 3) {
			transactionTestService.transetionTest3();
		}
		
		
		if(num == 4) {
			transactionTestService.transetionTest4();
		}
		
		if(num == 5) {
			transactionTestService.transetionTest5();
		}
		
		//가장 기본 적인 트랜잭션 에러 처리 
		if(num == 6) {
			transactionTestService.transetionTest6();
		}
		
		if(num == 7) {
			transactionTestService.transetionTest7();
		}
		
		return "redirect:/board/list2";
				
	}
}
