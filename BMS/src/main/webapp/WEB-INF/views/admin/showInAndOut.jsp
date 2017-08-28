<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="http://apps.bdimg.com/libs/jquery/1.11.1/jquery.js"></script>
<script type="text/javascript" src="${ctx}/static/js/admin/js/echarts/echarts.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="main" style="width:600px;height:400px;"></div>
	<script type="text/javascript">
	 $(document).ready(function(){
				$.ajax({
					type:"POST",
					url:ctx+"/admin/findInAndOut",
					dataType:"json",
					success:function(result){
						var data=$.parseJSON(result);
						if(data.success)
						{
							var myChart=echarts.init(document.getElementById('main'));
							myChart.setOption({
								title:{
									text:'近几日图书流动'
								},
								tooltip:{
									trigger:'axis',
									axisPointer:{
										type:'cross',
										crossStyle:{
											color:'#999'
										}
									}
								},
								toolbox:{
									feature:{
										dataView:{show:true,readOnly:false},
										magicType:{show:true,type:['bar']},
										restore:{show:true},
										saveAsImage:{show:true}
									}
								},
								legend:{
									data:['借出','归还']
								},
								xAxis:{
									type:'category',
									data:[data.day0,data.day1,data.day2,data.day3],
									axisPointer:{
										type:'shadow'
									}
								},
								yAxis:{
									type:'value',
									name:'图书量',
									min:0,
									max:10,
									interval:2,
									axisLabel:{
										formatter:'{value} 本'
									}
								},
								series:[{
									name:'借出',
									type:'bar',
									data:[data.day0Out,data.day1Out,data.day2Out,data.day3Out]
								},
								{
									name:'归还',
									type:'bar',
									data:[data.day0In,data.day1In,data.day2In,data.day3In,]
								}
								]
							});
						}else{
							alert("failed");
						}
					},
					error:function(jqXHR){
						alert("发生错误:"+jqXHR.status);
					}
				});
			})
	</script>
</body>
</html>