<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>质量监督共享查询</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/qualityShareAction_goBack.action";
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

			<h2 class="f16 fb" style="background: #80aced;">质量监督共享查询</h2>
			<form id="form1" name="form1" method="post"
				action="<%=basepath%>/qualityAction_modify.action"
				enctype="multipart/form-data">
				<div class="ry_content">

					<div class="ry_lbxx">
						<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
							<table class="" cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<th>项目名称：</th>
										<td><s:property value="quality.prjName" />
										<input
											id="prjId" type="hidden" readonly name="quality.prjNum"
											value="<s:property value="quality.prjNum"/>" class="required" />
										<input type="hidden" readonly name="quality.safetyId"
											value="<s:property value="quality.safetyId"/>"
											class="required" /> 
										<input type="hidden"
											name="quality.createDate"
											value="<s:property value="quality.createDate"/>"> 
										<input
											type="hidden" name="quality.appDept"
											value="<s:property value="quality.appDept"/>"></td>
										<th>项目编号：</th>
										<td><s:property value="quality.prjNum" /></td>
									</tr>
									<tr>
										<th>申请企业名称：</th>
										<td><s:property value="quality.applyCorpName" /></td>
										<th>申请企业代码：</th>
										<td><s:property value="quality.applyCorpCode" /></td>
									</tr>
									<tr>
										<td colspan="4" align="left">概况</td>
									</tr>
									<tr>
										<th>工程名称：</th>
										<td><s:property value="quality.projectName" /><input
											type="hidden"
											value="<s:property value="quality.projectName"/>"
											id="projectName" /></td>
										<th>结构/层数：</th>
										<td><s:property value="quality.configuration" /></td>
									</tr>
									<tr>
										<th>工程地点：</th>
										<td><s:property value="quality.projectAddress" /></td>
										<th>联系人：</th>
										<td><s:property value="quality.contact" /></td>
									</tr>
									<tr>
										<th>建设面积(㎡)：</th>
										<td colspan="3"><s:property
												value="quality.constructionArea" />㎡</td>
									</tr>
									<tr>
										<th>安装工程量(万元)：</th>
										<td colspan="3"><s:property value="quality.quantities" />元</td>
									</tr>
									<tr>
										<th>工程总造价(万元)：</th>
										<td><s:property value="quality.expensive" />元</td>
										<th>监督费(元)：</th>
										<td><s:property value="quality.superviseCost" />元</td>
									</tr>
									<tr>
										<th>计划开工日期：</th>
										<td><s:date name="quality.startDate" format="yyyy-MM-dd" />
										</td>
										<th>计划竣工日期：</th>
										<td><s:date name="quality.endDate" format="yyyy-MM-dd" /></td>
									</tr>
									<tr>
										<th>建设单位：</th>
										<td><s:property value="quality.developmentOrganization" /><input
											type="hidden"
											value="<s:property value="quality.developmentOrganization"/>"
											id="corpName" /></td>
										<th>建设单位资质等级：</th>
										<td><s:property
												value="quality.developmentQualificationLevel" /></td>
									</tr>
									<tr>
										<th>建设单位项目负责人：</th>
										<td><s:property value="quality.developmentCharge" /></td>
										<th>建设单位联系电话：</th>
										<td><s:property value="quality.developmentPhone" /></td>
									</tr>
									<tr>
										<th>勘察单位：</th>
										<td><s:property value="quality.surveyUnit" /></td>
										<th>勘察单位资质等级：</th>
										<td><s:property
												value="quality.surveyUnitQualificationLevel" /></td>
									</tr>
									<tr>
										<th>勘察单位项目负责人：</th>
										<td><s:property value="quality.surveyUnitCharge" /></td>
										<th>勘察单位联系电话：</th>
										<td><s:property value="quality.surveyUnitPhone" /></td>
									</tr>
									<tr>
										<th>设计单位：</th>
										<td><s:property value="quality.designUnit" /></td>
										<th>设计单位资质等级：</th>
										<td><s:property
												value="quality.designUnitQualificationLevel" /></td>
									</tr>
									<tr>
										<th>设计单位项目负责人：</th>
										<td><s:property value="quality.designUnitCharge" /></td>
										<th>设计单位联系电话：</th>
										<td><s:property value="quality.designUnitPhone" /></td>
									</tr>
									<tr>
										<th>监理单位：</th>
										<td><s:property value="quality.supervisionUnit" /></td>
										<th>监理单位资质等级：</th>
										<td><s:property value="quality.supervisionUnitQualLevel" />
										</td>
									</tr>
									<tr>
										<th>监理单位总监理工程师：</th>
										<td><s:property value="quality.supervisionUnitEngineer" />
										</td>
										<th>监理单位联系电话：</th>
										<td><s:property value="quality.supervisionUnitPhone" /></td>
									</tr>
									<tr>
										<th>施工单位：</th>
										<td><s:property value="quality.constructionUnit" /></td>
										<th>施工单位资质等级：</th>
										<td><s:property value="quality.constructionUnitQualLevel" />
										</td>
									</tr>
									<tr>
										<th>施工单位项目经理：</th>
										<td><s:property
												value="quality.constructionUnitProjectManager" /></td>
										<th>施工单位联系电话 ：</th>
										<td><s:property value="quality.constructionUnitPhone" /></td>
									</tr>
									<tr>
										<th>施工图审查机构：</th>
										<td><s:property value="quality.constructionPlans" /></td>
										<th>类别 ：</th>
										<td><s:property value="quality.constructionPlansType" /></td>
									</tr>
									<tr>
										<th>施工图审查机构项目经理：</th>
										<td><s:property value="quality.constructionPlansCharge" />
										</td>
										<th>施工图审查机构联系电话 ：</th>
										<td><s:property value="quality.constructionPlansPhone" /></td>
									</tr>
									<!--<tr>
										<td colspan="4" align="left">承包资料</td>
									</tr>
									<tr>
										<th>资料名称</th>
										<th>文件号</th>
										<th>资料名称</th>
										<th>文件号</th>
									</tr>
									<tr>
										<th>施工合同</th>
										<td><s:property
												value="quality.constructionContractFileNum" /></td>
										<th>建设单位项目负责人及项目机构组成</th>
										<td><s:property value="quality.developmentOrganFileNum" />
										</td>
									</tr>
									<tr>
										<th>施工组织设计</th>
										<td><s:property value="quality.constructionOrganFileNum" />
										</td>
										<th>施工单位项目负责人及项目机构组成</th>
										<td><s:property value="quality.onstructionUnitFileNum" /></td>
									</tr>
									<tr>
										<th>施工图审查报告和批准书</th>
										<td><s:property value="quality.constructionPlansFileNum" />
										</td>
										<th>监理单位项目负责人及项目机构组成</th>
										<td><s:property value="quality.supervisionUnitFileNum" /></td>
									</tr>
									<tr>
										<th>监理合同</th>
										<td><s:property
												value="quality.supervisionContractFileNum" /></td>
										<th>施工现场项目负责人、技术人员资格证书</th>
										<td><s:property value="quality.constructionSiteFileNum" />
										</td>
									</tr>
									<tr>
										<th>监理规划</th>
										<td><s:property value="quality.supervisionPlanFileNum" /></td>
										<th>质量检查员岗位证书</th>
										<td><s:property value="quality.qualityTestingFileNum" /></td>
									</tr>
									<tr>
										<th>消防设计审查合格书面证明文件</th>
										<td><s:property value="quality.fireControlFileNum" /></td>
										<th>现场监理人员注册执业证书</th>
										<td><s:property value="quality.fieldSupervisionFileNum" />
										</td>
									</tr>
									<tr>
										<th>监督注册号：</th>
										<td><s:property value="quality.jianduzhuceNum" />
										<input type="hidden" id="jianduzhuceNum" value="<s:property value="quality.jianduzhuceNum" />"  />
										</td>
										<th>文件编号：</th>
										<td><s:property value="quality.wenjianNum" />
										<input type="hidden" id="wenjianNum" value="<s:property value="quality.wenjianNum" />"  />
										</td>
									</tr>
									  -->
									<tr>
				                      	<td>附件：</td>
										<td align="left" colspan="3">
										<s:iterator status="i" value="quality.list">
										<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a>&nbsp;<br />
										</s:iterator>
										</td>
									</tr>
								</tbody>
							</table>
							
							<div class="sp_bton">
								<a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
							</div>
			</form>
		</div>
	</div>

</body>
</html>