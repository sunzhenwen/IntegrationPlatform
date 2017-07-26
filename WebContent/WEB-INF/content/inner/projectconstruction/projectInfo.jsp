<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业申报项目详细查看</title>

</head>
<body>
<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">申请项目审批</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>项目编号：</td>
						<td><s:property value="project.prjNum" /> <input
							type="hidden" name="project.prjId"
							value="<s:property value="project.prjId"/>" /></td>
						<td>项目名称：</td>
						<td><s:property value="project.prjName" /></td>
					</tr>

					<tr>
						<td>项目分类：</td>
						<td><s:property value="project.prjTypeName" /><input
							type="hidden" name="project.prjTypeNum"
							value="<s:property value="project.prjTypeNum"/>" /></td>
						<td>建设单位名称：</td>
						<td><s:property value="project.buildCorpName" /></td>
					</tr>
					<tr>
						<td>建设单位组织机构代码证：</td>
						<td><s:property value="project.buildCorpCode" /></td>
						<td>项目所在省：</td>
						<td><s:property value="project.provinceName" /><input
							type="hidden" name="project.countyNum"
							value="<s:property value="project.countyNum"/>" /></td>
					</tr>
					<tr>
						<td>项目所在市：</td>
						<td><s:property value="project.cityName" /></td>
						<td>项目所在地：</td>
						<td><s:property value="project.countyName" /></td>
					</tr>
					<tr>
						<td>立项文号：</td>
						<td><s:property value="project.prjApprovalNum" /></td>
						<td>立项级别：</td>
						<td><s:property value="project.prjApprovalLevelName" /></td>
					</tr>
					<tr>
						<td>建设用地规划许可证编号：</td>
						<td><s:property value="project.buldPlanNum" /></td>
						<td>建设工程规划许可证编号：</td>
						<td><s:property value="project.projectPlanNum" /></td>
					</tr>
					<tr>
						<td>总投资（万元）：</td>
						<td><s:property value="project.allInvest" /></td>
						<td>总面积（平方米）：</td>
						<td><s:property value="project.allArea" /></td>
					</tr>
					<tr>
						<td>建设规模：</td>
						<td><s:property value="project.prjSize" /></td>
						<td>建设性质：</td>
						<td><s:property value="project.prjPropertyName" /></td>
					</tr>
					<tr>
						<td>工程用途：</td>
						<td><s:property value="project.prjFunctionName" /></td>
						<td>实际开工日期：</td>
						<td><s:date name="project.beginDate" format="yyyy-MM-dd" />
							<input type="hidden" name="project.appDept" value="<s:property value="project.appDept" />">
						</td>
					</tr>
					<tr>
						<td>实际竣工日期：</td>
						<td><s:date name="project.endDate" format="yyyy-MM-dd" /></td>
						<td>登记日期：</td>
						<td><s:date name="project.createDate" format="yyyy-MM-dd" />
							<input type="hidden" name="project.createDate"
							value="<s:property value="project.createDate" />" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>