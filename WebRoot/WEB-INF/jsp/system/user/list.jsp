<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
<head>
    <title>用户列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery.datepick.css" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.datepick.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.datepick-zh-CN.js"></script>
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
    		$("#joindate").datepick({dateFormat: 'yy-mm-dd'}); 
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
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 成员管理
        </div>
        <div id="Title"><!--页面标题-->
            <a href="userAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png" /></a>
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<br/>

<div id="condition_query_isDislpay" style="cursor:pointer;"> <img src="${pageContext.request.contextPath}/css/images/search.png">可按以下分条件查询：隐藏/显示</div>
<s:form action="userAction_showUserByCondition.action" id="condition_form">
			<s:hidden name="#pageResult.url" id="action_url"></s:hidden>
 <div style="overflow:auto; height:120px; display:inline;" id="condition_query">
            <table class="content" align="center">
                <tr>
                    <td class="one" style="color:#00F">学	号</td>
                    <td class="inp">
                    	<s:textfield name="userQuery.number" cssClass="InputStyle"></s:textfield>
                    </td>
                    <td style="color:#00F">姓	名</td>
                    <td class="inp">
                    	<s:textfield name="userQuery.username" cssClass="InputStyle"></s:textfield>
                    </td>
                    <td style="color:#00F">加入中心时间</td>
                    <td class="inp">
                    	<s:textfield name="userQuery.joindate" class="current" cssClass="InputStyle" id="joindate"/>
                    </td>
                    <td class="one" style="color:#00F">入学年份</td>
                    <td class="inp"><s:textfield name="userQuery.year" class="current" cssClass="InputStyle" id="year" onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy'});"/>&nbsp;*2014 (2014级学生入学年份)</td>
                    
                </tr>
                <tr>
                    <td style="color:#00F">电	话</td>
                    <td class="inp"><s:textfield name="userQuery.phone" cssClass="InputStyle"/></td>
                    <td style="color:#00F">邮	箱</td>
                    <td class="inp"><s:textfield name="userQuery.email" cssClass="InputStyle"/></td>
                    <td style="color:#00F">所属部门</td>
                    <td class="inp">
                    	<s:select list="#departments" listKey="did" listValue="name" name="userQuery.department.did" cssClass="SelectStyle"></s:select>
                    </td>
                    <td style="color:#00F">成员类型</td>
                    <td class="inp">
                    	<s:select list="#roles" listKey="rid" listValue="name" name="userQuery.role.rid" cssClass="SelectStyle"></s:select>
                    </td>
                </tr>
<%--                <tr>--%>
<%--                    <td style="color:#00F">家庭住址</td>--%>
<%--                    <td class="inp" colspan="3"><input type="text" class="current" style="text-align:left;background:url(search_1.png) no-repeat 584px center #FFF; width:500px;"/></td>--%>
<%--                </tr>--%>
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
                <td>姓名</td>
                <td>学号</td>
                <td>密码</td>
                <td>电话</td>
                <td>邮箱</td>
                <td>性别</td>
                <td>家庭住址</td>
                <td>年龄</td>
                <td>加入中心时间</td>
                <td>入学年份</td>
                <td>所属部门</td>
                <td>角色</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
	        <s:iterator value="#pageResult.rows" status="s">
	            <tr class="${s.odd=='odd'?'TableDetail1 template':'even'}" align="center">
<!-- 	            	class="TableDetail1 template"    -->
	                <td>
						<input type="checkbox" class="ids" name="ids" value="${uid}"/>	
	                </td>
	                <td><s:property value="username"/></td>
	                <td><s:property value="number"/></td>
	                <td><s:property value="password"/></td>
	                <td><s:property value="phone"/></td>
	                <td><s:property value="email"/></td>
	                <td><s:property value="sex"/></td>
	                <td><s:property value="address"/></td>
	                <td><s:property value="age"/></td>
	                <td><s:property value="joindate"/></td>
	                <td><s:property value="year"/></td>
	                <td><s:property value="department.name"/></td>
	                <td><s:property value="role.name"/></td>
	               
	                <td>
	                    <c:if test="${role.name!='成员'}">
	                    	<c:if test="${sessionScope.user.role.name=='超级管理员'}">
	                    		<s:a action="userAction_delete.action?uid=%{uid}">删除</s:a>
	                    		<s:a action="userAction_updateUI.action?uid=%{uid}">修改</s:a>
	                    	</c:if>
	                    </c:if>
	                    <c:if test="${role.name=='成员'}">
	                    	<s:a action="userAction_delete.action?uid=%{uid}">删除</s:a>
	                    	<s:a action="userAction_updateUI.action?uid=%{uid}">修改</s:a>
	                    </c:if>
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

