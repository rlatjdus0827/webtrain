<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
function setFormAction() {
    var selectedValue = document.querySelector('input[name="selection"]:checked').value;
    if (selectedValue === "mem") {
        document.getElementById('loginForm').action = "../mem/memlogin";
    } else if (selectedValue === "train") {
        document.getElementById('loginForm').action = "../train/trainlogin";
    }
}
function setFormAction2(){
	var selectedValue = document.querySelector('input[name="signselect"]:checked').value;
	if(selectedValue === "mem") {
		document.getElementById('signUpForm').action = "../mem/meminsert.do";
	} else if(selectedValue === "train"){
		document.getElementById('signUpForm').action = "../train/traininsert.do";
	}
}

</script>


<title>Sign Page</title>

<link rel="stylesheet" href="/webtrain/auth/login.css">
</head>
<body>
<!-- /webtrain ${pageContext.request.servletContext.contextPath} -->
<h2>✿ SY Pilates Reservation ✿</h2>
<hr>
<div class="container" id="container">
  <div class="form-container sign-up-container">
    <form  id="signUpForm" action="">
      <h1>회원가입</h1>
      <span>가입 유형을 선택해주세요</span>
        <label for="signmem" style="margin: 5px !important; "><input type="radio"  name="signselect" id="signmem" value="mem" onclick="setFormAction2()" ><span style="font-size: 20px !important; color: #5c5c5c;">Member</span></label>
		
		<label for="signtrain" style="margin: 5px !important; "><input type="radio" name="signselect" id="signtrain" value="train" onclick="setFormAction2()"><span style="font-size: 20px !important; color: #5c5c5c;">Trainer</span></label>
      	
      <button type="submit">회원가입하기</button>
    </form>
  </div>
  <div class="form-container sign-in-container">
    <form  id="loginForm" action="" method="post">
      <h1>로그인</h1>
      <span>정보를 입력해주세요</span>
      <label for="mem" style="margin: 5px !important; "><input type="radio" name="selection" id="mem" value="mem" onclick="setFormAction()" ><span style="font-size: 20px !important; color: #5c5c5c;">Member</span></label> 
	  <label for="train" style="margin: 5px !important; "><input type="radio" name="selection" id="train" value="train" onclick="setFormAction()"><span style="font-size: 20px !important; color: #5c5c5c;">Trainer</span></label>
      
      <input type="text" placeholder="ID" id="id" name="id" />
      <input type="password" placeholder="Password" id="pwd" name="pwd"  />
      <button type="submit">로그인하기</button>
    </form>
  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-left">
        <h1>Welcome Back!</h1>
        <p>To keep connected with us please login with your personal info</p>
        <button class="ghost" id="signIn">로그인</button>
      </div>
      <div class="overlay-panel overlay-right">
        <h1>Hello, Friend!</h1>
        <p>Enter your personal details and start journey with us</p>
        <button class="ghost" id="signUp">회원가입</button>
      </div>
    </div>
  </div>
</div>


<script src="/webtrain/auth/login.js"></script>
</body>
</html>
 