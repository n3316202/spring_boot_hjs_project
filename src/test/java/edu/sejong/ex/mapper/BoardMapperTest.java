package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import oracle.net.aso.b;

@Slf4j
@SpringBootTest
class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	void testBoardMapper() {
		assertNotNull(boardMapper);		
	}

	@Disabled
	@Test
	void testSelectList() {
		for(BoardVO boardVO : boardMapper.getList()) {
			log.info("확인==================" + boardVO );
		}		
	}
	
	@Test
	void testSelectList2() {
		for(BoardVO boardVO : boardMapper.getList2()) {
			log.info("확인==================" + boardVO );
		}		
	}
	
	@Disabled
	@Test
	void testRead() {
		System.out.println(boardMapper.read(1));
		
	}
}
