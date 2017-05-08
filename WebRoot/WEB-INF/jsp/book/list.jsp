<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
<head>
    <title>图书列表</title>
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
    					$("#condition_query").show();
    				},
<%--    				第二次点击--%>
    				function(){
    					$("#condition_query").hide();
    				});
    	});
		<%--给批量删除添加事件--%>
		$().ready(function(){
			$("#deleteBatch").click(function(){
				var sure = window.confirm("是否批量删除，你的操作请慎重");
				if(sure){
					$("#condition_form").attr("action","projectAction_deleteBatch.action");
					$("#condition_form").submit();
		 			$("#condition_form").attr("action","projectAction_showProjectByPage.action");
				}
			});
		});
		<%--复选框全选事件--%>
		$().ready(function(){
			$("#selid").change(function(){
				var select = $("#selid").attr("checked");
				$("input[class='ids']").attr("checked",select);
			});
		});
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 图书列表
        </div>
        <div id="Title"><!--页面标题-->
            <a href="bookAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png" /></a>
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<br/>

<div id="condition_query_isDislpay" style="cursor:pointer;"> <img src="${pageContext.request.contextPath}/css/images/search.png">可按以下分条件查询：隐藏/显示</div>
<s:form action="bookAction_showBookByCondition.action" id="condition_form">
			<s:hidden name="#pageResult.url" id="action_url"></s:hidden>
 <div style="overflow:auto; height:80px; display:none;" id="condition_query">
            <table class="content" align="center">
                <tr>
                    <td class="one" style="color:#00F">图书编号</td>
                    <td class="inp">
                    	<s:textfield name="bookQuery.No" cssClass="InputStyle"></s:textfield>
                    </td>
                    <td style="color:#00F">图书名称</td>
                    <td class="inp"><s:textfield name="bookQuery.name" cssClass="InputStyle"/></td>   
                </tr>
                <tr>
                	<td colspan="7"></td>
                    <td height="40" align="left"><input type="submit" value="查询" class="search" id="searchByCondition"/></td>
                </tr>
     </table>
</div>



<%---------------list----------------%>
<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="40">
                <input type="checkbox" id="selid"><br/>
                	<a href="#" id="deleteBatch">删除</a>
                </td>
                <td>图书编号</td>
                <td width="500px">图书名称</td>
                <td>价格</td>
                <td>状态</td>
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
	                <td>
	                	<c:if test="${statue=='1'}">已借出</c:if>
	                	<c:if test="${statue=='0'}">库存</c:if>
	                </td>
	              
	                <td><s:a action="bookAction_delete.action?bid=%{bid}">删除</s:a>
	                    <s:a action="bookAction_updateUI.action?bid=%{bid}">修改</s:a>
	                    <c:if test="${statue=='0'}">
	                		<s:a action="bookAction_borrowUI.action?bid=%{bid}">借书</s:a>
                		</c:if>
                		<c:if test="${statue=='1'}">
	                		<s:a action="bookAction_back.action?bid=%{bid}">还书</s:a>
                		</c:if>
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

