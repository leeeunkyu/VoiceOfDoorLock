$(document).ready(function(){
	console.log('시작');
	$('#updateinfo').hide();
	$('#updatedanger').hide();
});

function selectOneEngineer(engineerPhone,path) {
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "selectOneEngineer.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"engineerPhone":engineerPhone},
        dataType: "json",
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (engineer) {
        	console.log(engineer);
        	document.getElementById('engineerNum').value=engineer.engineerNum;
        	document.getElementById('engineerName').value=engineer.engineerName;
        	document.getElementById('engineerPhone').value=engineer.engineerPhone;
        	document.getElementById('branchName').value=engineer.branchName;
        	document.getElementById('isTrip').value=engineer.isTrip;
        	document.getElementById('engineerImg').src =path+engineer.engineerNum+".png";

        },
        error:function(e){  
        	console.log('test2');
            console.log(e.responseText);  
        }  
    });
}
function updateEngineer(engineerNum,engineerName,engineerPhone,isTrip) {
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "updateEngineer.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"engineerNum":engineerNum,"engineerName":engineerName, "engineerPhone":engineerPhone,"isTrip":isTrip},
        dataType: "json",
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (updateResult) {
        	console.log(updateResult);
        	if(updateResult) {
        		console.log('?');
        		$('#updatedanger').hide();
        		document.getElementById('updateinfo').innerHTML = '기사님 정보가 성공적으로 업데이트 됐습니다.';  

        		$('#updateinfo').show();
        	}else {
        		$('#updateinfo').hide();
        		document.getElementById('updatedanger').innerHTML = '기사님 정보 변경과정에서 오류가 생겼습니다.';  

        		$('#updatedanger').show();

        	}
        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
}
function deleteEngineer(engineerNum) {
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "deleteEngineer.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"engineerNum":engineerNum},
        dataType: "json",
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (updateResult) {
        	console.log(updateResult);
        	if(updateResult) {
        		console.log('?');
        		$('#updatedanger').hide();
        		document.getElementById('updateinfo').innerHTML = '기사님 정보가 성공적으로 삭제 됐습니다.';  
        		
        		$('#updateinfo').show();
        	}else {
        		$('#updateinfo').hide();
        		document.getElementById('updatedanger').innerHTML = '기사님 삭제 과정에서 오류가 생겼습니다.';  

        		$('#updatedanger').show();

        	}
        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
}