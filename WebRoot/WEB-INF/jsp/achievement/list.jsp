<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
<head>
    <title>成果列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery-plugin-delete.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/pageCommon.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datepicker/WdatePicker.js"></script>
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
// 				alert(select)
				$("[class='ids']").attr("checked",select);
			});
		});
		$().ready(function(){
			$("#look_").unbind();
			$("#look_").bind("click",function(){
				var path = $(this).attr("url");
// 				alert(path);
				window.open(path);
			});
		});
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 成果列表
        </div>
        <div id="Title"><!--页面标题-->
            <a href="achievementAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png" /></a>
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<br/>

<div id="condition_query_isDislpay" style="cursor:pointer;"> <img src="${pageContext.request.contextPath}/css/images/search.png">可按以下分条件查询：隐藏/显示</div>
<s:form action="achievementAction_showAchievementByPage.action" id="condition_form">
			<s:hidden name="#pageResult.url" id="action_url"></s:hidden>
 <div style="overflow:auto; height:120px; display:inline;" id="condition_query">
            <table class="content" align="center">
                <tr>
                    <td class="one" style="color:#00F">成果年份</td>
                    <td class="inp">
                    	<s:textfield name="achievementQuery.year" cssClass="InputStyle" onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy'});"></s:textfield>
                    </td>
                    <td style="color:#00F">成果编号</td>
                    <td class="inp">
                    	<s:textfield name="achievementQuery.No" cssClass="InputStyle"></s:textfield>
                    </td>
                    
                    <td style="color:#00F">成果名称</td>
                    <td class="inp">
                    	<s:textfield name="achievementQuery.name" cssClass="InputStyle"></s:textfield>
                    </td>
                </tr>
                <tr>
                    <td style="color:#00F">成员</td>
                    <td class="inp"><s:textfield name="achievementQuery.members" cssClass="InputStyle"/></td>
                    
                    <td style="color:#00F">状态</td>
                    <td class="inp">
                    	<s:select list="#{'':'全部','0':'专利','1':'论文','2':'竞赛','3':'软件'}" name="achievementQuery.type" cssClass="SelectStyle"></s:select>
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
                <td width="40">
                <input type="checkbox" id="selid"><br/>
                	<a href="#" id="deleteBatch">删除</a>
                </td>
                <td>成果年份</td>
                <td>成果名称</td>
                <td>成果成员</td>
                <td>成果类型</td>
                <td>佐证材料</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="achievementList">
	        <s:iterator value="#pageResult.rows" status="s">
	            <tr class="${s.odd=='odd'?'TableDetail1 template':'even'}" align="center">
	            	
	                <td>
						<input type="checkbox" class="ids" name="ids" value="${aid}"/>	
	                </td>
	                <td><s:property value="year"/></td>
	                <td width="450px"><s:property value="name"/></td>
	                <td width="250px"><s:property value="members"/></td>
	                <td>
	                	<c:if test="${type=='0'}">专利</c:if>
	                	<c:if test="${type=='1'}">论文</c:if>
	                	<c:if test="${type=='2'}">竞赛</c:if>
	                	<c:if test="${type=='3'}">软件</c:if>
	                </td>
	                <td>
	                    <s:a action="achievementAction_download.action?aid=%{aid}">下载</s:a>
	                    <a href="#">查看</a>
<!-- 	                    <a href="#" id="look_" url="${pageContext.request.contextPath}/${contextPath}">查看</a> -->
	                </td>
	                
	                <td>
	                	<s:a action="achievementAction_delete.action?aid=%{aid}">删除</s:a>
	                    <s:a action="achievementAction_updateUI.action?aid=%{aid}">修改</s:a>
	                </td>
	            </tr>
            </s:iterator>
        </tbody>
    </table>
     <div id="TableTail">
        <div id="TableTail_inside">
				<%--分页信息--%>	
    			<%@ include file="/WEB-INF/jsp/page/page.jsp" %>
        </div>
    </div>
</div>
</s:form>
</body>
</html>

