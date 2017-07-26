<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title></title>
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/queryPermQualityAction_queryPage.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		//window.returnValue=value;
		var strs= new Array(); //定义一数组 
		strs=value.split("^&*"); //字符分割 

		var qualityNum = strs[0];//质量编码
		var tenderNum = strs[1];//中标通知书编号
		var sectionName = strs[2];//标段名称
		var projectName = strs[3];//工程名称
		var constructionArea = strs[4];//面积
		var surveyUnit = strs[5];//勘察单位全称
		var surveyCode = strs[6];//勘察单位组织机构代码
		var designUnit = strs[7];//设计单位全称
		var designCode = strs[8];//设计单位组织机构代码
		var constructionUnit = strs[9];//施工总承包单位全称
		var constructionCode = strs[10];//施工总承包单位组织机构代码
		var contractMoney = strs[11];//合同金额
		var safetyCerId = strs[12];//施工单位安全生产许可证编号
		var prjId = strs[13];//项目主键
		
		parent.document.getElementById("qualityNum").value=qualityNum;
		parent.document.getElementById("tenderNum").value=tenderNum;
		parent.document.getElementById("sectionName").value=sectionName;
		parent.document.getElementById("projectName").value=projectName;
		parent.document.getElementById("area").value=constructionArea;
		parent.document.getElementById("econCorpName").value=surveyUnit;
		parent.document.getElementById("econCorpCode").value=surveyCode;
		parent.document.getElementById("designCorpName").value=designUnit;
		parent.document.getElementById("designCorpCode").value=designCode;
		parent.document.getElementById("consCorpname").value=constructionUnit;
		parent.document.getElementById("consCorpCode").value=constructionCode;
		parent.document.getElementById("contractMoney").value=contractMoney;
		parent.document.getElementById("safetyCerId").value=safetyCerId;
		parent.document.getElementById("prjId").value=prjId;
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>质量信息选择</h2>
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
            	<p class="f16 fb">质量信息选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
							<th>项目名称</th>
							<th>项目编号</th>
							<th>质量编码</th>
							<th>申请日期</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio" name="corpRadio" 
                          	value="<s:property value="qualityNum"/>^&*<s:property value="tenderNum"/>^&*<s:property value="sectionName"/>^&*<s:property value="projectName"/>^&*<s:property value="constructionArea"/>^&*<s:property value="surveyUnit"/>^&*<s:property value="surveyCode"/>^&*<s:property value="designUnit"/>^&*<s:property value="designCode"/>^&*<s:property value="constructionUnit"/>^&*<s:property value="constructionCode"/>^&*<s:property value="contractMoney"/>^&*<s:property value="safetyCerId"/>^&*<s:property value="prjId"/>">
							</td>
							<td><s:property value="#i.count"/> </td>
                            <td><s:property value="prjName"/></td>
                            <td><s:property value="prjNum"/></td>
                            <td><s:property value="qualityNum"/></td>
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
