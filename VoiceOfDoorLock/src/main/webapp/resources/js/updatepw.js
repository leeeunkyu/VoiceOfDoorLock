function updateAdminPw(adminId,adminPw) {
	$.ajax({
        // type을 설정합니다.
        type : 'get',
        url : "updatePw.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"adminId" : adminId,"adminPw":adminPw},
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (updateResult) {
    		console.log(updateResult,0);
        	if(updateResult) {
            	document.getElementById('msg').innerHTML="메일에 전송 과전에서 문제가 생겼습니다.";
            }else {
        		console.log(updateResult,2);
        		document.getElementById('msg').innerHTML="메일에 전송 과전에서 문제가 생겼습니다.";
        	}
        }
    });
}