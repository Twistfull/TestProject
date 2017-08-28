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
        <script type="text/javascript" src="${ctx}/static/js/reader/bookinfo.js "></script>
        <script type="text/javascript" src="${ctx}/static/js/reader/bookinfoborrow.js"></script>
        <style>
		    #myModal
		    {
		        top:100px;
		    }
		    
		    #myModalBorrow
		    {
		        top:100px;
		    }
		     #ModalDanger
		    {
		        top:80px;
		    }
		    
		   /* .modal-backdrop { 将模态框背景阴影去除
			  opacity: 0 !important;
              filter: alpha(opacity=0) !important;
			} */
		</style>
  <script type="text/javascript">
   
   
   /* $(document).ready(function() {
    // 通过该方法来为每次弹出的模态框设置最新的zIndex值，从而使最新的modal显示在最前面
    $(document).on('show.bs.modal', '.modal', function() {
        var zIndex = 1040 + (10 * $('.modal:visible').length);
        $(this).css('z-index', zIndex);
        alert("sb");
        setTimeout(function() {
            $('.modal-backdrop').not('.modal-stack').css('z-index', zIndex - 1).addClass('modal-stack');
        }, 0);
    });
   }); */

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
					<form class="navbar-form navbar-right">
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
                          </div><!-- /btn-group -->
						  <input type="text" class="form-control" id="selectcontent" placeholder="检索内容...">
						</div><!-- /input-group -->
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
						<li class="active">
							<a href="${ctx}/reader/bookinfo/select?bookName=">图书信息</a>
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
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				  <!--start  弹出提示框 -->
				   <div id="showsuccessborrow" class="alert alert-success alert-dismissible" role="alert"  style="display:none">
                      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                       <strong>借阅成功!</strong>  恭喜你成功借阅，请注意归还时间，及时归还哦!
                   </div>
                   <div id="showdangerborrow" class="alert alert-danger alert-dismissible" role="alert"  style="display:none">
                      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                       <strong>借阅失败!</strong>  你的未还书籍或者逾期书籍的数量已超过限制不能继续借阅!
                       <a href="#" data-toggle="modal" data-target="#ModalDanger"  aria-label="Borrow" >查看详情</a>                      
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
				   <h2 class="sub-header ">图书信息</h2>										
                    	<div class="table-responsive " style="overflow:scroll;height:360px;">	
						<table class="table table-striped ">
							<thead >
								<tr>
								    <!-- <th>编号</th> -->
									<th>书籍名称</th>
									<th>作者</th>
									<th>书籍类型</th>
									<th>出版日期</th>
									<th>详情</th>
									<th>操作</th>
								</tr>
							</thead>										         					
							<tbody >
							  <%-- <c:set var="i" value="0"></c:set> --%>							    
							    
							    <c:forEach items="${requestScope.list }" var="book" varStatus="id" >							       
							        <tr>	
							       <%--  <% i=i+1; %>
							        <%=i %>						      
							        <td><%=(s-1)*8+1%></td> --%>
									<td>${book.bookName}</td>
									<td>${book.bookAuthor}</td>
									<td>${book.bookKind}</td>
									<td>
										<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- 格式化日期 -->
										<fmt:formatDate value="${book.publDate}" pattern="yyyy-MM-dd"/>
									</td>
									<td><a href="${ctx}/reader/bookinfo/bookid?id=${book.bookId}"  data-toggle="modal" data-target="#myModal" aria-label="Detail">详情</a>
									 <!-- <button class="btn btn-link" data-toggle="modal" data-target="#myModal">开始演示模态框</button> -->								
									</td>
									<c:choose>
									    <c:when test="${book.bookStatus=='外借'||book.bookStatus=='丢失'}">
									        <td>不在架</td>
									    </c:when>
									    <c:otherwise>
									        <td><a href="#" data-toggle="modal" data-target="#myModalBorrow"  aria-label="Borrow" onclick="productBorrowInfo('${book.bookId}')">借阅</a></td>
									    </c:otherwise>									    
									</c:choose>
								  </tr>
							    
							    </c:forEach>
							    <!-- 模态框（Modal） 显示书籍详细信息-->
									<div class="modal fade" id="myModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									    <div class="modal-dialog">
									        <div class="modal-content">
									            <div class="modal-header">
									                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									                <h4 class="modal-title" id="myModalLabel">详细信息</h4>
									            </div>
									            <div class="modal-body" >在这里添加一些文本</div>
									            <div class="modal-footer">
									                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									                <button type="button" class="btn btn-primary">提交更改</button>
									            </div>
									        </div><!-- /.modal-content -->
									    </div><!-- /.modal -->
									</div>
								<script> /* 在模态框完全对用户隐藏后清空模态框数据	 */								    
										$(function() {
										    $('#myModal').on('hidden.bs.modal',
										    function() {
										    	 $(this).removeData("bs.modal"); 
										    	  /*modal页面加载$()错误,由于移除缓存时加载到<span style="color: rgb(51, 51, 255);"><div class="modal-content"></div></span>未移除的数据，手动移除加载的内容*/
										    	 // $(this).find(".modal fade").children().remove();  

										    	//var sb=$("#bookbookId").val();
										    	//alert("xxx:"+sb);
										    	//$('#myModal').removeData('bs.modal');
										    	//document.getElementById("myModalbody").innerHTML = "";
										    	// $(this).removeData("bs.modal");
									     })
										}); 
								   </script>
									  <!-- 模态框（Modal） 显示书籍借阅信息( data-backdrop="static" 用户点击模态框外不关闭)-->
									<div class="modal fade" id="myModalBorrow" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"   data-backdrop="static" 
									data-backdrop="true"  data-keyboard="false">
									    <div class="modal-dialog">
									        <div class="modal-content">
									            <div class="modal-header">
									                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="cancel" name="back"  onclick="AddBorrow('cancel')">&times;</button>
									                <h4 class="modal-title" id="myModalLabel">借阅信息</h4>
									            </div>
									            <div class="modal-body"><!-- 模态框主体部分 -->
									                <div class="media-body" id="borrowdetail">	                                   
					                                   <!-- <h3 class="media-heading">详细信息</h3> -->
					                                   <p class="sub-header"></p>
					                                   <ul class="list-unstyled">
					                                       <li id="borrowusername">借阅人:&nbsp;&nbsp;${username}</li>
						                                    <p class="sub-header"></p>
						                                   <li id="borrowbookName">借阅书籍:&nbsp;&nbsp;${borrow.bookName}</li>
						                                   <%--   <p class="sub-header"></p>
						                                   <li id="borrowbookDate">借阅日期:&nbsp;&nbsp; 
						                                   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt1"%><!-- 格式化日期 -->
														     <fmt1:formatDate id="teststart" value="${borrow.startDate}" pattern="yyyy-MM-dd"/>
						                                   </li>
						                                     <p class="sub-header"></p>
						                                   <li id="returnbookDate">归还日期:&nbsp;&nbsp;
						                                   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt2"%><!-- 格式化日期,注意value里不要有空格 -->
														     <fmt2:formatDate id="testend" value="${borrow.endDate}" pattern="yyyy-MM-dd"/>
						                                   </li> --%>
						                                     <p class="sub-header"></p>		                                   
						                                   <li>小提示:&nbsp;&nbsp;在借书籍不能超过8本,逾期未还书籍不能超过3本，否则不予借阅。
						                                    
						                                   </li>		                                  
						                                     <p class="sub-header"></p>
					                                   </ul>
					                                 </div>
                                                 
                                                </div>
									            <div class="modal-footer">					                
									                <button type="button" class="btn btn-primary" data-dismiss="modal" id="confirm" name="back"  onclick="AddBorrow('confirm')">确认借阅</button>
									                <button type="button" class="btn btn-primary" data-dismiss="modal" id="cancel" name="back"  onclick="AddBorrow('cancel')">取消</button>
									            </div>
									        </div><!-- /.modal-content -->
									    </div><!-- /.modal -->
									</div>
									
									
									 <!-- 模态框（Modal） 显示不允许借阅情况信息-->
									<div class="modal fade" id="ModalDanger" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									    <div class="modal-dialog">
									        <div class="modal-content">
									            <div class="modal-header">
									                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									                <h4 class="modal-title" id="myModalLabel">警告信息</h4>
									            </div>
									            <div class="modal-body">
									                <div class="media-body" id="dangerdetail">	                                   
					                                  
					                                 </div>
									            </div>
									            <div class="modal-footer">
									                     <button type="button" class="btn btn-primary" onclick="gotoreturn()">去归还</button>							                    
									               <!--  <button type="button" class="btn btn-primary">提交更改</button> -->
									            </div>
									        </div><!-- /.modal-content -->
									    </div><!-- /.modal -->
									</div>
									<!-- start 在打开提示信息是，关闭警告框 -->
									<script>
										$(function() {
										    $('#ModalDanger').on('show.bs.modal',
										    function() {
										    	$('#showdangerborrow').hide();
										    })
										});
								   </script>
								   <!--end 在打开提示信息是，关闭警告框 -->
							<!-- 	<tr>
									<td>1,001</td>
									<td>Java从入门到退坑</td>
									<td>2017070100001</td>
									<td>2017/07/01</td>
									<td>2017/07/23</td>
								</tr> -->														
							</tbody>
						</table>
					</div>
                        <nav aria-label="Page navigation" style="abs">
                        <ul class="pagination">
                           
                            <li>
                             <c:choose>
                                <c:when test="${nowpage-1<0}">
                                 <a href="${ctx}/reader/bookinfo/pageid?id=1" aria-label="Previous">
                                 <span aria-hidden="true">&laquo;</span>
                                 </a>
                                </c:when>
                                <c:otherwise>
                                 <a href="${ctx}/reader/bookinfo/pageid?id=${nowpage-1}" aria-label="Previous">
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
			                                         <li><a href="${ctx}/reader/bookinfo/pageid?id=${1}">1</a></li>
				                                     <li><a href="${ctx}/reader/bookinfo/pageid?id=${2}">2</a></li>
				                                     <li class="disabled"><a href="#">...</a></li>
				                                     <li><a href="${ctx}/reader/bookinfo/pageid?id=${nowpage-2}">${nowpage-2}</a></li>
				                                     <li><a href="${ctx}/reader/bookinfo/pageid?id=${nowpage-1}">${nowpage-1}</a></li>
				                                     <li class="active"><a href="${ctx}/reader/bookinfo/pageid?id=${nowpage}">${nowpage}</a></li>		                                     
				                                     <li><a href="${ctx}/reader/bookinfo/pageid?id=${nowpage+1}">${nowpage+1}</a></li>
				                                     <li><a href="${ctx}/reader/bookinfo/pageid?id=${nowpage+2}">${nowpage+2}</a></li>
				                                     <li class="disabled"><a href="#">...</a></li>
	                                             </c:when>
	                                             <c:otherwise>
	                                                 <li><a href="${ctx}/reader/bookinfo/pageid?id=${1}">1</a></li>
				                                     <li><a href="${ctx}/reader/bookinfo/pageid?id=${2}">2</a></li>
				                                     <li class="disabled"><a href="#">...</a></li>
				                                     <c:forEach  var="i" begin="${nowpage-2}" end="${endpage}">
							                            <c:choose>
			                                               <c:when test="${nowpage == i}">
			                                                    <li class="active"><a href="${ctx}/reader/bookinfo/pageid?id=${i}">${i}</a></li>
			                                               </c:when>
			                                               <c:otherwise>                                      
			                                                    <li><a href="${ctx}/reader/bookinfo/pageid?id=${i}">${i}</a></li>
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
	                                                    <li class="active"><a href="${ctx}/reader/bookinfo/pageid?id=${i}">${i}</a></li>
	                                               </c:when>
	                                               <c:otherwise>                                      
	                                                    <li><a href="${ctx}/reader/bookinfo/pageid?id=${i}">${i}</a></li>
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
                                                    <li class="active"><a href="${ctx}/reader/bookinfo/pageid?id=${i}">${i}</a></li>
                                               </c:when>
                                               <c:otherwise>                                      
                                                    <li><a href="${ctx}/reader/bookinfo/pageid?id=${i}">${i}</a></li>
                                               </c:otherwise>
                                             </c:choose>
                                         </c:forEach>
                                   </c:otherwise>
                                </c:choose>
                            <li>
                              <c:choose>
                                <c:when test="${nowpage+1>endpage}">
                                <a href="${ctx}/reader/bookinfo/pageid?id=${endpage}" aria-label="Next">
                               <span aria-hidden="true">&raquo;</span>
                               </a>
                                </c:when>
                                <c:otherwise>
                                <a href="${ctx}/reader/bookinfo/pageid?id=${nowpage+1}" aria-label="Next">
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
		<!-- 隐藏，既在关闭模态框时触发事件   $(function(){}) 是 $(document).ready(function(){}) 的简写 -->	 

	</body>

</html>