<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>勘察设计审图人员 </title>
<script type="text/javascript">

	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            form.submit();
	        }    
	 	});
	});

	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/designSurveyStaffAction_goList.action";
		document.form1.submit();
	}
	
	//查询项目
	function queryPrjName()
	{
		var url="<%=basepath %>/designSurveyPrjsAction_queryPage.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
</script>

</head>

<body>
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="<%=basepath %>/designSurveyStaffAction_add.action">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>勘察设计审图人员添加</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td align="left">
							<input id="prjName" type="text" readonly name="dsStaff.prjName" value="<s:property value="dsStaff.prjName"/>" class="required"/><a href="#" onclick="queryPrjName()">选择</a>
							<input id="appDeptName" readonly type="hidden" name="permit.appDeptName" value="" class="required"/>
							<input id="appDept" type="hidden" name="permit.appDept" value=""/>
							<input id="prjId" type="hidden" readonly name="permit.prjId" value="" class="required"/>
							</td>
							<th>项目编号：</th>
							<td align="left">
							<input id="prjNum" type="text" readonly name="dsStaff.prjNum" value="<s:property value="dsStaff.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>所属单位名称：</th>
							<td align="left">
							<input type="text" name="dsStaff.corpName" value="<s:property value="dsStaff.corpName"/>" class="required"/>
							<input type="hidden" readonly name="dsStaff.conCorpName" value="<s:property value="conCorpName"/>" />
							</td>
							<th>所属单位组织机构改代码：</th>
							<td align="left">
							<input type="text" name="dsStaff.corpCode" value="<s:property value="dsStaff.corpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input type="hidden" readonly name="dsStaff.conCorpCode" value="<s:property value="conCorpCode"/>" />
							</td>
                         </tr>
                         <tr>
                         	<th>人员姓名：</th>
							<td align="left">
							<input type="text" name="dsStaff.userName" value="<s:property value="dsStaff.userName"/>" class="required"/>
							</td>
							<th>证件类型：</th>
							<td align="left">
							<select name="dsStaff.idCardTypeNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="idCardTypeNums">
	          						<option value="<s:property value="code"/>"<s:if test='dsStaff.idCardTypeNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>人员证件号码：</th>
							<td align="left">
							<input type="text" name="dsStaff.idCard" value="<s:property value="dsStaff.idCard"/>" class="required"/>
							</td>
							<th>注册类型及等级：</th>
							<td align="left">
							<select name="dsStaff.specialtyTypNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="specialtyTypNums">
	          						<option value="<s:property value="code"/>"<s:if test='dsStaff.specialtyTypNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>承担角色：</th>
							<td align="left">
							<select name="dsStaff.prjDuty" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="prjDutys">
	          						<option value="<s:property value="code"/>"<s:if test='dsStaff.prjDuty==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>施工图审查合格书编号</th>
							<td align="left">
							<input type="text" name="dsStaff.censorNum" value="<s:property value="dsStaff.censorNum"/>" class="required"/>
							</td>
                         </tr>
                </tbody>  
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
		            <input type="image"src="<%=basepath %>/images/shangbao.jpg" />
            	</div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
