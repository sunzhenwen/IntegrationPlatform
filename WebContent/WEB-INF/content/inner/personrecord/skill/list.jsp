<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>技术工人</title>
<script type="text/javascript">

		//查询
		function queryConstructor()
		{
			document.form1.action="<%=basepath%>/skillInfoAction_queryPage.action";
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
						<h2>技术工人搜索</h2>
						<table class="ry_left left">
							<tr>
								<td>人员名称：</td>
								<td><input type="text" name="condition.personName"
									value="<s:property value="condition.personName"/>" /></td>
								<td>证件号码：</td>
								<td><input type="text" name="condition.identityCard"
									value="<s:property value="condition.identityCard"/>" /></td>
							</tr>

							<tr>
								<td>技术人员种类：</td>
								<td><select name="condition.skilledTypeNum">
										<option value="">请选择</option>
										<s:iterator value="typedNums">
											<option value="<s:property value="code"/>"
												<s:if test='condition.skilledTypeNum==code'>selected</s:if>><s:property
													value="name" /></option>
										</s:iterator>
								</select></td>
						</table>
						<table class="ry_right left">
							<tr>
								<td><input type="image" src="<%=basepath%>/images/ry_look.png"
									onclick="queryConstructor()" /></td>
							</tr>
						</table>

					</div>
				</form>
				<div class="ry_liebiao">
					<p class="f16 fb">
						技术人员列表<img src="<%=basepath%>/images/ry_lie.png" />
					</p>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>序号</th>
								<th>姓名</th>
								<th>证件号码</th>
								<th>技术工种类型</th>
								<th>证书编号</th>
							</tr>
							<s:iterator status="i" value="currentPage.data">
								<tr>
									<td><s:property value="#i.count" /></td>
									<td><s:property value="personName" /></td>
									<td><s:property value="identityCard" /></td>
									<td><s:property value="skilledType" /></td>
									<td><s:property value="certificateNum" /></td>
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