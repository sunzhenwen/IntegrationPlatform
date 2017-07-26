<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>合同备案共享查询</title>
<script type="text/javascript">
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/filingShareAction_queryPage.action";
		document.form1.submit();
	}
	
	//查询区
	function queryArea() {
		$(document).ready(
			function() {
				//获取部门下拉列表的值
				var approvalCityId = $("#approvalCityId").val();
				$.ajax({
					url : 'filingShareAction_queryApprovaArea.action',
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
							<legend class="chaxuntj">合同备案共享查询</legend>
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
									<td>合同编号 ：</td>
									<td><input type="text" name="condition.contractNum"
										value="<s:property value="condition.contractNum"/>" /></td>
									<td>合同类别 ：</td>
									<td><input type="text" name="condition.contractTypeName"
										value="<s:property value="condition.contractTypeName"/>" /></td>
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
					<th>项目编号</th>
					<th>合同编号</th>
					<th>合同类别</th>
					<th>合同签订日期</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="prjName" /></td>
						<td><s:property value="prjNum" /></td>
						<td><s:property value="contractNum" /></td>
						<td><s:property value="contractTypeName" /></td>
						<td><s:date name="contractDate" format="yyyy-MM-dd" /></td>
						<td><s:if test="appType==0" >未处理</s:if><s:if test="appType==1" >备案通过</s:if><s:if test="appType==2" >备案未通过</s:if></td>
						<td align='center'><a
							href="filingShareAction_queryInfo.action?recordId=<s:property value="recordId"/>">详细</a>
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