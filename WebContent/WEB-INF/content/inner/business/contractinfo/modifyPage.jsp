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
		document.form1.action="<%=basepath%>/contractInfoAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>

<body>

	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #3874d3;">修改合同信息</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="<%=basepath%>/contractInfoAction_modifyMethod.action"
				onsubmit="return validateForm()">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>名称：</td>
						<td>
							<input type="text" maxlength='200'
							name="contract.conName" class="required" value = "<s:property value="contract.conName"/>" /><strong><font
								color="#FF0000">*</font></strong>
							<input type="hidden"  name="contract.conID"  value = "<s:property value="contract.conID"/>" />
							<input type="hidden" id="mes"  name="mes"  value = "<s:property value="contract.conMessage"/>" />
						</td>

						<td>合同类型：</td>
						<td><select name="contract.conType">
								<option value="">请选择</option>
								<option value="1" <s:if test='contract.conType==1'>selected</s:if>>建设工程施工合同（发改法规[2011]3018号）</option>
								<option value="2" <s:if test='contract.conType==2'>selected</s:if>>建设工程施工合同（建市[2010]88号）</option>
								<option value="3" <s:if test='contract.conType==3'>selected</s:if>>黑龙江省建设工程施工专业分包合同</option>
								<option value="4" <s:if test='contract.conType==4'>selected</s:if>>黑龙江省建设工程施工劳务分包合同</option>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>排序:</td>
						<td>
							<select name="contract.pNumber">
							<option value="">请选择</option>
							<option value="1" <s:if test='contract.pNumber==1'>selected</s:if>>1</option>
							<option value="2" <s:if test='contract.pNumber==2'>selected</s:if>>2</option>
							<option value="3" <s:if test='contract.pNumber==3'>selected</s:if>>3</option>
							<option value="4" <s:if test='contract.pNumber==4'>selected</s:if>>4</option>
							<option value="5" <s:if test='contract.pNumber==5'>selected</s:if>>5</option>
							<option value="6" <s:if test='contract.pNumber==6'>selected</s:if>>6</option>
							<option value="7" <s:if test='contract.pNumber==7'>selected</s:if>>7</option>
							<option value="8" <s:if test='contract.pNumber==8'>selected</s:if>>8</option>
							<option value="9" <s:if test='contract.pNumber==9'>selected</s:if>>9</option>
							<option value="10" <s:if test='contract.pNumber==10'>selected</s:if>>10</option>
							<option value="11" <s:if test='contract.pNumber==11'>selected</s:if>>11</option>
							<option value="12" <s:if test='contract.pNumber==12'>selected</s:if>>12</option>
							<option value="13" <s:if test='contract.pNumber==13'>selected</s:if>>13</option>
							<option value="14" <s:if test='contract.pNumber==14'>selected</s:if>>14</option>
							<option value="15" <s:if test='contract.pNumber==15'>selected</s:if>>15</option>
							</select>
						</td>
						<td>是否通用:</td>
						<td>
							<select name="contract.inCommon">
							<option value="">请选择</option>
							<option value="0" <s:if test='contract.inCommon==0'>selected</s:if>>通用</option>
							<option value="1" <s:if test='contract.inCommon==1'>selected</s:if>>非通用</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="4">
				<!-- 加载编辑器的容器 -->
				<script id="container" name="contract.conMessage"  type="text/plain">

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
