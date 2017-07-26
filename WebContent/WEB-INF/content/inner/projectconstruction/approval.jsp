<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报项目审核</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
  
	
	//审核通过
	function applythrough()
	{
		var nm = document.getElementById("appId");
		if(nm.value != "")
		{
			document.form1.action="<%=basepath%>/projectConstructionAction_applySuccess.action";
			document.form1.submit();
		}else
		{
			alert("请输入审核意见!");	
		}
	}
	//申请退回
	function applyBack()
	{
		var nmv = document.getElementById("appId");
		if(nmv.value != "")
		{
			document.form1.action="<%=basepath%>/projectConstructionAction_applyFaile.action";
			document.form1.submit();
		}else
		{
			alert("请输入审核意见!");	
		}
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/projectConstructionAction_goBack.action";
		document.form1.submit();
	}
	
	//附件下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath%>/fileUpload_downLoadFile.action?id="
				+ uploadId + "&returnRoot=constructionSuccess";
		document.form1.submit();
	}
	 function prn_preview() 
	 {	
			CreatePrintPageAB();	
			//LODOP.SET_PRINT_PAGESIZE(0,"210mm","297mm","");
			//LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
			//LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
				LODOP.PREVIEW();
	 };  
	function CreatePrintPageAB() 
	{
		LODOP=getLodop();  
		LODOP.PRINT_INIT("项目报建表");
		var strHTML="<body style='margin:0;background-color: white'>"+document.getElementById("table03").innerHTML+"</body>";
		LODOP.ADD_PRINT_HTM("10mm","10mm","RightMargin:1.5cm","BottomMargin:15mm",strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
	};
	
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">申请项目审核</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>项目编号：</td>
						<td><s:property value="project.prjNum" />
						<input type="hidden" name="project.prjId" value="<s:property value="project.prjId"/>" />
						<input type="hidden" name="project.prjNum" value="<s:property value="project.prjNum"/>" />
						<input type="hidden" name="project.prjName" value="<s:property value="project.prjName"/>" />
						<input type="hidden" name="project.appDeptName" value="<s:property value="project.appDeptName"/>" />
						<input type="hidden" name="project.buildCorpName" value="<s:property value="project.buildCorpName"/>" />
						<input type="hidden" name="project.buildCorpCode" value="<s:property value="project.buildCorpCode"/>" />
						<input type="hidden" name="project.appDept" value="<s:property value="project.appDept"/>" />
						</td>
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
						<td>建设单位项目负责人：</td>
						<td><s:property value="project.projectManager" /></td>
						<td>建设单位联系电话：</td>
						<td><s:property value="project.unitPhone" /></td>
					</tr>
					<tr>
						<td>总投资（万元）：</td>
						<td><s:property value="project.allInvest" /></td>
						<td>总面积（平方米）：</td>
						<td><s:property value="project.allArea" /></td>
					</tr>
					<tr>
						<td>建设性质：</td>
						<td><s:property value="project.prjPropertyName" /></td>
							<td>建设地址：</td>
						<td><s:property value="project.address" /></td>
					</tr>
					<tr>
                      	<td>建设用地规划许可证编号：</td>
						<td><s:property value="project.buldPlanNum"/></td>
                     	<td>建设工程规划许可证编号：</td>
						<td><s:property value="project.projectPlanNum"/></td>
					</tr>
					<tr>
						<td>开工日期：</td>
						<td><s:date name="project.beginDate" format="yyyy-MM-dd" /></td>
						<td>竣工日期：</td>
						<td><s:date name="project.endDate" format="yyyy-MM-dd" /></td>
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
							value="<s:property value="project.createDate" />" />
							
							</td>
					</tr>
					<tr style="height: 60px; border: 0">
						<td>审核意见：</td>
						<td colspan="3"><textarea id="appId" name="project.opinion"
								class="required"></textarea></td>
					</tr>
				</table>
				<!-- 
				<table class="sp_mtable" style="border-collapse:collapse; border:1px solid #CCC;text-align:center;">
				<s:if test="project.unitMark != null">
					<h2>单位工程</h2>
						<tr>
							<td style="text-align:center;">序号</td>
							<td style="text-align:center;">项目名称</td>
							<td style="text-align:center;">层数</td>
							<td style="text-align:center;">规模</td>
							<td style="text-align:center;">投资</td>
							<td style="text-align:center;">结构</td>
						</tr>
						<s:iterator status="i" value="currentPage.data">
							<tr>
								<td style="text-align:center;"><s:property value="#i.count" /></td>
								<td style="text-align:center;"><s:property value="prjName" /></td>
								<td style="text-align:center;"><s:property value="pliesNum" /></td>
								<td style="text-align:center;"><s:property value="prjSize" /></td>
								<td style="text-align:center;"><s:property value="prjNvest" /></td>
								<td style="text-align:center;"><s:property value="prjBuild" /></td>
							</tr>
						</s:iterator>
						</table>
						 
					
				</s:if>
				-->
				<table class="sp_mtable" style="border-collapse: collapse;">
				<h2>附件</h2>
				<s:iterator value="downloadlist" status="i">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><a href="#"
							onclick="downLoad('<s:property value="uploadId"/>')"><s:property
									value="fileFileName" /></a></td>
					</tr>
				</s:iterator>
				</table>
				<div class="sp_bton">
					<a href="#"><span class="sp_first" onclick="applythrough()">审核通过</span></a>
					<a href="#"><span class="sp_second" onclick="applyBack()">申请退回</span></a>
					<a href="#"><span class="sp_last" onclick="goBack()">取消</span></a>
				</div>
				
			</form>
		</div>
	</div>
	
<div id="table03" style="display: none">
<p align="center">工程建设项目报建表 </p>
<table border="1" width="100%" height="100%" style="border:solid 1px black;border-collapse:collapse">
  <tr>
    <td width="20%" colspan="3" ><p align="center">建设单位 </p></td>
    <td width="40%" colspan="6" ><p>&nbsp;<s:property value="project.buildCorpName" /> </p></td>
    <td width="15%" colspan="2" ><p align="center">单位性质 </p></td>
    <td width="25%" colspan="5" ><p>&nbsp; </p></td>
  </tr>
  <tr>
    <td width="20%" colspan="3" ><p align="center">工程名称 </p></td>
    <td width="80%" colspan="13" ><p>&nbsp;<s:property value="project.prjName" /></p></td>
  </tr>
  <tr>
    <td width="20%" colspan="3" ><p align="center">工程地址 </p></td>
    <td width="80%" colspan="13" ><p>&nbsp;<s:property value="project.provinceName" /><s:property value="project.cityName" /><s:property value="project.countyName" /> </p></td>
  </tr>
  <tr>
    <td width="20%" colspan="3" ><p align="center">建设性质 </p></td>
    <td width="10%" colspan="2" ><p>&nbsp;<s:property value="project.prjPropertyName" /></p></td>
    <td width="10%" ><p align="center">结构 </p></td>
    <td width="10%" ><p>&nbsp; </p></td>
    
    <td width="10%"><p align="center">层数 </p></td>
    <td width="10%"><p>&nbsp; </p></td>
    <td width="15%" colspan="2" ><p align="center">建设规模 </p></td>
    <td width="15%" colspan="5" ><p align="right">&nbsp;<s:property value="project.prjSize" /> M<sup>2 </p></td>
  </tr>
  <tr>
    <td width="20%" colspan="3" ><p align="center">投资总额 </p></td>
    <td width="30%" colspan="5" ><p align="right">&nbsp;<s:property value="project.allInvest" />万元 </p></td>
    
    <td width="20%" colspan="3" ><p align="center">当年投资 </p></td>
    <td width="30%" colspan="5" ><p align="right">万元 </p></td>
  </tr>
  <tr>
    <td width="20%" colspan="3" ><p align="center">资金来源构成 </p></td>
    <td width="80%" colspan="13" ><p align="center">国投 &nbsp;&nbsp;&nbsp;&nbsp;万元； 自筹&nbsp;&nbsp;&nbsp;&nbsp; 万元； 贷款&nbsp;&nbsp;&nbsp;&nbsp; 万元； 外资 &nbsp;&nbsp;&nbsp;&nbsp;万元 </p></td>
  </tr>
  <tr>
    <td width="20%" colspan="3" ><p align="center">资信证明 </p></td>
    <td width="80%" colspan="13" ><p>&nbsp; </p></td>
  </tr>
  <tr>
    <td width="10%" rowspan="2">
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;批 </p>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;准 </p>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;文 </p>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件 </p>
        </td>
    <td width="25%" colspan="5" >
    	<p align="center">&nbsp; </p>
       <p align="center">立项文件名称及文号</p>
       <p align="center">&nbsp; </p>
       </td>
    <td width="65%" colspan="10" ><p>&nbsp; </p>
        <p>&nbsp; <s:property value="project.prjApprovalLevelName" /><s:property value="project.prjApprovalNum" /></p>
        <p>&nbsp; </p>
        </td>
  </tr>
  <tr>
    <td width="25%" colspan="5" >
    	  <p align="center">&nbsp; </p>
        <p align="center">规划批准文件及文号 </p>
        <p align="center">&nbsp; </p>
        </td>
    <td width="65%" colspan="10" ><p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>&nbsp; </p></td>
  </tr>
  <tr>
    <td width="20%" colspan="3" ><p align="center">计划开工工期 </p></td>
    <td width="30%" colspan="4" ><p align="right"><s:date name="project.beginDate" format="yyyy-MM-dd" /></p></td>
    <td width="20%" colspan="2" ><p align="center">计划竣工日期 </p></td>
    <td width="30%" colspan="7" ><p align="right"><s:date name="project.endDate" format="yyyy-MM-dd" /></p></td>
  </tr>
  <tr>
    <td width="15%" colspan="2"><p>&nbsp; </p>
        <p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;工情 </p>
        <p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;程 </p>
        <p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;筹 </p>
        <p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;建况 </p>
        <p>&nbsp; </p></td>
    <td width="85%" colspan="14" ><p>&nbsp; </p></td>
  </tr>
  <tr>
    <td colspan="7" ><p>建设单位意见： </p>
        <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; （公章） </p>       
        <p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>经 办 人 </p>
        <p>联系电话 </p>
        <p>&nbsp; </p>
        <p align="right">年&nbsp;&nbsp; 月&nbsp;&nbsp; 日 </p></td>
    <td colspan="9" ><p>审核单位意见： </p>
        <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; （公章） </p>        
        <p>&nbsp; </p>
        <p>&nbsp; <s:property value="project.opinion" /></p>
        <p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>经 办 人 </p>
        <p>联系电话 </p>
        <p>&nbsp; </p>
        <p align="right">年 &nbsp;&nbsp;月 &nbsp;&nbsp;日 </p></td>
  </tr>
</table>
</div>		
	
	
</body>
</html>