package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.DeptEmpVO;
import edu.sejong.ex.vo.DeptVO;
import edu.sejong.ex.vo.EmpDeptVO;
import edu.sejong.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class CompanyMapperTest {

	@Autowired
	private CompanyMapper companyMapper;
	
	@Test
	void testCompanyMapper() {
		assertNotNull(companyMapper);
	}
	
	@Disabled
	@Test
	void testGetEmpDeptList() {
		for(EmpDeptVO vo : companyMapper.getEmpDept()) {
			System.out.println("확인==================" + vo );
			 //log.info("사원번호:" + vo.getEmpno() ); log.info("사원이름:" + vo.getEname() );
			 //log.info("부서번호:" + vo.getDeptno() ); log.info("부서번호:" + vo.getDname() );
		
		}		
	}
	
	@Test
	void testGetDeptEmpList() {
		
		System.out.println(companyMapper);
		System.out.println(companyMapper.getDeptEmpList().size());
		
		for (DeptEmpVO vo : companyMapper.getDeptEmpList()) {
				System.out.println(vo);
				
				for (EmpVO emp : vo.getEmpList()) {
					System.out.println(emp);
				}				
			}
	}
}
