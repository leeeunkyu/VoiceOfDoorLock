<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
  
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
 <script type="text/javascript" src="resources/js/branchmap.js"></script>

   <style>
      #map {
        height: 400px;
        width: 100%;
        margin-bottom: 20px;
        margin-top: 0px;
       }
    </style> 
  </head>
  <body>
   <h3 style="text-align: center; background-color: #ddd ;margin-bottom: 0px;">지점 위치 찾아보기</h3>
    <div id="map"></div>

    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCWsmkNm_0HTEe90pW6wNP4u37-VTQgFG4&callback=initMap">
    </script> 
    <div class="container">
    
 	<div class="input-group">
      <input type="text" class="form-control" placeholder="지점명을 입력 하세요" aria-label="Search for..." id="branchName">
      <span class="input-group-btn">
        <button class="btn btn-secondary" type="button" onclick="searchLocation(document.getElementById('branchName').value)">Go!</button>
      </span>
    </div>
    
    <input class="form-control" type="text" id="lat" placeholder="위도" readonly>
    <input class="form-control" type="text" id="lot" placeholder="경도" readonly>
    <button class="btn btn-secondary" type="button" onclick="saveLocation(document.getElementById('lat').value,document.getElementById('lot').value)">적용하기</button>
    </div>
  </body>
</html>
