<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
<head>
    <title>项目管理文件</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery-plugin-delete.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/pageCommon.css" />
    <script type="text/javascript">
	    $().ready(function(){
			$.myConfirm();
		});
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 项目管理文件
        </div>
     
        <div id="Title_End"></div>
    </div>
</div>

<br/>


<%---------------list----------------%>
<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td>文件名</td>
                <td width="200px">相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
	        <s:iterator value="#projectFiles">
	            <tr class="TableDetail1 template" align="center">
	                <td><s:property value="name"/></td>
	                <td>
	                	<s:a action="projectFileAction_delete.action?pfid=%{pfid}">删除</s:a>
	                	<s:a action="projectFileAction_download.action?pfid=%{pfid}">下载</s:a>
	                </td>
	            </tr>
            </s:iterator>
        </tbody>
    </table>
    <div id="TableTail">
        <div id="TableTail_inside">
				<%--    添加项目文件--%>
            <a href="projectFileAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png" /></a>

        </div>
    </div>
</body>
</html>

