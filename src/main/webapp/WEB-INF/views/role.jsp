<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>
<%@include file="/WEB-INF/views/common/resource.jsp" %>
 <script type="text/javascript" src="/js/views/role.js"></script>
</head>
<body>
	<table id="role_datagrid"></table>
	<div id="role_linkbutton">
		<div>
			<a id="AddRole"  class="easyui-linkbutton" data-options="iconCls:'icon-add'" plain:true>新增</a> 
			<a id="EditRole"  class="easyui-linkbutton" data-options="iconCls:'icon-edit'" plain:true>编辑</a> 
			<a id="DelRole"  class="easyui-linkbutton" data-options="iconCls:'icon-remove'" plain:true>删除</a> 
			<a id="ReloadRole" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" plain:true>刷新</a> 
		</div>
		<div>
			关键字查询：<input name="keyWord" style="width: 130px">
			<a id="keySelect" class="easyui-linkbutton" data-options="iconCls:'icon-search'" plain:true>搜索</a>
		</div>
	</div>
 	<div id="role_dialog">
 		<form id="role_form" method="post" align="center" style="padding-top: 15px">
 			<table>
 				<input type="hidden" name="id"/>
 				<tr>
 					<td>角色编号:<input type="text" name="sn"/></td>
 					<td>角色名称:<input type="text" name="name"/></td>
 				</tr>
 				<tr>
 					<td><table id="AllPerssions"></table></td>
 					<td><table id="SelectPerssions"></table></td>
 				</tr>
 			</table>
 		</form>
 	</div>
 		<div id="role_saveOrUpdate">
		<a id="role_save" class="easyui-linkbutton" data-options="iconCls:'icon-save'" plain:true>保存</a> 
		<a id="role_back" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" plain:true>取消</a> 
	</div>
</body>
</html>