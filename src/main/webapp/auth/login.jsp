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


<title>Login Page</title>
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

function showSignUpForm() {
    document.getElementById("signUpForm").style.display = "block";
}
</script>

</head>
<body>
<!-- /webtrain ${pageContext.request.servletContext.contextPath} -->

<div class="container mt-3">
  <h2>Login form</h2>
  	<input type="radio" name="selection" value="mem" onclick="setFormAction()"> 회원 
	<input type="radio" name="selection" value="train" onclick="setFormAction()"> 강사 
	<form id="loginForm" action="" method="post">
		<div class="mb-3 mt-3">
      	<label for="id">ID : </label>
      	<input type="text" class="form-control" id="id" name="id" >
    	</div>
    	<div class="mb-3 mt-3">
      	<label for="pwd">Password : </label>
      	<input type="text" class="form-control" id="pwd" name="pwd" >
    	</div>
    	<div class="form-check mb-3">
      	<label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Login 정보 저장
      	</label>
    	</div>
    	<button type="submit" class="btn btn-dark">Login</button>
	</form>
	
<hr>
<button onclick="showSignUpForm()" class="btn btn-dark">회원가입 (회원/강사 선택)</button>
<form id="signUpForm" action="" style="display: none;">
    <input type="radio" name="signselect" value="mem" onclick="setFormAction2()"> 회원 
	<input type="radio" name="signselect" value="train" onclick="setFormAction2()"> 강사 
	
	<input type="submit" value="회원가입 페이지로 이동" class="btn btn-dark">
</form>


</body>
</html>
 