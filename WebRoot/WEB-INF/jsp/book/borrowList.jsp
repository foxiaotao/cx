<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
<head>
    <title>已借出图书列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery-plugin-delete.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/pageCommon.css" />
    <script type="text/javascript">
    	$().ready(function(){
    		$.myConfirm();
    	});
    	$().ready(function(){
    		$("#condition_query_isDislpay").hover(function(){
    			$(this).css("color","red");
    		},
    		function(){
    			$(this).css("color","black");
    		});
    		$("#condition_query_isDislpay").toggle(
<%--    				第一次点击--%>
    				function(){
    					$("#condition_query").hide();
    				},
<%--    				第二次点击--%>
    				function(){
    					$("#condition_query").show();
    				});
    	});
		<%--给批量删除添加事件--%>
		$().ready(function(){
			$("#backBatch").click(function(){
				$("#condition_form").attr("action","bookAction_backBatch.action");
				$("#condition_form").submit();
	 			$("#condition_form").attr("action","bookAction_showBookByConditionBorrowed.action");
			});
		});
		<%--复选框全选事件--%>
		$().ready(function(){
			$("#selid").change(function(){
				var select = $("#selid").attr("checked");
				$("input[class='ids']").attr("checked",select);
			});
		});
		$().ready(function(){
			$("#mail").unbind();
			$("#mail").bind("click",function(){
				alert("邮件已发送");
			});
		});
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 已借出图书列表
        </div>
     
        <div id="Title_End"></div>
    </div>
</div>

<br/>

<div id="condition_query_isDislpay" style="cursor:pointer;"> <img src="${pageContext.request.contextPath}/css/images/search.png">可按以下分条件查询：隐藏/显示</div>
<s:form action="bookAction_showBookByConditionBorrowed.action" id="condition_form">
			<s:hidden name="#pageResult.url" id="action_url"></s:hidden>
 <div style="overflow:auto; height:70px; display:online;" id="condition_query">
            <table class="content" align="center">
                <tr>
                    <td class="one" style="color:#00F">图书编号</td>
                    <td class="inp">
                    	<s:textfield name="bookQuery.No" cssClass="InputStyle"></s:textfield>
                    </td>
                    <td style="color:#00F">图书名称</td>
                    <td class="inp"><s:textfield name="bookQuery.name" cssClass="InputStyle"/></td>   
                    
                    <td style="color:#00F">借阅人学号</td>
                    <td class="inp"><s:textfield name="bookQuery.user.number" cssClass="InputStyle"/></td>  
                </tr>
                <tr>
                	<td colspan="7"></td>
                    <td height="40" align="left"><input type="submit" value="查询" class="search" id="searchByCondition"/></td>
                </tr>
     </table>
</div>
<center>
	<h4>
	<a href="bookAction_sendMailBatch.action" id="mail">全部发送催还邮件</a>
	 ||--点击邮箱，可发催还邮件--||
	 <a href="bookAction_excel.action" id="excel">导出到表格文件(默认c盘)</a>
	</h4>
</center>
<%---------------list----------------%>
<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="40">
                <input type="checkbox" id="selid"><br/>
                	<a href="#" id="backBatch">还书</a>
                </td>
                <td>图书编号</td>
                <td width="300px">图书名称</td>
                <td>价格</td>
                <td>状态</td>
                
                <td>借阅人</td>
                <td width="150px">借阅人邮箱</td>
                <td>借阅时间</td>
                
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
	        <s:iterator value="#pageResult.rows">
	            <tr class="TableDetail1 template" align="center">
	            	
	                <td>
						<input type="checkbox" class="ids" name="ids" value="${bid}"/>	
	                </td>
	                <td><s:property value="No"/></td>
	                <td><s:property value="name"/></td>
	                <td><s:property value="price"/>&nbsp;元</td>
	                <td>已借出</td>
	                <td><s:property value="user.username"/></td>
	              
	              	<td>
	              		<s:a action="bookAction_sendMail.action?bid=%{bid}" id="mail">
		              		<s:property value="user.email"/>
		              	</s:a>
	              	</td>
	              	<td><s:property value="start"/></td>
	                <td>
	                	<s:a action="bookAction_backBook.action?bid=%{bid}">还书</s:a>
	                </td>
	            </tr>
            </s:iterator>
        </tbody>
    </table>
     <div id="TableTail">
        <div id="TableTail_inside">
    			<%@ include file="/WEB-INF/jsp/page/page.jsp" %>
        </div>
    </div>
</div>
</s:form>
</body>
</html>

