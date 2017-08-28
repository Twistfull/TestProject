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
	<div id="toolbar">
	</div>
	
	<table id="dg"></table>
	<div style="margin:20px 0;"></div>
		
	<script type="text/javascript" src="${ctx}/static/js/admin/listBorrow/listBorrow.js"></script>
</body>
</html>