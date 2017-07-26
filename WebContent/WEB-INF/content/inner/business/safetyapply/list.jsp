<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报安全勘察项目审核</title>
<script type="text/javascript">
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/safetyApplyAction_queryPage.action";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="libiao">
		<form id="form1" name="form1" method="post" action="">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">安全勘察审核</legend>
							<p style="margin-bottom: 10px; text-align: right;">
								<a href="#" onclick="query()"><span class="lbchx">查询</span></a>
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">

								<tr>
									<td>项目名称：</td>
									<td><input type="text" name="condition.prjName"
										value="<s:property value="condition.prjName"/>" /></td>
									<td>项目编号：</td>
									<td><input type="text" name="condition.prjNum"
										value="<s:property value="condition.prjNum"/>" /></td>
								</tr>
								<tr>
									<td>申请企业名称：</td>
									<td><input type="text" name="condition.applyCorpName"
										value="<s:property value="condition.applyCorpName"/>" /></td>
									<td>施工总承包单位名称：</td>
									<td><input type="text" name="condition.contractName"
										value="<s:property value="condition.contractName"/>" /></td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>

			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				onmouseover="changeto()" onmouseout="changeback()">
				<tr>
					<th>序号</th>
					<th>项目名称</th>
					<th>项目编号</th>
					<th>申请企业名称</th>
					<th>施工总承包单位名称</th>
					<th>记录日期</th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="prjName" /></td>
						<td><s:property value="prjNum" /></td>
						<td><s:property value="applyCorpName" /></td>
						<td><s:property value="contractName" /></td>
						<td><s:date name="createDate" format="yyyy-MM-dd" /></td>
						<td align='center'><a
							href="safetyApplyAction_queryapproval.action?safetyId=<s:property value="safetyId"/>">审核</a>
						</td>
					</tr>
				</s:iterator>

			</table>
		</form>
	</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
	</div>
</body>
</html>