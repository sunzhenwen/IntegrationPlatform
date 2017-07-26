<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css">
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<title>外省企业三类人员搜索</title>
<script type="text/javascript">
	//查询
	function queryTitle()
	{
		document.form1.action="<%=basepath%>/threeTypePersonAction_queryPage.action";
		document.form1.submit();
	}
	
	//添加
	function addTitle()
	{
		document.form1.action="<%=basepath%>/threeTypePersonAction_addPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/threeTypePersonAction_goBack.action";
		document.form1.submit();
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
	<div class="ry_wrapp">
		<div class="head">
			<input type="hidden" id="message"
				value="<s:property value="message" />" />
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
	<div class="main">
		<form id="form1" name="form1" method="post" action="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>

					<td valign="top">
						<div class="wr">

							<div class="tit">
								<img src="images/titico2.gif" /><strong>外省企业三类人员搜索</strong>
							</div>

							<div class="main " style="line-heigth: 24px;">
								<table width="98%" border="0" cellspacing="0" cellpadding="0"
									style="min-height: 100px;">
									<tr>
										<td width="12%"><label>人员名称：</label></td>
										<td><input type="text" name="condition.FName" class="ipu1"
											value="<s:property value="condition.FName"/>" /></td>
										<td width="12%"><label>身份证号：</label></td>
										<td><input type="text" name="condition.FIdCertNo" class="ipu1"
											value="<s:property value="condition.FIdCertNo"/>" /></td>
									</tr>
								</table>
								<table class="ry_right right">
									<tr>
										<td><input type="button" 
											class="btn" value="搜索" onclick="queryTitle()" /></td>
										<td><input type="button" 
											class="btn" value="添加" onclick="addTitle()" /></td>
										<td><input type="button" 
											class="btn" value="返回" onclick="goBack()" /></td>

									</tr>
								</table>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="ry_liebiao">
		<p class="f16 pd10 fb">
			外省企业三类人员列表<img src="<%=basepath%>/images/ry_lie.png" />
		</p>
		<table class="" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>身份证号</th>
					<th>所在单位</th>
					<th>证书编号</th>
					<th>发证日期</th>
					<th>结束日期</th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="FName" /></td>
						<td><s:property value="FIdCertNo" /></td>
						<td><s:property value="FEntName" /></td>
						<td><s:property value="FCertNumber" /></td>
						<td><s:date name="FRegDate" format="yyyy-MM-dd" /></td>
						<td><s:date name="FRegEndDate" format="yyyy-MM-dd" /></td>
						<td><a
							href="threeTypePersonAction_modifyPage.action?threeTypePersonId=<s:property value="threeTypePersonId"/>"><span>修改</span></a>&nbsp;
							<a
							href="threeTypePersonAction_delete.action?threeTypePersonId=<s:property value="threeTypePersonId"/>"><span>删除</span></a></td>

					</tr>
				</s:iterator>

			</tbody>
		</table>
		<%@include file="/WEB-INF/content/inc/page.jsp"%>
	</div>
	<%@include file="/WEB-INF/content/outside/footer.jsp"%>
	
</body>
</html>
