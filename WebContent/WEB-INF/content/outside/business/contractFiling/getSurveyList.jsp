<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title>勘察招投标信息选择</title>
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/surveyTenderInfoAction_queryPage.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		//window.returnValue=value;
		var strs= new Array(); //定义一数组 
		strs=value.split("^&*"); //字符分割 

		var tenderNum = strs[0];
		var tenderMoney = strs[1];
		var prjSize = strs[2];
		var tenderCorpName = strs[3];
		var tenderCorpCode = strs[4];
		var sectionName = strs[5];
		var projectName = strs[5];
		var unionCorpName = strs[6];
		var unionCorpCode = strs[7];
		var propietorCorpName = strs[8];//发包单位名称
		var propietorCorpCode = strs[9]; //发包单位住组织代码
		var projectAddress = strs[10];//工程地址
		var projectCost = strs[11];//工程造价
		var area = strs[12];//面积
		var constructorName = strs[13];//项目经理姓名
		var technicalName = strs[14]//技术负责人姓名
		var technicalIdCardTypeNum = strs[15]//技术负责人证件类型
		var technicalIdCard = strs[16]//技术负责人证件号码
		var technicalCertNum = strs[17]//技术负责人证书号
		var qualityName = strs[18]//质量检查员姓名
		var qualityIdCardTypeNum = strs[19]//质量检查员证件类型
		var qualityIdCard = strs[20]//质量检查员证件号码
		var qualityCertNum = strs[21]//质量检查员证书号
		var securityName = strs[22]//安全员姓名
		var securityIdCardTypeNum = strs[23]//安全员证件类型
		var securityIdCard = strs[24]//安全员证件号码
		var seCurityCertNum = strs[25]//安全员证书号
		var constructionName = strs[26]//施工员（工长）姓名
		var constructionIdCardTypeNum = strs[27]//施工员（工长）证件类型
		var constructionIdCard = strs[28]//施工员（工长）证件号码
		var constructionCertNum = strs[29]//施工员（工长）证书号
		var directorName = strs[30]//（监理人员）总监姓名
		var directorIdCardTypeNum = strs[31]//（监理人员）总监证件类型
		var directorIdCard = strs[32]//（监理人员）总监证件号码
		var directorCertNum = strs[33]//（监理人员）总监证书号
		var represEntativeName = strs[34]//总监代表姓名
		var represEntativeIdCardTypeNum = strs[35]//总监代表证件类型
		var represEntativeIdCard = strs[36]//总监代表证件号码
		var represEntativeCertNum = strs[37]//总监代表证书号
		var safetyName = strs[38]//安全监理姓名
		var safetyIdCardTypeNum = strs[39]//安全监理证件类型
		var safetyIdCard = strs[40]//安全监理证件号码

		
		parent.document.getElementById("tenderNum").value=tenderNum;
		parent.document.getElementById("allInvest").value=tenderMoney;//合同金额
		parent.document.getElementById("prjSize").value=prjSize;
		parent.document.getElementById("tenderCorpName").value=tenderCorpName;
		parent.document.getElementById("tenderCorpCode").value=tenderCorpCode;
		parent.document.getElementById("sectionName").value=sectionName;
		parent.document.getElementById("projectName").value=sectionName;
		parent.document.getElementById("unionCorpName").value=unionCorpName;
		parent.document.getElementById("unionCorpCode").value=unionCorpCode;
		parent.document.getElementById("propietorCorpName").value=propietorCorpName;//发包单位名称
		parent.document.getElementById("propietorCorpCode").value=propietorCorpCode; //发包单位住组织代码
		parent.document.getElementById("projectAddress").value=projectAddress;//工程地址
		parent.document.getElementById("projectCost").value=projectCost;//工程造价
		parent.document.getElementById("area").value=area;//面积
		parent.document.getElementById("constructorName").value=constructorName;//项目经理姓名
		parent.document.getElementById("technicalName").value=technicalName;//技术负责人姓名
		parent.document.getElementById("technicalIdCardTypeNum").value=technicalIdCardTypeNum;//技术负责人证件类型
		parent.document.getElementById("technicalIdCard").value=technicalIdCard;//技术负责人证件号码
		parent.document.getElementById("technicalCertNum").value=technicalCertNum;//技术负责人证书号
		parent.document.getElementById("qualityName").value=qualityName;//质量检查员姓名
		parent.document.getElementById("qualityIdCardTypeNum").value=qualityIdCardTypeNum;//质量检查员证件类型
		parent.document.getElementById("qualityIdCard").value=qualityIdCard;//质量检查员证件号码
		parent.document.getElementById("qualityCertNum").value=qualityCertNum;//质量检查员证书号
		parent.document.getElementById("securityName").value=securityName;//安全员姓名
		parent.document.getElementById("securityIdCardTypeNum").value=securityIdCardTypeNum;//安全员证件类型
		parent.document.getElementById("securityIdCard").value=securityIdCard;//安全员证件号码
		parent.document.getElementById("seCurityCertNum").value=seCurityCertNum;//安全员证书号
		parent.document.getElementById("constructionName").value=constructionName;//施工员（工长）姓名
		parent.document.getElementById("constructionIdCardTypeNum").value=constructionIdCardTypeNum;//施工员（工长）证件类型
		parent.document.getElementById("constructionIdCard").value=constructionIdCard;//施工员（工长）证件号码
		parent.document.getElementById("constructionCertNum").value=constructionCertNum;//施工员（工长）证书号
		parent.document.getElementById("directorName").value=directorName;//（监理人员）总监姓名
		parent.document.getElementById("directorIdCardTypeNum").value=directorIdCardTypeNum;//（监理人员）总监证件类型
		parent.document.getElementById("directorIdCard").value=directorIdCard;//（监理人员）总监证件号码
		parent.document.getElementById("directorCertNum").value=directorCertNum;//（监理人员）总监证书号
		parent.document.getElementById("represEntativeName").value=represEntativeName;//总监代表姓名
		parent.document.getElementById("represEntativeIdCardTypeNum").value=represEntativeIdCardTypeNum;//总监代表证件类型
		parent.document.getElementById("represEntativeIdCard").value=represEntativeIdCard;//总监代表证件号码
		parent.document.getElementById("represEntativeCertNum").value=represEntativeCertNum;//总监代表证书号
		parent.document.getElementById("safetyName").value=safetyName;//安全监理姓名
		parent.document.getElementById("safetyIdCardTypeNum").value=safetyIdCardTypeNum;//安全监理证件类型
		parent.document.getElementById("safetyIdCard").value=safetyIdCard;//安全监理证件号码

		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>勘察招投标信息选择</h2>
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
            	<p class="f16 fb">勘察招投标信息选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
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
                          	<td><input onclick="corpChoose(this.value)" type="radio"
                          	 name="corpRadio" 
                          	 value="<s:property value="tenderNum"/>^&*<s:property value="tenderMoney"/>^&*<s:property value="prjSize"/>^&*<s:property value="tenderCorpName"/>^&*<s:property value="tenderCorpCode"/>^&*<s:property value="sectionName"/>^&*<s:property value="unionCorpName"/>^&*<s:property value="unionCorpCode"/>^&*<s:property value="propietorCorpName"/>^&*<s:property value="propietorCorpCode"/>^&*<s:property value="projectAddress"/>^&*<s:property value="projectCost"/>^&*<s:property value="area"/>^&*<s:property value="constructorName"/>^&*<s:property value="technicalName"/>^&*<s:property value="technicalIdCardTypeNum"/>^&*<s:property value="technicalIdCard"/>^&*<s:property value="technicalCertNum"/>^&*<s:property value="qualityName"/>^&*<s:property value="qualityIdCardTypeNum"/>^&*<s:property value="qualityIdCard"/>^&*<s:property value="qualityCertNum"/>^&*<s:property value="securityName"/>^&*<s:property value="securityIdCardTypeNum"/>^&*<s:property value="securityIdCard"/>^&*<s:property value="seCurityCertNum"/>^&*<s:property value="constructionName"/>^&*<s:property value="constructionIdCardTypeNum"/>^&*<s:property value="constructionIdCard"/>^&*<s:property value="constructionCertNum"/>^&*<s:property value="directorName"/>^&*<s:property value="directorIdCardTypeNum"/>^&*<s:property value="directorIdCard"/>^&*<s:property value="directorCertNum"/>^&*<s:property value="represEntativeName"/>^&*<s:property value="represEntativeIdCardTypeNum"/>^&*<s:property value="represEntativeIdCard"/>^&*<s:property value="represEntativeCertNum"/>^&*<s:property value="safetyName"/>^&*<s:property value="safetyIdCardTypeNum"/>^&*<s:property value="safetyIdCard"/>">
                          	</td>
                          	<td><s:property value="#i.count"/></td>
                            <td><s:property value="prjNum"/></td>
                            <td><s:property value="sectionName"/></td>
                            <td><s:property value="tenderCorpName"/>
                            <s:property value="securityName"/>
                            </td>
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
