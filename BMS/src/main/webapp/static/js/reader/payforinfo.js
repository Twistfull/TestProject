$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

});

/*function edit(parm){//得到记录号的点击事件
	alert("记录号:"+parm);
}*/

function changurl(parm){
	//alert("处理状态:"+parm);
	$('#tb_departments').bootstrapTable('refresh',{url:'http://localhost:8080/BMS/reader/payfor/id?id='+parm});//按钮绑定bootstrapTable的刷新事件
}

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_departments').bootstrapTable({
            url: 'http://localhost:8080/BMS/reader/payfor/id?id=2',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            //toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
           // sortable: false,                     //是否启用排序
          //  sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 5,                       //每页的记录行数（*）
            pageList: [1,3, 5, 10],        //可供选择的每页的行数（*）
           // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
           // strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            //clickToSelect: true,                //是否启用点击选中行
            //height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            //uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            
            columns: [
			/*{
			    checkbox: true
			},*/
                      
            {
                field: 'bookName',
                title: '借阅书籍',
            	align: 'center',
            	valign: 'middle',       
            }, {
                field: 'startDate',
                title: '借阅日期',
            	align: 'center',
            	valign: 'middle'
            	/*formatter:function(value,row,index){
        			// var e = '<a href="#" rel="nofollow" target="_blank" mce_href="#" rel="nofollow" target="_blank" onclick="edit(\''+ row.id + '\')">编辑</a> ';
        			// var d = '<a href="#" rel="nofollow" target="_blank" mce_href="#" rel="nofollow" target="_blank" onclick="del(\''+ row.id +'\')">删除</a> ';
        			 var c = '<a href='+ctx+'/reader/bookinfo/bookid?id='+row.bookId+' data-toggle="modal" data-target="#myModal" aria-label="Detail">详情</a>'
        			 return c;
        			 }*/

            }, {
                field: 'endDate',
                title: '归还日期',
            	align: 'center',
            	valign: 'middle'

            }, {
                field: 'overDue',
                title: '逾期天数',
            	align: 'center',
            	valign: 'middle',
            	formatter:function(value,row,index){
                     if(row.overDue<0){
        			   var a = 0
        			   return a;
        			 }else{
        				return row.overDue; 
        			 }
            	}

            },{
                field: 'payFor',
                title: '罚款金额',
            	align: 'center',
            	valign: 'middle',
            	formatter:function(value,row,index){
            		 if(row.payFor<0){
          			   var a = 0
          			   return a;
          			 }else{
          				return row.payFor; 
          			 }
        		}

            },{
                field: 'payExplain',
                title: '处理情况',
            	align: 'center',
            	valign: 'middle',
        		formatter:function(value,row,index){
        			 if(row.payExplain==null){
            			  // var a = '<a href="#" rel="nofollow" target="_blank" mce_href="#" rel="nofollow" target="_blank" onclick="edit(\''+ row.recordId + '\')">未处理</a> ';
        				    var a = '<a href='+ctx+'/reader/borrowinfo/select?returnInfo.payExplain=未处理  rel="nofollow" target="_self" mce_href="#" rel="nofollow" target="_blank" >去归还</a> ';
        				    return a;//target属性:="_blank"在新窗口打开页面.="_self"在当前窗口打开
            			 }else{
            				 if(row.bookPrice==row.payFor){
            					 var b ="丢失赔偿";
            					return b;
            				 }else{
            					 return row.payExplain;
            				 }           				 
            			 }
          		}       			 
            },]
        });
    };
     
    
    
    
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小(行数)
            offset: params.offset,  //页码(当前页之前所有数据总数)
            //departmentname: $("#txt_search_departmentname").val(),
            //statu: $("#txt_search_statu").val()
        };
        return temp;
    };
    return oTableInit;
};


var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};
