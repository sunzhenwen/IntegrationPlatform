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
		document.form1.action="<%=basepath %>/queryPermSafetyAction_queryPage.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		//window.returnValue=value;
		var strs= new Array(); //定义一数组 
		strs=value.split("^&*"); //字符分割 
		var result;
		var safetyNum = strs[0];//安全监督编码
		var supervisionName = strs[1];//监理单位全称
		var contractorCorpCode = strs[2];//监理单位组织机构代码
		var supervisionStaff = strs[3];//监理单位项目总监姓名
		var probationStaff = strs[4];//监理单位安全监督姓名
		var contractstart = strs[5];
		var contractend = strs[6];
		if(contractstart!="" && contractend!="")
		{
			var sArr = contractstart.split("-");
			var eArr = contractend.split("-");
			var sRDate = new Date(sArr[0], sArr[1], sArr[2]);
			var eRDate = new Date(eArr[0], eArr[1], eArr[2]);
			var starttimes = sRDate.getTime();
			var lktimes = eRDate.getTime();
			result = (eRDate-sRDate)/(24*60*60*1000);
		}
		parent.document.getElementById("safetyNum").value=safetyNum;
		parent.document.getElementById("superCorpName").value=supervisionName;
		parent.document.getElementById("superCorpCode").value=contractorCorpCode;
		parent.document.getElementById("supervisionName").value=supervisionStaff;
		parent.document.getElementById("constructorName").value=probationStaff;
		parent.document.getElementById("time1").value=contractstart;
		parent.document.getElementById("time2").value=contractend;
		parent.document.getElementById("times").value=result;
		window.close();
	}
	
	function checkDate()
	{
		
		
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>安全信息选择</h2>
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
            	<p class="f16 fb">安全信息选择<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>选择</th>
                         	<th>序号</th>
							<th>项目编号</th>
							<th>项目名称</th>
							<th>安全编号</th>
							<th>申请日期</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
							<td><input onclick="corpChoose(this.value)" type="radio" name="corpRadio" 
                          	value="<s:property value="safetyNum"/>^&*<s:property value="supervisionName"/>^&*<s:property value="contractorCorpCode"/>^&*<s:property value="supervisionStaff"/>^&*<s:property value="probationStaff"/>^&*<s:date name="contractstart" format="yyyy-MM-dd" />^&*<s:date name="contractend" format="yyyy-MM-dd" />">
							</td>
							<td><s:property value="#i.count"/> </td>
                            <td><s:property value="prjNum"/></td>
                            <td><s:property value="prjName"/></td>
                            <td><s:property value="safetyNum"/></td>
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
