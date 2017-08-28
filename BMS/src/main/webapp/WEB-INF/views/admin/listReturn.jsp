<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>后台用户管理</title>
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/easyui/demo/demo.css" />
<script type="text/javascript" src="${ctx}/static/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/static/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="http://www.w3cschool.cc/try/jeasyui/datagrid-detailview.js"></script>
</head>
<body>
	<div style="margin:20px 0;"></div>
	
	<table id="dg" style="width:700px;height:250px"
					
					title="查看读者归还记录"
					singleSelect="true" fitColumns="true">
		<thead>
			<tr>
				<th field="id" width=100>读者编号</th>
				<th field="userId" width=100>userId</th>
				<th field="readerName" width=100>读者姓名</th>
				<th field="sex" width=100>读者性别</th>
				<th field="phone" width=100>读者电话</th>
				<th field="email" width=100>读者邮箱</th>
			</tr>
		</thead>
	
	</table>
	<div style="margin:20px 0;"></div>
		
	<script type="text/javascript" src="${ctx}/static/js/admin/listReturn/listReturn.js"></script>
</body>
</html>