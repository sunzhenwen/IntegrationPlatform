<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title>企业信息</title>
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/qualityTenderInfoAction_queryPage.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		//window.returnValue=value;
		var strs= new Array(); //定义一数组 
		strs=value.split(","); //字符分割 

		var tenderNum = strs[0];
		var sectionName = strs[1];
		var projectName = strs[2];
		var configuration = strs[3];
		var projectAddress = strs[4];
		var contact = strs[5];
		var constructionArea = strs[6];
		var expensive = strs[7];
		var startDate = strs[8];
		var endDate = strs[9];
		var developmentOrganization = strs[10];
		var developmentQualificationLevel = strs[11];
		var developmentCharge = strs[12];
		var developmentPhone = strs[13];
		var surveyUnit = strs[14];
		var surveyUnitQualificationLevel = strs[15];
		var surveyUnitCharge = strs[16];
		var surveyUnitPhone = strs[17];
		var designUnit = strs[18];
		var designUnitQualificationLevel = strs[19];
		var designUnitCharge = strs[20];
		var designUnitPhone = strs[21];
		var supervisionUnit = strs[22];
		var supervisionUnitQualLevel = strs[23];
		var supervisionUnitEngineer = strs[24];
		var supervisionUnitPhone = strs[25];
		var constructionUnit = strs[26];
		var constructionUnitQualLevel = strs[27];
		var constructionUnitProjectManager = strs[28];
		var constructionUnitPhone = strs[29];
		var constructionPlans = strs[30];
		var constructionPlansType = strs[31];
		var constructionPlansCharge = strs[32];
		var constructionPlansPhone = strs[33];
		var constructionContractFileNum = strs[34];
		var constructionOrganFileNum = strs[35];
		var constructionPlansFileNum = strs[36];
		var supervisionContractFileNum = strs[37];
		var supervisionPlanFileNum = strs[38];
		var fireControlFileNum = strs[39];
		var developmentOrganFileNum = strs[40];
		var onstructionUnitFileNum = strs[41];
		var supervisionUnitFileNum = strs[42];
		var constructionSiteFileNum = strs[43];
		var qualityTestingFileNum = strs[44];
		var fieldSupervisionFileNum = strs[45];
		

		
		parent.document.getElementById("tenderNum").value=tenderNum;
		parent.document.getElementById("sectionName").value=sectionName;
		parent.document.getElementById("projectName").value=projectName;
		parent.document.getElementById("configuration").value=configuration;
		parent.document.getElementById("projectAddress").value=projectAddress;
		parent.document.getElementById("contact").value=contact;
		parent.document.getElementById("constructionArea").value=constructionArea;
		parent.document.getElementById("expensive").value=expensive;
		parent.document.getElementById("time1").value=startDate;
		parent.document.getElementById("time2").value=endDate;
		parent.document.getElementById("developmentOrganization").value=developmentOrganization;
		parent.document.getElementById("developmentQualificationLevel").value=developmentQualificationLevel;
		parent.document.getElementById("developmentCharge").value=developmentCharge;
		parent.document.getElementById("developmentPhone").value=developmentPhone;
		parent.document.getElementById("surveyUnit").value=surveyUnit;
		parent.document.getElementById("surveyUnitQualificationLevel").value=surveyUnitQualificationLevel;
		parent.document.getElementById("surveyUnitCharge").value=surveyUnitCharge;
		parent.document.getElementById("surveyUnitPhone").value=surveyUnitPhone;
		parent.document.getElementById("designUnit").value=designUnit;
		parent.document.getElementById("designUnitQualificationLevel").value=designUnitQualificationLevel;
		parent.document.getElementById("designUnitCharge").value=designUnitCharge;
		parent.document.getElementById("designUnitPhone").value=designUnitPhone;
		parent.document.getElementById("supervisionUnit").value=supervisionUnit;
		parent.document.getElementById("supervisionUnitQualLevel").value=supervisionUnitQualLevel;
		parent.document.getElementById("supervisionUnitEngineer").value=supervisionUnitEngineer;
		parent.document.getElementById("supervisionUnitPhone").value=supervisionUnitPhone;
		parent.document.getElementById("constructionUnit").value=constructionUnit;
		parent.document.getElementById("constructionUnitQualLevel").value=constructionUnitQualLevel;
		parent.document.getElementById("constructionUnitProjectManager").value=constructionUnitProjectManager;
		parent.document.getElementById("constructionUnitPhone").value=constructionUnitPhone;
		parent.document.getElementById("constructionPlans").value=constructionPlans;
		parent.document.getElementById("constructionPlansType").value=constructionPlansType;
		parent.document.getElementById("constructionPlansCharge").value=constructionPlansCharge;
		parent.document.getElementById("constructionPlansPhone").value=constructionPlansPhone;
		parent.document.getElementById("constructionContractFileNum").value=constructionContractFileNum;
		parent.document.getElementById("constructionOrganFileNum").value=constructionOrganFileNum;
		parent.document.getElementById("constructionPlansFileNum").value=constructionPlansFileNum;
		parent.document.getElementById("supervisionContractFileNum").value=supervisionContractFileNum;
		parent.document.getElementById("supervisionPlanFileNum").value=supervisionPlanFileNum;
		parent.document.getElementById("fireControlFileNum").value=fireControlFileNum;
		parent.document.getElementById("developmentOrganFileNum").value=developmentOrganFileNum;
		parent.document.getElementById("onstructionUnitFileNum").value=onstructionUnitFileNum;
		parent.document.getElementById("supervisionUnitFileNum").value=supervisionUnitFileNum;
		parent.document.getElementById("constructionSiteFileNum").value=constructionSiteFileNum;
		parent.document.getElementById("qualityTestingFileNum").value=qualityTestingFileNum;
		parent.document.getElementById("fieldSupervisionFileNum").value=fieldSupervisionFileNum;
		
		
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="<%=basepath %>/queryPrjsAction_queryPage.action">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>项目信息选择</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>时间：</td>
                        <td colspan="3">
                        <input id="time1" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" type="text" name="condition.startDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        <input id="time2" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" type="text" name="condition.endDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        <input type="hidden" name="condition.prjNum" value = "<s:property value = "condition.prjNum"/>" />
                        </td>
                    </tr>
                    
                </table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" onclick="queryCorpInfo()" src="<%=basepath %>/images/ry_look.png" /></td>
                        <td>&nbsp;</td>
                    </tr>
                </table>		
            
            </div>
            
            <div class="ry_liebiao">
            	<p class="f16 fb">项目信息选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
							<th>项目编号</th>
							<th>标段名称</th>
							<th>中标单位</th>
							<th>申请日期</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio" name="corpRadio" 
                          	value="<s:property value="tenderNum"/>,<s:property value="sectionName"/>,<s:property value="projectName"/>,<s:property value="configuration"/>,<s:property value="projectAddress"/>,<s:property value="contact"/>,<s:property value="constructionArea"/>,<s:property value="expensive"/>,<s:property value="startDate"/>,<s:property value="endDate"/>,<s:property value="developmentOrganization"/>,<s:property value="developmentQualificationLevel"/>,<s:property value="developmentCharge"/>,<s:property value="developmentPhone"/>,<s:property value="surveyUnit"/>,<s:property value="surveyUnitQualificationLevel"/>,<s:property value="surveyUnitCharge"/>,<s:property value="surveyUnitPhone"/>,<s:property value="designUnit"/>,<s:property value="designUnitQualificationLevel"/>,<s:property value="designUnitCharge"/>,<s:property value="designUnitPhone"/>,<s:property value="supervisionUnit"/>,<s:property value="supervisionUnitQualLevel"/>,<s:property value="supervisionUnitEngineer"/>,<s:property value="supervisionUnitPhone"/>,<s:property value="constructionUnit"/>,<s:property value="constructionUnitQualLevel"/>,<s:property value="constructionUnitProjectManager"/>,<s:property value="constructionUnitPhone"/>,<s:property value="constructionPlans"/>,<s:property value="constructionPlansType"/>,<s:property value="constructionPlansCharge"/>,<s:property value="constructionPlansPhone"/>,<s:property value="constructionContractFileNum"/>,<s:property value="constructionOrganFileNum"/>,<s:property value="constructionPlansFileNum"/>,<s:property value="supervisionContractFileNum"/>,<s:property value="supervisionPlanFileNum"/>,<s:property value="fireControlFileNum"/>,<s:property value="developmentOrganFileNum"/>,<s:property value="onstructionUnitFileNum"/>,<s:property value="supervisionUnitFileNum"/>,<s:property value="constructionSiteFileNum"/>,<s:property value="qualityTestingFileNum"/>,<s:property value="fieldSupervisionFileNum"/>">
                          	</td>


                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="prjNum"/></td>
                            <td><s:property value="sectionName"/></td>
                            <td><s:property value="tenderCorpName"/></td>
                            <td><s:date name="createdate" format="yyyy-MM-dd" /></td>
                         </tr>
						</s:iterator>
                
                	</tbody>  
                </table>
                
                
         </div>
    	</div>
        </form>
    </div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>
