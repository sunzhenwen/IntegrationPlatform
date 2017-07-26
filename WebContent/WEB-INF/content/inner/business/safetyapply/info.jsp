<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报安全勘察审核</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/safetyHistoryAction_goBack.action";
		document.form1.submit();
	}
	
	//查询单体工程信息
	function querySingleProject(){
		var prjNum = $("#prjNum").val();
		var prjId = $("#prjId").val();
		var url = "<%=basepath %>/innerSingleProjectAction_queryPage.action?prjNum="+prjNum+"&prjId="+prjId+"&condition.prjId="+prjId+"&condition.linkName=4&linkName=4";
		var newWin=window.showModalDialog(url,window,'dialogHeight:900px;dialogWidth:1300px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">安全勘察审核</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<div class="ry_content">

					<div class="ry_lbxx">
						<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
							<table class="" cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<th>项目名称：</th>
										<td><s:property value="safety.prjName" /> <input
											id="prjNum" type="hidden" readonly name="safety.prjNum"
											value="<s:property value="safety.prjNum"/>" class="required" />
											<input id="prjId" type="hidden" readonly name="safety.prjId"
											value="<s:property value="safety.prjId"/>" class="required" />
											<input type="hidden" id="safetyId" readonly name="safety.safetyId"
											value="<s:property value="safety.safetyId"/>"
											class="required" /> <input type="hidden"
											name="safety.createDate"
											value="<s:property value="safety.createDate"/>"> <input
											type="hidden" name="safety.appDept"
											value="<s:property value="safety.appDept"/>"> <input
											type="hidden" id="prjName"
											value="<s:property value="safety.prjName" />" /></td>
										<th>项目编号：</th>
										<td><s:property value="safety.prjNum" /></td>
									</tr>
									<tr>
										<th>申请企业名称：</th>
										<td><s:property value="safety.applyCorpName" /></td>
										<th>申请企业代码：</th>
										<td><s:property value="safety.applyCorpCode" /> <input
											id="appDeptName" readonly type="hidden"
											name="safety.appDeptName"
											value="<s:property value="safety.appDeptName"/>"
											class="required" /> <input id="appDept" type="hidden"
											name="safety.appDept"
											value="<s:property value="safety.appDept"/>" /></td>
									</tr>
									<tr>
										<td colspan="4" align="left"><strong>工程概况</strong></td>
									</tr>
									<tr>
										<th>工程名称</th>
										<td><s:property value="safety.projectName" /></td>
										<th>&nbsp;</th>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<th>工程地点</th>
										<td colspan="2" align="left">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<s:property value="safety.projectAddress" />
										</td>
										<td align="left">&nbsp;</td>
									</tr>
									<tr>
										<th>合同开工日期</th>
										<td><s:date name="safety.proStartDate"
												format="yyyy-MM-dd" /></td>
										<th>合同竣工日期</th>
										<td><s:date name="safety.proEndDate" format="yyyy-MM-dd" /></td>
									</tr>
									<tr>
										<th>工程类型</th>
										<td><s:property value="typeName" /></td>
										<th>安全生产标准化创建目标</th>
										<td><s:property value="safety.safetyTarget" /></td>
									</tr>
									<tr>
										<td align="left" colspan="4"><s:if
												test='safety.newlyBuild == "0"'>
												<input type="checkbox" name="safety.newlyBuild" value="0"
													checked />
           					 新建
                           </s:if> <s:else>
												<input type="checkbox" name="safety.newlyBuild" value="0" />
           					 新建
                           </s:else> <s:if test='safety.extend == "1"'>
												<input type="checkbox" name="safety.extend" value="1"
													checked />
                           	改建
                           </s:if> <s:else>
												<input type="checkbox" name="safety.extend" value="1" />
                           	改建
                           </s:else> <s:if test='safety.other == "2"'>
												<input type="checkbox" name="safety.other" value="2" checked />
                           	其它
                           </s:if> <s:else>
												<input type="checkbox" name="safety.other" value="2" />
                           	其它
                           </s:else></td>
									</tr>
									<tr>
										<th>勘察单位全称</th>
										<td><s:property value="safety.policingName" /></td>
										<th>勘察单位项目负责人</th>
										<td><s:property value="safety.policingStaff" /></td>
									</tr>
									<tr>
										<th>设计单位全称</th>
										<td><s:property value="safety.designName" /></td>
										<th>设计单位项目负责人</th>
										<td><s:property value="safety.designStaff" /></td>
									</tr>
									<tr>
										<th>建设单位全称</th>
										<td><s:property value="safety.buildingName" /> <input
											id="buildingName" type="hidden"
											value="<s:property value="safety.buildingName" />" /></td>
										<th>建设单位项目负责人</th>
										<td><s:property value="safety.buildingStaff" /></td>
									</tr>
									<tr>
										<th>建设单位联系电话</th>
										<td><s:property value="safety.buildingPhone" /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td align="left" colspan="4"><strong>监理单位</strong></td>
									</tr>
									<tr>
										<th>单位全称</th>
										<td><s:property value="safety.supervisionName" /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<th>项目总监姓名</th>
										<td><s:property value="safety.supervisionStaff" /></td>
										<th>项目总监注册证书号</th>
										<td><s:property value="safety.supervisionNum" /></td>
									</tr>
									<tr>
										<th>项目总监联系电话</th>
										<td><s:property value="safety.supervisionPhone" /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<th>安全监理姓名</th>
										<td><s:property value="safety.probationStaff" /></td>
										<th>安全监理注册证书号</th>
										<td><s:property value="safety.probationNum" /></td>
									</tr>
									<tr>
										<th>安全监理联系电话</th>
										<td><s:property value="safety.probationPhone" /></td>
										<th>安全监理证号</th>
										<td><s:property value="safety.probationSafeNum" /></td>
									</tr>
									<tr>
										<td align="left" colspan="4"><strong>施工总承包单位</strong></td>
									</tr>
									<tr>
										<th>单位全称</th>
										<td><s:property value="safety.contractName" /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<th>安全管理</th>
										<td><s:property value="safety.contractAdmin" /></td>
										<th>联系电话</th>
										<td><s:property value="safety.contractPhone" /></td>
									</tr>
									<tr>
										<!-- <th>负责人</th>
										<td><s:property value="safety.contractStaff" /></td>
										 -->
										<th>安全考核证号</th>
										<td><s:property value="safety.contractSafeNum" /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<th>项目负责人姓名</th>
										<td><s:property value="safety.contractProStaff" /></td>
										<th>项目负责人联系电话</th>
										<td><s:property value="safety.contractProStaffPhone" /></td>
									</tr>
									<tr>
										<th>项目负责人注册证号</th>
										<td><s:property value="safety.contractStaffRegNum" /></td>
										<th>项目负责人考核证号</th>
										<td><s:property value="safety.contractStaffNum" /></td>
									</tr>
									<tr>
										<td align="left" colspan="4"><strong>现场专职安全管理人员</strong>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									</tr>
									<s:iterator status="t" value="safety.csList">
										<tr>
											<td colspan="4">
												<table class="fulltable" width="100%" cellpadding="0"
													cellspacing="0">
													<tr>
														<td>姓名：<input type="text" disabled
															name="constructionSafety[<s:property value='#t.count'/>].safetyManageName"
															value="<s:property value="safetyManageName"/>" />
															&nbsp;&nbsp; 岗位证号：<input type="text" disabled
															name="constructionSafety[<s:property value='#t.count'/>].safetyManageNum"
															value="<s:property value="safetyManageNum"/>" />
															&nbsp;&nbsp; 安全考核证号：<input type="text" disabled
															name="constructionSafety[<s:property value='#t.count'/>].safetyManagecheckNum"
															value="<s:property value="safetyManagecheckNum"/>" />
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</s:iterator>

									<tr>
										<th height="78" colspan="4">&nbsp;</th>
									</tr>
									<!--<tr>
										<th>单位工程名称</th>
										<td><s:property value="safety.unitProject" /></td>
										<th>&nbsp;</th>
										<td>&nbsp;</td>
									</tr>
									  -->
									<tr>
										<td colspan="4" align="left"><strong>工程概况</strong></td>
									</tr>
									<tr>
										<th>建筑规模(建筑面积或体积)</th>
										<td><s:property value="safety.scale" /></td>
										<th>工程总造价</th>
										<td><s:property value="safety.cost" /></td>
									</tr>
									<tr>
										<th>结构/层次</th>
										<td><s:property value="safety.structure" /></td>
										<th>建筑总高度</th>
										<td><s:property value="safety.height" /></td>
									</tr>
									<tr>
										<td colspan="4" align="left"><strong>专业分包单位</strong>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									</tr>
									<s:iterator status="y" value="safety.majors">
										<tr>
											<td colspan="4">
												<table class="fulltable" width="100%" cellpadding="0"
													cellspacing="0">
													<tr>
														<td>单位名称</td>
														<td><input type="text" disabled
															name="majors[<s:property value='#y.count'/>].majorName"
															value="<s:property value="majorName"/>" /></td>
														<td>分包分部分项工程名称</td>
														<td><input type="text" disabled
															name="majors[<s:property value='#y.count'/>].majorProject"
															value="<s:property value="majorProject"/>" /></td>
													</tr>
													<tr>
														<td>安全生产许可证有效期</td>
														<td><input id="0" type="text" disabled
															name="majors[<s:property value='#y.count'/>].majorLicenseDate"
															value="<s:date name="majorLicenseDate" format="yyyy-MM-dd" />"
															onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /></td>
														<td>项目负责人</td>
														<td><input type="text" disabled
															name="majors[<s:property value='#y.count'/>].majorStaff"
															value="<s:property value="majorStaff"/>" /></td>
													</tr>
													<tr>
														<td>安全考核证号</td>
														<td><input type="text" disabled
															name="majors[<s:property value='#y.count'/>].majorCardNum"
															value="<s:property value="majorCardNum"/>" /></td>
														<td>联系电话</td>
														<td><input type="text" disabled
															name="majors[<s:property value='#y.count'/>].majorPhone"
															value="<s:property value="majorPhone"/>" /></td>
													</tr>
												</table>
											</td>
										</tr>
									</s:iterator>

									<tr>
										<td colspan="4" align="left"><strong>劳务分包单位</strong>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									</tr>
									<s:iterator status="i" value="safety.labours">
										<tr>
											<td colspan="4">
												<table class="fulltable" width="100%" cellpadding="0"
													cellspacing="0">
													<tr>
														<td>单位名称</td>
														<td><input type="text" disabled
															name="labours[<s:property value='#i.count'/>].labourName"
															value="<s:property value="labourName"/>" /></td>
														<td>安全生产许可证有效期</td>
														<td><input id="0" type="text" disabled
															name="labours[<s:property value='#i.count'/>].labourLicenseDate"
															value="<s:date name="labourLicenseDate" format="yyyy-MM-dd" />"
															onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /></td>
													</tr>
													<tr>
														<td>现场负责人</td>
														<td><input type="text" disabled
															name="labours[<s:property value='#i.count'/>].labourStaff"
															value="<s:property value="labourStaff"/>" /></td>
														<td>联系电话</td>
														<td><input type="text" disabled
															name="labours[<s:property value='#i.count'/>].labourPhone"
															value="<s:property value="labourPhone"/>" /></td>
													</tr>
												</table>
											</td>
										</tr>
									</s:iterator>
									<tr>
										<td colspan="4" align="left"><center><strong>
										<a href="#" onclick="querySingleProject()">
										单体工程(点击查看)
										</a></strong></center>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									</tr>
									<tr style="height: 60px; border: 3">
										<th>安全监督登记编号</th>
										<td><s:property value="safety.oversightNum" />
							<input type="hidden" id="oversightNum" value="<s:property value="safety.oversightNum"/>">										
										</td>
										<th>审核意见</th>
										<td colspan="3" align="middle"><textarea id="appId"
												name="safety.appOpinion" class="required"><s:property
													value="safety.appOpinion" /></textarea></td>
									</tr>
								</tbody>
							</table>
							<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
								<table class="sp_mtable" style="border-collapse: collapse;"
									cellpadding="0" cellspacing="0">

								</table>
							</div>
							<div class="sp_bton">
								<a href="#"><span class="sp_last" onclick="prn_preview()">打印</span></a>
								<a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
							</div>
			</form>
		</div>
	</div>


	<div id="table01" style="display: none">
		<p align="center">安全监督登记表</p>
		<p align="right">编号:<s:property value="safety.oversightNum" /></p>
		<table border="1" width="100%"
			style="border: solid 1px black; border-collapse: collapse">
			<tr>
				<td width="5%" rowspan="5">
					<p align="center">工</p>
					<p align="center">程</p>
					<p align="center">概</p>
					<p align="center">况</p>
				</td>
				<td width="20%" colspan="2">
					<p align="center">工程名称</p>
				</td>
				<td width="75%" colspan="5"><p align="center">
						<s:property value="safety.prjName" />
					</p></td>
			</tr>
			<tr>
				<td width="20%" colspan="2"><p align="center">工程地点</p></td>
				<td width="75%" colspan="5"><p align="center">
						<s:property value="safety.projectAddress" />
					</p></td>
			</tr>
			<tr>
				<td width="20%" colspan="2"><p align="center">合同开工日期</p></td>
				<td width="35%" colspan="2"><p align="center">
						<s:date name="safety.proStartDate" format="yyyy-MM-dd" />
					</p></td>
				<td width="14%"><p align="center">合同竣工日期</p></td>
				<td width="26%" colspan="2"><p align="center">
						<s:date name="safety.proEndDate" format="yyyy-MM-dd" />
					</p></td>
			</tr>
			<tr>
				<td width="20%" colspan="2"><p align="center">工程类型</p></td>
				<td width="35%" colspan="2"><p align="center">
						<s:property value="typeName" />
					</p></td>
				<td width="14%"><p align="center">安全生产标准化创建目标</p></td>
				<td width="26%" colspan="2"><p>
						<s:property value="safety.safetyTarget" />
					</p></td>
			</tr>
			<tr>
				<td width="95%" colspan="7"><s:if
						test='safety.newlyBuild == "0"'>
						<input type="checkbox" name="safety.newlyBuild" value="0" checked />
           					 新建
                           </s:if> <s:else>
						<input type="checkbox" name="safety.newlyBuild" value="0" />
           					 新建
                           </s:else> <s:if test='safety.extend == "1"'>
						<input type="checkbox" name="safety.extend" value="1" checked />
                           	改建
                           </s:if> <s:else>
						<input type="checkbox" name="safety.extend" value="1" />改建
                           </s:else> <s:if test='safety.other == "2"'>
						<input type="checkbox" name="safety.other" value="2" checked />其它
                           </s:if> <s:else>
						<input type="checkbox" name="safety.other" value="2" />其它
                           </s:else></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">勘察单位</p></td>
				<td width="20%" colspan="2"><p align="center">单位全称</p></td>
				<td width="35%" colspan="2"><p align="center">
						<s:property value="safety.policingName" />
					</p></td>
				<td width="14%"><p align="center">项目负责人</p></td>
				<td width="26%" colspan="2"><p align="center">
						<s:property value="safety.policingStaff" />
					</p></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">设计单位</p></td>
				<td width="20%" colspan="2"><p align="center">单位全称</p></td>
				<td width="35%" colspan="2"><p align="center">
						<s:property value="safety.designName" />
					</p></td>
				<td width="14%"><p align="center">项目负责人</p></td>
				<td width="26%" colspan="2"><p align="center">
						<s:property value="safety.designStaff" />
					</p></td>
			</tr>
			<tr>
				<td width="5%" rowspan="2"><p align="center">建设单位</p></td>
				<td width="20%" colspan="2"><p align="center">单位全称</p></td>
				<td width="75%" colspan="5"><p align="center">
						<s:property value="safety.buildingName" />
					</p></td>
			</tr>
			<tr>
				<td width="20%" colspan="2"><p align="center">项目负责人</p></td>
				<td width="35%" colspan="2"><p align="center">
						<s:property value="safety.buildingStaff" />
					</p></td>
				<td width="14%"><p align="center">联系电话</p></td>
				<td width="26%" colspan="2"><p align="center">
						<s:property value="safety.buildingPhone" />
					</p></td>
			</tr>
			<tr>
				<td width="5%" rowspan="5"><p align="center">监理单位</p></td>
				<td width="20%" colspan="2"><p align="center">单位全称</p></td>
				<td width="75%" colspan="5"><p align="center">
						<s:property value="safety.supervisionName" />
					</p></td>
			</tr>
			<tr>
				<td width="5%" rowspan="2"><p align="center">项目总监</p></td>
				<td width="15%"><p align="center">姓名</p></td>
				<td width="35%" colspan="2"><p align="center">
						<s:property value="safety.supervisionStaff" />
					</p></td>
				<td width="14%" rowspan="2"><p align="center">联系电话</p></td>
				<td width="26%" colspan="2" rowspan="2"><p align="center">
						<s:property value="safety.supervisionPhone" />
					</p></td>
			</tr>
			<tr>
				<td width="15%"><p align="center">注册证书号</p></td>
				<td width="35%" colspan="2"><p align="center">
						<s:property value="safety.supervisionNum" />
					</p></td>
			</tr>
			<tr>
				<td width="5%" rowspan="2"><p align="center">安全监理</p></td>
				<td width="15%"><p align="center">姓名</p></td>
				<td width="35%" colspan="2"><p align="center">
						<s:property value="safety.probationStaff" />
					</p></td>
				<td width="14%"><p align="center">联系电话</p></td>
				<td width="26%" colspan="2"><p align="center">
						<s:property value="safety.probationPhone" />
					</p></td>
			</tr>
			<tr>
				<td width="15%"><p align="center">注册证书号</p></td>
				<td width="35%" colspan="2"><p align="center">
						<s:property value="safety.probationNum" />
					</p></td>
				<td width="14%"><p align="center">安全监理证号</p></td>
				<td width="26%" colspan="2"><p align="center">
						<s:property value="safety.probationSafeNum" />
					</p></td>
			</tr>
			<tr>
				<td width="5%" rowspan="6"><p align="center">施工总承包单位</p></td>
				<td width="20%" colspan="2"><p align="center">单位全称</p></td>
				<td width="75%" colspan="5"><p align="center">
						<s:property value="safety.contractName" />
					</p></td>
			</tr>
			<tr>
				<td width="20%" colspan="2" rowspan="2">
					<p align="center">公司安全管理负责人</p>
				</td>
				<td width="35%" colspan="2" rowspan="2"><p align="center">
						<s:property value="safety.contractAdmin" />
					</p></td>
				<td width="14%"><p align="center">联系电话</p></td>
				<td width="26%" colspan="2"><p align="center">
						<s:property value="safety.contractPhone" />
					</p></td>
			</tr>
			<tr>
				<td width="14%"><p align="center">安全考核证号</p></td>
				<td width="26%" colspan="2"><p align="center">
						<s:property value="safety.contractSafeNum" />
					</p></td>
			</tr>
			<tr>
				<td width="5%" rowspan="2"><p align="center">项目负责人</p></td>
				<td width="15%"><p align="center">姓 名</p></td>
				<td width="35%" colspan="2"><p align="center">
						<s:property value="safety.contractProStaff" />
					</p></td>
				<td width="14%"><p align="center">联系电话</p></td>
				<td width="26%" colspan="2"><p align="center">
						<s:property value="safety.contractProStaffPhone" />
					</p></td>
			</tr>
			<tr>
				<td width="15%"><p align="center">注册证号</p></td>
				<td width="35%" colspan="2"><p align="center">
						<s:property value="safety.contractStaffRegNum" />
					</p></td>
				<td width="14%"><p align="center">安全考核证号</p></td>
				<td width="26%" colspan="2"><p align="center">
						<s:property value="safety.contractStaffNum" />
					</p></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">现场专职安全管理人员</p></td>

				<td colspan="6" width="90%">
					<table border="1" width="100%"
						style="border: solid 1px black; border-collapse: collapse">
						<s:iterator status="t" value="safety.csList">
							<tr>
								<td width="15%"><p align="center">姓 名</p></td>
								<td width="20%"><p align="center">
										<s:property value="safetyManageName" />
									</p></td>
								<td width="15%"><p align="center">岗位证号</p></td>
								<td width="14%"><p align="center">
										<s:property value="safetyManageNum" />
									</p></td>
								<td width="13%"><p align="center">安全考核证号</p></td>
								<td width="13%"><p align="center">
										<s:property value="safetyManagecheckNum" />
									</p></td>
							</tr>
						</s:iterator>
					</table>
				</td>
			</tr>
		</table>
	</div>

	<div id="table02" style="display: none">
		<p align="center">安全监督登记表（单位工程分表）</p>
		<p align="right">编号:<s:property value="safety.oversightNum" /></p>
		<table border="1" width="100%"
			style="border: solid 1px black; border-collapse: collapse">

			<tr>
				<td width="10%"><p align="center">单位工程名称</p></td>
				<td width="90%" colspan="6"><p align="center">
						<s:property value="safety.unitProject" />
					</p></td>
			</tr>
			<tr>
				<td width="10%" rowspan="2"><p align="center">工程概况</p></td>
				<td width="15%"><p align="center">建筑规模（建筑面积或体量）</p></td>
				<td width="25%"><p align="center">
						<s:property value="safety.scale" />
					</p></td>
				<td width="15%"><p align="center">工程总造价</p></td>
				<td width="35%" colspan="3"><p align="center">
						<s:property value="safety.cost" />
						万元
					</p></td>
			</tr>
			<tr>
				<td width="15%"><p align="center">结构 / 层次</p></td>
				<td width="25%"><p align="center">
						<s:property value="safety.structure" />
					</p></td>
				<td width="15%"><p align="center">建筑总高度</p></td>
				<td width="35%" colspan="3"><p align="center">
						<s:property value="safety.height" />
					</p></td>
			</tr>
			<tr>
				<td width="10%"><p align="center">专业分包单位</p></td>

				<td width="90%" colspan="6">
					<table border="1" width="100%"
						style="border: solid 1px black; border-collapse: collapse">
						<s:iterator status="y" value="safety.majors">
							<tr>
								<td width="15%"><p align="center">
										单位名称
										<s:property value='#y.count' />
									</p></td>
								<td width="25%"><p align="center">
										<s:property value="majorName" />
									</p></td>
								<td width="15%"><p align="center">分包分部分项工程名称</p></td>
								<td width="35%" colspan="3"><p align="center">
										<s:property value="majorProject" />
									</p></td>
							</tr>
							<tr>
								<td width="15%" rowspan="2">
									<p align="center">安全生产许可证有效期</p>
								</td>
								<td width="25%" rowspan="2"><p align="center">
										<s:date name="majorLicenseDate" format="yyyy-MM-dd" />
									</p></td>
								<td width="15%"><p align="center">项目负责人</p></td>
								<td width="10%"><p align="center">
										<s:property value="majorStaff" />
									</p></td>
								<td width="10%"><p align="center">安全考核证号</p></td>
								<td width="15%"><p align="center">
										<s:property value="majorCardNum" />
									</p></td>
							</tr>

							<tr>
								<td width="15%"><p align="center">联系电话</p></td>
								<td width="35%" colspan="3"><p align="center">
										<s:property value="majorPhone" />
									</p></td>
							</tr>

						</s:iterator>

					</table>
				</td>
			</tr>
			<tr>
				<td width="10%"><p align="center">劳务分包单位</p></td>
				<td width="90%" colspan="6">
					<table border="1" width="100%"
						style="border: solid 1px black; border-collapse: collapse">

						<s:iterator status="i" value="safety.labours">
							<tr>
								<td width="15%"><p align="center">
										单位名称
										<s:property value='#i.count' />
									</p></td>
								<td width="25"><p align="center">
										<s:property value="labourName" />
									</p></td>
								<td width="15%"><p align="center">安全生产许可证有效期</p></td>
								<td width="35%" colspan="3"><p align="center">
										<s:date name="labourLicenseDate" format="yyyy-MM-dd" />
									</p></td>
							</tr>
							<tr>
								<td width="15%"><p align="center">现场负责人</p></td>
								<td width="25%"><p align="center">
										<s:property value="labourStaff" />
									</p></td>
								<td width="15%"><p align="center">联系电话</p></td>
								<td width="35%" colspan="3"><p align="center">
										<s:property value="labourPhone" />
									</p></td>
							</tr>
						</s:iterator>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<script language="javascript" type="text/javascript">
		var LODOP; //声明为全局变量 

		function prn_preview() {
			CreatePrintPageA();
			LODOP.NewPage();
			CreatePrintPageB();
			LODOP.NewPage();
			CreatePrintPageC();
			//LODOP.SET_PRINT_PAGESIZE(0,"210mm","297mm","");
			//LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
			//LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
			LODOP.PREVIEW();
		};
		function CreatePrintPageA() {
			LODOP = getLodop();
			LODOP.PRINT_INIT("安全监督登记");
			var strHTML = "<body style='margin:0;background-color: white'>"
					+ document.getElementById("table01").innerHTML + "</body>";
			LODOP.ADD_PRINT_HTM("10mm", "10mm", "RightMargin:10mm",
					"BottomMargin:10mm", strHTML);
		};

		function CreatePrintPageB() {
			var strHTML = "<body style='margin:0;background-color: white'>"
					+ document.getElementById("table02").innerHTML + "</body>";
			LODOP.ADD_PRINT_HTM("10mm", "10mm", "RightMargin:10mm",
					"BottomMargin:10mm", strHTML);
		};

		function CreatePrintPageC() {
			//LODOP=getLodop();  
			//LODOP.PRINT_INIT("施工安全监督告知书");
			//LODOP.SET_PRINT_PAGESIZE(0, 2100, 2970, "");
			//LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW", true);

			LODOP.ADD_PRINT_TEXT(123, 240, 322, 40, "施工安全监督告知书");
			LODOP.SET_PRINT_STYLEA(0, "FontName", "华文中宋");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 22);
			//LODOP.SET_PRINT_STYLEA(0,"Bold",1);
			//LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",5);
			LODOP.ADD_PRINT_TEXT(172, 282, 199, 34, "安告字[     ]号");
			LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
			LODOP
					.ADD_PRINT_TEXT(
							274,
							71,
							654,
							289,
							document.getElementById("buildingName").value
									+ "：\n"
									+ "    你单位提交的"
									+ document.getElementById("prjName").value
									+ "项目安全监督申请及相关资料已收到，经查验，所提交资料符合相关规定。\n"
									+ "    我_____________将在你单位取得施工许可证后组织召开建设、勘察、设计、施工、监理等单位及相关人员参加的施工安全监督告知会议，并确定对该项目开展施工安全监督工作起始时间。\n");
			LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
			LODOP.SET_PRINT_STYLEA(0, "LineSpacing", 10);

			LODOP.ADD_PRINT_TEXT(638, 86, 251, 80, "经办人：\n" + "联系电话：");
			LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
			LODOP.SET_PRINT_STYLEA(0, "LineSpacing", 8);

			LODOP.ADD_PRINT_TEXT(659, 430, 265, 81, "（监督机构章）\n"
					+ "     年   月   日");
			LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
			LODOP.SET_PRINT_STYLEA(0, "LineSpacing", 10);

			//LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",5);

			LODOP.ADD_PRINT_TEXT(828, 80, 239, 88, "签收人：\n" + "联系电话：");
			LODOP.SET_PRINT_STYLEA(0, "LineSpacing", 10);
			LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);

			LODOP.ADD_PRINT_TEXT(826, 480, 228, 54, "年   月   日");
			LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
		};
	</script>
</body>
</html>