$(function(){

	$("#dept_datagrid").datagrid({
		fit:true,
		fitColumns:true,
		rownumbers:true,
		pagination:true,
		toolbar:'#dept_linkbutton',
		singleSelect:true,
		pageList:[1,10,20,30,40,50],
		url:"/department_all",
		columns:
		[
		 	[
		 	 	{field:'sn',title:'部门编号',algin:'center',width:1},
		 	 	{field:'name',title:'部门名称',algin:'center',width:1},
		 	 	{field:'manager',title:'管理者',algin:'center',width:1,formatter:empForamtter},
		 	 	{field:'parent',title:'总部门',algin:'center',width:1,formatter:deptForamtter},
		 	 	{field:'status',title:'状态',algin:'center',width:1}	
		 	 ]
		 ]
	})
})
function deptForamtter(value,row,index){
	return value!=null?value.name:"";
}
function empForamtter(value,row,index){
	return value!=null?value.relname:"";
}
