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
		document.form1.action="<%=basepath %>/queryCorpsAction_queryPage.action";
		document.form1.submit();
	}
	
	function corpChoose(value)
	{
		var parent=window.dialogArguments;
		//window.returnValue=value;
		var strs= new Array(); //定义一数组 
		strs = value.split(","); //字符分割 
		var corpCode = strs[0];
		var corpName = strs[1];
		var economicNum = strs[2];
		var economicName= strs[3];
		parent.document.getElementById("corpCode").value = corpCode;
		parent.document.getElementById("corpName").value = corpName;
		parent.document.getElementById("economicNum").value = economicNum;
		parent.document.getElementById("economicName").value = economicName;
		window.close();
	}
</script>
</head>

<body>

	<div class="ry_wrapp">
    	<form id="form1" name="form1" method="post" action="<%=basepath %>/queryCorpsAction_queryPage.action">
      
        <div class="ry_content">
        
        	<div class="ry_main" cellpadding="0" cellspacing="0">
              	<h2>企业备案申请</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>时间：</td>
                        <td colspan="3">
                        <input id="time1" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" type="text" name="condition.startDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        <input id="time2" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" type="text" name="condition.endDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>
                    <tr >
                        <td>企业名称：</td>
                        <td>
                        <input type = "text" name="condition.corpName" value = "<s:property value = "condition.corpName"/>" />
                        </td>
                        <td >组织机构代码：</td>
                        <td>
                        <input type = "text" name="condition.corpCode" value = "<s:property value = "condition.corpCode"/>" />
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
            	<p class="f16 fb">企业备案申请列表<img src="<%=basepath %>/images/ry_lie.png" /></p>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>
							<tr>
								<th>选择</th>
								<th>序号</th>
								<th>企业名称</th>
								<th>组织机构代码</th>
								<th>工商营业执照注册号</th>
								<th>办公电话</th>
								<th>企业类型</th>
								<th>申请日期</th>
							</tr>

							<s:iterator status="i" value="currentPage.data">
								<tr>
									<td><input onclick="corpChoose(this.value)" type="radio"
										name="corpRadio"
										value="<s:property value="corpCode"/>,<s:property value="corpName"/>,<s:property value="economicNum"/>,<s:property value="economicName"/>"></td>
									<td><s:property value="#i.count" /></td>
									<td><s:property value="corpName" /></td>
									<td><s:property value="corpCode" /></td>
									<td><s:property value="licenseNum" /></td>
									<td><s:property value="officePhone" /></td>
									<td><s:property value="economicName" /></td>
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
