<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<center>

		第${pageResult.currentPage}页/共${pageResult.totalPage}页&nbsp;&nbsp;
		<input type="button" class="condition" value="首页" param="${pageResult.currentPage}"/>&nbsp;&nbsp;
		<input type="button" class="condition" value="上一页" param="${pageResult.currentPage>1?pageResult.currentPage-1:1}">&nbsp;&nbsp;
		
		<c:forEach begin="${pageResult.startNum}" end="${pageResult.endNum}" var="v">
		&nbsp;
			<span style="cursor: pointer;" class="condition" param="${v}">${v}</span>
		</c:forEach>
		&nbsp;
		<input class="condition" type="button" value="下一页" param="${pageResult.currentPage<pageResult.totalPage?pageResult.currentPage+1:pageResult.totalPage}">&nbsp;&nbsp;
		<input class="condition" type="button" value="尾页" param="${pageResult.totalPage}">&nbsp;&nbsp;
		
		<input type="text" style="width: 40px" id="inputNum" value="${pageResult.currentPage}"/>
		<input class="condition" type="button" value="GO" id="Gobutton" param=""/>&nbsp;&nbsp;
		每页显示条数
		<input type="text" style="width: 40px" id="pageSize" value="${pageResult.pageSize}"/>
</center>

<script type="text/javascript">
	<%--将输入框中的值赋给gobutton--%>
	$().ready(function(){
		$("#inputNum").change(function(){
			var num = document.getElementById("inputNum").value;
			var maxNum = ${pageResult.totalPage};
			if(parseInt(num)==num){
				if(num>0 && num<=maxNum){
<%--					alert($(this).val())--%>
						$("#Gobutton").attr("param",$(this).val());
					}
				else if(num>maxNum){
					alert("页码不足");
					document.getElementById("inputNum").value=maxNum;
				}
				else{
					alert("页码必须为正数");
					document.getElementById("inputNum").value=${pageResult.currentPage};
				}
			}
			else{
				alert("请输入合法页数");
				document.getElementById("inputNum").value=${pageResult.currentPage};
			}
		});
		$("#pageSize").change(function(){
			var num = document.getElementById("pageSize").value;
			if(parseInt(num)==num){
				if(num<0){
					alert("请输入正数限制")
				}
			}
			else{
				alert("请输入合法页数");
				document.getElementById("pageSize").value="10";
			}
		});
	});
<%--	给分页添加鼠标进入，退出时间--%>
	$().ready(function(){
		$("span[style='cursor: pointer;']").hover(function(){
			$(this).css("color","blue");
		},function(){
			$(this).css("color","black");
		});
	});
	
	<%--给所有的分页查询添加事件--%>
	$().ready(function(){
		$("[class='condition']").unbind("click");
		$("[class='condition']").bind("click",function(){
			var currentPage = $(this).attr("param");
			var url = $("#action_url").val();
			var pageSize = $("#pageSize").val();
			$("#condition_form").attr("action",(url+"currentPage="+currentPage+"&pageSize="+pageSize));
			$("#condition_form").submit();
		});
	});
</script>