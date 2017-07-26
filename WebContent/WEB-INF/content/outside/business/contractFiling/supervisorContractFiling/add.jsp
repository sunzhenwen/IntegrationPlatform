<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业监理合同备案 </title>
<script type="text/javascript">

	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            var check = /^([1-9]\d*|0)(\.\d*[1-9])?$/; 
	 			var allInvest = $("#allInvest").val();
	 			var sectionName = $("#sectionName").val();
	 			var prjName = $("#prjName").val();
	 			if (!check.exec(allInvest)) 
	 			{
	 				alert("合同金额不能为负数!");
	 			}else
	 			{
	 				if(prjName=="" || prjName==null)
	 				{
	 					alert("请选择项目名称!");
	 				}else if(sectionName=="" || sectionName==null)
	 				{
	 					alert("请选择标段名称!");
	 				}else
		 			{
		 				form.submit();
		 			}
	 			}
	 		}    
	 	});
	});

	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/supervisorContractFilingAction_goList.action";
		document.form1.submit();
	}
	
	//查询项目
	function queryPrjName()
	{
		var url1="<%=basepath %>/queryPrjsAction_queryPage.action";
		var newWin1=window.showModalDialog(url1,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin1.open()
	}
	
	//查询招投标信息
	function queryTenderInfo()
	{
		var prjNum = $("#prjNum").val();
		var url="<%=basepath %>/supervisorTenderInfoAction_queryPage.action?condition.prjNum="+prjNum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
	
	//查询资质信息
	function queryTitleLeve()
	{
		var tenderCorpCode = $("#tenderCorpCode").val();
		var url2="<%=basepath %>/querySupervisorTitleLeveAction_queryPage.action?condition.tenderCorpCode="+tenderCorpCode;
		var newWin2=window.showModalDialog(url2,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin2.open()
	}
</script>

</head>

<body>
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="<%=basepath %>/supervisorContractFilingAction_add.action">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>企业监理合同备案</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td colspan="4" align="left">
							<input id="prjName" size="100" type="text" readonly name="contractFiling.prjName" value="<s:property value="contractFiling.prjName"/>" class="required"/>
							<a href="#" onclick="queryPrjName()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							
							<input id="prjId" type="hidden" readonly name="contractFiling.prjId" value="<s:property value="contractFiling.prjId"/>" class="required"/>
							<input type="hidden" name="contractFiling.contractTypeNum" value="<s:property value="400"/>" class="required"/>
							<input id="qualificationsTypeName" type="hidden" name="contractFiling.qualificationsTypeName" value="<s:property value="contractFiling.qualificationsTypeName"/>"/>
							<input id="specialtyTypeName" type="hidden" name="contractFiling.specialtyTypeName" value="<s:property value="contractFiling.specialtyTypeName"/>"/>
							<input id="ratingName" type="hidden" name="contractFiling.ratingName" value="<s:property value="contractFiling.ratingName"/>" />
							<input id="qualificationsType" type="hidden" name="contractFiling.qualificationsType" value="<s:property value="contractFiling.qualificationsType"/>"/>
							<input id="specialtyType" type="hidden" name="contractFiling.specialtyType" value="<s:property value="contractFiling.specialtyType"/>" />
							<input id="rating" type="hidden" name="contractFiling.rating" value="<s:property value="contractFiling.rating"/>" />
							</td>
							
                         </tr>
                         <tr>
                         	<th>标段名称：</th>
							<td colspan="4" align="left">
							<input id="sectionName" size="100" type="text"  />
							<a href="#" onclick="queryTenderInfo()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							
							</td>
						 </tr>
						  <tr>
                         	<th>工程名称：</th>
							<td colspan="4" align="left">
							<input id="projectName" size="100" type="text" name="contractFiling.sectionName" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                         <tr>
                         	<th>项目编号：</th>
							<td align="left">
							<input id="prjNum" type="text" readonly name="contractFiling.prjNum" value="<s:property value="contractFiling.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	<th>中标通知书编号：</th>
							<td align="left">
							<input id="tenderNum" type="text" name="contractFiling.tenderNum" />
							</td>
						 </tr>
                         <tr>
                         	<th>工程造价(万元)：</th>
							<td align="left">
							<input id="projectCost" type="text" name="contractFiling.projectCost" class="required number" />
							</td>
                         	<th>项目地址：</th>
							<td align="left">
							<input id="projectAddress" type="text" name="contractFiling.projectAddress" />
							</td>
						 </tr>
                         
                         <tr>
                         	<th>合同编号：</th>
							<td align="left">
							<input type="text" name="contractFiling.contractNum" value="<s:property value="contractFiling.contractNum"/>" />
							</td>
							<th>建筑面积：</th>
							<td align="left">
							<input id="area" type="text" name="contractFiling.area" value="<s:property value="contractFiling.area"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                         <tr>
                         	<th>合同金额(万元)：</th>
							<td align="left">
							<input id="allInvest" type="text" name="contractFiling.contractMoney" value="<s:property value="contractFiling.contractMoney"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>合同签订日期：</th>
							<td align="left">
							<input id="time1" type="text" name="contractFiling.contractDate" value="<s:date name="contractFiling.contractDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong>
							</td>
							
							
						</tr>
						<tr>
                         	<th>发包单位名称：</th>
							<td align="left">
							<input id="propietorCorpName" type="text" name="contractFiling.propietorCorpName" value="<s:property value="contractFiling.propietorCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>发包单位组织机构代码：</th>
							<td align="left">
							<input id="propietorCorpCode" type="text" name="contractFiling.propietorCorpCode" value="<s:property value="contractFiling.propietorCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
						
						<tr>
                         	<th>承包单位名称：</th>
							<td colspan="4" align="left">
							<input id="tenderCorpName" size="100" type="text" name="contractFiling.contractorCorpName" value="<s:property value="contractFiling.contractorCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
						</tr>
						<tr>
							<th>承包单位组织机构代码：</th>
							<td align="left">
							<input id="tenderCorpCode" type="text" name="contractFiling.contractorCorpCode" value="<s:property value="contractFiling.contractorCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>资质等级：</th>
							<td align="left">
							<input id="titleLeve" type="text" name="contractFiling.titleLeve" value="<s:property value="contractFiling.titleLeve"/>" class="required"/>
							<a href="#" onclick="queryTitleLeve()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							
							</td>
						</tr>
						<tr>
                         	<th>项目负责人：</th>
							<td align="left">
							<input id="constructorName" type="text" name="contractFiling.constructorName" value="<s:property value="contractFiling.constructorName"/>" class="required"/>
							</td>
							<th>单位联系电话：</th>
							<td align="left">
							<input type="text" name="contractFiling.phone" value="<s:property value="contractFiling.phone"/>" class="required"/>
							</td>
                         </tr>
                        <tr>
                         	<th>联合体承包单位名称：</th>
							<td align="left">
							<input id="unionCorpName" type="text" name="contractFiling.unionCorpName" value="<s:property value="contractFiling.unionCorpName"/>" />
							</td>
							<th>联合体承包单位组织代码：</th>
							<td align="left">
							<input id="unionCorpCode" type="text" name="contractFiling.unionCorpCode" value="<s:property value="contractFiling.unionCorpCode"/>" />
							<input id="appDeptName" readonly type="hidden" name="contractFiling.appDeptName" value="<s:property value="contractFiling.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="contractFiling.appDept" value="<s:property value="contractFiling.appDept"/>"/>
							</td>
						</tr>
						<tr>
                         	<th>申请企业名称：</th>
							<td align="left">
							<input type="text" name="contractFiling.applyCorpName" value="<s:property value="corpName"/>" class="required"/>
							</td>
							<th>申请企业代码：</th>
							<td align="left">
							<input id="corpCode" type="text" name="contractFiling.applyCorpCode" value="<s:property value="corpCode"/>" class="required"/>
							
<input id="technicalName" type="hidden" name="contractFiling.technicalName" value="<s:property value="contractFiling.technicalName"/>" /><!-- 技术负责人姓名 -->
<input id="technicalIdCardTypeNum" type="hidden" name="contractFiling.technicalIdCardTypeNum" value="<s:property value="contractFiling.technicalIdCardTypeNum"/>" /><!-- 技术负责人证件类型 -->
<input id="technicalIdCard" type="hidden" name="contractFiling.technicalIdCard" value="<s:property value="contractFiling.technicalIdCard"/>" /><!-- 技术负责人证件号码 -->
<input id="technicalCertNum" type="hidden" name="contractFiling.technicalCertNum" value="<s:property value="contractFiling.technicalCertNum"/>" /><!-- 技术负责人证书号 -->
<input id="qualityName" type="hidden" name="contractFiling.qualityName" value="<s:property value="contractFiling.qualityName"/>" /><!-- 质量检查员姓名 -->
<input id="qualityIdCardTypeNum" type="hidden" name="contractFiling.qualityIdCardTypeNum" value="<s:property value="contractFiling.qualityIdCardTypeNum"/>" /><!-- 质量检查员证件类型 -->
<input id="qualityIdCard" type="hidden" name="contractFiling.qualityIdCard" value="<s:property value="contractFiling.qualityIdCard"/>" /><!-- 质量检查员证件号码 -->
<input id="qualityCertNum" type="hidden" name="contractFiling.qualityCertNum" value="<s:property value="contractFiling.qualityCertNum"/>" /><!-- 质量检查员证书号 -->
<input id="securityName" type="hidden" name="contractFiling.securityName" value="<s:property value="contractFiling.securityName"/>" /><!-- 安全员姓名 -->
<input id="securityIdCardTypeNum" type="hidden" name="contractFiling.securityIdCardTypeNum" value="<s:property value="contractFiling.securityIdCardTypeNum"/>" /><!-- 安全员证件类型 -->
<input id="securityIdCard" type="hidden" name="contractFiling.securityIdCard" value="<s:property value="contractFiling.securityIdCard"/>" /><!-- 安全员证件号码 -->
<input id="seCurityCertNum" type="hidden" name="contractFiling.seCurityCertNum" value="<s:property value="contractFiling.seCurityCertNum"/>" /><!-- 安全员证书号 -->
<input id="constructionName" type="hidden" name="contractFiling.constructionName" value="<s:property value="contractFiling.constructionName"/>" /><!-- 施工员（工长）姓名 -->
<input id="constructionIdCardTypeNum" type="hidden" name="contractFiling.constructionIdCardTypeNum" value="<s:property value="contractFiling.constructionIdCardTypeNum"/>" /><!-- 施工员（工长）证件类型 -->
<input id="constructionIdCard" type="hidden" name="contractFiling.constructionIdCard" value="<s:property value="contractFiling.constructionIdCard"/>" /><!-- 施工员（工长）证件号码 -->
<input id="constructionCertNum" type="hidden" name="contractFiling.constructionCertNum" value="<s:property value="contractFiling.constructionCertNum"/>" /><!-- 施工员（工长）证书号 -->
<input id="directorName" type="hidden" name="contractFiling.directorName" value="<s:property value="contractFiling.directorName"/>" /><!-- （监理人员）总监姓名 -->
<input id="directorIdCardTypeNum" type="hidden" name="contractFiling.directorIdCardTypeNum" value="<s:property value="contractFiling.directorIdCardTypeNum"/>" /><!-- （监理人员）总监证件类型 -->
<input id="directorIdCard" type="hidden" name="contractFiling.directorIdCard" value="<s:property value="contractFiling.directorIdCard"/>" /><!-- （监理人员）总监证件号码 -->
<input id="directorCertNum" type="hidden" name="contractFiling.directorCertNum" value="<s:property value="contractFiling.directorCertNum"/>" /><!-- （监理人员）总监证书号 -->
<input id="represEntativeName" type="hidden" name="contractFiling.represEntativeName" value="<s:property value="contractFiling.represEntativeName"/>" /><!-- 总监代表姓名 -->
<input id="represEntativeIdCardTypeNum" type="hidden" name="contractFiling.represEntativeIdCardTypeNum" value="<s:property value="contractFiling.represEntativeIdCardTypeNum"/>" /><!-- 总监代表证件类型 -->
<input id="represEntativeIdCard" type="hidden" name="contractFiling.represEntativeIdCard" value="<s:property value="contractFiling.represEntativeIdCard"/>" /><!-- 总监代表证件号码 -->
<input id="represEntativeCertNum" type="hidden" name="contractFiling.represEntativeCertNum" value="<s:property value="contractFiling.represEntativeCertNum"/>" /><!-- 总监代表证书号 -->
<input id="safetyName" type="hidden" name="contractFiling.safetyName" value="<s:property value="contractFiling.safetyName"/>" /><!-- 安全监理姓名 -->
<input id="safetyIdCardTypeNum" type="hidden" name="contractFiling.safetyIdCardTypeNum" value="<s:property value="contractFiling.safetyIdCardTypeNum"/>" /><!-- 安全监理证件类型 -->
<input id="safetyIdCard" type="hidden" name="contractFiling.safetyIdCard" value="<s:property value="contractFiling.safetyIdCard"/>" /><!-- 安全监理证件号码 -->
							</td>
                         </tr>
                        <tr>
                       		<th>建设规模：</th>
							<td colspan="4" align="left">
							<textarea id="prjSize" name="contractFiling.prjSize" id="textarea" cols="100" rows="5"><s:property value="contractFiling.prjSize"/></textarea>
							</td>
						</tr>
                </tbody>  
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
		            <input type="image"src="<%=basepath %>/images/shangbao.jpg" />
            	</div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
