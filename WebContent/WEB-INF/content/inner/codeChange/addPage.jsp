<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>组织机构代码变更</title>
<script type="text/javascript" src="<%=basepath%>/js/validator.js"></script>
<script type="text/javascript">
	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	 			var corpName = $("#corpName").val();
	 			if(corpName=="")
	 			{
	 				alert("请选择企业!");
	 			}else
	 			{
	 				form.submit();
	 			}
	 		}    
	 	});
	}); 
	
	//查询企业
	function queryCorp()
	{
		var url="<%=basepath %>/queryCorpAction_queryPage.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	
	//取消
	function goBack()
	{
		document.form1.action="<%=basepath%>/codeChangeAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>

<body>

	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #3874d3;">组织机构代码变更</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="<%=basepath%>/codeChangeAction_add.action" >
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>企业名称：</td>
						<td>
						<input id="corpId" type="hidden" readonly name="codeChange.corpId" class="required" />
						<input id="corpName" type="text" readonly name="codeChange.corpName" class="required" />
						<strong><font color="#FF0000">*</font></strong>
						<a href="#" onclick="queryCorp()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
						</td>
						<td>组织机构代码：</td>
						<td>
						<input id="corpCode" type="text" readonly name="codeChange.oldCode" class="required" />
						<strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>
					<tr>
						<td>新组织机构代码：</td>
						<td colspan="3">
							<input id="newCode" type="text" maxlength='23' name="codeChange.newCode" class="required" />
							<strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>
					
				</table>
				
				<div class="sp_bton">
					<input type="image" src="<%=basepath%>/images/baocun.jpg" /> 
					<input type="image" onclick="goBack()" src="<%=basepath%>/images/quxiao.jpg" />
				</div>
			</form>
		</div>
	</div>

</body>
</html>
