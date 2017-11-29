<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="resources/js/doorlockCreate.js"></script>

</head>
<body>
<%@include file="../split/header.jsp" %>
<div class="container">
<div class="jumbotron">
  <h1 class="display-3">DoorLock Create</h1>
  <p class="lead">도어락 번호 및 도어락 패스워드가 생성되는 페이지 입니다.</p>
  <hr class="my-4">
  <p>새로운 도어락 제품이 만들어졌을 경우 아래 버튼을 눌러 해당 도어락에 대한 고유 식별 번호와 도어락 비밀 번호를 만들어 줄 수 있습니다.</p>
  <p class="lead">
    <a class="btn btn-danger btn-lg" href="#" role="button" data-toggle="modal" data-target="#exampleModal" onclick="createDoorLock()">도어락 생성하기</a>
    <a class="btn btn btn-info btn-lg" href="#" role="button">생성됐던 도어락 리스트 보기</a>
  </p>
</div>
</div>
<!-- Button trigger modal -->
			
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">성공적으로 키가 생성되었습니다.</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        <span id="doorLockNum"></span>
			        <p>
			        <span id="doorLockPassword"></span>
			        <p>
			        <span id="doorLockOk"></span>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">확인</button>
			      </div>
			    </div>
			  </div>
			</div>
	
<%@include file="../split/footer.jsp" %>

</body>
</html>