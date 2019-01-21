
$(function(){
	//创建欢迎页面
	$("#mytabs").tabs("add",{
		title:"首页",
		closable:true,
		border:0,
		//设置ifram的内容
		content:"<iframe  src='welcome'  style='width:100%;height:100%;'  frameborder='0' ></iframe>"
	});
	
	$("#mytree").tree({
		url:'/js/data/tree.json',
		onClick:function(node){
			//得到当前的node的对象的文本.
			    var  text = node.text;
			//判断这个标签是不是已经存在了.
			var   exist =  $("#mytabs").tabs("exists",text);
			if(exist){
				//假如已经存在,那么,选中.
				$("#mytabs").tabs("select",text);
			}else{
				
				if(node.attributes.url=="menu"){
					window.open(node.attributes.url,false);
					return;
				}
				if(!node.attributes.url){
					return;
				}
				
				//假如不存在,那么创建新的
				$("#mytabs").tabs("add",{
					title:text,
					closable:true,
					border:0,
					//设置ifram的内容
					/*href:node.attributes.url*/
					content:"<iframe  src='"+node.attributes.url+"'  style='width:100%;height:100%;'  frameborder='0' ></iframe>"
				});
			}
		}
	})
	})