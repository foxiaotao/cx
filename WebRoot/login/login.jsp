<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>理学院科技实践创新中心云共享系统_用户登录</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}
-->
</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
<script type="text/JavaScript">
<!--
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

$().ready(function(){
	$("#Image1").click(function(){
		$("#login_login").submit();
	});
	$("#login_password").keypress(function(e){
		var code;
		if(e.keyCode){
			code=e.keyCode;
		}
		else if(e.which){
			code   =   e.which;
		}
		if(code==13){
			$("#login_login").submit();
		}
	});
	$("#login_number").keypress(function(e){
		var code;
		if(e.keyCode){
			code=e.keyCode;
		}
		else if(e.which){
			code   =   e.which;
		}
		if(code==13){
			$("#login_login").submit();
		}
	});
});

//-->
</script>
</head>
<s:form action="loginAction_login.action" id="login_login">
<body onLoad="MM_preloadImages('${pageContext.request.contextPath}/css/login/login_09_1.gif','${pageContext.request.contextPath}/css/login/login_10_1.gif')">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#02395f">&nbsp;</td>
  </tr>
  <tr>
    <td height="607" align="center" background="${pageContext.request.contextPath}/css/login/login_02.gif"><table width="974" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="331" background="${pageContext.request.contextPath}/css/login/login_01.jpg">&nbsp;</td>
      </tr>
      <tr>
        <td height="116"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="393" height="116" background="${pageContext.request.contextPath}/css/login/login_05.gif">&nbsp;</td>
            <td width="174"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="81" background="${pageContext.request.contextPath}/css/login/login_06.gif">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    
                    <font size="2" color="red"><s:actionmessage/></font>
                  <tr>
                    <td width="24%"><div align="center"><font style="height:1;font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)">学号</font></div></td>
                    <td width="76%" height="25">
                    <input type="text" name="number" id="login_number" style="width:125px; height:20px; background:#32a2e3; font-size:12px; border:solid 1px #0468a7; color:#ffffff;"/></td>
                  </tr>
                  <tr>
                    <td><div align="center"><font style="height:1;font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)">密码</font></div></td>
                    <td height="25">
                    <input type="password" name="password" id="login_password"  style="width:125px; height:20px; background:#32a2e3; font-size:12px; border:solid 1px #0468a7; color:#ffffff;"></td>
                  </tr>
               
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="50" height="35"><img src="${pageContext.request.contextPath}/css/login/login_08.gif" width="50" height="35"></td>
                    <td width="46"><img src="${pageContext.request.contextPath}/css/login/login_09.gif" name="Image1" width="46" height="35" border="0" id="Image1" onMouseOver="MM_swapImage('Image1','','${pageContext.request.contextPath}/css/login/login_09_1.gif',1)" onMouseOut="MM_swapImgRestore()"></a></td>
                    <td width="45"><img src="${pageContext.request.contextPath}/css/login/login_10.gif" name="Image2" width="45" height="35" border="0" id="Image2" onMouseOver="MM_swapImage('Image2','','${pageContext.request.contextPath}/css/login/login_10_1.gif',1)" onMouseOut="MM_swapImgRestore()"></a></td>
                    <td width="33"><img src="${pageContext.request.contextPath}/css/login/login_11.gif" width="33" height="35"></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
            <td width="407" background="${pageContext.request.contextPath}/css/login/login_07.gif">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="160" background="${pageContext.request.contextPath}/css/login/login_12.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="#02609c">&nbsp;</td>
  </tr>

</table>

</body>

</s:form>

</html>

