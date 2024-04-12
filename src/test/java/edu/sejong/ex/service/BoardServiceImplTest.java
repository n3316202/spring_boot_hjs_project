package edu.sejong.ex.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BoardServiceImplTest {
	
	@Autowired
	private BoardService boardService;
	
	@Test
	void testBoardService() {
		assertNotNull(boardService);		
	}

	@Test
	void testSelectList() {
		for(BoardVO boardVO : boardService.getList()) {
			log.info("확인==================" + boardVO );
		}		
	}

}
