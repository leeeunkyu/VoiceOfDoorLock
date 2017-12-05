<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.2.1.js"
  integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
  crossorigin="anonymous"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="resources/js/insertbranch.js"></script>

</head>

<body>
<%@include file="../split/header.jsp" %>
<div  class="container" style="margin-top: 7%;margin-bottom: 5%">
<form action="insertBranch.do" method="get">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="branchName">지점 이름</label>
      <input type="text" class="form-control" name="branchName" id="branchName" placeholder="지점 이름..">
    </div>
    <div class="form-group col-md-6">
      <label for="branchPhone">지점 번호</label>
      <input type="text" class="form-control" name="branchPhone" id="branchPhone" placeholder="지점 번호..">
    </div>
  </div>
  <div class="branchEmail">
    <label for="inputAddress">지점메일</label>
    <input type="text" class="form-control" name="branchEmail" id="branchEmail" placeholder="지전 메일 ..">
  </div>
  <div class="form-row">
    <div class="form-group col-md-5">
      <label for="branchLatitude">위도 LATITUDE</label>
      <input type="text" class="form-control" name="branchLatitude" id="branchLatitude"  readonly>
    </div>
    <div class="form-group col-md-5">
      <label for=branchLongitude>경도 LONGITUDE</label>
      <input type="text" class="form-control" name="branchLongitude" id="branchLongitude"  readonly>
    </div>
      <div class="form-group col-md-2">
      <label for="inputPassword4">위도 경도 계산하기</label>
	  <button type="button" class="btn btn-outline-warning" onclick="getlocation()"> 계산하기</button>
    </div>
  </div>
  <button type="submit" class="btn btn-primary">Sign in</button>
</form>
</div>
<%@include file="../split/footer.jsp" %>

</body>
</html>