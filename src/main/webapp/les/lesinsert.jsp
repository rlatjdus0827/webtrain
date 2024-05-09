<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}"/>

<h1>새 강의 등록</h1>
<form action="lesinsert.do" method="post">
	기구 종류 : <input type="text" name="les_machine">
	레슨 날짜 : <input type="date" name="les_date">
	시작 시간 : <input type="text" name="les_start_time">
	종료 시간 : <input type="text" name="les_end_time">
	수강 가능 인원 : <input type="number" name="les_available_cnt">
	개인/그룹 여부 : <input type="text" name="les_porg">
	

	<input type="submit" value="등록">
</form>
</body>
</html>