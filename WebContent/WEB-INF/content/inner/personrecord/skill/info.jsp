<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>技术工人详细</title>

</head>

<body>

	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #3874d3;">注册建造师详细</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>姓名：</td>
						<td><s:property value="skillworker.personName" /></td>
						<td>性别：</td>
						<td><s:property value="skillworker.sexName" /></td>

					</tr>
					<tr>
						<td>证件类型：</td>
						<td><s:property value="skillworker.idCardTypeName" /></td>
						<td>证件号码：</td>
						<td><s:property value="skillworker.identityCard" /></td>


					</tr>
					<tr>
						<td>工种类型：</td>
						<td><s:property value="skillworker.skilledType" /></td>
						<td>工种级别：</td>
						<td><s:property value="skillworker.skilledLevel" /></td>


					</tr>
					<tr>
						<td>民族：</td>
						<td><s:property value="skillworker.nationAlityName" /></td>
						<td>手机号码：</td>
						<td><s:property value="skillworker.mobile" /></td>

					</tr>

					<tr>
						<td>学位：</td>
						<td><s:property value="skillworker.degreeName" /></td>
						<td>学历：</td>
						<td><s:property value="skillworker.eduLevelName" /></td>


					</tr>

					<tr>
						<td>出生日期：</td>
						<td><s:date name="skillworker.birthday" format="yyyy-MM-dd" /></td>
						<td>所在公司：</td>
						<td><s:property value="skillworker.corpName" /></td>
					</tr>

				</table>
				<div class="sp_bton">
					<a href="javascript:history.go(-1)">返回上一步</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
