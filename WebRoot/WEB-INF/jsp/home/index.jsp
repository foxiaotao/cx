<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
	<head>
		<title>理学院科技实践创新中心云共享系统</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	</head>
	<frameset rows="100,*,25" framespacing="0" border="0" frameborder="0">
		<frame src="forwordAction_forword.action?method=top" name="TopMenu" scrolling="no" noresize />
		<frameset cols="250,*" id="resize">
			<frame noresize name="menu" src="forwordAction_forword.action?method=left" scrolling="yes" />
			<frame noresize name="right" src="forwordAction_forword.action?method=right" scrolling="yes" />
		</frameset>
		<frame noresize name="status_bar" scrolling="no" src="${pageContext.request.contextPath}/forwordAction_forword.action?method=bottom" />
	</frameset>
	<noframes>
		<body>
		</body>
	</noframes>
</html>
