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
<button onclick="location.href='${cpath}/mem/memhome.do'">메인으로 돌아가기</button>
<table border="1px solid gray" class="table">
	<thead>
		<tr>
			<th>레슨 코드</th>
			<th>강사 id</th>
			<th>강사 이름</th>
			<th>기구 종류</th>
			<th>레슨 날짜</th>
			<th>시작 시간</th>
			<th>종료 시간</th>
			<th>예약 가능 인원</th>
			<th>개인/그룹 여부</th>
			<th></th>
	</thead>
	<tbody>
		<c:forEach items="${lesdatelist}" var="les">
			<tr>
				<td>${les.les_code}</td>
				<td>${les.trn_id}</td>
				<td>${les.trn_name }</td>
				<td>${les.les_machine }</td>
				<td>${les.les_date}</td>
				<td>${les.les_start_time}</td>
				<td>${les.les_end_time}</td>
				<td>${les.les_available_cnt}</td>
				<td>${les.les_porg}</td>
				<td><button onclick="location.href='${cpath}/res/resinsert.do?les_code=${les.les_code}'">예약</button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>