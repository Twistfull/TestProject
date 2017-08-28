<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!-- saved from url=(0042)https://v3.bootcss.com/examples/dashboard/ -->

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="${ctx}/static/images/favicon.ico">

		<title>图书管理系统</title>

		<!-- Bootstrap core CSS -->
		<!-- <link href="${ctx}/static/css/bootstrap/bootstrap.min.css" rel="stylesheet"> -->
        <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<link href="${ctx}/static/css/bootstrap/ie10-viewport-bug-workaround.css" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="${ctx}/static/css/bootstrap/dashboard.css" rel="stylesheet">

		<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
		<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
		<script src="${ctx}/static/js/bootstrap/ie-emulation-modes-warning.js"></script>
        <!-- 跳转start -->
        <link href="${ctx}/static/css/bootstrap/bootstrap-spinner.css" rel="stylesheet">
        <link href="${ctx}/static/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <script type="text/javascript" src="${ctx}/static/js-modules/lib/jquery/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="${ctx}/static/js-modules/lib/jquery/jquery.spinner.min.js"></script>
        <script type="text/javascript" src="${ctx}/static/js/reader/addborrow.js"></script>
        <!-- end -->
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	</head>

	<body>

		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
					<a class="navbar-brand" href="#">图书管理系统</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<!-- <li>
							<a href="javascript:void(0)" onClick="select()">搜索</a>
						</li> -->
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<b class="glyphicon glyphicon-user" aria-hidden="true"></b>    ${username}
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="${ctx}/login/gotoMember">个人中心</a>
								</li>								
								<li class="divider"></li>
								<li>
									<a href="${ctx}/login/logout">注销</a>
								</li>
							</ul>
						</li>						
						<li>
							<a href="#">设置</a>
						</li>
						<li>
							<a href="#">帮助</a>
						</li>
					</ul>
					<!-- <form class="navbar-form navbar-right">
					    <div class="input-group">
                          <div class="input-group-btn">
                            <button type="button" id="termbookname" name="bookName" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
                               <span id="term">书名</span>&nbsp;<span class="caret"></span></button>
                            <ul class="dropdown-menu">
                              <li><a href="javascript:void(0)" onClick="selectterm('书名')">书名</a></li>
                              <li><a href="javascript:void(0)" onClick="selectterm('书籍类型')">书籍类型</a></li>
                              <li><a href="javascript:void(0)" onClick="selectterm('作者')">作者</a></li>
                              <li><a href="javascript:void(0)" onClick="selectterm('简介')">简介</a></li>
                            </ul>
                          </div>/btn-group
						  <input type="text" class="form-control" id="selectcontent" placeholder="检索内容...">
						</div>/input-group
                         <button type="submit" class="btn btn-default">Submit</button>
					</form> -->
				</div>
			</div>
		</nav>
		<div class="container-fluid">
			<div class="row">
				  <div class="col-sm-3 col-md-2 sidebar">
					<ul class="nav nav-sidebar">
						<li >
							<a href="${ctx}/login/gotoMain">首页<span class="sr-only">(current)</span></a>
						</li>
						<li class="active">
							<a href="${ctx}/reader/bookinfo/pageid?id=1">图书信息</a>
						</li>
						<li>
							<a href="${ctx}/reader/borrowinfo/select?bookInfo.bookName=">借阅信息</a>
						</li>
						<li>
							<a href="${ctx}/reader/borrowtip">逾期提醒</a>
						</li>
						<li>
							<a href="${ctx}/reader/payfor">罚款信息</a>
						</li>
						<li>
							<a href="#">导出</a>
						</li>
					</ul>
					<ul class="nav nav-sidebar">
						<li>
							<a href="#">系统公告</a>
						</li>
					</ul>
                </div>	
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="changediv">
					
					<h2 class="sub-header" id="successtip">借阅信息</h2>
					<div class="per_detail_content">
					      <ul class="media-list">
	                           <li class="media">
	                               <div class="media-left">
	                                    <%-- <a href="#">
	                                       <img class="media-object" src="${ctx}/static/images/GRTX.jpg" alt="${ctx}/static/images/GRTX.jpg">
	                                     </a> --%>
	                               </div>
	                               <div class="media-body" id="borrowdetail">
	                                   
	                                   <h3 class="media-heading">详细信息</h3>
	                                   <p class="sub-header"></p>
	                                   <ul class="list-unstyled">
	                                       <li>借阅人:&nbsp;&nbsp;${username}</li>
		                                    <p class="sub-header"></p>
		                                   <li>借阅书籍:&nbsp;&nbsp;${borrow.bookName}</li>
		                                     <p class="sub-header"></p>
		                                   <li>借阅日期:&nbsp;&nbsp; 
		                                   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt1"%><!-- 格式化日期 -->
										     <fmt1:formatDate value="${borrow.startDate}" pattern="yyyy-MM-dd"/>
		                                   </li>
		                                     <p class="sub-header"></p>
		                                   <li>归还日期:&nbsp;&nbsp;
		                                   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt2"%><!-- 格式化日期,注意value里不要有空格 -->
										     <fmt2:formatDate value="${borrow.endDate}" pattern="yyyy-MM-dd"/>
		                                   </li>
		                                     <p class="sub-header"></p>		                                   
		                                   <li>小提示:&nbsp;&nbsp;在借书籍不能超过8本,逾期未还书籍不能超过3本，否则不予借阅。
		                                    
		                                   </li>		                                  
		                                     <p class="sub-header"></p>
	                                   </ul>
	                                 </div>
	                              </li>
	                        </ul>
                     </div> 
                    <input type="button" class="btn btn-primary" id="confirm" name="back" value="确认" onclick="AddBorrow('confirm')"/>
                    <input type="button" class="btn btn-primary" id="cancel" name="back" value="取消" onclick="AddBorrow('cancel')" style="margin-left:20px;"/>
				</div>
			</div>
		</div>
       <%--  <script src="${ctx}/static/js/reader/bookinfo.js "></script> --%>
		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="${ctx}/static/js/bootstrap/jquery.min.js "></script>
		<!-- <script>
			window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js "><\/script>')
		</script> -->
		<script src="${ctx}/static/js/bootstrap/bootstrap.min.js"></script>
		<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
		<script src="${ctx}/static/js/bootstrap/holder.min.js "> </script>
			<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<script src = "${ctx}/static/js/bootstrap/ie10-viewport-bug-workaround.js "></script>

	</body>

</html>