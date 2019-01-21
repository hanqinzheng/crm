$(function(){
	$("#resetValue").click(function(){
		$(":input[name]").val("");
	})
	$("#submitForm").click(function(){
		$.ajax({
			   type: "POST",
			   url: "/login",
			   data: $("form").serialize(),
			   success: function(json){
				   if(json.success){
					   window.location.href="/index";
				   }else{
					   alert(json.msg);
				   }
			   }
			});		
	})
	$(document).keyup(function(){
		if(event.keyCode==13){
			$("#submitForm").click();
		}
	});
})
