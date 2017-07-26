<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>项目报建审核历史查询</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/projectShareAction_goPage.action";
		document.form1.submit();
	}
	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_downLoadFile.action?id="+uploadId;
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">项目报建审核历史查询</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>项目编号：</td>
						<td><s:property value="construction.prjNum" /> <input
							type="hidden" name="construction.prjId"
							value="<s:property value="construction.prjId"/>" /></td>
						<td>项目名称：</td>
						<td><s:property value="construction.prjName" /></td>
					</tr>

					<tr>
						<td>项目分类：</td>
						<td><s:property value="construction.prjTypeName" /><input
							type="hidden" name="construction.prjTypeNum"
							value="<s:property value="construction.prjTypeNum"/>" /></td>
						<td>建设单位名称：</td>
						<td><s:property value="construction.buildCorpName" /></td>
					</tr>
					<tr>
						<td>建设单位组织机构代码证：</td>
						<td><s:property value="construction.buildCorpCode" /></td>
						<td>项目所在省：</td>
						<td><s:property value="construction.provinceName" /><input
							type="hidden" name="construction.countyNum"
							value="<s:property value="construction.countyNum"/>" /></td>
					</tr>
					<tr>
						<td>项目所在市：</td>
						<td><s:property value="construction.cityName" /></td>
						<td>项目所在地：</td>
						<td><s:property value="construction.countyName" /></td>
					</tr>
					<tr>
						<td>立项文号：</td>
						<td><s:property value="construction.prjApprovalNum" /></td>
						<td>立项级别：</td>
						<td><s:property value="construction.prjApprovalLevelName" /></td>
					</tr>
					<tr>
						<td>建设用地规划许可证编号：</td>
						<td><s:property value="construction.buldPlanNum" /></td>
						<td>建设工程规划许可证编号：</td>
						<td><s:property value="construction.projectPlanNum" /></td>
					</tr>
					<tr>
						<td>开工日期：</td>
						<td><s:date name="construction.BDate" format="yyyy-MM-dd" /></td>
						<td>竣工日期：</td>
						<td><s:date name="construction.EDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>总投资（万元）：</td>
						<td><s:property value="construction.allInvest" /></td>
						<td>总面积（平方米）：</td>
						<td><s:property value="construction.allArea" /></td>
					</tr>
					<tr>
						<td>建设规模：</td>
						<td><s:property value="construction.prjSize" /></td>
						<td>建设性质：</td>
						<td><s:property value="construction.prjPropertyName" /></td>
					</tr>
					<tr>
						<td>工程用途：</td>
						<td><s:property value="construction.prjFuncitonName" /></td>
						<td>登记日期：</td>
						<td><s:date name="construction.createDate" format="yyyy-MM-dd" />
							<input type="hidden" name="construction.createDate"
							value="<s:property value="construction.createDate" />" /></td>
					</tr>
					<tr>
						<td>详细地址：</td>
						<td colspan="3"><div align="center"><s:property value="construction.address" /></div></td>
					</tr>
					
					<tr>
                      	<td>附件：</td>
						<td align="left" colspan="3">
						<s:iterator status="i" value="construction.list">
						<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a>&nbsp;<br />
						</s:iterator>
						</td>
					</tr>
				</table>
				
				<div class="sp_bton">
					<a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>