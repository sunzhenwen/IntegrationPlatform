<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop2.jsp"%>
<%@ page import="com.tj.jst.login.model.Login"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>一体化平台管理</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript">
	
	//查询经过认证的企业信息
	function queryCorp()
	{
		document.form1.action="<%=basepath%>/certifiedCorpAction_modifyCorpPage.action";
		document.form1.submit();
	}
	
	
	//查询注册建造师
	function queryConstructo()
	{
		document.form1.action="<%=basepath%>/constructorAction_queryPage.action";
		document.form1.submit();
	}

	//查询岗位人员
	function queryPositions()
	{
		document.form1.action="<%=basepath%>/positionsAction_queryPage.action";
		document.form1.submit();
	}
	
	//查询技术工人
	function querySkilledworker()
	{
		document.form1.action="<%=basepath%>/skilledworkerAction_queryPage.action";
		document.form1.submit();
	}

	//职称人员
	function queryTitle()
	{
		document.form1.action="<%=basepath%>/titleAction_queryPage.action";
		document.form1.submit();
	}
	
	//操作提示信息

	function getMessage()
	{
		var message = document.getElementById("message").value;
		if(message != "")
		{
			alert(message);
		}
	}
	
	//项目报建
	function construction()
	{
		document.form1.action="<%=basepath%>/constructionAction_queryPage.action";
		document.form1.submit();
	}
	
	//勘察
	function survey()
	{
		document.form1.action="<%=basepath%>/surveyAction_queryPage.action";
		document.form1.submit();
	}
	//设计
	function design()
	{
		document.form1.action="<%=basepath%>/designAction_queryPage.action";
		document.form1.submit();
	}
	//勘察设计审图人员
	function dsStaff()
	{
		document.form1.action="<%=basepath%>/designSurveyStaffAction_queryPage.action";
		document.form1.submit();
	}
	//合同备案
	function contractRecord()
	{
		document.form1.action="<%=basepath%>/filingIndexContractFilingAction_filingIndex.action";
		document.form1.submit();
	}
	//施工图审查
	function contractCensor()
	{
		document.form1.action="<%=basepath%>/constructionPlansAction_queryPage.action";
		document.form1.submit();
	}
	//质量监督
	function qualityAction()
	{
		document.form1.action="<%=basepath%>/qualityAction_queryPage.action";
		document.form1.submit();
	}
	//安全监督
	function safetyAction()
	{
		document.form1.action="<%=basepath%>/safetyAction_queryPage.action";
		document.form1.submit();
	}
	//施工安全从业人员
	function safetyStaffAction()
	{
		document.form1.action="<%=basepath%>/safetyStaffAction_queryPage.action";
		document.form1.submit();
	}
	//施工许可
	function permitAction()
	{
		document.form1.action="<%=basepath%>/permitAction_queryPage.action";
		document.form1.submit();
	}
	//竣工备案
	function completeAction()
	{
		document.form1.action="<%=basepath%>/completeAction_queryPage.action";
		document.form1.submit();
	}
	
	//企业基本信息修改
	function modifyBasicInfo() {
		document.form1.action="<%=basepath%>/corpAction_queryCorp.action";
		document.form1.submit();
	}
	
	//建筑业企业统计报表
	function corpReport()
	{
		document.form1.action="<%=basepath%>/corpReportAction_queryPage.action";
		document.form1.submit();
	}
	//授权
	function queryAuthorization()
	{
		document.form1.action="<%=basepath%>/authorizationAction_queryPage.action";
		document.form1.submit();
	}
	//招投标
	function tenderInfo()
	{
		document.form1.action="<%=basepath%>/tenderInfoAction_queryPage.action";
		document.form1.submit();
	}
	//----------------------------查询--------------------------------------
	//项目报建
	function queryConstruction()
	{
		document.form1.action="<%=basepath%>/queryConstructionAction_queryPage.action";
		document.form1.submit();
	}
	
	//勘察
	function querySurvey()
	{
		document.form1.action="<%=basepath%>/querySurveyAction_queryPage.action";
		document.form1.submit();
	}
	//设计
	function queryDesign()
	{
		document.form1.action="<%=basepath%>/queryDesignAction_queryPage.action";
		document.form1.submit();
	}
	//合同备案
	function queryContractRecord()
	{
		document.form1.action="<%=basepath%>/queryContractFilingAction_queryPage.action";
		document.form1.submit();
	}
	//施工图审查
	function queryContractCensor()
	{
		document.form1.action="<%=basepath%>/queryConstructionPlansAction_queryPage.action";
		document.form1.submit();
	}
	//质量监督
	function queryQualityAction()
	{
		document.form1.action="<%=basepath%>/queryQualityAction_queryPage.action";
		document.form1.submit();
	}
	//安全监督
	function querySafetyAction()
	{
		document.form1.action="<%=basepath%>/querySafetyAction_queryPage.action";
		document.form1.submit();
	}
	//施工许可
	function queryPermitAction()
	{
		document.form1.action="<%=basepath%>/queryPermitAction_queryPage.action";
		document.form1.submit();
	}
	//竣工备案
	function queryCompleteAction()
	{
		document.form1.action="<%=basepath%>/queryCompleteAction_queryPage.action";
		document.form1.submit();
	}
	//查询项目进度
	function queryProjectInfo()
	{
		document.form1.action="<%=basepath%>/queryProjectAction_queryPage.action";
		document.form1.submit();
	}
	
