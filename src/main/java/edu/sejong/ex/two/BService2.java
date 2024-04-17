package edu.sejong.ex.two;

import java.util.List;



import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.vo.BoardVO;




@Service
public class BService2 {
	
	@Autowired
	//private SqlSession sqlSession;
	private SqlSessionTemplate sqlSession;
	
    public List<BoardVO> selectBoardList() throws Exception {
    	return  sqlSession.selectList("board.selectBoardList");
    }

}
