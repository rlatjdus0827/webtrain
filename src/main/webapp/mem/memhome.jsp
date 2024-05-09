<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container {
    width: 960px;
    margin : 0 auto;
  }
.navi{
    width:960px;
    height:60px;
    padding-bottom:10px;
    border-bottom:2px solid #ccc;
}
.navi ul{
    list-style: none;
    padding-top:10px; 
    padding-bottom:5px;
  }
.navi ul li {
	float:left;
	width:150px;
	padding:10px;
}
.navi a:link, .navi a:visited {
	display:block;
	font-size: 14px;
	color:#000;
	padding:10px;
	text-decoration:none;
	text-align:center;
	
}
.navi a:hover, .navi a:focus{
	background-color: #e8aea9;
	color:#fff;
}
.navi a:active{
	background-color:#ad665f;
}
.contents {
    margin:30px auto;
    width:400px;
    padding:20px;
    border:1px solid #222;
    border-radius:5px;        
  }

#reservation:target, #myInfo:target, #lesSearch:target{
    background-color:#ffeae8; 
  }
#all{
	text-decoration:none;
}
</style>
</head>
<body>
<c:set var="path" value="${pageContext.request.servletContext.contextPath}/mem"/>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}"/>

<h1>test memHome</h1>
<a href="${cpath}/auth/logout.do" id="all">로그아웃</a>


<div class="container">
<nav class="navi">
	<ul>
		<li><a href="#myInfo">내 정보</a></li>
		<li><a href="#lesSearch">강의 조회</a></li>
		<li><a href="#reservation">예약 정보</a></li>
		<li></li>
	</ul>
</nav>
<div id="myInfo" class="contents">
	<h2>나의 정보</h2><hr>

	${memInfo.mem_id}<br>
	${memInfo.mem_pw}<br>
	${memInfo.mem_name}<br>
	${memInfo.mem_email}<br>
	${memInfo.mem_phone}<br>
	${memInfo.mem_lesson_cnt}<br>
<hr>
<a href="${cpath}/mem/memupdate.do?id=${memInfo.mem_id}">정보 수정하기</a>
<p>정보가 수정되면 재로그인 해야합니다</p>
</div>
<div id="lesSearch" class="contents">
<h2>강의 조회</h2><hr>
<a href="${cpath}/les/leslist.do" id="all">전체 강의 조회</a>
<form action="${cpath}/les/leslist.do" method="post">
<input type="date" name="les_date" required> 
<input type="submit" value="해당 날짜로 강의 조회">
</form>

<form action="${cpath}/les/leslist.do" method="post">
<input type="text" name="les_machine" required> 
<input type="submit" value="해당 기구로 강의 조회">
</form>

</div>
<div id="reservation" class="contents">
<h2>예약 정보</h2><hr>
<a href="${cpath}/res/reslist.do" id="all">예약 정보 조회하기</a>
</div>
</div>
</body>
</html>