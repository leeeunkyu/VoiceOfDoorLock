<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script type="text/javascript" src="resources/crypto/aes.js"></script>
<script type="text/javascript" src="resources/crypto/AesUtil.js"></script>
<script type="text/javascript" src="resources/crypto/pbkdf2.js"></script>
<script src="resources/plugin/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<script type="text/javascript" src="resources/crypto/jsbn.js"></script>
<script type="text/javascript" src="resources/crypto/rsa.js"></script>
<script type="text/javascript" src="resources/crypto/prng4.js"></script>
<script type="text/javascript" src="resources/crypto/rng.js"></script>
<script type="text/javascript" src="resources/js/login.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<%@include file="../split/header.jsp" %>
	<p>
	<p>
	<%String islogin = (String)request.getAttribute("islogin"); %>
	<%String RSAModulus = (String)request.getAttribute("RSAModulus"); %>
	<%String RSAExponent = (String)request.getAttribute("RSAExponent"); %>
	<%if(islogin.equals("false")){ %>
			<script type="text/javascript">
			 alert("아이디 비밀번호를 확인해 주세요");
			</script>
	<%} %>
<div class="container" style="margin-top: 7%;margin-bottom: 5%">
  <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/logo/mainlogo.png" alt="Card image cap" style="width: 30%;height: 30%;margin-left: 35%;">
  <div class="row">
    <div class="col-sm">
    </div>
    <div class="col-sm">
    	 <div class="container">
			<form action="selectAdmin.do" method="get" id="loginForm">
			  <div class="form-group">
			    <label for="adminId">아이디</label>
			    <input type="text" class="form-control"  id="adminId" placeholder="아이디를 입력 하세요.">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">비밀번호</label>
			    <input type="password" class="form-control"  id="adminPw" placeholder="비밀번호를 입력 하세요.">
			  </div>
			  <button type="button" class="btn btn-primary" style="width: 100%;" onclick="login(document.getElementById('adminId').value,document.getElementById('adminPw').value,document.getElementById('loginForm'))">로그인</button>
			  <button type="button" class="btn btn-secondary" style="width: 100%; margin-top: 5px;" onclick="selectAdminId()">아이디 찾기</button>
			  <button type="button" class="btn btn-secondary" style="width: 100%; margin-top: 5px;" onclick="selectAdminPw()">비밀번호 찾기</button>
			</form>
		</div>
    </div>
    <div class="col-sm">
    </div>
  </div>
</div>
<input type="hidden" value='<%=RSAModulus %>' id="RSAModulus">
<input type="hidden" value='<%=RSAExponent %>' id=RSAExponent>

	<%@include file="../split/footer.jsp" %>
</body>
</html>