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
        <!-- bootstrap-table依赖 -->
		<link rel="stylesheet" href="${ctx}/static/css/bootstrap/table/bootstrap-table.css">
		
        <script type="text/javascript" src="${ctx}/static/js-modules/lib/jquery/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="${ctx}/static/js-modules/lib/jquery/jquery.spinner.min.js"></script>
       
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
                              <li><a href="javascript:void(0)" onClick="selectterm('作者')">作者</a></li>
                              <li><a href="javascript:void(0)" onClick="selectterm('书籍类型')">书籍类型</a></li>                            
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
						<li >
							<a href="${ctx}/reader/bookinfo/select?bookName=">图书信息</a>
						</li>
						<li>
							<a href="${ctx}/reader/borrowinfo/select?bookInfo.bookName=">借阅信息</a>
						</li>
						<li>
							<a href="${ctx}/reader/borrowtip">逾期提醒</a>
						</li>
						<li class="active">
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
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">			
				   <h2 class="sub-header ">罚款信息				   
				   </h2>										
                    	<div class="table-responsive ">	
                               <input type="button" class="btn btn-primary" name="back" value="已处理" onclick="changurl(0);" />
                               <input type="button" class="btn btn-primary" name="back" value="未处理" onclick="changurl(1);"/>
                               <input type="button" class="btn btn-primary" name="back" value="全部" onclick="changurl(2);"/>
                               <a class="btn btn-primary"  href="${ctx}/reader/export.do" >导出</a> 
					           <table id="tb_departments"></table>
					         
					        </div>
						    <!-- 模态框（Modal） 显示书籍详细信息-->
									<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									    <div class="modal-dialog">
									        <div class="modal-content">
									            <div class="modal-header">
									                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									                <h4 class="modal-title" id="myModalLabel">详细信息</h4>
									            </div>
									            <div class="modal-body">在这里添加一些文本</div>
									            <div class="modal-footer">
									                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									                <button type="button" class="btn btn-primary">提交更改</button>
									            </div>
									        </div><!-- /.modal-content -->
									    </div><!-- /.modal -->
									</div>
							<!-- 模态框（Modal） 显示书籍借阅信息( data-backdrop="static" 用户点击模态框外不关闭)-->
					    </div>
                        <script> /* 在模态框完全对用户隐藏后清空模态框数据	 */								    
							$(function() {
							    $('#myModal').on('hidden.bs.modal',
							    function() {
							    	 $(this).removeData("bs.modal"); 
						     })
							}); 
					   </script>                      
				</div>
			</div>
		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="${ctx}/static/js/bootstrap/jquery.min.js "></script>
		
		<!-- bootstrap-table依赖 -->
		<script src="${ctx}/static/js/bootstrap/table/bootstrap-table.js"></script>
		<script src="${ctx}/static/js/bootstrap/table/bootstrap-table-zh-CN.js"></script>
		
		<script src="${ctx}/static/js/reader/payforinfo.js "></script>
		<!-- <script>
			window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js "><\/script>')
		</script> -->
		<script src="${ctx}/static/js/bootstrap/bootstrap.min.js"></script>
		<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
		<script src="${ctx}/static/js/bootstrap/holder.min.js "> </script>
			<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<script src = "${ctx}/static/js/bootstrap/ie10-viewport-bug-workaround.js "></script>
		<!-- 隐藏，既在关闭模态框时触发事件   $(function(){}) 是 $(document).ready(function(){}) 的简写 -->	 

	</body>

</html>