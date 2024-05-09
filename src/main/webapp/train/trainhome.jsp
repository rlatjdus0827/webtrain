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

#lesPlus:target, #myInfo:target, #myLes:target{
    background-color:#ffeae8;  
  }
#all{
	text-decoration:none;
}
</style>
</head>
<body>

<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}"/>

<h1>test trainHome</h1>
<a href="${cpath}/auth/logout.do" id="all">로그아웃</a>
<div class="container">
<nav class="navi">
	<ul>
		<li><a href="#myInfo">내 정보</a></li>
		<li><a href="#lesPlus">강의 등록</a></li>
		<li><a href="#myLes">내 강의(+취소)</a></li>
		<li></li>
	</ul>
</nav>
<div id="myInfo" class="contents">
	<h2>나의 정보</h2><hr>

	${trnInfo.trn_id}<br>
	${trnInfo.trn_pw}<br>
	${trnInfo.trn_name}<br>
	${trnInfo.trn_email}<br>
	${trnInfo.trn_phone}<br>

<hr>
<a href="${cpath}/train/trainupdate.do?id=${trnInfo.trn_id}">정보 수정하기</a>
<p>정보가 수정되면 재로그인 해야합니다</p>
</div>
<div id="lesPlus" class="contents">
<h2>강의 등록</h2><hr>
<a href="${cpath}/les/lesinsert.do" id="all">새로운 강의 추가</a>
</div>
<div id="myLes" class="contents">
<h2>내 강의</h2><hr>
<a href="${cpath}/les/myles.do" id="all">내 강의 조회</a>
</div>
</div>

</body>
</html>