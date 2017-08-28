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
<style type="text/css">
	#fm{
		margin:0;
		padding:10px 30px;
	}
	.ftitle{
		font-size:14px;
		font-weight:bold;
		padding:5px 0;
		margin-bottom:10px;
		border-bottom:1px solid #CCC;
	}
	.fitem{
		margin-bottom:5px;
	}
	.fitem label
	{
		display:inline-block;
		width:80px;
	}
</style>
<script type="text/javascript">
	function edituser(){
		var row=$("#dg").datagrid("getSelected");
		if(row){
			id = row.id;
			readerName = row.readerName;
			phone = row.phone;
			email = row.email;
			$("#dlg").dialog("open").dialog('setTitle','修改读者信息');
			$("#fm").form("load",row);
		}
	}
	function saveuser(){
		$("#fm").form("submit",{
			url : ctx + "/admin/updateReader",
			onsubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				if(result=="111"){
					alert("操作成功");
					$("#dlg").dialog("close");
					$("#dg").datagrid("load");
				}
				else{
					alert("操作失败");
				}
			}
		});
	}
</script>
</head>
<body>
	<div style="margin:20px 0;"></div>
	
	<table id="dg"></table>
	<div id="toolbar">
		<a onClick="edituser()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>
 		<a onClick="MoveUp()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上移</a>
 		<a onClick="MoveDown()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下移</a>
	</div>
	
	<table id="dg"></table>
	<div style="margin:20px 0;"></div>
	<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px;"	
		closed="true" buttons="#dlg-buttons">
		<div class="ftitle">
		修改读者信息
		</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label>
					姓名
				</label>
				<input name="readerName" id="readerName" class="easyui-validatebox" required="true"/>
			</div>
			<div class="fitem">
				<label>
					电话
				</label>
				<input name="phone" id="phone" class="easyui-validatebox" required="true"/>
			</div>
			<div class="fitem">
				<label>
					邮箱
				</label>
				<input name="email" id="email" class="easyui-validatebox" required="true"/>
			</div>
			<input type="hidden" name="id" id="id"/>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveuser()"
		iconcls="icon-save">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg').dialog('close')"
		iconcls="icon-cancel">取消</a>
	</div>
	
	<script type="text/javascript" src="${ctx}/static/js/admin/users_back/users_back.js"></script>
</body>
</html>