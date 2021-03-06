<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>施工许可申请 </title>
<script type="text/javascript">

	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	 			var check = /^([1-9]\d*|0)(\.\d*[1-9])?$/; 
	 			var contractMoney = $("#contractMoney").val();
	 			var prjName = $("#prjName").val();
	 			if (!check.exec(contractMoney)) 
	 			{
	 				alert("合同金额不能为负数!");
	 			}else if(prjName=="" || prjName==null)
 				{
 					alert("请选择项目名称!");
 				}else
	 			{
	 				form.submit();
	 			}
	        }    
	 	});
	});

	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/permitAction_goList.action";
		document.form1.submit();
	}
	
	//查询项目
	function queryPrjName()
	{
		var url="<%=basepath %>/queryPermPrjsAction_queryPage.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	
	//查询质量
	function queryQualityInfo()
	{
		var prjNum = $("#prjNum").val();
		var url1="<%=basepath %>/queryPermQualityAction_queryPage.action?condition.prjNum="+prjNum;
		var newWin1=window.showModalDialog(url1,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin1.open();
	}
	
	//查询安全
	function querySafetyInfo()
	{
		var prjNum = $("#prjNum").val();
		var url2="<%=basepath %>/queryPermSafetyAction_queryPage.action?condition.prjNum="+prjNum;
		var newWin2=window.showModalDialog(url2,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin2.open();
	}
	
	function checkDate()
	{
		var time1 = $("#time1").val();
		var time2 = $("#time2").val();
		var sArr = time1.split("-");
		var eArr = time2.split("-");
		var sRDate = new Date(sArr[0], sArr[1], sArr[2]);
		var eRDate = new Date(eArr[0], eArr[1], eArr[2]);
		var starttimes = sRDate.getTime();
		var lktimes = eRDate.getTime();
		if(starttimes>lktimes)
		{
			alert("合同竣工日期不能小于合同开工日期之前!");
			document.getElementById("time2").focus();
		}else
		{
			var result = (eRDate-sRDate)/(24*60*60*1000);
			$("#times").val(result);
		}
		
	}

	//查询施工图证书编号
	function queryPlanInfo()
	{
		var prjId = $("#prjId").val();
		var url2="<%=basepath %>/queryPlanAction_queryPage.action?condition.prjId="+prjId;
		var newWin2=window.showModalDialog(url2,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin2.open();
	}

</script>

</head>

<body>
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="<%=basepath %>/permitAction_add.action">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>施工许可申请</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td colspan="4" align="left">
							<input id="prjName" size="110" type="text" readonly name="permit.prjName" value="<s:property value="permit.prjName"/>" class="required"/>
							<a href="#" onclick="queryPrjName()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							
							<input id="prjId" type="hidden" readonly name="permit.prjId" value="<s:property value="permit.prjId"/>" class="required"/>
							</td>
						 </tr>
						 <tr>
                         	<th>项目编号：</th>
							<td colspan="4" align="left">
							<input id="prjNum" size="110" type="text" readonly name="permit.prjNum" value="<s:property value="permit.prjNum"/>" class="required"/>
							</td>
						</tr>
                         <tr>
                         	<th>质量编码：</th>
							<td colspan="4" align="left">
							<input id="qualityNum" size="110" type="text" name="permit.qualityNum" />
							<a href="#" onclick="queryQualityInfo()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							
							</td>
						</tr>
						 <tr>
                         	<th>安全编码：</th>
							<td colspan="4" align="left">
							<input id="safetyNum" size="110" type="text" name="permit.safetyNum" />
							<a href="#" onclick="querySafetyInfo()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							
							</td>
						</tr>
						<tr>
                         	<th>施工许可名称：</th>
							<td colspan="4" align="left">
							<input id="projectName" size="110" type="text" name="permit.projectName" value="<s:property value="permit.projectName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                         <tr>
                        	<th>标段名称：</th>
							<td align="left">
							<input id="sectionName" type="text" name="permit.sectionName" />
							</td>
							<th>中标通知书编号：</th>
							<td align="left">
							<input id="tenderNum" type="text" name="permit.tenderNum" />
							</td>
                         </tr>
                         <tr>
                         	<th>申请企业名称：</th>
							<td align="left">
							<input type="text" name="permit.applyCorpName" value="<s:property value="corpName"/>" class="required"/>
							</td>
							<th>申请企业代码：</th>
							<td align="left">
							<input type="text" name="permit.applyCorpCode" value="<s:property value="corpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="appDeptName" readonly type="hidden" name="permit.appDeptName" value="<s:property value="permit.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="permit.appDept" value="<s:property value="permit.appDept"/>"/>
							</td>
                         </tr>
                         
                         <tr>
                         	<th>施工图审查合格书编号：</th>
							<td colspan="4" align="left">
							<input id="censorNum" size="110" type="text" name="permit.censorNum" value="<s:property value="permit.censorNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<a href="#" onclick="queryPlanInfo()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							</td>
                         </tr>
                         
                         <tr>
                         	<th>建设用地规划许可证编号：</th>
							<td align="left">
							<input id="buldPlanNum" type="text" name="permit.buldPlanNum" value="<s:property value="permit.buldPlanNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>建设工程规划许可证编号：</th>
							<td align="left">
							<input id="projectPlanNum" type="text" name="permit.projectPlanNum" value="<s:property value="permit.projectPlanNum"/>" class="required"/>
							</td>
							
                         </tr>
                         <tr>
                         	<th>合同开工日期：</th>
							<td align="left">
							<input id="time1" value="<s:date name="permit.starDate" format="yyyy-MM-dd" />" type="text" name="permit.starDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
							</td>
							<th>合同竣工日期：</th>
							<td align="left">
							<input id="time2" onchange="checkDate()" value="<s:date name="permit.endDate" format="yyyy-MM-dd" />" type="text" name="permit.endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
							</td>
							
                         </tr>
                         <tr>
                         	<th>合同工期：</th>
							<td align="left">
							<input id="times" type="text" readonly name="permit.timeLimit" value="<s:property value="permit.timeLimit"/>" class="required"/><strong><font color="#FF0000">*</font></strong>(天)
							</td>
							
							<th>合同金额(万元)：</th>
							<td align="left">
							<input id="contractMoney" type="text" name="permit.contractMoney" value="<s:property value="permit.contractMoney"/>" class="required number"/>
							</td>
							
                         </tr>
                         <tr>
                         	<th>面积(平方米)：</th>
							<td align="left">
							<input id="area" type="text" name="permit.area" value="<s:property value="permit.area"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<!-- 
							<th>发证日期：</th>
							<td>
							<input id="time1" type="text" name="permit.issueCertDate" value="<s:date name="permit.issueCertDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong>
							</td>
							 -->
							<th>勘察单位名称：</th>
							<td align="left">
							<input id="econCorpName" type="text" name="permit.econCorpName" value="<s:property value="permit.econCorpName"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>勘察单位组织机构代码：</th>
							<td align="left">
							<input id="econCorpCode" type="text" name="permit.econCorpCode" value="<s:property value="permit.econCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>设计单位名称：</th>
							<td align="left">
							<input id="designCorpName" type="text" name="permit.designCorpName" value="<s:property value="permit.designCorpName"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>设计单位组织机构代码：</th>
							<td align="left">
							<input id="designCorpCode" type="text" name="permit.designCorpCode" value="<s:property value="permit.designCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>施工单位名称：</th>
							<td align="left">
							<input id="consCorpname" type="text" name="permit.consCorpname" value="<s:property value="permit.consCorpname"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         	<th>施工单位组织机构代码：</th>
							<td align="left">
							<input id="consCorpCode" type="text" name="permit.consCorpCode" value="<s:property value="permit.consCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>施工单位安全生产许可证编号：</th>
							<td align="left">
							<input id="safetyCerId" type="text" name="permit.safetyCerId" value="<s:property value="permit.safetyCerId"/>" class="required"/>
							</td>
                         </tr>

                         <tr>
                         	<th>监理单位名称：</th>
							<td align="left">
							<input id="superCorpName" type="text" name="permit.superCorpName" value="<s:property value="permit.superCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>监理单位组织机构代码：</th>
							<td align="left">
							<input id="superCorpCode" type="text" name="permit.superCorpCode" value="<s:property value="permit.superCorpCode"/>" class="required"/>
							</td>
							
                         </tr>
                         <tr>
                         	<th>项目经理姓名：</th>
							<td align="left">
							<input id="constructorName" type="text" name="permit.constructorName" value="<s:property value="permit.constructorName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>项目经理证件类型：</th>
							<td align="left">
							<select name="permit.cidCardTypeNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="cardTypeNums">
	          						<option value="<s:property value="code"/>"<s:if test='code==1'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
							
                         </tr>
                         <tr>
                         	<th>项目经理证件号码：</th>
							<td align="left">
							<input id="constructorIdCard" type="text" name="permit.constructorIdCard" value="<s:property value="permit.constructorIdCard"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>总监理工程师姓名：</th>
							<td align="left">
							<input id="supervisionName" type="text" name="permit.supervisionName" value="<s:property value="permit.supervisionName"/>" class="required"/>
							</td>
							
                         </tr>
                         <tr>
                         	<th>总监理工程师证件类型：</th>
							<td align="left">
							<select name="permit.sidCardTypeNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="cardTypeNums">
	          						<option value="<s:property value="code"/>"<s:if test='code==1'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>总监理工程师号码：</th>
							<td align="left">
							<input id="supervisionIdCard" type="text" name="permit.supervisionIdCard" value="<s:property value="permit.supervisionIdCard"/>" class="required"/>
							</td>
							
                         </tr>
                         <!-- 
                         <tr>
                         	<th>安全生产管理人员姓名：</th>
							<td>
							<input id="userName" type="text" name="permit.userName" value="<s:property value="permit.userName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>安全生产管理证件类型：</th>
							<td>
							<select name="permit.idCardTypeNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="cardTypeNums">
	          						<option value="<s:property value="code"/>"<s:if test='permit.idCardTypeNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
							
                         </tr>
                         <tr>
                         	<th>安全生产管理人员证件号：</th>
							<td>
							<input id="idCard" type="text" name="permit.idCard" value="<s:property value="permit.idCard"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>安全生产考核合格证书编号：</th>
							<td>
							<input id="certId" type="text" name="permit.certId" value="<s:property value="permit.certId"/>" class="required"/>
							</td>
							
                         </tr>
                          -->
                         <tr>
                         <!-- 
                         	<th>安全生产管理人员类型：</th>
							<td>
							<select name="permit.userType" class="required">
     							<option value="">请选择</option>
	      						<option value="1">主要负责人</option>
	          					<option value="2">项目负责人</option>
	          					<option value="3">安全员</option>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
							 -->
							<th>建设规模：</th>
							<td colspan="4" align="left">
							<textarea id="prjSize" name="permit.prjSize" cols="90" rows="5"><s:property value="permit.prjSize"/></textarea>
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
