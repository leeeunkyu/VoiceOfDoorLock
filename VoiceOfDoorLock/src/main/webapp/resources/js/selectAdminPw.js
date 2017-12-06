$(document).ready(function(){
	$('#pwInput').hide();
	$('#msg').hide();
});

function selectAdminPw(adminId,branchName,branchNum) {
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "selectAdminPw.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"adminId":adminId,"branchName":branchName,"branchNum":branchNum},
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (result) {
    		console.log(result);

        	if(result) {
            	document.getElementById('selectPwToEmail').disabled = false;
            	document.getElementById('msg').innerHTML="변경 메일 보내기 버튼을 클릭해 주세요";
            	$('#msg').show();
            	$('#pwInput').show();
        	}else {
            	document.getElementById('selectPwToEmail').disabled = true;
            	document.getElementById('msg').innerHTML="입력값을 확인해 주세요";

            	$('#pwInput').hide();
            	$('#msg').show();
        	}
        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
}

function sendEmail(adminId) {
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "sendEmail.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"adminId":adminId},
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (result) {
        	if(result) {
            	document.getElementById('selectPwToEmail').disabled = false;
            	document.getElementById('msg').innerHTML="메일에 전송된 보안 토큰을 입력해 주세요.";
            	$('#msg').show();
        	}else {
            	document.getElementById('msg').innerHTML="메일에 전송 과전에서 문제가 생겼습니다. 아이디를 확인해주세요";
            	$('#msg').show();

        	}
        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
}

function updateAdminPw(token) {
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "tokenCheck.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"token":token},
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (result) {
        	console.log(result);
        	if(result) {
            	console.log(result);
                document.getElementById("updateForm").submit();
        	}else {
            	console.log(result);
            	document.getElementById('msg').innerHTML="토큰값이 틀렸습니다.";

        	}
        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
	console.log('test');
}
