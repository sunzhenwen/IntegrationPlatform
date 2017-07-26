<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title>项目信息</title>
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath%>/queryProjectInfoAction_queryPage.action";
		document.form1.submit();
	}

	function corpChoose(value) {
		var parent = window.dialogArguments;
		//window.returnValue=value;
		var strs = new Array(); //定义一数组 
		strs = value.split(","); //字符分割 
		var prjNum = strs[0];
		var prjName = strs[1];
		var address = strs[2];
		var buildCorpName = strs[3];
		var buildCorpCode = strs[4];
		parent.document.getElementById("prjNum").value = prjNum;
		parent.document.getElementById("prjName").value = prjName;
		parent.document.getElementById("address").value = address;
		parent.document.getElementById("buildCorpName").value = buildCorpName;
		parent.document.getElementById("buildCorpCode").value = buildCorpCode;
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
		<form id="form1" name="form1" method="post"
			action="<%=basepath%>/queryCorpsAction_queryPage.action">

			<div class="ry_content">

				<div class="ry_main" cellpadding="0" cellspacing="0">
					<h2>企业备案申请</h2>
					<table class="ry_left left">
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
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</table>
					<table class="ry_right left">
						<tr>
							<td><input type="image" onclick="queryCorpInfo()"
								src="<%=basepath%>/images/ry_look.png" /></td>
							<td>&nbsp;</td>
						</tr>
					</table>

				</div>

				<div class="ry_liebiao">
					<p class="f16 fb">
						企业备案申请列表<img src="<%=basepath%>/images/ry_lie.png" />
					</p>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>选择</th>
								<th>序号</th>
								<th>项目名称</th>
								<th>建设单位名称</th>
								<th>建设单位组织机构代码证</th>
								<th>立项文号</th>
								<th>建设用地规划许可证编号</th>
								<th>建设工程规划许可证编号</th>
							</tr>

							<s:iterator status="i" value="currentPage.data">
								<tr>
									<td><input onclick="corpChoose(this.value)" type="radio"
										name="corpRadio"
										value="<s:property value="prjNum"/>,<s:property value="prjName"/>,<s:property value="address"/>,<s:property value="buildCorpName"/>,<s:property value="buildCorpCode"/>"></td>
									<td><s:property value="#i.count" /></td>
									<td><s:property value="prjName" /></td>
									<td><s:property value="buildCorpName" /></td>
									<td><s:property value="buildCorpCode" /></td>
									<td><s:property value="prjApprovalNum" /></td>
									<td><s:property value="buldPlanNum" /></td>
									<td><s:property value="projectPlanNum" /></td>
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
