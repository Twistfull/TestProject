
function AddBorrow(parm) {  
    var _json = jQuery.param({ "operation": parm });  
    var request = $.ajax({  
        url: ctx + "/reader/addborrow", 
        type: "POST",  
        async: false,  
        data: _json, //不能直接写成 {id:"123",code:"tomcat"}  
        dataType: "json",  
        // contentType: "charset=utf-8",  
        cache: false,  
        success: function (result) {  
	       if (result &&result.statusCode==1&& result.message){	    	   
	    	  document.getElementById("borrowdetail").innerHTML=" ";
	    	  $('#confirm').hide();
	    	  $('#cancel').hide();
	    	  document.getElementById("successtip").style.color="green";
       		  document.getElementById("successtip").innerHTML="借阅成功!";
       		  setTimeout(function(){window.location.href=document.referrer;},2000);//document.referrer获取前一页url
	    	   
	    	  }
	       else if(result &&result.statusCode==2&& result.message){
	    	   window.history.go(-1) ;  	   
        }else if(result &&result.statusCode==3&& result.message){
	          
	          document.getElementById("borrowdetail").innerHTML=" ";
	          document.getElementById('successtip').innerHTML='警告信息';
	          $('#confirm').hide();
	          // $('#confirm').val("确认赔偿");
	          //$('#miss').hide();
			 // document.getElementById('confirm').id='paymoney';
			 // document.getElementById('cancel').id='paycancel';
			  var div=document.createElement('div');//创建一个div
			  document.getElementById("changediv").appendChild(div);//把div放在id为changdiv的div里
			  div.id="borrowdetail";//定义创建div的id
			  div.ClassName="media-body";
			  var h3=document.createElement('h3');
			  var hc=document.createElement('h4');
			  var h4=document.createElement('h4');
			  h4.id="color";
			  var span=document.createElement('span');
			  span.id="price";
			  document.getElementById("borrowdetail").appendChild(h3);
			  h3.appendChild(document.createTextNode("很抱歉您不能借阅!您需要先处理归还!"));
			  document.getElementById("borrowdetail").appendChild(hc);
			  hc.appendChild(document.createTextNode("您未归还(不超过8本)，或者逾期(不超过三本)的书籍数量超过了规定!"));
			  document.getElementById("borrowdetail").appendChild(h4);	    	  
			  h4.appendChild(document.createTextNode("你的借阅数量和逾期数量分别为:"));
			  document.getElementById("color").appendChild(span);
			  span.appendChild(document.createTextNode(result.data.countborrow+"本和"+result.data.countoverdue+"本"));
			  document.getElementById("price").style.color="red";
	          result
	        
	    }else{
	    	  window.location.href = ctx + "/reader/disallowborrow";
	    }
},
    });   
}