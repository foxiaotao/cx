<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
<head>
    <title>待审核文件</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery.datepick.css" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.datepick.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.datepick-zh-CN.js"></script>
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
    		$("#joindate").datepick({dateFormat: 'yy-mm-dd'}); 
    		$("#year").datepick({dateFormat: 'yy'}); 
    	});
		<%--给批量审核添加事件--%>
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 文件列表
        </div>
<!--         <div id="Title">页面标题 -->
<!--             <a href="filesAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png" /></a> -->
<!--         </div> -->
        <div id="Title_End"></div>
    </div>
</div>

<br/>

<div id="condition_query_isDislpay" style="cursor:pointer;"> <img src="${pageContext.request.contextPath}/css/images/search.png">可按以下分条件查询：隐藏/显示</div>
<s:form action="filesAction_approveUI.action" id="condition_form">
			<s:hidden name="#pageResult.url" id="action_url"></s:hidden>
 <div style="overflow:auto; height:120px; display:none;" id="condition_query">
            <table class="content" align="center">
                <tr>
                    <td class="one" style="color:#00F">文件名</td>
                    <td class="inp">
                    	<s:textfield name="filesQuery.name" cssClass="InputStyle"></s:textfield>
                    </td>
                    <td style="color:#00F">文件描述</td>
                    <td class="inp"><s:textfield name="filesQuery.description" cssClass="InputStyle"/></td>
                    <td style="color:#00F">上传时间</td>
                    <td class="inp">
                    	<s:textfield name="filesQuery.uploadtime" class="current" cssClass="InputStyle" id="joindate"/>
                    </td>
                </tr>
                <tr>
                    <td style="color:#00F">所属部门</td>
                    <td class="inp">
                    	<s:select list="#departments" listKey="did" listValue="name" name="filesQuery.department.did" cssClass="SelectStyle"></s:select>
                    </td>
                    <td style="color:#00F">所属用户学号</td>
                    <td class="inp">
                    	<s:textfield name="filesQuery.user.number" cssClass="InputStyle"></s:textfield>
                    </td>
                    <td style="color:#00F">文件类型</td>
                    <td class="inp">
                    	<s:radio list="#{'0':'个人资料','1':'共享资料'}" name="filesQuery.type" cssClass="SelectedStyle"></s:radio>
                    </td>
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
                <td width="50">
                <input type="checkbox" id="selid"><br/>
                	<a href="#" id="approveBatch">通过审核</a>
                </td>
                <td width="500px">文件名</td>
                <td width="200px">所属部门</td>
                <td>上传时间</td>
                <td>文件大小</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
	        <s:iterator value="#pageResult.rows">
	            <tr class="TableDetail1 template" align="center">
	            	
	                <td>
						<input type="checkbox" class="ids" name="fids" value="${fid}"/>	
	                </td>
	                <td><s:property value="name"/></td>
	                <td><s:property value="department.name"/></td>
	                <td><s:property value="uploadtime"/></td>
	                <td>
	                	<s:if test="length>=0 && length<1024"><s:property value="length"/> B</s:if>
						<s:if test="length>=1024 && length<1024*1024"><s:property value="length/1024"/> KB</s:if>
						<s:if test="length>=1024*1024 && length<1024*1024*1024"><s:property value="length/(1024*1024)"/> MB</s:if>
						<s:if test="length>=1024*1024*1024"><s:property value="length/(1024*1024*1024)"/> GB</s:if>
	                </td>
	                <td><s:a action="filesAction_deleteFiles.action?fid=%{fid}">删除</s:a>
	                	<s:a action="filesAction_approve.action?fids=%{fid}">通过审核</s:a>
	                	<s:a action="filesAction_download.action?fid=%{fid}">下载</s:a>
	                </td>
	            </tr>
            </s:iterator>
        </tbody>
    </table>
     <div id="TableTail">
        <div id="TableTail_inside">
				<%--    添加成员--%>
<%--            <a href="userAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png" /></a>--%>



				<%--分页信息--%>	
    			<%@ include file="/WEB-INF/jsp/page/page.jsp" %>
        </div>
    </div>
</div>
</s:form>
</body>
</html>

