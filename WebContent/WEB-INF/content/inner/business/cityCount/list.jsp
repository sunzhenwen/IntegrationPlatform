<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报施工许可项目审核</title>
</head>
<body>
	<div class="libiao">
		<form id="form1" name="form1" method="post" action="">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">项目报建统计</legend>
							<p style="margin-bottom: 10px; text-align: right;">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
				onmouseover="changeto()" onmouseout="changeback()">
				<tr>
					<th>序号</th>
					<th>地区名称</th>
					<th>上报数量</th>
				</tr>
				<s:iterator status="i" value="list">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="appDeptName" /></td>
						<td><s:property value="cityNum" /></td>
					</tr>
				</s:iterator>

			</table>
						</fieldset>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>