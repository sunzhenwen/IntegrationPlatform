<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加附件信息</title>
<script type="text/javascript" src="<%=basepath%>/js/validator.js"></script>
<script type="text/javascript"
	src="<%=basepath%>/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript"
	src="<%=basepath%>/js/ckfinder/ckfinder.js"></script>
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
		document.form1.action="<%=basepath%>/accessoryAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>

<body>

	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #3874d3;">修改附件信息</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="<%=basepath%>/accessoryAction_modifyMethod.action"
				onsubmit="return validateForm()">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>附件信息序号：</td>
						<td><input type="text" maxlength='200' name="accessory.num" value = "<s:property value="accessory.num"/>"
							class="required number" /><strong><font color="#FF0000">*</font></strong>
							<input type="hidden" maxlength='200'
							name="accessory.id" class="required" value = "<s:property value="accessory.id"/>" /></td>
						
						<td>环节选择：</td>
						<td>
							<select name="accessory.linkNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="linkNames">
	          						<option value="<s:property value="code"/>"<s:if test='accessory.linkNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>
					<tr>
						<td>附件信息提示信息：</td>
						<td colspan="3"><input type="text" maxlength='200' value = "<s:property value="accessory.message"/>"
							name="accessory.message" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>
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
