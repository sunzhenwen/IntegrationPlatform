<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop2.jsp" %>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单体工程 </title>
<base  target="_self" /> 
<script type="text/javascript">


	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/innerSingleProjectAction_goList.action";
		document.form1.submit();
	}

	
</script>

</head>

<body>
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">
	
	<form id="form1" name="form1" method="post" action="" target="win_test" enctype="multipart/form-data">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>单体工程</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>单位编码：</th>
							<td colspan="4">
							<input type="text" readonly size="100" name="singleProject.spNum" value="<s:property value="singleProject.spNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="prjNum" type="hidden" name="prjNum" value="<s:property value="singleProject.prjNum"/>" />
                        	<input id="foreignId" type="hidden" name="foreignId" value="<s:property value="singleProject.foreignId"/>" />
                        	<input id="linkName" type="hidden" name="linkName" value="<s:property value="singleProject.linkName"/>" />
                        	<input type="hidden" name="singleProject.spId" value="<s:property value="singleProject.spId"/>" />
							</td>
						</tr>
                         
                         <tr>
                        	<th>单位建(构)筑物名称：</th>
							<td colspan="4">
							<input type="text" size="100" name="singleProject.buildingName" value="<s:property value="singleProject.buildingName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                        	<th>建筑面积(平方米)：</th>
							<td colspan="2">
							<input type="text" name="singleProject.buildingArea" value="<s:property value="singleProject.buildingArea"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>投资额(万元)：</th>
							<td colspan="2">
							<input type="text" name="singleProject.investAmount" value="<s:property value="singleProject.investAmount"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
          
						<tr>
                         	<th>地上建筑面积(平方米)：</th>
							<td colspan="2">
							<input type="text" name="singleProject.overgroundArea"  value="<s:property value="singleProject.overgroundArea"/>" />
							</td>
                         	<th>地下建筑面积(平方米)：</th>
							<td colspan="2">
							<input type="text" name="singleProject.undergroundArea" value="<s:property value="singleProject.undergroundArea"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                        <tr>
                        	<th>地上层数：</th>
							<td colspan="2">
							<input id="allInvest" type="text" name="singleProject.overgroundNum" value="<s:property value="singleProject.overgroundNum"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>
                       		<th>地下层数：</th>
							<td colspan="2">
							<input type="text" name="singleProject.undergroundNum" value="<s:property value="singleProject.undergroundNum"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                        <tr>
                       		<th>建筑高度(米)：</th>
							<td colspan="2">
							<input type="text" name="singleProject.buildingHeight" value="<s:property value="singleProject.buildingHeight"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                       		<th>工程等级：</th>
							<td colspan="2">
							<select name="singleProject.engineeringGrade" class="required">
     							<option value="">请选择</option>
     							<s:if test="singleProject.engineeringGrade==0">
     							<option value="0" selected>大型</option>
	      						<option value="1">中型</option>
	      						<option value="2">小型</option>
     							</s:if>
     							<s:if test="singleProject.engineeringGrade==1">
     							<option value="0">大型</option>
	      						<option value="1" selected>中型</option>
	      						<option value="2">小型</option>
     							</s:if>
	      						<s:if test="singleProject.engineeringGrade==2">
     							<option value="0">大型</option>
	      						<option value="1">中型</option>
	      						<option value="2" selected>小型</option>
     							</s:if>
	      					</select><strong><font color="#FF0000">*</font></strong>
							</td>
							
                        </tr>
                        <tr>
                        	<th>长度(公里)：</th>
							<td colspan="2">
							<input type="text" name="singleProject.lengthKm" value="<s:property value="singleProject.lengthKm"/>" /><strong><font color="#FF0000">*</font></strong>
							</td>
                       		<th>跨度(米)：</th>
							<td colspan="2">
							<input type="text" name="singleProject.spanM" value="<s:property value="singleProject.spanM"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                        <tr>
                       		<th>体系结构：</th>
							<td colspan="4">
							<select name="singleProject.prjStructureTypeNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="prjStructureTypeNums">
	          						<option value="<s:property value="code"/>"<s:if test='singleProject.prjStructureTypeNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
						<tr>
                       		<th>工程规模：</th>
							<td colspan="4">
							<textarea name="singleProject.projectSize" cols="100" rows="5"><s:property value="singleProject.projectSize"/></textarea>
							</td>
						</tr>
                        <tr>
                       		<th>其它：</th>
							<td colspan="4">
							<textarea name="singleProject.other" cols="100" rows="5"><s:property value="singleProject.other"/></textarea>
							</td>
						</tr>
                        
                </tbody>  
                
                </table>
                 <div class="botn"> 
		        	<!-- <input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />  -->
            	</div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
