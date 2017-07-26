<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" >
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

	//导入数据
	function leadingIn()
	{
		$(document).ready(function(){
			$.ajax({
				url: "otherConstructorAction_leadingIn.action",
				type: 'post',
                dataType: 'json',
                beforeSend:function() {
					 $("#jiazai").append('<img src="<%=basepath %>/images/jiazai.gif" />');
				},  
			   	success: function(data) {
			   		if(data=="1")
			   		{
			   			window.location.href = "<%=basepath %>/otherConstructorAction_queryPage.action";
			   		}else
			   		{
			   			alert("数据导入失败!");
			   			window.location.href = "<%=basepath %>/otherConstructorAction_queryPage.action";
			   		}
			   	},  
			   	error: function(data) {
			   		//失败
			   		alert("数据导入失败!");
			   		window.location.href = "<%=basepath %>/otherConstructorAction_queryPage.action";
			   	}
			});
		});
	}

</script>
</head>

<body onload="leadingIn()">
	
	<div class="ry_wrapp">
		<div class="head">
			<div class="head_a1">
				<p class="logo">
					<img src="images/lg.png">
				</p>
				<div class="head_a3">
					<div class="header-search">
					</div>
				</div>
			</div>
		</div>
		<div class="wz">
			<dl>
				<dt>当前位置：外省企业备案</dt>
			</dl>
		</div>
	</div>
	<div id="jiazai">
	</div>
	<form id="form1" name="form1" method="post" action="">
	</form>
	<%@include file="/WEB-INF/content/outside/footer.jsp"%>

</body>
</html>
