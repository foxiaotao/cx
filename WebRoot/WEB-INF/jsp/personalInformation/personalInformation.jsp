<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
<head>
	<title>用户信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/pageCommon.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/validation/screen.css" />
	<script src="${pageContext.request.contextPath}/js/jquery.validate.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/localization/messages_zh.js" type="text/javascript"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery.datepick.css" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.datepick.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.datepick-zh-CN.js"></script>
    <script type="text/javascript">
    </script>
</head>

<script type="text/javascript">

</script>



<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 用户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="userAction_update.action" id="userForm" cssClass="center">
    	<s:hidden name="uid"></s:hidden>
    <table cless="center">
        <div class="ItemBlock_Title1"><!-- 信息说明 -->
       
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 用户信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                    	<td width="100">姓名</td>
                    	<td>
                    		<s:property value="username"/>
                    	</td>
                    </tr>
                    <tr>
                    	<td width="100">学号</td>
                    	<td>
                    	<s:property value="number"/>
                    	</td>
                    </tr>
                    <tr>
                    	<td width="100">密码</td>
                    	<td>
                    	<s:property value="password"/>
                    	
                    </tr>
                    <tr>
                    	<td width="100">部门</td>
                        <td>
                        	<s:property value="department.name"/>
                        </td>
                    </tr>
                    <tr>
                    	<td width="100">角色</td>
                        <td>
                        	<s:property value="role.name"/>
                        </td>
                    </tr>
                    <tr>
	                    <td width="100">电话</td>
	                    <td>
	                    <s:property value="phone"/>
	                    </td>
                    </tr>
                    <tr>
	                    <td width="100">E-mail</td>
	                    <td>
	                    <s:property value="email"/>
	                    </td>
                    </tr>
                    <tr>
                    	<td width="100">性别</td>
                    	<td>
                    	<span cssClass="InputStyle">
                    		<s:property value="sex"/>
						</td>
					</tr>
                    <tr>
                    	<td>家庭住址</td>
	                     <td>
	                    	<s:property value="address"/>
                    	</td>
<%--                        <td><input type="text" name="loginName" class="InputStyle"/> *</td>--%>
                    </tr>
					<tr><td>年龄</td>
					<td>
                        <s:property value="age"/>
                        </td>
                    </tr>
                    <tr>
                    	<td>加入中心时间</td>
                    	<td>
                        <s:property value="joindate"/>
                        </td>
                    </tr>
                    <tr>
                    	<td>入学年份</td>
                    	<td>
                        <s:property value="year"/>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        
<%--		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">--%>
<%--        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 岗位设置 </div> --%>
<%--        </div>--%>
<%--        --%>
<%--        <!-- 表单内容显示 -->--%>
<%--        <div class="ItemBlockBorder">--%>
<%--            <div class="ItemBlock">--%>
<%--                <table cellpadding="0" cellspacing="0" class="mainForm">--%>
<%--                    <tr>--%>
<%--						<td width="100">岗位</td>--%>
<%--                        <td><select name="roleIdList" multiple="true" size="10" class="SelectStyle">--%>
<%--                                <option value="1">程序员</option>--%>
<%--                                <option value="2">行政秘书</option>--%>
<%--                                <option value="3">出纳</option>--%>
<%--                                <option value="4">总经理</option>--%>
<%--                                <option value="5">测试员</option>--%>
<%--                            </select>--%>
<%--                            按住Ctrl键可以多选或取消选择--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                </table>--%>
<%--            </div>--%>
<%--        </div>		--%>
		
      	<!-- 表单操作 -->
        <div id="InputDetailBar">
<!--             <input type="image" src="${pageContext.request.contextPath}/css/images/save.png"/> -->
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/css/images/goBack.png"/></a>
        </div>
        </table>
    </s:form>
</div>

<div class="Description">
	说明：<br />
	1，用户的登录名要唯一，在填写时要同时检测是否可用。<br />
	2，用户登录系统后可以使用“个人设置→修改密码”功能修改密码。<br />
	3，新建用户后，会自动指定默认的头像。用户可以使用“个人设置→个人信息”功能修改自已的头像<br />
	4，修改用户信息时，登录名不可修改。
</div>

</body>
</html>

