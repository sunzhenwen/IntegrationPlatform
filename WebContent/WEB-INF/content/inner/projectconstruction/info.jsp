<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报项目审核查询</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/historyAction_goBack.action";
		document.form1.submit();
	}

	function prn_preview() {
		CreatePrintPageAB();
		//LODOP.SET_PRINT_PAGESIZE(0,"210mm","297mm","");
		//LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
		LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
		LODOP.PREVIEW();
	};
	function CreatePrintPageAB() {
		LODOP = getLodop();
		LODOP.PRINT_INIT("项目报建表");
		var strHTML = "<body style='margin:0;background-color: white'>"
				+ document.getElementById("table03").innerHTML + "</body>";
		LODOP.ADD_PRINT_HTM("10mm", "10mm", "RightMargin:1.5cm",
				"BottomMargin:15mm", strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
	};
</script>
</head>
<body>
	<div id="table03" style="display: none">
		<p align="center">工程建设项目报建表</p>
		<table border="1" 
			style="border: solid 1px black; border-collapse: collapse">
			<tr>
				<td width="20%" colspan="3"><p align="center">项目编号</p></td>
				<td width="80%" colspan="13"><p>
						&nbsp;
						<s:property value="project.prjNum" />
					</p></td>
			</tr>
			<tr>
				<td width="20%" colspan="3"><p align="center">建设单位</p></td>
				<td width="40%" colspan="6"><p>
						&nbsp;
						<s:property value="project.buildCorpName" />
					</p></td>
				<td width="15%" colspan="2"><p align="center">单位性质</p></td>
				<td width="25%" colspan="5"><p>&nbsp;</p></td>
			</tr>

			<tr>
				<td width="20%" colspan="3"><p align="center">工程名称</p></td>
				<td width="80%" colspan="13"><p>
						&nbsp;
						<s:property value="project.prjName" />
					</p></td>
			</tr>
			<tr>
				<td width="20%" colspan="3"><p align="center">工程地址</p></td>
				<td width="80%" colspan="13"><p>
						&nbsp;
						<s:property value="project.provinceName" />
						<s:property value="project.cityName" />
						<s:property value="project.countyName" />
					</p></td>
			</tr>
			<tr>
				<td width="20%" colspan="3"><p align="center">建设性质</p></td>
				<td width="20%" colspan="2"><p>
						&nbsp;
						<s:property value="project.prjPropertyName" />
					</p></td>
				<td width="10%" colspan="2"><p align="center">结构</p></td>
				<td width="10%" colspan="2"><p>&nbsp;</p></td>

				<td width="15%" colspan="2"><p align="center">层数</p></td>
				<td width="25%" colspan="5"><p>&nbsp;</p></td>

			</tr>
			<tr>
				<td width="20%" colspan="3"><p align="center">投资总额</p></td>
				<td width="30%" colspan="5"><p align="center">
						&nbsp;
						<s:property value="project.allInvest" />
						万元
					</p></td>

				<td width="20%" colspan="3"><p align="center">当年投资</p></td>
				<td width="30%" colspan="5"><p align="center">万元</p></td>
			</tr>

			<tr>
				<td width="20%" colspan="3"><p align="center">资信证明</p></td>
				<td width="80%" colspan="13"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="20%" colspan="3"><p align="center">建设规模</p></td>
				<td width="80%" colspan="13"><p>&nbsp;<s:property value="project.prjSize" /></p></td>
			</tr>
			<tr>
				<td width="10%" rowspan="2">
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;批</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;准</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;文</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件</p>
				</td>
				<td width="25%" colspan="5">
					<p align="center">&nbsp;</p>
					<p align="center">立项文件名称及文号</p>
					<p align="center">&nbsp;</p>
				</td>
				<td width="65%" colspan="10"><p>&nbsp;</p>
					<p>
						&nbsp;
						<s:property value="project.prjApprovalLevelName" />
						<s:property value="project.prjApprovalNum" />
					</p>
					<p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="25%" colspan="5">
					<p align="center">&nbsp;</p>
					<p align="center">规划批准文件及文号</p>
					<p align="center">&nbsp;</p>
				</td>
				<td width="65%" colspan="10"><p>&nbsp;</p>
					<p>&nbsp;建设用地规划许可证编号：<s:property value="project.buldPlanNum" /></p>
					<p>&nbsp;建设工程规划许可证编号：<s:property value="project.projectPlanNum" /></p></td>
			</tr>
			<tr>
				<td width="20%" colspan="3"><p align="center">开工日期</p></td>
				<td width="30%" colspan="5"><p align="center">
						<s:date name="project.beginDate" format="yyyy-MM-dd" />
					</p></td>
				<td width="20%" colspan="3"><p align="center">竣工日期</p></td>
				<td width="30%" colspan="5"><p align="center">
						<s:date name="project.endDate" format="yyyy-MM-dd" />
					</p></td>
			</tr>
			<tr>
				<td width="15%" colspan="2">
					<p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;工情</p>
					<p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;程</p>
					<p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;筹</p>
					<p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;建况</p>
				</td>
				<td width="85%" colspan="14"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td colspan="7"><p>建设单位意见：</p>
					<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; （公章）</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>经 办 人</p>
					<p>联系电话</p>
					<p>&nbsp;</p>
					<p align="right">年&nbsp;&nbsp; 月&nbsp;&nbsp; 日</p></td>
				<td colspan="9"><p>审核单位意见：</p>
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



	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">申请项目审核查询</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>项目编号：</td>
						<td><s:property value="project.prjNum" /> <input
							type="hidden" name="project.prjId"
							value="<s:property value="project.prjId"/>" /></td>
						<td>项目名称：</td>
						<td><s:property value="project.prjName" /></td>
					</tr>

					<tr>
						<td>项目分类：</td>
						<td><s:property value="project.prjTypeName" /><input
							type="hidden" name="project.prjTypeNum"
							value="<s:property value="project.prjTypeNum"/>" /></td>
						<td>建设单位名称：</td>
						<td><s:property value="project.buildCorpName" /></td>
					</tr>
					<tr>
						<td>建设单位组织机构代码证：</td>
						<td><s:property value="project.buildCorpCode" /></td>
						<td>项目所在省：</td>
						<td><s:property value="project.provinceName" /><input
							type="hidden" name="project.countyNum"
							value="<s:property value="project.countyNum"/>" /></td>
					</tr>
					<tr>
						<td>项目所在市：</td>
						<td><s:property value="project.cityName" /></td>
						<td>项目所在地：</td>
						<td><s:property value="project.countyName" /></td>
					</tr>
					<tr>
						<td>立项文号：</td>
						<td><s:property value="project.prjApprovalNum" /></td>
						<td>立项级别：</td>
						<td><s:property value="project.prjApprovalLevelName" /></td>
					</tr>
					<tr>
						<td>建设用地规划许可证编号：</td>
						<td><s:property value="project.buldPlanNum" /></td>
						<td>建设工程规划许可证编号：</td>
						<td><s:property value="project.projectPlanNum" /></td>
					</tr>
					<tr>
						<td>总投资（万元）：</td>
						<td><s:property value="project.allInvest" /></td>
						<td>总面积（平方米）：</td>
						<td><s:property value="project.allArea" /></td>
					</tr>
					<tr>
						<td>开工日期：</td>
						<td><s:date name="project.beginDate" format="yyyy-MM-dd" /></td>
						<td>竣工日期：</td>
						<td><s:date name="project.endDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>建设性质：</td>
						<td><s:property value="project.prjPropertyName" /></td>
						<td></td>
						<td></td>
					</tr>
						<tr style="height: 60px; border: 0">
						<td>建设规模：</td>
						<td colspan="3"><center><s:property value="project.prjSize" /></center></td>
					</tr>
					<tr>
						<td>工程用途：</td>
						<td><s:property value="project.prjFunctionName" /></td>
						<td>登记日期：</td>
						<td><s:date name="project.createDate" format="yyyy-MM-dd" />
							<input type="hidden" name="project.createDate"
							value="<s:property value="project.createDate" />" /></td>
					</tr>
					<tr>
						<td>详细地址：</td>
						<td colspan="3"><div align="center"><s:property value="project.address" /></div></td>
					</tr>
					<tr style="height: 60px; border: 0">
						<td>审核结果：</td>
						<td colspan="3"><div align="center"><s:if test="project.processSteps==2">项目报建通过</s:if> <s:if
								test="project.processSteps==3">待合同备案、施工图审处理。。</s:if> <s:if
								test="project.processSteps==4">待质量监督、安全监督处理。。</s:if> <s:if
								test="project.processSteps==5">带施工许可处理。。</s:if> <s:if
								test="project.processSteps==6">待竣工验收处理。。</s:if> <s:if
								test="project.processSteps==7">竣工验收通过</s:if> <s:if
								test="project.appType==2">项目报建不通过</s:if></div></td>
					</tr>
				</table>
				<!-- 
				<table class="sp_mtable"
					style="border-collapse: collapse; border: 1px solid #CCC; text-align: center;">
					<s:if test="project.unitMark != null">
						<h2>单位工程</h2>
						<tr>
							<td>序号</td>
							<td>项目名称</td>
							<td>层数</td>
							<td>规模</td>
							<td>投资</td>
							<td>结构</td>
						</tr>
						<s:iterator status="i" value="currentPage.data">
							<tr>
								<td><s:property value="#i.count" /></td>
								<td><s:property value="prjName" /></td>
								<td><s:property value="pliesNum" /></td>
								<td><s:property value="prjSize" /></td>
								<td><s:property value="prjNvest" /></td>
								<td><s:property value="prjBuild" /></td>
							</tr>
						</s:iterator>
						</s:if>
				</table>
				 -->
				
				<div class="sp_bton">
					<a href="#"><span class="sp_last" onclick="prn_preview()">打印</span></a>
					<a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
				</div>
			</form>
		</div>
	</div>



</body>
</html>