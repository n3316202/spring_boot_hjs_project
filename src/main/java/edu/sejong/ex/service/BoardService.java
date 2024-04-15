package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.BoardVO;

public interface BoardService {
	List<BoardVO> getList();
	BoardVO get(int bno);
	int remove(int bid);
	int writeBoard(BoardVO board);
	int modifyBoard(BoardVO board);
	//댓글
	public void writeReply(BoardVO board);
}
