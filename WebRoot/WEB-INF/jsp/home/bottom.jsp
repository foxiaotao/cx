<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Bottom</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/statusbar.css" />
</head>
<body style="margin:0"> 

<div id="StatusBar">
    <div id="Online">
    	在线人员：共 <span class="OnlineUser" id="onlineUserNum">${applicationScope.onlineNum}</span> 人
        <span class="OnlineView"><a href="javascript:void(0)">[查看在线名单]</a></span>
    </div>
    <div id="Info">
    	<a href="http://www.hbmy.edu.cn/" title = "湖北名族学院首页" target="_blank">湖北名族学院首页</a> |
        <a href="http://211.67.32.144/edu/" title = "湖北民族学院教务管理系统" target="_blank">湖北民族学院教务管理系统</a> |
        <a href="http://lxykc.hbmy.edu.cn/cxzx/" title = "理学院科技实践创新中心首页" target="_blank">理学院科技实践创新中心首页</a> 
    </div>
    <div id="DesktopText">
        <a href="javascript:void(0)"><img border="0" src="${pageContext.request.contextPath}/css/images/top/text.gif"/>版权所有：孙涛 021040317 384631173@qq.com</a>
        <span id=TryoutInfo></span>
        <span id="Version">
            <a href="javascript:void(0)">
            	<img border="0" width="11" height="11" src="${pageContext.request.contextPath}/css/images/top/help.gif" /> 
                <img border="0" width="40" height="11" src="${pageContext.request.contextPath}/css/blue/images/top/version.gif" /> &nbsp; 2.0
            </a>
        </span>
    </div>
</div>
</body>
</html>
