<%@ page language="java" contentType="text/html; charset=UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>员工管理系统</title>
    <%@include file="/WEB-INF/views/common/resource.jsp" %>
    <script type="text/javascript" src="/js/views/index.js"></script>
</head>
<div id="cc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'North Title',split:true,noheader:true"
         style="height:70px;background-image: url('/img/blue2.jpg') ;background-repeat: no-repeat;background-size:cover;">
        <h1>CRM客户管理系统</h1>
    </div>
    <div data-options="region:'west',title:'West',noheader:true" style="width:200px;">
        <!-- 左边的内容 -->
        <div class="easyui-accordion" data-options="fit:true">
            <div title="菜单">
                <!-- 树的内容 -->
                <ul id="mytree"></ul>
            </div>
            <div title="帮助文档"></div>
        </div>
    </div>
    <div id="mytabs" data-options="region:'center',border:false" class="easyui-tabs"
         style="padding:5px;background:#eee;">

    </div>
    <div data-options="region:'south',title:'South Title',noheader:true"
         style="height:30px;background-image: url('/img/banner-pic.gif') ;background-repeat: no-repeat;background-size:cover;">
        <div align="center">版权所有,侵权不究!</div>
    </div>
    <c:forEach items="${users}" varStatus="user">
    	<td>${user.id}</td>
    </c:forEach>
</div>
</body>
</body>
</html>