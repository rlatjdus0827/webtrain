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
<style>
@import url('https://fonts.googleapis.com/css?family=Montserrat:400,800');
@import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Poetsen+One&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Jersey+25+Charted&family=Jua&family=Noto+Sans+KR:wght@100..900&family=Poetsen+One&display=swap');
/*google font import*/
* {
	box-sizing: border-box;
}
body {
	font-family: "Noto Sans KR", sans-serif;
}
h1 {
  font-weight: bold;
  
 }
span{
	font-size: 16px;
}
button {
  border-radius: 20px;
  border: 1px solid #FF4B2B;
  background-color: #FF4B2B;
  color: #FFFFFF;
  font-size: 16px;
  font-weight: bold;
  
  padding: 10px 20px;
  margin:10px;
  
  letter-spacing: 1px;
  transition: transform 80ms ease-in;
}
input {
	width: 200px;
	
}
label {
	width: 100px;
	display: inline-block;
	
	padding: 4px;
	margin: 10px;
	
}
.container{
	width: 800px;
	margin:200px auto;
	border:2px solid #FF4B2B;
	border-radius: 20px;
	padding: 20px;
	
}
#title{
	text-align: center;
}
#box1{
	width: 400px;
	margin: 0 auto;
	
}
</style>

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
<div class="container">
<h1 id="title"> 회원가입 <span>강사용</span></h1>
<hr>
<form action="${pageContext.request.servletContext.contextPath}/train/traininsert.do" method="post" onsubmit="return validateForm()">
	<div id="box1">
      	<label for="trn_id">ID : </label>
      	<input type="text" id="trn_id" name="trn_id" >
    
    
      	<label for="trn_pw">Password : </label>
      	<input type="text" id="trn_pw" name="trn_pw" placeholder="4자리 이상 입력">
    
      	<label for="trn_name">이름 : </label>
      	<input type="text" id="trn_name" name="trn_name" >
    
      	<label for="trn_email">Email : </label>
      	<input type="email" id="trn_email" name="trn_email" placeholder="format)email@email.com" >
    
      	<label for="trn_phone">전화번호 : </label>
      	<input type="text" id="trn_phone" name="trn_phone" placeholder="format)010-0000-0000">
    </div>
    <div style="text-align: center;"> 
    	<button type="submit">회원가입</button>
    </div>
</form>
</div>
</body>
</html>