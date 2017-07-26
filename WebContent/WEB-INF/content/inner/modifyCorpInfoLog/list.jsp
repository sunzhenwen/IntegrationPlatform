<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业信息修改查询</title>
<script type="text/javascript">

	//查询
	function query()
	{
		document.form1.action="<%=basepath %>/modifyCorpInfoLogAction_queryPage.action";
		document.form1.submit();
	}

</script>
</head>
<body>
<div class="libiao">
<form id="form1" name="form1" method="post" action="">
<table width="100%"  border="0" cellpadding="0" height="15%">
     <tr>
	    <td >	
	      <fieldset>
		  <legend  class="chaxuntj" >企业信息修改历史查询</legend>	
          <p style="margin-bottom:10px; text-align:right;">
          <a href="#" onclick="query()"><span class="lbchx">查询</span></a> 
			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" height="10%">
				<tr>
			    	<td colspan="4">日期选择：
						<input id="time1" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" type="text" name="condition.startDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
						~
						<input id="time2" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" type="text" name="condition.endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
					</td>
  		        </tr>
		        <tr>
			        <td>企业名称：</td>
			  		<td>
			  			<input type="text" name="condition.corpName" value="<s:property value="condition.corpName"/>" />
			  		</td>
			        <td>组织结构代码号：</td>
			  		<td>
			  			<input type="text" name="condition.corpCode" value="<s:property value="condition.corpCode"/>" />
			  		</td>
			  	</tr>
    		</table>
	      </fieldset>
		</td>
   	</tr>
</table>
</form>
<table width = "100%" border  = "0"  cellpadding = "0"  cellspacing="0"   onmouseover="changeto()"  onmouseout="changeback()" >
	<tr >
		<th>序号</th>
		<th>企业名称</th>
		<th>组织机构代码证号</th>
		<th>修改日期</th>
		<th>操作</th>
	</tr>
	<s:iterator status="i" value="currentPage.data" > 
	<tr>
		<td><s:property value="#i.count"/></td>
		<td><s:property value="corpName"/></td>
		<td><s:property value="corpCode" /></td>
		<td><s:property value="modifyDate"/></td>
		<td align='center'> <a href="modifyCorpInfoLogAction_queryInfo.action?logId=<s:property value="logid"/>">详细</a> </td>
	</tr>
	</s:iterator>
</table>
</div>
 <%@include file="/WEB-INF/content/inc/page.jsp"%> 
</div>
</body>
</html>