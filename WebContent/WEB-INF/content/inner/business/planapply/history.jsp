<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报施工图审查项目审核历史查询</title>
<script type="text/javascript">
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/planHistoryAction_queryHistoryPage.action";
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
							<legend class="chaxuntj">施工图审核历史查询</legend>
							<p style="margin-bottom: 10px; text-align: right;">
								<a href="#" onclick="query()"><span class="lbchx">查询</span></a>
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">

								<tr>
									<td>项目名称：</td>
									<td><input type="text" name="condition.prjName"
										value="<s:property value="condition.prjName"/>" /></td>
									<td>施工图审查机构名称：</td>
									<td><input type="text" name="condition.censorCorpName"
										value="<s:property value="condition.censorCorpName"/>" /></td>
								</tr>

								<tr>
									<td>施工图审查机构组织机构代码：</td>
									<td><input type="text" name="condition.censorCorpCode"
										value="<s:property value="condition.censorCorpCode"/>" /></td>
								</tr>
								
								<tr>
									<td>项目状态：</td>
									<td>
										<select name="condition.appType">
                        					<option value="">请选择</option>
											<option value="0" <s:if test='condition.appType==0'>selected</s:if>>未处理</option>
											<option value="1" <s:if test='condition.appType==1'>selected</s:if>>通过</option>
											<option value="2" <s:if test='condition.appType==2'>selected</s:if>>未通过</option>
										</select>
									</td>
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
					<th>施工图审查机构名称</th>
					<th>施工图审查机构组织机构代码</th>
					<th>审查完成日期</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="prjName" /></td>
						<td><s:property value="prjNum" /></td>
						<td><s:property value="censorCorpName" /></td>
						<td><s:property value="censorCorpCode" /></td>
						<td><s:date name="censorEDate" format="yyyy-MM-dd" /></td>
						<td><s:if test="appType==0" >未处理</s:if><s:if test="appType==1" >通过</s:if><s:if test="appType==2" >未通过</s:if></td>
						<td align='center'><a
							href="planHistoryAction_queryHistory.action?censorId=<s:property value="censorId"/>">详细</a>
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