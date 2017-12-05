$(document).ready(function(){

});
var uluru;
var map;
var marker;
function searchLocation(branchName) {
	$.ajax({
        // type을 설정합니다.
        type : 'GET',
        url : "getBranchLocation.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {"branchName":branchName},
        dataType: "json",
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (location) {
        	document.getElementById('lat').value=location.lat;
        	document.getElementById('lot').value=location.lot;
        	console.log(location.lat);
        	console.log(uluru);
        	uluru.lat =  Number(location.lat);
        	uluru.lng =  Number(location.lot);
        	console.log(uluru);
        	map = new google.maps.Map(document.getElementById('map'), {
        	      zoom: 15,
        	      center: uluru
        	    });
        	    marker = new google.maps.Marker({
        	      position: uluru,
        	      map: map
        	    });
        	/*for(var i=0;i<5;i++){
        	document.getElementById('applicationDay'+i).innerHTML=test[i].applicationDay;
        	document.getElementById('memberId'+i).innerHTML=test[i].memberId;
        	document.getElementById('memberName'+i).innerHTML=test[i].memberName;
        	document.getElementById('memberPhone'+i).innerHTML=test[i].memberPhone;
        	document.getElementById('doorlockAddress'+i).innerHTML=test[i].doorlockAddress;

        	}*/
        },
        error:function(e){  
            console.asApplication(e.responseText);  
        }  
    });
}
function initMap() {
    uluru = {lat: 37.532395, lng: 126.986};
    map = new google.maps.Map(document.getElementById('map'), {
      zoom: 10,
      center: uluru
    });
    marker = new google.maps.Marker({
      position: uluru,
      map: map
    });
  }

function saveLocation(lat,lot) {
	opener.document.getElementById("branchLatitude").value = lat;
	opener.document.getElementById("branchLongitude").value = lot;

    // 창을 닫음
    window.close();
}