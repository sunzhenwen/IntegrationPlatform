<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改发布信息</title>
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
		document.form1.action="<%=basepath%>/announceAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>

<body>

	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #3874d3;">修改发布信息</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="<%=basepath%>/announceAction_modifyAction.action"
				onsubmit="return validateForm()">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>发布信息标题：</td>
						<td>
							<input type="text" maxlength='200'
							name="announce.title" class="required" value = "<s:property value="announce.title"/>" /><strong><font
								color="#FF0000">*</font></strong>
							<input type="hidden" maxlength='200'
							name="announce.announceId" class="required" value = "<s:property value="announce.announceId"/>" />
							<input type="hidden" id="mes"  name="announce.message"  value = "<s:property value="announce.message"/>" />
								
						</td>

						<td>发布信息类型：</td>
						<td><select name="announce.type">
								<option value="">请选择</option>
								<option value="1" <s:if test='announce.type==0'>selected</s:if>>文件通知</option>
								<option value="2" <s:if test='announce.type==1'>selected</s:if>>公示</option>
								<option value="3" <s:if test='announce.type==2'>selected</s:if>>公告</option>
								<option value="4" <s:if test='announce.type==3'>selected</s:if>>延续通知</option>
								<option value="5" <s:if test='announce.type==4'>selected</s:if>>行政处罚</option>
								<option value="6" <s:if test='announce.type==5'>selected</s:if>>行政处理</option>
								<option value="7" <s:if test='announce.type==6'>selected</s:if>>通报</option>
								<option value="8" <s:if test='announce.type==7'>selected</s:if>>法律</option>
								<option value="9" <s:if test='announce.type==8'>selected</s:if>>法规</option>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>

					<tr>
						<td>发布信息所在网址：</td>
						<td><input type="text" maxlength='100' name="announce.url" value = "<s:property value="announce.url"/>"/></td>

						<td>是否发布：</td>
						<td><select name="announce.isPublish">
								<option value="">请选择</option>
								<option value="0" <s:if test='announce.isPublish==0'>selected</s:if>>未发布</option>
								<option value="1" <s:if test='announce.isPublish==1'>selected</s:if>>已发布</option>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td colspan="4">
											<!-- 加载编辑器的容器 -->
				<script id="container" name="announce.conMessage"  type="text/plain">

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
					//对编辑器的操作最好在编辑器ready之后再做
					ue.ready(function() {
				    //设置编辑器的内容
				    var message = document.getElementById("mes").value
				    ue.setContent(message);
				    //获取html内容，返回: <p>hello</p>
				    var html = ue.getContent();
				    //获取纯文本内容，返回: hello
				    var txt = ue.getContentTxt();
				});
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
