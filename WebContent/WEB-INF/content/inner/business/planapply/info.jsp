<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报施工图审查审核历史查询</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/planHistoryAction_goBack.action";
		document.form1.submit();
	}
	 var LODOP; //声明为全局变量 
	 function prn_preview() 
	 {	
				CreatePrintPageAB();	
			//	LODOP.SET_PRINT_PAGESIZE(0,"210mm","297mm","");
			//	LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
				//LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
				
				LODOP.PREVIEW();
	};  
	 
	function CreatePrintPageAB() 
	{
		LODOP=getLodop();  
		LODOP.PRINT_INIT("上报施工图审查审核");
		var strHTML="<body style='margin:0;background-color: white'>"+document.getElementById("table03").innerHTML+"</body>";
		//LODOP.ADD_PRINT_HTM("10mm","10mm","RightMargin:15mm","BottomMargin:15mm",strHTML);
		LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:0.9cm","BottomMargin:9mm",strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
	};		
	
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">施工图审核历史查询</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>施工图审查合格证书编号：</td>
						<td><s:property value="plan.censorNum" /> <input
							type="hidden" name="plan.censorId"
							value="<s:property value="plan.censorId"/>"><input
							type="hidden" name="plan.createDate"
							value="<s:property value="plan.createDate"/>"> <input
							type="hidden" name="plan.appDept"
							value="<s:property value="plan.appDept"/>"></td>
						<td>项目编号：</td>
						<td><s:property value="plan.prjNum" /></td>
					</tr>

					<tr>
						<td>项目名称：</td>
						<td colspan="3"><center><s:property value="plan.prjName" /> <input type="hidden"
							name="plan.prjNum" value="<s:property value="plan.prjNum"/>"></center></td>
					</tr>
					<tr style="height: 100px; border: 0">
						<td>建设规模：</td>
						<td colspan="3"><center><s:property value="plan.prjSize" /></center></td>
					</tr>
					<tr>
						<td>施工图审查机构组织机构代码：</td>
						<td><s:property value="plan.censorCorpCode" /></td>
						<td>审查完成日期：</td>
						<td><s:date name="plan.censorEDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>施工图审查机构名称：</td>
						<td><s:property value="plan.censorCorpName" /></td>
						<td>勘察单位名称：</td>
						<td><s:property value="plan.econCorpName" /></td>
					</tr>
					<tr>
						<td>勘察单位组织机构代码：</td>
						<td><s:property value="plan.econCorpCode" /></td>
						<td>勘察单位名称2：</td>
						<td><s:property value="plan.econCorpName2" /></td>
					</tr>
					<tr>
						<td>勘察单位组织机构代码2：</td>
						<td><s:property value="plan.econCorpCode2" /></td>
						<td>勘察单位名称3：</td>
						<td><s:property value="plan.econCorpName3" /></td>
					</tr>
					<tr>
						<td>勘察单位组织机构代码3：</td>
						<td><s:property value="plan.econCorpCode3" /></td>
						<td>设计单位名称：</td>
						<td><s:property value="plan.designCorpName" /></td>
					</tr>
					<tr>
						<td>设计单位组织机构代码：</td>
						<td><s:property value="plan.designCorpCode" /></td>
						<td>设计单位名称2：</td>
						<td><s:property value="plan.designCorpName2" /></td>
					</tr>
					<tr>
						<td>设计单位组织机构代码2：</td>
						<td><s:property value="plan.designCorpCode2" /></td>
						<td>设计单位名称3：</td>
						<td><s:property value="plan.designCorpName3" /></td>
					</tr>
					<tr>
						<td>设计单位组织机构代码3：</td>
						<td><s:property value="plan.designCorpCode3" /></td>
						<td>一次审查是否通过：</td>
						<td><s:if test="plan.oneCensorIsPass == 0">不通过</s:if><s:if test="plan.oneCensorIsPass == 1">通过</s:if></td>
					</tr>
					<tr>
						<td>一次审查时违反强条数：</td>
						<td><s:property value="plan.oneCensorWfqtCount" /></td>
						<td>一次审查时违反的强条条目：</td>
						<td><s:property value="plan.oneCensorWfqtContent" /></td>
					</tr>
					<tr>
						<td>申请企业组织机构代码：</td>
						<td><s:property value="plan.applyCorpCode" /></td>
						<td>申请企业名称：</td>
						<td><s:property value="plan.applyCorpName" /></td>
					</tr>
					<tr>
						<td>审核单位：</td>
						<td><s:property value="plan.appSteffName" /></td>
						<td>审核时间：</td>
						<td><s:date name="plan.appDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr style="height: 60px; border: 0">
						<td>审核结果：</td>
						<td><s:if test="plan.appType==0">待审核</s:if> <s:if
								test="plan.appType==1">审核通过</s:if> <s:if test="plan.appType==2">审核不通过</s:if>
						</td>
						<td>审核意见：</td>
						<td colspan="3"><textarea id="appId" name="plan.appOpinion"
								class="required"><s:property value="plan.appOpinion" /></textarea></td>
					</tr>
				</table>
				<div class="sp_bton">
				    <a href="#"><span class="sp_last" onclick="prn_preview()">打印</span></a>
					<a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
				</div>
			</form>
		</div>
	</div>
