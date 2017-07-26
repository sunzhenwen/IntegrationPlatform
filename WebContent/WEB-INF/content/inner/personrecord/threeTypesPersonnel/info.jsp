<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>三类人员详细</title>

</head>

<body>

	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #3874d3;">三类人员详细</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>姓名：</td>
						<td><s:property value="threeTypesPersonnel.fName" /></td>
						<td>身份证号：</td>
						<td><s:property value="threeTypesPersonnel.fIdCertNo" /></td>

					</tr>
					<tr>
						<td>证书类别：</td>
						<td><s:property value="threeTypesPersonnel.FCertType" /></td>
						<td>证书编号：</td>
						<td><s:property value="threeTypesPersonnel.FCertNumber" /></td>


					</tr>
					<tr>
						<td>发证日期：</td>
						<td><s:date name="threeTypesPersonnel.FRegDate" format="yyyy-MM-dd" /></td>
						<td>结束日期：</td>
						<td><s:date name="threeTypesPersonnel.FRegEndDate" format="yyyy-MM-dd" /></td>


					</tr>
					<tr>
						<td>所在单位：</td>
						<td><s:property value="threeTypesPersonnel.FEntName" /></td>
						<td>单位：</td>
						<td><s:property value="threeTypesPersonnel.FEntName1" /></td>

					</tr>

					<tr>
						<td>状态：</td>
						<s:if test='threeTypesPersonnel.fState=="0"'>
							<td>有效</td>
						</s:if><s:else>
							<td>无效</td>
						</s:else>
						<td>企业：</td>
						<td><s:property value="corpName" /></td>


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
