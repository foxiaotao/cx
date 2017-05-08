<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Top</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/top.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
</head>
<script type="text/javascript">
		$().ready(function(){
			initdate();
			window.setInterval("walking()",1000);
		});
		function initdate(){
			var now = new Date();
			
			$("#taday_date_time").text(now.toLocaleString());
		}
		function walking(){
			var now = new Date();
			$("#taday_date_time").text(now.toLocaleString());
		}
</script>
<body class="PageBody" style="margin: 0">
 
	<div id="Head1">
		<div id="Logo">
			<a id="msgLink" href="javascript:void(0)"></a>
            <font color="#0000CC" style="color:#F1F9FE; font-size:30px; font-family:Arial Black, Arial">理学院科技实践创新中心共享系统</font> 
			<!--<img border="0" src="${pageContext.request.contextPath}/css/blue/images/logo.png" />-->
        </div>
		
		<div id="Head1Right">
			<div id="Head1Right_UserName">
                <img border="0" width="13" height="14" src="${pageContext.request.contextPath}/css/images/top/user.gif" /> 您好: <b>${sessionScope.user.username}</b>
                <b>${sessionScope.user.role.name}</b>
			</div>
			<div id="Head1Right_UserDept"></div>
			<div id="Head1Right_UserSetup">
<!--             	<a href="javascript:void(0)"> -->
<!-- 					<img border="0" width="13" height="14" src="${pageContext.request.contextPath}/css/images/top/user_setup.gif" /> 个人设置 -->
<!-- 				</a> -->
			</div>
			<div id="Head1Right_Time"></div>
		</div>
		
        <div id="Head1Right_SystemButton">
<!--             <a target="_parent" href="System_User/logout.html"> -->
<!-- 				<img width="78" height="20" alt="退出系统" src="${pageContext.request.contextPath}/css/blue/images/top/logout.gif" /> -->
<!-- 			</a> -->
        </div>

	</div>
    
    <div id="Head2">
        <div id="Head2_Awoke">
            <ul id="AwokeNum">
                <li><a target="desktop" href="javascript:void(0)">
						<img border="0" width="11" height="13" src="${pageContext.request.contextPath}/css/images/top/msg.gif" /> 消息
						<span id="msg"></span>
					</a>
				</li>
                <li class="Line"></li>
                <li><a target="desktop" href="javascript:void(0)">
						<img border="0" width="16" height="11" src="${pageContext.request.contextPath}/css/images/top/mail.gif" /> 邮件
						<span id="mail"></span>
					</a>
				</li>
                <li class="Line"></li>
				  <!-- 是否有待审批文档的提示1，数量 -->
               <%--  <li><a href="Flow_Formflow/myTaskList.html" target="desktop">
                		<img border="0" width="12" height="14" src="${pageContext.request.contextPath}/css/images/top/wait.gif" /> 
                		待办事项（<span id="wait" class="taskListSize">1</span>）
                	</a>
                </li> --%>
				  
                <!-- 是否有待审批文档的提示2，提示审批 -->
                <li id="messageArea"><li id="messageArea">今天是：<span id="taday_date_time"></span>&nbsp;&nbsp;&nbsp;&nbsp;<span>您的IP：${sessionScope.visiterAddr}</span></li></li>
            </ul>
        </div>
        
		<div id="Head2_FunctionList">
			<marquee style="WIDTH: 100%;" onMouseOver="this.stop()" onMouseOut="this.start()" 
				scrollamount=1 scrolldelay=30 direction=left>
				<b>理学院科技创新中心欢迎您！</b>
			</marquee>
		</div>
	</div>

</body>
</html>
