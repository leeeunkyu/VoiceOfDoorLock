<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="resources/plugin/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>

<script type="text/javascript" src="resources/js/keyCreate.js"></script>

</head>
<body>
<%@include file="../split/header.jsp" %>
<div class="container">
<div class="jumbotron">
  <h1 class="display-3">Key Create</h1>
  <p class="lead">키 생성 페이지 입니다. Voice of DoorLock 페이지의 모든 통신은 RSA & AES 알고리즘을 이용해 암호화 전송되고 있으며, 아래 버튼을 누르면 암호화에 생성되는
  Key 가 refresh 됩니다.</p>
  <hr class="my-4">
  <p>아래 버튼을 누르는 순간... 기타 간략한 key에 대한 설명</p>
  <p class="lead">
    <a class="btn btn-danger btn-lg" href="setRsaKey.do" role="button" data-toggle="modal" data-target="#exampleModal" onclick="getkey()">키 생성하기</a>    
  </p>
</div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">성공적으로 키가 생성됐습니다.</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="publicKey">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">확인</button>
      </div>
    </div>
  </div>
</div>
<%@include file="../split/footer.jsp" %>

</body>
</html>