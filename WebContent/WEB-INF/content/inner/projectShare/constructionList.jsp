<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>项目报建审核历史查询</title>
<script type="text/javascript">
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/projectShareAction_queryPage.action";
		document.form1.submit();
	}
	
	//查询区
	function queryArea() {
		$(document).ready(
			function() {
				//获取部门下拉列表的值
				var approvalCityId = $("#approvalCityId").val();
				$.ajax({
					url : 'projectShareAction_queryApprovaArea.action',
					type : 'post',
					dataType : 'json',
					data : 'approvalCityId=' + approvalCityId,
					success : function(data) {
						//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
						var items = eval("(" + data + ")");
						$("#approvalAreaId").empty();
						$("#approvalAreaId").append("<option value=''>请选择 </option>");
						var area = '<s:property value="condition.approvalAreaId"/>';
						//循环items,i为循环下标,(默认i从0开始取值)
						$.each(items, function(i) {
							if (items[i].code == area) {
								$("#approvalAreaId").append("<option value='" + items[i].code+ "' selected >"+ items[i].name+ "</option>");
							} else {
								$("#approvalAreaId").append(
										"<option value='" + items[i].code+ "' >"+ items[i].name + "</option>");
							}
						});
					}
				});
			});
	}
</script>
</head>
<body onload="queryArea()">
	<div class="libiao">
		<form id="form1" name="form1" method="post" action="">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">项目报建审核历史查询</legend>
							<p style="margin-bottom: 10px; text-align: right;">
								<a href="#" onclick="query()"><span class="lbchx">查询</span></a>
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
								<tr>
									<td>审批市：</td>
									<td>
									<select id="approvalCityId" onchange="queryArea()" name="condition.approvalCityId" class="sel">
										<option value="">请选择</option>
										<s:iterator value="approvalCityList">
											<option value="<s:property value = "code" />"<s:if test='condition.approvalCityId==code'>selected</s:if>><s:property value="name" /></option>
										</s:iterator>
									</select>
									</td>
									<td>审批区/县：</td>
									<td>
									<select id="approvalAreaId" name="condition.approvalAreaId" class="sel">
										<option value="">请选择</option>
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
					<th>建设单位名称</th>
					<th>建设单位组织机构代码证</th>
					<th>立项文号</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="prjName" /></td>
						<td><s:property value="buildCorpName" /></td>
						<td><s:property value="buildCorpCode" /></td>
						<td><s:property value="prjApprovalNum" /></td>
						<td><s:if test="appType==0" >未处理</s:if><s:if test="appType==1" >通过</s:if><s:if test="appType==2" >未通过</s:if></td>
						<td align='center'><a
							href="projectShareAction_queryInfo.action?prjId=<s:property value="prjId"/>">详细</a>
						</td>
					</tr>
				</s:iterator>

			</table>
		</form>
	</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
	
</body>
</html>