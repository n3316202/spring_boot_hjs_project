package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.DeptEmpVO;


public interface EmpService {
	List<DeptEmpVO> getDeptEmpList();	//일대다
	
}
