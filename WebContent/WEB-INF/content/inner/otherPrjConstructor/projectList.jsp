<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>外省企业项目备案</title>
<script type="text/javascript">
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/otherPrjConstructorAction_queryPage.action";
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
							<legend class="chaxuntj">外省企业项目备案</legend>
							<p style="margin-bottom: 10px; text-align: right;">
								<a href="#" onclick="query()"><span class="lbchx">查询</span></a>
								<!-- 
								<a href="#" onclick="batchApplythrough()"><span
									class="lbchx">批量审核</span></a>
								 -->
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">
								
								<tr>
									<td width="12%"><label>起始时间：</label></td>
									<td>
									<input id="time1" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" type="text" name="condition.startDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
									</td>
									<td width="12%"><label>截止时间：</label></td>
									<td>
									<input id="time2" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" type="text" name="condition.endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
									</td>
								</tr>
								<tr>
									<td width="12%"><label>项目名称：</label></td>
									<td><input type="text" name="condition.prjName"
										value="<s:property value="condition.prjName"/>" /></td>
									<td width="12%"><label>项目编号：</label></td>
									<td><input type="text" name="condition.prjNum"
										value="<s:property value="condition.prjNum"/>" /></td>
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
					<th>备案公司</th>
					<th>备案日期</th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="prjName" /></td>
						<td><s:property value="prjNum" /></td>
						<td><s:property value="corpName" /></td>
						<td><s:date name="createDate" format="yyyy-MM-dd" /></td>
						<td>
						<a href="otherPrjConstructorAction_projectById.action?otherPrjId=<s:property value="otherPrjId"/>">
						<span>查看</span>
						</a>
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