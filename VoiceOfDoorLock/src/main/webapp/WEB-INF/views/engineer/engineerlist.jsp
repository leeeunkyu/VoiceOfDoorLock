<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kosta.dto.Engineer" %>
<%@page import="com.kosta.dto.Member" %>

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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="resources/css/engineer.css"></link>

<title>Insert title here</title>
   <style>
      #map {
        height: 200px;
        width: 500px;
       }
    </style>
</head>
<body>

	<%String size = (String)request.getAttribute("engineerListSize"); %>
	<%String doorlockAddress = (String)request.getAttribute("doorlockAddress"); %>
	
	<%ArrayList<Engineer> engineer = (ArrayList)request.getAttribute("engineerList"); %>
	<%Map location = (Map)request.getAttribute("location");  %>
	<%Member member = (Member)request.getAttribute("member"); %>
	<%String engineerNum[] = {"engineerNum0","engineerNum1","engineerNum2","engineerNum3","engineerNum4"}; %>
	<%String engineerPhone[] = {"engineerPhone0","engineerPhone1","engineerPhone2",
			"engineerPhone3","engineerPhone4"}; %>
	<%String engineerName[] = {"engineerName0","engineerName1","engineerName2",
			"engineerName3","engineerName4"}; %>
	<%String branchName[] = {"branchName0","branchName1","branchName2",
			"branchName3","branchName4"}; %>
	<%String isTrip[] = {"isTrip0","isTrip1","isTrip2",
			"isTrip3","isTrip4"}; %>
	<div class="container-fluid">
		<img src="" alt="사원을 선택해 주세요" id="engineerImg" class="img-thumbnail test" >		
	</div>
	
	<div style="margin-left:300px; margin-top: 10px;">
		<div>
			<table id="memberTable">
				<tr>
					<td class="font-weight-bold">회원 아이디</td>
					<td><span class="font-weight-normal" id="memberId">&nbsp;&nbsp;<%=member.getMemberId() %></span></td>
				</tr>
				<tr>
					<td class="font-weight-bold">회원 이름</td>
					<td><span class="font-weight-normal" id="memberId">&nbsp;&nbsp;<%=member.getMemberName() %></span></td>					
				</tr>
				<tr>
					<td class="font-weight-bold">회원 전화번호</td>
					<td><span class="font-weight-normal" id="memberId">&nbsp;&nbsp;<%=member.getMemberPhone() %></span></td>				
				</tr>
				<tr>
					<td class="font-weight-bold">라인 아이디</td>
					<td><span class="font-weight-normal" id="memberId">&nbsp;&nbsp;<%=member.getLineId() %></span></td>
				</tr>
				<tr>
					<td class="font-weight-bold">도어락 위치</td>
					<td><span class="font-weight-normal" id="doorlockAddress">&nbsp;&nbsp;<%=doorlockAddress %></span></td>
				</tr>
			</table>
		</div>
		<span class="font-weight-bold">latitude: </span>  <span id="lat"><%=location.get("lat") %></span>
		<span class="font-weight-bold">Longitude: </span> <span id="lot"><%=location.get("lot") %></span>
				
		<div style="margin-top: 20px;">
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#exampleModal" onclick="initModal()">
			  Line으로 메시지 보내기
			</button>
			
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">메시지 확인</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
					<%=member.getMemberName() %> 님에게 as 출발 메시지를 보내시겠습니까?
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			        <button type="button" class="btn btn-primary" id="sendLine" onclick="tripEngineer('<%=member.getMemberId() %>')" disabled>메시지 보내기</button>
			      </div>
			    </div>
			  </div>
			</div>
			
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#exampleModal"> SNS 메시지 보내기</button>
			
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        ...
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			        <button type="button" class="btn btn-primary">메시지 보내기</button>
			      </div>
			    </div>
			  </div>
			</div>
			<p>
				<div id="map"></div>
			
		</div>
	</div>
		<span id="eName" style="position: relative; top: -110px;">수리기사님을 선택해 주세요 </span>
	<div class="fixed-bottom">
		<div id="alert" class="alert alert-success" role="alert">
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	 <table class="table">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">수리기사 사원번호</th>
	      <th scope="col">수리기사 전화번호</th>
	      <th scope="col">수리기사 이름</th>
	      <th scope="col">지점명</th>
	      <th scope="col">출장가능여부</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<%if (engineer.size() >= 5) { %>
		    <%for(int i=0;i<5;i++){ %>
		    <tr onclick="selectEngineer('<%=i %>','${pageContext.request.contextPath}/resources/images/engineer/')">
		      <th scope="row"><%=i %></th>
			  <td><span id=<%=engineerNum[i]%>><%=engineer.get(i).getEngineerNum() %></span></td>
		      <td><span id=<%=engineerPhone[i]%>><%=engineer.get(i).getEngineerPhone() %></span></td>
		      <td><span id=<%=engineerName[i]%>><%=engineer.get(i).getEngineerName() %></span></td>
		      <td><span id=<%=branchName[i]%>><%=engineer.get(i).getBranchName() %></span></td>
		      <td><span id=<%=isTrip[i]%>><%=engineer.get(i).getIsTrip() %></span></td>	
		    </tr>
		     <%} %>
	     <%}else { %>
	      <%for(int i=0;i<engineer.size();i++){ %>
		    <tr onclick="selectEngineer('<%=i %>','${pageContext.request.contextPath}/resources/images/engineer/')">
		      <th scope="row"><%=i %></th>
			  <td><span id=<%=engineerNum[i]%>><%=engineer.get(i).getEngineerNum() %></span></td>		      
		      <td><span id=<%=engineerPhone[i]%>><%=engineer.get(i).getEngineerPhone() %></span></td>
		      <td><span id=<%=engineerName[i]%>><%=engineer.get(i).getEngineerName() %></span></td>
		      <td><span id=<%=branchName[i]%>><%=engineer.get(i).getBranchName() %></span></td>
		      <td><span id=<%=isTrip[i]%>><%=engineer.get(i).getIsTrip() %></span></td>	
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
	    	<a class="page-link" href="#" 
	    	onclick="goPage(document.getElementById('firstpage').innerHTML,'<%=engineer.get(0).getBranchName()%>')">
	    		<span id="firstpage">1</span>
	    </a>
	    </li>
	    <li class="page-item">
	    	<a class="page-link" href="#" 
	    	onclick="goPage(document.getElementById('secondpage').innerHTML,'<%=engineer.get(0).getBranchName()%>')">
	    		<span id="secondpage">2</span></a></li>
	    <li class="page-item">
	    	<a class="page-link" href="#" 
	    	onclick="goPage(document.getElementById('thirdpage').innerHTML,'<%=engineer.get(0).getBranchName()%>')">
	    		<span id="thirdpage">3</span></a></li>
	    <li class="page-item">
	      <a class="page-link" href="#" 
	      onclick="nextPage('<%=size%>')">Next</a>
	    </li>
	  </ul>
	</nav>
	<div class="d-flex justify-content-center">
	 		<select class="custom-select d-block my-3" id="selectContent"  required>
		    <option value="">검색조건</option>
		    <option value="engineerNum">사원번호</option>
		    <option value="engineerName">기사 성함</option>
		    <option value="isTrip">출장 가능여부</option>		    
	  	</select>
	  	</div> 
	<div class="d-flex justify-content-center">	
	 <div class="input-group" style="width: 20%; height: 50%">    
	    <input type="text" class="form-control" id="searchContent" placeholder="Search for..." aria-label="Search for...">
      	<span class="input-group-btn">
      	  <button class="btn btn-secondary" type="button"
      	      onclick="searchSelect(document.getElementById('searchContent').value,document.getElementById('selectContent').value,'<%=engineer.get(0).getBranchName() %>')">
      	  Go!</button>
      	</span>
    </div>
   	</div>
	</div>
	
</div>
 <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCWsmkNm_0HTEe90pW6wNP4u37-VTQgFG4&callback=initMap">
    </script>
<script type="text/javascript" src="resources/js/engineerlist.js"></script>

</body>
</html>