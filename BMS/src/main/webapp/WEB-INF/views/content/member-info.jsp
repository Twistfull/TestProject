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
    
        <link rel="stylesheet" type="text/css" href="${ctx}/static/css/imgup/img_account.css" />
        <link rel="stylesheet" href="${ctx}/static/css/imgup/jquery.Jcrop.min.css" />
       <%--  <script src="${ctx}/static/js/bootstrap/jquery.min.js "></script> --%>
       <script type="text/javascript" src="${ctx}/static/js-modules/lib/jquery/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="${ctx}/static/js/imgup/jquery.Jcrop.min.js"></script>
        <script src="${ctx}/static/js/imgup/common.js "></script>
        <script type="text/javascript" src="${ctx}/static/js/imgup/person_information.js"></script>
      <!--[endif]-->
      <style>
	  .head_detail_content{
		   width:828px;
	       padding-left: 10px;
	       padding-bottom: 20px;
	       min-height:500px;
		   display:none;
	  }
	  </style>
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
				<a class="navbar-brand" href="${ctx}/login/gotoMain">图书管理系统</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<b class="glyphicon glyphicon-user" aria-hidden="true"></b>    ${reader.readerName}
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">个人中心</a>
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
				</div>
			</div>
		</nav>
		<div class="container-fluid">
			<div class="row">
				<!-- left start -->
			    <%@ include file="/WEB-INF/views/common/left.jsp"%>
			    <!-- left end -->				
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<h4 class="page-header">个人中心</h4>
					
					 <ul class="nav nav-tabs">
                               <li role="presentation" class="active" id="per_de" ><a href="javascript:void(0);" onclick="info()">基本资料</a></li>
                               <li role="presentation"  id="my_head"><a href="javascript:void(0);" onclick="member()">上传头像</a></li>
                    </ul>
               <div class="per_detail_content">

				   <ul class="media-list">
                           <li class="media">
                               <div class="media-left">
                                    <a href="#">
                                     <c:choose>
                                       <c:when test="${reader.avatar!=null}">
                                       <%-- ${reader.avatar} --%>
                                         <img class="img-rounded" src="${ctx}/static/images/avatar/${reader.avatar}" alt="个人头像" style="margin:25px 20px 10px 0;">
                                          <p class="text-center">Personal Avatar</p>
                                       </c:when>
                                       <c:otherwise>
                                         <img class="img-rounded" src="${ctx}/static/images/GRTX.jpg" alt="默认头像" style="margin:25px 20px 10px 0;">
                                         <p class="text-center">Personal Avatar</p>
                                       </c:otherwise>
                                     </c:choose>                                       
                                     </a>
                               </div>
                               <div class="media-body">
                                   <p class="sub-header"></p>
                                   <h4 class="media-heading">基本信息</h4>
                                   <p class="sub-header"></p>
                                   <ul class="list-unstyled">
	                                   <li>用户名：${user.username}</li>
	                                     <p class="sub-header"></p>
	                                   <li>邮箱：123213213@qq.com</li>
	                                     <p class="sub-header"></p>
	                                   <li>联系方式：123123123213</li>
	                                     <p class="sub-header"></p>
	                                   <li>姓名：${reader.readerName}</li>
	                                     <p class="sub-header"></p>
	                                   <li>个人简介：帅!无与伦比的帅!</li>
	                                     <p class="sub-header"></p>
                                   </ul>
                                 </div>
                              </li>
                        </ul>
                     </div> 
                       <div class="head_detail_content">					
					   <form id="headForm" name="headForm" method="post" action="#" enctype="multipart/form-data">

						<div class="headMain">
							<div class="preview_pane">
								<p>设置您的头像：</p>
								<p class="preview_background">
									<img src="${ctx}/static/images/icon.jpg" id="target" class="mainImage" />
									
								</p>
								<p>仅支持GIF、JPG、PNG图片</p>
							</div>
							<div class="source_pane">
								<p id="errory">头像预览（大小：200 * 200）</p>
								<div class="img-preview">
									<div class="img-contbox">
										<img src="${ctx}/static/images/icon.jpg" id="litte_pre" class="jcrop-preview" alt="Preview">
									</div>
								</div>
								<div>
									<a href="javascript:void(0);" class="file">上传照片 
									<input type="file" name="image" id="imgOne" accept=".png,.jpg,.gif" onChange="preImg(this.id);">
									</a>
								</div>
							</div>
						</div>
						<input type="hidden" id="x1" name="x1" /> 
                        <input type="hidden" id="y1" name="y1" />
                        <input type="hidden" id="w" name="w" /> 
                        <input type="hidden" id="h" name="h" /> 
                        <input type="hidden" id="ratio" name="ratio" /> 
                        <img style="display: none" src="${ctx}/static/images/icon.jpg" id="org_file" name="org_file" />
						<div class="text-center" style="margin-top: 10px;margin-right: 800px">
							<input type="button" id="btnHeadSave"  class="save_button save_left" onclick="checkImage()"  value="保   存" />
						</div>
					</form>
					<%-- <form action="${ctx}/file/photoUpload" method="post" enctype="multipart/form-data">
					     选择文件:<input type="file" name="file">
					     <input type="submit" value="上传"> 
					 </form> --%>
				    </div>
				</div>
			</div>
		</div>

		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->

		 <script src="${ctx}/static/js/imgup/jquery.form.min.js "></script>
        
         
        <script type="text/javascript">
        var jcrop_api, boundx, boundy, $preview, $pcnt, pimg;
        var xsize, ysize;
        $(document).ready(function (e) {
            $preview = $('.img-preview');
            $pcnt = $('.img-preview .img-contbox');
            $pimg = $('.img-preview .img-contbox img');
            xsize = $pcnt.width();
            ysize = $pcnt.height();
        });
        </script>
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