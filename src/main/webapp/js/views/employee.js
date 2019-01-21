$(function(){
	$("#emp_datagrid").datagrid({
		fit:true,
		fitColumns:true,
		rownumbers:true,
		pagination:true,
		toolbar:'#emp_linkbutton',
		singleSelect:true,
		pageList:[1,10,20,30,40,50],
		onClickRow:function(rowIndex,rowData){
			if(rowData.state){
				$("#EditEmp,#DelEmp").linkbutton('enable');
			}else{
				$("#EditEmp,#DelEmp").linkbutton('disable');
			}
		},
		url:"/employee_list",
		columns:
		[
		 	[
		 	 	{field:'username',title:'用户名',align:'center',width:1},
		 	 	{field:'relname',title:'真实姓名',align:'center',width:1},
		 	 	{field:'tel',title:'电话',align:'center',width:1},
		 	 	{field:'email',title:'邮箱',align:'center',width:1},
		 	 	{field:'dept',title:'部门',align:'center',width:1,formatter:deptForamtter},
		 	 	{field:'inputtime',title:'入职时间',align:'center',width:1},
		 	 	{field:'state',title:'状态',align:'center',width:1,formatter:stateForamtter},
		 	 	{field:'admin',title:'是否超级管理员',align:'center',width:1,formatter:adminForamtter},
		 	 	
		 	 ]
		 ]
	})
	$("#emp_dialog").dialog({
		title:"新增",
		width:251,
		height:300,
		buttons:"#emp_saveOrUpdate",
		closed:true
	})
	$("#SelectDept,#SelectDept1").combobox({
		 url:'/department_list',    
		 valueField:'id',    
		 textField:'name' 
	})
	
	$("#SelectRole").combobox({
		 url:'/RoleList',    
		 valueField:'id',    
		 textField:'name',
		 multiple:true
	})
	$("#AddEmp").click(function(){
		$("#emp_dialog").dialog("open");
		$("#emp_form").form("clear");
	})
	$("#EditEmp").click(function(){
		var selectData = $("#emp_datagrid").datagrid("getSelected");
		if(selectData){
			$("#emp_dialog").dialog("open");
			$("#emp_form").form("clear");
			//部门显示
			selectData["dept.id"]=selectData.dept.id;
			//发送同步请求
			 var html = $.ajax({
				  url: "/role_queryByID?eid="+selectData.id,
				  async: false
				 }).responseText;
			 html=$.parseJSON(html);
			 console.log(html);
			$("#SelectRole").combobox("setValues",html);
			
			$("#emp_form").form("load",selectData);
		}else{
			$.messager.alert("温馨提示","请选择编辑的数据","info");
		}
		
	})
	
	$("#DelEmp").click(function(){
		var selectData = $("#emp_datagrid").datagrid("getSelected");
		if(selectData){
			$.messager.confirm("温馨提示","你确定要离职选中的员工吗?",function(yes){
				if(yes){
					$.ajax({
						   type: "POST",
						   url: "/employee_delete",
						   data: "id="+selectData.id,
						   success: function(data){
						     if(data.success){
						    	 $.messager.alert("温馨提示",data.msg,"info",function(){
						    		 $("#emp_datagrid").datagrid("reload"); 
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
	
	$("#ReloadEmp").click(function(){
		$("#emp_datagrid").datagrid("reload"); 
	})
	
	$("#keySelect").click(function(){
		var keyword = $("#emp_linkbutton [name='keyWord']").val();
		var deptId = $("#emp_linkbutton [name='dept.id']").val();
		var state = $("#emp_linkbutton [name='state']").val();
		$("#emp_datagrid").datagrid("load",{
			keyWord:keyword,
			dept_id:deptId,
			State:state
		}); 
	})
	
	
	
	$("#emp_back").click(function(){
		$("#emp_dialog").dialog("close"); 
		
	})
	
	$("#emp_save").click(function(){
		var id = $("#emp_form [name='id']").val();
		console.log(id);
		var url;
		if(id!=null&&id!=""){
			url="/employee_update";
		}else{
			url="/employee_save";
		}
		$("#emp_form").form("submit",{
			url:url,
			onSubmit:function(param){
				var ids = $("#SelectRole").combobox("getValues");
				for(var i=0;i<ids.length;i++)
					param["roles["+i+"].id"] = ids[i]
			},
			success:function(data){
				data = $.parseJSON(data);
				if(data.success){
					$.messager.alert("温馨提示",data.msg,"info",function(){
						$("#emp_dialog").dialog("close");
						$("#emp_datagrid").datagrid("reload"); 
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

