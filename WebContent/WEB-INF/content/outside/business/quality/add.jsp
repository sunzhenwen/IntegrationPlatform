<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>质量监督注册 </title>
<script type="text/javascript">

	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	 			var check = /^([1-9]\d*|0)(\.\d*[1-9])?$/; 
	 			var expensive = $("#expensive").val();
	 			var prjName = $("#prjName").val();
	 			if(!check.exec(expensive))
	 			{
	 				alert("工程总造价不能为负数!");
	 			}else if(prjName=="" || prjName==null)
 				{
 					alert("请选择项目名称!");
 				}else
	 			{
	 				form.submit();
	 			}
	 		}    
	 	});
	});

	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/qualityAction_goList.action";
		document.form1.submit();
	}
	
	//查询项目
	function queryPrjName()
	{
		
		var url="<%=basepath %>/qualityPrjsAction_queryPage.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
	
	//查询招投标信息
	function queryTenderInfo()
	{
		var prjNum = $("#prjNum").val();
		var url="<%=basepath %>/contractRecordAction_queryPage.action?condition.prjNum="+prjNum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
	

	//勘察单位
	function queryContractCorpQualA()
	{
		var prjNum = $("#prjNum").val();
		var contractTypeNum="100";
		var url="<%=basepath %>/contractCorpQualAction_queryPageA.action?condition.prjNum="+prjNum+"&condition.contractTypeNum="+contractTypeNum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
	
	
	//设计单位
	function queryContractCorpQualB()
	{
		var prjNum = $("#prjNum").val();
		var contractTypeNum="200";
		var url="<%=basepath %>/contractCorpQualAction_queryPageB.action?condition.prjNum="+prjNum+"&condition.contractTypeNum="+contractTypeNum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
	
	//监理单位
	function queryContractCorpQualC()
	{
		var prjNum = $("#prjNum").val();
		var contractTypeNum="400";
		var url="<%=basepath %>/contractCorpQualAction_queryPageC.action?condition.prjNum="+prjNum+"&condition.contractTypeNum="+contractTypeNum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
	
	//
	function queryContractCorpQualD()
	{
		var prjNum = $("#prjNum").val();
		var contractTypeNum="301";
		var url="<%=basepath %>/contractCorpQualAction_queryPageD.action?condition.prjNum="+prjNum+"&condition.contractTypeNum="+contractTypeNum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
	

	//施工图审查询
	function queryQualityPlans()
	{
		var prjId = $("#prjId").val();
		var url="<%=basepath %>/qualityPlansAction_queryPage.action?condition.prjId="+prjId;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
	function checkreadonly()  
	{  
	 document.getElementById("prjName").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("prjNum").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("sectionName").style.backgroundColor="#EBEBE4"; 	
	 document.getElementById("tenderNum").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("sqqy").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("sqdm").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("projectAddress").style.backgroundColor="#EBEBE4"; 	 
     document.getElementById("developmentOrganization").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("surveyUnit").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("designUnit").style.backgroundColor="#EBEBE4"; 	
	 document.getElementById("supervisionUnit").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("constructionUnit").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("developmentCharge").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("developmentQualificationLevel").style.backgroundColor="#EBEBE4"; 
     document.getElementById("surveyUnitQualificationLevel").style.backgroundColor="#EBEBE4"; 	
	 document.getElementById("surveyUnitCharge").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("designUnitQualificationLevel").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("designUnitCharge").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("supervisionUnitQualLevel").style.backgroundColor="#EBEBE4";
	 document.getElementById("supervisionUnitEngineer").style.backgroundColor="#EBEBE4";
	 document.getElementById("constructionUnitProjectManager").style.backgroundColor="#EBEBE4";
	 document.getElementById("constructionUnitQualLevel").style.backgroundColor="#EBEBE4";
	}  
    
    
</script>

</head>

<body  onload="checkreadonly()">
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="<%=basepath %>/qualityAction_add.action">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>质量监督注册</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td colspan="3" align="left">
							<input id="prjName" type="text" size="112" readonly=false style="color:#707070" name="quality.prjName" value="<s:property value="quality.prjName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							
							<a href="#" onclick="queryPrjName()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							<input id="prjId" type="hidden" readonly name="quality.prjId" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>合同名称：</th>
							<td colspan="3" align="left">
							<input id="sectionName" style="color:#707070" type="text" size="112" name="quality.sectionName" /><strong><font color="#FF0000">*</font></strong>
							<a href="#" onclick="queryTenderInfo()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							</td>
                         </tr>
                       
                          <tr>
                         	<th>项目编号：</th>
							<td align="left">						
							<input id="prjNum" type="text" readonly=false style="color:#707070" name="quality.prjNum" value="<s:property value="quality.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
                             <th>中标通知书编号：</th>
							<td align="left">
							<input id="tenderNum" style="color:#707070" type="text" name="quality.tenderNum" />
							</td>
                          </tr>
                         
                         
                                           
                         <tr>
                         	<th>申请企业名称：</th>
							<td colspan="3" align="left">
							<input id="sqqy" type="text" size="112" readonly=false style="color:#707070" name="quality.applyCorpName" value="<s:property value="corpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>

                         </tr>
                         						
                          <tr>
                         	<th>申请企业代码：</th>
							<td colspan="3" align="left">
							<input id="sqdm" type="text" readonly=false style="color:#707070" name="quality.applyCorpCode" value="<s:property value="corpCode"/>" class="required"/>
							<input id="appDeptName" readonly type="hidden" name="quality.appDeptName" value="<s:property value="quality.appDeptName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="appDept" type="hidden" name="quality.appDept" value="<s:property value="quality.appDept"/>"/>
							</td>
 
                          </tr>
                          
                         <tr>
                         	<td colspan="4" align="left">概况</td>
                         </tr>
                         
                         <tr>
                         	<th>工程名称：</th>
							<td align="left" colspan="3">
							<input id="projectName" type="text" size="112" name="quality.projectName" value="<s:property value="quality.projectName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>

                         <tr>
                         	<th>工程地点：</th>
							<td align="left" colspan="3">
							<input id="projectAddress"   style="color:#707070"  type="text" size="112" name="quality.projectAddress" value="<s:property value="quality.projectAddress"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         
                         <tr>
                         	<th>结构/层数：</th>
							<td align="left" colspan="3">
							<input id="configuration" type="text" size="112" name="quality.configuration" value="<s:property value="quality.configuration"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         
                         
                         <tr>							
							<th>甲方联系人：</th>
							<td align="left">
							<input id="contact" type="text" name="quality.contact" value="<s:property value="quality.contact"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
							<th>合同金额(万元)：</th>
							<td align="left">
								<input id="contractMoney" type="text" name="quality.contractMoney" value="<s:property value="quality.contractMoney"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>								
                         </tr>
                         
                         
                         
                         
                         <tr>
                         	<th>建设面积(㎡)：</th>
							<td align="left">
							<input id="constructionArea" type="text" name="quality.constructionArea" value="<s:property value="quality.constructionArea"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
						   <th>工程总造价(万元)：</th>
							<td align="left">
							<input id="expensive" type="text" name="quality.expensive" value="<s:property value="quality.expensive"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>						
						</tr>
						<!-- 
						<tr>
                         	<th>安装工程量(万元)：</th>
							<td colspan="3">
							<input id="quantities" size="112" type="text" name="quality.quantities" value="<s:property value="quality.quantities"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
						 -->
						<!-- 
						<th>监督费(元)：</th>
						<td>
						<input id="superviseCost" type="text" name="quality.superviseCost" value="<s:property value="quality.superviseCost"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
						</td>
						 -->
                    
                         <tr>
                         	<th>计划开工日期：</th>
							<td align="left">
							<input id="time1" type="text" name="quality.startDate" value="<s:date name="quality.startDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>计划竣工日期：</th>
							<td align="left">
							<input id="time2" type="text" name="quality.endDate" value="<s:date name="quality.endDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         
                          <tr>
                         	<th>建设单位：</th>
							<td colspan="3" align="left">
							<input id="developmentOrganization"   style="color:#707070"  	type="text" size="112" name="quality.developmentOrganization" value="<s:property value="quality.developmentOrganization"/>" />
							</td>
                          </tr>
                         
                          <tr>
                         	<th>建设单位项目负责人：</th>
							<td align="left">
								<input id="developmentCharge"   style="color:#707070"  type="text" name="quality.developmentCharge" value="<s:property value="quality.developmentCharge"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>建设单位资质等级：</th>
							<td align="left">
								<input id="developmentQualificationLevel"   style="color:#707070" type="text" name="quality.developmentQualificationLevel" value="<s:property value="quality.developmentQualificationLevel"/>" />
							</td>
                         </tr>
                         

                         <tr>
                            <th>建设单位联系电话：</th>
							<td colspan="3" align="left">
							<input id="developmentPhone" type="text" name="quality.developmentPhone" value="<s:property value="quality.developmentPhone"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>

                          </tr>
                         
                         
                         <tr>
                         	<th>勘察单位：</th>
							<td colspan="3" align="left">
							<input id="surveyUnit"   style="color:#707070"  type="text" size="112" name="quality.surveyUnit" value="<s:property value="quality.surveyUnit"/>" />
							
							<input id="econCorpCode" type="hidden"  name="quality.econCorpCode" value="<s:property value="quality.econCorpCode"/>" />
							<a href="javascript:queryContractCorpQualA()" onclick=""><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							
							</td>
                         </tr>
                         
                          <tr>                          
                            <th>勘察单位资质等级：</th>
							<td align="left">
							<input id="surveyUnitQualificationLevel"   style="color:#707070" type="text" name="quality.surveyUnitQualificationLevel" value="<s:property value="quality.surveyUnitQualificationLevel"/>" />
							</td>
                         	<th>勘察单位项目负责人：</th>
							<td align="left">
							<input id="surveyUnitCharge" type="text"   style="color:#707070" name="quality.surveyUnitCharge" value="<s:property value="quality.surveyUnitCharge"/>" />
							</td>
                         </tr>
                           <tr>
	                            <th>勘察单位联系电话：</th>
								<td colspan="3" align="left">
									<input id="surveyUnitPhone" type="text"  name="quality.surveyUnitPhone" value="<s:property value="quality.surveyUnitPhone"/>" />
								</td>
                           </tr>
                         
                         
                         <tr>
                         	<th>设计单位：</th>
							<td colspan="3" align="left">
							<input id="designUnit"  style="color:#707070"   type="text" size="112" name="quality.designUnit" value="<s:property value="quality.designUnit"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="designCorpCode" type="hidden"  name="quality.designCorpCode" value="<s:property value="quality.designCorpCode"/>" />
							<a href="javascript:queryContractCorpQualB()" onclick=""><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							</td>
                         </tr>
                         
                         <tr>                                                  
                            <th>设计单位资质等级：</th>
							<td align="left">
							<input id="designUnitQualificationLevel"   style="color:#707070" type="text" name="quality.designUnitQualificationLevel" value="<s:property value="quality.designUnitQualificationLevel"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	<th>设计单位项目负责人：</th>
							<td align="left">
							<input id="designUnitCharge" type="text"   style="color:#707070" name="quality.designUnitCharge" value="<s:property value="quality.designUnitCharge"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         
                          <tr>
							<th>设计单位联系电话：</th>
							<td colspan="3" align="left">
							<input id="designUnitPhone" type="text" name="quality.designUnitPhone" value="<s:property value="quality.designUnitPhone"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                          </tr>
         
                         <tr>
                         	<th>监理单位：</th>
							<td colspan="3" align="left">
							<input id="supervisionUnit"   style="color:#707070"  type="text" size="112" name="quality.supervisionUnit" value="<s:property value="quality.supervisionUnit"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="superCorpCode" type="hidden"  name="quality.superCorpCode" value="<s:property value="quality.superCorpCode"/>" />
							<a href="javascript:queryContractCorpQualC()" onclick=""><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							</td>
                         </tr>
                         
                         <tr>
                         	<th>监理单位资质等级：</th>
							<td align="left">
							<input id="supervisionUnitQualLevel"   style="color:#707070" type="text" name="quality.supervisionUnitQualLevel" value="<s:property value="quality.supervisionUnitQualLevel"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	<th>监理单位总监理工程师：</th>
							<td align="left">
							<input id="supervisionUnitEngineer" type="text"   style="color:#707070" name="quality.supervisionUnitEngineer" value="<s:property value="quality.supervisionUnitEngineer"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         
                         
                          <tr>
							<th>监理单位联系电话：</th>
							<td colspan="3" align="left">
							<input id="supervisionUnitPhone" type="text" name="quality.supervisionUnitPhone" value="<s:property value="quality.supervisionUnitPhone"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>                          
                          </tr>                            
                                                                                          
                         
                         <tr>
                         	<th>施工单位：</th>
							<td colspan="3" align="left">
							<input id="constructionUnit"  style="color:#707070"  type="text" size="112" name="quality.constructionUnit" value="<s:property value="quality.constructionUnit"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="consCorpCode" type="hidden"  name="quality.consCorpCode" value="<s:property value="quality.consCorpCode"/>" />
							
							</td>
                         </tr>
                         
                         <tr>
                         	<th>施工单位项目经理：</th>
							<td align="left">
							<input id="constructionUnitProjectManager"   style="color:#707070" type="text" name="quality.constructionUnitProjectManager" value="<s:property value="quality.constructionUnitProjectManager"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>							
							<th>施工单位资质等级：</th>
							<td align="left">
							<input id="constructionUnitQualLevel"   style="color:#707070" type="text" name="quality.constructionUnitQualLevel" value="<s:property value="quality.constructionUnitQualLevel"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         
                         <tr>
	                      	<th>施工单位联系电话 ：</th>
							<td colspan="3" align="left">
							<input id="constructionUnitPhone" type="text" name="quality.constructionUnitPhone" value="<s:property value="quality.constructionUnitPhone"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                          </tr>          
                         
                         
                         
                         <tr>
                         	<th>施工图审查合格书：</th>
							<td colspan="3" align="left">
							<input id="constructionPlans" type="text" size="112" name="quality.constructionPlans" value="<s:property value="quality.constructionPlans"/>" class="required"/>
							<a href="javascript:queryQualityPlans()" onclick=""><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							
							</td>
                         </tr>
                         <tr>
                         	<th>类别 ：</th>
							<td align="left">
							<input id="constructionPlansType" type="text" name="quality.constructionPlansType" value="<s:property value="quality.constructionPlansType"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	<th>施工图审查机构项目经理：</th>
							<td align="left">
							<input id="constructionPlansCharge" type="text" name="quality.constructionPlansCharge" value="<s:property value="quality.constructionPlansCharge"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>

                         </tr>                       
                          <tr>
								<th>施工图审查机构联系电话 ：</th>
								<td colspan="3" align="left">
								<input id="constructionPlansPhone" type="text" name="quality.constructionPlansPhone" value="<s:property value="quality.constructionPlansPhone"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
								</td>
                          </tr>                                
                         <!--  
                         <tr>
                         	<td colspan="4" align="left">呈报资料</td>
                         </tr>
                         <tr>
                         	<th>资料名称</th>
							<th>文件号</th>
							<th>资料名称</th>
							<th>文件号</th>
						</tr>
						<tr>
                         	<th>施工合同</th>

							<td align="left">
							<textarea id="constructionContractFileNum" name="quality.constructionContractFileNum" rows="3" cols="21" maxlength='50' class="required"><s:property value="quality.constructionContractFileNum"/></textarea>
							<strong><font color="#FF0000">*</font></strong>
							</td>
							
							<th>建设单位项目负责人及项目机构组成</th>
							<td align="left">
								<textarea id="developmentOrganFileNum" name="quality.developmentOrganFileNum" rows="3" cols="21" maxlength='50' class="required" ><s:property value="quality.developmentOrganFileNum"/></textarea>
								<strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>施工组织设计</th>
							<td align="left">					
								<textarea id="constructionOrganFileNum" name="quality.constructionOrganFileNum" rows="3" cols="21" maxlength='50' class="required"><s:property value="quality.constructionOrganFileNum"/></textarea>
								<strong><font color="#FF0000">*</font></strong>							
							</td>
							<th>施工单位项目负责人及项目机构组成</th>
							<td align="left">
								<textarea id="onstructionUnitFileNum" name="quality.onstructionUnitFileNum" rows="3" cols="21" maxlength='50' class="required"><s:property value="quality.onstructionUnitFileNum"/></textarea>
								<strong><font color="#FF0000">*</font></strong>
							</td>						
                         </tr>
                         
                         
              <tr>
	               <th>施工图审查报告和批准书</th>
					<td align="left">
						<textarea id="constructionPlansFileNum" rows="3" cols="21" maxlength='50' class="required" name="quality.constructionPlansFileNum" ><s:property value="quality.constructionPlansFileNum"/></textarea><strong><font color="#FF0000">*</font></strong>
					</td>
					<th>监理单位项目负责人及项目机构组成</th>
					<td align="left">
						<textarea id="supervisionUnitFileNum" rows="3" cols="21" maxlength='50' class="required" name="quality.supervisionUnitFileNum" ><s:property value="quality.supervisionUnitFileNum"/></textarea><strong><font color="#FF0000">*</font></strong>
					</td>
             </tr>
             <tr>
             <th>监理合同</th>
			 <td align="left">
				<textarea id="supervisionContractFileNum" rows="3" cols="21" maxlength='50' class="required" name="quality.supervisionContractFileNum" ><s:property value="quality.supervisionContractFileNum"/></textarea>
				<strong><font color="#FF0000">*</font></strong>
			  </td>
			<th>施工现场项目负责人、技术人员资格证书</th>
			<td align="left">
				<textarea id="constructionSiteFileNum" rows="3" cols="21" maxlength='50' class="required" name="quality.constructionSiteFileNum" ><s:property value="quality.constructionSiteFileNum"/></textarea><strong><font color="#FF0000">*</font></strong>
			</td>
            </tr>
            <tr>
             <th>监理规划</th>
				<td align="left">
				<textarea id="supervisionPlanFileNum" rows="3" cols="21" maxlength='50' class="required" name="quality.supervisionPlanFileNum" ><s:property value="quality.supervisionPlanFileNum"/></textarea>
					<strong><font color="#FF0000">*</font></strong>
				</td>
				<th>质量检查员岗位证书</th>
				<td align="left">
				<textarea id="qualityTestingFileNum" rows="3" cols="21" maxlength='50' class="required" name="quality.qualityTestingFileNum" ><s:property value="quality.qualityTestingFileNum"/></textarea>
				<strong><font color="#FF0000">*</font></strong>
				</td>
             </tr>
             <tr>
             <th>消防设计审查合格书面证明文件</th>
			 <td align="left">
			    <textarea id="fireControlFileNum" rows="3" cols="21" maxlength='50' name="quality.fireControlFileNum" ><s:property value="quality.fireControlFileNum"/></textarea>
			 </td>
			<th>现场监理人员注册执业证书</th>
			   <td align="left">
				   <textarea id="fieldSupervisionFileNum" rows="3" cols="21" maxlength='50' class="required" name="quality.fieldSupervisionFileNum" ><s:property value="quality.fieldSupervisionFileNum"/></textarea>
					<strong><font color="#FF0000">*</font></strong>
				</td>
              </tr>
              -->
                         
                         
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
