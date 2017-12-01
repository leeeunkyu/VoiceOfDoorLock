<%@page import="com.kosta.dto.Engineer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link type="text/css" rel="stylesheet" href="resources/css/footer.css"></link>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<%String branchName = (String)session.getAttribute("branchName"); %>
<%ArrayList<Engineer> engineerList = (ArrayList)request.getAttribute("engineerList"); %>
<div style="width: 30%;float: left; margin-top: 20px">
	 <div class="form-group">
    <label for="exampleFormControlSelect2"><%=branchName %> 기사님 목록</label>
    <select multiple class="form-control" id="exampleFormControlSelect2" style="height: 45em;">
      <%for(int i = 0; i<engineerList.size(); i++){ %>
		<option onclick="selectOneEngineer('<%=engineerList.get(i).getEngineerPhone()%>')"><%=engineerList.get(i).getEngineerPhone()%> |  <%=engineerList.get(i).getEngineerName() %></option>
      <%} %>
    </select>
  </div>
</div>