<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业安全监督申请 </title>
<script type="text/javascript">

	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/querySafetyAction_goList.action";
		document.form1.submit();
	}

	//查询单体工程信息
	function querySingleProject()
	{ 
		var prjNum = $("#prjNum").val();
		var prjId = $("#prjId").val();
		var url = "<%=basepath %>/querySingleProjectAction_queryPage.action?prjNum="+prjNum+"&prjId="+prjId+"&condition.prjId="+prjId+"&condition.linkName=4&linkName=4";
		var newWin=window.showModalDialog(url,window,'dialogHeight:900px;dialogWidth:1300px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
</script>

</head>

<body>

	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>企业安全监督申请</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td align="left">
							<input id="prjName" type="text" readonly name="safety.prjName" value="<s:property value="safety.prjName"/>" class="required"/>
							<input id="prjId" type="hidden" readonly name="safety.prjId" value="<s:property value="safety.prjId"/>" class="required"/>
							<input id="safetyId" type="hidden" readonly name="safety.safetyId" value="<s:property value="safety.safetyId"/>" class="required"/>
							</td>
							<th>项目编号：</th>
							<td align="left">
							<input id="prjNum" type="text" readonly name="safety.prjNum" value="<s:property value="safety.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>申请企业名称：</th>
							<td align="left">
							<input type="text" readonly name="safety.applyCorpName" value="<s:property value="safety.applyCorpName"/>" class="required"/>
							</td>
							<th>申请企业代码：</th>
							<td align="left">
							<input type="text" readonly name="safety.applyCorpCode" value="<s:property value="safety.applyCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="appDeptName" readonly type="hidden" name="safety.appDeptName" value="<s:property value="safety.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="safety.appDept" value="<s:property value="safety.appDept"/>"/>
							</td>
                         </tr>
                         <tr>
							<th>安全监督编号：</th>
							<td colspan="3" align="left">
								<input type="text" size="110" readonly name="safety.safetyNum" value="<s:property value="safety.safetyNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                         <tr>
                           <td colspan="4" align="left"><strong>工程概况</strong></td>
                         </tr>
                         <tr>
                         	<th>编号</th>
                           <td align="left"><input type="text" name="safety.oversightNum" value="<s:property value="safety.oversightNum"/>"/></td>
                           <th>工程名称</th>
                           <td align="left"><input type="text" name="safety.projectName" value="<s:property value="safety.projectName"/>"/></td>
                           
                         </tr>
                         <tr>
                           <th>工程地点</th>
                           <td colspan="2" align="left">
                            <input name="safety.projectAddress" type="text" value="<s:property value="safety.projectAddress"/>" size="60"/></td>
                           <td>&nbsp;</td>
                         </tr>
                         <tr>
                           <th>合同开工日期</th>
                           <td align="left"><input id="time1" type="text" name="safety.proStartDate" value="<s:date name="safety.proStartDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /></td>
                           <th>合同竣工日期</th>
                           <td align="left"><input id="time2" type="text" name="safety.proEndDate" value="<s:date name="safety.proEndDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /></td>
                         </tr>
                         <tr>
                           <th>工程类型</th>
                           <td align="left">
                           <select name="safety.projectType" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="projectTypes">
	          						<option value="<s:property value="code"/>"<s:if test='safety.projectType==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select>
                           </td>
                           <th>安全生产标准化创建目标</th>
                           <td align="left"><input type="text" name="safety.safetyTarget" value="<s:property value="safety.safetyTarget"/>"/></td>
                         </tr>
                         <tr>
                           <td align="left" colspan="4">
                           
                           <s:if test='safety.newlyBuild == "0"'>
                           <input type="checkbox" name="safety.newlyBuild" value="0" checked  />
           					 新建
                           </s:if>
                           <s:else>
                           <input type="checkbox" name="safety.newlyBuild" value="0"  />
           					 新建
                           </s:else>
                           <s:if test='safety.extend == "1"'>
                           <input type="checkbox" name="safety.extend" value="1" checked />
                           	改建
                           </s:if>
                           <s:else>
                           <input type="checkbox" name="safety.extend" value="1"  />
                           	改建
                           </s:else>
                           <s:if test='safety.other == "2"'>
                           <input type="checkbox" name="safety.other" value="2" checked />
                           	其它
                           </s:if>
                           <s:else>
                           <input type="checkbox" name="safety.other" value="2"  />
                           	其它
                           </s:else>
                           
                           
                           </td>
                         </tr>
                         <tr>
                           <th>勘察单位全称</th>
                           <td align="left"><input type="text" name="safety.policingName" value="<s:property value="safety.policingName"/>"/></td>
                           <th>勘察单位项目负责人</th>
                           <td align="left"><input type="text" name="safety.policingStaff" value="<s:property value="safety.policingStaff"/>"/></td>
                         </tr>
                         <tr>
                           <th>设计单位全称</th>
                           <td align="left"><input type="text" name="safety.designName" value="<s:property value="safety.designName"/>"/></td>
                           <th>设计单位项目负责人</th>
                           <td align="left"><input type="text" name="safety.designStaff" value="<s:property value="safety.designStaff"/>"/></td>
                         </tr>
                         <tr>
                           <th>建设单位全称</th>
                           <td align="left"><input type="text" name="safety.buildingName" value="<s:property value="safety.buildingName"/>"/></td>
                           <th>建设单位项目负责人</th>
                           <td align="left"><input type="text" name="safety.buildingStaff" value="<s:property value="safety.buildingStaff"/>"/></td>
                         </tr>
                         <tr>
                           <th>建设单位联系电话</th>
                           <td align="left"><input type="text" name="safety.buildingPhone" value="<s:property value="safety.buildingPhone"/>"/></td>
                           <td>&nbsp;</td>
                           <td>&nbsp;</td>
                         </tr>
                         <tr>
                           <td align="left" colspan="4"><strong>监理单位</strong></td>
                         </tr>
                         <tr>
                           <th>单位全称</th>
                           <td align="left"><input type="text" name="safety.supervisionName" value="<s:property value="safety.supervisionName"/>"/></td>
                           <td>&nbsp;</td>
                           <td>&nbsp;</td>
                         </tr>
                         <tr>
                           <th>项目总监姓名</th>
                           <td align="left"><input type="text" name="safety.supervisionStaff" value="<s:property value="safety.supervisionStaff"/>"/></td>
                           <th>项目总监注册证书号</th>
                           <td align="left"><input type="text" name="safety.supervisionNum" value="<s:property value="safety.supervisionNum"/>"/></td>
                         </tr>
                         <tr>
                           <th>项目总监联系电话</th>
                           <td align="left"><input type="text" name="safety.supervisionPhone" value="<s:property value="safety.supervisionPhone"/>"/></td>
                           <td>&nbsp;</td>
                           <td>&nbsp;</td>
                         </tr>
                         <tr>
                           <th>安全监理姓名</th>
                           <td align="left"><input type="text" name="safety.probationStaff" value="<s:property value="safety.probationStaff"/>"/></td>
                           <th>安全监理注册证书号</th>
                           <td align="left"><input type="text" name="safety.probationNum" value="<s:property value="safety.probationNum"/>"/></td>
                         </tr>
                         <tr>
                           <th>安全监理联系电话</th>
                           <td align="left"><input type="text" name="safety.probationPhone" value="<s:property value="safety.probationPhone"/>"/></td>
                           <th>安全监理证号</th>
                           <td align="left"><input type="text" name="safety.probationSafeNum" value="<s:property value="safety.probationSafeNum"/>"/></td>
                         </tr>
                         <tr>
                           <td align="left" colspan="4"><strong>施工总承包单位</strong></td>
                         </tr>
                         <tr>
                           <th>单位全称</th>
                           <td align="left"><input type="text" name="safety.contractName" value="<s:property value="safety.contractName"/>"/></td>
                           <td>&nbsp;</td>
                           <td>&nbsp;</td>
                         </tr>
                         <tr>
                           <th>安全管理</th>
                           <td align="left"><input type="text" name="safety.contractAdmin" value="<s:property value="safety.contractAdmin"/>"/></td>
                           <th>联系电话</th>
                           <td align="left"><input type="text" name="safety.contractPhone" value="<s:property value="safety.contractPhone"/>"/></td>
                         </tr>
                         <tr>
                           <!--
                           <th>负责人</th>
                           <td><input type="text" name="safety.contractStaff" value="<s:property value="safety.contractStaff"/>"/></td>
                             -->
                           <th>安全考核证号</th>
                           <td align="left"><input type="text" name="safety.contractSafeNum" value="<s:property value="safety.contractSafeNum"/>"/></td>
                           <td>&nbsp;</td>
                           <td>&nbsp;</td>
                         </tr>
                         <tr>
                           <th>项目负责人姓名</th>
                           <td align="left"><input type="text" name="safety.contractProStaff" value="<s:property value="safety.contractProStaff"/>"/></td>
                           <th>项目负责人联系电话</th>
                           <td align="left"><input type="text" name="safety.contractProStaffPhone" value="<s:property value="safety.contractProStaffPhone"/>"/></td>
                         </tr>
                         <tr>
                           <th>项目负责人注册证号</th>
                           <td align="left"><input type="text" name="safety.contractStaffRegNum" value="<s:property value="safety.contractStaffRegNum"/>"/></td>
                           <th>项目负责人考核证号</th>
                           <td align="left"><input type="text" name="safety.contractStaffNum" value="<s:property value="safety.contractStaffNum"/>"/></td>
                         </tr>
                         <tr>
                           <td align="left" colspan="4" >
                           	现场专职安全管理人员
                           </td>
                         </tr>
                         
       
                         <s:iterator status="t" value="safety.csList" > 
                         <tr>
                           <td colspan="4">
                           <table class="fulltable" width="100%" cellpadding="0" cellspacing="0">
                             <tr>
                               <td >
                               	姓名：<input type="text" name="constructionSafety[<s:property value='#t.count'/>].safetyManageName" value="<s:property value="safetyManageName"/>"/>
                               	&nbsp;&nbsp;
                               	岗位证号：<input type="text" name="constructionSafety[<s:property value='#t.count'/>].safetyManageNum" value="<s:property value="safetyManageNum"/>"/>
                               	&nbsp;&nbsp;
                               	安全考核证号：<input type="text" name="constructionSafety[<s:property value='#t.count'/>].safetyManagecheckNum" value="<s:property value="safetyManagecheckNum"/>"/>
                               </td>
                             </tr>
                           </table></td>
                         </tr>
                         </s:iterator>
         
<!--                     <tr>
                           <th height="78" colspan="4">&nbsp;</th>
                         </tr>
                         <tr>
                           <th>单位工程名称</th>
                           <td><input type="text" name="safety.unitProject" value="<s:property value="safety.unitProject"/>"/></td>
                           <th>&nbsp;</th>
                           <td>&nbsp;</td>
                         </tr>
-->
                         <tr>
                           <td colspan="4" align="left"><strong>工程概况</strong></td>
                         </tr>
                         <tr>
                           <th>建筑规模(建筑面积或体积)</th>
                           <td align="left"><input type="text" name="safety.scale" value="<s:property value="safety.scale"/>"/></td>
                           <th>工程总造价</th>
                           <td align="left"><input type="text" name="safety.cost" value="<s:property value="safety.cost"/>"/></td>
                         </tr>
                         <tr>
                           <th>结构/层次</th>
                           <td align="left"><input type="text" name="safety.structure" value="<s:property value="safety.structure"/>"/></td>
                           <th>建筑总高度</th>
                           <td align="left"><input type="text" name="safety.height" value="<s:property value="safety.height"/>"/></td>
                         </tr>
                         <tr>
                           <td colspan="4" align="left">
                           <strong>专业分包单位</strong>
                           </td>
                         </tr>
                         
                         <s:iterator status="y" value="safety.majors" > 
                         <tr>
                           <td colspan="4" align="left">
                           <table class="fulltable" width="100%" cellpadding="0" cellspacing="0">
                             <tr>
                           <td>单位名称</td>
                           <td align="left"><input type="text" name="majors[<s:property value='#y.count'/>].majorName" value="<s:property value="majorName"/>"/></td>
                           <td>分包分部分项工程名称</td>
                           <td align="left"><input type="text" name="majors[<s:property value='#y.count'/>].majorProject" value="<s:property value="majorProject"/>"/></td>
                         </tr>
                         <tr>
                           <td>安全生产许可证有效期</td>
                           <td align="left"><input id="0" type="text" name="majors[<s:property value='#y.count'/>].majorLicenseDate" value="<s:date name="majorLicenseDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /></td>
                           <td>项目负责人</td>
                           <td align="left"><input type="text" name="majors[<s:property value='#y.count'/>].majorStaff" value="<s:property value="majorStaff"/>"/></td>
                         </tr>
                         <tr>
                           <td>安全考核证号</td>
                           <td align="left"><input type="text" name="majors[<s:property value='#y.count'/>].majorCardNum" value="<s:property value="majorCardNum"/>"/></td>
                           <td>联系电话</td>
                           <td align="left"><input type="text" name="majors[<s:property value='#y.count'/>].majorPhone" value="<s:property value="majorPhone"/>"/></td>
                         </tr>
                           </table>
                           </td>
                         </tr>
                         </s:iterator>

                         <tr>
                           <td colspan="4" align="left">
                           <strong>劳务分包单位</strong>
                           </td>
                         </tr>
                         
                         <s:iterator status="i" value="safety.labours" > 
                         <tr>
                           <td colspan="4">
                           <table class="fulltable" width="100%" cellpadding="0" cellspacing="0">
                           <tr>
                           <td>单位名称</td>
                           <td align="left"><input type="text" name="labours[<s:property value='#i.count'/>].labourName" value="<s:property value="labourName"/>"/></td>
                           <td>安全生产许可证有效期</td>
                           <td align="left"><input id="0" type="text" name="labours[<s:property value='#i.count'/>].labourLicenseDate" value="<s:date name="labourLicenseDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /></td>
                         </tr>
                         <tr>
                           <td>现场负责人</td>
                           <td align="left"><input type="text" name="labours[<s:property value='#i.count'/>].labourStaff" value="<s:property value="labourStaff"/>"/></td>
                           <td>联系电话</td>
                           <td align="left"><input type="text" name="labours[<s:property value='#i.count'/>].labourPhone" value="<s:property value="labourPhone"/>"/></td>
                         </tr>
                           </table>
                           </td>
                         </tr>
                         
	                 	</s:iterator>
	                 	<tr>
                       		<th>附件：</th>
							<td align="left" colspan="3">
							<s:iterator status="i" value="safety.list">
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
