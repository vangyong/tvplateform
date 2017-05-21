
//登录处理函数
function login() {
var crudServiceBaseUrl = "sys/login";
	
	var LoginParameter={
			loginName:"18682561280",
			password : "123456"
	};
	
	$.ajax({
		url: crudServiceBaseUrl + "/login",
		type: "POST",
		async: true,
		dataType: "json",
		data: JSON.stringify(LoginParameter),
		contentType: "application/json",
		beforeSend : function(req) {
	      //  req.setRequestHeader('Authorization', make_basic_auth(AuthUserLoginID, AuthUserPassword));
	    },	
		success : function(data) {
			if (data.status == 'OK') { 
				$.ajax({
					url: crudServiceBaseUrl + "/main",
					type: "GET",
					async: true,
					//dataType: "json",
					//data: JSON.stringify(RegisterParameter),
					//contentType: "application/json",
					beforeSend : function(req) {
				       // req.setRequestHeader('Authorization', make_basic_auth(AuthUserLoginID, AuthUserPassword));
				    },	
					success : function(data) {
					}		
				});
				
			} else {
				alert("Call Failed");
			}
		}		
	});
}

