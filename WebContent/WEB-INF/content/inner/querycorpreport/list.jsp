<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业统计报表页面</title>
<script type="text/javascript">
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/queryCorpReportAction_queryPage.action";
		document.form1.submit();
	}
</script>
</head>
<body onload="getMessage()">
	<input type="hidden" id="message"
		value="<s:property value="message" />" />
	<div class="ry_wrapp">
		<form id="form1" name="form1" method="post" action="">

			<div class="ry_content">
				<form>
					<div class="ry_main" cellpadding="0" cellspacing="0">
						<h2>统计报表搜索</h2>
						<table class="ry_left left">
							<tr>
								<td>企业名称：</td>
								<td><input type="text" name="condition.corpName"
									value="<s:property value = "condition.corpName"/>" /></td>
								<td>企业组织机构代码证：</td>
								<td><input type="text" name="condition.corpCode"
									value="<s:property value = "condition.corpCode"/>" /></td>
							</tr>
							<tr>
								<td>年：</td>
								<td><input id="time3"
									value="<s:date name="condition.reportYear" format="yyyy" />"
									type="text" name="condition.reportYear"
									onFocus="WdatePicker({dateFmt:'yyyy',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
								</td>
								<td>季度：</td>
								<td><select name="condition.quarter">
										<option value="">请选择</option>
										<option value="1">第一季度</option>
										<option value="2">第二季度</option>
										<option value="3">第三季度</option>
										<option value="4">第四季度</option>
								</select></td>
							</tr>
						</table>
						<table class="ry_right left">
							<tr>
								<td><input type="image" onclick="query()"
									src="<%=basepath%>/images/ry_look.png" /></td>
							</tr>
						</table>

					</div>
				</form>
				<div class="ry_liebiao">
					<p class="f16 fb">
						企业统计报表列表<img src="<%=basepath%>/images/ry_lie.png" />
					</p>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>序号</th>
								<th>企业名称</th>
								<th>企业组织机构代码证</th>
								<th>年</th>
								<th>季度</th>
								<th>操作</th>
							</tr>
							<s:iterator status="i" value="currentPage.data">
								<tr>
									<td><s:property value="#i.count" /></td>
									<td><s:property value="corpName" /></td>
									<td><s:property value="corpCode" /></td>
									<td><s:property value="reportYear" />年</td>
									<td>
										<s:if test="quarter==1">第一季度</s:if>
										<s:if test="quarter==2">第二季度</s:if>
										<s:if test="quarter==3">第三季度</s:if>
										<s:if test="quarter==4">第四季度</s:if>
									</td>
									<td align='center'><a
										href="queryCorpReportAction_queryInfo.action?id=<s:property value="id"/>"><span
											class="lbmingx">详细</span></a>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>
