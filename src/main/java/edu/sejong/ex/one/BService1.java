package edu.sejong.ex.one;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.vo.BoardVO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

@Service
public class BService1 {
	
	@Autowired
	//private SqlSession SqlSession; //마이바티스
	private SqlSessionTemplate sqlSession; //마이바티스
	
	public List<BoardVO> selectBoardList() throws Exception{
		IBDao dao = sqlSession.getMapper(IBDao.class);
		return dao.listDao();
	}	
}
