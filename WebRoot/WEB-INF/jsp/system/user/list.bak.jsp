<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
<head>
    <title>用户列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery.datepick.css" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.datepick.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.datepick-zh-CN.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 成员管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>



<s:form action="userAction_showUserByCondition.action">
 <div style="overflow:auto; height:120px;">
 
			可按以下条件查询：
            <table class="content">
                <tr>
                    <td class="one" style="color:#00F">学	号</td>
                    <td class="inp">
                    	<s:textfield name="userQuery.number" cssClass="InputStyle"></s:textfield>
                    </td>
                    <td style="color:#00F">姓	名</td>
                    <td class="inp">
                    	<s:textfield name="userQuery.username" cssClass="InputStyle"></s:textfield>
                    </td>
                    <td style="color:#00F">加入中心时间</td>
                    <td class="inp">
                    	<s:textfield name="userQuery.joindate" class="current" cssClass="InputStyle"/>
                    </td>
                    <td class="one" style="color:#00F">入学年份</td>
                    <td class="inp"><s:textfield name="userQuery.year" class="current" cssClass="InputStyle"/>*2014 (2014级学生入学年份)</td>
                    
                </tr>
                <tr>
                    <td style="color:#00F">电	话</td>
                    <td class="inp"><s:textfield name="phone" cssClass="InputStyle"/></td>
                    <td style="color:#00F">邮	箱</td>
                    <td class="inp"><s:textfield name="email" cssClass="InputStyle"/></td>
                    <td style="color:#00F">所属部门</td>
                    <td class="inp">
                    	<s:select list="{'','数学建模','程序设计部','超级管理'}" cssClass="SelectStyle"></s:select>
                    </td>
                    <td style="color:#00F">成员类型</td>
                    <td class="inp">
                    	<s:select list="{'','成员','管理员','超级管理'}" cssClass="SelectStyle"></s:select>
                    </td>
                </tr>
<%--                <tr>--%>
<%--                    <td style="color:#00F">家庭住址</td>--%>
<%--                    <td class="inp" colspan="3"><input type="text" class="current" style="text-align:left;background:url(search_1.png) no-repeat 584px center #FFF; width:500px;"/></td>--%>
<%--                </tr>--%>
                <tr>
                	<td colspan="7"></td>
                    <td height="40" align="left"><input type="button" value="查询" class="search"/></td>
                </tr>
            </table>
           </div>
<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">姓名</td>
                <td width="100">学号</td>
                <td width="100">密码</td>
                <td width="100">电话</td>
                <td width="100">邮箱</td>
                <td width="50">性别</td>
                <td width="200">家庭住址</td>
                <td width="50">年龄</td>
                <td width="120">加入中心时间</td>
                <td width="100">入学年份</td>
                <td width="150">所属部门</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
	        <s:iterator value="#pageResult.rows">
	            <tr class="TableDetail1 template" align="center">
	                <td><s:property value="username"/></td>
	                <td><s:property value="number"/></td>
	                <td><s:property value="password"/></td>
	                <td><s:property value="phone"/></td>
	                <td><s:property value="email"/></td>
	                <td><s:property value="sex"/></td>
	                <td><s:property value="address"/></td>
	                <td><s:property value="age"/></td>
	                <td><s:property value="joindate"/></td>
	                <td><s:property value="year"/></td>
	                <td><s:property value="department.name"/></td>
	               
	                <td><s:a action="userAction_delete.action?uid=%{uid}">删除</s:a>
	                    <s:a action="userAction_updateUI.action?uid=%{uid}">修改</s:a>
	                </td>
	            </tr>
            </s:iterator>
        </tbody>
    </table>
    
     <div id="TableTail">
        <div id="TableTail_inside">
            <a href="userAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png" /></a>
        </div>
    </div>
    
</div>
</s:form>
</body>
</html>

