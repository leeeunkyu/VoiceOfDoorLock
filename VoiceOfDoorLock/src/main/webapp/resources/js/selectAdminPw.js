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
        	}else {
            	document.getElementById('selectPwToEmail').disabled = true;
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
    		console.log(result);

        	if(result) {
            	document.getElementById('selectPwToEmail').disabled = false;
            	$('#pwInput').show();
            	$('#msg').show()
        	}else {
            	document.getElementById('selectPwToEmail').disabled = true;
            	$('#pwInput').hide();
            	$('#msg').hide();
        	}
        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
}
