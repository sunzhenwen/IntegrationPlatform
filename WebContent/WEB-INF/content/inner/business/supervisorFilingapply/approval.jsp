<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报合同备案审查审核</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
  
//附件下载
function downLoad(uploadId)
{
	document.form1.action="<%=basepath%>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=contractFilingSuccess";
	document.form1.submit();
}
	//审核通过
	function applythrough()
	{
		var nm = document.getElementById("appId");
		if(nm.value != "")
		{
			document.form1.action="<%=basepath%>/supervisorFilingApplyAction_approvalSuccess.action";
			document.form1.submit();
		}else
		{
			alert("请输入备案意见!");	
		}
		//prn_preview();
	
	}
	//申请退回
	function applyBack()
	{
		var nmv = document.getElementById("appId");
		if(nmv.value != "")
		{
			document.form1.action="<%=basepath%>/supervisorFilingApplyAction_approvalFailed.action";
			document.form1.submit();
		}else
		{
			alert("请输入备案意见!");	
		}
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/supervisorFilingApplyAction_goBack.action";
		document.form1.submit();
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
		LODOP.PRINT_INIT("上报合同备案表");
		var strHTML="<body style='margin:0;background-color: white'>"+document.getElementById("table03").innerHTML+"</body>";
		LODOP.ADD_PRINT_HTM("15mm","15mm","RightMargin:15mm","BottomMargin:15mm",strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:0.9cm","BottomMargin:9mm",strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
	};	
	
	//企业拥有资质
	function getCertification(recordId)
	{
		window.open('<%=basepath %>/filingBusinessAction_queryPage.action?conId='+recordId)   
	}
	
	
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">监理合同备案</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>合同编号：</td>
						<td><s:property value="filing.contractNum" /> <input
							type="hidden" name="filing.recordId"
							value="<s:property value="filing.recordId"/>"><input
							type="hidden" name="filing.createDate"
							value="<s:property value="filing.createDate"/>"> <input
							type="hidden" name="filing.appDept"
							value="<s:property value="filing.appDept"/>"> <input
							value="<s:property value="filing.contractTypeNum"/>"
							type="hidden" name="filing.contractTypeNum"></td>
						<td>项目编号：</td>
						<td><s:property value="filing.prjNum" /></td>
					</tr>

					<tr>
						<td>项目名称：</td>
						<td><s:property value="filing.prjName" /> <input
							type="hidden" name="filing.prjNum"
							value="<s:property value="filing.prjNum"/>"></td>
						<td>合同备案编号：</td>
						<td><s:property value="filing.recordNum" /></td>
					</tr>
					<tr>
						<td>标段名称：</td>
						<td><s:property value="filing.sectionName" /> </td>
						<td>工程造价（万元）：</td>
						<td><s:property value="filing.projectCost" /></td>
					</tr>
					<tr>
						<td>建筑面积（平方米）：</td>
						<td><s:property value="filing.area" /> </td>
						<td>资质等级：</td>
						<td><s:property value="filing.titleLeve" /></td>
					</tr>
					<tr>
						<td>项目负责人：</td>
						<td><s:property value="filing.constructorName" /> </td>
						<td>单位联系电话：</td>
						<td><s:property value="filing.phone" /></td>
					</tr>
					<tr>
						<td>合同金额（万元）：</td>
						<td><s:property value="filing.contractMoney" /></td>
						<td>合同类别：</td>
						<td><s:property value="filing.contractTypeName" /></td>
					</tr>
					<s:if test="filing.contractTypeNum==302"><tr><td>总包合同备案编号：</td>
						<td><s:property value="filing.mainRecordNum" /></td><td></td><td></td></tr></s:if>
					<s:if test="filing.contractTypeNum==303"><tr><td>总包合同备案编号：</td>
						<td><s:property value="filing.mainRecordNum" /></td><td></td><td></td></tr></s:if>
					<tr>
						<td>合同签订日期：</td>
						<td><s:date name="filing.contractDate" format="yyyy-MM-dd" /></td>
						<td>发包单位名称：</td>
						<td><s:property value="filing.propietorCorpName" /></td>
					</tr>
					<tr>
						<td>发包单位组织机构代码：</td>
						<td><s:property value="filing.propietorCorpCode" /></td>
						<td>承包单位名称：</td>
						<td><s:property value="filing.contractorCorpName" /></td>
					</tr>
					<tr>
						<td>承包单位组织机构代码：</td>
						<td><s:property value="filing.contractorCorpCode" /></td>
						<td>联合体承包单位名称：</td>
						<td><s:property value="filing.unionCorpName" /></td>
					</tr>
					<tr>
						<td>联合体承包组织机构代码：</td>
						<td><s:property value="filing.unionCorpCode" /></td>
						<td>记录登记时间：</td>
						<td><s:date name="filing.createDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>申请企业组织机构代码：</td>
						<td><s:property value="filing.applyCorpCode" /></td>
						<td>申请企业名称：</td>
						<td><s:property value="filing.applyCorpName" /></td>
					</tr>
					
					<s:if test="filing.contractTypeNum.contains('30')">
					<tr style="height: 50px; border: 0">
						<td>合同：</td>
						<td colspan="3"><a href="#" onclick="getCertification('<s:property value="filing.recordId"/>')">详细查看</a></td>
					</tr>
					</s:if>
					
					<tr style="height: 100px; border: 0">
						<td>建设规模：</td>
						<td colspan="3"><s:property value="filing.prjSize" /></td>
					</tr>
					
					<tr style="height: 60px; border: 0">
						<td>备案意见：</td>
						<td colspan="3"><textarea id="appId" name="filing.appOpinion"
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
					<a href="#"><span class="sp_first" onclick="applythrough()">备案通过</span></a>
					<a href="#"><span class="sp_second" onclick="applyBack()">备案退回</span></a>
					<a href="#"><span class="sp_last" onclick="goBack()">取消</span></a>
				</div>
			</form>
		</div>
	</div>
	
<div id="table03" style="display: none">
<p align="center">合同备案确认表</p>

<table border="1" width="100%" height="100%" style="border:solid 1px black;border-collapse:collapse">
  
  <tr>
    <td width="20%" ><p align="center"> 合同备案编号</p></td>
    <td width="80%" colspan="3" ><p>&nbsp; </p></td>
  </tr>
  
  <tr>
    <td width="20%" ><p align="center">项目编号 </p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:property value="filing.prjNum" /></p></td>
  </tr>
  <tr>
    <td width="20%" ><p align="center">合同编号 </p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:property value="filing.contractNum" /></p></td>
  </tr>
  <tr>
    <td width="20%" ><p align="center">合同类别 </p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:property value="filing.contractTypeName" /></p></td>
  </tr>
  			
    <tr>
    <td width="20%" ><p align="center">合同金额（万元） </p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:property value="filing.contractMoney" /></p></td>
  </tr>			
  			
 <tr>
    <td width="20%" >
    	<p align="center">&nbsp; </p>
    	<p align="center">建设规模</p>
    	<p align="center">&nbsp; </p>
    	</td>
    <td width="80%" colspan="3" >
    	<p>&nbsp; </p>
        <p>&nbsp; <s:property value="filing.prjSize" /></p>
        <p>&nbsp; </p>
        </td>
 </tr> 	
  	
  <tr>
    <td width="20%" ><p align="center"> 合同签订日期</p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:date name="filing.contractDate" format="yyyy-MM-dd" /></p></td>
  </tr>		 		 
  <tr>
    <td width="20%" ><p align="center"> 发包单位名称</p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:property value="filing.propietorCorpName" /></p></td>
  </tr>	
  
  <tr>
    <td width="20%" ><p align="center"> 承包单位名称</p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:property value="filing.contractorCorpName" /></p></td>
  </tr>
  
  <tr>
    <td width="20%" ><p align="center"> 联合体承包单位名称</p></td>
    <td width="80%" colspan="3" ><p>&nbsp; <s:property value="filing.unionCorpName" /></p></td>
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
    <td  width="50%" colspan="2" ><p>备案单位意见： </p>
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