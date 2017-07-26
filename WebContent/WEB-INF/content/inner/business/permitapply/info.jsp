<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报施工许可审核</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/promiseHistoryAction_goBack.action";
		document.form1.submit();
	}
	
	//查询单位工程信息
	function querySingleProject(){
		var prjNum = $("#prjNum").val();
		var prjId = $("#prjId").val();
		var url = "<%=basepath %>/innerSingleProjectAction_queryPage.action?prjNum="+prjNum+"&prjId="+prjId+"&condition.prjId="+prjId+"&condition.linkName=5&linkName=5";
		var newWin=window.showModalDialog(url,window,'dialogHeight:900px;dialogWidth:1300px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">施工许可审核历史查询</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>工程名称：</td>
						<td colspan="3" align="center" valign="middle"><div align="center"><s:property value="permit.projectName" /></div></td>
					</tr>

					<tr>
						<td>项目名称：</td>
						<td><s:property value="permit.prjName" /> <input
							type="hidden" id="prjName"
							value="<s:property value="permit.prjName"/>"> <input
							type="hidden" id="prjNum" name="permit.prjNum"
							value="<s:property value="permit.prjNum"/>"> <input
							type="hidden" id="permitId" name="permit.permitId"
							value="<s:property value="permit.permitId"/>"><input
							type="hidden" name="permit.createDate"
							value="<s:property value="permit.createDate"/>"> <input
							type="hidden" name="permit.appDept"
							value="<s:property value="permit.appDept"/>">
							<input type="hidden" id="prjId" name="permit.prjId"
							value="<s:property value="permit.prjId"/>"></td>
						<td>项目编号：</td>
						<td><s:property value="permit.prjNum" /> 
						<input type="hidden" id="address" value="<s:property value="projectConstruction.address" />" /> 
						<input type="hidden" id="beginDate" value="<s:date name="projectConstruction.beginDate" format="yyyy-MM-dd"/>" />
						<input type="hidden" id="endDate" value="<s:date name="projectConstruction.endDate" format="yyyy-MM-dd"/>" /> 
						<input type="hidden" id="projectName" value="<s:property value="permit.projectName" />" /></td>
					</tr>

					<tr>
						<td>施工许可证编号：</td>
						<td><s:property value="permit.builderLicenceNum" /> <input
							type="hidden" id="builderLicenceNum"
							value="<s:property value="permit.builderLicenceNum" />" /></td>
						<td>建设用地规划许可证编号：</td>
						<td><s:property value="permit.buldPlanNum" /></td>
					</tr>
					<tr>
						<td>建设工程规划许可证编号：</td>
						<td><s:property value="permit.projectPlanNum" /></td>
						<td>施工图审查合格书编号：</td>
						<td><s:property value="permit.censorNum" /></td>
					</tr>
					<tr>
						<td>合同金额(万元)：</td>
						<td><s:property value="permit.contractMoney" /> <input
							type="hidden" id="contractMoney"
							value="<s:property value="permit.contractMoney" />" /></td>
						<td>面积(平方米)：</td>
						<td><s:property value="permit.area" /></td>
					</tr>
					<tr style="height: 60px; border: 0">
						<td>建设规模：</td>
						<td colspan="3"><center><s:property value="permit.prjSize" /></center></td>
					</tr>
					<tr>
						<td>发证日期：</td>
						<td><s:date name="permit.issueCertDate" format="yyyy-MM-dd" />
							<input type="hidden" id="issueCertDate" value="<s:date name="permit.issueCertDate" format="yyyy-MM-dd" />" /></td>
						<td><input
							type="hidden" id="prjSize"
							value="<s:property value="permit.prjSize" />" /></td>
						<td></td>
					</tr>
					<tr>
						<td>勘察单位名称：</td>
						<td><s:property value="permit.econCorpName" /></td>
						<td>勘察单位组织机构代码：</td>
						<td><s:property value="permit.econCorpCode" /></td>
					</tr>
					<tr>
						<td>设计单位名称：</td>
						<td><s:property value="permit.designCorpName" /> <input
							type="hidden" id="designCorpName"
							value="<s:property value="permit.designCorpName" />" /></td>
						<td>设计单位组织机构代码：</td>
						<td><s:property value="permit.designCorpCode" /></td>
					</tr>
					<tr>
						<td>施工单位名称：</td>
						<td><s:property value="permit.consCorpname" /> <input
							type="hidden" id="consCorpname"
							value="<s:property value="permit.consCorpname" />" /></td>
						<td>施工单位组织机构代码：</td>
						<td><s:property value="permit.consCorpCode" /></td>
					</tr>
					<tr>
						<td>施工单位安全生产许可证编号：</td>
						<td><s:property value="permit.safetyCerId" /></td>
						<td>监理单位名称 ：</td>
						<td><s:property value="permit.superCorpName" /> <input
							type="hidden" id="superCorpName"
							value="<s:property value="permit.superCorpName" />" /></td>
					</tr>
					<tr>
						<td>监理单位组织机构代码：</td>
						<td><s:property value="permit.superCorpCode" /></td>
						<td>项目经理姓名：</td>
						<td><s:property value="permit.constructorName" /></td>
					</tr>
					<tr>
						<td>项目经理证件类型：</td>
						<td><s:if test="permit.cidCardTypeNum==1">身份证</s:if> <s:if
								test="permit.cidCardTypeNum==2">军官证</s:if> <s:if
								test="permit.cidCardTypeNum==3">护照</s:if> <s:if
								test="permit.cidCardTypeNum==4">台湾居民身份证</s:if> <s:if
								test="permit.cidCardTypeNum==5">香港永久居民身份证</s:if> <s:if
								test="permit.cidCardTypeNum==6">警官证</s:if> <s:if
								test="permit.cidCardTypeNum==7">其他</s:if></td>
						<td>项目经理证件号码：</td>
						<td><s:property value="permit.constructorIdCard" /></td>
					</tr>
					<tr>
						<td>总监理工程师姓名：</td>
						<td><s:property value="permit.supervisionName" /></td>
						<td>总监理工程师证件类型：</td>
						<td><s:if test="permit.sidCardTypeNum==1">身份证</s:if> <s:if
								test="permit.sidCardTypeNum==2">军官证</s:if> <s:if
								test="permit.sidCardTypeNum==3">护照</s:if> <s:if
								test="permit.sidCardTypeNum==4">台湾居民身份证</s:if> <s:if
								test="permit.sidCardTypeNum==5">香港永久居民身份证</s:if> <s:if
								test="permit.sidCardTypeNum==6">警官证</s:if> <s:if
								test="permit.sidCardTypeNum==7">其他</s:if></td>
					</tr>
					<tr>
						<td>总监理工程师身份证号码：</td>
						<td><s:property value="permit.supervisionIdCard" /></td>
						<td>安全生产管理人员姓名：</td>
						<td><s:property value="permit.userName" /></td>
					</tr>
					<tr>
						<td>质量编码：</td>
						<td><s:property value="permit.qualityNum" /></td>
						
						<td>安全编码：</td>
						<td><s:property value="permit.safetyNum" /></td>
					
					</tr>
					<tr>
						<td>合同开工日期：</td>
						<td><s:date name="permit.starDate" format="yyyy-MM-dd" /></td>
						
						<td>合同竣工日期：</td>
						<td><s:date name="permit.endDate" format="yyyy-MM-dd" /></td>
					
					</tr>
					<tr>
						<td>合同工期（天）：</td>
						<td><s:property value="permit.timeLimit" /></td>
						<td>记录登记日期：</td>
						<td><s:date name="permit.createDate" format="yyyy-MM-dd" /></td>
					</tr>
					
					<tr>
						<td colspan="4" align="left"><center><strong>
						<a href="#" onclick="querySingleProject()">
						单体工程(点击查看)
						</a></strong></center>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<!--  
					<tr>
						<td>安全生产管理证件类型：</td>
						<td><s:if test="permit.idCardTypeNum==1">身份证</s:if> <s:if
								test="permit.idCardTypeNum==2">军官证</s:if> <s:if
								test="permit.idCardTypeNum==3">护照</s:if> <s:if
								test="permit.idCardTypeNum==4">台湾居民身份证</s:if> <s:if
								test="permit.idCardTypeNum==5">香港永久居民身份证</s:if> <s:if
								test="permit.idCardTypeNum==6">警官证</s:if> <s:if
								test="permit.idCardTypeNum==7">其他</s:if></td>
						<td>安全生产管理人员姓名：</td>
						<td><s:property value="permit.userName" /></td>
					</tr>
					<tr>
						<td>安全生产管理人员证件号：</td>
						<td><s:property value="permit.idCard" /></td>
						<td>安全生产考核合格证书编号：</td>
						<td><s:property value="permit.certId" /></td>
					</tr>
					<tr>
						<td>安全生产管理人员类型：</td>
						<td><s:if test="permit.userType==1">主要负责人</s:if> <s:if
								test="permit.userType==2">项目负责人</s:if> <s:if
								test="permit.userType==3">安全员</s:if></td>
						
					</tr>
					-->
					<tr>
						<td>审核单位：</td>
						<td><s:property value="permit.appSteffName" /></td>
						<td>审核时间：</td>
						<td><s:date name="permit.appDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr style="height: 60px; border: 0">
						<td>审核结果：</td>
						<td><s:if test="permit.appType==0">待审核</s:if> <s:if
								test="permit.appType==1">审核通过</s:if> <s:if
								test="permit.appType==2">审核不通过</s:if></td>
						<td>审核建议：</td>
						<td colspan="3"><textarea id="appId" name="permit.appOpinion"
								class="required"><s:property
									value="permit.appOpinion" /></textarea></td>
					</tr>
				</table>
				<div class="sp_bton">

					<a href="#"><span class="sp_last" onclick="prn_preview()">确认表</span></a>
					<s:if test="permit.appType==1">
						<a href="#"><span class="sp_last" onclick="prn_previewC()">施工许可证</span></a>
					</s:if>
					<a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>

				</div>
			</form>
		</div>
	</div>
	
<div id="table01" style="display: none">
	 <table border="1" width="100%" height="100%" style="border:solid 1px black;border-collapse:collapse">
	 	<tr>
	    <td width="25%"><p align="center" style="font-family:宋体;font-size:18px;">建设单位</p></td>
	    <td width="75%" colspan="3"><p style="font-size:15px;">&nbsp;<s:property value="permit.applyCorpName" /></p></td>
	  </tr>
	 	<tr>
	    <td width="25%"><p align="center" style="font-family:宋体;font-size:18px;">工程名称</p></td>
	    <td width="75%" colspan="3"><p style="font-size:15px;">&nbsp;<s:property value="permit.projectName" /> </p></td>
	  </tr>
	  <tr>
	    <td width="25%"><p align="center" style="font-family:宋体;font-size:18px;">建设地址 </p></td>
	    <td width="75%" colspan="3"><p style="font-size:15px;">&nbsp;<s:property value="projectConstruction.address" /></p></td>
	  </tr>
	 	 <tr>
	    <td width="25%"><p align="center" style="font-family:宋体;font-size:18px;">建设规模</p></td>
	    <td width="25%"><p style="font-size:15px;">&nbsp;<s:property value="permit.area" />平方米</p></td>
	    <td width="25%"><p align="center" style="font-family:宋体;font-size:18px;">合同价格</p></td>
	    <td width="25%"><p style="font-size:15px;">&nbsp;<s:property value="permit.contractMoney" />万元</p></td>
	  </tr>
	 	<tr>
	    <td width="25%"><p align="center" style="font-family:宋体;font-size:18px;">设计单位</p></td>
	    <td width="75%" colspan="3"><p style="font-size:15px;">&nbsp;<s:property value="permit.designCorpName" /> </p></td>
	  </tr>
	 	 <tr>
	    <td width="25%"><p align="center" style="font-family:宋体;font-size:18px;">施工单位</p></td>
	    <td width="75%" colspan="3"><p style="font-size:15px;">&nbsp;<s:property value="permit.consCorpname" /> </p></td>
	  </tr>
	   <tr>
	    <td width="25%"><p align="center" style="font-family:宋体;font-size:18px;">监理单位</p></td>
	    <td width="75%" colspan="3"><p style="font-size:15px;">&nbsp;<s:property value="permit.superCorpName" /> </p></td>
	  </tr>
	 	<tr>
	    <td width="25%"><p align="center" style="font-family:宋体;font-size:18px;">合同开工日期</p></td>
	    <td width="25%"><p style="font-size:15px;">&nbsp;<s:date name="permit.starDate" format="yyyy-MM-dd" /> </p></td>
	    <td width="25%"><p align="center" style="font-family:宋体;font-size:18px;">合同竣工日期</p></td>
	    <td width="25%"><p style="font-size:15px;">&nbsp;<s:date name="permit.endDate" format="yyyy-MM-dd" /></p></td>
	  </tr>
	 	<tr>
	       <td width="25%">
	    	<p align="center" style="font-family:宋体;font-size:18px;">备注</p>
	    	<p>&nbsp; </p>
	       </td>
	       <td width="75%" colspan="3">
	    	<p>&nbsp; </p>
	    	<p>&nbsp; </p>
	       </td>
	   </tr>
	</table>
</div>	
	
	<div id="table03" style="display: none">
		<table border="1" width="100%" height="100%"
			style="border: solid 1px black; border-collapse: collapse">

			<tr>
				<td width="20%"><p align="center">工程名称</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="permit.projectName" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">项目编号</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="permit.prjNum" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">施工许可证编号</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="permit.builderLicenceNum" />
					</p></td>
			</tr>

			<tr>
				<td width="20%"><p align="center">建设用地规划许可证编号</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="permit.projectPlanNum" />
					</p></td>
			</tr>

			<tr>
				<td width="20%"><p align="center">建设工程规划许可证编号</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="permit.projectPlanNum" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">施工图审查合格书编号</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="permit.censorNum" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">合同金额</p></td>
				<td width="30%"><p align="right">
						<s:property value="permit.contractMoney" />
						万元
					</p></td>
				<td width="20%"><p align="center">面积</p></td>
				<td width="30%"><p align="right">
						<s:property value="permit.area" />
						平方米
					</p></td>
			</tr>
			<tr>
				<td width="20%">
					<p align="center">&nbsp;</p>
					<p align="center">建设规模</p>
					<p align="center">&nbsp;</p>
				</td>
				<td width="80%" colspan="3">
					<p>&nbsp;</p>
					<p>
						&nbsp;
						<s:property value="permit.prjSize" />
					</p>
					<p>&nbsp;</p>
				</td>
			</tr>

			<tr>
				<td width="20%"><p align="center">发证日期</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:date name="permit.issueCertDate" format="yyyy-MM-dd" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">勘察单位名称</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="permit.econCorpName" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">设计单位名称</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="permit.designCorpName" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">施工单位名称</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="permit.consCorpname" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">施工单位安全生产许可证编号</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="permit.safetyCerId" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">监理单位名称</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="permit.superCorpName" />
					</p></td>
			</tr>

			<tr>
				<td width="20%"><p align="center">项目经理姓名</p></td>
				<td width="30%"><p align="center">
						&nbsp;
						<s:property value="permit.constructorName" />
					</p></td>
				<td width="20%"><p align="center">项目经理证件号码</p></td>
				<td width="30%"><p align="center">
						&nbsp;
						<s:property value="permit.constructorIdCard" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">总监理工程师姓名</p></td>
				<td width="30%"><p align="center">
						&nbsp;
						<s:property value="permit.supervisionName" />
					</p></td>
				<td width="20%"><p align="center">总监理工程师身份证号码</p></td>
				<td width="30%"><p align="center">
						&nbsp;
						<s:property value="permit.supervisionIdCard" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">安全生产管理人员姓名</p></td>
				<td width="30%"><p align="center">
						&nbsp;
						<s:property value="permit.userName" />
					</p></td>
				<td width="20%"><p align="center">安全生产管理人员证件号</p></td>
				<td width="30%"><p align="center">
						&nbsp;
						<s:property value="permit.idCard" />
					</p></td>
			</tr>

			<tr>
				<td width="20%"><p align="center">安全生产考核合格证书编号</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="permit.certId" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">安全生产管理人员类型</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:if test="permit.userType==1">主要负责人</s:if>
						<s:if test="permit.userType==2">项目负责人</s:if>
						<s:if test="permit.userType==3">安全员</s:if>
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">记录登记日期</p></td>
				<td width="80%" colspan="3"><p>&nbsp;</p></td>
			</tr>

			<tr>
				<td colspan="2"><p>施工单位意见：</p>
					<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; （公章）</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>经 办 人</p>
					<p>联系电话</p>
					<p>&nbsp;</p>
					<p align="right">年&nbsp;&nbsp; 月&nbsp;&nbsp; 日</p></td>
				<td colspan="2"><p>审核单位意见：</p>
					<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; （公章）</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>经 办 人</p>
					<p>联系电话</p>
					<p>&nbsp;</p>
					<p align="right">年 &nbsp;&nbsp;月 &nbsp;&nbsp;日</p></td>
			</tr>
		</table>
	</div>

	<script language="javascript" type="text/javascript">
		var LODOP; //声明为全局变量 
		function prn_preview() {
			CreatePrintPageAB();
			//LODOP.SET_PRINT_PAGESIZE(0,"210mm","297mm","");
			//LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
			//LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
			LODOP.PREVIEW();
		};

		function CreatePrintPageAB(){
			LODOP = getLodop();
			LODOP.PRINT_INIT("上报施工许可审核");
			var strHTML = "<body style='margin:0;background-color: white'>"
					+ document.getElementById("table03").innerHTML + "</body>";
			//LODOP.ADD_PRINT_HTM("10mm","10mm","RightMargin:15mm","BottomMargin:15mm",strHTML);
			LODOP.ADD_PRINT_HTM("5mm", 34, "RightMargin:0.9cm",
					"BottomMargin:9mm", strHTML);
			//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
		};

		
		//施工许可证原套打
		function prn_previewAB3() 
		{
			LODOP=getLodop();  
			LODOP.PRINT_INIT("施工许可证");
			LODOP.SET_PRINT_PAGESIZE(2,"260mm","375mm","");
			LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW", 1);//打印后自动关闭预览窗口
			CreatePrintPageAB3();
		    LODOP.PREVIEW();
		};

		function CreatePrintPageAB3() 
		{		
			LODOP.ADD_PRINT_TEXT("96mm","110mm","60mm","8mm",document.getElementById("builderLicenceNum").value);
			LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
			//LODOP.ADD_PRINT_TEXT("190mm","100mm","70mm","8mm","黑龙江住房和城乡建设厅");
			//LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
			LODOP.ADD_PRINT_TEXT("211mm","102mm","70mm","8mm",document.getElementById("issueCertDate").value);
			LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
			
			LODOP.ADD_PRINT_TEXT("26mm","250mm","97mm","8mm",document.getElementById("consCorpname").value);
			LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
			LODOP.ADD_PRINT_TEXT("36mm","250mm","97mm","8mm",document.getElementById("projectName").value);
			LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
			LODOP.ADD_PRINT_TEXT("46mm","250mm","97mm","8mm",document.getElementById("address").value);
			LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
			
			LODOP.ADD_PRINT_TEXT("56mm","250mm","32mm","8mm",document.getElementById("prjSize").value+"平方米");
			LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
			LODOP.ADD_PRINT_TEXT("56mm","317mm","18mm","8mm",document.getElementById("contractMoney").value);
			LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
			
			LODOP.ADD_PRINT_TEXT("66mm","250mm","97mm","8mm",document.getElementById("designCorpName").value);
			LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
			LODOP.ADD_PRINT_TEXT("76mm","250mm","97mm","8mm",document.getElementById("consCorpname").value);
			LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
			LODOP.ADD_PRINT_TEXT("86mm","250mm","97mm","8mm",document.getElementById("superCorpName").value);
			LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
			
			LODOP.ADD_PRINT_TEXT("96mm","250mm","30mm","8mm",document.getElementById("beginDate").value);
			LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
			LODOP.ADD_PRINT_TEXT("96mm","317mm","30mm","8mm",document.getElementById("endDate").value);
			LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
			
			LODOP.ADD_PRINT_TEXT("106mm","250mm","97mm","30mm","项目经理：");
			LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
			LODOP.ADD_PRINT_BARCODE("210mm","20mm","30mm","30mm","QRCode","http://192.20.1.89:8080/CBasicsService/dataImportAction_queryHistory.action?permitId="+document.getElementById("permitId").value);
		};
		
		function prn_previewA3() 
		{	
		  LODOP=getLodop();  
		  LODOP.PRINT_INIT("施工许可证A3");
		  LODOP.SET_PRINT_PAGESIZE(2,0,0,"A3");
		  CreatePrintPageA3();
		  LODOP.PREVIEW();
		};
		
		
		function prn_previewC() 
		{	
		  LODOP=getLodop();  
		  LODOP.PRINT_INIT("施工许可证C");
		  LODOP.SET_PRINT_PAGESIZE(2,"262mm","378mm","");
		  CreatePrintPageC();
		  LODOP.PREVIEW();
		};
		
		function CreatePrintPageA3() 
		{
		  LODOP.ADD_PRINT_RECT("15mm","15mm","180mm","267mm",0,1);
		  
		  LODOP.ADD_PRINT_TEXT(164,98,631,55,"     中华人民共和国");
		  LODOP.SET_PRINT_STYLEA(0, "FontSize", 36);
		  LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		  //LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",2);//字间距
		  
		  LODOP.ADD_PRINT_TEXT(294,102,626,79,"建筑工程施工许可证");
		  LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
		  LODOP.SET_PRINT_STYLEA(0, "FontSize", 46);
		  LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		  LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",2);//字间距
			
		  LODOP.ADD_PRINT_TEXT("120mm","105mm",331,41,"编号 "+document.getElementById("builderLicenceNum").value);
		  LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
			
		  LODOP.ADD_PRINT_TEXT("149mm","25mm",617,45,"    根据《中华人民共和国建筑法》第八条规定，经审查，本");
		  LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
		  LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",2);//字间距
			
		  LODOP.ADD_PRINT_TEXT(610,"25mm",617,45,    "建筑工程符合施工条件，准予施工。");
		  LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
		  LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",2);//字间距
			
			
		  LODOP.ADD_PRINT_TEXT(687,96,620,50,"        特发此证");
		  LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
		//LODOP.ADD_PRINT_TEXT(827,388,336,45,"发证机关 "+document.getElementById("CertDepartment").value);
		  LODOP.ADD_PRINT_TEXT(827,388,336,45,"发证机关 ");
		  LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
		  LODOP.ADD_PRINT_TEXT(922,388,336,45,"日    期 "+document.getElementById("issueCertDate").value);
		  LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
			
		  LODOP.ADD_PRINT_BARCODE("240mm","30mm","40mm","40mm","QRCode","http://111.40.3.210:808/hljjst_InterfaceSys/qrCodeAction_queryBuilderLicence.action?permitId="+document.getElementById("permitId").value+"&Type=1");
		  
		  LODOP.ADD_PRINT_RECT("15mm","225mm","180mm","267mm",0,1);
		  LODOP.ADD_PRINT_HTM("30mm","235mm","160mm","140mm",document.getElementById("table01").innerHTML);
			
		  LODOP.ADD_PRINT_TEXT(697,888,624,302,
			 "注意事项：\n"
			+"一、本证放置施工现场，作为准予施工的凭证。\n"
			+"二、未经发证机关许可，本证的各项内容不得变更。\n"
			+"三、建设行政主管部门可以对本证进行查验。\n"
			+"四、本证自核发之日起三个月内应予施工，逾期应办理延期手续，\n"
			+"    不办理延期或延期次数、时间超过法定时间的，本证自行废止。\n"
			+"五、凡未取得本证擅自施工的属违法建设，将按《中华人民共和国\n"
			+"    建筑法》的规定予以处罚。\n");
		  LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",1);//字间距
		  LODOP.SET_PRINT_STYLEA(0,"LineSpacing",8);//行距
		  LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
			//LODOP.SET_PRINT_STYLEA(0,"FontName","隶书");//字体
			//LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		};
	
		function CreatePrintPageC() 
		{		 
			  LODOP.ADD_PRINT_RECT("5mm","10mm","169mm","242mm",0,1);
			  
			  LODOP.ADD_PRINT_TEXT(155,93,494,55,"    中华人民共和国");
			  LODOP.SET_PRINT_STYLEA(0, "FontSize", 35);
			  LODOP.SET_PRINT_STYLEA(0,"Bold",1);
			  //LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",2);//字间距
			  
				LODOP.ADD_PRINT_TEXT(285,80,561,79,"建筑工程施工许可证");
				LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
				LODOP.SET_PRINT_STYLEA(0, "FontSize", 45);
			  LODOP.SET_PRINT_STYLEA(0,"Bold",1);
				//LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",1);//字间距
			
			LODOP.ADD_PRINT_TEXT("110mm","84mm",331,41,"编号 "+document.getElementById("builderLicenceNum").value);
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
			
			LODOP.ADD_PRINT_TEXT("135mm","15mm",597,42,"    根据《中华人民共和国建筑法》第八条规定，经审查，本");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
			LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",1);//字间距
			
			LODOP.ADD_PRINT_TEXT(560,"15mm",577,45,    "建筑工程符合施工条件，准予施工。");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
			LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",2);//字间距
			
			
			LODOP.ADD_PRINT_TEXT(650,90,575,50,"        特发此证");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
			//LODOP.ADD_PRINT_TEXT(810,380,336,45,"发证机关 "+document.getElementById("CertDepartment").value);
			LODOP.ADD_PRINT_TEXT(750,330,336,45,"发证机关 ");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
			LODOP.ADD_PRINT_TEXT(830,330,336,45,"日    期 "+document.getElementById("issueCertDate").value);
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
			
		  LODOP.ADD_PRINT_BARCODE("210.4mm","13.63mm","40mm","40mm","QRCode","http://111.40.3.210:808/hljjst_InterfaceSys/qrCodeAction_queryBuilderLicence.action?permitId="+document.getElementById("permitId").value+"&Type=1");
		  
		  LODOP.ADD_PRINT_RECT("5mm","194mm","169mm","242mm",0,1);
		  LODOP.ADD_PRINT_HTM("15mm","199mm","159mm","130mm",document.getElementById("table01").innerHTML);
		  LODOP.ADD_PRINT_TEXT(600,765,603,302,
			 "注意事项：\n"
			+"一、本证放置施工现场，作为准予施工的凭证。\n"
			+"二、未经发证机关许可，本证的各项内容不得变更。\n"
			+"三、建设行政主管部门可以对本证进行查验。\n"
			+"四、本证自核发之日起三个月内应予施工，逾期应办理延期手续，\n"
			+"    不办理延期或延期次数、时间超过法定时间的，本证自行废止。\n"
			+"五、凡未取得本证擅自施工的属违法建设，将按《中华人民共和国\n"
			+"    建筑法》的规定予以处罚。\n");
		  //LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",1);//字间距
		  LODOP.SET_PRINT_STYLEA(0,"LineSpacing",8);//行距
		  LODOP.SET_PRINT_STYLEA(0, "FontSize", 14);
			//LODOP.SET_PRINT_STYLEA(0,"FontName","隶书");//字体
			//LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		};	
		
	</script>
</body>
</html>