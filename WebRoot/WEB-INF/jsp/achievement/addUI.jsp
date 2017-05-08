<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
<head>
	<title>添加成果</title>
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
	$().ready(function() {
		$("#achievementForm").validate({
			rules : {
				
				name:{
					required:true,
					minlength:2
				},
				members : {
					required : true,
					minlength : 2
				},
				type : {
					required : true
				},
				year:{
					requiered:true,
				}
			},
			messages : {
				name : {
					required:"请输入名称",
					minlength:"名称不得少于两个汉字"
				},
				members : {
					required : "请输入成员",
					minlength : "成员长度不能少于2个字符"
				},
				type : {
					required : "请输入成果类型"
				},
				year:{
					required:"请输入成果时间",
				}
			}
		});
	});
</script>

<style type="text/css">

<%--#achievementForm { width: 100%; }--%>
#achievementForm label.error {
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 成果信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="achievementAction_add.action" id="achievementForm" cssClass="center" enctype="multipart/form-data">
    <table cless="center">
        <div class="ItemBlock_Title1"><!-- 信息说明 -->
       
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 项目信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                    	<td width="100">成果名称</td>
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
                    	<td width="100">类型</td>
                    	<td>
                    		<s:select list="#{'':'请选择','0':'专利','1':'论文','2':'竞赛','3':'软件'}" name="type" cssClass="SelectStyle"></s:select>
                    	</td>	
                    </tr>
                    <tr>
                    	<td>添加佐证材料</td>
                    	<td>
                        	<s:file name="resource"  cssClass="InputStyle"></s:file>
                        </td>
                    </tr>
                    <tr>
                    	<td>成果年份</td>
                    	<td>
                        <s:textfield name="year" id="year" readonly="true" cssClass="InputStyle" onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy'});"/>
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

