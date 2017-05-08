(function($){
	$.fn.TreePanel = {
			zTreePlugin:'',
			defaults:{
				treeid:'',
				ajax:{
					url:'',
					data:null
				},
				setting:{
					isSimpleData:true,
					treeNodeKey:'id',
					treeNodeParentKey:'pid',
					showLine:true,
					root:{
						isRoot:true,
						nodes:[]
					}
				}
			},
			//创建树
			createTree:function(config){
				var myconfig = {};
				//覆盖需要改变的默认值，true表示深度遍历
				$.extend(true,myconfig,$.fn.TreePanel.defaults,config);
				$.myPost({
					url:myconfig.ajax.url,
					data:myconfig.ajax.data,
					callback:function(data1){
						$.fn.TreePanel.zTreePlugin = $("#"+myconfig.treeid).zTree(myconfig.setting,data1);
					}
				});
			},
	};
})($);