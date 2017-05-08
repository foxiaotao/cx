<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
	<head>
	    <title>角色列表</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
	    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/pageCommon.css" />

	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery-plugin-delete.js"></script>
	    
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-plugin-tree.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ztree-2.5.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/funPrivilege.js"></script>
	    
	    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/zTreeStyle/zTreeStyle.css" />
	    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/zTreeStyle/zTreeIcon.css" />
	    <script type="text/javascript">
		    $().ready(function(){
	    		$.myConfirm();
	    	})
	    </script>
	</head>
	
	
	
	<body>
	 
	<div id="Title_bar">
	    <div id="Title_bar_Head">
	        <div id="Title_Head"></div>
	        <div id="Title"><!--页面标题-->
	            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 角色管理
	        </div>
	        <div id="Title_End"></div>
	    </div>
	</div>
	
	<div id="MainArea">
	    <table cellspacing="0" cellpadding="0" class="TableStyle">
	       
	        <!-- 表头-->
	        <thead>
	            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
	            	<td width="200px">角色名称</td>
	                <td width="500px">角色说明</td>
	                <td>相关操作</td>
	            </tr>
	        </thead>
	
			<!--显示数据列表-->
	        <tbody id="TableData" class="dataContainer" datakey="roleList">
	        	<s:iterator value="#roles">
					<tr class="TableDetail1 template">
						<s:hidden name="rid"></s:hidden>
						
						<td><s:property value="name"/></td>
						<td><s:property value="description"/></td>
						<td>
							<s:a action="roleAction_delete.action?rid=%{rid}">删除</s:a>
							<s:a action="roleAction_updateUI.action?rid=%{rid}">修改</s:a>
							<c:if test="${sessionScope.user.username=='admin'}">
								<a style="cursor:pointer;">设置权限</a>
							</c:if>
						</td>
					</tr>
				</s:iterator>
	        </tbody>
	    </table>
	    <!-- 其他功能超链接 -->
	    <div id="TableTail">
	        <div id="TableTail_inside">
	            <s:a action="roleAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png" /></s:a>
	        </div>
	    </div>
	    
		<%--隐藏===============================--%>
		
	    <div class="ItemBlock_Title1" id="userTitle" style="display: none;"><!-- 信息说明 -->
	    <div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif"/>
        	<label id="roleImage"></label>
        </div>
    <div class="ItemBlock_Title1" id="privilegeTitle" style="display: none;"><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" />选择权限</div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder" style="display: none;" id="privilegeContent">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<!--表头-->
					<thead>
						<tr align="LEFT" valign="MIDDLE" id="TableTitle">
							<td width="300px" style="padding-left: 7px;">
								<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
								<input type="checkbox" id="allchecked"/>
								<label for="cbSelectAll">全选</label>
							</td>
						</tr>
					</thead>
                   
			   		<!--显示数据列表-->
					<tbody id="TableData">
						<tr class="TableDetail1">
							<!-- 显示权限树 -->
							<td>
								<ul id='privilegeTree' class="tree"></ul>
								<img id='loading' src="${pageContext.request.contextPath}/css/images/loading.gif">
							</td>
						</tr>
					</tbody>
                </table>
            </div>
        </div>
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <image id="savePrivilege" src="${pageContext.request.contextPath}/css/images/save.png"/>
        </div>
	</div>
	</body>
</html>