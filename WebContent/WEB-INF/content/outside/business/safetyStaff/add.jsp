<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>施工安全从业人员 </title>
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
		document.form1.action="<%=basepath %>/safetyStaffAction_goList.action";
		document.form1.submit();
	}
	
	//查询项目
	function queryPrjName()
	{
		var url="<%=basepath %>/qualityPrjsAction_queryPage.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
</script>

</head>

<body>
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="<%=basepath %>/safetyStaffAction_add.action">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>施工安全从业人员添加</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td align="left">
							<input id="prjName" type="text" readonly name="safetyStaff.prjName" value="<s:property value="safetyStaff.prjName"/>" class="required"/><a href="#" onclick="queryPrjName()">选择</a>
							<input id="appDeptName" readonly type="hidden" name="permit.appDeptName" value="" class="required"/>
							<input id="appDept" type="hidden" name="permit.appDept" value=""/>
							<input id="prjId" type="hidden" readonly name="permit.prjId" value="" class="required"/>
							</td>
							<th>项目编号：</th>
							<td align="left">
							<input id="prjNum" type="text" readonly name="safetyStaff.prjNum" value="<s:property value="safetyStaff.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>所属单位名称：</th>
							<td align="left">
							<input type="text" readonly name="safetyStaff.corpName" value="<s:property value="corpName"/>" class="required"/>
							</td>
							<th>所属单位组织机构改代码：</th>
							<td align="left">
							<input type="text" readonly name="safetyStaff.corpCode" value="<s:property value="corpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>施工许可证编号：</th>
							<td align="left">
							<input type="text" name="safetyStaff.builderLicenceNum" value="<s:property value="safetyStaff.builderLicenceNum"/>" class="required"/>
							</td>
							<th>安全生产许可证编号：</th>
							<td align="left">
							<input type="text" name="safetyStaff.safetyCerId" value="<s:property value="safetyStaff.safetyCerId"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>人员姓名：</th>
							<td align="left">
							<input type="text" name="safetyStaff.userName" value="<s:property value="safetyStaff.userName"/>" class="required"/>
							</td>
							<th>证件类型：</th>
							<td align="left">
							<select name="safetyStaff.idCardTypeNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="idCardTypeNums">
	          						<option value="<s:property value="code"/>"<s:if test='safetyStaff.idCardTypeNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>人员证件号码：</th>
							<td align="left">
							<input type="text" name="safetyStaff.idCard" value="<s:property value="safetyStaff.idCard"/>" class="required"/>
							</td>
							<th>安全生产考核合格证书编号：</th>
							<td align="left">
							<input type="text" name="safetyStaff.certId" value="<s:property value="safetyStaff.certId"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>安全生产管理人员类型：</th>
							<td align="left">
							<select name="safetyStaff.userType" class="required">
     							<option value="">请选择</option>
	      						<option value="1">主要负责人</option>
	          					<option value="2">项目负责人</option>
	          					<option value="3">安全员</option>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
							<th></th>
							<td>
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
