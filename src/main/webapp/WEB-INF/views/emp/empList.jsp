<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0"  border="1">
		<tr>
			<td>사원번호</td>
			<td>이름</td>
			<td>월급</td>
			<td>부서번호</td>
			<td>부서이름</td>				
		</tr>
		<c:forEach var="dept" items="${deptEmps}">
			<c:forEach var="emp" items="${dept.empList}">			
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>		
				<td>${emp.sal}</td>			
				<td>${dept.deptno}</td>
				<td>${dept.dname}</td>			
			</tr>
			</c:forEach>
		</c:forEach>	
	</table>

	<hr>
	 <table width="500" cellpadding="0" cellspacing="0"  border="1">
		<tr>
			<td>사원번호</td>
			<td>이름</td>
			<td>월급</td>
			<td>부서번호</td>
			<td>부서이름</td>
			<td>월급등급</td>
			<td>로우셀</td>
			<td>하이셀</td>				
		</tr>
		<c:forEach var="dept" items="${deptEmps}">
			<c:forEach var="emp" items="${dept.getEmpList()}">			
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>		
				<td>${emp.sal}</td>			
				<td>${dept.deptno}</td>
				<td>${dept.dname}</td>
				
				<td>${emp.salGrade.grade}</td>			
				<td>${emp.salGrade.losal}</td>
				<td>${emp.salGrade.hisal}</td>					
			</tr>
			</c:forEach>
		</c:forEach>	
	</table> 
	
</body>
</html>