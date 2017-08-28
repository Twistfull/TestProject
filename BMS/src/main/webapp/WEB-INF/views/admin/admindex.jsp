<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<head>
<title>图书后台管理</title>
<link href="${ctx}/static/css/admin/css/adminStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/static/js-modules/lib/jquery/jquery-1.9.1.min.js"></script>
<title>图书后台管理</title>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(".div2").click(
						function() {
							$(this).next("div").slideToggle("slow").siblings(
									".div3:visible").slideUp("slow");
						});
			});
	function openurl(url) {
		var rframe = parent.document.getElementById("rightFrame");
		rframe.src = url;
	}
</script>

</head>
<body>

	<div class="top2">
		<div class="logo">
			<img src="${ctx}/static/images/images/admin_logo.png" title=" " />
		</div>
		<div class="title" >
			<h3>图书后台管理系统</h3>
		</div>
		<div class="fr top-link">
		    <%-- <a href="${ctx}/login/gotoMember" target="mainCont" title="DeathGhost"> --%>
			<a href="#" target="mainCont" title="DeathGhost">
              <span>管理员：${admin.adminName}</span></a> 
			<span>在线人数：${userNumber }</span>
		</div>
	</div>

	<div class="left">
		<div class="div1">
			<div class="left_top">
  
  			</div>
			
           <div class="div2">
				<div class="spgl"></div>
				图书管理
			</div>
			<div class="div3">
				<li><a class="a" href="javascript:void(0);"
					onClick="openurl('${ctx}/admin/listAll');">图书信息</a></li>
				<li><a class="a" href="javascript:void(0);"
					onClick="openurl('${ctx}/admin/addBook');">添加图书</a></li>
			   
			</div>
			<div class="div2">
				<div class="spgl"></div>
				借阅管理
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('${ctx}/admin/listBorrow');">查看借阅记录</a></li>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('${ctx}/admin/listReturn');">查看归还记录</a></li>
				</ul>
			</div>
			
			<div class="div2">
				<div class="yhgl"></div>
				用户管理
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('${ctx}/admin/showReaders');">查看用户信息</a></li>
              
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('teacherQuery.html');">注销用户</a></li>
				</ul>
			</div>
			
			<div class="div2">
				<div class="spgl"></div>
				借还统计
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('${ctx}/admin/showInAndOut');">借出/归还</a></li>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('afficheAdd.html');">图书类型</a></li>
				</ul>
			</div>
			<a class="a1" href="login.html">
                <div class="div2">
					<div class="tcht"></div>
					退出后台
				</div></a>
		</div>
	</div>

	<div class="right">
		<iframe id="rightFrame" name="rightFrame" width="100%" height="100%"
			scrolling="auto" marginheight="0" marginwidth="0" align="center"
			style="border: 0px solid #CCC; margin: 0; padding: 0;"></iframe>
	</div>

</body>
</html>
