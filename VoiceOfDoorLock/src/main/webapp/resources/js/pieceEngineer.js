$(document).ready(function(){
	console.log('시작');
	$('#updateinfo').hide();
	$('#updatedanger').hide();
});

function selectOneEngineer(engineerNum,path) {
	console.log(engineerNum,path);
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "selectOneEngineer.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"engineerNum":engineerNum},
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
var en;
function selectEngineer(branchName,inputEngineer,inputState,path) {
		$("#engineerSelectList").empty()

	/*for(var i = 0; i < size; i++) {
    	document.getElementById('engineerSelectList').options[i] = null;
    	console.log(i);
	}*/
//	console.log(document.getElementById('engineerSelectList').options);
//	console.log(document.getElementById('engineerSelectList').option);
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "engineerSelectList.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"index":99,"branchName":branchName,"searchContent":inputEngineer,"selectContent":inputState},
        dataType: "json",
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (selectResult) {
        	console.log(selectResult.length);
        	console.log(selectResult);
        	en = selectResult;
        	var searchMenu;
        	if(inputState == 'engineerNum'){
        		searchMenu = "사원번호&nbsp;검색결과";
        	}else if(inputState == 'engineerName'){
        		searchMenu = "사원이름&nbsp;검색결과";
        	}else{
        		searchMenu = "출장여부&nbsp;검색결과";
        	}
        	$("#engineerSelectList").append("<optgroup label="+searchMenu+">");
        	for(var i = 0; i < selectResult.length; i++ ) {
        		$("#engineerSelectList").append(
        				"<option id="+i+">"+selectResult[i].engineerNum+" &nbsp;|&nbsp;&nbsp; "+selectResult[i].engineerPhone+" &nbsp;|&nbsp;&nbsp; "+selectResult[i].isTrip+" &nbsp;|&nbsp;&nbsp; "+selectResult[i].engineerName+"</option>"
        		);
        	}
        	$("#engineerSelectList").append("</optgroup>");
        	for(var j = 0; j < selectResult.length; j++){
        		document.getElementById(j).addEventListener("click", function(e){
        			console.log(en);
        			console.log(en[0]);
        			console.log(e.srcElement.attributes[0].nodeValue);
        			selectOneEngineer(en[e.srcElement.attributes[0].nodeValue].engineerNum,path);
        		});	
        	}
        	
        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
}