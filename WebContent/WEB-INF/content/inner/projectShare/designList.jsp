<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>项目设计共享查询</title>
<script type="text/javascript">
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/designShareAction_queryPage.action";
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
							<legend class="chaxuntj">项目设计共享查询</legend>
							<p style="margin-bottom: 10px; text-align: right;">
								<a href="#" onclick="query()"><span class="lbchx">查询</span></a>
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">

								<tr>
									<td>项目编号：</td>
									<td><input type="text" name="condition.prjNum"
										value="<s:property value="condition.prjNum"/>" /></td>
									<td>设计编码：</td>
									<td><input type="text" name="condition.designNum"
										value="<s:property value="condition.designNum"/>" /></td>
								</tr>

								<tr>
									<td>设计单位名称：</td>
									<td><input type="text" name="condition.designCorpName"
										value="<s:property value="condition.designCorpName"/>" /></td>
									<td>设计单位组织机构代码证：</td>
									<td><input type="text" name="condition.designCorpCode"
										value="<s:property value="condition.designCorpCode"/>" /></td>
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
					<th>项目编号</th>
					<th>项目名称</th>
					<th>设计编码</th>
					<th>设计单位名称</th>
					<th>设计单位组织机构代码证</th>
					<th>申请企业组织机构代码证</th>
					<th>申请日期</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="prjNum" /></td>
						<td><s:property value="prjName" /></td>
						<td><s:property value="designNum" /></td>
						<td><s:property value="designCorpName" /></td>
						<td><s:property value="designCorpCode" /></td>
						<td><s:property value="applyCorpCode" /></td>
						<td><s:date name="createDate" format="yyyy-MM-dd" /></td>
						<td><s:if test="appType==0" >未处理</s:if><s:if test="appType==1" >通过</s:if><s:if test="appType==2" >未通过</s:if></td>
						<td align='center'><a
							href="designShareAction_queryInfo.action?designId=<s:property value="designId"/>">详细</a>
						</td>
					</tr>
				</s:iterator>

			</table>
		</form>
	</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>

</body>
</html>