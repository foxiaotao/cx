<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/com.jsp" %>
<html>
<head>
	<title>借阅图书</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/blue/pageCommon.css" />
</head>

<script type="text/javascript">
	$().ready(function() {
		$("#number").blur(function(){
			var bookname = $("#bookname").val();
			var number = $("#number").val();
			var bid = $("#bid").val();
			window.location.href="bookAction_borrowUIInfo.action?bookname="+bookname+"&number="+number+"&bid="+bid;
		})
	});
	$().ready(function(){
		$("#borrow").click(function(){
			$("#borrowUIForm").submit();
		});
	});
</script>

<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 借阅图书
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="bookAction_borrow.action" id="borrowUIForm" cssClass="center">
<!--     <s:hidden name="bid"></s:hidden> -->
    <table cless="center">
        <div class="ItemBlock_Title1"><!-- 信息说明 -->
       
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 借阅图书 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
<!--                     <s:textfield name="bid" id="bid"></s:textfield> -->
                    <s:hidden name="bid" id="bid"></s:hidden>
                    <s:hidden name="bookname" id="bookname"></s:hidden>
                    <tr>
                    	<td width="100">图书</td>
                    	<td>
                    		<s:property value="bookname"/>
                    	</td>
                    </tr>
                    <tr>
                    	<td width="100">借书人学号</td>
                    	<td>
                    	<s:textfield name="number" id="number" cssClass="InputStyle"/>点击输入框之外任何地方触发事件
                    	</td>
                    </tr>
                   
                   
                   <tr>
                    	<td width="100">借书人姓名</td>
                    	<td>
                    	<s:textfield name="username" id="username" readonly="true" cssClass="InputStyle"/>
                    	</td>
                    </tr>
                   <tr>
                    	<td width="100">借书人邮箱</td>
                    	<td>
                    	<s:textfield name="email" id="email" readonly="true" cssClass="InputStyle"/>
                    	</td>
                    </tr>
                   <tr>
                    	<td width="100">借书人电话</td>
                    	<td>
                    	<s:textfield name="phone" id="phone" readonly="true" cssClass="InputStyle"/>
                    	</td>
                    </tr>
                </table>
            </div>
        </div>
        
	
      	<!-- 表单操作 -->
        <div id="InputDetailBar">
<!--             <input type="image" id="save" src="${pageContext.request.contextPath}/css/images/save.png"/> -->
<!--             <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/css/images/goBack.png"/></a> -->
			<input type="button" id="borrow" value="借书">
        </div>
        </table>
    </s:form>
</div>

<div class="Description">
	说明：<br />
	1，只需要输入学号。<br/>
	2，会自动显示借阅人信息。<br/>
	3，如果不显示说明借书人信息不全，应不予借阅。没有必要的邮箱信息和手机号码<br/>
	4，点击保存即可借阅<br/>
</div>

</body>
</html>

