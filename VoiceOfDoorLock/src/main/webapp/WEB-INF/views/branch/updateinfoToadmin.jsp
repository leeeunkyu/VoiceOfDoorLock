<%@page import="com.kosta.dto.Branch"%>
<%@page import="com.kosta.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%Admin admin = (Admin)request.getAttribute("admin"); %>
 
<div class="container">
<form>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">관리자 아이디</label>
      <input type="text" class="form-control" name="adminId" value="<%=admin.getAdminId() %>" readonly>
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">관리자 이름</label>
      <input type="text" class="form-control" name="adminName" value="<%=admin.getAdminName() %>">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">관리자 이메일</label>
    <input type="text" class="form-control" name="adminEmail" value="<%=admin.getAdminEmail() %>">
  </div>
 <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">관리자 등급</label>
      <input type="text" class="form-control" name="adminGrade" value="<%=admin.getAdminGrade() %>" readonly>
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">관리자 지점명</label>
      <input type="text" class="form-control" name="branch" value="<%=admin.getBranchName()%>" readonly>
    </div>
  </div>


  <button type="submit" class="btn btn-primary">변경하기</button>
</form></div>