function selectAdminId(adminName,branchName,branchNum) {
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "selectAdminId.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"adminName":adminName,"branchName":branchName,"branchNum":branchNum},
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (adminId) {
        	if(adminId == "noId") {
        		document.getElementById('adminId').value = "검색된 id가 없습니다."
        	}else {
            	document.getElementById('adminId').value = '찾은 id: '+adminId;
        	}
        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
}