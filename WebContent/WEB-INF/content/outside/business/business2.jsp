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

	//查询外省岗位人员
	function queryOtherPositions()
	{
		document.form1.action="<%=basepath%>/queryOtherPositionsAction_queryPage.action";
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
	//查询企业拥有资质 
	function queryCert()
	{
		document.form1.action="<%=basepath%>/queryCorpCertAction_queryPage.action";
		document.form1.submit();
	}
	//查询企业诚信信息
	function queryCredAction()
	{
		document.form1.action="<%=basepath%>/queryCredAction_query.action";
		document.form1.submit();
	}
	//三类人员
	function queryThreeTypePerson()
	{
		document.form1.action="<%=basepath%>/threePersonAction_queryPage.action";
		document.form1.submit();
	}
	
	
	
	
	
</script>
</head>
<body onload="getMessage()"
	style="background:#fff url(images/bg2.jpg) no-repeat top;background-size:cover;-webkit-background-size: cover;-moz-background-size: cover;
 -o-background-size: cover; min-width:1366px;">

	<form id="form1" name="form1" method="post" action=""
		onsubmit='return Validate();' language='jscript'>
		

			<div class="ytwrapp" >
   <div class="index_bottom" style="width:1140px;margin-top:228px;">
					 <div class="inb_left inb_left_hyqy inba left" >

						<ul>
							<li class="ywlifrist" style="margin-top:30px;padding-bottom:10px;font-size:1.5em;color:#ff0000;">单位人员管理</li>
							<a href="#" onclick="queryConstructo()"><li>注册执业人员(自动获取)</li></a>
							<%
								if("230000".equals(provinceNum))
								{
							%>
							<a href="#" onclick="queryPositions()"><li>现场管理人员(自动获取)</li></a>
							<%
								}else{
							%>
							<a href="#" onclick="queryOtherPositions()"><li>现场管理人员(自动获取)</li></a>
							<a href="#" onclick="queryThreeTypePerson()"><li>三类人员(查看)</li></a>
							<%
								}
							%>
							<a href="#" onclick="querySkilledworker()"><li>技术工人(企业填报)</li></a>
							<a href="#" onclick="queryTitle()"><li>技术职称人员(企业填报)</li></a>
							<a href="#" onclick="queryCert()"><li>行业企业拥有资质</li></a>
							<a href="#" onclick="corpReport()"><li>建筑业企业统计报表</li></a>
						</ul>

					</div>
				 <div class="inb_left inb_left_hyqy inba left">

					<ul>
						<li class="ywlifrist" style="margin-top:30px;padding-bottom:10px;font-size:1.5em;color:#ff0000;">行业企业业务办理</li>
						<a href="#" onclick="contractRecord()"><li>合同备案</li></a>
						<a href="http://111.40.3.210:8092/HljProjectCensorWeb/Sgtsc/CorpPrjectCensorManageFrom.aspx?Type=3&id=<%=login.getUserId() %>"><li>施工图审查结果备案</li></a>
						<a href="http://111.40.3.210:8092/HljProjectCensorWeb/Sgtsc/CorpPrjectCensorManageFrom.aspx?Type=1&id=<%=login.getUserId() %>"><li>施工图审查勘察人员补报</li></a>
						<a href="http://111.40.3.210:8092/HljProjectCensorWeb/Sgtsc/CorpPrjectCensorManageFrom.aspx?Type=2&id=<%=login.getUserId() %>"><li>施工图审查设计人员补报</li></a>

						<a href="#" onclick="qualityAction()"><li>质量监督注册</li></a>
						<a href="#" onclick="safetyAction()"><li>安全监督手续</li></a>
						<!-- 
						<a href="#" onclick="permitAction()"><li>施工许可申请</li></a>
						<a href="#" onclick="completeAction()"><li>竣工备案申请</li></a>
						 -->
					</ul>

				</div>
				
				<div class="inb_left inb_left_hyqy inbb right">
					<ul>
						<li class="ywlifrist" style="margin-top:30px;padding-bottom:10px;font-size:1.5em;color:#ff0000;">行业企业业务查询</li>
						<a href="#" onclick="queryProjectInfo()"><li>项目进度整体查询</li></a>
						<a href="#" onclick="queryContractRecord()"><li>合同备案申请查询</li></a>
						<!-- <a href="#" onclick="queryContractCensor()"><li>施工图审查申请查询</li></a> -->
						<a href="#" onclick="queryQualityAction()"><li>质量监督申请查询</li></a>
						<a href="#" onclick="querySafetyAction()"><li>安全监督申请查询</li></a>
						<a href="#" onclick="queryCredAction()"><li>企业诚信信息查询</li></a>
						<!-- 
						<a href="#" onclick="queryPermitAction()"><li>施工许可申请查询</li></a>
						<a href="#" onclick="queryCompleteAction()"><li>竣工备案申请查询</li></a>
						 -->
					</ul>
				</div>
			</div>
		</div>
		
	</form>
	
</body>
</html>