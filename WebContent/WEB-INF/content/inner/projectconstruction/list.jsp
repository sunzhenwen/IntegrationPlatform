<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报项目审核</title>
<script type="text/javascript">
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/projectConstructionAction_queryPage.action";
		document.form1.submit();
	}
	
	//批量审核通过
	function batchApplythrough(){   
		if(hasChecked(form1)==false){
			alert("请选择要审核的记录!");
			return;
		}
		if(confirm("您确定要审核选中的记录吗？")==true){
			document.form1.action="<%=basepath%>/projectConstructionAction_queryPage.action";
			document.form1.submit();
		}
	}
	
	//批量审核通过
	function batchApplythrough(){   
		if(hasChecked(form1)==false){
			alert("请选择要审核的记录!");
			return;
		}
		if(confirm("您确定要审核选中的记录吗？")==true){
			document.form1.action="<%=basepath %>/projectConstructionAction_batchApplythrough.action";
			document.form1.submit();
		}
	}	
</script>
</head>
<body onload="querySpecialtyType()">
	<div class="libiao">
		<form id="form1" name="form1" method="post" action="">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">上报项目审核</legend>
							<p style="margin-bottom: 10px; text-align: right;">
								<a href="#" onclick="query()"><span class="lbchx">查询</span></a>
								<!-- 
								<a href="#" onclick="batchApplythrough()"><span
									class="lbchx">批量审核</span></a>
								 -->
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">
								
								<tr>
									<td>项目名称：</td>
									<td><input type="text" name="condition.prjName"
										value="<s:property value="condition.prjName"/>" /></td>
									<td>立项文号：</td>
									<td><input type="text" name="condition.prjApprovalNum"
										value="<s:property value="condition.prjApprovalNum"/>" /></td>
								</tr>
								
								<tr>
									<td>建设单位名称：</td>
									<td><input type="text" name="condition.buildCorpName"
										value="<s:property value="condition.buildCorpName"/>" /></td>
									<td>建设单位组织机构代码证：</td>
									<td><input type="text" name="condition.buildCorpCode"
										value="<s:property value="condition.buildCorpCode"/>" /></td>
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
					<th>建设单位名称</th>
					<th>建设单位组织机构代码证</th>
					<th>立项文号</th>
					<th>项目编号</th>
					<!-- 
					<th>
					<input type="checkbox" name="all" onclick="javascript:check(form1,form1.all);" class="henglan">
					</th>
					 -->
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="prjName" /></td>
						<td><s:property value="buildCorpName" /></td>
						<td><s:property value="buildCorpCode" /></td>
						<td><s:property value="prjApprovalNum" /></td>
						<td><s:property value="prjNum" /></td>
						<!-- 
						<td><input type="checkbox" name="ids"
							value="<s:property value="newQualId"/>"
							onclick="javascript:setChecked(form1);" />
						</td>
						 -->
						<td align='center'><a
							href="projectConstructionAction_queryapproval.action?prjId=<s:property value="prjId"/>">审核</a>
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