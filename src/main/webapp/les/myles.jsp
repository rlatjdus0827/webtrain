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
<h2>내 강의 목록</h2>
<button onclick="location.href='${cpath}/train/trainhome.do'">메인으로 돌아가기</button>
<table border="1px solid gray" class="table">
	<thead>
		<tr>
			<th>레슨 코드</th>
			<th>강사 ID</th>
			<th>기구 종류</th>
			<th>레슨 날짜</th>
			<th>시작 시간</th>
			<th>종료 시간</th>
			<th>수강 가능 인원</th>
			<th>개인/그룹 여부</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${trnleslist}" var="trnles">
		<tr>
			<td>${trnles.les_code }</td>
			<td>${trnles.trn_id }</td>
			<td>${trnles.les_machine }</td>
			<td>${trnles.les_date }</td>
			<td>${trnles.les_start_time }</td>
			<td>${trnles.les_end_time }</td>
			<td>${trnles.les_available_cnt }</td>
			<td>${trnles.les_porg }</td>
			<td><button onclick="location.href='${cpath}/les/lesdelete.do?les_code=${trnles.les_code}'">취소</button></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>