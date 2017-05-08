<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
<head>
	<title>添加文件</title>
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
				this.submitHandler();
			}
			
	});
	$().ready(function() {
		$("#filesForm").validate({
			rules : {
				resource : {
					required : true,
				},
				description:{
					required:true,
					minlength:4,
				},
				department : {
					required : true,
				},
				type : {
					required : true,
				},
			},
			messages : {
				resource : {
					required:"请输选择文件",
				},
				description:{
					required:"请输入文件描述",
					minlength:"文件描述不得少于4个汉字",
				},
				type : {
					required : "请选择文件类别",
				},
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 文件信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="filesAction_addFiles.action" id="filesForm" cssClass="center" enctype="multipart/form-data">
    <table cless="center">
        <div class="ItemBlock_Title1"><!-- 信息说明 -->
       
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 文件信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
               		<tr>
                    	<td>选择文件</td>
                    	<td>
                        <s:file name="resource" id="resource" cssClass="InputStyle"/>
                        </td>
                    </tr>
                    <tr>
                    	<td width="100">文件描述</td>
                    	<td>
                    	<s:textarea name="description" id="description" cssClass="TextareaStyle"/>
                    	</td>
                    </tr>
                    <tr>
                    	<td width="100">所属部门</td>
                        <td>
                        	<s:select list="#departments" listKey="did" listValue="name" name="department.did" id="department" cssClass="SelectStyle"></s:select>
                        </td>
                    </tr>
                    <tr>
                    	<td width="100">选择文件类别</td>
                    	<td>
                    	<span cssClass="InputStyle">
                    		<s:radio list="#{'0':'个人资料','1':'共享资料'}" name="type" id="type" ></s:radio></span>
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
	1，文件上传必须选择部门。<br />
	4，文件都会经过管理员审核，请不要胡乱上传，否则必定追究到个人。<br />
	5，如果是相同的文件只是文件名不同，可实现秒传<br />
	6，普通成员都有上传和下载的权限。
</div>

</body>
</html>

