<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="resources/plugin/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>

<link type="text/css" rel="stylesheet" href="resources/css/signup.css"></link>
<script type="text/javascript" src="resources/js/signup.js"></script>
</head>
<body>
	<%@include file="../split/header.jsp" %>
	<div class="container" style="margin-top: 3%">
		<form action="adminAdd.do" class="was-validated">
			<div class="form-group">
    			<label for="adminId">아이디를 입력하세요.</label>
 			  	 <input type="text" class="form-control" id="adminId" placeholder="id를 입력해 주세요." name="adminId"
 			  	 autocomplete="off" autofocus required pattern="[0-9]+[a-z]+" maxlength="20" minlength="5">
    			<small id="idHelp" class="form-text text-muted">5~20자리 영문 소문자,숫자를 입력해 주세요</small>
    		</div>	
    		<button type="button" class="btn btn-outline-info" onclick="isId(document.getElementById('adminId').value)">중복확인</button>
    		<p id="isfalse" class="text-danger">중복되는 아이디가 있습니다.</p>
    		<p id="istrue" class="text-info">중복되는 아이디가 없습니다.</p>				
			<div class="form-group">
    			<label for="adminId">패스워드를 입력하세요.</label>
 			  	 <input type="password" class="form-control" id="adminPw" placeholder="password를 입력해 주세요." name="adminPw"
 			  	 autocomplete="off" required pattern="[A-Z0-9a-z]+" maxlength="16" minlength="6">
    			<small id="pwHelp" class="form-text text-muted">6~16자 영문 대 소문자,숫자</small>
    		</div>	
			
			<div class="form-group">
    			<label for="adminId">패스워드를 확인하세요.</label>
 			  	 <input type="password" class="form-control" id="adminPwConfirm" placeholder="password를 확인해 주세요." name="adminPwConfirm"
 			  	 autocomplete="off" required pattern="[A-Z0-9a-z]+" maxlength="16" minlength="6">
    		</div>	
		 	<div class="form-group">
		    	<label for="adminEail">Email address</label>
		    	<input type="email" class="form-control" id="adminEmail" placeholder="name@example.com" name="adminEmail"
		    	autocomplete="off" required">
		  	</div>
 
 			<div class="form-group">
    			<label for="adminId">이름를 입력하세요.</label>
 			  	 <input type="text" class="form-control" id="adminName" placeholder="이름을 입력해 주세요." name="adminName"
 			  	 autocomplete="off">
    		</div>				
				<div class="custom-controls-stacked d-block my-3">
			    <label class="custom-control custom-radio">
			      <input id="radioStacked1" name="adminGrade" type="radio" class="custom-control-input" value="M" disabled>
			      <span class="custom-control-indicator"></span>
			      <span class="custom-control-description">총관리자</span>
			    </label>
			    <label class="custom-control custom-radio">
			      <input id="radioStacked2" name="adminGrade" type="radio" class="custom-control-input" value="B" checked>
			      <span class="custom-control-indicator"></span>
			      <span class="custom-control-description">지점장</span>
			    </label>
			  </div>
			<p>
			<input type="text" name="branchName" placeholder="지점명" id="branchName"
			 class="form-control"  readonly>
			 <p>
			<button type="button" class="btn btn-outline-info" onclick="openChild()">지점찾기</button>	
			<p>
			<button type=submit class="btn btn-outline-info">가입하기</button>	
		</form>
	</div>
	<%@include file="../split/footer.jsp" %>
</body>
</html>