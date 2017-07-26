<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>合同审核</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
  
	//审核通过
	function applythrough()
	{
		var nm = document.getElementById("appId").value;
		if(nm != "")
		{
			document.form1.action="<%=basepath%>/constructionFilingApplyAction_contractBusiness.action";
			document.form1.submit();
		} else {
			alert("请输入意见!");
		}
	}
	//查询
	function goBack()
	{
		document.form1.action="<%=basepath%>/constructionFilingApplyAction_goList.action";
		document.form1.submit();
	}
	
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">合同审核</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>合同名称：</td>
						<td><s:property value="contractB.zhConName" /> 
<input type="hidden" name="contractB.conId" value="<s:property value="contractB.conId"/>">
<input type="hidden" name="contractB.createDate" value="<s:property value="contractB.createDate"/>"> 
<input type="hidden" name="contractB.recordId" value="<s:property value="contractB.recordId"/>">
<input type="hidden" name="recordId" value="<s:property value="contractB.recordId"/>">
						</td>
						<td>合同类型：</td>
						<td>
							<s:if test='contractB.conType==1'>建设工程施工合同（发改法规[2011]3018号）</s:if>
							<s:if test='contractB.conType==2'>建设工程施工合同（建市[2010]88号）</s:if>
							<s:if test='contractB.conType==3'>黑龙江省建设工程施工专业分包合同</s:if>
							<s:if test='contractB.conType==4'>黑龙江省建设工程施工劳务分包合同</s:if>
						</td>
					</tr>
					<tr>
						<td colspan="4">
	<!--**************   卓正 PageOffice 客户端代码开始    ************************-->
	<script language="javascript" type="text/javascript">

	    function ShowPrintDlg() {
	        document.getElementById("PageOfficeCtrl2").ShowDialog(4);
	    }
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
						<td><s:date name="contractB.createDate" format="yyyy-MM-dd" /></td>
						<td>合同是否锁定：</td>
						<td><select name="contractB.isLocking">
								<option value="">请选择</option>
								<option value="0" <s:if test='contractB.isLocking==0'>selected</s:if>>未锁定</option>
								<option value="1" <s:if test='contractB.isLocking==1'>selected</s:if>>锁定</option>
						</select></td>
					</tr>
					<tr style="height: 60px; border: 0">
						<td>审核意见：</td>
						<td colspan="3"><textarea id="appId" name="contractB.reason"
								class="required"></textarea></td>
					</tr>
				</table>
				<div class="sp_bton">
					<a href="#" onclick="applythrough()"><span class="sp_first">审核</span></a>
					<a href="#" onclick="goBack()"><span class="sp_last">返回</span></a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>