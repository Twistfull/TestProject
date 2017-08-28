
function Goto() {
	window.location.href = ctx + "/reader/borrowinfo/pageid?id="+$('#pageid').val();
}
//控制bootstrap日期格式start

/*$('.form_date').datetimepicker({
    language:  'zh-CN',
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	minView: 2,
	forceParse: 0,
});*/


//end

//控制easy-ui日期格式start
function myformatter(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
function myparser(s){
	if (!s) return new Date();
	var ss = (s.split('-'));
	var y = parseInt(ss[0],10);
	var m = parseInt(ss[1],10);
	var d = parseInt(ss[2],10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		return new Date(y,m-1,d);
	} else {
		return new Date();
	}
}
//end
function select() {
	//var _jsons=$('#woqunimalgb').serialize();
	var bookName=$('#bookName').val();
    var startDate=$('#startDate').val();
	var endDate=$('#endDate').val();
	var _json = jQuery.param({ "bookInfo.bookName":bookName ,"startDate":startDate,"endDate":endDate}); 
	window.location.href=ctx + "/reader/borrowinfo/select?"+_json;
	//_json.action=ctx + "/reader/borrowinfo/select";
	//_json.submit();
	//var testform=document.getElementById("woqunimalgb");
	//alert(testform);
	//testform.action=ctx + "/reader/borrowinfo/select";
	//testform.submit();

	//var bookName=$('#bookName').val();
	//var startDate=$('#startDate').val();
	//var endDate=$('#endDate').val();
	//var _json = jQuery.param({ "bookName":bookName ,"startDate":startDate,"endDate":endDate});  
	//alert(_jsons);
	/*$.ajax({
		    url: ctx + "/reader/borrowinfo/select", 
		    type: "POST",  
		    async: true,  
		    data:_jsons,// form 
*/		    //dataType: "json",  
			//success: function(data) {
			     // $("#commonLayout_appcreshi").parent().html(data);
			//    },
	      // error:function(data){
			             //        alert('errr');
			             //    }
//			});
	        
	//修改tomcat的server.xml文件： <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8" useBodyEncodingForURI="true"/> 

	//由于Get这样传参中文会乱码
	//window.location.href = ctx + "/reader/bookinfo/select?"+term+"="+$('#selectcontent').val();
}