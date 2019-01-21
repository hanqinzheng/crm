<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门列表</title>
<%@include file="/WEB-INF/views/common/resource.jsp" %>
<script type="text/javascript" src="/js/views/department.js"></script>
</head>
<body>
	<table id="dept_datagrid"></table>
		<div id="dept_linkbutton">
		<div>
			<a id=""  class="easyui-linkbutton" data-options="iconCls:'icon-add'" plain:true>新增</a> 
			<a id=""  class="easyui-linkbutton" data-options="iconCls:'icon-edit'" plain:true>编辑</a> 
			<a id=""  class="easyui-linkbutton" data-options="iconCls:'icon-remove'" plain:true>删除</a> 
			<a id="" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" plain:true>刷新</a> 
		</div>
		</div>
</body>
</html>