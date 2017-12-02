<%@page import="com.kosta.dto.Engineer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link type="text/css" rel="stylesheet" href="resources/css/engineer.css"></link>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

<div style="width: 70%; float: left; margin-top: 25px">
	<div class="border border-info" style="height: 50em">
		<div class="container-fluid" style="margin:10px;">
			<img src="${pageContext.request.contextPath}/resources/images/engineer/홍길동0.jpg" alt="사원을 선택해 주세요" id="engineerImg" class="img-thumbnail test" >
		</div>
	  <div class="form-group col-md-6" style="float: left;">
	  	  <label for="engineerName">사원 번호</label>
	      <input type="text" class="form-control" id="engineerNum" readonly>
	      <label for="engineerName">사원 이름</label>
	      <input type="text" class="form-control" id="engineerName">
	      <label for="engineerPhone">사원 전화번호</label>
	      <input type="text" class="form-control" id="engineerPhone">
	      <label for="branchName">근무 지점</label>
	      <input type="text" class="form-control" id="branchName" readonly>
	      <label for="isTrip">출장 가능 여부</label>
	      <select class="form-control" id="isTrip">
		      <option>TRUE</option>
		      <option>FALSE</option>
   		 </select>
		<div style="margin-top: 20px;">
   		 <button type="button" class="btn btn-outline-info" style="float: left; margin-right: 10px;" onclick="updateEngineer(
   			 	document.getElementById('engineerNum').value,
   				 document.getElementById('engineerName').value, 
   				 document.getElementById('engineerPhone').value, 
   				 document.getElementById('isTrip').value)">변경사항 저장</button>
   		
   		 <button type="button" class="btn btn-outline-danger">기사님 삭제하기</button>
   		 <div class="alert alert-primary" id="updateinfo" role="alert" style="margin: 10px;">
		성공적으로 사원 정보가 변경 됐습니다.
		</div>
		<div class="alert alert-danger" id="updatedanger" role="alert" style="margin: 10px;">
			정보 변경 과정에서 오류가 생겼습니다.
		</div>
   		</div>
    </div>
		

</div>