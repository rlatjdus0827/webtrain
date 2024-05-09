<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Member Sign up</title>
<script>
function validateForm() {
    var id = document.getElementById("mem_id").value;
    var pw = document.getElementById("mem_pw").value;
    var name = document.getElementById("mem_name").value;
    var email = document.getElementById("mem_email").value;
    var phone = document.getElementById("mem_phone").value;

    if (id === "" || pw === "" || name === "" || email === "" || phone === "") {
        alert("모든 입력란을 작성해주세요.");
        return false;
    }
    return true;
}
</script>
</head>
<body>
<h1>[회원용] 회원가입</h1>
<form action="${pageContext.request.servletContext.contextPath}/mem/meminsert.do" method="post" onsubmit="return validateForm()">
	<div class="mb-3 mt-3">
      	<label for="mem_id">ID : </label>
      	<input type="text" class="form-control" id="mem_id" name="mem_id" >
    </div>
    <div class="mb-3 mt-3">
      	<label for="mem_pw">Password : </label>
      	<input type="text" class="form-control" id="mem_pw" name="mem_pw" placeholder="4자리 이상 입력">
    </div>
    <div class="mb-3 mt-3">
      	<label for="mem_name">이름 : </label>
      	<input type="text" class="form-control" id="mem_name" name="mem_name" >
    </div>
    <div class="mb-3 mt-3">
      	<label for="mem_email">Email : </label>
      	<input type="email" class="form-control" id="mem_email" name="mem_email" placeholder="format)email@email.com" >
    </div>
    <div class="mb-3 mt-3">
      	<label for="mem_phone">전화번호 : </label>
      	<input type="text" class="form-control" id="mem_phone" name="mem_phone" placeholder="format)010-0000-0000">
    </div>
    
    <button type="submit" class="btn btn-dark">sign up</button>
</form>
</body>
</html>