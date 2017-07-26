<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>项目设计共享查询</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/designShareAction_goPage.action";
		document.form1.submit();
	}
	
	//查询计划详细
	function getProject(prjNum){
		var openUrl = "<%=basepath%>/projectConstructionAction_getProjectInfo.action?prjNum="
				+ prjNum;
		openUrl = encodeURI(openUrl);
		openUrl = encodeURI(openUrl);
		window.open(openUrl)
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

			<h2 class="f16 fb" style="background: #80aced;">项目设计共享查询</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>项目编号：</td>
						<td><s:property value="design.prjNum" /> <input
							type="hidden" name="design.designId"
							value="<s:property value="design.designId"/>"> <input
							type="hidden" name="design.prjNum"
							value="<s:property value="design.prjNum"/>"> <input
							type="hidden" name="design.createDate"
							value="<s:property value="design.createDate"/>"> <input
							type="hidden" name="design.appDept"
							value="<s:property value="design.appDept"/>"></td>
						<td>项目详细信息：</td>
						<td><a href="#"
							onclick="getProject('<s:property value="design.prjNum"/>')">查看详细</a>
						</td>
					</tr>

					<tr>
						<td>设计编码：</td>
						<td><s:property value="design.designNum" /></td>
						<td>设计单位名称：</td>
						<td><s:property value="design.designCorpName" /></td>
					</tr>
					<tr>
						<td>设计单位组织机构代码证：</td>
						<td><s:property value="design.designCorpCode" /></td>
						<td>申请企业组织机构代码证：</td>
						<td><s:property value="design.applyCorpCode" /></td>
					</tr>
					
					<tr>
                      	<td>附件：</td>
						<td align="left" colspan="3">
						<s:iterator status="i" value="design.list">
						<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a>&nbsp;<br />
						</s:iterator>
						</td>
					</tr>
				</table>

				<s:if test="design.isUnits == 0">
					<h2>单位工程</h2>
					<table class="sp_mtable" style="border-collapse: collapse;"
						cellpadding="0" cellspacing="0">
						<tr>
							<td>序号</td>
							<td>资质类型</td>
							<td>资质等级</td>
							<td>证书编号</td>
						</tr>
						<s:iterator status="i" value="design.designQualifications" >
							<tr>
								<td><s:property value="#i.count" /></td>
								<td><s:property value="certTypeName" /></td>
								<td><s:property value="titleLevelName" /></td>
								<td><s:property value="certId" /></td>
							</tr>
						</s:iterator>
					</table>
				</s:if>
				<div class="sp_bton">
				    <a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
				</div>
			</form>
		</div>
	</div>
	

	
</body>
</html>