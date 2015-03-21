$(document).ready(function() {

	$("#loginBtn").click(function(){
		var userName = $("#userName").val();
		var password = $("#password").val();

		$.post(basePath + "login/loginCheck", {
			userName : userName,
			password : password
		}, function(data) {
			if (data.success) {
				
				window.location.href = basePath + "login/hello?userName=" + data.data[0].userName;
			} else {
				$("#message").html(data.errorMessage);
			}
		});
	});

});