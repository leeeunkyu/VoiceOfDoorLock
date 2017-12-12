function getkey() {
	
	
    $.ajax({
        type: 'POST',
        url: "getRsaPublicKey.do",
        data: {},
        contentType: "application/json;charset=UTF-8",
        success: function(key) {
            console.log(key);
            var publicKey = "public key = ";
            for (var i = 0; i < key.length; i++) {
                publicKey += key.substring(0 + (i * 10), (i + 1) * 10) + '\n'
            }
            document.getElementById('publicKey').innerHTML = publicKey
        },
        error: function(e) {
            console.log(e.responseText)
        }
    })
}
function setKey() {
	   $.ajax({
	        type: 'get',
	        url: "setRsaKey.do",
	        data: {},
	        contentType: "application/json;charset=UTF-8",
	        success: function(key) {
	            console.log(key);
	            getkey();
	        },
	        error: function(e) {
	            console.log(e.responseText)
	        }
	    })
}