</script>
</head>
<body onload="getMessage()"
	style="background: #fff url(images/bg1.jpg) no-repeat 0 5px; background-size: cover; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; min-width: 1366px;">

	<form id="form1" name="form1" method="post" action=""
		onsubmit='return Validate();' language='jscript'>
		<input type="hidden" name="corpCode" value='<s:property value="corpCode" />' >
		<input type="hidden" id="message" value='<s:property value="message" />' >
		<div class="ytwrapp">
			<div class="index_bottom" style="margin-top: 200px;">

				


				<div class="inb_left inba left">

					<ul>
						<li class="ywlifrist"
							style="margin-top: 30px; padding-bottom: 10px; font-size: 1.5em;">建设单位业务办理</li>
						<a href="#" onclick="construction()"><li>企业项目报建</li></a>
						<!-- 
                    <a href="#" onclick="survey()"><li>企业勘察申请</li></a>
                    <a href="#" onclick="design()"><li>企业设计申请</li></a>
                     -->
						<a href="#" onclick="tenderInfo()"><li>招投标信息(只能查看)</li></a>
						
						<a href="#" onclick="contractRecord()"><li>合同备案</li></a>
						<!-- 
						<a href="#" onclick="contractCensor()"><li>施工图审查申请</li></a>
						-->
						
						 
						
						<a href="http://111.40.3.210:8092/HljProjectCensorWeb/Sgtsc/BuildPrjectCensorManageFrom.aspx?id=<%=login.getUserId() %>"><li>施工图审查申请</li></a>
						<a href="#" onclick="qualityAction()"><li>质量监督注册</li></a>
						<a href="#" onclick="safetyAction()"><li>安全监督手续</li></a>
						<a href="#" onclick="permitAction()"><li>施工许可申请</li></a>
						<a href="#" onclick="completeAction()"><li>竣工备案申请</li></a>
						<a href="#" onclick="modifyBasicInfo()"><li>企业基本信息修改</li></a>
						
					</ul>

				</div>
				
				<div class="inb_left inbb right">

					<ul>
						<li class="ywlifrist"
							style="margin-top: 30px; padding-bottom: 10px; font-size: 1.5em;">建设单位业务查询</li>
						<a href="#" onclick="queryAuthorization()"><li>企业授权</li></a>
						<a href="#" onclick="queryProjectInfo()"><li>项目进度整体查询</li></a>
						<a href="#" onclick="queryConstruction()"><li>企业项目报建查询</li></a>
						<!-- 
                    <a href="#" onclick="querySurvey()"><li>企业勘察申请查询</li></a>
                    <a href="#" onclick="queryDesign()"><li>企业设计申请查询</li></a>
                     -->
						
						<a href="#" onclick="queryContractRecord()"><li>合同备案申请查询</li></a>
						<a href="#" onclick="queryQualityAction()"><li>质量监督申请查询</li></a>
						<a href="#" onclick="querySafetyAction()"><li>安全监督申请查询</li></a>
						<a href="#" onclick="queryPermitAction()"><li>施工许可申请查询</li></a>
						<a href="#" onclick="queryCompleteAction()"><li>竣工备案申请查询</li></a>
					</ul>
				</div>
			</div>
		</div>

	</form>

</body>
</html>