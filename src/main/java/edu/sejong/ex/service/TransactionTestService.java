package edu.sejong.ex.service;

import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransactionTestService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Transactional
	public void transetionTest1() {
		
		log.info("transetionTest1() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션1");
		boardVO.setBname("트랜잭션1");
		boardVO.setBtitle("트랜잭션1");
		
		mapper.insertBoard(boardVO);
		
		BoardVO boardVO2 = new BoardVO();
		boardVO2.setBcontent("트랜잭션2");
		boardVO2.setBname("트랜잭션2");
		boardVO2.setBtitle("트랜잭션2");
		
		mapper.insertBoard(boardVO2);
		
	}
	
	public void transetionTest2() {
		
		log.info("transetionTest2() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션1");
		boardVO.setBname("트랜잭션1");
		boardVO.setBtitle("트랜잭션1");
		
		mapper.insertBoard(boardVO);
		
		BoardVO boardVO2 = new BoardVO();
		boardVO2.setBcontent("트랜잭션2");
		boardVO2.setBname("트랜잭션2");
		boardVO2.setBtitle("트랜잭션2");
		
		// 일부러 트랜잭션을 위한 테스트로 null 값을 넣음
		boardVO2 = null;
		mapper.insertBoard(boardVO2);
		
	}
	
	@Transactional //롤백(rollback) 언제: 함수에서 에러가 나면
	public void transetionTest3() {
		
		log.info("transetionTest3() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션3");
		boardVO.setBname("트랜잭션3");
		boardVO.setBtitle("트랜잭션3");
		
		mapper.insertBoard(boardVO);
		
		BoardVO boardVO2 = new BoardVO();
		boardVO2.setBcontent("트랜잭션3");
		boardVO2.setBname("트랜잭션3");
		boardVO2.setBtitle("트랜잭션3");
		
		// 일부러 트랜잭션을 위한 테스트로 null 값을 넣음
		boardVO2 = null;
		mapper.insertBoard(boardVO2);
		
	}
	
	@Transactional  //롤백 함
	public void transetionTest4() {
		
		log.info("transetionTest4() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션4");
		boardVO.setBname("트랜잭션4");
		boardVO.setBtitle("트랜잭션4");		
	
		mapper.insertBoard(boardVO);
		
		throw new RuntimeException("RuntimeException for rollback");
	}
	
	//CheckedExeption 테스트(롤백 안함)
	@Transactional  //롤백 안함
	public void transetionTest5() throws SQLException  {
		
		log.info("transetionTest5() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션5");
		boardVO.setBname("트랜잭션5");
		boardVO.setBtitle("트랜잭션5");		
	
		mapper.insertBoard(boardVO);
		
		throw new SQLException("RuntimeException for rollback");
	}
	
	//@Transactional의 rollbackFor 옵션을 이용하면 Rollback이 되는 클래스를 지정가능함.
	// Exception예외로 롤백을 하려면 다음과 같이 지정하면됩니다. 
	//@Transactional(rollbackFor = Exception.class) 
	// 여러개의 예외를 지정할 수도 있습니다. 
	//@Transactional(rollbackFro = {RuntimeException.class, Exception.class})
	@Transactional(rollbackFor = Exception.class) 
	public void transetionTest6() throws SQLException  {
		
		log.info("transetionTest6() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션6");
		boardVO.setBname("트랜잭션6");
		boardVO.setBtitle("트랜잭션6");		
	
		mapper.insertBoard(boardVO);
		
		throw new SQLException("RuntimeException for rollback");
	}
	
	@Transactional(rollbackFor = SQLException.class) 
	public void transetionTest7() throws SQLException  {
		
		log.info("transetionTest7() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션7");
		boardVO.setBname("트랜잭션7");
		boardVO.setBtitle("트랜잭션7");		
	
		mapper.insertBoard(boardVO);
		
		throw new SQLException("RuntimeException for rollback");
	}
	
	
}
