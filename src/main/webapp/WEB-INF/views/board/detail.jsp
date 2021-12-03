<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>detail.jsp</h2>
	
	글번호: ${board.b_number}
	작성자: ${board.b_writer}
	제목: ${board.b_title}
	내용: ${board.b_contentsl}
	작성일자: ${board.b_hits}
	조회수: ${board.b_date}
	<a href="/board/delete?b_number=${board.b_number}">삭제</a>
	<a href="/board/update?b_number=${board.b_number}&page=${page}">수정</a>
	<a href="/board/paging?page=${page}">목록</a>
	
	<!-- 수정기능에 페이징 추가
		수정 처리 완료 후 상세페이지를 띄우고 거기서 목록링크를 클릭하면 직전 페이지로 돌아가도록 코드를 살짝 수정해봅시다. -->
	
	<!-- datail.jsp에서 수정, 삭제, 목록 링크를 각가 만들고 수정, 삭제기능을 구현해 봅시다
			1. 삭제기능: 삭제 클릭하면 삭제 처리하거 목록 출력
			2. 수정기능: 수정 클릭하면 수정화면(update.jsp)출력 후 제목, 내용만 수정하도록 하고 
						비밀번호 확인하여 맞으면 수정처리, 틀리면 alert 출력.
			           	수정처리 완료 후 detail.jsp 다시 출력할 것 -->
</body>
</html>