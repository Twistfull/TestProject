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
		
		
		<link rel="stylesheet" type="text/css" href="${ctx}/static/css/admin/css/easy-ui/easyui.css">
	    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/admin/css/easy-ui/icon.css">
	    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/admin/css/easy-ui/demo.css">
	    <script type="text/javascript" src="${ctx}/static/js/admin/js/easy-ui/jquery.min.js"></script>
	    <script type="text/javascript" src="${ctx}/static/js/admin/js/easy-ui/jquery.easyui.min.js"></script>

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
        <style>
		    #myModalReturn
		    {
		        top:100px;
		    }		   
		</style>
        <script type="text/javascript">
        $('document').ready(function (){
        	var userask="全部";
        	
        	url=ctx+"/reader/borrowinfo/select?returnInfo.payExplain=已处理";
        	url1=ctx+"/reader/borrowinfo/select?returnInfo.payExplain=未处理";
        	url2=ctx+"/reader/borrowinfo/select?bookInfo.bookName=";

        })
                   
           function userask1(){
           	
           	userask="已归还";
           	window.location.href=url;//查询已归还书籍（包括处理过的丢失）
           //	alert(userask);
           }
           
           function userask2(){
           	userask="未归还";
           	window.location.href=url1;//查询未归还书籍
           	//	alert(userask);
           }
           
           function userask3(){
           	userask="全部";
            window.location.href=url2;//查询所有书籍
           	//	alert(userask);
           }
        	
        </script>
       
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
						<li>
							<a href="javascript:void(0)" onClick="select()">搜索</a>
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
					<form class="navbar-form navbar-right" id="woqunimalgb">
					    <div class="input-group">
                          <div class="input-group-btn">
                            <button type="button" id="termbookname" name="bookName" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
                               <span >书名</span>&nbsp;</button>

                          </div><!-- /btn-group -->
						  <input type="text" class="form-control" name="bookName" id=bookName  placeholder="检索内容...">
						</div><!-- /input-group -->
						<!--start-- bootstrap-datetimepicker -->
						<!-- <div class="form-group">
			                <label for="dtp_input2" class="col-md-2 control-label">Date Picking</label>
			                <div class="input-group date form_date col-md-5"  data-date-format="yyyy-mm-dd" >
			                    <input name="dtBegin" class="form-control" size="16" type="text" value=""  >
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
								<input name="dtEnd" class="form-control" size="16" type="text" value=""   >
			                   <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                </div>
							<input type="hidden" id="dtp_input2" value="" /><br/>
			            </div> -->
			            <!--end-- bootstrap-datetimepicker -->
			            <!-- start-easyui Date-->
						<input id="startDate" name="startDate" type="text" class="easyui-datebox"  data-options="formatter:myformatter,parser:myparser" style="width:150px;height:35px;">
                        <input id="endDate" name="endDate" type="text" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" style="width:150px;height:35px;"> 
                         <!-- end-easyui  Date--> 
                         <!--<button type="submit" class="btn btn-default">Submit</button>-->
					</form>
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
						<li class="active">
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
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!--start  弹出提示框 -->
				   <div id="showsuccessreturn" class="alert alert-success alert-dismissible" role="alert"  style="display:none">
                      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                       <strong>归还成功!</strong>  记得注意归还时间,逾期可以会罚款的哦!
                   </div>
                  <div id="showsuccesspayfor" class="alert alert-success alert-dismissible" role="alert"  style="display:none">
                      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                       <strong>赔偿成功!</strong>  下次记得保管好借阅的书籍哦!
                   </div>
                   <script type="text/javascript">
						$(function(){
							$("#showdangerborrow").bind('closed.bs.alert', function () {
								window.location.reload();//关闭警告后的刷新页面
								/* alert("警告消息框被关闭。"); */
							});
						});
				  </script>  
                  <!--end  弹出提示框 -->
					<h2 class="sub-header ">借阅信息
					  <input type="button" class="btn btn-primary" name="back" value="已归还" onclick="userask1();"/>
                      <input type="button" class="btn btn-primary" name="back" value="未归还" onclick="userask2();"/>
                      <input type="button" class="btn btn-primary" name="back" value="全部" onclick="userask3();"/>
					</h2>
                    	<div class="table-responsive " style="overflow:scroll;height:360px;">
                    	
						<table class="table table-striped ">
							<thead >
								<tr>
									<th>书籍名称</th>
									<th>借阅日期</th>
									<th>期限</th>
									<!--<th>出版日期</th>  -->
									<!-- <th>详情</th> -->
									<th>状态</th>
								</tr>
							</thead>										         					
							<tbody >
							    <c:forEach items="${requestScope.list }" var="borrow" varStatus="id" >
							      <tr>
									<td>${borrow.bookInfo.bookName}</td>
									<td><%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- 格式化日期 -->
										<fmt:formatDate value="${borrow.startDate}" pattern="yyyy-MM-dd"/></td>
									<td>一个月</td>																											
									<%-- <td><a href="${ctx}/reader/borrow/borrowid?id=${borrow.recordId}" aria-label="Detail">详情</a></td> --%>
									<c:choose>
									    <c:when test="${borrow.bookInfo.bookStatus=='外借'&&borrow.returnInfo.payExplain==null}">
									        <td><a href="#" data-toggle="modal" data-target="#myModalReturn"  aria-label="Borrow" onclick="productReturnInfo('${borrow.recordId}')">未归还</a></td>
									    </c:when>
									    <c:otherwise>
											<c:choose>
											    <c:when test="${borrow.bookInfo.bookStatus=='丢失'&&borrow.returnInfo.payFor==borrow.bookInfo.bookPrice}">
											          <td>丢失</td>
											    </c:when>
											    <c:otherwise>
											          <td>已归还</td>
											    </c:otherwise>
											</c:choose>
									    </c:otherwise>
									</c:choose>
								  </tr>							    
							    </c:forEach>						
							</tbody>
						</table>
						 <!-- 模态框（Modal） 显示书籍归还信息(用户点击模态框外不关闭)-->
						<div class="modal fade" id="myModalReturn" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"   data-backdrop="static" 
							data-backdrop="true"  data-keyboard="false">
							    <div class="modal-dialog">
							        <div class="modal-content">
							            <div class="modal-header">
							                <!-- <button type="button" class="close" data-dismiss="modal"  id="cancel" aria-hidden="true" id="cancel" name="back"  onclick="ReturnBook(this.id)">&times;</button> -->
							                <h4 class="modal-title" id="myModalLabel">归还信息</h4>
							            </div>
							            <div class="modal-body"><!-- 模态框主体部分 -->
							                <div class="media-body" id="returndetail">	                                   
			                                   
			                                </div>
	                                    </div>
							            <div class="modal-footer" id="inputlink">					                
							                <input type="button" class="btn btn-primary" data-dismiss="modal" id="confirm" name="back" value="确认归还" onclick="ReturnBook(this.id)" style="margin-left:10px;"/>
                                            <input type="button" class="btn btn-primary" data-dismiss="modal" id="cancel" name="back" value="取消" onclick="ReturnBook(this.id)" style="margin-left:20px;"/>
                                            <input type="button" class="btn btn-link"  id="miss" name="sb" value="图书丢失" onclick="BookMiss(this.name)" style="margin-left:20px;margin-top:20px;"/>
							            </div>
							        </div><!-- /.modal-content -->
							    </div><!-- /.modal -->
							</div>
							<!-- start 还原按钮 value-->
									<script>
										$(function() {
										    $('#myModalReturn').on('hidden.bs.modal',
										    function() {
										    	if(document.getElementById('paymoney')){
										    	document.getElementById('paymoney').id='confirm';
										    	document.getElementById('paycancel').id='cancel';
										    	}
										    	$('#confirm').val("确认归还");
										    	$('#miss').show();
										    })
										});
								   </script>
						 <!--end 还原按钮 value -->
					</div>
                        <nav aria-label="Page navigation" style="abs">
                        <ul class="pagination">
                           
                            <li>
                             <c:choose>
                                <c:when test="${nowpage-1<0}">
                                 <a href="${ctx}/reader/borrowinfo/pageid?id=1" aria-label="Previous">
                                 <span aria-hidden="true">&laquo;</span>
                                 </a>
                                </c:when>
                                <c:otherwise>
                                 <a href="${ctx}/reader/borrowinfo/pageid?id=${nowpage-1}" aria-label="Previous">
                                 <span aria-hidden="true">&laquo;</span>
                                 </a>
                                </c:otherwise>
                             </c:choose>                            
                            
                            </li>
                               <c:choose>
                                   <c:when test="${endpage>8}">
                                     <c:choose>
	                                     <c:when test="${nowpage+2>7}"><!-- 选中代码整体后移Tab,前移动Shift+Tab -->
	                                         <c:choose>
	                                             <c:when test="${nowpage+2<endpage}">
			                                         <li><a href="${ctx}/reader/borrowinfo/pageid?id=${1}">1</a></li>
				                                     <li><a href="${ctx}/reader/borrowinfo/pageid?id=${2}">2</a></li>
				                                     <li class="disabled"><a href="#">...</a></li>
				                                     <li><a href="${ctx}/reader/borrowinfo/pageid?id=${nowpage-2}">${nowpage-2}</a></li>
				                                     <li><a href="${ctx}/reader/borrowinfo/pageid?id=${nowpage-1}">${nowpage-1}</a></li>
				                                     <li class="active"><a href="${ctx}/reader/bookinfo/pageid?id=${nowpage}">${nowpage}</a></li>		                                     
				                                     <li><a href="${ctx}/reader/borrowinfo/pageid?id=${nowpage+1}">${nowpage+1}</a></li>
				                                     <li><a href="${ctx}/reader/borrowinfo/pageid?id=${nowpage+2}">${nowpage+2}</a></li>
				                                     <li class="disabled"><a href="#">...</a></li>
	                                             </c:when>
	                                             <c:otherwise>
	                                                 <li><a href="${ctx}/reader/borrowinfo/pageid?id=${1}">1</a></li>
				                                     <li><a href="${ctx}/reader/borrowinfo/pageid?id=${2}">2</a></li>
				                                     <li class="disabled"><a href="#">...</a></li>
				                                     <c:forEach  var="i" begin="${nowpage-2}" end="${endpage}">
							                            <c:choose>
			                                               <c:when test="${nowpage == i}">
			                                                    <li class="active"><a href="${ctx}/reader/borrowinfo/pageid?id=${i}">${i}</a></li>
			                                               </c:when>
			                                               <c:otherwise>                                      
			                                                    <li><a href="${ctx}/reader/borrowinfo/pageid?id=${i}">${i}</a></li>
			                                               </c:otherwise>
			                                             </c:choose>
			                                         </c:forEach>				                                     
	                                             </c:otherwise>
	                                         </c:choose>                                                                     
		                                 </c:when>
		                                 <c:otherwise>
		                                     <c:forEach  var="i" begin="1" end="6">
	                                             <c:choose>
	                                               <c:when test="${nowpage == i}">
	                                                    <li class="active"><a href="${ctx}/reader/borrowinfo/pageid?id=${i}">${i}</a></li>
	                                               </c:when>
	                                               <c:otherwise>                                      
	                                                    <li><a href="${ctx}/reader/borrowinfo/pageid?id=${i}">${i}</a></li>
	                                               </c:otherwise>
	                                             </c:choose>
	                                         </c:forEach>	                                     
		                                 </c:otherwise>
		                              </c:choose>
                                   </c:when>
                                   <c:otherwise>
                                         <c:forEach  var="i" begin="1" end="${endpage}">
                                             <c:choose>
                                               <c:when test="${nowpage == i}">
                                                    <li class="active"><a href="${ctx}/reader/borrowinfo/pageid?id=${i}">${i}</a></li>
                                               </c:when>
                                               <c:otherwise>                                      
                                                    <li><a href="${ctx}/reader/borrowinfo/pageid?id=${i}">${i}</a></li>
                                               </c:otherwise>
                                             </c:choose>
                                         </c:forEach>
                                   </c:otherwise>
                                </c:choose>
                            <li>
                              <c:choose>
                                <c:when test="${nowpage+1>endpage}">
                                <a href="${ctx}/reader/borrowinfo/pageid?id=${endpage}" aria-label="Next">
                               <span aria-hidden="true">&raquo;</span>
                               </a>
                                </c:when>
                                <c:otherwise>
                                <a href="${ctx}/reader/borrowinfo/pageid?id=${nowpage+1}" aria-label="Next">
                               <span aria-hidden="true">&raquo;</span>
                               </a>
                                </c:otherwise>
                             </c:choose> 
                              <%-- <a href="${ctx}/reader/bookinfo/pageid?id=${nowpage+1}" aria-label="Next">
                               <span aria-hidden="true">&raquo;</span>
                               </a> --%>
                             </li>
                          </ul>
                       </nav>
                       <div class="demo" style="width:80px; margin:-60px auto 0 430px;">
 
                            <div class="input-group spinner" data-trigger="spinner" id="spinner">
                                <input type="text" id="pageid" class="form-control" value="1" data-max="${endpage}" data-min="1" data-step="1">
                                
                                <div class="input-group-addon">
                                    <a href="javascript:;" class="spin-up" data-spin="up"><i class="icon-sort-up"></i></a>
                                    <a href="javascript:;" class="spin-down" data-spin="down"><i class="icon-sort-down"></i></a>
                               </div>                         
                            </div> 
                            <div class="demo" style="width:80px; margin:-34px auto 0 90px;">
                                <input class="btn btn-default" type="button" value="跳转" id="Go" onclick="Goto()">
                            </div>  
                             <div class="demo" style="width:80px; margin:-20px auto 0 160px;">
                                   <span>第${nowpage}/${endpage}页</span>
                            </div>
                            <div class="demo" style="width:100px; margin:-20px auto 0 240px;">
                                   <span>总记录数:${total}条</span>
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
     <script src="${ctx}/static/js/reader/borrowinfo.js "></script>
     <script type="text/javascript" src="${ctx}/static/js/reader/returnbook.js"></script>
</html>