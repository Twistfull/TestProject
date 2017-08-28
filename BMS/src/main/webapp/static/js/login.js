requirejs([ 'jquery.validate.ex' ], function(_) {

	var validator = $("#loginForm").validate({
		wrapper: "label",

		rules : {
			username : "required",
			password : "required"
		},
		messages : {// Key is the name of an element
			username :" *不为空",
			password : " *不为空"
		}
/*		groups: {//定义错误集中显示
		    username: "请输入用户名"
		  },
		  errorPlacement: function(error, element) {
		     if (element.attr("name") == "username" || element.attr("name") == "password" )
		       error.insertAfter("#error");
		     else
		       error.insertAfter(element);
		   }*/
	});

	$("#submitButton").click(function() {
		if (validator.form()) {
			$.ajax({
				type : "POST",
				url : ctx + "/login/doLogin",
				data : $("#loginForm").serialize(),
				dataType : "json",
				success : function(result) {
					if (result && result.statusCode == 1) 
					   {
						window.location.href = ctx + "/login/gotoMain";
					   }
					else
						{
						document.getElementById("error").innerHTML = result.message;
						}
					
					/*ajaxReturn(result, function() {
						window.location.href = ctx + "/login/gotoMain";
					}, function() {
						message('', '登录失败，用户名或密码错误', {
							'returnJson' : result,
							'type' : 'error'
						});
					});*/
				}
			});
		} else {
			document.getElementById("error").innerHTML = "这是不应该发生的错误";// focus 错误的输入框
		}
	});

});

function register() {
	window.location.href = ctx + "/login/register";
}
