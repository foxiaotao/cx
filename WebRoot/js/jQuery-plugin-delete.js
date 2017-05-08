(function(jQuery){
	jQuery.myConfirm=function(){
		$("a").each(function(){
			if($(this).text()=="删除"){
				$(this).unbind("click");
				$(this).bind("click",function(){
					return window.confirm("您确定要删除吗 ?");
				});
			}
		});
	};
})(jQuery);