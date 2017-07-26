<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base target="_self" />
<title>项目信息选择</title>
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/queryAuPrjsAction_queryPage.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		//window.returnValue=value;
		var strs= new Array(); //定义一数组 
		strs=value.split(","); //字符分割 
		var prjId = strs[0];
		var prjNum = strs[1];
		var prjName = strs[2];
		var appDept = strs[3];
		var appDeptName = strs[4];
		var buildCorpName = strs[5];
		var buildCorpCode = strs[6];
		parent.document.getElementById("prjId").value=prjId;
		parent.document.getElementById("prjNum").value=prjNum;
		parent.document.getElementById("prjName").value=prjName;
		parent.document.getElementById("appDept").value=appDept;
		parent.document.getElementById("appDeptName").value=appDeptName;
		parent.document.getElementById("buildCorpName").value=buildCorpName;
		parent.document.getElementById("buildCorpCode").value=buildCorpCode;
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
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>
                    <tr >
                        <td>项目编号：</td>
                        <td>
                        <input type="text" name="condition.prjNum" value = "<s:property value = "condition.prjNum"/>" />
                        </td>
                        <td>项目名称：</td>
                        <td>
                        <input name="condition.prjName" value = "<s:property value = "condition.prjName"/>" />
                        <input type="hidden" name="condition.corpCode" value = "<s:property value = "condition.corpCode"/>" />
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
							<th>项目名称</th>
							<th>审批单位</th>
							<th>申请日期</th>
						</tr>
                          
                         <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><input onclick="corpChoose(this.value)" type="radio" name="corpRadio" value="<s:property value="prjId"/>,<s:property value="prjNum"/>,<s:property value="prjName"/>,<s:property value="appDept"/>,<s:property value="appDeptName"/>,<s:property value="buildCorpName"/>,<s:property value="buildCorpCode"/>"></td>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="prjNum"/></td>
                            <td><s:property value="prjName"/></td>
                            <td><s:property value="appDeptName"/></td>
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
