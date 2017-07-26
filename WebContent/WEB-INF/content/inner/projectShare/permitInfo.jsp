<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>施工许可共享查询</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/promiseShareAction_goBack.action";
		document.form1.submit();
	}
	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_downLoadFile.action?id="+uploadId;
		document.form1.submit();
	}
	
	//查询单位工程信息
	function querySingleProject(){
		var prjNum = $("#prjNum").val();
		var prjId = $("#prjId").val();
		var url = "<%=basepath %>/innerSingleProjectAction_queryPage.action?prjNum="+prjNum+"&prjId="+prjId+"&condition.prjId="+prjId+"&condition.linkName=5&linkName=5";
		var newWin=window.showModalDialog(url,window,'dialogHeight:900px;dialogWidth:1300px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	
	//查询企业详细
	function queryCorp(corpCode)
	{
		var url="<%=basepath %>/promiseShareAction_queryCorpInfo.action?corpCode="+corpCode;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">施工许可共享查询</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>工程名称：</td>
						<td colspan="3" align="center" valign="middle"><div align="center"><s:property value="permit.projectName" /></div></td>
					</tr>

					<tr>
						<td>项目名称：</td>
						<td><s:property value="permit.prjName" /> 
						<input type="hidden" id="prjNum" name="permit.prjNum"
							value="<s:property value="permit.prjNum"/>">
						<input type="hidden" id="permitId" name="permit.permitId"
							value="<s:property value="permit.permitId"/>">
						<input type="hidden" id="prjId" name="permit.prjId"
							value="<s:property value="permit.prjId"/>">
						</td>
						<td>项目编号：</td>
						<td><s:property value="permit.prjNum" /></td>
					</tr>

					<tr>
						<td>施工许可证编号：</td>
						<td><s:property value="permit.builderLicenceNum" /></td>
						<td>建设用地规划许可证编号：</td>
						<td><s:property value="permit.buldPlanNum" /></td>
					</tr>
					<tr>
						<td>建设工程规划许可证编号：</td>
						<td><s:property value="permit.projectPlanNum" /></td>
						<td>施工图审查合格书编号：</td>
						<td><s:property value="permit.censorNum" /></td>
					</tr>
					<tr>
						<td>合同金额(万元)：</td>
						<td><s:property value="permit.contractMoney" /></td>
						<td>面积(平方米)：</td>
						<td><s:property value="permit.area" /></td>
					</tr>
					<tr>
						<td>建设规模：</td>
						<td><s:property value="permit.prjSize" /></td>
						<td>发证日期：</td>
						<td><s:date name="permit.issueCertDate" format="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<td>勘察单位名称：</td>
						<td>
						<a href="#" onclick="queryCorp('<s:property value="permit.econCorpCode" />')">
						<s:property value="permit.econCorpName" />
						</a>
						</td>
						<td>勘察单位组织机构代码：</td>
						<td><s:property value="permit.econCorpCode" /></td>
					</tr>
					<tr>
						<td>设计单位名称：</td>
						<td>
						<a href="#" onclick="queryCorp('<s:property value="permit.designCorpCode" />')">
						<s:property value="permit.designCorpName" />
						</a>
						</td>
						<td>设计单位组织机构代码：</td>
						<td><s:property value="permit.designCorpCode" /></td>
					</tr>
					<tr>
						<td>施工单位名称：</td>
						<td>
						<a href="#" onclick="queryCorp('<s:property value="permit.consCorpCode" />')">
						<s:property value="permit.consCorpname" />
						</a>
						</td>
						<td>施工单位组织机构代码：</td>
						<td><s:property value="permit.consCorpCode" /></td>
					</tr>
					<tr>
						<td>施工单位安全生产许可证编号：</td>
						<td><s:property value="permit.safetyCerId" /></td>
						<td>监理单位名称 ：</td>
						<td>
						<a href="#" onclick="queryCorp('<s:property value="permit.superCorpCode" />')">
						<s:property value="permit.superCorpName" />
						</a>
						</td>
					
					</tr>
					<tr>
						<td>监理单位组织机构代码：</td>
						<td><s:property value="permit.superCorpCode" /></td>
						<td>项目经理姓名：</td>
						<td><s:property value="permit.constructorName" /></td>
					</tr>
					<tr>
						<td>项目经理证件类型：</td>
						<td><s:if test="permit.cidCardTypeNum==1">身份证</s:if> <s:if
								test="permit.cidCardTypeNum==2">军官证</s:if> <s:if
								test="permit.cidCardTypeNum==3">护照</s:if> <s:if
								test="permit.cidCardTypeNum==4">台湾居民身份证</s:if> <s:if
								test="permit.cidCardTypeNum==5">香港永久居民身份证</s:if> <s:if
								test="permit.cidCardTypeNum==6">警官证</s:if> <s:if
								test="permit.cidCardTypeNum==7">其他</s:if></td>
						<td>项目经理证件号码：</td>
						<td><s:property value="permit.constructorIdCard" /></td>
					</tr>
					<tr>
						<td>总监理工程师姓名：</td>
						<td><s:property value="permit.supervisionName" /></td>
						<td>总监理工程师证件类型：</td>
						<td><s:if test="permit.sidCardTypeNum==1">身份证</s:if> <s:if
								test="permit.sidCardTypeNum==2">军官证</s:if> <s:if
								test="permit.sidCardTypeNum==3">护照</s:if> <s:if
								test="permit.sidCardTypeNum==4">台湾居民身份证</s:if> <s:if
								test="permit.sidCardTypeNum==5">香港永久居民身份证</s:if> <s:if
								test="permit.sidCardTypeNum==6">警官证</s:if> <s:if
								test="permit.sidCardTypeNum==7">其他</s:if></td>
					</tr>
					<tr>
						<td>总监理工程师身份证号码：</td>
						<td><s:property value="permit.supervisionIdCard" /></td>
						<td>记录登记日期：</td>
						<td><s:date name="permit.createDate" format="yyyy-MM-dd" /></td>
						<!-- 
						<td>安全生产管理人员姓名：</td>
						<td><s:property value="permit.userName" /></td>
						 -->
					</tr>
					<!-- 
					<tr>
						<td>安全生产管理证件类型：</td>
						<td><s:if test="permit.idCardTypeNum==1">身份证</s:if> <s:if
								test="permit.idCardTypeNum==2">军官证</s:if> <s:if
								test="permit.idCardTypeNum==3">护照</s:if> <s:if
								test="permit.idCardTypeNum==4">台湾居民身份证</s:if> <s:if
								test="permit.idCardTypeNum==5">香港永久居民身份证</s:if> <s:if
								test="permit.idCardTypeNum==6">警官证</s:if> <s:if
								test="permit.idCardTypeNum==7">其他</s:if></td>
						<td>安全生产管理人员姓名：</td>
						<td><s:property value="permit.userName" /></td>
					</tr>
					<tr>
						<td>安全生产管理人员证件号：</td>
						<td><s:property value="permit.idCard" /></td>
						<td>安全生产考核合格证书编号：</td>
						<td><s:property value="permit.certId" /></td>
					</tr>
					<tr>
						<td>安全生产管理人员类型：</td>
						<td><s:if test="permit.userType==1">主要负责人</s:if> <s:if
								test="permit.userType==2">项目负责人</s:if> <s:if
								test="permit.userType==3">安全员</s:if></td>
						<td>记录登记日期：</td>
						<td><s:date name="permit.createDate" format="yyyy-MM-dd" /></td>
					</tr>
					 -->
					<tr>
						<td colspan="4" align="left"><center><strong>
						<a href="#" onclick="querySingleProject()">
						单体工程(点击查看)
						</a></strong></center>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
	                    <td>附件：</td>
						<td align="left" colspan="3">
						<s:iterator status="i" value="permit.list">
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