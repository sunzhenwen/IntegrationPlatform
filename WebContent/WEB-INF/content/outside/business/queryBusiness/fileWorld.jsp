<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>打印</title>
<%
	//取得当前Web应用的名称
	String basepath = request.getContextPath();
%>
<script type="text/javascript" src="<%=basepath%>/js/My97/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basepath%>/js/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript" src="<%=basepath%>/js/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="<%=basepath%>/js/jquery/jquery.metadata.js"></script>
<script type="text/javascript" src="<%=basepath%>/js/jquery/messages_cn.js"></script>
<script type="text/javascript" src="<%=basepath%>/js/checkbox/checkbox.js"></script>
<link rel="stylesheet" href="<%=basepath%>/css/style.css" type="text/css" >
<link rel="stylesheet" href="<%=basepath%>/css/public.css" type="text/css" >

</head>

<body>
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
	
</body>
</html>
