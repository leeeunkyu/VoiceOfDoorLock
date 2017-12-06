<%@page import="com.kosta.dto.Engineer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link type="text/css" rel="stylesheet" href="resources/css/engineer.css"></link>
<script type="text/javascript" src="resources/js/pieceEngineer.js"></script>
<script src="resources/plugin/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>

<%String branchName = (String)session.getAttribute("branchName"); %>
<%ArrayList<Engineer> engineerList = (ArrayList)request.getAttribute("engineerList"); %>
<div style="width: 35%;float: left; margin-top: 20px;padding-left: 3em;">
	 <div class="form-group">
    <label for="engineerSelectList"><%=branchName %> 기사님 목록</label>
    <select multiple class="form-control" id="engineerSelectList" style="height: 30em;">
    <optgroup label="전체검색">
    	<option>&nbsp;&nbsp; 사원 번호   &nbsp;&nbsp;&nbsp;&nbsp;|  &nbsp;사원 전화번호 &nbsp;&nbsp;&nbsp;|  &nbsp;사원 출장가능여부&nbsp;&nbsp;|  &nbsp;사원 이름</option>
      <%for(int i = 0; i<engineerList.size(); i++){ %>
		<option onclick="selectOneEngineer('<%=engineerList.get(i).getEngineerNum()%>','${pageContext.request.contextPath}/resources/images/engineer/')"> 
			&nbsp;<%=engineerList.get(i).getEngineerNum()%>&nbsp;&nbsp; 
			| &nbsp; <%=engineerList.get(i).getEngineerPhone()%> &nbsp;&nbsp;
			|  &nbsp;<%=engineerList.get(i).getIsTrip() %> &nbsp;&nbsp; | &nbsp;<%=engineerList.get(i).getEngineerName() %></option>
      <%} %>
          	</optgroup>
      
    </select>
  </div>
  
	<div class="container-fluid">
	 <div class="form-row">
	  <div class="form-group col-md-5">
	      <select id="inputState" class="form-control">
	      	<option value="">검색조건</option>
	      	<option value="engineerNum">사원 번호</option>
	        <option value="engineerName">사원 이름</option>
	        <option value="isTrip">사원 출장가능여부</option>
	        
	      </select>
	    </div>
	 
	    <div class="form-group col-md-7">
	        <div class="input-group">
	    
	      <input type="text" class="form-control" id="inputEngineer">
	      <span class="input-group-btn">
	        <button class="btn btn-secondary" type="button" 
	        onclick="selectEngineer('<%=branchName %>',document.getElementById('inputEngineer').value,document.getElementById('inputState').value,'${pageContext.request.contextPath}/resources/images/engineer/')">검색하기</button>
	      </span>
	    </div>
	    </div>
	     
	  </div>
	
	</div>
     
</div>
