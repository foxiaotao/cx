<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
<head>
	<title>修改图书</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/pageCommon.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/validation/screen.css" />
	<script src="${pageContext.request.contextPath}/js/jquery.validate.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/localization/messages_zh.js" type="text/javascript"></script>
</head>

<script type="text/javascript">
	$.validator.setDefaults({
		submitHandler: function() { 
<%--			alert("submitted!"); --%>
				this.submitHandler();
			}
	});
	
	$().ready(function() {
		$("#bookForm").validate({
			rules : {
				name : {
					required : true,
					minlength : 2,
				},
				No : {
					required : true,
					minlength : 5
				},
				price : {
					required : true,
				},
			},
			messages : {
				name : {
					required:"请输入名称",
					minlength:"名称不得少于两个汉字",
				},
				No:{
					required:"请输入编号",
					minlength : "编号长度不能少于5个字符"
				},
				price : {
					required : "请输入单价",
				}
			}
		});
	});
</script>

<style type="text/css">

<%--#bookForm { width: 100%; }--%>
#bookForm label.error {
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 修改图书
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="bookAction_update.action" id="bookForm" cssClass="center">
    <table cless="center">
        <div class="ItemBlock_Title1"><!-- 信息说明 -->
       
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 修改图书 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                <s:hidden name="bid"></s:hidden>
                    <tr>
                    	<td width="100">图书编号</td>
                    	<td>
                    	<s:textfield name="No" id="No" cssClass="InputStyle"/>
                    	</td>
                    </tr>
                    <tr>
                    	<td width="100">图书名称</td>
                    	<td>
                    	<s:textfield name="name" id="name" cssClass="InputStyle"/>
                    	</td>
                    </tr>
                    <tr>
                    	<td width="100">价格</td>
                    	<td>
                    	<s:textfield name="price" id="price" cssClass="InputStyle"/>
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
	1，图书编号要唯一。<br/>
	2，添加每个都必须填写。<br/>
</div>

</body>
</html>

