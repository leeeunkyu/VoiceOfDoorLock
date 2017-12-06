function getkey() {
	$.ajax({
        // type을 설정합니다.
        type : 'POST',
        url : "getRsaPublicKey.do",
        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
        data : {},
		contentType:"application/json;charset=UTF-8",
        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
        success : function (key) {
        	console.log(key);
        	var publicKey="public key = ";
        	for(var i = 0; i < key.length ; i++) {
        		publicKey+=key.substring(0+(i*10),(i+1)*10)+'\n';
        	}
        	
        	document.getElementById('publicKey').innerHTML=publicKey;
        },
        error:function(e){  
            console.log(e.responseText);  
        }  
    });
}