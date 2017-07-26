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
//附件下载
function downLoad(uploadId)
{
	document.form1.action="<%=basepath%>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=permitSuccess";
	document.form1.submit();
}
	
	//审核通过
	function applythrough()
	{
		var nm = document.getElementById("appId");
		if(nm.value != "")
		{
			document.form1.action="<%=basepath%>/promiseApplyAction_approvalSuccess.action";
			document.form1.submit();
		}else
		{
			alert("请输入审核意见!");	
		}
		//prn_previewA3();
		//prn_preview();
		
	}
	//申请退回
	function applyBack()
	{
		var nmv = document.getElementById("appId");
		if(nmv.value != "")
		{
			document.form1.action="<%=basepath%>/promiseApplyAction_approvalFailed.action";
			document.form1.submit();
		}else
		{
			alert("请输入审核意见!");	
		}
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/promiseApplyAction_goBack.action";
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

			<h2 class="f16 fb" style="background: #80aced;">施工许可审核</h2>
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
							type="hidden" name="permit.prjNum" id="prjNum"
							value="<s:property value="permit.prjNum"/>"> <input
							type="hidden" name="permit.permitId" id="permitId"
							value="<s:property value="permit.permitId"/>"><input
							type="hidden" name="permit.createDate"
							value="<s:property value="permit.createDate"/>"> <input
							type="hidden" name="permit.appDept"
							value="<s:property value="permit.appDept"/>">
							<input type="hidden" id="prjId" name="permit.prjId"
							value="<s:property value="permit.prjId"/>"></td>
						<td>项目编号：</td>
						<td><s:property value="permit.prjNum" /></td>

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
							<input type="hidden" id="issueCertDate"
							value="<s:property value="permit.issueCertDate" />" /></td>
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
						
						<td>记录登记日期：</td>
						<td><s:date name="permit.createDate" format="yyyy-MM-dd" /></td>
					
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
						
						<td></td>
						<td></td>
					
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
						<td>安全生产管理人员姓名：</td>
						<td><s:property value="permit.userName" /></td>
					</tr>
-->
					<tr style="height: 60px; border: 0">
						<td>审核意见：</td>
						<td colspan="3"><textarea id="appId" name="permit.appOpinion"
								class="required"></textarea></td>
					</tr>
				</table>
				<h2>附件</h2>
				<s:iterator value="downloadlist" status="i">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><a href="#"
							onclick="downLoad('<s:property value="uploadId"/>')"><s:property
									value="fileFileName" /></a></td>
					</tr>
				</s:iterator>
				<div class="sp_bton">
					<a href="#"><span class="sp_first" onclick="applythrough()">审核通过</span></a>
					<a href="#"><span class="sp_second" onclick="applyBack()">申请退回</span></a>
					<a href="#"><span class="sp_last" onclick="goBack()">取消</span></a>
				</div>
			</form>
		</div>
	</div>
	<div id="table03" style="display: none">
		<table border="1" width="100%" height="100%"
			style="border: solid 1px black; border-collapse: collapse">
			<tr>
				<td width="20%"><p align="center">建设单位</p></td>
				<td width="30%"><p>&nbsp;</p></td>
				<td width="20%"><p align="center">单位性质</p></td>
				<td width="30%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">工程名称</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="permit.prjName" />
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

		function CreatePrintPageAB() {
			LODOP = getLodop();
			LODOP.PRINT_INIT("上报施工许可审核");
			var strHTML = "<body style='margin:0;background-color: white'>"
					+ document.getElementById("table03").innerHTML + "</body>";
			//LODOP.ADD_PRINT_HTM("10mm","10mm","RightMargin:15mm","BottomMargin:15mm",strHTML);
			LODOP.ADD_PRINT_HTM("5mm", 34, "RightMargin:0.9cm",
					"BottomMargin:9mm", strHTML);
			//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
		};

		function prn_previewA3() {
			CreatePrintPageA3();
			LODOP.SET_PRINT_PAGESIZE(0, "420mm", "297mm", "");
			LODOP.SET_PREVIEW_WINDOW(1, 0, 1, 0, 0, "");//打印前弹出选择打印机的对话框	
			LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW", 1);//打印后自动关闭预览窗口

			LODOP.PREVIEW();
		};

		function CreatePrintPage() {
			LODOP = getLodop();
			LODOP.PRINT_INIT("打印设计");

		};

		function CreatePrintPageA3() {
			LODOP = getLodop();
			LODOP.PRINT_INIT("打印施工许可证");
			LODOP.ADD_PRINT_RECT("15mm", "15mm", "180mm", "267mm", 0, 1);
			LODOP
					.ADD_PRINT_HTM(154, 155, 479, 95,
							"<p align='center' style='font-size:48px;'><strong>中华人民共和国 </strong></p>");
			LODOP
					.ADD_PRINT_HTM(
							267,
							76,
							650,
							82,
							"<p align='center' style='font-size:65px;font-family:黑体'><strong>建筑工程施工许可证 </strong></p>");
			LODOP.ADD_PRINT_HTM(407, 378, 50, 30,
					"<p style='font-family:宋体; font-size:23px;'>编号</p>");
			LODOP
					.ADD_PRINT_HTM(
							490,
							76,
							655,
							70,
							"<p style='font-family:宋体;font-size:23px; line-height:30px; text-indent:2em; text-align:left; padding:0 10px'>根据《中华人民共和国建筑法》第八条规定，经审查，本建筑工程符合施工条件，准予施工。 </p>");
			LODOP
					.ADD_PRINT_HTM(
							604,
							103,
							300,
							100,
							"<p style='font-family:宋体;font-size:23px; text-align:left; padding:20px 0 20px 86px;'>特发此证 </p>");
			LODOP
					.ADD_PRINT_HTM(826, 345, 300, 35,
							"<p style='font-family:宋体;font-size:23px; padding-bottom:20px;'>发证机关 </p>");
			LODOP
					.ADD_PRINT_HTM(
							903,
							341,
							300,
							100,
							"<p style='font-family:宋体;font-size:23px; padding-top:20px;'>日&nbsp;&nbsp;&nbsp;&nbsp;期&nbsp;&nbsp;"
									+ document.getElementById("issueCertDate").value
									+ " </p>");
			LODOP
					.ADD_PRINT_HTM(
							407,
							431,
							273,
							30,
							"<p style='font-family:宋体; font-size:23px;'>"
									+ document
											.getElementById("builderLicenceNum").value
									+ "</p>");
			LODOP.ADD_PRINT_RECT("15mm", "225mm", "180mm", "267mm", 0, 1);
			LODOP
					.ADD_PRINT_TABLE(
							101,
							882,
							636,
							559,
							"<style> table,td,th {border: 1px solid black;border-style: solid;border-collapse: collapse}</style>"
									+ " <table border='1' cellspacing='0' cellpadding='0' width='96%'  style='margin:0 auto; text-align:center;font-family:宋体; font-size:22px; height:500px; margin-top:50px;' >"
									+ "         <tr>"
									+ "           <td  >建 设 单 位 </td>"
									+ "           <td  colspan='3' align='left'>&nbsp;"
									+ document.getElementById("consCorpname").value
									+ "</td>"
									+ "         </tr>"
									+ "         <tr>"
									+ "           <td  >工 程 名 称 </td>"
									+ "           <td  colspan='3' >&nbsp;"
									+ document.getElementById("prjName").value
									+ "</td>"
									+ "         </tr>"
									+ "         <tr>"
									+ "           <td  >建 设 地 址 </td>"
									+ "           <td  colspan='3'>&nbsp;</td>"
									+ "         </tr>"
									+ "         <tr>"
									+ "           <td width='25%' >建 设 规 模 </td>"
									+ "           <td width='25%'>&nbsp;"
									+ document.getElementById("prjSize").value
									+ "</td>"
									+ "           <td width='25%' >合 同 价 格 </td>"
									+ "           <td width='25%' style='text-align:right; padding-right:5px;'>"
									+ document.getElementById("contractMoney").value
									+ "万元  </td>"
									+ "         </tr>"
									+ "         <tr>"
									+ "           <td width='25%' >设 计 单 位  </td>"
									+ "           <td width='75%' colspan='3' >&nbsp;"
									+ document.getElementById("designCorpName").value
									+ "  </td>"
									+ "         </tr>"
									+ "         <tr>"
									+ "           <td width='25%' > 施 工 单 位  </td>"
									+ "           <td width='75%' colspan='3' >&nbsp; "
									+ document.getElementById("consCorpname").value
									+ " </td>"
									+ "         </tr>"
									+ "         <tr>"
									+ "           <td width='25%' > 监 理 单 位  </td>"
									+ "           <td width='75%' colspan='3' >&nbsp;"
									+ document.getElementById("superCorpName").value
									+ "  </td>"
									+ "         </tr>"
									+ "         <tr>"
									+ "           <td width='25%' > 合同开工日期  </td>"
									+ "           <td width='25%' >&nbsp;  </td>"
									+ "           <td width='25%' > 合同竣工日期  </td>"
									+ "           <td width='25%' >&nbsp;  </td>"
									+ "         </tr>"
									+ "         <tr>"
									+ "           <td width='100%' colspan='4' ><p style='text-align:left; padding-left:5px; padding-bottom:60px; margin-top:4px;'>备注</td>"
									+ "         </tr>" + " </table>");
			LODOP.ADD_PRINT_HTM(618, 878, 166, 30,
					"<p style='font-size:21px;'><b>注意事项：</b> </p>");
			LODOP.ADD_PRINT_HTM(655, 882, 453, 30,
					"<p style='font-size:21px;'>一、本证放置施工现场，作为准予施工的凭证。</p>");
			LODOP.ADD_PRINT_HTM(700, 882, 484, 32,
					"<p style='font-size:21px;'>二、未经发证机关许可，本证的各项内容不得变更。</p>");
			LODOP.ADD_PRINT_HTM(746, 883, 430, 29,
					"<p style='font-size:21px;'>三、建设行政主管部门可以对本证进行查验。</p>");
			LODOP
					.ADD_PRINT_HTM(792, 883, 591, 34,
							"<p style='font-size:21px;'>四、本证自核发之日起三个月内应予施工，逾期应办理延期手续，</p>");
			LODOP
					.ADD_PRINT_HTM(836, 924, 571, 24,
							"<p style='font-size:21px;'>不办理延期或延期次数、时间超过法定时间的，本证自行废止。</p>");
			LODOP
					.ADD_PRINT_HTM(882, 882, 612, 35,
							"<p style='font-size:21px;'>五、凡未取得本证擅自施工的属违法建设，将按《中华人民共和国</p>");
			LODOP.ADD_PRINT_HTM(929, 926, 244, 25,
					"<p style='font-size:21px;'>建筑法》的规定予以处罚。</p>");
			//LODOP.ADD_PRINT_BARCODE(1310,127,168,146,"QRCode","http://localhost:8088/cip/corpAction_showCodeCertificate.action?builderLicenceNum="+document.getElementById("builderLicenceNum").value);
			//LODOP.ADD_PRINT_BARCODE(948,90,110,85,"QRCode","http://localhost:8088/cip/corpAction_showCodeCertificate.action?builderLicenceNum="+document.getElementById("builderLicenceNum").value);

		};
	</script>
</body>
</html>