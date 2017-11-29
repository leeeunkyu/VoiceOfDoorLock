$(document).ready(function(){
	console.log('as시작');
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "asApplicationSelectList.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"index":1},
        dataType: "json",
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (test) {
        	for(var i=0;i<5;i++){
        	document.getElementById('applicationDay'+i).innerHTML=test[i].applicationDay;
        	document.getElementById('branchName'+i).innerHTML=test[i].branchName;
        	document.getElementById('memberId'+i).innerHTML=test[i].memberId;
        	document.getElementById('memberName'+i).innerHTML=test[i].memberName;
        	document.getElementById('memberPhone'+i).innerHTML=test[i].memberPhone;
        	document.getElementById('memberAddress'+i).innerHTML=test[i].memberAddress;
        	}
        },
        error:function(e){  
            console.asApplication(e.responseText);  
        }  
    });
});

var searchContent = null;
var selectContent = null;
var searchBoolean = false;
var searchSize;

function goPage(page) {
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "asApplicationSelectList.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"index":page ,"searchContent":searchContent,"selectContent":selectContent},
        dataType: "json",
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (test) {
        	for(var j=0;j<5;j++){
        		if(test[j]==null){
        			console.log('j값'+j);
        			for(var k=0;k<=j-1;k++){
        				document.getElementById('applicationDay'+k).innerHTML=test[k].applicationDay;
        	        	document.getElementById('branchName'+k).innerHTML=test[k].branchName;
        	        	document.getElementById('memberId'+k).innerHTML=test[k].memberId;
        	        	document.getElementById('memberName'+k).innerHTML=test[k].memberName;        	        	
        	        	document.getElementById('memberPhone'+k).innerHTML=test[k].memberPhone;
        	        	document.getElementById('memberAddress'+k).innerHTML=test[k].memberAddress;
        			}
        			for(var l=k;l<5;l++){
        				document.getElementById('applicationDay'+l).innerHTML="";
        	        	document.getElementById('branchName'+l).innerHTML="";
        	        	document.getElementById('memberId'+l).innerHTML="";
        	        	document.getElementById('memberName'+l).innerHTML="";
        	        	document.getElementById('memberPhone'+l).innerHTML="";
        	        	document.getElementById('memberAddress'+l).innerHTML="";
        			}
        			break;
        		}else{
        			document.getElementById('applicationDay'+j).innerHTML=test[j].applicationDay;
    	        	document.getElementById('branchName'+j).innerHTML=test[j].branchName;
    	        	document.getElementById('memberId'+j).innerHTML=test[j].memberId;
    	        	document.getElementById('memberName'+j).innerHTML=test[j].memberName;    	        	
    	        	document.getElementById('memberPhone'+j).innerHTML=test[j].memberPhone;
    	        	document.getElementById('memberAddress'+j).innerHTML=test[j].memberAddress;
        		}
        	}
        	
	        
        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
}
function nextPage(size) {
	if(!searchBoolean){
		var temp = document.getElementById('thirdpage').innerHTML;
		temp = Number(temp);
		size = Number(size);
		console.log('검색전',size);
		if(temp*5 <= size){
			document.getElementById('firstpage').innerHTML = temp+1;
			document.getElementById('secondpage').innerHTML = temp+2;
			document.getElementById('thirdpage').innerHTML = temp+3;
		}
	}else {
		var temp = document.getElementById('thirdpage').innerHTML;
		temp = Number(temp);
		size = searchSize;
		console.log('검색후',size);
		if(temp*5 <= size){
			document.getElementById('firstpage').innerHTML = temp+1;
			document.getElementById('secondpage').innerHTML = temp+2;
			document.getElementById('thirdpage').innerHTML = temp+3;
		}
	}
}

function beforePage() {
	var temp = document.getElementById('firstpage').innerHTML;
	temp = Number(temp);
	if(temp > Number('1')) {
		document.getElementById('firstpage').innerHTML = temp-3;
		document.getElementById('secondpage').innerHTML = temp-2;
		document.getElementById('thirdpage').innerHTML = temp-1;
	}else{
		console.log('???');

	}
}
function searchSelect(search,select) {
	searchContent = search;
	selectContent = select;
	//console.log(searchContent);
	//console.log(selectContent);
	searchBoolean = true;
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "asApplicationSelectSize.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"searchContent":search,"selectContent":select},
        dataType: "json",
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (test) {
        	console.log(test);
        	searchSize = test;
        	console.log('searchSize',searchSize);
        	goPage(1);
        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
}

var openWin;

function engineer(memberId,branchName) {
	console.log(memberId);
	console.log(branchName);
	window.name = "parentForm";
    // window.open("open할 window", "자식창 이름", "팝업창 옵션");
    openWin = window.open("engineerListView.do?branchName="+branchName+"&memberId="+memberId,
            "childForm", "width=900, height=880, resizable=no, scrollbars = no");
}

function colorChange(data) {
	data.style.color = 'red';
}

function colorReturn(data) {
	data.style.color = 'black';
}