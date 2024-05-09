<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="path" value="${pageContext.request.servletContext.contextPath}/mem"/>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}"/>

<form action="${cpath}/mem/memupdate.do" method="post">
<input type="hidden" name="mem_id" value="${memdetail.mem_id }"><br>
 Password : <input type="text" name="mem_pw" value="${memdetail.mem_pw }"><br>
 이름 : <input type="text" name="mem_name" value="${memdetail.mem_name }"><br>
 Email : <input type="text" name="mem_email" value="${memdetail.mem_email }"><br>
 전화번호 : <input type="text" name="mem_phone" value="${memdetail.mem_phone }"><br>
 <input type="hidden" name="mem_lesson_cnt" value="${memdetail.mem_lesson_cnt }"><br>
 <input type="submit" value="수정">
</form>
</body>
</html>