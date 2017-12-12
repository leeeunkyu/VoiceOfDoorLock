<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link type="text/css" rel="stylesheet" href="resources/css/header.css"></link>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<script type="text/javascript" src="resources/js/header.js"></script>

<%String grade = (String)session.getAttribute("adminGrade"); %>
<%String id = (String)session.getAttribute("adminId"); %>
<%String loginSucc = (String)request.getAttribute("loginSucc"); %>
<%String logoutSucc = (String)request.getAttribute("logoutSucc"); %>

<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="home.do">Voice Of DoorLock</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="navbarText">
   <%if(grade == null){ %>
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="login.do">로그인 <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="signUp.do">회원가입</a>
	      </li>
	    </ul>
 	<%}else if("B".equals(grade)){ %>
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="profile"><%=id %>님 환영합니다. <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="logout.do" onclick="logout()">로그아웃</a>
	      </li>
	       <li class="nav-item">
	        <a class="nav-link" href="updateView.do">지점 /관리자 정보 변경</a>
	      </li>
	    </ul>
	<%}else if(("M").equals(grade)){ %>
	 <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="profile"><%=id %>님 환영합니다. <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="logout.do" onclick="logout()">로그아웃</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="keyCreateView.do">키 생성하기</a>
	      </li>
	       <li class="nav-item">
	        <a class="nav-link" href="blockMemberView.do">블락 유저 확인</a>
	      </li>
	    </ul>
	<%} %>
	    <span class="navbar-text">
     Voice of DoorLock
    </span>
  </div>
</nav>
<%if("ok".equals(loginSucc)){ %>
<div class="container" id="loginbar">
	<div class="alert alert-primary" role="alert" id="loginAlert">
  		정상적으로 로그인 됐습니다.
	</div>
</div>
<%}else if("ok".equals(logoutSucc)){ %>
<div class="container" id="loginbar">
	<div class="alert alert-primary" role="alert" id="loginAlert">
  		정상적으로 로그아웃 됐습니다.
	</div>
</div>
<%} %>
