<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>岗位工人</title>
<script type="text/javascript">

		//查询
		function queryConstructor()
		{
			document.form1.action="<%=basepath%>/titleInfoAction_queryPage.action";
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
						<h2>岗位人员搜索</h2>
						<table class="ry_left left">
							<tr>
								<td>人员名称：</td>
								<td><input type="text" name="condition.personName"
									value="<s:property value="condition.personName"/>" /></td>
								<td>证件号码：</td>
								<td><input type="text" name="condition.idCard"
									value="<s:property value="condition.idCard"/>" /></td>
							</tr>

							<tr>
								<td>职称：</td>
								<td><input type="text" name="condition.titleName"
									value="<s:property value="condition.titleName"/>" /></td>
								<td>职称专业：</td>
								<td><input type="text" name="condition.titleMajor"
									value="<s:property value="condition.titleMajor"/>" /></td>
							</tr>
							<tr>
								<td>职称级别：</td>
								<td><input type="text" name="condition.titleLevel"
									value="<s:property value="condition.titleLevel"/>" /></td>
								<td>所在公司名称：</td>
								<td><input type="text" name="condition.corpName"
									value="<s:property value="condition.corpName"/>" /></td>
							</tr>
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
						岗位人员列表<img src="<%=basepath%>/images/ry_lie.png" />
					</p>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>序号</th>
								<th>姓名</th>
								<th>证件号码</th>
								<th>职称</th>
								<th>职称专业</th>
								<th>职称级别</th>
								<th>所属公司</th>
								<th>操作</th>
							</tr>
							<s:iterator status="i" value="currentPage.data">
								<tr>
									<td><s:property value="#i.count" /></td>
									<td><s:property value="personName" /></td>
									<td><s:property value="idCard" /></td>
									<td><s:property value="titleName" /></td>
									<td><s:property value="titleMajor" /></td>
									<td><s:property value="titleLevel" /></td>
									<td><s:property value="corpName" /></td>
									<td><a
										href="titleInfoAction_queryById.action?personId=<s:property value="personId"/>"><span>详细</span></a></td>
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