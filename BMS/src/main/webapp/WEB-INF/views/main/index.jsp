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
							<!-- <a href="#">搜索</a> -->
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
						<!-- <input type="text" class="form-control" placeholder="检索内容..."> -->
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
					    <div class="col-md-12 column">
                                  <div class="jumbotron">
                                        <h1>Hello, 陈先生!</h1>
                                        <p class="text-left">好书推荐 : 《程序员的进阶之旅》、《程序员的颠峰操作》等</p>
                                        <p class="text-left">最热门书籍 : 《程序员的日常生活》等</p>
                                        <p class="text-left">最新上架书籍 : 《Oracle》 、《Mysql》 、《计算操作系统》等</p>  
                                        <p>
                                             <a class="btn btn-primary btn-large" href="#">了解更多</a>
                                        </p>
                                    </div>
                                    <div class="row clearfix">
                                        <div class="col-md-12 column">
                                            <div class="media">
                                              <div class="media-left">
                                                <a href="#">
                                                  <img class="img-circle" src="${ctx}/static/images/GTX.jpg"  style="width:80px;height:80px;"alt="...">
                                                </a>
                                              </div>
                                              <div class="media-body">
                                                <h4 class="media-heading">总共借阅书籍</h4>
                                                从1996年至2017年8月25号，在这10几年间，感谢你对我们的信任，你在这期间一共借阅过<mark>1880</mark>本书籍，其中借阅次数最多的是经济文化科技类的书籍，达到<mark>1234</mark>册，其中最感兴趣的书籍是Oracle，借阅了<mark>18</mark>次之多!
                                              </div>
                                            </div>     
                                            <div class="media">                                             
                                              <div class="media-body">
                                                <h4 class="media-heading">逾期归还情况</h4>
                                                从1996年至2017年8月25号，在这10几年间，感谢你对我们的信任，你在这期间一共借阅过<mark>1880</mark>本书籍，其中逾期未还的次数达到了<mark>1500</mark>次之多，希望在之后的使用中，您还需要多注意书籍的归还时间!配合我们的工作! 
                                              </div>
                                              <div class="media-right">
                                                <a href="#">
                                                  <img class="img-circle" src="${ctx}/static/images/GTX.jpg" style="width:80px;height:80px ;"alt="..." >
                                                </a>
                                              </div>
                                            </div>
                                            <div class="media">
                                              <div class="media-left media-middle">
                                                <a href="#">
                                                  <img class="img-circle" src="${ctx}/static/images/GTX.jpg" style="width:80px;height:80px ;"alt="..." >
                                                </a>
                                              </div>
                                              <div class="media-body">
                                                <h4 class="media-heading">罚款情况</h4>
                                               从1996年至2017年8月25号，在这10几年间，感谢你对我们的信任，你在这期间一共借阅过<mark>1880</mark>本书籍，其中因为逾期或者图书丢失而造成的赔偿金额高达<mark>17567元</mark>人民币，望能引起重视，避免不必要的损失和公共资源的浪费! 
                                             
                                              </div>
                                             
                                            </div>
                                           <!-- 
                                            <img class="img-circle" alt="140x140" src="../../../../Pictures/Saved Pictures/GTX.jpg"/>
                                            <img class="img-circle" alt="140x140" src="../../../../Pictures/Saved Pictures/GTX.jpg" />
                                            <img class="img-circle" alt="140x140" src="../../../../Pictures/Saved Pictures/GTX.jpg" />-->
                                        </div>
                                    </div>
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