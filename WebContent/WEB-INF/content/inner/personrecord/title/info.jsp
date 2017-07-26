<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>岗位人员详细</title>

</head>

<body>

	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #3874d3;">岗位人员详细</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>姓名：</td>
						<td><s:property value="title.personName" /></td>
						<td>性别：</td>
						<td><s:property value="title.sexName" /></td>

					</tr>
					<tr>
						<td>证件类型：</td>
						<td><s:property value="title.idCardTypeName" /></td>
						<td>证件号码：</td>
						<td><s:property value="title.idCard" /></td>
					</tr>
					<tr>
						<td>职称：</td>
						<td><s:property value="title.titleName" /></td>
						<td>职称专业：</td>
						<td><s:property value="title.titleMajor" /></td>


					</tr>
					<tr>
						<td>职称级别：</td>
						<td><s:property value="title.titleLevel" /></td>
						<td>毕业学校：</td>
						<td><s:property value="title.graduatedSchool" /></td>

					</tr>

					<tr>
						<td>所学专业：</td>
						<td><s:property value="title.studyMajor" /></td>
						<td>毕业时间：</td>
						<td><s:date name="title.graduatedDate" format="yyyy-MM-dd" /></td>


					</tr>

					<tr>
						<td>手机号码：</td>
						<td><s:property value="title.mobile" /></td>
						<td>所在公司：</td>
						<td><s:property value="title.corpName" /></td>
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
