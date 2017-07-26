<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%
	//取得当前Web应用的名称
	String basepath = request.getContextPath();
%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业施工合同备案申请 </title>
<link href="<%=basepath %>/login-img/login-style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

	//市建
	function queryContractor()
	{
		document.form1.action="<%=basepath %>/theContractorAction_queryPage.action";
		document.form1.submit();
	}
	
	//发改法规
	function queryReform()
	{
		document.form1.action="<%=basepath %>/reformAction_queryPage.action";
		document.form1.submit();
	}
	
	//劳务分包
	function querySubPackage()
	{
		document.form1.action="<%=basepath %>/subPackageAction_queryPage.action";
		document.form1.submit();
	}

	//专业分包
	function queryLabourServices()
	{
		document.form1.action="<%=basepath %>/labourServicesAction_queryPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/filingIndexContractFilingAction_filingIndex.action";
		document.form1.submit();
	}

	
</script>
</head>

<body>
<form id="form1" name="form1" method="post" action="">
<div class="warp">
	<div class="logo"><img src="login-img/logo.png" /></div>
      
      <div class="w800">
  
            
            <div class="fr login">
            	
            	<ul>
                        <li><a href="#" onclick="queryContractor()">建设工程施工合同（建市[2010]88号</a></li>
						<li><a href="#" onclick="queryReform()">建设工程施工合同（发改法规[2011]3018号</a></li>
                  		<li><a href="#" onclick="querySubPackage()">专业分包</a></li>
                        <li><a href="#" onclick="queryLabourServices()">劳务分包</a></li>
                       
                  </ul>
            </div>
      </div>
</div>

<div class="bot">Copyright ? 2015 版权所有 黑龙江住房和城乡建设部建筑市场监管司
技术支持：建设厅信息中心 哈尔滨天健高新技术有限公司
建议使用 IE 8及以上，1366*768及以上分辨率浏览

</div>

<script type="text/javascript" src="<%=basepath%>/js/jquery/jquery-1.7.1.js"></script>

<!--[if lte IE 6]>
<script src="js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('*');
    </script>
<![endif]-->
</form>
</body>
</html>
