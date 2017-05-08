var privilegeTree = {
		zTreePlugin:"",
		data:{
			role:{
				rid:"",
				name:""
			}
		},
		init:{
			initData:function(){
				privilegeTree.data.role.rid = $(this).parent().siblings("input[type='hidden']").val();
				privilegeTree.data.role.name = $(this).parent().siblings("td:first").text();
			},
			initEvent:function(){
				//添加点击事件
				$("a").each(function(){
					if($(this).text()=="设置权限"){
						$(this).unbind();
						$(this).bind("click",function(){
				
							//显示隐藏
							privilegeTree.opt.divOpt.showDiv();
							//给data中的role赋值
							privilegeTree.init.initData.call(this);
							//动态显示所选择的角色的名称
							privilegeTree.opt.roleOpt.showRole();
							//全选为不可用
							privilegeTree.opt.controllerAddChecked(true);
							//在书还没有加载完成的时候显示laoding
							privilegeTree.opt.controllerLoadingOrTree_show({
								loading:true
							});
							//显示树
							privilegeTree.opt.loadPrivilegeTree();
							//全选，如果全选按钮被选点击，则下面所有被选中
						});
					}
				})
				//给全选添加事件
				$("#allchecked").change(function(){
					privilegeTree.opt.allChecked.call(this);
				});
				//保存
				$("#savePrivilege").click(function(){
					privilegeTree.opt.savePrivilege();
				});
				//
			}
		},
		//所有也去操作
		opt:{
			//显示隐藏的div
			divOpt:{
				showDiv:function(){
					$("div:hidden").show();
				}
			},
			roleOpt:{
				showRole:function(){
					$("#roleImage").text("角色："+privilegeTree.data.role.name);
				}
			},
			funPrivilegeTree:{
				
				setting:{
					isSimpleData:true,
					treeNodeKey:"id",
					treeNodeParentKey:"pid",
					showLine:true,
					root:{
						isRoot:true,
						nodes:[]
					},
					checkable:true,
					callback:{
						change:function(){
							//让数据回显，在查找的数据中的checked属性做标记
							privilegeTree.opt.setAllChecked();
						}
					}
				}
			},
			loadPrivilegeTree:function(){
				$.post("privilegeAction_loadFunPrivilegeTree.action",
						{rid:privilegeTree.data.role.rid},
						function(data){
							
							//创建树
							privilegeTree.zTreePlugin = $("#privilegeTree").zTree(privilegeTree.opt.funPrivilegeTree.setting,data);
							//显示树，不显示loading
							privilegeTree.opt.controllerLoadingOrTree_show({
								loading:false
							});

							//让allcheck  可选
							privilegeTree.opt.controllerAddChecked(false);
							//让数据回显，在查找的数据中的checked属性做标记
							privilegeTree.opt.setAllChecked();
						});
			},
			controllerLoadingOrTree_show:function(json){
				if(json.loading){
					$("#loading").show();
					$("#privilegeTree").hide();
				}
				else{
					$("#loading").hide();
					$("#privilegeTree").show();
				}
			},
		
			controllerAddChecked:function(isDisable){
				$("#allchecked").attr("disabled",isDisable);
			},
			allChecked:function(){
				if($(this).attr("checked")){//this 是什么
					privilegeTree.zTreePlugin.checkAllNodes(true);
				}
				else{
					privilegeTree.zTreePlugin.checkAllNodes(false);
				}
			},
			//保存,需要有一个rids，去保存选中的rids
			savePrivilege:function(){
				var strIds='';
				var array = privilegeTree.zTreePlugin.getCheckedNodes(true);
				for(var i =0;i<array.length;i++){
					if(i>0){
						strIds=strIds+",";
					}
					strIds = strIds + array[i].id;
				};
				var parameter = {
						rid:privilegeTree.data.role.rid,
						strIds:strIds
				};
				$.post("privilegeAction_biuldRoleAndPrivilege.action",parameter,function(data){
					alert("添加成功");
				});
			},
			//小判断是否所有的tree被选中
			setAllChecked:function(){
				var unchecked = privilegeTree.zTreePlugin.getCheckedNodes(false);
				if(unchecked==0){
					//说明有为选中的
					$("#allchecked").attr("checked",true);
				}
				else{
					$("#allchecked").attr("checked",false);
				}
			}
		}
}

$().ready(function(){
	privilegeTree.init.initEvent();
})