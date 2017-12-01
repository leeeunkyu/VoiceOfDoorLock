<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
	<link type="text/css" rel="stylesheet" href="resources/css/main.css"></link>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	
</head>
<body>
<%@include file="split/header.jsp" %>
<div class="mainPosition">
	<span class="card" style="width: 20rem; float: left; margin: 12px;margin-left:15%; margin-top: 4%;">
	  <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/main/usersearch.png" alt="Card image cap">
	  <span class="card-body">
		    <h4 class="card-title">회원 조회</h4>
		    <p class="card-text">
		    Voice of DoorLock 서비스를 이용하고 있는 회원들의 회원 정보에 대해 조회할수 있습니다. 
		    <p class="font-weight-light">
			You can inquire about membership information of members using Voice of DoorLock service.
			</p>		    
		    </p>
		    <a href="memberListView.do?index=1" class="btn btn-primary">조회하기</a>
		</span>
	</span>
	<span class="card" style="width: 20rem; float: left; margin: 12px; margin-top: 4%;">
  <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/main/entersearch.png" alt="Card image cap">
  <span class="card-body">
    <h4 class="card-title">입기록 조회</h4>
    <p class="card-text">
  		Voice of DoorLock 을 사용하는 사용자의 DoorLock 기기별 입기록을 조회할수있습니다.
		<p class="font-weight-light">
		You can view the entry history of each DoorLock device of users who use Voice of DoorLock.
		</p>
    </p>
    <a href="logListView.do?index=1" class="btn btn-primary">조회하기</a>
  </span>
	</span>
	<span class="card" style="width: 20rem; float: left; margin: 12px; margin-top: 4%;">
  <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/main/branch.jpg" alt="Card image cap">
  <span class="card-body">
    <h4 class="card-title">지점 설정</h4>
    <p class="card-text">관리자님이 속한 Voice of DoorLock 지점에 대한 여러가지 설정사항등을 변경하실수 있습니다.</p>
   	<p class="font-weight-light">
		You can change various settings for the Voice of DoorLock branch that the administrator belongs to.
		</p>
    </p>
    <a href="branchMainView.do" class="btn btn-primary">조회하기</a>
  </span>
	</span>
	<span class="card" style="width: 20rem; float: left; margin: 12px; margin-top: 4%;">
  <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/main/AS.jpg" alt="Card image cap">
  <span class="card-body">
    <h4 class="card-title">AS 조회</h4>
    <p class="card-text">
    Voice of DoorLock 을 사용하는 사용자의 AS 신청 현황을 알수있으며, AS에대한 응답메시지를 보낼수 있습니다.
		<p class="font-weight-light">	
	You can see the application status of AS users who use Voice of Door Lock, and send a response message to AS.
		</p>
    </p>
    <a href="asApplicationListView.do?index=1" class="btn btn-primary">Go somewhere</a>
  </span>
	</span>
</div>
<%@include file="split/footer.jsp" %>


</body>
</html>
