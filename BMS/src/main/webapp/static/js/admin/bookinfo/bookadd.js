             $.extend($.fn.validatebox.defaults.rules,
              {  
                  // 验证中文
              CHS : {
                     validator : function(value) {
                     return /^[\u0391-\uFFE5]+$/.test(value);},
                      message : "只能输入汉字"
                     },
                //验证数字
			 number: {
                    validator: function (value, param) {
                    return /^\d+$/.test(value);},
                      message: '请输入大于等于0的数字'
					 },
				//验证价格
			  price: {
                    validator: function (value, param) {
                    return /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/.test(value);},
                      message: '请输入正确的价格:0.00'
					 },
			   //start 比较时间
			compareDate: {
                    validator: function (value, param) {
                    Time1= $("#strogeDate").datebox('getValue');
			//		Time2= $("#pushdate").datebox('getValue'); 获取不到，可以用value 直接取到当前value
			//		var d1 = $.fn.datebox.defaults.parser(Time1); 
            //      var d2 = $.fn.datebox.defaults.parser(Time2); 
             //       return d2>d1; 
                    return dateCompare( Time1,value); //注意easyui 时间控制获取值的方式
                    },
                     message: '还未出版的书不能入库哦'
                    }
			 })		 
		    function dateCompare(startdate, enddate) {
              var arr = startdate.split("-");
			//  document.write(arr+"<br/>")
              var starttime = new Date(arr);
			 // document.write(starttime+"<br/>")
              var starttimes = starttime.getTime();
              var arrs = enddate.split("-");
			 // document.write(arrs+"<br/>")
              var lktime = new Date(arrs);
			 // document.write(lktime+"<br/>")
              var lktimes = lktime.getTime();
              if (starttimes > lktimes) {
				  return true;
			  }
               else
			      return false;
			}
			//end 比较时间
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
		   function submitForm(){
			$('#ff').form('submit',{
				url: ctx + "/admin/addBookAction",
				dataType:"json",
				onSubmit:function(){
					return $(this).form('enableValidation').form('validate');
				},
                success: function (data) {
                	var obj=$.parseJSON(data);
                	if (obj.statusCode==1) 
                	{
                		alert(obj.message);
                		document.getElementById("flag").style.color="green";
                		document.getElementById("flag").innerHTML="添加成功!";
                		setTimeout(function()
                				{
                					document.getElementById("flag").style.color="black";
                					document.getElementById("flag").innerHTML="添加新入库的图书信息。";},2000);
                	}
					else
					{
						alert(data.message);
						document.getElementById("flag").style.color="red";
            			document.getElementById("flag").innerHTML="添加失败!";
            			setTimeout(function()
            			{document.getElementById("flag").style.color="black";
            			document.getElementById("flag").innerHTML="添加新入库的图书信息。";},2000);          		       
				   }
                }

            });
        }


function clearForm(){
	$('#ff').form('clear');
}

