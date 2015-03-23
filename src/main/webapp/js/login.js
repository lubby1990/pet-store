$(document).ready(function() {

	$("#loginBtn").click(function(){
		
		$("#message").html("");
		var userName = $("#userName").val();
		var password = $("#password").val();

		$.post(basePath + "login/loginCheck", {
			userName : userName,
			password : password
		}, function(data) {
			if (data.success) {
				window.location.href = basePath + "list/hello?userName=" + data.data[0].userName;
			} else {
				$("#message").html(data.errorMessage);
			}
		});
	});
	
	//show or hide the register div
	$("#registBtn").click(function(){
		$("#registe_message").html("");
		$("#register").toggle();
	});
	
	// register
	$("#registSubmitBtn").click(function(){
		$("#registe_message").html("");
		var userName = $("#r_userName").val();
		var password = $("#r_password").val();
		var nickName = $("#r_nickName").val();
		var gender = $("#r_gender").val();
		var address = $("#r_address").val();
		var nation = $("#r_nation").val();
		var requestData = {
				userName : userName,
				password : password,
				nickName : nickName,
				gender : gender,
				address : address,
				nation : nation
		}
		$.post(basePath + "user/registerUser" , requestData,function(data){
			if(data.success){
				window.location.href = basePath + "list/hello";
			}else{
				$("#registe_message").html(data.errorMessage);
			}
		});
		
	});

});