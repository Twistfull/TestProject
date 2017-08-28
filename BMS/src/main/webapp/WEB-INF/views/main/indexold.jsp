<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!-- saved from url=(0042)https://v3.bootcss.com/examples/dashboard/ -->
<html lang="zh-CN">

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
						<li>
							<a href="#">搜索</a>
						</li>
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
					<form class="navbar-form navbar-right">
						<input type="text" class="form-control" placeholder="检索内容...">
					</form>
				</div>
			</div>
		</nav>
		<div class="container-fluid">
			<div class="row">
			    <!-- left start -->
			    <%@ include file="/WEB-INF/views/common/left.jsp"%>
			    <!-- left end -->				
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<h1 class="page-header">阅读总览</h1>

					<div class="row placeholders">

						<div class="col-xs-6 col-sm-3 placeholder ">
							<img src="${ctx}/static/images/circle.png" width=" 200 " height="200 " class="img-responsive " alt="sorry,your picture lost">				  
							<h4>0</h4>
							<span class="text-muted ">总阅读数量</span>
						</div>
						<div class="col-xs-6 col-sm-3 placeholder ">
							<img src="${ctx}/static/images/circle1.png" width=" 200 " height="200 " class="img-responsive " alt="sorry,your picture lost">
							<h4>0</h4>
							<span class="text-muted ">已归还书籍</span>
						</div>
						<div class="col-xs-6 col-sm-3 placeholder ">
							<img src="${ctx}/static/images/circle1.png" width=" 200 " height="200 " class="img-responsive " alt="sorry,your picture lost">
							<h4>0</h4>
							<span class="text-muted ">未归还书籍</span>
						</div>
						<div class="col-xs-6 col-sm-3 placeholder ">
							<img src="${ctx}/static/images/circle1.png" width=" 200 " height="200 " class="img-responsive " alt="sorry,your picture lost">
							<h4>0</h4>
							<span class="text-muted ">逾期未还书籍</span>
						</div>
					</div>

					<h2 class="sub-header ">借阅详单</h2>
					<div class="table-responsive ">
						<table class="table table-striped ">
							<thead>
								<tr>
									<th>编号</th>
									<th>书籍名称</th>
									<th>书籍编号</th>
									<th>借阅日期</th>
									<th>归还日期</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1,001</td>
									<td>Java从入门到退坑</td>
									<td>2017070100001</td>
									<td>2017/07/01</td>
									<td>2017/07/23</td>
								</tr>
								<tr>
									<td>1,002</td>
									<td>oracle从删库到跑路</td>
									<td>2017070100002</td>
									<td>2017/07/01</td>
									<td>2017/07/24</td>
								</tr>
								<tr>
									<td>1,003</td>
									<td>android从起步到跑路</td>
									<td>2017070100003</td>
									<td>2017/07/01</td>
									<td>2017/07/25</td>
								</tr>
								<tr>
									<td>1,004</td>
									<td>xxxx</td>
									<td>2017070100004</td>
									<td>2017/07/01</td>
									<td>2017/07/26</td>
								</tr>
								<tr>
									<td>1,005</td>
									<td>xxxx</td>
									<td>2017070100005</td>
									<td>2017/07/01</td>
									<td>2017/07/27</td>
								</tr>
								<tr>
									<td>1,006</td>
									<td>xxxx</td>
									<td>2017070100006</td>
									<td>2017/07/01</td>
									<td>2017/07/28</td>
								</tr>
								<tr>
									<td>1,007</td>
									<td>xxxx</td>
									<td>2017070100007</td>
									<td>2017/07/01</td>
									<td>2017/07/29</td>
								</tr>
								<tr>
									<td>1,008</td>
									<td>xxxx </td>
									<td>2017070100008</td>
									<td>2017/07/01</td>
									<td>2017/07/30</td>
								</tr>
								<tr>
									<td>1,009</td>
									<td>xxxx</td>
									<td>2017070100009</td>
									<td>2017/07/01</td>
									<td>2017/07/31</td>
								</tr>
								<tr>
									<td>1,010</td>
									<td>xxxx</td>
									<td>20170701000010</td>
									<td>2017/07/01</td>
									<td>2017/07/23</td>
								</tr>
								<tr>
									<td>1,011</td>
									<td>xxxx</td>
									<td>20170701000011</td>
									<td>2017/07/01</td>
									<td>2017/07/23</td>
								</tr>
								<tr>
									<td>1,012</td>
									<td>xxxx</td>
									<td>20170701000012</td>
									<td>2017/07/01</td>
									<td>2017/07/23</td>
								</tr>
								<tr>
									<td>1,013</td>
									<td>xxxx</td>
									<td>20170701000013</td>
									<td>2017/07/01</td>
									<td>2017/07/23</td>
								</tr>
								<tr>
									<td>1,014</td>
									<td>xxxx</td>
									<td>20170701000014</td>
									<td>2017/07/01</td>
									<td>2017/07/23</td>
								</tr>
								<tr>
									<td>1,015</td>
									<td>xxxx</td>
									<td>20170701000015</td>
									<td>2017/07/01</td>
									<td>2017/07/23</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

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