<div id="table03" style="display: none">
<p align="center">施工图审查确认表</p>

<table border="1" width="100%" height="90%" style="border:solid 1px black;border-collapse:collapse">
  <tr>
    <td width="20%"><p align="center">施工图审查机构名称 </p></td>
    <td width="80%" colspan="3" ><p align="center">&nbsp; <s:property value="plan.censorCorpName" /></p></td>
  </tr>
  
  <tr>
    <td width="20%" ><p align="center"> 施工图审查合格书编号</p></td>
    <td width="80%" colspan="3" ><p align="center"><s:property value="plan.censorNum" />  </p></td>
  </tr>
  <tr>
    <td width="20%" ><p align="center">项目编号</p></td>
    <td width="80%" colspan="3" ><p align="center">&nbsp; <s:property value="plan.prjNum" /></p></td>
  </tr>
  
   <tr>
    <td width="20%" ><p align="center"> 项目名称</p></td>
    <td width="80%" colspan="3" ><p align="center">&nbsp; <s:property value="plan.prjName" /></p></td>
  </tr>
  
  
  <tr>
    <td width="20%" ><p align="center">审查完成日期 </p></td>
    <td width="80%" colspan="3" ><p align="center">&nbsp;<s:date name="plan.censorEDate" format="yyyy-MM-dd" /> </p></td>
  </tr>
  
 <tr>
    <td width="20%" >
    	<p align="center">&nbsp; </p>
    	<p align="center">建设规模</p>
    	<p align="center">&nbsp; </p>
    	</td>
    <td width="80%" colspan="3" >
    	<p>&nbsp; </p>
        <p>&nbsp; <s:property value="plan.prjSize" /></p>
        <p>&nbsp; </p>
        </td>
 </tr>   
  
 <tr>
    <td width="20%" ><p align="center"> 勘察单位名称</p></td>
    <td width="80%" colspan="3" ><p align="center">&nbsp; <s:property value="plan.econCorpName" /></p></td>
  </tr>
  <tr>
    <td width="20%" ><p align="center"> 勘察单位名称2</p></td>
    <td width="80%" colspan="3" ><p align="center">&nbsp; <s:property value="plan.econCorpName2" /></p></td>
  </tr>
  <tr>
    <td width="20%" ><p align="center"> 勘察单位名称3</p></td>
    <td width="80%" colspan="3" ><p align="center"> <s:property value="plan.econCorpName3" /></p></td>
  </tr>
  
  <tr>
    <td width="20%" ><p align="center"> 设计单位名称</p></td>
    <td width="80%" colspan="3" ><p align="center">&nbsp; <s:property value="plan.designCorpName" /></p></td>
  </tr> 
   <tr>
    <td width="20%" ><p align="center"> 设计单位名称2</p></td>
    <td width="80%" colspan="3" ><p align="center">&nbsp; <s:property value="plan.designCorpName2" /></p></td>
  </tr> 
   <tr>
    <td width="20%" ><p align="center">设计单位名称3 </p></td>
    <td width="80%" colspan="3" ><p align="center">&nbsp; <s:property value="plan.designCorpName3" /></p></td>
  </tr> 
   
  <tr>
    <td width="20%" ><p align="center">一次审查是否通过 </p></td>
    <td width="80%" colspan="3" ><p align="center">&nbsp; <s:if test="plan.oneCensorIsPass == 0">不通过</s:if><s:if test="plan.oneCensorIsPass == 1">通过</s:if></p></td>
  </tr>  
    <tr>
    <td width="20%" ><p align="center">一次审查时违反强条数</p></td>
    <td width="80%" colspan="3" ><p align="center">&nbsp; <s:property value="plan.oneCensorWfqtCount" /></p></td>
  </tr>
  <tr>
    <td width="20%" ><p align="center"> 一次审查时违反的强条条目</p></td>
    <td width="80%" colspan="3" ><p align="center">&nbsp; <s:property value="plan.oneCensorWfqtContent" /></p></td>
  </tr> 
  
  <tr>
    <td colspan="2" width="50%"><p>施工图审查机构意见： </p>
        <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; （公章） </p>       
        <p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>&nbsp; </p>
        <p>经 办 人 </p>
        <p>联系电话 </p>
        <p>&nbsp; </p>
        <p align="right">年&nbsp;&nbsp; 月&nbsp;&nbsp; 日 </p></td>
    <td  colspan="2" width="50%"><p>审核单位意见： </p>
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