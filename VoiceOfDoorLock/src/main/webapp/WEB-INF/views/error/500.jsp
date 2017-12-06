<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/plugin/jquery-3.2.1.slim.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../split/header.jsp" %>
<div class="container" style="margin-top: 10%">
 <div class="alert alert-danger" role="alert">
  <h4 class="alert-heading">500 Server Error</h4>
  <p>정확하지 않은 데이터 값을 넣거나 비 정상적인 접근이 포착 됐습니다. 다시한번 입력값을 확인해 주세요</p>
  <p>This web page is accessible only to the voice of doorlock administrator. voice of doorlock If you are a general manager, you can not access this page.</p>
  
  <hr>
  <p class="mb-0">경고를 무시한채 지속적인 접속을 할 경우 법적 처벌을 받을수 있음을 알려드립니다.</p>
  <p class="mb-0">로그인이 되지 않는 경우, 지점코드를 분실하신 경우, 기타 회원가입에 문제가 있으신 분들</p>
  <p class="mb-0">tel) 02-xxx-xxxx 혹은 email) xdkyu@naver.com  로 문의 바랍니다.</p>
<%@include file="../split/footer.jsp" %>
</body>
</html>