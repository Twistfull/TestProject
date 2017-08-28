<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>

<html>
<head>
	<title>用户登录</title>
	<link rel="stylesheet" href="${ctx}/static/css/base.css" />
    <link rel="stylesheet" href="${ctx}/static/css/global.css" />
	<link rel="stylesheet" href="${ctx}/static/css/login-register.css" />
	<style>
      .error{
	      color:red;
           }
    </style>
</head>
<body>
	<div class="header wrap1000">
		<a href="index.jsp"><img src="${ctx}/static/images/logo.png" alt="" /></a>
	</div>
	<div class="main">
		<div class="login-form fr">
			<div class="form-hd">
				<h3>用户登录 <b style="color:#F00;  font-size:12px" name="error" id="error"></b></h3>
			</div>
			<div class="form-bd">
				<form method="post" action="" name="loginForm" id="loginForm" role="form">
					<dl>				   
						<dt >用户名</dt>
						<dd><input type="text" name="username" class="text"  /></dd>
					</dl>
					<label></label>
					<dl>
						<dt >密&nbsp;&nbsp;&nbsp;&nbsp;码</dt>
						<dd><input type="password" name="password" class="text" /></dd>
					</dl>
					<label></label>
					<dl>
						<dt>&nbsp;</dt>
						<dd><input type="button" value="登 录" class="submit" id="submitButton"/> <a href="" class="forget">忘记密码?</a></dd>
					</dl>
				</form>
				<dl>
					<dt>&nbsp;</dt>
					<dd>还不是本站会员？立即<a href="javascript:void(0);" onclick="register()" class="register">注册</a></dd>
				</dl>
			</div>
			<div class="form-ft">
			</div>		
		</div>
		<div class="login-form-left fl">
			<img src="${ctx}/static/images/left.jpg" alt="" />
		</div>
	</div>
	<div class="footer clear wrap1000">
	</div>
<jsp:include page="/WEB-INF/views/common/include_javascript.jsp"/>	
<script type="text/javascript" src="${ctx}/static/js/login.js"></script>
</body>
</html>
