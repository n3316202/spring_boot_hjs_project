<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/board.js"></script>

<script type="text/javascript">
	/* 
	$.ajax({
	  type : `http method type`,
	  url : `url`,
	  data : `서버에 전송할 데이터`,
	  contentType : "전송할 데이터 타입",
	  //기본 값 : "application / x-www-form-urlencoded; charset = UTF-8"  
	  dataType : '서버로 부터 수신할 데이터 타입',
	  //아무것도 지정하지 않으면 jQuery는 응답의 MIME 유형을 기반으로 해석을 시도
	  error : `에러 발생시 수행할 함수`,
	  success : `성공시 수행할 함수`
	}); 
	*/
	$(document).ready(function(){
		
		 //boardService().test()		
		//boardService.test();
	
		
		function makeList(result) {
			let htmls = "";
			
			$("#list-table").html("");
			
			$("<tr>" , {
				html : "<td>" + "번호" + "</td>" +  // 컬럼명들
						"<td>" + "이름" + "</td>" +
						"<td>" + "제목" + "</td>" +
						"<td>" + "날짜" + "</td>" +				
						"<td>" + "히트" + "</td>"
			}).appendTo("#list-table") // 이것을 테이블에 붙임

			if(result.length < 1){
				htmls.push("등록된 게시글 없습니다.");
			}else{
				$(result).each(function(){
					htmls += '<tr>';
					htmls += '<td>' + this.bid + '</td>';
					htmls += '<td>' + this.bname + '</td>';
					htmls += '<td>'					
					for(var i=0; i < this.bindent; i++) { 
	         			htmls += '-'	
	        		}
					htmls += '<a href="${pageContext.request.contextPath}/content_view?bid=' + this.bid + '">' + this.btitle + '</a></td>';
		            htmls += '<td>'+ this.bdate + '</td>'; 
	                htmls += '<td>'+ this.bhit + '</td>';
	                htmls += '<td>'+ '<input id=' + this.bid + " type='button' class='btn_delete' value='삭제'>" + '</td>';
	                htmls += '</tr>';
				}); //each end

			}

			htmls+='<tr>';
	        htmls+='<td colspan="5"> <a href="${pageContext.request.contextPath}/write_view">글작성</a> </td>';		                	
	        htmls+='</tr>';

			$("#list-table").append(htmls);
			
		}
		
		//boardService.list(makeList);
	
		//getBoard(328);
		//deleteBoard(348);
		
		boardService.get(328);
		boardService.del(348);

		
		function writeBoard(board){
			
			$.ajax({
				type:"POST",
				contentType:'application/json; charset=utf-8',
				url: "${pageContext.request.contextPath}/boards/",
				data: JSON.stringify(board),
				success: function(result){
					console.log(result);
				},
				error: function(e){
					console.log(e);
				}
			});
		}
		
		function modifyBoard(board){
			
			$.ajax({
				type: "PUT",
				contentType:'application/json; charset=utf-8',
				url: "${pageContext.request.contextPath}/boards/" + board.bid ,
				data: JSON.stringify(board),
				success: function(result){
					console.log(result);
					boardList();
				},
				error: function(e){
					console.log(e);
				}
			});
		}
		
		
		//let board = {
		//		bname : "홍길동",
		//		bcontent : "포스트로 인서트",
		//		btitle : "안녕히 게숑"				
		//};
		
		//writeBoard(board);
		//boardList();
		
		let board = {
				bid : 1062,
				bname : "고무구구구구",
				bcontent : "호박",
				btitle : "바뀌었다"				
		};
		
		//modifyBoard(board);
		
		//deleteBoard(348);
		
		//getBoard(328);
		//getBoard(347);
		//getBoard(348);
		//boardList();
		
		$(document).on("click","#list-table .btn_delete",function(){
			console.log(this);
			
			let bid = $(this).attr("id");

			deleteBoard(bid);
			$(this).parent().parent().remove();


		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function(){

	});
</script>


</head>
<body>
	<table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">
	</table>
</body>
</html>