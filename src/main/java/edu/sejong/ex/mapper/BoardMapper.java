package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	@Select("select * from mvc_board order by bGroup desc, bStep asc")
	List<BoardVO> getList2();
	
	List<BoardVO> getList();
	
	BoardVO read(int bno);
	int delete(int bid);
	int insertBoard(BoardVO boardVO);
	int updateBoard(BoardVO boardVO);
	int upHit(BoardVO boardVO);
	
	//댓글 관련
	public void updateShape(BoardVO boardVO);		
	public void insertReply(BoardVO boardVO);
	//페이징 관련
	List<BoardVO> getListWithPaging(Criteria cri);
	int getTotalCount();
}
