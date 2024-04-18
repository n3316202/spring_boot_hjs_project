package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.DeptEmpVO;
import edu.sejong.ex.vo.EmpDeptVO;
import edu.sejong.ex.vo.EmpVO;

@Mapper
public interface CompanyMapper {
	List<EmpDeptVO> getEmpDept();
	List<DeptEmpVO> getDeptEmpList();	//일대다
}
