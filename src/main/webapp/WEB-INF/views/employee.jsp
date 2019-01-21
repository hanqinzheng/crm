<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<%@include file="/WEB-INF/views/common/resource.jsp" %>
 <script type="text/javascript" src="/js/views/employee.js"></script>
</head>
<body>
	<table id="emp_datagrid"></table>
	<div id="emp_linkbutton">
		<div>
			<a id="AddEmp"  class="easyui-linkbutton" data-options="iconCls:'icon-add'" plain:true>新增</a> 
			<a id="EditEmp"  class="easyui-linkbutton" data-options="iconCls:'icon-edit'" plain:true>编辑</a> 
			<a id="DelEmp"  class="easyui-linkbutton" data-options="iconCls:'icon-remove'" plain:true>离职</a> 
			<a id="ReloadEmp" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" plain:true>刷新</a> 
		</div>
		<div>
			关键字查询：<input name="keyWord" style="width: 130px">
			部门:<input id="SelectDept1" style="width: 100px" class="easyui-combobox" name="dept.id"/>
			员工:<select class="easyui-combobox" name="state" style="width:100px;">   
			 	<option value="-1">全部</option>   
			    <option value="1">在职员工</option>   
			    <option value="0">离职员工</option>    
			</select> 
			<a id="keySelect" class="easyui-linkbutton" data-options="iconCls:'icon-search'" plain:true>搜索</a>
		</div>
	</div>
 	<div id="emp_dialog">
 		<form id="emp_form" method="post" align="center" style="padding-top: 15px">
 			<table>
 			<input type="hidden" name="id"/>
 				<tr>
 					<td>用户名</td>
 					<td><input type="text" name="username"/></td>
 				</tr>
 				<tr>
 					<td>真实姓名</td>
 					<td><input type="text" name="relname"/></td>
 				</tr>
 				<tr>
 					<td>电话</td>
 					<td><input type="text" name="tel"/></td>
 				</tr>
 				<tr>
 					<td>邮箱</td>
 					<td><input type="text" name="email"/></td>
 				</tr>
 				<tr>
 					<td>部门</td>
 					<td><input id="SelectDept" class="easyui-combobox" name="dept.id"/></td>
 				</tr>
 				<tr>
 					<td>入职时间</td>
 					<td><input type="text" name="inputtime" class="easyui-datebox"/></td>
 				</tr>
 					<tr>
 					<td>角色</td>
 					<td><input type="text" id="SelectRole" class="easyui-combobox"/></td>
 				</tr>
 				
 			</table>
 		</form>
 	</div>
 		<div id="emp_saveOrUpdate">
		<a id="emp_save" class="easyui-linkbutton" data-options="iconCls:'icon-save'" plain:true>保存</a> 
		<a id="emp_back" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" plain:true>取消</a> 
	</div>
</body>
</html>