<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>用户注册</title>
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
				<h3 id="registersuccess">用户注册<b style="color:#F00;  font-size:12px" >&nbsp;</b></h3>
			</div>
			<div class="form-bd">
				<form action="" method="post" name="registerForm" id="registerForm">
					<dl>
						<dt>用&nbsp;户&nbsp;名</dt>
						<dd><input type="text" name="username" id="username"  class="text"  style="width:180px;"/></dd>
					</dl>
					<label></label>
					<dl>
						<dt>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</dt>
						<dd><input type="password" name="password"  id="password"class="text" style="width:180px;"/></dd>
					</dl>
					<label></label>
					<dl>
						<dt>确认密码</dt>
						<dd><input type="password" name="repassword" id="repassword" class="text" style="width:180px;"/></dd>
					</dl>
					<label></label>
                    <dl>
						<dt>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</dt>
						<dd><input type="text" name="readerName" id="readerName" class="text" style="width:180px;"/> </dd>
					</dl>
                    <label></label>
                    <dl>
						<dt>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</dt>
						<dd><input type="text" name="email" id="email" class="text" style="width:180px;"/></dd>
					</dl>
                    
                    <dl>
						<dt>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</dt>      
						<dd> 
                            <label><input type="radio" name="sex" id="sexM" value="男" id="R1"    checked/>男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                            <label><input type="radio" name="sex" id="sexW" value="女" id="R2"         />女</label>
                        </dd>
                       
					</dl>
					              				
					<dl>
						<dt>&nbsp;</dt>
						<dd><input type="button" value="立即注册" class="submit" id="addRegister" /> <input type= "checkbox" checked="checked"/>阅读并同意<a href="" class="forget">服务协议</a></dd>
					</dl>
				</form>
			</div>
			<div class="form-ft">
			</div>		
		</div>
		<div class="login-form-left fl">
			<dl class="func clearfix">
				<div class="login-form-left fl">
			    <img src="${ctx}/static/images/left2.jpg" alt="" />
		         </div>
			</dl>
			<div class="if">
				<!--<b style="color:#333;  font-size:18px; font-weight:400">如果您是本站用户</b>-->
                <br/>
                <br/>
                <br/>
                <br/>
				<p>我已经注册过账号，立即 <a href="javascript:void(0);" onclick="login()" class="register">登录</a> 或是 <a href="" class="findpwd">找回密码？</a></p>
			</div>
		</div>
	</div>
	<div class="footer clear wrap1000">
	</div>
  <jsp:include page="/WEB-INF/views/common/include_javascript.jsp"/>	
  <script type="text/javascript" src="${ctx}/static/js/register.js"></script>
</body>
</html>
