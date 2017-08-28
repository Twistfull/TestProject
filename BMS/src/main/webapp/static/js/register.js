
requirejs(['jquery.validate.ex'], function (_) {

    //完成注册页面
        var validateResult = $("#registerForm").validate({
//            errorElement: 'dt',//默认的是label
        	wrapper: "label",
            rules: {
                username: {
                    required: true,
                    remote: {                                          //验证用户名是否存在
                    	type: "POST",
                        url: ctx + "/login/remoteUsername",             //servlet
                        cache: false,
                        async: false,
                        data: {
                            username: function () {
                               return $("#username").val();//返回第一个匹配的value属性                     

                            }
                        }
                    }
                },
                password: "required",
                repassword: {
                    required: true,
                    equalTo: "#password"
                },
                readerName: "required",
                email: {
                	    required:true,
                	    email:true
                       }
            },
            messages: {
                username: {
                    //required: "<font color='red'>请输入用户名</font>",
                    required: " *不能为空",
                    remote: " *已存在"
                },
                password: " *不能为空",
                repassword: {
                    required:" *再次输入",
                    equalTo: " *不一致"
                },
                readerName: " *姓名不能为空",
                email: {
                	required:" *不能为空",
                	email:" *格式不正确"
                }
            }
        });
        $('#addRegister').click(function () {
        if (validateResult.form()) {
            $.ajax({
                type: "POST",
                url: ctx + "/login/addRegister",
                data: $("#registerForm").serialize(),
                dataType: "json",
                success: function (result) {
                	if (result &&result.statusCode== 1 && result.statusCode != 99999 && result.message) 
					   {
                		  /*requirejs(["toastr"], function (toastr) {
                		        var toastrOptions = {
                		               //"closeButton" : true,
                		                  "newestOnTop": false, //默认 true
                		                  "progressBar": true,
                		            //"timeOut": "5000", //默认5秒
                		                  "timeOut":" 5000", 
                                    }
                		        toastr.success("注册成功，即将跳转到登录页面");                		        
                		  });
                		 setTimeout(function(){window.location.href= ctx+"/"},5000);*/
                		document.getElementById("registerForm").innerHTML=" ";
                		document.getElementById("registersuccess").innerHTML="注册成功！即将登录到主页";
                		setTimeout(function(){window.location.href = ctx + "/login/gotoMain";},3000);
             		   
					   }
					else
						{
						requirejs(["toastr"], function (toastr) {
            		        var toastrOptions = {
            		               //"closeButton" : true,
            		                  "newestOnTop": false, //默认 true
            		                  "progressBar": true,
            		            //"timeOut": "5000", //默认5秒
            		                  "timeOut":" 5000", 
                                }
            		        toastr.error("注册失败");
            		  });            		       
						
					/*	document.getElementById("error").innerHTML = result.message;*/
						}
                }
                    /*ajaxReturn(result, function () {
                        message('', '注册成功，即将跳转到登录页', {
                            'type': 'success', 'timeOut': 2000,
                            'onClose': function () {
                                window.location.href = ctx+"/";
                            }
                        });
                    }, function () {
                        message('', '注册失败', {'returnJson': result, 'type': 'error'});
                    });
                }*/
            });
        }
    });
});

function login() {
	window.location.href = ctx + "/login/login";
}



