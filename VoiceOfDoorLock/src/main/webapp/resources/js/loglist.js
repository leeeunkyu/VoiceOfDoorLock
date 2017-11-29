$(document).ready(function(){
	console.log('시작');
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "logSelectList.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"index":1},
        dataType: "json",
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (test) {
        	console.log(test);
        	for(var i=0;i<5;i++){
        	document.getElementById('memberId'+i).innerHTML=test[i].memberId;
        	document.getElementById('logDate'+i).innerHTML=test[i].logDate;
        	document.getElementById('logControl'+i).innerHTML=test[i].logControl;
        	document.getElementById('doorlockNum'+i).innerHTML=test[i].doorlockNum;
        	}
        },
        error:function(e){  
            console.log(e.responseText);  
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
        url : "logSelectList.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"index":page ,"searchContent":searchContent,"selectContent":selectContent},
        dataType: "json",
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (test) {
        	console.log(test);
        	for(var j=0;j<5;j++){
        		if(test[j]==null){
        			console.log('j값'+j);
        			for(var k=0;k<=j-1;k++){
        	        	console.log('k값'+k);
        				document.getElementById('memberId'+k).innerHTML=test[k].memberId;
        	        	document.getElementById('logDate'+k).innerHTML=test[k].logDate;
        	        	document.getElementById('logControl'+k).innerHTML=test[k].logControl;
        	        	document.getElementById('doorlockNum'+k).innerHTML=test[k].doorlockNum;
        			}
        			for(var l=k;l<5;l++){
        				document.getElementById('memberId'+l).innerHTML="";
        	        	document.getElementById('logDate'+l).innerHTML="";
        	        	document.getElementById('logControl'+l).innerHTML="";
        	        	document.getElementById('doorlockNum'+l).innerHTML="";
        			}
        			break;
        		}else{
        			document.getElementById('memberId'+j).innerHTML=test[j].memberId;
    	        	document.getElementById('logDate'+j).innerHTML=test[j].logDate;
    	        	document.getElementById('logControl'+j).innerHTML=test[j].logControl;
    	        	document.getElementById('doorlockNum'+j).innerHTML=test[j].doorlockNum;
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
        url : "logSelectSize.do",
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