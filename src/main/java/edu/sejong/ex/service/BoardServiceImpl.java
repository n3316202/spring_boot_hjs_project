package edu.sejong.ex.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getList() {
		log.info("getList().. ");
		
	
		return boardMapper.getList();
	}

	@Override
	public BoardVO get(int bno) {
		log.info("get().. ");
		
		BoardVO board = new BoardVO();
		board.setBid(bno);
		
		boardMapper.upHit(board);
		
		return boardMapper.read(bno);
	}

	@Override
	public int remove(int bid) {
		log.info("remove().. ");
		
		return boardMapper.delete(bid);
	}

	@Override
	public int writeBoard(BoardVO board) {
		log.info("writeBoard().. ");
		
		return boardMapper.insertBoard(board);
	}

	@Override
	public int modifyBoard(BoardVO board) {
		log.info("modifyBoard().. ");
		
		return boardMapper.updateBoard(board);
	}

	@Override
	public void writeReply(BoardVO board) {
		log.info("writeReply().. ");
		
		boardMapper.updateShape(board);
		boardMapper.insertReply(board);	
		
	}

	@Override
	public void upHit(BoardVO board) {
		log.info("upHit().. ");
		boardMapper.upHit(board);
	}

	@Override
	public int getTotal() {
		
		log.info("getTotal()..");
		
		return boardMapper.getTotalCount();
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		log.info("getListWithPaging()..");
		
		return boardMapper.getListWithPaging(cri);
	}

}
