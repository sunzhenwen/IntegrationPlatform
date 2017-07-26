<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册人员详细</title>

</head>

<body>

	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #3874d3;">注册人员详细</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>姓名：</td>
						<td><s:property value="constructor.personName" /></td>
						<td>证件类型：</td>
						<td><s:property value="constructor.idCardTypeName" /></td>

					</tr>
					<tr>
						<td>证件号码：</td>
						<td><s:property value="constructor.idCard" /></td>
						<td>注册类型及等级：</td>
						<td><s:property value="constructor.sepecialtyTypName" /></td>


					</tr>
					<tr>
						<td>注册证书编号：</td>
						<td><s:property value="constructor.certNum" /></td>
						<td>发证日期：</td>
						<td><s:date name="constructor.awardDate" format="yyyy-MM-dd" /></td>


					</tr>
					<tr>
						<td>发证单位：</td>
						<td><s:property value="constructor.awardDepart" /></td>
						<td>执业印章号：</td>
						<td><s:property value="constructor.stampNum" /></td>

					</tr>

					<tr>
						<td>注册有效期：</td>
						<td><s:date name="constructor.effectDate" format="yyyy-MM-dd" /></td>
						<td>所在企业行业类型（1-8）：</td>
						<td><s:property value="constructor.callingTypeName" /></td>


					</tr>
					<tr>
						<td>所在企业名称：</td>
						<td><s:property value="constructor.corpName" /></td>
						<td>所在企业组织代码证（1-8）：</td>
						<td><s:property value="constructor.corpCode" /></td>


					</tr>
					<tr>
						<td>所在企业证书编号：</td>
						<td><s:property value="constructor.certId" /></td>
						<td>注册专业编号（1-8）：</td>
						<td><s:property value="constructor.regTradeTypeName" /></td>


					</tr>
					<tr>
						<td>注册开始日期：</td>
						<td><s:date name="constructor.tradeTypeAwardDate"
								format="yyyy-MM-dd" /></td>
						<td>注册截止日期（1-8）：</td>
						<td><s:date name="constructor.tradeTypeEffectDate"
								format="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>职业资格状态：</td>
						<td><s:property value="constructor.stateName" /></td>

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
