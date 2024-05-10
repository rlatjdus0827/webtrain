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
	
    width: 1400px;
    margin : 0 auto;
  }
#cont2{
	display:flex;
}
.navi{
    width:1400px;
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
	margin:0 140px;
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
#reservation, #myInfo, #lesSearch{
    display:inline-block;
    align-items:flex-start;
  }
#all{
	text-decoration:none;
	border-radius: 20px;
  	border: 1px solid #ad665f;
  	background-color: #e8aea9;
  	color: #FFFFFF;
  	font-size: 16px;
  	font-weight: bold;
  	
  	padding: 10px 20px;
  	
  	margin:auto 20px;
  	float:right;
}
#atag{
	text-decoration:none;
	border-radius: 10px;
	background-color: #e8aea9;
	padding: 10px 20px;
	font-weight: bold;
	color: #FFFFFF;
	font-size: 14px;
	margin : 10px 10px;
}
h1{
	text-align: center;
}
input{
	width:150px;
	margin:5px;
}
#cont3{
	
}

</style>
</head>
<body>
<c:set var="path" value="${pageContext.request.servletContext.contextPath}/mem"/>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}"/>

<br>
<h1>SY 필라테스</h1>
<a href="${cpath}/auth/logout.do" id="all">로그아웃</a>
<br>

<div class="container">
<nav class="navi">
	<ul>
		<li><a href="#myInfo">내 정보</a></li>
		<li><a href="#lesSearch">강의 조회</a></li>
		<li><a href="#reservation">예약 정보</a></li>
		
	</ul>
</nav>
<div id="cont2">
<div id="myInfo" class="contents">
	<h2>나의 정보</h2><hr>
	<div id="cont3">
	<b>🔑 ID : </b>${memInfo.mem_id}<br>
	<b>🔒 PW : </b>${memInfo.mem_pw}<br>
	<b>👤 이름 : </b>${memInfo.mem_name}<br>
	<b>✉️ Email : </b>${memInfo.mem_email}<br>
	<b>📞 전화번호 : </b>${memInfo.mem_phone}<br>
	<b>📌 수강 가능 횟수 : </b>${memInfo.mem_lesson_cnt}<br>
	</div>
<hr>
<a href="${cpath}/mem/memupdate.do?id=${memInfo.mem_id}" id="atag">정보 수정하기</a>
<p>⚠️ 정보가 수정되면 재로그인 해야합니다 ⚠️</p>
</div>
<div id="lesSearch" class="contents">
<h2>강의 조회</h2><hr>
<a href="${cpath}/les/leslist.do" id="atag">전체 강의 조회</a>
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
<a href="${cpath}/res/reslist.do" id="atag">예약 정보 조회하기</a>
</div>
</div>
</div>
<hr>
</body>
</html>
 