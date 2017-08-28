<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<head>
	<title>添加图书</title>
	<link rel="stylesheet" type="text/css" href="${ctx}/static/css/admin/css/easy-ui/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/static/css/admin/css/easy-ui/icon.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/static/css/admin/css/easy-ui/demo.css">
	<script type="text/javascript" src="${ctx}/static/js/admin/js/easy-ui/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/admin/js/easy-ui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/admin/bookinfo/bookadd.js"></script>
	 
</head>
<body>
	<h2>添加图书</h2>
	<p id="flag" style="color:black">添加新入库的图书信息。</p>
	<div class="easyui-panel"  style="width:400px; title="" position:absolute ;left:200px;">
		<div style="padding:10px 60px 20px 60px;">
	    <form id="ff" method="post">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>书名：</td>
	    			<td><input class="easyui-textbox" type="text" name="bookName" data-options="required:true,missingMessage:'书名必须填写！'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>作者：</td>
	    			<td><input class="easyui-textbox" type="text" name="bookAuthor" data-options="required:true,missingMessage:'作者不能为空！'"></input></td>
	    		</tr>	    		
                <tr>
	    			<td>价格：</td>
	    			<td><input class="easyui-textbox" type="text" name="bookPrice" data-options="required:true,validType:'price'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>入库日期:</td>
                    <td><input class="easyui-datebox" id="strogeDate" name="storageDate" data-options="formatter:myformatter,parser:myparser,required:true"></input></td>
	    		</tr>
                
                <tr>
	    			<td>出版日期:</td>
	    			<td><input class="easyui-datebox" id="publDate" name="publDate" data-options="formatter:myformatter,parser:myparser,validType:'compareDate',required:true"></input></td>
	    		</tr>
                
                <tr>
	    			<td>出版社:</td>
	    			<td><select class="easyui-combobox" name="bookPubl" style="width:170px">
                    <option >北京大学出版社</option>
                    <option >人民文学出版社</option>
                    <option >上海译文出版社</option>
                    <option  selected="selected">中国人民大学出版社</option>
                    <option >高等教育出版社</option>
                    <option >中华书局</option>
                    
                    </select>
	    			</td>
	    		</tr>
                
                <tr>
	    			<td>在架位置：</td>
	    			<td><select class="easyui-combobox" name="bookAddress" style="width:170px">
                    <option >A区13号</option>
                    <option >B区7号</option>
                    <option >C区21号</option>
                    <option  selected="selected">D区1号</option>
                    <option >E区8号</option>
                    <option >F区10号</option>
                    
                    </select>
	    			</td>
	    		</tr>
                <tr>
	    			<td>图书类型:</td>
	    			<td><select class="easyui-combobox" name="bookKind">
                    <option value="A">马列主义毛邓思想</option>
                    <option value="B">哲学</option>
                    <option value="C">社会科学总论</option>
                    <option value="D">政治、法律</option>
                    <option value="E">军事</option>
                    <option value="F">经济</option>
                    <option value="G" selected="selected">文化、科学、教育、体育</option>
                    <option value="H">语言、文字</option>
                    <option value="I">文学</option>
                    <option value="J">艺术</option>
                    <option value="K">历史、地理</option>
                    <option value="N">自然科学总论</option>
                    <option value="O">数理科学和化学</option>
                    <option value="P">天文学、地球科学</option>
                    <option value="Q">生物科学</option>
                    <option value="R">医药、卫生</option>
                    <option value="S">农业科学</option>
                    <option value="T">工业技术</option>
                    <option value="U">交通运输</option>
                    <option value="V">航空、航天</option>
                    <option value="X">环境科学、安全科学</option>
                    <option value="Z">综合性图书</option>                    
                    </select>
	    			</td>
	    		</tr>
                
                 <tr>
	    			<td>图书简介:</td>
	    			<td><input class="easyui-textbox" name="bookIntro" data-options="multiline:true" style="height:60px; width:170px"></input></td>
	    		</tr>
                

	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清空</a>
	    </div>
	    </div>
	</div>
<%--  <jsp:include page="/WEB-INF/views/common/include_javascript.jsp"/>	 --%>

<!-- 	<script>
	   function submitForm(){
		$('#ff').form('submit',{
			onSubmit:function(){
				return $(this).form('enableValidation').form('validate');
			}
		});
	   }
		function clearForm(){
			$('#ff').form('clear');
		}
	</script> -->
</body>

</html>