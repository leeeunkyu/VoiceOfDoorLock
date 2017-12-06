<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="resources/plugin/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<%@include file="../split/header.jsp" %>
	<%String size = (String)request.getAttribute("logListSize"); %>
	<%String memberId[] = {"memberId0","memberId1","memberId2",
			"memberId3","memberId4","memberId5"}; %>
	<%String logDate[] = {"logDate0","logDate1","logDate2",
			"logDate3","logDate4","logDate5"}; %>
	<%String logControl[] = {"logControl0","logControl1","logControl2",
			"logControl3","logControl4","logControl5"}; %>
	<%String doorlockNum[] = {"doorlockNum0","doorlockNum1","doorlockNum2",
			"doorlockNum3","doorlockNum4","doorlockNum5"}; %>						
<div class="jumbotron" style="background-color:#D8D8D8">
	  <h1 class="display-3">로그 조회</h1>
	  <p class="lead"> DoorLock에대한 전체적인 입기록을 확인 할 수 있습니다. </p>
	  <hr class="my-4">
	 <table class="table">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">아이디</th>
	      <th scope="col">입 날짜</th>
	      <th scope="col">허가여부</th>
	      <th scope="col">도어락 고유번호</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<%if (Integer.parseInt(size) >= 5) {%>
		    <%for(int i=0;i<5;i++){ %>
		    <tr>
		      <th scope="row"><%=i %></th>
		      <td><span id=<%=memberId[i]%>></span></td>
		      <td><span id=<%=logDate[i]%>></span></td>
		      <td><span id=<%=logControl[i]%>></span></td>
		      <td><span id=<%=doorlockNum[i]%>></span></td>	
		    </tr>
		       <%} %>
	     <%}else { %>
		     <%for(int i=0;i< Integer.parseInt(size) ;i++){ %>
		    	<tr>
			      <th scope="row"><%=i %></th>
			      <td><span id=<%=memberId[i]%>></span></td>
			      <td><span id=<%=logDate[i]%>></span></td>
			      <td><span id=<%=logControl[i]%>></span></td>
			      <td><span id=<%=doorlockNum[i]%>></span></td>	
		      	</tr>
		    <%} %>
	     <%} %>     
	  </tbody>
	</table>

	<div>
	<nav aria-label="Page navigation example">
	  	<ul class="pagination justify-content-center">
	    <li class="page-item">
	      <a class="page-link" href="#" onclick="beforePage()">Previous</a>
	    </li>
	    <li class="page-item" id=test>
	    	<a class="page-link" href="#" onclick="goPage(document.getElementById('firstpage').innerHTML)">
	    		<span id="firstpage">1</span>
	    </a>
	    </li>
	    <li class="page-item">
	    	<a class="page-link" href="#" onclick="goPage(document.getElementById('secondpage').innerHTML)">
	    		<span id="secondpage">2</span></a></li>
	    <li class="page-item">
	    	<a class="page-link" href="#" onclick="goPage(document.getElementById('thirdpage').innerHTML)">
	    		<span id="thirdpage">3</span></a></li>
	    <li class="page-item">
	      <a class="page-link" href="#" onclick="nextPage('<%=size%>')">Next</a>
	    </li>
	  </ul>
	</nav>
			<div class="d-flex justify-content-center">
	 		<select class="custom-select d-block my-3" id="selectContent" required>
		    <option value="">검색조건</option>
		    <option value="memberId">아이디</option>
		    <option value="permission">허가여부</option>
	  	</select>
	  	</div> 
	<div class="d-flex justify-content-center">	
	 <div class="input-group" style="width: 20%; height: 50%">    
	    <input type="text" class="form-control" id="searchContent" placeholder="Search for..." aria-label="Search for...">
      	<span class="input-group-btn">
      	  <button class="btn btn-secondary" type="button"
      	  onclick="searchSelect(document.getElementById('searchContent').value,document.getElementById('selectContent').value)">
      	  Go!</button>
      	</span>
    </div>
   	</div>
	</div>
	
</div>
	<%@include file="../split/footer.jsp" %>
<script type="text/javascript" src="resources/js/loglist.js"></script>

</body>
</html>