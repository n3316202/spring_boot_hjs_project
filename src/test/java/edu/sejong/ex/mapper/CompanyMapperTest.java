package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.EmpDeptVO;
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
	@Test
	void testGetEmpDept() {
		for(EmpDeptVO vo : companyMapper.getEmpDept()) {
			log.info("확인==================" + vo );
			log.info("사원번호:" + vo.getEmpno() );
			log.info("사원이름:" + vo.getEname() );
			log.info("부서번호:" + vo.getDeptno() );
			log.info("부서번호:" + vo.getDname() );
			
			
		}		
	}
	

}
