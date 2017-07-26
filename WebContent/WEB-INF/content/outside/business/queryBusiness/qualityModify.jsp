<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业质量监督申请 </title>
<script type="text/javascript">

	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/queryQualityAction_goList.action";
		document.form1.submit();
	}
	
</script>

</head>

<body>
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>企业质量监督申请</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td align="left">
							<input id="prjName" type="text" readonly name="quality.prjName" value="<s:property value="quality.prjName"/>" class="required"/>
							<input id="prjId" type="hidden" readonly name="quality.prjId" value="<s:property value="quality.prjId"/>" class="required"/>
							<input type="hidden" readonly name="quality.qualityId" value="<s:property value="quality.qualityId"/>" class="required"/>
							</td>
							<th>项目编号：</th>
							<td align="left">
							<input id="prjNum" type="text" readonly name="quality.prjNum" value="<s:property value="quality.prjNum"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>申请企业名称：</th>
							<td align="left">
							<input type="text" readonly name="quality.applyCorpName" value="<s:property value="quality.applyCorpName"/>" class="required"/>
							</td>
							<th>申请企业代码：</th>
							<td align="left">
							<input type="text" readonly name="quality.applyCorpCode" value="<s:property value="quality.applyCorpCode"/>" class="required"/>
							<input id="appDeptName" readonly type="hidden" name="quality.appDeptName" value="<s:property value="quality.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="quality.appDept" value="<s:property value="quality.appDept"/>"/>
							</td>
                         </tr>
                         <tr>
							<th>质量监督编号：</th>
							<td colspan="3" align="left">
								<input type="text" size="110" readonly name="quality.qualityNum" value="<s:property value="quality.qualityNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                         <tr>
                         	<td colspan="4" align="left">概况</td>
                         </tr>
                         <tr>
                         	<th>监督注册号：</th>
							<td align="left">
							<input type="text" name="quality.jianduzhuceNum" value="<s:property value="quality.jianduzhuceNum"/>" class="required"/>
							</td>
							<th>文件编号：</th>
							<td align="left">
							<input type="text" name="quality.wenjianNum" value="<s:property value="quality.wenjianNum"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>工程名称：</th>
							<td align="left">
							<input type="text" name="quality.projectName" value="<s:property value="quality.projectName"/>" class="required"/>
							</td>
							<th>结构/层数：</th>
							<td align="left">
							<input type="text" name="quality.configuration" value="<s:property value="quality.configuration"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>工程地点：</th>
							<td align="left">
							<input type="text" name="quality.projectAddress" value="<s:property value="quality.projectAddress"/>" class="required"/>
							</td>
							<th>联系人：</th>
							<td align="left">
							<input type="text" name="quality.contact" value="<s:property value="quality.contact"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>建设面积(㎡)：</th>
							<td colspan="3" align="left">
							<input size="112" type="text" name="quality.constructionArea" value="<s:property value="quality.constructionArea"/>" class="required number"/>
							</td>
						</tr>
						<!-- 
						<tr>
                         	<th>安装工程量(万元)：</th>
							<td colspan="3">
							<input size="112" type="text" name="quality.quantities" value="<s:property value="quality.quantities"/>" class="required number"/>
							</td>
						</tr>
						 -->
                         <tr>
                         	<th>工程总造价(万元)：</th>
							<td align="left">
							<input type="text" name="quality.expensive" value="<s:property value="quality.expensive"/>" class="required number"/>
							</td>
							<!-- 
							<th>监督费(元)：</th>
							<td>
							<input type="text" name="quality.superviseCost" value="<s:property value="quality.superviseCost"/>" class="required number"/>
							</td>
							 -->
							 <th>&nbsp;</th>
							 <td>&nbsp;</td>
                         </tr>
                         <tr>
                         	<th>计划开工日期：</th>
							<td align="left">
							<input id="time1" type="text" name="quality.startDate" value="<s:date name="quality.startDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" />
							</td>
							<th>计划竣工日期：</th>
							<td align="left">
							<input id="time2" type="text" name="quality.endDate" value="<s:date name="quality.endDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" />
							</td>
                         </tr>
                          <tr>
                         	<th>建设单位：</th>
							<td align="left">
							<input type="text" name="quality.developmentOrganization" value="<s:property value="quality.developmentOrganization"/>" class="required"/>
							</td>
							<th>建设单位资质等级：</th>
							<td align="left">
							<input type="text" name="quality.developmentQualificationLevel" value="<s:property value="quality.developmentQualificationLevel"/>" class="required"/>
							</td>
                         </tr>
                          <tr>
                         	<th>建设单位项目负责人：</th>
							<td align="left">
							<input type="text" name="quality.developmentCharge" value="<s:property value="quality.developmentCharge"/>" class="required"/>
							</td>
							<th>建设单位联系电话：</th>
							<td align="left">
							<input type="text" name="quality.developmentPhone" value="<s:property value="quality.developmentPhone"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>勘察单位：</th>
							<td align="left">
							<input type="text" name="quality.surveyUnit" value="<s:property value="quality.surveyUnit"/>" class="required"/>
							</td>
							<th>勘察单位资质等级：</th>
							<td align="left">
							<input type="text" name="quality.surveyUnitQualificationLevel" value="<s:property value="quality.surveyUnitQualificationLevel"/>" class="required"/>
							</td>
                         </tr>
                          <tr>
                         	<th>勘察单位项目负责人：</th>
							<td align="left">
							<input type="text" name="quality.surveyUnitCharge" value="<s:property value="quality.surveyUnitCharge"/>" class="required"/>
							</td>
							<th>勘察单位联系电话：</th>
							<td align="left">
							<input type="text" name="quality.surveyUnitPhone" value="<s:property value="quality.surveyUnitPhone"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>设计单位：</th>
							<td align="left">
							<input type="text" name="quality.designUnit" value="<s:property value="quality.designUnit"/>" class="required"/>
							</td>
							<th>设计单位资质等级：</th>
							<td align="left">
							<input type="text" name="quality.designUnitQualificationLevel" value="<s:property value="quality.designUnitQualificationLevel"/>" class="required"/>
							</td>
                         </tr>
                          <tr>
                         	<th>设计单位项目负责人：</th>
							<td align="left">
							<input type="text" name="quality.designUnitCharge" value="<s:property value="quality.designUnitCharge"/>" class="required"/>
							</td>
							<th>设计单位联系电话：</th>
							<td align="left">
							<input type="text" name="quality.designUnitPhone" value="<s:property value="quality.designUnitPhone"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>监理单位：</th>
							<td align="left">
							<input type="text" name="quality.supervisionUnit" value="<s:property value="quality.supervisionUnit"/>" class="required"/>
							</td>
							<th>监理单位资质等级：</th>
							<td align="left">
							<input type="text" name="quality.supervisionUnitQualLevel" value="<s:property value="quality.supervisionUnitQualLevel"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>监理单位总监理工程师：</th>
							<td align="left">
							<input type="text" name="quality.supervisionUnitEngineer" value="<s:property value="quality.supervisionUnitEngineer"/>" class="required"/>
							</td>
							<th>监理单位联系电话：</th>
							<td align="left">
							<input type="text" name="quality.supervisionUnitPhone" value="<s:property value="quality.supervisionUnitPhone"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>施工单位：</th>
							<td align="left">
							<input type="text" name="quality.constructionUnit" value="<s:property value="quality.constructionUnit"/>" class="required"/>
							</td>
							<th>施工单位资质等级：</th>
							<td align="left">
							<input type="text" name="quality.constructionUnitQualLevel" value="<s:property value="quality.constructionUnitQualLevel"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>施工单位项目经理：</th>
							<td align="left">
							<input type="text" name="quality.constructionUnitProjectManager" value="<s:property value="quality.constructionUnitProjectManager"/>" class="required"/>
							</td>
							<th>施工单位联系电话 ：</th>
							<td align="left">
							<input type="text" name="quality.constructionUnitPhone" value="<s:property value="quality.constructionUnitPhone"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>施工图审查机构：</th>
							<td align="left">
							<input type="text" name="quality.constructionPlans" value="<s:property value="quality.constructionPlans"/>" class="required"/>
							</td>
							<th>类别 ：</th>
							<td align="left">
							<input type="text" name="quality.constructionPlansType" value="<s:property value="quality.constructionPlansType"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>施工图审查机构项目经理：</th>
							<td align="left">
							<input type="text" name="quality.constructionPlansCharge" value="<s:property value="quality.constructionPlansCharge"/>" class="required"/>
							</td>
							<th>施工图审查机构联系电话 ：</th>
							<td align="left">
							<input type="text" name="quality.constructionPlansPhone" value="<s:property value="quality.constructionPlansPhone"/>" class="required"/>
							</td>
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
							<td>
							<input type="text" name="quality.constructionContractFileNum" value="<s:property value="quality.constructionContractFileNum"/>" class="required"/>
							</td>
							<th>建设单位项目负责人及项目机构组成</th>
							<td>
							<input type="text" name="quality.developmentOrganFileNum" value="<s:property value="quality.developmentOrganFileNum"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>施工组织设计</th>
							<td>
							<input type="text" name="quality.constructionOrganFileNum" value="<s:property value="quality.constructionOrganFileNum"/>" class="required"/>
							</td>
							<th>施工单位项目负责人及项目机构组成</th>
							<td>
							<input type="text" name="quality.onstructionUnitFileNum" value="<s:property value="quality.onstructionUnitFileNum"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>施工图审查报告和批准书</th>
							<td>
							<input type="text" name="quality.constructionPlansFileNum" value="<s:property value="quality.constructionPlansFileNum"/>" class="required"/>
							</td>
							<th>监理单位项目负责人及项目机构组成</th>
							<td>
							<input type="text" name="quality.supervisionUnitFileNum" value="<s:property value="quality.supervisionUnitFileNum"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>监理合同</th>
							<td>
							<input type="text" name="quality.supervisionContractFileNum" value="<s:property value="quality.supervisionContractFileNum"/>" class="required"/>
							</td>
							<th>施工现场项目负责人、技术人员资格证书</th>
							<td>
							<input type="text" name="quality.constructionSiteFileNum" value="<s:property value="quality.constructionSiteFileNum"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>监理规划</th>
							<td>
							<input type="text" name="quality.supervisionPlanFileNum" value="<s:property value="quality.supervisionPlanFileNum"/>" class="required"/>
							</td>
							<th>质量检查员岗位证书</th>
							<td>
							<input type="text" name="quality.qualityTestingFileNum" value="<s:property value="quality.qualityTestingFileNum"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>消防设计审查合格书面证明文件</th>
							<td>
							<input type="text" name="quality.fireControlFileNum" value="<s:property value="quality.fireControlFileNum"/>" class="required"/>
							</td>
							<th>现场监理人员注册执业证书</th>
							<td>
							<input type="text" name="quality.fieldSupervisionFileNum" value="<s:property value="quality.fieldSupervisionFileNum"/>" class="required"/>
							</td>
                         </tr>
                           -->
                        <tr>
                       		<th>附件：</th>
							<td align="left" colspan="3">
							<s:iterator status="i" value="quality.list">
							<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a><br />
							</s:iterator>
							</td>
						</tr>
                </tbody>  
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
		        </div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
