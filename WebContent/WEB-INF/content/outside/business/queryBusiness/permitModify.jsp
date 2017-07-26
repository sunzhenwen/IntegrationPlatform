<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>施工许可申请 </title>
<script type="text/javascript">

	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/queryPermitAction_goList.action";
		document.form1.submit();
	}
	
	//查询单体工程信息
	function querySingleProject()
	{ 
		var prjNum = $("#prjNum").val();
		var prjId = $("#prjId").val();
		var url = "<%=basepath %>/querySingleProjectAction_queryPage.action?prjNum="+prjNum+"&prjId="+prjId+"&condition.prjId="+prjId+"&condition.linkName=5&linkName=5";
		var newWin=window.showModalDialog(url,window,'dialogHeight:900px;dialogWidth:1300px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
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
              	<h2>施工许可申请</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td align="left">
							<input id="prjName" type="text" readonly name="permit.prjName" value="<s:property value="permit.prjName"/>" class="required"/>
							<input id="prjId" type="hidden" readonly name="permit.prjId" value="<s:property value="permit.prjId"/>" class="required"/>
							<input id="permitId" type="hidden" readonly name="permit.permitId" value="<s:property value="permit.permitId"/>" class="required"/>
							</td>
							<th>项目编号：</th>
							<td align="left">
							<input id="prjNum" type="text" readonly name="permit.prjNum" value="<s:property value="permit.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>申请企业名称：</th>
							<td align="left">
							<input type="text" readonly name="permit.applyCorpName" value="<s:property value="permit.applyCorpName"/>" class="required"/>
							</td>
							<th>申请企业代码：</th>
							<td align="left">
							<input type="text" readonly name="permit.applyCorpCode" value="<s:property value="permit.applyCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="appDeptName" readonly type="hidden" name="permit.appDeptName" value="<s:property value="permit.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="permit.appDept" value="<s:property value="permit.appDept"/>"/>
							</td>
                         </tr>
                         <tr>
                        	<th>施工许可证编号：</th>
							<td align="left">
								<input type="text" readonly name="permit.builderLicenceNum" value="<s:property value="permit.builderLicenceNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	<th>工程名称：</th>
							<td align="left">
							<input type="text" name="permit.projectName" value="<s:property value="permit.projectName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
                         </tr>
                         
                         <tr>
                         	<th>建设用地规划许可证编号：</th>
							<td align="left">
							<input type="text" name="permit.buldPlanNum" value="<s:property value="permit.buldPlanNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>建设工程规划许可证编号：</th>
							<td align="left">
							<input type="text" name="permit.projectPlanNum" value="<s:property value="permit.projectPlanNum"/>" class="required"/>
							</td>
						</tr>
                         <tr>
                         	<th>施工图审查合格书编号：</th>
							<td align="left">
							<input type="text" name="permit.censorNum" value="<s:property value="permit.censorNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>合同金额(万元)：</th>
							<td align="left">
							<input type="text" name="permit.contractMoney" value="<s:property value="permit.contractMoney"/>" class="required"/>
							</td>
							
                         </tr>
                         <tr>
                         	<th>面积(平方米)：</th>
							<td align="left">
							<input type="text" name="permit.area" value="<s:property value="permit.area"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
							<th>发证日期：</th>
							<td align="left">
							<input id="time1" type="text" name="permit.issueCertDate" value="<s:date name="permit.issueCertDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	
							<th>勘察单位名称：</th>
							<td align="left">
							<input type="text" name="permit.econCorpName" value="<s:property value="permit.econCorpName"/>" class="required"/>
							</td>
							<th>勘察单位组织机构代码：</th>
							<td align="left">
							<input type="text" name="permit.econCorpCode" value="<s:property value="permit.econCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	
							
							<th>设计单位名称：</th>
							<td align="left">
							<input type="text" name="permit.designCorpName" value="<s:property value="permit.designCorpName"/>" class="required"/>
							</td>
							<th>设计单位组织机构代码：</th>
							<td align="left">
							<input type="text" name="permit.designCorpCode" value="<s:property value="permit.designCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	
							
							<th>施工单位名称：</th>
							<td align="left">
							<input type="text" name="permit.consCorpname" value="<s:property value="permit.consCorpname"/>" class="required"/>
							</td>
							<th>施工单位组织机构代码：</th>
							<td align="left">
							<input type="text" name="permit.consCorpCode" value="<s:property value="permit.consCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	
							
							<th>施工单位安全生产许可证编号：</th>
							<td align="left">
							<input type="text" name="permit.safetyCerId" value="<s:property value="permit.safetyCerId"/>" class="required"/>
							</td>
							<th>监理单位名称：</th>
							<td align="left">
							<input type="text" name="permit.superCorpName" value="<s:property value="permit.superCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
                         </tr>
                         <tr>
                         	
							<th>监理单位组织机构代码：</th>
							<td align="left">
							<input type="text" name="permit.superCorpCode" value="<s:property value="permit.superCorpCode"/>" class="required"/>
							</td>
							<th>项目经理姓名：</th>
							<td align="left">
							<input type="text" name="permit.constructorName" value="<s:property value="permit.constructorName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	
							<th>项目经理证件类型：</th>
							<td align="left">
							<select name="permit.cidCardTypeNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="cardTypeNums">
	          						<option value="<s:property value="code"/>"<s:if test='permit.cidCardTypeNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>项目经理证件号码：</th>
							<td align="left">
							<input type="text" name="permit.constructorIdCard" value="<s:property value="permit.constructorIdCard"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	
							<th>总监理工程师姓名：</th>
							<td align="left">
							<input type="text" name="permit.supervisionName" value="<s:property value="permit.supervisionName"/>" class="required"/>
							</td>
							<th>总监理工程师证件类型：</th>
							<td align="left">
							<select name="permit.sidCardTypeNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="cardTypeNums">
	          						<option value="<s:property value="code"/>"<s:if test='permit.sidCardTypeNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	
							<th>总监理工程师号码：</th>
							<td align="left">
							<input type="text" name="permit.supervisionIdCard" value="<s:property value="permit.supervisionIdCard"/>" class="required"/>
							</td>
							
							<th>&nbsp;</th>
							<td>&nbsp;</td>
							<!-- 
							<th>安全生产管理人员姓名：</th>
							<td>
							<input type="text" name="permit.userName" value="<s:property value="permit.userName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							 -->
                         </tr>
                         <!-- 
                         <tr>
                         	
							<th>安全生产管理证件类型：</th>
							<td>
							<select name="permit.idCardTypeNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="cardTypeNums">
	          						<option value="<s:property value="code"/>"<s:if test='permit.idCardTypeNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>安全生产管理人员证件号：</th>
							<td>
							<input type="text" name="permit.idCard" value="<s:property value="permit.idCard"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	
							<th>安全生产考核合格证书编号：</th>
							<td>
							<input type="text" name="permit.certId" value="<s:property value="permit.certId"/>" class="required"/>
							</td>
							<th>安全生产管理人员类型：</th>
							<td>
							<select name="permit.userType" class="required">
								<s:if test="permit.userType==1">
									<option value="">请选择</option>
		      						<option value="1" selected>主要负责人</option>
		          					<option value="2">项目负责人</option>
		          					<option value="3">安全员</option>
								</s:if>
								<s:if test="permit.userType==2">
									<option value="">请选择</option>
		      						<option value="1">主要负责人</option>
		          					<option value="2" selected>项目负责人</option>
		          					<option value="3">安全员</option>
								</s:if>
								<s:if test="permit.userType==3">
									<option value="">请选择</option>
		      						<option value="1">主要负责人</option>
		          					<option value="2">项目负责人</option>
		          					<option value="3" selected>安全员</option>
								</s:if>
     							
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                          -->
                        <tr>
                       		<th>建设规模：</th>
							<td colspan="3" align="left">
							<textarea name="permit.prjSize" cols="100" rows="5"><s:property value="permit.prjSize"/></textarea>
							</td>
						</tr>
						<tr>
                       		<th>附件：</th>
							<td align="left" colspan="3">
							<s:iterator status="i" value="permit.list">
							<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a><br />
							</s:iterator>
							</td>
						</tr>
                </tbody>  
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
		        	<a href="#" onclick="querySingleProject()">
						<input type="image"src="<%=basepath %>/images/dtgc.jpg" />
		            </a>
		        </div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
