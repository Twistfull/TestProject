
/*$('#myModal').on('hidden.bs.modal', function () {
         $(this).removeData("bs.modal");
         $("#myModal").empty();
       //  $("#contactAddForm").html("数据正在加载...");
    }); */

/*   window.onload = function(){ 
	   AddBorrow()(parm); 
  } */
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

  
/*	 $(function () { 
	 $('#myModalBorrrow').modal('hide');
	 $('#myModalBorrrow').on('hide.bs.modal',function() {
    	  
    	  alert('嘿，我听说您喜欢模态框...');
          //  AddBorrow('cancel');
        })
     });*/
	 
// $("#myModal").modal("hide");

/*	$(function() {
	    $('#ModalDanger').on('show.bs.modal',
	    function() {
	    	$('#showdangerborrow').hide();
	    })
	});*/
/*	$(function() {
		$('#myModal').on('hide.bs.modal',
		  function(){
		$(this).removeData('bs.modal');		
	      //alert("SSSS");
	    // window.location.reload();
       })
	});*/
		  /*setTimeout(function(){//清除bootstrap modal多次加载残留的样式问题
		      showRation();
		},500)*/

function Goto() {
	window.location.href = ctx + "/reader/bookinfo/pageid?id="+$('#pageid').val();
}

function selectterm(str) {
	document.getElementById("term").innerHTML = str;
	//window.location.href = ctx + "/reader/bookinfo/pageid?id="+$('#pageid').val();
}

function select() {
	var term=$('#term').text();//获取span标签内容(span标签没有value属性)
	if(term=="书名"){
		term="bookName";
	}else if(term=="书籍类型"){
		term="bookKind";		
	}else if(term=="作者"){
		term="bookAuthor";		
	}else if(term=="简介"){
		term="bookIntro";		
	}
	//修改tomcat的server.xml文件： <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8" useBodyEncodingForURI="true"/> 

	//由于Get这样传参中文会乱码
	window.location.href = ctx + "/reader/bookinfo/select?"+term+"="+$('#selectcontent').val();
}


function productBorrowInfo(parm) {  
	    var _json = jQuery.param({ "bookId": parm });  
	    var request = $.ajax({  
	        url:ctx+"/reader/productborrow/bookid", 
	        type: "POST",  
	        async: true,  
	        data: _json, //不能直接写成 {id:"123",code:"tomcat"}  
	        dataType: "json",  
	        // contentType: "charset=utf-8",  
	        cache: false,  
	        success: function (result) {  
		       if (result &&result.statusCode==1&& result.message){	
		    	   /* start 动态生成模态框主题部分的图书借阅信息*/
		    	   document.getElementById("borrowdetail").innerHTML=" ";
		    	   var ul=document.createElement('ul');
		    	   ul.id="ulid"
		    	   ul.className="list-unstyled";
		    	   document.getElementById("borrowdetail").appendChild(ul);
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
					       var p5=document.createElement('p');
					       p5.className="sub-header";
				    	   document.getElementById("ulid").appendChild(p5);
				       var li5=document.createElement('li');
				       li5.style.padding="0px 0px 0px 20px";
				       document.getElementById("ulid").appendChild(li5);
	                   li1.appendChild(document.createTextNode("借阅人:  "+result.data.username));
	                   li2.appendChild(document.createTextNode("借阅书籍:  "+result.data.borrow.bookName));
	                   var time1 = new Date(result.data.borrow.startDate).Format("yyyy-MM-dd");
	                   var time2 = new Date(result.data.borrow.endDate).Format("yyyy-MM-dd");
	                   li3.appendChild(document.createTextNode("借阅日期:  "+time1));
	                   li4.appendChild(document.createTextNode("归还日期:  "+time2));
	                   li5.appendChild(document.createTextNode("小提示:  在借书籍不能超过8本,逾期未还书籍不能超过3本，否则不予借阅。"));
	                  /* end 动态生成模态框主题部分的图书借阅信息*/
			      /*document.getElementById("borrowdetail").appendChild(h3);
				  h3.appendChild(document.createTextNode("很抱歉您不能借阅!您需要先处理归还!"));
				  document.getElementById("borrowdetail").appendChild(hc);
				  hc.appendChild(document.createTextNode("您未归还(不超过8本)，或者逾期(不超过三本)的书籍数量超过了规定!"));
				  document.getElementById("borrowdetail").appendChild(h4);	    	  
				  h4.appendChild(document.createTextNode("你的借阅数量和逾期数量分别为:"));
				  document.getElementById("color").appendChild(span);
				  span.appendChild(document.createTextNode(result.data.countborrow+"本和"+result.data.countoverdue+"本"));
				  document.getElementById("price").style.color="red";
		    	  document.getElementById("borrowusername").innerHTML="借阅人:&nbsp;&nbsp;result.data.username";	    	 
		    	  document.getElementById("borrowbookName").innerHTML="借阅书籍:&nbsp;&nbsp;result.data.borrow.bookName";*/
                  //document.getElementById("teststart").val(result.data.borrow.startDate);
                 // document.getElementById("testsend").val(result.data.borrow.endDate);				     
		    	  //document.getElementById("successtip").style.color="green";
	       		  //document.getElementById("successtip").innerHTML="借阅成功!";
	       		  //setTimeout(function(){window.location.href=document.referrer;},2000);//document.referrer获取前一页url

		        
		        }else{
		    }
	      },
	
	  }); 

	 
}