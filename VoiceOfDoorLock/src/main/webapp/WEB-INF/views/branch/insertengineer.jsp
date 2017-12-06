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
<link type="text/css" rel="stylesheet" href="resources/css/insertengineer.css"></link>

</head>

<body>
<%String branchName = (String)session.getAttribute("branchName"); %>
<%@include file="../split/header.jsp" %>
<div class="container">
 <img src="${pageContext.request.contextPath}/resources/images/logo/engineerlogo.png" class="img-fluid" alt="Responsive image" style="margin-bottom:2em; margin-top: 2em;margin-left: 25em;">
<form action="insertEngineer.do" id="engineerForm" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label for="exampleInputEmail1">사원 번호</label>
   		<input type="text" class="form-control" id="engineerNum" name="engineerNum" placeholder="사원번호는 사원 등록시에 발급 됩니다." readonly>
   		<small id="emailHelp" class="form-text text-muted">사원 번호 입니다.</small>
	</div> 
	<div class="form-group">
		<label for="exampleInputEmail1">사원 이름</label>
   		<input type="text" class="form-control" id="engineerName" name="engineerName" placeholder="Name">
   		<small id="emailHelp" class="form-text text-muted">사원 이름을 적어주세요</small>
	</div> 
	<div class="form-group">
		<label for="exampleInputEmail1">사원 전화 번호</label>
    	<input type="text" class="form-control" id="engineerPhone" name="engineerPhone"  placeholder="Mobile">
    	<small id="emailHelp" class="form-text text-muted">사원 전화 번호를 적어주세요</small>
	 </div>
	<div class="form-group"> 
	<select class="form-control" name="isTrip">
	  <option value="TRUE">TRUE</option>
	  <option value="FALSE">FALSE</option> 
	</select>
	 <small id="emailHelp" class="form-text text-muted">사원 출장 가능 여부를 표시해주세요 TRUE = 출장가능,  FALSE = 출장불가능</small>
	</div>
	<input class="form-control" type="text" name="branchName"  value="<%=branchName %>" readonly>
 <div class="form-group">
    <label for="uploadFile">AS 사원 사진 등록하기 (PNG, JPG)</label>
    <input type="file" id="uploadFile" name="uploadFile" accept=".jpg, .jpeg, .png" multiple>
  </div> 
  <div class="preview">
    <p>No files currently selected for upload</p>
  </div>
  <div>
	<button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#exampleModal">등록하기</button>
  </div>
</form>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">사원등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		정상적으로 등록 됐습니다.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="insertEngineer()">확인</button>
      </div>
    </div>
  </div>
</div>
 <script type="text/javascript" src="resources/js/insertEngineer.js"></script>
<%@include file="../split/footer.jsp" %>
</body>
</html>