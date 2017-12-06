<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/updatepw.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

<script src="resources/plugin/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<%String adminId = (String)request.getAttribute("adminId"); %>
<div class="container">
  <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/logo/mainlogo.png" alt="Card image cap" style="width: 30%;height: 30%;margin-left: 35%;">
<h5 style="text-align: center;">비밀번호 변경</h5>
<hr>
 <div class="form-group" style="margin-top: 1em;">
    <label for="adminName">아이디</label>
    <input type="text" class="form-control" id="adminId" value="<%=adminId %>" placeholder="이름을 입력하세요.." readonly>
  </div>
   <div class="form-group">
    <label for="branchName">비밀번호 </label>
    <input type="text" class="form-control" id="adminPw" placeholder="비밀번호를 입력하세요..">
  </div>
   <div class="form-group">
    <label for="branchNum">비밀번호확인</label>
    <input type="text" class="form-control" id="adminPwConfirm" placeholder="지점코드를 입력하세요..">
  </div>
 <button type="button" class="btn btn-outline-primary" 
 onclick="updateAdminPw(document.getElementById('adminId').value,document.getElementById('adminPw').value)"
 >비밀번호 변경하기</button>
   <u style="margin: 20px;" id="msg"> 변경할 비밀번호를 입력해 주세요</u>
  
 </div>
</body>
</html>