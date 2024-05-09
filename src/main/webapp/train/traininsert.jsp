<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<title>Trainer Sign up</title>
<script>
function validateForm() {
    var id = document.getElementById("trn_id").value;
    var pw = document.getElementById("trn_pw").value;
    var name = document.getElementById("trn_name").value;
    var email = document.getElementById("trn_email").value;
    var phone = document.getElementById("trn_phone").value;

    if (id === "" || pw === "" || name === "" || email === "" || phone === "") {
        alert("모든 입력란을 작성해주세요.");
        return false;
    }
    return true;
}
</script>
</head>
<body>
<h1>[강사용] 회원가입</h1>
<form action="${pageContext.request.servletContext.contextPath}/train/traininsert.do" method="post" onsubmit="return validateForm()">
	<div class="mb-3 mt-3">
      	<label for="trn_id">ID : </label>
      	<input type="text" class="form-control" id="trn_id" name="trn_id" >
    </div>
    <div class="mb-3 mt-3">
      	<label for="trn_pw">Password : </label>
      	<input type="text" class="form-control" id="trn_pw" name="trn_pw" placeholder="4자리 이상 입력">
    </div>
    <div class="mb-3 mt-3">
      	<label for="trn_name">이름 : </label>
      	<input type="text" class="form-control" id="trn_name" name="trn_name" >
    </div>
    <div class="mb-3 mt-3">
      	<label for="trn_email">Email : </label>
      	<input type="email" class="form-control" id="trn_email" name="trn_email" placeholder="format)email@email.com" >
    </div>
    <div class="mb-3 mt-3">
      	<label for="trn_phone">전화번호 : </label>
      	<input type="text" class="form-control" id="trn_phone" name="trn_phone" placeholder="format)010-0000-0000">
    </div>
    
    <input type="submit" class="btn btn-dark">sign up
</form>
</body>
</html>