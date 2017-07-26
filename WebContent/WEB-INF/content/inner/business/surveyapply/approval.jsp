<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报勘察项目审核</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
//附件下载
function downLoad(uploadId)
{
	document.form1.action="<%=basepath%>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=surveySuccess";
	document.form1.submit();
}
	
	//审批通过 
	function applythrough()
	{
		var nm = document.getElementById("appId");
		if(nm.value != "")
		{
			document.form1.action="<%=basepath%>/surveyApplyAction_applySuccess.action";
			document.form1.submit();
		}else
		{
			alert("请输入审核意见!");	
		}
		//prn_preview();
	}
	//申请退回
	function applyBack()
	{
		var nmv = document.getElementById("appId");
		if(nmv.value != "")
		{
			document.form1.action="<%=basepath%>/surveyApplyAction_applyFaile.action";
			document.form1.submit();
		}else
		{
			alert("请输入审核意见!");	
		}
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/surveyApplyAction_goBack.action";
		document.form1.submit();
	}
	
	//查询计划详细
	function getProject(prjNum){
		var openUrl = "<%=basepath%>/projectConstructionAction_getProjectInfo.action?prjNum="
				+ prjNum;
		openUrl = encodeURI(openUrl);
		openUrl = encodeURI(openUrl);
		window.open(openUrl)
	}
	var LODOP; //声明为全局变量 
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
		LODOP.PRINT_INIT("项目勘察确认表");
		var strHTML="<body style='margin:0;background-color: white'>"+document.getElementById("table03").innerHTML+"</body>";
		LODOP.ADD_PRINT_HTM("15mm","15mm","RightMargin:1.5cm","BottomMargin:50mm",strHTML);
		//LODOP.ADD_PRINT_HTM("15mm","15mm","RightMargin:1.5cm","BottomMargin:50mm",strHTML);
	};
	
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">勘察项目审核</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>项目编号：</td>
						<td><s:property value="project.prjNum" /> <input
							type="hidden" name="project.prjNum"
							value="<s:property value="project.prjNum"/>"><input
							type="hidden" name="project.createDate"
							value="<s:property value="project.createDate"/>"> <input
							type="hidden" name="project.appDept"
							value="<s:property value="project.appDept"/>"></td>
						<td>项目详细信息：</td>
						<td><a href="#"
							onclick="getProject('<s:property value="project.prjNum"/>')">查看详细</a>
						</td>
					</tr>

					<tr>
						<td>勘察编码：</td>
						<td><s:property value="project.surveyNum" /> <input
							type="hidden" name="project.surveyId"
							value="<s:property value="project.surveyId"/>"></td>
						<td>勘察单位名称：</td>
						<td><s:property value="project.surveyCorpName" /></td>
					</tr>
					<tr>
						<td>勘察单位组织机构代码证：</td>
						<td><s:property value="project.surveyCorpCode" /></td>
						<td>申请企业组织机构代码证：</td>
						<td><s:property value="project.applyCorpCode" /></td>
					</tr>
					<tr style="height: 60px; border: 0">
						<td>审核意见：</td>
						<td colspan="3"><textarea id="appId"
								name="project.appOpinion" class="required"></textarea></td>
					</tr>
				</table>

				<s:if test="project.unitMark != null">
					<h2>单位工程</h2>
					<table class="sp_mtable" style="border-collapse: collapse;"
						cellpadding="0" cellspacing="0">
						<tr>
							<td>序号</td>
							<td>资质类型</td>
							<td>资质等级</td>
							<td>证书编号</td>
						</tr>
						<s:iterator status="i" value="currentPage.data">
							<tr>
								<td><s:property value="#i.count" /></td>
								<td><s:property value="cretTypeName" /></td>
								<td><s:property value="titleLevelName" /></td>
								<td><s:property value="certId" /></td>
							</tr>
						</s:iterator>
					</table>
					<%@include file="/WEB-INF/content/inc/page.jsp"%>
				</s:if>
				<h2>附件</h2>
				<s:iterator value="list" status="i">
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
<p align="center">项目勘察确认表 </p>
<table border="1" width="100%" height="100%" style="border:solid 1px black;border-collapse:collapse">
  <tr>
    <td width="20%" ><p align="center">项目编号</p></td>
    <td width="80%" colspan="4" ><p>&nbsp;<s:property value="project.prjNum" /> </p></td>
  </tr>
 
   <tr>
    <td width="20%" ><p align="center">工程名称 </p></td>
    <td width="80%" colspan="4" ><p>&nbsp; </p></td>
  </tr>
  
   <tr>
    <td width="20%" ><p align="center">勘察编码</p></td>
    <td width="80%" colspan="4" ><p>&nbsp; <s:property value="project.surveyNum" /></p></td>
  </tr>
  
   <tr>
    <td width="20%" ><p align="center">建设单位名称</p></td>
    <td width="80%" colspan="4" ><p>&nbsp; </p></td>
   </tr>
  
   <tr>
    <td width="20%" ><p align="center">勘察单位名称</p></td>
    <td width="80%" colspan="4" ><p>&nbsp;<s:property value="project.surveyCorpName" /> </p></td>
  </tr>
  
	  <s:if test="project.unitMark != null">
	  <tr>
	    <td width="100%" colspan="5" ><p align="center">资质列表</p></td>
	  </tr>
	   <tr>  
	    <td width="100%" colspan="5" >
	   		 <table border="1" width="100%" height="100%" style="border:solid 1px black;border-collapse:collapse">
				<tr>
					<td><p align="center">序号</p></td>
					<td><p align="center">资质类型</p></td>
					<td><p align="center">资质等级</p></td>
					<td><p align="center">证书编号</p></td>
				</tr>
				
				<s:iterator status="i" value="currentPage.data">				
					<tr>						
					<td><p align="center">&nbsp;<s:property value="#i.count" /></p></td>
					<td><p align="center">&nbsp;<s:property value="cretTypeName" /></p></td>
					<td><p align="center">&nbsp;<s:property value="titleLevelName" /></p></td>
					<td><p align="center">&nbsp;<s:property value="certId" /></p></td>
					</tr>
				</s:iterator>					
			</table>
	    </td>
	  </tr>
	  </s:if>
  
  <tr>
    <td colspan="2" width="50%"><p>勘察单位意见：</p>
        <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; （公章） </p>       
        <p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>经 办 人 </p>
        <p>联系电话 </p>
        <p>&nbsp; </p>
        <p align="right">年&nbsp;&nbsp;&nbsp;&nbsp; 月&nbsp;&nbsp;&nbsp;&nbsp; 日 </p></td>
    <td colspan="3" width="50%"><p>审批单位意见： </p>
        <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; （公章） </p>        
        <p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>经 办 人 </p>
        <p>联系电话 </p>
        <p>&nbsp; </p>
        <p align="right">年 &nbsp;&nbsp;&nbsp;&nbsp;月 &nbsp;&nbsp;&nbsp;&nbsp;日 </p></td>
  </tr>
</table>
</div>	
	
</body>
</html>