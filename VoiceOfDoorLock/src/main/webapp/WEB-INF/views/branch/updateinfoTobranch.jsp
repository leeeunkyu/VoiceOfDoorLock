<%@page import="com.kosta.dto.Branch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%Branch branch = (Branch)request.getAttribute("branch"); %>
    
<div class="container">
<form>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">지점명</label>
      <input type="email" class="form-control" name="branchName" value="<%=branch.getBranchName() %>" readonly>
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">위도</label>
      <input type="password" class="form-control" name="branchLatitude" value="<%=branch.getBranchLatitude() %>" readonly>
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">경도</label>
    <input type="text" class="form-control" name="branchLongtitude" value="<%=branch.getBranchLongitude() %>" readonly>
  </div>
  <div class="form-group">
    <label for="inputAddress2">지점 전화번호</label>
    <input type="text" class="form-control" name="branchPhone" value="<%=branch.getBranchPhone() %>">
  </div>
<div class="form-group">
    <label for="inputAddress2">지점 메일</label>
    <input type="text" class="form-control" name="branchEmail" value="<%=branch.getBranchEmail() %>">
  </div>

  <button type="submit" class="btn btn-primary">변경하기</button>
</form></div>