<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css">
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<title>组织机构代码证查询</title>
<script type="text/javascript">
	function queryCorpCode()
	{
		var code = document.getElementById("code").value;
		if(code != "")
		{
			document.form1.action="<%=basepath%>/queryQualificationAction_queryQualifications.action";
			document.form1.submit();
		} else {
			alert("请输入企业组织机构代码！");
		}
	}

	//操作提示信息
	function getMessage() {
		var message = document.getElementById("message").value;
		if (message != "") {
			alert(message);
		}
	}
</script>
</head>

<body onload="getMessage()">
	<input type="hidden" id="message"
		value="<s:property value="message" />" />
	<form id="form1" name="form1" method="post" action="">
		<div class="qy_wrapp">
			<div class="tit">
				<img src="images/titico2.gif" /><strong>企业资质查询平台
				</strong>
			</div>
			<div class="main cz"
				style="min-height: 500px; solid: #000 1px solid;">
				<table width="98%" border="0" cellspacing="0" cellpadding="0" style="margin-top:20px;">
					<tr>
						<td width="100%" style="padding:10px 10px;" ><label style="padding:0px;font-size:24px;line-height:100%;">组织机构代码证查询</label></td>
						
					</tr>
					<tr>
						<td width="100%" style="padding:10px 10px;" ><label style="padding:0px;font-size:20px;line-height:100%;">(统一社会信用代码)</label></td>
						
					</tr>
					<tr>
						<td width="95%"  style="padding:10px 10px;">
							 <input id="code" maxlength="18" type="text" class="ipu1" name="corpCode" style="width:100%;padding:10px ;height:30px;"/>
						</td>
					</tr>
					<tr>
						<td width="100%" style="padding:10px 10px;"><input name="" type="button" value="查询"
							class="fl btn" onclick="queryCorpCode()"  style="padding:0px;line-height:100%;"/></td>
					</tr>
				</table>
			</div>
		</div>
</body>
</html>