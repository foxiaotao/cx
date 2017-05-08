<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp"%>
<html>
<head>
<title>导航菜单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/zTreeStyle/zTreeStyle.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/zTreeStyle/zTreeIcons.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ztree-2.5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/menuTree.js"></script>

</head>
<body style="margin: 0">
	<TABLE border=0 width="700">
		<TR>
			<TD width=340px align=center valign=top>
				<div class="zTreeDemoBackground">
					<ul id="menuItemTree" class="tree"></ul>
				</div>
				<div id="msg" align="left"></div>
			</TD>
		</TR>
	</TABLE>
</body>
</html>