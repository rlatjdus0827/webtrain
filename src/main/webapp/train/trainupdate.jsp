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
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}"/>

<form action="${cpath}/train/trainupdate.do" method="post">
<input type="hidden" name="trn_id" value="${traindetail.trn_id }"><br>
 Password : <input type="text" name="trn_pw" value="${traindetail.trn_pw }"><br>
 이름 : <input type="text" name="trn_name" value="${traindetail.trn_name }"><br>
 Email : <input type="text" name="trn_email" value="${traindetail.trn_email }"><br>
 전화번호 : <input type="text" name="trn_phone" value="${traindetail.trn_phone }"><br>
 
 <input type="submit" value="수정">
</form>
</body>
</html>