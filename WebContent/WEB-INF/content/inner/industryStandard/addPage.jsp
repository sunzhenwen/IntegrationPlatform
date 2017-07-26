<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv=X-UA-Compatible content=IE=EmulateIE7>
<title>增加发布信息</title>
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
		document.form1.action="<%=basepath%>/industryStandardAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>

<body>

	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #3874d3;">新增行业标准</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="<%=basepath%>/industryStandardAction_add.action"
				onsubmit="return validateForm()">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>发布信息标题：</td>
						<td colspan="3">
						<input type="text" size="50" maxlength='200' name="industryStandard.title"
							class="required" /></td>
					
					</tr>

					<tr>
						<td>行业标准类型：</td>
						<td>
						<select name="industryStandard.isType" class="required">
    						<option value="">请选择</option>
      						<s:iterator value="isTypes">
          						<option value="<s:property value="code"/>"<s:if test='industryStandard.isType==code'>selected</s:if>><s:property value="name"/></option>
      						</s:iterator>
						</select>
						</td>

						<td>是否发布：</td>
						<td>
						<select name="industryStandard.isPublish" class="required">
    						<option value="">请选择</option>
      						<s:iterator value="isPublishs">
          						<option value="<s:property value="code"/>"<s:if test='industryStandard.isPublish==code'>selected</s:if>><s:property value="name"/></option>
      						</s:iterator>
						</select>
						</td>
					</tr>
					
					<tr>
						<td colspan="4">
							<!-- 加载编辑器的容器 -->
				<script id="container" name="industryStandard.message" type="text/plain">

   						 </script>
				<!-- 配置文件 -->
				<script type="text/javascript"
					src="<%=basepath%>/js/utf8-jsp/ueditor.config.js"></script>
				<!-- 编辑器源码文件 -->
				<script type="text/javascript"
					src="<%=basepath%>/js/utf8-jsp/ueditor.all.js"></script>
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
