<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>合同备案共享查询</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/filingShareAction_goBack.action";
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

			<h2 class="f16 fb" style="background: #80aced;">合同备案共享查询</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>合同备案编号：</td>
						<td><s:property value="filing.recordNum" /> <input
							type="hidden" name="filing.recordId"
							value="<s:property value="filing.recordId"/>"><input
							type="hidden" name="filing.createDate"
							value="<s:property value="filing.createDate"/>"> <input
							type="hidden" name="filing.appDept"
							value="<s:property value="filing.appDept"/>"></td>
						<td>项目编号：</td>
						<td><s:property value="filing.prjNum" /></td>
					</tr>

					<tr>
						<td>项目名称：</td>
						<td><s:property value="filing.prjName" /> <input
							type="hidden" name="filing.prjNum"
							value="<s:property value="filing.prjNum"/>"></td>
						<td>合同类别：</td>
						<td><s:property value="filing.contractTypeName" /></td>
					</tr>
					<tr>
						<td>合同金额（万元）：</td>
						<td><s:property value="filing.contractMoney" /></td>
						<td>建设规模：</td>
						<td><s:property value="filing.prjSize" /></td>
					</tr>
					<tr>
						<td>合同签订日期：</td>
						<td><s:date name="filing.contractDate" format="yyyy-MM-dd" /></td>
						<td>发包单位名称：</td>
						<td><s:property value="filing.propietorCorpName" /></td>
					</tr>
					<tr>
						<td>发包单位组织机构代码：</td>
						<td><s:property value="filing.propietorCorpCode" /></td>
						<td>承包单位名称：</td>
						<td><s:property value="filing.contractorCorpName" /></td>
					</tr>
					<tr>
						<td>承包单位组织机构代码：</td>
						<td><s:property value="filing.contractorCorpCode" /></td>
						<td>联合体承包单位名称：</td>
						<td><s:property value="filing.unionCorpName" /></td>
					</tr>
					<tr>
						<td>联合体承包组织机构代码：</td>
						<td><s:property value="filing.unionCorpCode" /></td>
						<td>记录登记时间：</td>
						<td><s:date name="filing.createDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>申请企业组织机构代码：</td>
						<td><s:property value="filing.applyCorpCode" /></td>
						<td>申请企业名称：</td>
						<td><s:property value="filing.applyCorpName" /></td>
					</tr>
					
					<tr>
						<td>合同编号：</td>
						<td><s:property value="filing.contractNum" /></td>
						<td>&nbsp;</td>
						<td>
							&nbsp;
						</td>
					</tr>
					
					<tr>
                      	<td>附件：</td>
						<td align="left" colspan="3">
						<s:iterator status="i" value="filing.list">
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