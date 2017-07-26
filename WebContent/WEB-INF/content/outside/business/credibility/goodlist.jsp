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
function goBack()
{
	document.form1.action="<%=basepath %>/queryCredLhAction_queryPage.action";
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
                          <input id="prjNum" type="text" readonly name="crediBillitygood.corpname" value="<s:property value="crediBillitygood.corpname"/>" size="115" class="required"/>
							  </tr>
                	 
                         <tr>   
							<th>组织机构代码</th>
							<td align="left">
							<input id="prjNum" type="text" readonly name="crediBillitygood.corpcode" value="<s:property value="crediBillitygood.corpcode"/>" class="required"/>
							</td><th></th><td></td>
                         </tr>
                         <tr>
                         	<th>登记部门</th>
							<td align="left">
							<input  type="text" name="crediBillitygood.departname" value="<s:property value="crediBillitygood.departname"/>" class="required"/>
							</td>
							<th>登记人</th>
							<td align="left">
							<input type="text" name="crediBillitygood.username" value="<s:property value="crediBillitygood.username"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>奖励决定内容<strong></th>
                            <td colspan="3" align="left">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          <textarea rows=3 cols="90" ><s:property value="crediBillitygood.awardcontent"/></textarea>
                         	
                           
                         </tr>
                         <tr>
                           <th>项目编号</th>
                           <td align="left">   
                           <input id='projectAddress' name="crediBillitygood.prjnum" type="text" value="<s:property value="crediBillitygood.prjnum"/>"  class="required"/></td>
                           <th>奖励部门</th>
                           <td align="left">   
                           <input id='projectAddress' name="crediBillitygood.awarddepartname" type="text" value="<s:property value="crediBillitygood.awarddepartname"/>" class="required"/></td>
                         </tr>
                         <tr>
                           <th>登记日期</th>
                           <td align="left"><input id="time1" type="text" name="crediBillitygood.createdate" value="<s:property value="crediBillitygood.createdate"/>"   class="required" /></td>
                           <th>奖励日期</th>
                           <td align="left"><input id="time2" type="text" name="crediBillitygood.awarddate" value="<s:property value="crediBillitygood.awarddate"/>"    class="required" /></td>
                         </tr>
                         
                         <tr>
                         <th>企业类型</th>
                         <td align="left">                       
                         <input type="text" name="crediBillitygood.certtypenum" value="<s:property value="crediBillitygood.certtypenum"/>"  class="required"/></td>
                         <th>工程名称</th>
                         <td align="left">                       
                         <input type="text" name="crediBillitygood.prjname" value="<s:property value="crediBillitygood.prjname"/>" class="required"/></td>
                         
                         </tr>
                         
                         
                         
                         <tr>
                           <th>工程地址</th>
                           <td align="left"><input type="text" name="crediBillitygood.address" value="<s:property value="crediBillitygood.address"/>" class="required" /></td>
                           <th>建设单位</th>
                           <td align="left"><input type="text" name="crediBillitygood.buildcorpname" value="<s:property value="crediBillitygood.buildcorpname"/>" class="required number"/></td>
                         
                         </tr>
                         
                         <tr>
                           <th>建设单位组织机构代码</th>
                           <td align="left"><input type="text" name="crediBillitygood.buildcorpcode" value="<s:property value="crediBillitygood.buildcorpcode"/>" class="required"/></td>
                           <th>	审核领导</th>
                           <td align="left"><input type="text" name="crediBillitygood.auditusername" value="<s:property value="crediBillitygood.auditusername"/>" class="required number"/></td>
                         </tr>
                         <tr>
                         <th>发布开始时间</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="crediBillitygood.publicbdate" value="<s:property value="crediBillitygood.publicbdate"/>"    class="required"/> 
                         </td>
                         <th>发布结束时间</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="crediBillitygood.publicedate" value="<s:property value="crediBillitygood.publicedate"/>"    class="required"/> 
                         </td>
                         </tr>  
                         <tr>
                         
                         <th>良好行为发生所在省</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="crediBillitygood.provincenum" value="<s:property value="crediBillitygood.provincenum"/>"    class="required"/> 
                         </td>
                         <th>良好行为发生所在地市</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="crediBillitygood.citynum" value="<s:property value="crediBillitygood.citynum"/>"   class="required"/> 
                         </td>
                         </tr>
                         
                         <tr>
                         <th>良好行为发生所在区县</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="crediBillitygood.countynum" value="<s:property value="crediBillitygood.countynum"/>"    class="required"/> 
                         </td>
                         <th>奖励决定文号</th>
                          <td align="left">
                         <input id='contractorCorpName' type="text" name="crediBillitygood.awardnumber" value="<s:property value="crediBillitygood.awardnumber"/>"    class="required"/> 
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
