var openWin;
$(document).ready(function(){
	$('#istrue').hide();
	$('#isfalse').hide();
});

function openChild() {
	// window.name = "부모창 이름"; 
    window.name = "parentForm";
    // window.open("open할 window", "자식창 이름", "팝업창 옵션");
    openWin = window.open("branchname.do",
            "childForm", "width=570, height=350, resizable = no, scrollbars = no");    
}
function setParentText(){
    opener.document.getElementById("branchName").value = document.getElementById("branchName").value;
    window.close();
}

function confirmBranch(branchName,branchCode) {
	console.log(branchCode);
	console.log(branchName);
	$.ajax({
        // type을 설정합니다.
        type : 'POST',
        url : "confirmBranch.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"branchName" : branchName,"branchCode":branchCode},
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (data) {
        	console.log(data);
            // 서버에서 Return된 값으로 중복 여부를 사용자에게 알려줍니다.
            if (data=='ok') {
            	document.getElementById('addButton').disabled = false;
            	document.getElementById('branchAddSign').style.color="blue"
            	document.getElementById('branchAddSign').innerHTML="지점 코드가 확인 됐습니다."
            	
            } else {
            	document.getElementById('addButton').disabled = true;
            	document.getElementById('branchAddSign').innerHTML="지점 코드를 확인 해주세요."
                	document.getElementById('branchAddSign').style.color="red"

            }             
        }
    });
}

function isId(adminId) {
	console.log(adminId);
	$.ajax({
        // type을 설정합니다.
        type : 'POST',
        url : "isId.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"adminId" : adminId},
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (data) {
        	console.log(data);
            // 서버에서 Return된 값으로 중복 여부를 사용자에게 알려줍니다.
            if (data==true) {
            	console.log('이미 있다');
            	$('#istrue').hide();
            	$('#isfalse').show();
            } else {
            	console.log('없다');
            	$('#istrue').show();
            	$('#isfalse').hide();
            }             
        }
    });
}
