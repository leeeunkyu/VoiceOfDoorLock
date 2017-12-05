$(document).ready(function(){
	console.log('시작');
	$('#alert').hide();
   // document.getElementById("memberId").innerHTML = opener.document.getElementById("memberId0").value;
	 // document.getElementById("cInput").value = opener.document.getElementById("pInput").value;
});

var searchContent = null;
var selectContent = null;
var searchBoolean = false;
var searchSize;

function goPage(page,branchName) {
	console.log(branchName);
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "engineerSelectList.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"index":page,"branchName":branchName,"searchContent":searchContent,"selectContent":selectContent},
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
        				document.getElementById('engineerNum'+k).innerHTML=test[k].engineerNum;
        				document.getElementById('engineerPhone'+k).innerHTML=test[k].engineerPhone;
        	        	document.getElementById('engineerName'+k).innerHTML=test[k].engineerName;
        	        	document.getElementById('branchName'+k).innerHTML=test[k].branchName;
        	        	document.getElementById('isTrip'+k).innerHTML=test[k].isTrip;
        			}
        			for(var l=k;l<5;l++){
        				document.getElementById('engineerNum'+l).innerHTML="";
        				document.getElementById('engineerPhone'+l).innerHTML="";
        	        	document.getElementById('engineerName'+l).innerHTML="";
        	        	document.getElementById('branchName'+l).innerHTML="";
        	        	document.getElementById('isTrip'+l).innerHTML="";
        			}
        			break;
        		}else{
    				document.getElementById('engineerNum'+j).innerHTML=test[j].engineerNum;
        			document.getElementById('engineerPhone'+j).innerHTML=test[j].engineerPhone;
    	        	document.getElementById('engineerName'+j).innerHTML=test[j].engineerName;
    	        	document.getElementById('branchName'+j).innerHTML=test[j].branchName;
    	        	document.getElementById('isTrip'+j).innerHTML=test[j].isTrip;
        		}
        	}
        	
	        
        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
}
function nextPage(size) {
	var temp = document.getElementById('thirdpage').innerHTML;
	console.log('test'+size);
	console.log(temp);
	temp = Number(temp);
	size = Number(size);
	console.log(size);
	console.log(temp);
	if(temp*5 <= size){
	document.getElementById('firstpage').innerHTML = temp+1;
	document.getElementById('secondpage').innerHTML = temp+2;
	document.getElementById('thirdpage').innerHTML = temp+3;
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

function searchSelect(search,select,branchNaem) {
	searchContent = search;
	selectContent = select;
	//console.log(searchContent);
	//console.log(selectContent);
	searchBoolean = true;
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "engineerSelectSize.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"searchContent":search,"selectContent":select,"branchNaem":branchNaem},
        dataType: "json",
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (test) {
        	console.log(test);
        	searchSize = test;
        	console.log('searchSize',searchSize);
        	goPage(1,branchNaem);
        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
}

var globalEngineerName = "";
var globalEngineerPhone = "";
var globalBranchName = "";
var globalisTrip = "";

function tripEngineer(memberId) {
	console.log(globalBranchName);
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "tripEngineer.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"engineerPhone":globalEngineerPhone,"engineerName":globalEngineerName,"memberId":memberId,"branchName":globalBranchName},
        dataType: "json",
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (test) {
        	$('#alert').show();
        	document.getElementById('alert').innerHTML = 
        		' <strong>as 메시지를 보냈습니다!!</strong>'+test.engineerName+'기사님'+ test.memberName+'회원님에게 성공적으로 as 메시지를 보냈습니다.'
        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
}


function selectEngineer(index,path) {
	document.getElementById('eName').innerHTML ="수리기사 성함 : "+document.getElementById('engineerName'+index).innerHTML;
	document.getElementById('engineerImg').src =path+document.getElementById('engineerNum'+index).innerHTML+".png";
	globalEngineerName = document.getElementById('engineerName'+index).innerHTML;
	globalEngineerPhone = document.getElementById('engineerPhone'+index).innerHTML;
	globalBranchName = document.getElementById('branchName'+index).innerHTML;
	globalisTrip = document.getElementById('isTrip'+index).innerHTML;
	console.log(globalEngineerName);
	console.log(globalEngineerPhone);
}

function initModal() {
	console.log(globalisTrip);
	if(globalisTrip === "FALSE") {
	}else {
		document.getElementById('sendLine').disabled = false;
	}
}


function initMap() {
    uluru = {lat:  Number(document.getElementById('lat').innerHTML), lng:  Number(document.getElementById('lot').innerHTML)};
    map = new google.maps.Map(document.getElementById('map'), {
      zoom: 18,
      center: uluru
    });
    marker = new google.maps.Marker({
      position: uluru,
      map: map
    });
  }