var menuTree = {
		setting:{
			isSimpleData:true,
			treeNodeKey:"id",
			treeNodeParentKey:"pid",
			showLine:true,
			root:{
				isRoot:true,
				nodes:[]
			},
			url:"",
			target:'',
			callback:{
				change:function(){
					//设置默认的全选狂的值
					
				}
			}
		},
		loadMenuTree:function(){
			$.post("privilegeAction_showPrivilegeByUserLogin.action",null,function(data){
				$("#menuItemTree").zTree(menuTree.setting,data);
			});
		}
}

$().ready(function(){
	menuTree.loadMenuTree();
});