<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>合同审核</title>
<script type="text/javascript">
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/filingBusinessAction_queryPage.action";
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
							<legend class="chaxuntj">施工合同审核</legend>
						</fieldset>
					</td>
				</tr>
			</table>
			
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				onmouseover="changeto()" onmouseout="changeback()">
				<tr>
					<th>序号</th>
					<th>名称</th>
					<th>类型</th>
					<th>合同签订日期</th>
					<th>是否锁定</th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="zhConName" /></td>
						<td><s:if test='conType==1'>建设工程施工合同（发改法规[2011]3018号）</s:if>
							<s:if test='conType==2'>建设工程施工合同（建市[2010]88号）</s:if>
							<s:if test='conType==3'>黑龙江省建设工程施工专业分包合同</s:if>
							<s:if test='conType==4'>黑龙江省建设工程施工劳务分包合同</s:if></td>
						<td><s:date name="createDate" format="yyyy-MM-dd" /></td>
						<td>
						<s:if test='isLocking==0'>未锁定</s:if>
						<s:if test='isLocking==1'>锁定</s:if>
						</td>
						<td align='center'>
							<s:if test="isLocking == 1"><a href="filingBusinessAction_queryInfo.action?conId=<s:property value="conId"/>&recordId=<s:property value="recordId"/>">查看</a></s:if>
							<s:if test="isLocking == 0"><a href="constructionFilingApplyAction_queryContractInfoPage.action?conId=<s:property value="conId"/>&recordId=<s:property value="recordId"/>">审核</a></s:if>
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