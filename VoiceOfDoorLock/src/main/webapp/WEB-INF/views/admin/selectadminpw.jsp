<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

<script src="resources/plugin/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="resources/js/selectAdminPw.js"></script>

</head>
<body>
<div class="container">
  <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/logo/mainlogo.png" alt="Card image cap" style="width: 30%;height: 30%;margin-left: 35%;">
<h5 style="text-align: center;">비밀번호 찾기</h5>
<hr>
 <form action="updatePwView.do" id="updateForm">
 <div class="form-group" style="margin-top: 1em;">
    <label for="adminId">아이디</label>
    <input type="text" class="form-control" id="adminId" name="adminId" placeholder="아이디를 입력하세요..">
  </div>
   <div class="form-group">
    <label for="branchName">지점 명 </label>
    <input type="text" class="form-control" id="branchName" placeholder="지점명을 입력하세요..">
  </div>
   <div class="form-group">
    <label for="branchNum">지점 코드</label>
    <input type="text" class="form-control" id="branchNum" placeholder="지점코드를 입력하세요..">
  </div>
 <button type="button" class="btn btn-outline-primary" 
 onclick="selectAdminPw(document.getElementById('adminId').value,document.getElementById('branchName').value,document.getElementById('branchNum').value)">입력값확인</button>
  <button type="button" class="btn btn-outline-primary" id="selectPwToEmail"
 onclick="sendEmail(document.getElementById('adminId').value)" disabled>비밀번호 변경 메일 보내기</button>
 <p style="margin: 20px;">
 <u style="margin: 20px;" id="msg"> 비밀번호 변경 메일 버튼을 눌러주세요</u>
	   <div class="input-group" id="pwInput">
	      <input type="text" class="form-control"  id="inputToken" placeholder="Search for..." aria-label="Search for...">
	      <span class="input-group-btn">
	        <button class="btn btn-secondary" type="button" onclick="updateAdminPw(document.getElementById('inputToken').value)">변경암호 입력하기</button>
	      </span>
	    </div>
	</form>  
 </div>

</body>
</html>