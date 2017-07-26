<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册人员</title>
<script type="text/javascript">

		//查询
		function queryConstructor()
		{
			document.form1.action="<%=basepath%>/constructorInfoAction_queryPage.action";
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
						<h2>注册人员搜索</h2>
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
								<td>学历：</td>
								<td><select name="condition.eduLevelNum">
										<option value="">请选择</option>
										<s:iterator value="eduLevelNums">
											<option value="<s:property value="code"/>"
												<s:if test='condition.eduLevelNum==code'>selected</s:if>><s:property
													value="name" /></option>
										</s:iterator>
								</select></td>
								<td>所在公司名称：</td>
								<td><input type="text" name="condition.corpName"
									value="<s:property value="condition.corpName"/>" /></td>
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
						注册人员列表<img src="<%=basepath%>/images/ry_lie.png" />
					</p>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>序号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>类型及级别</th>
								<th>证件号码</th>
								<th>学历</th>
								<th>公司名称</th>
								<th>详细</th>
							</tr>

							<s:iterator status="i" value="currentPage.data">
								<tr>
									<td><s:property value="#i.count" /></td>
									<td><s:property value="personName" /></td>
									<td><s:property value="sexName" /></td>
									<td><s:property value="sepecialtyTypName" /></td>
									<td><s:property value="idCard" /></td>
									<td><s:property value="eduLevelName" /></td>
									<td><s:property value="corpName" /></td>
									<td>
									<a href="constructorInfoAction_detail.action?personId=<s:property value="personId"/>">
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