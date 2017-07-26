<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%
	//取得当前Web应用的名称
	String basepath = request.getContextPath();
%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basepath %>/login-img/login-style.css" rel="stylesheet" type="text/css" />
<title>企业合同备案申请</title>
<script type="text/javascript">

	//勘察
	function querySurvey()
	{
		document.form1.action="<%=basepath%>/surveyContractFilingAction_queryPage.action";
		document.form1.submit();
	}
	
	
	
	
	
	//设计
	function queryDesign()
	{
		document.form1.action="<%=basepath%>/designContractFilingAction_queryPage.action";
		document.form1.submit();
	}
	
	//监理
	function querySupervisor()
	{
		document.form1.action="<%=basepath%>/supervisorContractFilingAction_queryPage.action";
		document.form1.submit();
	}
	
	//施工合同备案
	function queryConstruction()
	{
		document.form1.action="<%=basepath%>/filingIndexContractFilingAction_constructionFiling.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/contractFilingAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>

<body>

	<div class="warp">
		<div class="logo">
			<img src="login-img/logo.png" />
		</div>

		<div class="w800">

         <form  name="form1" method="post" action="">
			<div class="fr login">

				<ul>
					<li><a href="#" onclick="querySurvey()">勘察合同备案</a></li>
					<li><a href="#" onclick="queryDesign()">设计合同备案</a></li>
					<li><a href="#" onclick="querySupervisor()">监理合同备案</a></li>
					<li><a href="#" onclick="queryConstruction()">施工合同备案</a></li>

				</ul>
			</div>
		</form>	
			
		</div>
	</div>
	<div class="bot">Copyright ? 2015 版权所有 黑龙江住房和城乡建设部建筑市场监管司
		技术支持：建设厅信息中心 哈尔滨天健高新技术有限公司 建议使用 IE 8及以上，1366*768及以上分辨率浏览</div>

	<script type="text/javascript" src="js/jquery.js"></script>

	<!--[if lte IE 6]>
<script src="js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('*');
    </script>
<![endif]-->
</body>
</html>

