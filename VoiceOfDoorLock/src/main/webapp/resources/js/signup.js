var openWin;
$(document).ready(function() {
    $('#istrue').hide();
    $('#isfalse').hide();
    $('#isPwTrue').hide();
    $('#isPwFalse').hide();
});

function openChild() {
    window.name = "parentForm";
    openWin = window.open("branchName.do", "childForm", "width=570, height=350, resizable = no, scrollbars = no")
}

function setParentText() {
    opener.document.getElementById("branchName").value = document.getElementById("branchName").value;
    window.close()
}

function confirmBranch(branchName, branchCode) {
    console.log(branchCode);
    console.log(branchName);
    $.ajax({
        type: 'POST',
        url: "confirmBranch.do",
        data: {
            "branchName": branchName,
            "branchCode": branchCode
        },
        success: function(data) {
            console.log(data);
            if (data == 'ok') {
                document.getElementById('addButton').disabled = false;
                document.getElementById('branchAddSign').style.color = "blue"
                document.getElementById('branchAddSign').innerHTML = "지점 코드가 확인 됐습니다."
            } else {
                document.getElementById('addButton').disabled = true;
                document.getElementById('branchAddSign').innerHTML = "지점 코드를 확인 해주세요."
                document.getElementById('branchAddSign').style.color = "red"
            }
        }
    })
}

function isId(adminId) {
    console.log(adminId);
    $.ajax({
        type: 'POST',
        url: "isId.do",
        data: {
            "adminId": adminId
        },
        success: function(data) {
            console.log(data);
            if (data == true) {
                console.log('이미 있다');
                $('#istrue').hide();
                $('#isfalse').show()
            } else {
                console.log('없다');
                $('#istrue').show();
                $('#isfalse').hide()
            }
        }
    })
}
var checkPw = false;
function matchPw(pw,cPw) {
	if(pw == cPw) {
		checkPw = true;
		 $('#isPwTrue').show();
		 $('#isPwFalse').hide();
	}else{
		$('#isPwTrue').hide();
		$('#isPwFalse').show();
		checkPw = false;
	}
}