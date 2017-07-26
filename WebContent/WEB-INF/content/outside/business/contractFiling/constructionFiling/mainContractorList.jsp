<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title>施工总包合同选择</title>
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/mainContractorAction_queryPage.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		//window.returnValue=value;
		var strs= new Array(); //定义一数组 
		strs=value.split("^&*"); //字符分割 

		var recordNum = strs[0];//合同备案编号
		var prjNum = strs[1]; //项目编号
		var prjName = strs[2];//项目名称
		var projectAddress = strs[3];//项目地址
		var projectCost = strs[4];//工程造价
		var constructorName = strs[5];//项目经理姓名
		var titleLeve = strs[6];//资质等级
		var phone = strs[7];//联系电话
		var area = strs[8];//建筑面积
		var tenderNum = strs[9];//中标通知书编号
		var sectionName = strs[10];//标段名称
		var projectName = strs[10];//合同名称
		var contractNum = strs[11]; //合同编号
		var contractMoney = strs[12]; //合同金额(万元)
		var prjSize = strs[13]; //建设规模
		var propietorCorpName = strs[14]; //发包单位名称
		var propietorCorpCode = strs[15]; //发包单位住组织代码
		var contractorCorpName = strs[16]; //承包单位名称
		var contractorCorpCode = strs[17]; //承包单位组织代码
		var unionCorpName = strs[18]; //联合体承包单位名称
		var unionCorpCode = strs[19]; //联合体承包单位组织代码
		var appDept = strs[20];
		var appDeptName = strs[21];
	//-------------------------------人员-----------------------------------	
		//var technicalName = strs[20];//技术负责人姓名
		//var technicalIdCardTypeNum = strs[21];//技术负责人证件类型
		//var technicalIdCard = strs[22];//技术负责人证件号码
		//var technicalCertNum = strs[23];//技术负责人证书号
		//var qualityName = strs[24];//质量检查员姓名
		//var qualityIdCardTypeNum = strs[25];//质量检查员证件类型
		//var qualityIdCard = strs[26];//质量检查员证件号码
		//var qualityCertNum = strs[27];//质量检查员证书号
		//var securityName = strs[28];//安全员姓名
		//var securityIdCardTypeNum = strs[29];//安全员证件类型
		//var securityIdCard = strs[30];//安全员证件号码
		//var securityCertNum = strs[31];//安全员证书号
		//var constructionName = strs[32];//施工员（工长）姓名
		//var constructionIdCardTypeNum = strs[33];//施工员（工长）证件类型
		//var constructionIdCard = strs[34];//施工员（工长）证件号码
		//var constructionCertNum = strs[35];//施工员（工长）证书号
		//var directorName = strs[36];//（监理人员）总监姓名
		//var directorIdCardTypeNum = strs[37];//（监理人员）总监证件类型
		//var directorIdCard = strs[38];//（监理人员）总监证件号码
		//var directorCertNum = strs[39];//（监理人员）总监证书号
		//var represEntativeName = strs[40];//总监代表姓名
		//var represEntativeIdCardTypeNum = strs[41];//总监代表证件类型
		//var represEntativeIdCard = strs[42];//总监代表证件号码
		//var represEntativeCertNum = strs[43];//总监代表证书号
		//var safetyName = strs[44];//安全监理姓名
		//var safetyIdCardTypeNum = strs[45];//安全监理证件类型
		//var safetyIdCard = strs[46];//安全监理证件号码
		
		
		
		
		
		parent.document.getElementById("recordNum").value=recordNum;//合同备案编号
		parent.document.getElementById("prjNum").value=prjNum; //项目编号
		parent.document.getElementById("prjName").value=prjName;//项目名称
		parent.document.getElementById("projectAddress").value=projectAddress;//项目地址
		parent.document.getElementById("projectCost").value=projectCost;//工程造价
		parent.document.getElementById("constructorName").value=constructorName;//项目经理姓名
		parent.document.getElementById("titleLeve").value=titleLeve;//资质等级
		parent.document.getElementById("phone").value=phone;//联系电话
		parent.document.getElementById("area").value=area;//建筑面积
		parent.document.getElementById("tenderNum").value=tenderNum;//中标通知书编号
		parent.document.getElementById("sectionName").value=sectionName;//标段名称
		parent.document.getElementById("projectName").value=sectionName;//合同名称
		
		parent.document.getElementById("contractNum").value=contractNum; //合同编号
		parent.document.getElementById("contractMoney").value=contractMoney; //合同金额(万元)
		parent.document.getElementById("prjSize").value=prjSize; //建设规模
		parent.document.getElementById("propietorCorpName").value=propietorCorpName; //发包单位名称
		parent.document.getElementById("propietorCorpCode").value=propietorCorpCode; //发包单位住组织代码
		parent.document.getElementById("contractorCorpName").value=contractorCorpName; //承包单位名称
		parent.document.getElementById("contractorCorpCode").value=contractorCorpCode; //承包单位组织代码
		parent.document.getElementById("unionCorpName").value=unionCorpName; //联合体承包单位名称
		parent.document.getElementById("unionCorpCode").value=unionCorpCode; //联合体承包单位组织代码
        parent.document.getElementById("appDept").value=appDept;
		parent.document.getElementById("appDeptName").value=appDeptName;                                     		
	//-------------------------------人员-----------------------------------	
		//parent.document.getElementById("technicalName").value=technicalName;//技术负责人姓名
		//parent.document.getElementById("technicalIdCardTypeNum").value=technicalIdCardTypeNum;//技术负责人证件类型
		//parent.document.getElementById("technicalIdCard").value=technicalIdCard;//技术负责人证件号码
		//parent.document.getElementById("technicalCertNum").value=technicalCertNum;//技术负责人证书号
		//parent.document.getElementById("qualityName").value=qualityName;//质量检查员姓名
		//parent.document.getElementById("qualityIdCardTypeNum").value=qualityIdCardTypeNum;//质量检查员证件类型
		//parent.document.getElementById("qualityIdCard").value=qualityIdCard;//质量检查员证件号码
		//parent.document.getElementById("qualityCertNum").value=qualityCertNum;//质量检查员证书号
		//parent.document.getElementById("securityName").value=securityName;//安全员姓名
		//parent.document.getElementById("securityIdCardTypeNum").value=securityIdCardTypeNum;//安全员证件类型
		//parent.document.getElementById("securityIdCard").value=securityIdCard;//安全员证件号码
		//parent.document.getElementById("securityCertNum").value=securityCertNum;//安全员证书号
		//parent.document.getElementById("constructionName").value=constructionName;//施工员（工长）姓名
		//parent.document.getElementById("constructionIdCardTypeNum").value=constructionIdCardTypeNum;//施工员（工长）证件类型
		//parent.document.getElementById("constructionIdCard").value=constructionIdCard;//施工员（工长）证件号码
		//parent.document.getElementById("constructionCertNum").value=constructionCertNum;//施工员（工长）证书号
		//parent.document.getElementById("directorName").value=directorName;//（监理人员）总监姓名
		//parent.document.getElementById("directorIdCardTypeNum").value=directorIdCardTypeNum;//（监理人员）总监证件类型
		//parent.document.getElementById("directorIdCard").value=directorIdCard;//（监理人员）总监证件号码
		//parent.document.getElementById("directorCertNum").value=directorCertNum;//（监理人员）总监证书号
		//parent.document.getElementById("represEntativeName").value=represEntativeName;//总监代表姓名
		//parent.document.getElementById("represEntativeIdCardTypeNum").value=represEntativeIdCardTypeNum;//总监代表证件类型
		//parent.document.getElementById("represEntativeIdCard").value=represEntativeIdCard;//总监代表证件号码
		//parent.document.getElementById("represEntativeCertNum").value=represEntativeCertNum;//总监代表证书号
		//parent.document.getElementById("safetyName").value=safetyName;//安全监理姓名
		//parent.document.getElementById("safetyIdCardTypeNum").value=safetyIdCardTypeNum;//安全监理证件类型
		//parent.document.getElementById("safetyIdCard").value=safetyIdCard;//安全监理证件号码
		
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>施工总包合同选择</h2>
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
            	<p class="f16 fb">施工总包合同选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
							<th>项目编号</th>
							<th>项目名称</th>
							<th>合同备案编号</th>
							<th>总包合同备案类型</th>
							<th>申请日期</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio"
                          	 name="corpRadio" 
                          	 value="<s:property value="recordNum"/>^&*<s:property value="prjNum"/>^&*<s:property value="prjName"/>^&*<s:property value="projectAddress"/>^&*<s:property value="projectCost"/>^&*<s:property value="constructorName"/>^&*<s:property value="titleLeve"/>^&*<s:property value="phone"/>^&*<s:property value="area"/>^&*<s:property value="tenderNum"/>^&*<s:property value="sectionName"/>^&*<s:property value="contractNum"/>^&*<s:property value="contractMoney"/>^&*<s:property value="prjSize"/>^&*<s:property value="propietorCorpName"/>^&*<s:property value="propietorCorpCode"/>^&*<s:property value="contractorCorpName"/>^&*<s:property value="contractorCorpCode"/>^&*<s:property value="unionCorpName"/>^&*<s:property value="unionCorpCode"/>^&*<s:property value="appDept"/>^&*<s:property value="appDeptName"/>">
                          	 </td>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="prjNum"/></td>
                            <td><s:property value="prjName"/></td>
                            <td><s:property value="recordNum"/></td>
                            <td>
                            	<s:if test="contrType==1">
                            		市建
                            	</s:if>
                            	<s:if test="contrType==2">
                            		发改法规
                            	</s:if>
                            </td>
                            <td><s:date name="createDate" format="yyyy-MM-dd" /></td>
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
