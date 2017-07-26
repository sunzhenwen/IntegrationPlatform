<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报竣工验收审核</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
//附件下载
function downLoad(uploadId)
{
	document.form1.action="<%=basepath%>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=completeSuccess";
	document.form1.submit();
}
	
	//审核通过
	function applythrough()
	{
		var nm = document.getElementById("appId");
		if(nm.value != "")
		{
			document.form1.action="<%=basepath%>/readyApplyAction_approvalSuccess.action";
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
			document.form1.action="<%=basepath%>/readyApplyAction_approvalFailed.action";
			document.form1.submit();
		}else
		{
			alert("请输入审核意见!");	
		}
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/readyApplyAction_goBack.action";
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
		LODOP.PRINT_INIT("竣工验收审核表");
		var strHTML="<body style='margin:0;background-color: white'>"+document.getElementById("table03").innerHTML+"</body>";
		LODOP.ADD_PRINT_HTM("15mm","15mm","RightMargin:15mm","BottomMargin:15mm",strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:0.9cm","BottomMargin:9mm",strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
	};	
	
	//查询单位工程信息
	function querySingleProject(){
		var prjNum = $("#prjNum").val();
		var prjId = $("#prjId").val();
		var url = "<%=basepath %>/innerSingleProjectAction_queryPage.action?prjNum="+prjNum+"&prjId="+prjId+"&condition.prjId="+prjId+"&condition.linkName=6&linkName=6";
		var newWin=window.showModalDialog(url,window,'dialogHeight:900px;dialogWidth:1300px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">竣工验收审核</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>工程名称：</td>
						<td colspan="3" align="center" valign="middle"><div align="center"><s:property value="complete.projectName" /></div></td>
					</tr>

					<tr>
						<td>项目名称：</td>
						<td><s:property value="complete.prjName" /> <input
							type="hidden" name="complete.prjNum" id="prjNum"
							value="<s:property value="complete.prjNum"/>"> <input
							type="hidden" name="complete.completeId" id="completeId"
							value="<s:property value="complete.completeId"/>"><input
							type="hidden" name="complete.createDate"
							value="<s:property value="complete.createDate"/>"> <input
							type="hidden" name="complete.appDept"
							value="<s:property value="complete.appDept"/>">
							<input id="prjId" type="hidden" readonly name="complete.prjId" value="<s:property value="complete.prjId"/>" class="required"/>
							</td>
						<td>项目编号：</td>
						<td><s:property value="complete.prjNum" /></td>
					</tr>

					<tr>
						<td>竣工备案编号：</td>
						<td><s:property value="complete.prjFinishNum" /></td>
						<td>施工许可证编号：</td>
						<td><s:property value="complete.builderLicenceNum" /></td>
					</tr>
					<tr>
						<td>质量检测机构名称：</td>
						<td><s:property value="complete.qcCorpName" /></td>
						<td>质量检测机构组织机构代码：</td>
						<td><s:property value="complete.qcCorpCode" /></td>
					</tr>
					<tr>
						<td>实际造价(万元)：</td>
						<td><s:property value="complete.factCost" /></td>
						<td>实际面积(平方米)：</td>
						<td><s:property value="complete.factArea" /></td>
					</tr>
					<tr>
						<td>实际建设规模：</td>
						<td><s:property value="complete.factSize" /></td>
						<td>结构体系：</td>
						<td><s:if test="complete.prjStructureTypeNum==1">砖混结构</s:if>
							<s:if test="complete.prjStructureTypeNum==2">底框结构</s:if> <s:if
								test="complete.prjStructureTypeNum==3">框架结构</s:if> <s:if
								test="complete.prjStructureTypeNum==4">框架－剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==5">剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==6">板柱-剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==7">短肢墙剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==8">部分框支剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==9">框-筒体结构</s:if> <s:if
								test="complete.prjStructureTypeNum==10">筒中筒结构</s:if> <s:if
								test="complete.prjStructureTypeNum==11">异型柱框架结构</s:if> <s:if
								test="complete.prjStructureTypeNum==12">复杂高层结构</s:if> <s:if
								test="complete.prjStructureTypeNum==13">混合结构</s:if> <s:if
								test="complete.prjStructureTypeNum==14">钢结构</s:if> <s:if
								test="complete.prjStructureTypeNum==15">排架结构</s:if> <s:if
								test="complete.prjStructureTypeNum==99">其他</s:if></td>
					</tr>
					<tr>
						<td>实际开工日期：</td>
						<td><s:date name="complete.BDate" format="yyyy-MM-dd" /></td>
						<td>实际竣工验收日期：</td>
						<td><s:date name="complete.EDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>记录登记日期：</td>
						<td><s:date name="complete.createDate" format="yyyy-MM-dd" /></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					  <tr>
						<td colspan="4" align="left"><center><strong>
						<a href="#" onclick="querySingleProject()">
						单体工程(点击查看)
						</a></strong></center>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					 </tr>
					<tr style="height: 60px; border: 0">
						<td>审核意见：</td>
						<td colspan="3"><textarea id="appId"
								name="complete.appOpinion" class="required"></textarea></td>
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
<p align="center">竣工验收审核表</p>

<table border="1" width="100%" height="100%" style="border:solid 1px black;border-collapse:collapse">
 
  <tr>
    <td width="20%" ><p align="center"> 项目名称</p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:property value="complete.prjName" /></p></td>
  </tr>
   <tr>
    <td width="20%" ><p align="center"> 项目编号</p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:property value="complete.prjNum" /></p></td>
  </tr>
  <tr>
    <td width="20%" ><p align="center">竣工备案编号 </p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:property value="complete.prjFinishNum" /></p></td>
  </tr>
  <tr>
    <td width="20%" ><p align="center">施工许可证编号 </p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:property value="complete.builderLicenceNum" /></p></td>
  </tr>
  <tr>
    <td width="20%" ><p align="center">质量检测机构名称 </p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:property value="complete.qcCorpName" /></p></td>
  </tr>
  			
   <tr>
    <td width="20%"><p align="center">实际造价 </p></td>
    <td width="30%"><p>&nbsp; <s:property value="complete.factCost" /></p></td>
    <td width="20%"><p align="center">实际面积 </p></td>
    <td width="30%"><p>&nbsp; <s:property value="complete.factArea" /></p></td>
  </tr> 	
  	
 <tr>
    <td width="20%" >
    	<p align="center">&nbsp; </p>
    	<p align="center">实际建设规模</p>
    	<p align="center">&nbsp; </p>
    	</td>
    <td width="80%" colspan="3" >
    	<p>&nbsp; </p>
        <p>&nbsp; <s:property value="complete.factSize" /></p>
        <p>&nbsp; </p>
        </td>
 </tr> 	
  	
 		 
 <tr>
    <td width="20%" ><p align="center">结构体系 </p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:if test="complete.prjStructureTypeNum==1">砖混结构</s:if>
							<s:if test="complete.prjStructureTypeNum==2">底框结构</s:if> <s:if
								test="complete.prjStructureTypeNum==3">框架结构</s:if> <s:if
								test="complete.prjStructureTypeNum==4">框架－剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==5">剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==6">板柱-剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==7">短肢墙剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==8">部分框支剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==9">框-筒体结构</s:if> <s:if
								test="complete.prjStructureTypeNum==10">筒中筒结构</s:if> <s:if
								test="complete.prjStructureTypeNum==11">异型柱框架结构</s:if> <s:if
								test="complete.prjStructureTypeNum==12">复杂高层结构</s:if> <s:if
								test="complete.prjStructureTypeNum==13">混合结构</s:if> <s:if
								test="complete.prjStructureTypeNum==14">钢结构</s:if> <s:if
								test="complete.prjStructureTypeNum==15">排架结构</s:if> <s:if
								test="complete.prjStructureTypeNum==99">其他</s:if></td></p></td>
 </tr>
  
  <tr>
    <td width="20%"><p align="center">实际开工日期 </p></td>
    <td width="30%"><p>&nbsp; <s:date name="complete.BDate" format="yyyy-MM-dd" /></p></td>
    <td width="20%"><p align="center">实际竣工验收日期 </p></td>
    <td width="30%"><p>&nbsp; <s:date name="complete.EDate" format="yyyy-MM-dd" /></p></td>
  </tr> 
  
  <tr>
    <td width="20%" ><p align="center">记录登记日期 </p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:date name="complete.createDate" format="yyyy-MM-dd" /></p></td>
  </tr>

  <tr>
    <td width="50%" colspan="2" ><p>申请单位意见：</p>
        <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; （公章） </p>       
        <p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>经 办 人 </p>
        <p>联系电话 </p>
        <p>&nbsp; </p>
        <p align="right">年&nbsp;&nbsp; 月&nbsp;&nbsp; 日 </p></td>
    <td  width="50%" colspan="2" ><p>审核单位意见： </p>
        <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; （公章） </p>             
        <p>&nbsp; </p>
        <p>&nbsp; <s:property value="project.opinion" /></p>
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