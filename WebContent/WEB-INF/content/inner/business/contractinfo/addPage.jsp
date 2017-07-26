<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加发布信息</title>
<script type="text/javascript" src="<%=basepath%>/js/validator.js"></script>
<script type="text/javascript">
	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            form.submit();
	        }    
	 	});
	}); 
	
	//取消
	function goBack()
	{
		document.form1.action="<%=basepath%>/contractInfoAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>

<body>

	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #3874d3;">合同发布</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="<%=basepath%>/contractInfoAction_addMethod.action"
				onsubmit="return validateForm()">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>名称：</td>
						<td><input type="text" maxlength='200'
							name="contract.conName" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>

						<td>合同类型：</td>
						<td><select name="contract.conType">
								<option value="">请选择</option>
								<option value="1">建设工程施工合同（发改法规[2011]3018号）</option>
								<option value="2">建设工程施工合同（建市[2010]88号）</option>
								<option value="3">黑龙江省建设工程施工专业分包合同</option>
								<option value="4">黑龙江省建设工程施工劳务分包合同</option>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>排序：</td>
						<td>
							<select name="contract.pNumber">
								<option value="">请选择</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								</select><strong><font color="#FF0000">*</font></strong>
						</td>
						<td>是否通用：</td>
						<td>
							<select name="contract.inCommon">
								<option value="">请选择</option>
								<option value="0">通用</option>
								<option value="1">非通用</option>
								</select><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>
					<tr>
						<td colspan="4">
						<!-- 加载编辑器的容器 -->
				<script id="container" name="contract.conMessage" type="text/plain">

   						 </script>
				<!-- 配置文件 -->
				<script type="text/javascript"
					src="<%=basepath%>/js/ueditor/ueditor.config.js"></script>
				<!-- 编辑器源码文件 -->
				<script type="text/javascript"
					src="<%=basepath%>/js/ueditor/ueditor.all.js"></script>
				<!-- 实例化编辑器 -->
				<script type="text/javascript">
					var ue = UE.getEditor('container');
				</script>
						</td>
					</tr>
				</table>
				
				<div class="sp_bton">
					<input type="image" src="<%=basepath%>/images/baocun.jpg" /> <input
						type="image" onclick="goBack()"
						src="<%=basepath%>/images/quxiao.jpg" />
				</div>
			</form>
		</div>
	</div>

</body>
</html>
