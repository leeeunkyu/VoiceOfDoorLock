<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="resources/plugin/jquery-3.2.1.slim.min.js"></script>

 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<%@include file="../split/header.jsp" %>
	<div class="container" style="margin-top: 2%;">
	
	<div class="card mb-3" style="margin: 5px;">
		<a href="insertEngineerView.do"><img src="${pageContext.request.contextPath}/resources/images/logo/insertEngineer.png" class="img-fluid" alt="Responsive image"></a>
  <div class="card-body">
    <p class="card-text">지점장님은 각 지점에 대한 수리기사들을 등록할수 있습니다.</p>
  </div>
</div>
	<div class="card mb-3" style="margin: 5px;">
		<a href="updateEngineerView.do"><img src="${pageContext.request.contextPath}/resources/images/logo/updateEngineer.png" class="img-fluid" alt="Responsive image"></a>	
  <div class="card-body">
    <p class="card-text">지점장님은 각 지점에 속해 있는 수리기사들 정보를 변경할수 있습니다.</p>
  </div>
</div>
	<div class="card mb-3" style="margin: 5px;">
		<a href="insertBranchView.do"><img src="${pageContext.request.contextPath}/resources/images/logo/insertBranch.png" class="img-fluid" alt="Responsive image"></a>	
  <div class="card-body">
    <p class="card-text">총 관리자님은 지점정보를 추가할수 있습니다.</p>
  </div>
</div>
	<div class="card mb-3" style="margin: 5px;">
		<a href="insertDoorKeyView.do"><img src="${pageContext.request.contextPath}/resources/images/logo/createdoorlockkey.png" class="img-fluid" alt="Responsive image"></a>
  <div class="card-body">
    <p class="card-text">관리자 분들은 도어락이 판매되었을때 도어락 키를 생성할수 있습니다.</p>
  </div>
</div>
	</div>
<%@include file="../split/footer.jsp" %>

</body>
</html>