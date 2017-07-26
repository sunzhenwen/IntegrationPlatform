<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>合同审核</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
	//查询
	function goBack()
	{
		document.form1.action="<%=basepath%>/constructionFilingApplyAction_goList.action";
		document.form1.submit();
	}
</script>
</head>
<body onload="HTMLDecode()">
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">合同审核历史</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>合同名称：</td>
						<td><s:property value="contract.zhConName" /> 
<input type="hidden" name="contract.conId" value="<s:property value="contract.conId"/>">
<input type="hidden" name="contract.createDate" value="<s:property value="contract.createDate"/>"> 
<input type="hidden" name="contract.recordId" value="<s:property value="contract.recordId"/>">
						</td>
						<td>合同类型：</td>
						<td><s:if test='contract.conType==1'>建设工程施工合同（发改法规[2011]3018号）</s:if>
							<s:if test='contract.conType==2'>建设工程施工合同（建市[2010]88号）</s:if> <s:if
								test='contract.conType==3'>黑龙江省建设工程施工专业分包合同</s:if> <s:if
								test='contract.conType==4'>黑龙江省建设工程施工劳务分包合同</s:if></td>
					</tr>
					<tr>
						<td colspan="4">
						<input type="hidden" name="recordId" value="<s:property value="recordId" />">
						
<!--**************   卓正 PageOffice 客户端代码开始    ************************-->
	<script language="javascript" type="text/javascript">

	    
	    function SetFullScreen() {
	        document.getElementById("PageOfficeCtrl2").FullScreen = !document.getElementById("PageOfficeCtrl2").FullScreen;
	    }
	    function AddSeal() {
	        document.getElementById("PageOfficeCtrl2").ZoomSeal.AddSeal();
	    }
	    function AddHandSign() {
	        document.getElementById("PageOfficeCtrl2").ZoomSeal.AddHandSign();
	    }
	    function VerifySeal() {
	        try
	        {
	            document.getElementById("PageOfficeCtrl2").ZoomSeal.VerifySeal();
	        }
	        catch(e)
	        {
	        }
	    }
	</script>
    <!--**************   卓正 PageOffice 客户端代码结束    ************************-->
    <div style="width:auto; height:600px;">
      <po:PageOfficeCtrl id="PageOfficeCtrl2" />
    </div>

</td>
					</tr>
					<tr>
						<td>合同创建日期：</td>
						<td><s:date name="contract.createDate" format="yyyy-MM-dd" /></td>
						<td>合同是否锁定：</td>
						<td><s:if test='contract.isLocking==0'>未锁定</s:if> <s:if
								test='contract.isLocking==1'>锁定</s:if></td>
					</tr>
					<tr>
						<td>审核日期：</td>
						<td><s:property value="contract.aDate" /></td>
						<td>&nbsp;&nbsp;</td>
						<td>&nbsp;&nbsp;</td>
					</tr>
					<tr style="height: 60px; border: 0">
						<td>审核意见：</td>
						<td colspan="3"><s:property value="contract.reason" /></td>
					</tr>
				</table>
				<div class="sp_bton">
					<a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>