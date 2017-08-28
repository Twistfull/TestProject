
Date.prototype.Format = function(fmt)   //日期转换方法
	{ //author: meizz   
	  var o = {   
	    "M+" : this.getMonth()+1,                 //月份   
	    "d+" : this.getDate(),                    //日   
	    "h+" : this.getHours(),                   //小时   
	    "m+" : this.getMinutes(),                 //分   
	    "s+" : this.getSeconds(),                 //秒   
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
	    "S"  : this.getMilliseconds()             //毫秒   
	  };   
	  if(/(y+)/.test(fmt))   
	    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
	  for(var k in o)   
	    if(new RegExp("("+ k +")").test(fmt))   
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	  return fmt;   
	}  

function productReturnInfo(parm) {  
	    var _json = jQuery.param({ "recordId": parm });  
	    var request = $.ajax({  
	        url:ctx+"/reader/productreturn/recordid", 
	        type: "POST",  
	        async: true,  
	        data: _json, //不能直接写成 {id:"123",code:"tomcat"}  
	        dataType: "json",  
	        // contentType: "charset=utf-8",  
	        cache: false,  
	        success: function (result) {  
		       if (result &&result.statusCode==1&& result.message){	
		    	   /* start 动态生成模态框主体部分的图书归还信息*/
		    	   document.getElementById("overdaytipdetail").innerHTML=" ";
		    	   var ul=document.createElement('ul');
		    	   ul.id="ulid"
		    	   ul.className="list-unstyled";
		    	   document.getElementById("overdaytipdetail").appendChild(ul);
		    	   //document.getElementById("color").appendChild(span);
		    	   //var p1=document.createElement('p');
		    	  // p1.className="sub-header";
		    	   //document.getElementById("ulid").appendChild(p1);		    	   
				       var li1=document.createElement('li');
				       li1.style.padding="0px 0px 0px 20px";
				       document.getElementById("ulid").appendChild(li1);
				       	   var p2=document.createElement('p');
					       p2.className="sub-header";
				    	   document.getElementById("ulid").appendChild(p2);
				       var li2=document.createElement('li');
				       li2.style.padding="0px 0px 0px 20px";
				       document.getElementById("ulid").appendChild(li2);
					       var p3=document.createElement('p');					       
					       p3.className="sub-header";
				    	   document.getElementById("ulid").appendChild(p3);
				       var li3=document.createElement('li');
				       li3.style.padding="0px 0px 0px 20px";
				       document.getElementById("ulid").appendChild(li3);
					       var p4=document.createElement('p');
					       p4.className="sub-header";
				    	   document.getElementById("ulid").appendChild(p4);
				       var li4=document.createElement('li');
				       li4.style.padding="0px 0px 0px 20px";
				       document.getElementById("ulid").appendChild(li4);
					      
					     
	                   li1.appendChild(document.createTextNode("借阅人:  "+result.data.username));
	                   li2.appendChild(document.createTextNode("借阅书籍:  "+result.data.returns.borrowInfo.bookInfo.bookName));
	                   var time1 = new Date(result.data.returns.borrowInfo.endDate).Format("yyyy-MM-dd");
	                   var time2 = new Date(result.data.returns.returnDate).Format("yyyy-MM-dd");
	                   li3.appendChild(document.createTextNode("限定日期:  "+time1));
	                   li4.appendChild(document.createTextNode("归还日期:  "+time2));
	                   if(result.data.returns.payFor<=0){
		                	   var p5=document.createElement('p');
						       p5.className="sub-header";
					    	   document.getElementById("ulid").appendChild(p5);
					       var li5=document.createElement('li');
					       li5.style.padding="0px 0px 0px 20px";
					       document.getElementById("ulid").appendChild(li5);
		                   li5.appendChild(document.createTextNode("处于限定时间内归还!"));
	                   }else{
		                	   var p6=document.createElement('p');
						       p6.className="sub-header";
					    	   document.getElementById("ulid").appendChild(p6);
					       var li6=document.createElement('li');
					       li6.style.padding="0px 0px 0px 20px";
					       document.getElementById("ulid").appendChild(li6);
					       li6.appendChild(document.createTextNode("逾期天数:  "+result.data.overdueDay+"  天"));
						       var p7=document.createElement('p');
						       p7.className="sub-header";
					    	   document.getElementById("ulid").appendChild(p7);
					       var li7=document.createElement('li');
					       li7.style.padding="0px 0px 0px 20px";
					       document.getElementById("ulid").appendChild(li7);
					       li7.appendChild(document.createTextNode("罚款金额:  "+result.data.returns.payFor+"  元"));
	                	   
	                   }
	                   $("#miss").attr('name',result.data.returns.borrowInfo.bookInfo.bookPrice);//给id为miss的标签改变name数值
	                   //$('input[name="sb"]')
	                   //document.getElementById("miss").name(result.data.returns.borrowInfo.bookInfo.bookPrice);
	                  /* end 动态生成模态框主题部分的图书归还信息*/
	                    /*window.onload = function() {
	                	   $('miss').onclick= function() { BookMiss(result.data.returns.borrowInfo.bookInfo.bookPrice) }; 
	                	   }*/

	                      /* var input=document.createElement('input');
	                       input.id="miss";
	                       input.className="btn btn-link";
	                       input.type="button";
	                       input.name="back";
	                       input.value="图书丢失";
	                       input.style.margin="20px 0px 0px 20px";
	                       document.getElementById("inputlink").appendChild(input);
	                       input.onclick=BookMiss(result.data.returns.borrowInfo.bookInfo.bookPrice);*/
	                  var str="<input type=\"button\" class=\"btn btn-link\"id=\"miss\" name=\"back\" value=\"图书丢失\" onclick=\"BookMiss(${returns.borrowInfo.bookInfo.bookPrice})\" style=\"margin-left:20px;margin-top:20px;\"\/>"
		        }else{
		    }
	      },
	
	  }); 

	 
}


