<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>三类人员</title>
<script type="text/javascript">

		//查询
		function queryConstructor()
		{
			document.form1.action="<%=basepath%>/threeTypesPersonnelAction_queryPage.action";
			document.form1.submit();
		}
</script>
</head>
<body>
	<div class="ry_wrapp">
		<form id="form1" name="form1" method="post" action="">

			<div class="ry_content">
				<form>
					<div class="ry_main" cellpadding="0" cellspacing="0">
						<h2>三类人员搜索</h2>
						<table class="ry_left left">
							<tr>
								<td>人员名称：</td>
								<td><input type="text" name="condition.FName"
									value="<s:property value="condition.FName"/>" /></td>
								<td>证件号码：</td>
								<td><input type="text" name="condition.FIdCertNo"
									value="<s:property value="condition.FIdCertNo"/>" /></td>
							</tr>
							<tr>
								<td>证书编号：</td>
								<td><input type="text" name="condition.FCertNumber"
									value="<s:property value="condition.FCertNumber"/>" /></td>
								<td>所在公司名称：</td>
								<td><input type="text" name="condition.fEntName"
									value="<s:property value="condition.fEntName"/>" /></td>
							</tr>
						</table>
						<table class="ry_right left">
							<tr>
								<td><input type="image"
									src="<%=basepath%>/images/ry_look.png"
									onclick="queryConstructor()" /></td>
							</tr>
						</table>

					</div>
				</form>
				<div class="ry_liebiao">
					<p class="f16 fb">
						三类人员列表<img src="<%=basepath%>/images/ry_lie.png" />
					</p>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>序号</th>
								<th>姓名</th>
								<th>证件号码</th>
								<th>证书类型</th>
								<th>证书编号</th>
								<th>公司名称</th>
								<th>操作</th>
							</tr>

							<s:iterator status="i" value="currentPage.data">
								<tr>
									<td><s:property value="#i.count" /></td>
									<td><s:property value="fName"/> </td>
									<td><s:property value="fIdCertNo" /></td>
									<td><s:property value="fCertType" /></td>
									<td><s:property value="fCertNumber" /></td>
									<td><s:property value="fEntName" /></td>
									<td>
									<a href="threeTypesPersonnelAction_queryById.action?threeTypePersonId=<s:property value="threeTypePersonId"/>">
									<span class="lbmingx">详细</span></a>
									</td>
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