function deleteById() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		var id = row.id;
		$.ajax({
					// type:"GET",
					type : "POST",
					data : {
						id : id,
					},
					// url:"<%=path%>/deleteById.action?id="+$("#keyword").val(),
					url : ctx + "/deleteById.action",
					dataType : "json",
					success : function(data) {
						if (data.success) {
							alert(data.msg);
							//刷新页面
							window.location.href = ctx+"/users_back.jsp";
						} else {
							alert(data.msg);
						}
					},
					/*
					 * success:function(result){ ajaxReturn(result, function () {
					 * $("#searchResult").html(data.msg); }, function () {
					 * $("#searchResult").html("出现错误:"+data.msg); }); },
					 */
					error : function(jqXHR) {
						alert("发生错误:" + jqXHR.status);
					}
				});
	}
}


$(function() {
	$("#dg").datagrid({
		title:'读者表',
		url : ctx + "/admin/findReaderList",
		columns : [ [ {
			field : 'id',
			title : 'id',
			width : 100,
			sortable:'true'
		},{
			field : 'userId',
			title : 'userId',
			width : 100,
			sortable:'true'
		},{
			field : 'readerName',
			title : '读者姓名',
			width : 100,
			sortable:'true'
		} ,{
			field : 'sex',
			title : '性别',
			width : 100,
			sortable:'true'
		}, {
			field : 'phone',
			title : '电话',
			width : 100
		} ,{
			field : 'email',
			title : '邮箱',
			width : 100
		}] ],
		toolbar : '#toolbar', // 表格菜单
		loadMsg : '嗖 ----正在火速加载中 -------------', // 加载提示
		pagination : true, // 显示分页工具栏
		rownumbers : true, // 显示行号列
		singleSelect : true,// 是允许选择一行
		queryParams : { // 在请求数据是发送的额外参数，如果没有则不用写
			name : 'easyui',
			hhh : 'aa'
		},
		height : '300px',
		width:'800'	
	});

	var p = $('#dg').datagrid('getPager');
	$(p).pagination({
		pageSize : 10,// 每页显示的记录条数，默认为10  
		pageList : [ 5, 10, 15 ],// 可以设置每页记录条数的列表  
		beforePageText : '第',// 页数文本框前显示的汉字  
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
	/*
	 * onBeforeRefresh:function(){              $(this).pagination('loading'); 
	 *             alert('before refresh'); 
	 *             $(this).pagination('loaded');          }
	 */
	});
	$.fn.menubutton.methods.enableNav();
	$(document).keydown(function(e) {
		if (e.altKey && e.keyCode == 87) {
			$('#btn-home').focus();
		}
	});
})
//上移
	function MoveUp() {
		    var row = $("#dg").datagrid('getSelected'); 
		    var index = $("#dg").datagrid('getRowIndex', row);
		    mysort(index, 'up', 'dg');
		     
		}
		//下移
		function MoveDown() {
		    var row = $("#dg").datagrid('getSelected');
		    var index = $("#dg").datagrid('getRowIndex', row);
		    mysort(index, 'down', 'dg');
		     
		}
		function mysort(index, type, gridname) {
			    if ("up" == type) {
			        if (index != 0) {
			            var toup = $('#' + gridname).datagrid('getData').rows[index];
			            var todown = $('#' + gridname).datagrid('getData').rows[index - 1];
			            $('#' + gridname).datagrid('getData').rows[index] = todown;
			            $('#' + gridname).datagrid('getData').rows[index - 1] = toup;
			            $('#' + gridname).datagrid('refreshRow', index);
			            $('#' + gridname).datagrid('refreshRow', index - 1);
			            $('#' + gridname).datagrid('selectRow', index - 1);
			        }
			    } else if ("down" == type) {
			        var rows = $('#' + gridname).datagrid('getRows').length;
			        if (index != rows - 1) {
			            var todown = $('#' + gridname).datagrid('getData').rows[index];
			            var toup = $('#' + gridname).datagrid('getData').rows[index + 1];
			            $('#' + gridname).datagrid('getData').rows[index + 1] = todown;
			            $('#' + gridname).datagrid('getData').rows[index] = toup;
			            $('#' + gridname).datagrid('refreshRow', index);
			            $('#' + gridname).datagrid('refreshRow', index + 1);
			            $('#' + gridname).datagrid('selectRow', index + 1);
			        }
			    }
			 
			}
		(
				function($) {
					function getParentMenu(rootMenu, menu) {
						return findParent(rootMenu);

						function findParent(pmenu) {
							var p = undefined;
							$(pmenu).find('.menu-item').each(function() {
								if (!p && this.submenu) {
									if ($(this.submenu)[0] == $(menu)[0]) {
										p = pmenu;
									} else {
										p = findParent(this.submenu);
									}
								}
							});
							return p;
						}
					}
					function getParentItem(pmenu, menu) {
						var item = undefined;
						$(pmenu).find('.menu-item').each(function() {
							if ($(this.submenu)[0] == $(menu)[0]) {
								item = $(this);
								return false;
							}
						});
						return item;
					}

					$
							.extend(
									$.fn.menubutton.methods,
									{
										enableNav : function(enabled) {
											var curr;
											$(document).unbind('.menubutton');
											if (enabled == undefined) {
												enabled = true;
											}
											if (enabled) {
												$(document)
														.bind(
																'keydown.menubutton',
																function(e) {
																	var currButton = $(
																			this)
																			.find(
																					'.m-btn-active,.m-btn-plain-active,.l-btn:focus');
																	if (!currButton.length) {
																		return;
																	}

																	if (!curr
																			|| curr.button != currButton[0]) {
																		curr = {
																			menu : currButton
																					.data('menubutton') ? $(currButton
																					.menubutton('options').menu)
																					: $(),
																			button : currButton[0]
																		};
																	}
																	var item = curr.menu
																			.find('.menu-active');

																	switch (e.keyCode) {
																	case 13: // enter
																		item
																				.trigger('click');
																		break;
																	case 27: // esc
																		currButton
																				.trigger('mouseleave');
																		break;
																	case 38: // up
																		var prev = !item.length ? curr.menu
																				.find('.menu-item:last')
																				: item
																						.prevAll('.menu-item:first');
																		prev
																				.trigger('mouseenter');
																		return false;
																	case 40: // down
																		var next = !item.length ? curr.menu
																				.find('.menu-item:first')
																				: item
																						.nextAll('.menu-item:first');
																		next
																				.trigger('mouseenter');
																		return false;
																	case 37: // left
																		var pmenu = getParentMenu(
																				currButton
																						.data('menubutton') ? $(currButton
																						.menubutton('options').menu)
																						: $(),
																				curr.menu);
																		if (pmenu) {
																			item
																					.trigger('mouseleave');
																			var pitem = getParentItem(
																					pmenu,
																					curr.menu);
																			if (pitem) {
																				pitem
																						.trigger('mouseenter');
																			}
																			curr.menu = pmenu;
																		} else {
																			var prev = currButton
																					.prevAll('.l-btn:first');
																			if (prev.length) {
																				currButton
																						.trigger('mouseleave');
																				prev
																						.focus();
																			}
																		}
																		return false;
																	case 39: // right
																		if (item.length
																				&& item[0].submenu) {
																			curr.menu = $(item[0].submenu);
																			curr.button = currButton[0];
																			curr.menu
																					.find(
																							'.menu-item:first')
																					.trigger(
																							'mouseenter');
																		} else {
																			var next = currButton
																					.nextAll('.l-btn:first');
																			if (next.length) {
																				currButton
																						.trigger('mouseleave');
																				next
																						.focus();
																			}
																		}
																		return false;
																	}
																});
											}
										}
									});
				})(jQuery);
