function createDoorLock() {
	$.ajax({
        type : 'GET',
        url : "insertDoorKey.do",
		contentType:"application/json;charset=UTF-8",
        success : function (doorlock) {
        	document.getElementById('doorLockNum').innerHTML="doorlock id: "+doorlock.doorLockNum;
        	document.getElementById('doorLockPassword').innerHTML="doorlock pw: "+doorlock.doorLockPassword;
        	document.getElementById('doorLockOk').innerHTML="doorlock pw: "+doorlock.doorLockOk;

        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
}
