<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>施工图审查共享查询</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/planShareAction_goBack.action";
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

			<h2 class="f16 fb" style="background: #80aced;">施工图审查共享查询</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>施工图审查合格证书编号：</td>
						<td><s:property value="plan.censorNum" /> <input
							type="hidden" name="plan.censorId"
							value="<s:property value="plan.censorId"/>"><input
							type="hidden" name="plan.createDate"
							value="<s:property value="plan.createDate"/>"> <input
							type="hidden" name="plan.appDept"
							value="<s:property value="plan.appDept"/>"></td>
						<td>项目编号：</td>
						<td><s:property value="plan.prjNum" /></td>
					</tr>

					<tr>
						<td>项目名称：</td>
						<td><s:property value="plan.prjName" /> <input type="hidden"
							name="plan.prjNum" value="<s:property value="plan.prjNum"/>"></td>
						<td>施工图审查机构名称：</td>
						<td><s:property value="plan.censorCorpName" /></td>
					</tr>
					<tr>
						<td>施工图审查机构组织机构代码：</td>
						<td><s:property value="plan.censorCorpCode" /></td>
						<td>审查完成日期：</td>
						<td><s:date name="plan.censorEDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>建设规模：</td>
						<td><s:property value="plan.prjSize" /></td>
						<td>勘察单位名称：</td>
						<td><s:property value="plan.econCorpName" /></td>
					</tr>
					<tr>
						<td>勘察单位组织机构代码：</td>
						<td><s:property value="plan.econCorpCode" /></td>
						<td>勘察单位名称2：</td>
						<td><s:property value="plan.econCorpName2" /></td>
					</tr>
					<tr>
						<td>勘察单位组织机构代码2：</td>
						<td><s:property value="plan.econCorpCode2" /></td>
						<td>勘察单位名称3：</td>
						<td><s:property value="plan.econCorpName3" /></td>
					</tr>
					<tr>
						<td>勘察单位组织机构代码3：</td>
						<td><s:property value="plan.econCorpCode3" /></td>
						<td>设计单位名称：</td>
						<td><s:property value="plan.designCorpName" /></td>
					</tr>
					<tr>
						<td>设计单位组织机构代码：</td>
						<td><s:property value="plan.designCorpCode" /></td>
						<td>设计单位名称2：</td>
						<td><s:property value="plan.designCorpName2" /></td>
					</tr>
					<tr>
						<td>设计单位组织机构代码2：</td>
						<td><s:property value="plan.designCorpCode2" /></td>
						<td>设计单位名称3：</td>
						<td><s:property value="plan.designCorpName3" /></td>
					</tr>
					<tr>
						<td>设计单位组织机构代码3：</td>
						<td><s:property value="plan.designCorpCode3" /></td>
						<td>一次审查是否通过：</td>
						<td><s:if test="plan.oneCensorIsPass == 0">不通过</s:if><s:if test="plan.oneCensorIsPass == 1">通过</s:if></td>
					</tr>
					<tr>
						<td>一次审查时违反强条数：</td>
						<td><s:property value="plan.oneCensorWfqtCount" /></td>
						<td>一次审查时违反的强条条目：</td>
						<td><s:property value="plan.oneCensorWfqtContent" /></td>
					</tr>
					<tr>
						<td>申请企业组织机构代码：</td>
						<td><s:property value="plan.applyCorpCode" /></td>
						<td>申请企业名称：</td>
						<td><s:property value="plan.applyCorpName" /></td>
					</tr>
					<tr>
                      	<td>附件：</td>
						<td align="left" colspan="3">
						<s:iterator status="i" value="plan.list">
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