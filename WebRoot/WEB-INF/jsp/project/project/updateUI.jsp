<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
<head>
	<title>修改项目</title>
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
	$.validator.setDefaults({
		submitHandler: function() { 
<%--			alert("submitted!"); --%>
				this.submitHandler();
			}
	});
	$().ready(function(){
<%--		时间日期选择--%>
		$("#start").datepick({dateFormat: 'yy-mm-dd'}); 
	});
	$().ready(function() {
		$("#projectForm").validate({
			rules : {
				No : {
					required : true,
					minlength : 2,
				},
				name:{
					required:true,
					minlength:2
				},
				members : {
					required : true,
					minlength : 2
				},
				statue : {
					required : true
				},
				start:{
					requiered:true,
				}
			},
			messages : {
				name : {
					required:"请输入名称",
					minlength:"名称不得少于两个汉字"
				},
				No:{
					required:"请输入项目编号",
					minlength:"项目编号不得少于2字符",
				},
				members : {
					required : "请输入成员",
					minlength : "成员长度不能少于2个字符"
				},
				statue : {
					required : "请输入状态"
				},
				start:{
					required:"请输入立项时间",
				}
			}
		});
	});
</script>

<style type="text/css">

<%--#projectForm { width: 100%; }--%>
#projectForm label.error {
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 项目信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="projectAction_update.action" id="projectForm" cssClass="center">
    <s:hidden name="pid"></s:hidden>
    <table cless="center">
        <div class="ItemBlock_Title1"><!-- 信息说明 -->
       
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 项目信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                    	<td width="100">项目编号</td>
                    	<td>
                    	<s:textfield name="No" id="No" cssClass="InputStyle"/>
                    	</td>
                    </tr>
                    <tr>
                    	<td width="100">项目名称</td>
                    	<td>
                    	<s:textfield name="name" id="name" cssClass="InputStyle"/>
                    	</td>
                    </tr>
                    <tr>
                    	<td width="100">成员</td>
                    	<td>
                    	<s:textfield name="members" id="members" cssClass="InputStyle"/>
                    	</td>
                    </tr>
                    <tr>
                    	<td width="100">状态</td>
                    	<td>
                    		<s:select list="#{'0':'立项','1':'中期检查','2':'结题'}" name="statue" cssClass="SelectStyle"></s:select>
                    	</td>	
                    </tr>
                    <tr>
	                    <td>等级</td>
	                    <td class="inp">
	                    	<s:select list="#{'0':'校级','1':'省级','2':'国家'}" name="type" id="type" cssClass="SelectStyle"></s:select>
	                    </td>
                    </tr>
                    <tr>
                    	<td>立项时间</td>
                    	<td>
                        <s:textfield name="start" id="start" readonly="true" cssClass="InputStyle"/>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        
		
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
	1，项目标号要唯一，在填写时要同时检测是否可用。<br />
	2，状态  新添加默认状态0，  立项：0 | 中期检查：1 | 结题 2<br />
</div>

</body>
</html>

