var AuthUserLoginID = "18682561280";
var AuthUserPassword = "3d4f2bf07dc1be38b20cd6e46949a1071f9d0e3d";

function make_basic_auth(login_id, password) {
	var tok = login_id + ':' + password;
	var hash = Base64.encode(tok);
	return "Basic " + hash;
} 

function testGet() {
	
	//var crudServiceBaseUrl = "http://192.168.1.101:9090/spring4mybatis/";
	
	var RegisterParameter={
			mobileNumber:"18682561280",
			password : "123456"
	};
	
	$.ajax({
		url:"sys/user/testGet",
		type: "GET",
		async: true,
		dataType: "json",
		//data: JSON.stringify(RegisterParameter),
		contentType: "application/json",
		beforeSend : function(req) {
	        req.setRequestHeader('Authorization', make_basic_auth(AuthUserLoginID, AuthUserPassword));
	    },	
		success : function(data) {
			var tdata =data;
			if (data.status == 'OK') { 
				alert("Call Success");
			} else {
				alert("Call Failed");
			}
		}		
	});
}

function testPost() {
	
	//var crudServiceBaseUrl = "http://192.168.1.101:9090/spring4mybatis/";
	
	var RegisterParameter={
			mobileNumber:"18682561280",
			password : "123456"
	};
	
	$.ajax({
		url:"sys/user/testPost",
		type: "POST",
		async: true,
		dataType: "json",
		data: JSON.stringify(RegisterParameter),
		contentType: "application/json",
		beforeSend : function(req) {
	        req.setRequestHeader('Authorization', make_basic_auth(AuthUserLoginID, AuthUserPassword));
	    },	
		success : function(data) {
			var tdata =data;
			if (data.status == 'OK') { 
				alert("Call Success");
			} else {
				alert("Call Failed");
			}
		}		
	});
}

//用户注册
function register() {
	var crudServiceBaseUrl = "sys/user";
	
	var RegisterParameter={
			mobileNumber:"18682561280",
			password : "123456"
	};
	
	$.ajax({
		url: crudServiceBaseUrl + "/register",
		type: "POST",
		async: true,
		dataType: "json",
		data: JSON.stringify(RegisterParameter),
		contentType: "application/json",
		beforeSend : function(req) {
	        req.setRequestHeader('Authorization', make_basic_auth(AuthUserLoginID, AuthUserPassword));
	    },	
		success : function(data) {
			var tdata =data;
			if (data.status == 'OK') { 
				alert("Call Success");
			} else {
				alert("Call Failed");
			}
		}		
	});
}


//用户注册
function login() {
	var crudServiceBaseUrl = "sys/user";
	
	var RegisterParameter={
			mobileNumber:"18682561280",
			password : "123456"
	};
	
	$.ajax({
		url: crudServiceBaseUrl + "/login",
		type: "POST",
		async: true,
		dataType: "json",
		data: JSON.stringify(RegisterParameter),
		contentType: "application/json",
		beforeSend : function(req) {
	        req.setRequestHeader('Authorization', make_basic_auth(AuthUserLoginID, AuthUserPassword));
	    },	
		success : function(data) {
			var tdata =data;
			if (data.status == 'OK') { 
				alert("Call Success");
			} else {
				alert("Call Failed");
			}
		}		
	});
}

//用户注册
function demoListOrder() {
	var crudServiceBaseUrl = "demo/order";
	
	var DemoOrderParameter={
			userId:"18682561280",
			name : "123456"
	};
	
	$.ajax({
		url: crudServiceBaseUrl + "/queryOrderList",
		type: "POST",
		async: true,
		dataType: "json",
		data: JSON.stringify(DemoOrderParameter),
		contentType: "application/json",
		beforeSend : function(req) {
	        req.setRequestHeader('Authorization', make_basic_auth(AuthUserLoginID, AuthUserPassword));
	    },	
		success : function(data) {
			var tdata =data;
			if (data.status == 'OK') { 
				alert("Call Success");
			} else {
				alert("Call Failed");
			}
		}		
	});
}

$(document).ready(function() {

});
