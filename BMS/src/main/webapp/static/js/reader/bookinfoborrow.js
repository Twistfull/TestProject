function gotoreturn() {
	window.location.href=ctx+"/reader/borrowinfo/select?returnInfo.payExplain=未处理";												    
	};

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
			       if (result &&result.statusCode==1&& result.message){	//成功借阅    	   
			    	  //document.getElementById("borrowdetail").innerHTML=" ";
			    	  $('#showsuccessborrow').show();
			    	  setTimeout(function(){window.location.reload();},1000);//刷新当前页面
			    	 // window.location.reload();
			    	 // style="display:table"
			    	/*  $('#confirm').hide();
			    	  $('#cancel').hide();
			    	  document.getElementById("successtip").style.color="green";
		       		  document.getElementById("successtip").innerHTML="借阅成功!";
		       		  setTimeout(function(){window.location.href=document.referrer;},2000);//document.referrer获取前一页url
                     */			    	   
			    	}
			     else if(result &&result.statusCode==2&& result.message){//用户取消借阅
			    	  // window.history.go(-1) ;  	   
		        }else if(result &&result.statusCode==3&& result.message){//不允许借阅
			          
			
			           $('#showdangerborrow').show();
			    	   document.getElementById("dangerdetail").innerHTML=" ";
			    	   var ul=document.createElement('ul');
			    	   ul.id="dangulid"
			    	   ul.className="list-unstyled";
			    	   document.getElementById("dangerdetail").appendChild(ul);	    	   		    	   
				       var li1=document.createElement('li');
				       li1.style.padding="0px 0px 0px 20px";
				       document.getElementById("dangulid").appendChild(li1);
				       	   var p2=document.createElement('p');
					       p2.className="sub-header";
				    	   document.getElementById("dangulid").appendChild(p2);
				       var li2=document.createElement('li');
				       li2.style.padding="0px 0px 0px 20px";
				       document.getElementById("dangulid").appendChild(li2);
					       var p3=document.createElement('p');					       
					       p3.className="sub-header";
				    	   document.getElementById("dangulid").appendChild(p3);
				       var li3=document.createElement('li');
				       li3.style.padding="0px 0px 0px 20px";
				       document.getElementById("dangulid").appendChild(li3);
					       var p4=document.createElement('p');
					       p4.className="sub-header";
				    	   document.getElementById("dangulid").appendChild(p4);
				       var li4=document.createElement('li');
				       li4.style.padding="0px 0px 0px 20px";
				       document.getElementById("dangulid").appendChild(li4);
					       var p5=document.createElement('p');
					       p5.className="sub-header";
				    	   document.getElementById("dangulid").appendChild(p5);
				       var li5=document.createElement('li');
				       li5.style.padding="0px 0px 0px 20px";
				       document.getElementById("dangulid").appendChild(li5);
	                   li1.appendChild(document.createTextNode("最大在借书籍:  8  (本)"));
	                   li2.appendChild(document.createTextNode("实际在借书籍:  "+result.data.countborrow+"  (本)"));
	                  // var time1 = new Date(result.data.borrow.startDate).Format("yyyy-MM-dd");
	                   //var time2 = new Date(result.data.borrow.endDate).Format("yyyy-MM-dd");
	                   li3.appendChild(document.createTextNode("最大逾期未还数量:  3  (本)"));
	                   li4.appendChild(document.createTextNode("实际逾期未还数量:  "+result.data.countoverdue+"  (本)"));
	                   li5.appendChild(document.createTextNode("建议:如果你想要继续借阅书籍，请先处理归还!"));
	    	           //setTimeout(function(){window.location.reload();},5000);
			           /*document.getElementById("borrowdetail").innerHTML=" ";
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
			          result*/
			        
			    }else{//其他异常
			    	  window.location.href = ctx + "/reader/disallowborrow";
			    }
		},
		    });  
	}




	

  