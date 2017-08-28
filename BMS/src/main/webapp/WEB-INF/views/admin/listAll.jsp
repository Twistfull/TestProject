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
<script type="text/javascript" src="${ctx}/static/js/admin/js/easy-ui/datagrid-filter.js"></script>

</head>
<body>
	<div style="margin:20px 0;"></div>

	<table id="dg"></table>
	<div id="toolbar">
		
 		<a onClick="deleteById()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
 		<a onClick="MoveUp()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上移</a>
 		<a onClick="MoveDown()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下移</a>
	</div>
	
	<table id="dg"></table>
	<div style="margin:20px 0;"></div>
		
	<script type="text/javascript" src="${ctx}/static/js/admin/listAll/listAll.js"></script>
</body>
</html>