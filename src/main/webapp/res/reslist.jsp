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
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}"/>
<h1>레슨 일정 조회</h1>
<table border="1px solid gray" class="table">
	<thead>
		<tr>
			<th>예약 코드</th>
			<th>레슨 코드</th>
			<th>강사 ID</th>
			<th>강사 이름</th>
			<th>기구 종류</th>
			<th>레슨 날짜</th>
			<th>시작 시간</th>
			<th>종료 시간</th>
			<th>개인/그룹 여부</th>
			<th>회원 ID</th>
			<th></th>
	</thead>
	<tbody>
		<c:forEach items="${ldlist}" var="ld">
			<tr>
				<td>${ld.res_code}</td>
				<td>${ld.les_code}</td>
				<td>${ld.trn_id}</td>
				<td>${ld.trn_name }</td>
				<td>${ld.les_machine }</td>
				<td>${ld.les_date}</td>
				<td>${ld.les_start_time}</td>
				<td>${ld.les_end_time}</td>
				<td>${ld.les_porg}</td>
				<td>${ld.mem_id}</td>
				<td><button onclick="location.href='${cpath}/res/resdelete.do?res_code=${ld.res_code}'">취소</button></td>
			</tr>
		</c:forEach>
	</tbody>
</body>
</html>