$(function(){
	$("#role_datagrid").datagrid({
		fit:true,
		fitColumns:true,
		rownumbers:true,
		pagination:true,
		toolbar:'#role_linkbutton',
		singleSelect:true,
		pageList:[1,10,20,30,40,50],
		url:"/role_list",
		columns:
		[
		 	[
		 	 	{field:'sn',title:'角色编号',algin:'center',width:1},
		 	 	{field:'name',title:'角色名称',algin:'center',width:1},		 	 	
		 	 ]
		 ]
	})
	
	$("#AllPerssions").datagrid({
		width:300,
		height:300,
		title:'所有权限',
		fitColumns:true,
		rownumbers:true,
		pagination:true,
		singleSelect:true,
		url:"/permission_list",
		onDblClickRow:function(rowIndex,rowData){//双击事件
			var rows = $("#SelectPerssions").datagrid("getRows");//返回当前页的所有行
			var flag=true;
			var index=-1;
			for(var i=0;i<rows.length;i++){
				if(rows[i].id==rowData.id){
					flag=false;
					index=i;
					break;
				}
			}
			if(flag){
				$("#SelectPerssions").datagrid("appendRow",rowData);//追加一个新行,新行将被添加到最后的位置
			}else{
				$("#SelectPerssions").datagrid("selectRow",index);//选中一行
			}
		},
		columns:
			[
			 	[
			 	 	{field:'name',title:'权限名',align:'center',width:1},	
			 	 ]
			 ]
	})
	

	
	$("#SelectPerssions").datagrid({
		width:300,
		height:300,
		title:'所选权限',
		rownumbers:true,
		fitColumns:true,
		pagination:true,
		singleSelect:true,
		onDblClickRow:function(rowIndex,rowData){
			$("#SelectPerssions").datagrid("deleteRow",rowIndex);//删除一行
		},
		columns:
			[
			 	[
			 	 	{field:'name',title:'权限名',align:'center',width:1},	
			 	 ]
			 ]
	})
	
	var AllPerssionsPage = $("#AllPerssions").datagrid("getPager");
	AllPerssionsPage.pagination({
		showPageList:false,
		showRefresh:false,
		displayMsg:''
	})
	
	var SelectPerssionsPage = $("#SelectPerssions").datagrid("getPager");
	SelectPerssionsPage.pagination({
		showPageList:false,
		showRefresh:false,
		displayMsg:''
	})
	
	$("#role_dialog").dialog({
		title:"新增",
		width:650,
		height:480,
		buttons:"#role_saveOrUpdate",
		closed:true
	})
	$("#AddRole").click(function(){
		$("#role_dialog").dialog("open");
		/*$("#role_form").form("clear");*/
		$("[name='id'],[name='sn'],[name='name']").val("");
		$("#SelectPerssions").datagrid("loadData",{rows:[]});
	})
	$("#EditRole").click(function(){
		var selectData = $("#role_datagrid").datagrid("getSelected");
		if(selectData){
			$("#role_dialog").dialog("open");
			$("[name='id'],[name='sn'],[name='name']").val("");
			/*$("#role_form").form("clear");*/
			
			var options = $("#SelectPerssions").datagrid("options");
			options.url="/permission_ByRoleId";
			$("#SelectPerssions").datagrid("load",{
				rid:selectData.id
			});
			$("#role_form").form("load",selectData);
		}else{
			$.messager.alert("温馨提示","请选择编辑的数据","info");
		}
		
	})
	
	$("#DelRole").click(function(){
		var selectData = $("#role_datagrid").datagrid("getSelected");
		if(selectData){
			$.messager.confirm("温馨提示","你确定要删除选中的数据吗?",function(yes){
				if(yes){
					$.ajax({
						   type: "POST",
						   url: "/role_delete",
						   data: "id="+selectData.id,
						   success: function(data){
						     if(data.success){
						    	 $.messager.alert("温馨提示",data.msg,"info",function(){
						    		 $("#role_datagrid").datagrid("reload"); 
						    	 });
						     }else{
						    	 $.messager.alert("温馨提示",data.msg,"info");
						     }
						   }
						});
				}
			})
		}else{
			$.messager.alert("温馨提示","请选择离职的数据","info");
		}
	})
	
	$("#ReloadRole").click(function(){
		$("#role_datagrid").datagrid("reload"); 
	})
	
	$("#keySelect").click(function(){
		var keyword = $("#role_linkbutton [name='keyWord']").val();
		//var deptId = $("#role_linkbutton [name='dept.id']").val();
		//var state = $("#role_linkbutton [name='state']").val();
		$("#role_datagrid").datagrid("load",{
			keyWord:keyword,
			/*dept_id:deptId,
			State:state*/
		}); 
	})
	
	
	
	$("#role_back").click(function(){
		$("#role_dialog").dialog("close"); 
		
	})
	
	$("#role_save").click(function(){
		var id = $("#role_form [name='id']").val();
		var url;
		if(id!=null&&id!=""){
			url="/role_update";
		}else{
			url="/role_save";
		}
		$("#role_form").form("submit",{
			url:url,
			onSubmit:function(param){
				var rows = $("#SelectPerssions").datagrid("getRows");
				for(var i=0;i<rows.length;i++){
					param["permissions["+i+"].id"]=rows[i].id
				}
			},
			success:function(data){
				data = $.parseJSON(data);
				if(data.success){
					$.messager.alert("温馨提示",data.msg,"info",function(){
						$("#role_dialog").dialog("close");
						$("#role_datagrid").datagrid("reload"); 
					});
				}else{
					$.messager.alert("温馨提示",data.msg,"info");
				}
			}  
		})
	})
})
function deptForamtter(value,row,index){
	return value!=null?value.name:"";
}
function stateForamtter(value,row,index){
	if(value==true){
		return "<font color='green'>"+"在职员工"+"</font>";
	}else{
		return "<font color='red'>"+"离职员工"+"</font>";
	}
}
function adminForamtter(value,row,index){
	if(value==true){
		return "是";
	}else{
		return "否";
	}
}

