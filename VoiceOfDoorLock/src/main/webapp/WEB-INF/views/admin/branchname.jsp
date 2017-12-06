<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="resources/plugin/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="resources/js/signup.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<div class="form-group">
	    	<label for="adminId">지점명</label>
	 		<input type="text" class="form-control" id="branchName" placeholder="이름을 입력해 주세요." name="branchName"
	 		 autocomplete="off">
	    </div>	
		 <div class="form-group">
	    	<label for="adminId">지점코드</label>
	 		<input type="text" class="form-control" id="branchCode" placeholder="이름을 입력해 주세요." name="branchCode"
	 		 autocomplete="off">
	    </div>
	    <p class="font-weight-bold" id="branchAddSign"></p>
	    <button type="button" class="btn btn-outline-info" onclick="confirmBranch(document.getElementById('branchName').value,document.getElementById('branchCode').value)">지점확인</button>	
		<button type="button" class="btn btn-outline-info" onclick="setParentText()" id="addButton" disabled>지점추가</button>	
	</div>
</body>
</html>