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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript">
    </script>
</head>

<script type="text/javascript">
	$.validator.setDefaults({
		submitHandler: function() { 
<%--			alert("submitted!"); --%>
				this.submitHandler();
			}
	});
 	$().ready(function(){
		$("#joindate").datepick({dateFormat: 'yy-mm-dd'}); 
		$("#year").datepick({dateFormat: 'yy'}); 
	});
	$().ready(function() {
		$("#userForm").validate({
			rules : {
				username : {
					required : true,
					minlength : 2,
					maxlength:10
				},
				sex:'required',
				phone : {
					required : true,
					digits : true,
					minlength:11,
					maxlength:11
				},
				address:{
					required:true,
					minlength:4
				},
				age:{
					required:true,
					digits : true,
					minlength:2,
				},
				year:{
					required:true,
					digits : true,
					minlength:4,
					maxlength:4
				}
	
			},
			messages : {
				username : {
					required:"请输入姓名",
					minlength:"姓名不得少于两个汉字",
					maxlength:"姓名不得长于10个汉字"
				},
				email : {
					required : "请输入邮箱",
					email : "请输入正确的邮箱"
				},
				phone : {
					required : "请输入电话号码",
					digits:"必须输入数字",
					minlength:"电话必须为11为数字",
					maxlength:"电话必须为11为数字",
				},
				address:{
					required:"请输入家庭地址",
					minlength:"地址长度不能小于4个汉字",
				},
				age:{
					required:"请输入年龄",
					digits : "必须输入数字",
					minlength:"年龄长度不能小于2个数字",
				},
				year:{
					required:"请输入入学年份",
					digits :"入学年份输入必须是数字",
					minlength:"入学年份输入必须是 4 个数字",
					maxlength:"入学年份输入必须是 4 个数字",
				}
			}
		});
	});
</script>

<style type="text/css">

<%--#userForm { width: 100%; }--%>
#userForm label.error {
	margin-left: 10px;
	width: auto;
	display: inline;
}

</style>




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
    <s:form action="userAction_updateInfo.action" id="userForm" cssClass="center">
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
                    	<s:textfield name="username" id="username" cssClass="InputStyle" readonly="true"/>
                    	</td>
                    </tr>
                    <tr>
	                    <td width="100">电话</td>
	                    <td>
	                    <s:textfield name="phone" id="phone" cssClass="InputStyle"/>
	                    </td>
                    </tr>
                    <tr>
	                    <td width="100">E-mail</td>
	                    <td>
	                    <s:textfield name="email" id="email" cssClass="InputStyle"/>
	                    </td>
                    </tr>
                    <tr>
                    	<td width="100">性别</td>
                    	<td>
                    	<span cssClass="InputStyle">
                    		<s:radio list="{'男','女'}" name="sex" id="sex"></s:radio></span>
						</td>
					</tr>
                    <tr>
                    	<td>家庭住址</td>
	                     <td>
	                    	<s:textfield name="address" id="address" cssClass="InputStyle"/>
                    	</td>
<%--                        <td><input type="text" name="loginName" class="InputStyle"/> *</td>--%>
                    </tr>
					<tr><td>年龄</td>
					<td>
                        <s:textfield name="age" id="age" cssClass="InputStyle"/>
                        </td>
                    </tr>
                    <tr>
                    	<td>入学年份</td>
                    	<td>
                        <s:textfield name="year" id="year" readonly="true" cssClass="InputStyle" onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy'});"/>
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
            <input type="image" src="${pageContext.request.contextPath}/css/images/save.png"/>
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