function ReturnBook(parm) {  
    var _json = jQuery.param({ "operation": parm });  
    var request = $.ajax({  
        url: ctx + "/reader/returnbook", 
        type: "POST",  
        async: false,  
        data: _json, //不能直接写成 {id:"123",code:"tomcat"}  
        dataType: "json",  
        // contentType: "charset=utf-8",  
        cache: false,  
        success: function (result) {  
           if (result &&result.statusCode==1&& result.message){
	    	   $('#showsuccessreturn').show();
		       setTimeout(function(){window.location.reload();},1000);//刷新当前页面
	    	  /*document.getElementById("returndetail").innerHTML=" ";
	    	  $('#confirm').hide();
	    	  $('#cancel').hide();
	    	  $('#miss').hide();
	    	  document.getElementById("successtip").style.color="green";
       		  document.getElementById("successtip").innerHTML="归还成功!";
       		  setTimeout(function(){window.location.href=document.referrer;},2000);//document.referrer获取前一页url
*/	    	   
	    	  }else if(result &&result.statusCode==2&& result.message){
	    	    //  window.history.go(-1) ;  	   //由于有2个返回不能简单调用返回前一页,数据库端做一次判断
             }else if(result &&result.statusCode==3&& result.message){
	            $('#showsuccesspayfor').show();
	            setTimeout(function(){window.location.reload();},1000);//刷新当前页面
	         /*document.getElementById("returndetail").innerHTML=" ";
	         $('#paymoney').hide();
	         $('#paycancel').hide();         
	         document.getElementById("successtip").style.color="green";
		     document.getElementById("successtip").innerHTML="已支付!成功处理这条归还记录!";
		     setTimeout(function(){window.location.href=document.referrer;},2000);//document.referrer获取前一页url	              	           
*/	         }else{
	          
	         window.location.href = ctx + "/reader/disallowborrow";//错误
	    }
     },
    });   
}

function BookMiss(parm) {
	
	    	  document.getElementById("overdaytipdetail").innerHTML=" ";
	    	 // document.getElementById('successtip').innerHTML='赔偿信息';
	    	  $('#confirm').val("确认赔偿");
	    	  $('#miss').hide();
	    	  document.getElementById('confirm').id='paymoney';
	    	  document.getElementById('cancel').id='paycancel';
	    	 // var div=document.createElement('div');
	    	 // document.getElementById("changediv").appendChild(div);
	    	  //div.id="returndetail";
	    	  //div.ClassName="media-body";
	    	  var h3=document.createElement('h3');
	    	  var h4=document.createElement('h3');
	    	  h4.id="color";
	    	  var span=document.createElement('span');
	    	  span.id="price";
	    	  document.getElementById("overdaytipdetail").appendChild(h3);
	    	  h3.appendChild(document.createTextNode("由于您丢失了图书,很抱歉您需要照价赔偿"));
	    	  document.getElementById("overdaytipdetail").appendChild(h4);	    	  
	    	  h4.appendChild(document.createTextNode("这本书的价格为:"));
	    	  document.getElementById("color").appendChild(span);
	    	  span.appendChild(document.createTextNode(parm+"元"));
	    	  document.getElementById("price").style.color="red";
	    	  //document.getElementById("successtip").style.color="green";
	   		  //document.getElementById("successtip").innerHTML="借阅成功!";
	   		  //setTimeout(function(){window.location.href=document.referrer;},2000);
		    	   
}
