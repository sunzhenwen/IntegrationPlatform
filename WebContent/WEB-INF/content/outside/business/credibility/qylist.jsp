<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业安全监督申请 </title>
<script type="text/javascript" src="jquery-1.11.1.js"></script>
<style type="text/css">
table { border-collapse:collapse;width:100%; border:1px solid #000;}
table td{height:22px; border:1px solid #000;}
table.fulltable{width:100%;border:none;}
</style>
<script type="text/javascript">
//返回
function goBack()
{
	document.form1.action="<%=basepath %>/queryCredAction_queryPage.action";
	document.form1.submit();
}
</script>
</head>

<body>
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>企业安全监督申请</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>  
                	<tr>
                           <th>企业名称：</th>
                           <td colspan="3" align="left">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          <input id="prjNum" type="text" readonly name="credibillity.corpname" value="<s:property value="credibillity.corpname"/>" size="115" class="required"/>
							<input id="prjId" type="hidden" readonly name="safety.prjId" value="<s:property value="safety.prjId"/>" class="required"/>
							<input type="hidden" readonly name="safety.safetyId" value="<s:property value="safety.safetyId"/>" class="required"/></td>
                           
                         </tr>
                	 
                         <tr>   
							<th>组织机构代码</th>
							<td align="left">
							<input id="prjNum" type="text" readonly name="credibillity.corpcode" value="<s:property value="credibillity.corpcode"/>" class="required"/>
							</td><th></th><td></td>
                         </tr>
                         <tr>
                         	<th>不良行为类别</th>
							<td align="left">
							<input  type="text" name="credibillity.credittype" value="<s:property value="credibillity.credittype"/>" class="required"/>
							</td>
							<th>不良行为发生日期</th>
							<td align="left"> 
							<input type="text" name="credibillity.happendate" value="<s:property value="credibillity.happendate"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>处罚依据<strong></th>
                            <td colspan="3" align="left">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          	 <textarea rows=3 cols="90" ><s:property value="credibillity.punishevidence"/></textarea>
                           
                         </tr>
                         <tr>
                           <th>处罚决定内容</th>
                           <td colspan="3" align="left">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                           <input id='projectAddress' name="credibillity.punishcontent" type="text" value="<s:property value="credibillity.punishcontent"/>" size="115" class="required"/></td>
                           
                         </tr>
                         <tr>
                           <th>处罚日期</th>
                           <td align="left"><input id="time1" type="text" name="credibillity.punishdate" value="<s:property value="credibillity.punishdate"/>"  class="required" /></td>
                           <th>处罚截止日期</th>
                           <td align="left"><input id="time2" type="text" name="credibillity.punishedate" value="<s:property value="credibillity.punishedate"/>"    class="required" /></td>
                         </tr>
                         
                         <tr>
                         <th>不良行为内容</th>
                         <td colspan="3" align="left">
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                         <input type="text" name="credibillity.content" value="<s:property value="credibillity.content"/>" size="115" class="required"/></td>
                         </tr>
                         <tr>
                           <th>项目编号</th>
                           <td align="left"><input type="text" name="credibillity.prjnum" value="<s:property value="credibillity.prjnum"/>" class="required" /></td>
                           <th>登记部门</th>
                           <td align="left"><input type="text" name="credibillity.departname" value="<s:property value="credibillity.departname"/>" class="required number"/></td>
                         
                         </tr>
                         
                         <tr>
                           <th>企业类型</th>
                           <td align="left"><input type="text" name="credibillity.certtypenum" value="<s:property value="credibillity.certtypenum"/>" class="required"/></td>
                           <th>工程名称</th>
                           <td align="left"><input type="text" name="credibillity.prjname" value="<s:property value="credibillity.prjname"/>" class="required number"/></td>
                         </tr>
                         <tr>
                         <th>工程地址</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="credibillity.address" value="<s:property value="credibillity.address"/>"    class="required"/> 
                         </td>
                         <th>建设单位</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="credibillity.buildcorpname" value="<s:property value="credibillity.buildcorpname"/>"    class="required"/> 
                         </td>
                         </tr>
                         
                      
                         <tr>
                         <th>处罚部门</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="credibillity.punishdepartname" value="<s:property value="credibillity.punishdepartname"/>"    class="required"/> 
                         </td>
                         <th>审核时间</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="credibillity.auditdate" value="<s:property value="credibillity.auditdate"/>"   class="required"/> 
                         </td>
                         </tr>
                         
                         <tr>
                         <th>审核领导</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="credibillity.auditusername" value="<s:property value="credibillity.auditusername"/>"    class="required"/> 
                         </td>
                         <th>处罚金额</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="credibillity.punishmoney" value="<s:property value="credibillity.punishmoney"/>"    class="required"/> 
                         </td>
                         </tr>
                         
                         
                          <tr>
                         <th>发布结束时间</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="credibillity.publicedate" value="<s:property value="credibillity.publicedate"/>"   class="required"/> 
                         </td>
                         <th>发布开始时间</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="credibillity.publicbdate" value="<s:property value="credibillity.publicbdate"/>"  class="required"/> 
                         </td>
                         </tr>
                         
                          <tr>
                         <th>不良行为发生所在省</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="credibillity.provincenum" value="<s:property value="credibillity.provincenum"/>"   class="required"/> 
                         </td>
                         <th>不良行为发生所在地市</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="credibillity.citynum" value="<s:property value="credibillity.citynum"/>"  class="required"/> 
                         </td>
                         </tr>
                         
                          <tr>
                         <th>不良行为发生所在区县</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="credibillity.countynum" value="<s:property value="credibillity.countynum"/>"   class="required"/> 
                         </td>
                         <th>不良行为分类</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="credibillity.creditclassnum" value="<s:property value="credibillity.creditclassnum"/>"  class="required"/> 
                         </td>
                         </tr>
                         
                  </tbody>  
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/ry_return.png" onclick="goBack()" />
            	</div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
