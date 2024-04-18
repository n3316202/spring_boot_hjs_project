package edu.sejong.ex.vo;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//lombok사용하여 생성자2개, getter, setter, toString메소드 생성
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DeptEmpVO {
	private String deptno; // 부서번호
	private String dname; // 부서이름
	private String loc; // 지역
	
	private List<EmpVO> empList;	
	
}
