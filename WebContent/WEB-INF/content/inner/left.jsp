<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<%@ page import="com.tj.jst.login.model.Login" %>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>内网左侧</title>
<script type="text/javascript">
$(function(){ 
		$(".nw_left h2:first").addClass("active"); 
		$(".nw_left ul:not(:first)").hide(); 
		$(".nw_left h2").click(function(){ 
			$(this).next("ul").slideToggle().siblings("ul").slideUp(); 
			$(this).toggleClass('nmli').siblings("h2").removeClass("nmli"); 
		}); 
	}); 
</script>
</head>	
<body>
 <%
 	Login login = (Login)session.getAttribute("login");
 	String typeNum = (String) session.getAttribute("typeNum");
 %>
<div class="nw_left">
	<div class="nmli">
        <h2>项目办理 &gt;&gt;</h2>
        <ul>
        	<%
            	if(login.getPopedomid().indexOf(",201,") >=0){
            %>
            <a href="<%=basepath %>/projectConstructionAction_queryPage.action"  target ="rightshowframe"><li>项目报建申请</li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",223,") >=0){
            %>
            <a href="<%=basepath %>/filingApplyAction_queryPage.action"  target ="rightshowframe"><li>勘察合同备案</li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",224,") >=0){
            %>
            <a href="<%=basepath %>/designFilingApplyAction_queryPage.action"  target ="rightshowframe"><li>设计合同备案</li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",225,") >=0){
            %>
            <a href="<%=basepath %>/constructionFilingApplyAction_queryPage.action"  target ="rightshowframe"><li>施工合同备案</li></a>
            <%
            	} 
            %>
            
            <%
            	if(login.getPopedomid().indexOf(",222,") >=0){
            %>
            <a href="<%=basepath %>/supervisorFilingApplyAction_queryPage.action"  target ="rightshowframe"><li>监理合同备案</li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",203,") >=0){
            %>
            <a href="http://111.40.3.210:8092/HljProjectCensorWeb/Sgtsc/ManagePrjectCensorManageFrom.aspx?id=<%=login.getLoginuserid() %>"  target ="rightshowframe"><li>施工图审查告知性备案 </li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",204,") >=0){
            %>
            <a href="<%=basepath %>/qualityApplyAction_queryPage.action"  target ="rightshowframe"><li>质量监督审核</li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",205,") >=0){
            %>
            <a href="<%=basepath %>/safetyApplyAction_queryPage.action"  target ="rightshowframe"><li>安全监督审核</li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",206,") >=0){
            %>
            <a href="<%=basepath %>/promiseApplyAction_queryPage.action"  target ="rightshowframe"><li>施工许可审批</li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",207,") >=0){
            %>
            <a href="<%=basepath %>/scenesafeAction_queryPage.action"  target ="rightshowframe"><li>现场质量安全监督审查表</li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",208,") >=0){
            %>
            <a href="<%=basepath %>/readyApplyAction_queryPage.action"  target ="rightshowframe"><li>竣工验收审核</li></a>
        	<%
            	} 
            %>
            <a href="<%=basepath %>/codeChangeAction_queryPage.action"  target ="rightshowframe"><li>组织机构代码变更(业务数据)</li></a>
        </ul>
    </div>
    
	<div class="nmli">
        <h2>项目查询 &gt;&gt;</h2>
        <ul>
        	<a href="<%=basepath %>/otherPrjConstructorAction_queryPage.action"  target ="rightshowframe"><li>外省项目备案查询</li></a>
        	<!-- 
        	<a href="<%=basepath %>/constrModifyAction_queryPage.action"  target ="rightshowframe"><li>项目报建修改</li></a>
        	 -->
        	<%
            	if(login.getPopedomid().indexOf(",201,") >=0){
            %>
            <a href="<%=basepath %>/historyAction_queryHistoryPage.action"  target ="rightshowframe"><li>项目报建申请查询</li></a>
            <%
            	} 
            %>
            <%
            	if((login.getPopedomid().indexOf(",222,") >=0)||(login.getPopedomid().indexOf(",223,") >=0)||(login.getPopedomid().indexOf(",224,") >=0)||(login.getPopedomid().indexOf(",225,") >=0)){
            %>
            <a href="<%=basepath %>/filingHistoryAction_queryHistoryPage.action"  target ="rightshowframe"><li>合同备案查询</li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",203,") >=0){
            %>
            <a href="http://111.40.3.210:8092/HljProjectCensorWeb/Sgtsc/ManagePrjectCensorManageFrom.aspx?id=<%=login.getLoginuserid() %>"  target ="rightshowframe"><li>施工图审查告知性备案 </li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",204,") >=0){
            %>
            <a href="<%=basepath %>/qualityHistoryAction_queryHistoryPage.action"  target ="rightshowframe"><li>质量监督审核查询</li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",205,") >=0){
            %>
            <a href="<%=basepath %>/safetyHistoryAction_queryHistoryPage.action"  target ="rightshowframe"><li>安全监督审核查询</li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",206,") >=0){
            %>
            <a href="<%=basepath %>/promiseHistoryAction_queryHistoryPage.action"  target ="rightshowframe"><li>施工许可审批查询</li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",208,") >=0){
            %>
            <a href="<%=basepath %>/readyHistoryAction_queryHistoryPage.action"  target ="rightshowframe"><li>竣工验收审核查询</li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",207,") >=0){
            %>
            <a href="<%=basepath %>/querscenesafeAction_querypage.action"  target ="rightshowframe"><li>现场质量安全监督查询</li></a>
        	<%
            	} 
            %>
        </ul>
    </div>
    	<div class="nmli">
        <h2>项目共享 &gt;&gt;</h2>
        <ul>
            <a href="<%=basepath %>/projectShareAction_queryPage.action"  target ="rightshowframe"><li>申请项目登记共享查询</li></a>
            <a href="<%=basepath %>/filingShareAction_queryPage.action"  target ="rightshowframe"><li>合同备案登记共享查询</li></a>
            <a href="http://111.40.3.210:8092/HljProjectCensorWeb/Sgtsc/ManagePrjectCensorManageFrom.aspx?id=<%=login.getLoginuserid() %>"  target ="rightshowframe"><li>施工图审查告知性备案 </li></a>
            <a href="<%=basepath %>/qualityShareAction_queryPage.action"  target ="rightshowframe"><li>质量监督登记共享查询</li></a>
            <a href="<%=basepath %>/safetyShareAction_queryPage.action"  target ="rightshowframe"><li>安全监督登记共享查询</li></a>
            <a href="<%=basepath %>/promiseShareAction_queryPage.action"  target ="rightshowframe"><li>施工许可登记共享查询</li></a>
            <a href="<%=basepath %>/readyShareAction_queryPage.action"  target ="rightshowframe"><li>竣工验收登记共享查询</li></a>
            <a href="<%=basepath %>/queradminscenesafeAction_querypagey.action"  target ="rightshowframe"><li>现场安全监督登记查询</li></a>
            <a href="<%=basepath %>/randomCityAction_randomCityPage.action"  target ="rightshowframe"><li>地市随机查询</li></a>
            <a href="<%=basepath %>/randomProjectAction_randomProjectPage.action"  target ="rightshowframe"><li>项目随机查询</li></a>
        </ul>
    </div>
	<div class="nmli">
        <h2>企业管理 &gt;&gt;</h2>
        <ul>
        <!-- 
            <a href="<%=basepath %>/corpFilingsAction_queryPage.action"  target ="rightshowframe"><li>企业信息备案审核</li></a>
         -->
            <a href="<%=basepath %>/queryCorpFilingsAction_queryPage.action"  target ="rightshowframe"><li>企业信息备案审核查询</li></a>
        </ul>
    </div>
    
    <div  class="nmli">
    <h2>人员备案 &gt;&gt;</h2>
        <ul>
            <a href="<%=basepath %>/constructorInfoAction_queryPage.action"  target ="rightshowframe"><li>注册人员</li></a>
            <a href="<%=basepath %>/positionInfoAction_queryPage.action"  target ="rightshowframe" ><li>岗位人员</li></a>
            <a href="<%=basepath %>/skillInfoAction_queryPage.action" target ="rightshowframe" ><li>技术工人</li></a>
            <a href="<%=basepath %>/titleInfoAction_queryPage.action" target ="rightshowframe" ><li>职称人员</li></a>
            <a href="<%=basepath %>/otherProvincePositionInfoAction_queryPage.action" target ="rightshowframe" ><li>岗位人员(外省)</li></a>
            <a href="<%=basepath %>/threeTypesPersonnelAction_queryPage.action" target ="rightshowframe" ><li>三类人员(外省)</li></a>
        </ul>
    </div>
    
    <div  class="nmli">
        <h2>诚信管理 &gt;&gt;</h2>
        <ul>
            <a href="<%=basepath %>/corpBadIntegrityAction_queryPage.action"  target ="rightshowframe"><li>企业不良信息管理</li></a>
            <a href="<%=basepath %>/corpGoodIntegrityAction_queryPage.action"  target ="rightshowframe" ><li>企业良好信息管理</li></a>
            <a href="<%=basepath %>/personBadIntegrityAction_queryPage.action" target ="rightshowframe" ><li>人员不良行为管理</li></a>
            <a href="<%=basepath %>/personGoodIntegrityAction_queryPage.action" target ="rightshowframe" ><li>人员良好行为管理</li></a>
           <%--  <a href="<%=basepath %>/queryIntegrityInfoAction_queryPage.action" target ="rightshowframe" ><li>诚信搜索</li></a> --%>
        </ul>
    </div>
    <div  class="nmli">
        <h2>诚信管理共享 &gt;&gt;</h2>
        <ul>
            <a href="<%=basepath %>/corpBadIntegrityShareAction_queryPage.action"  target ="rightshowframe"><li>企业不良信息管理</li></a>
            <a href="<%=basepath %>/corpGoodIntegrityShareAction_queryPage.action"  target ="rightshowframe" ><li>企业良好信息管理</li></a>
            <a href="<%=basepath %>/personBadIntegrityShareAction_queryPage.action" target ="rightshowframe" ><li>人员不良行为管理</li></a>
            <a href="<%=basepath %>/personGoodIntegrityShareAction_queryPage.action" target ="rightshowframe" ><li>人员良好行为管理</li></a>
           <%--  <a href="<%=basepath %>/queryIntegrityInfoAction_queryPage.action" target ="rightshowframe" ><li>诚信搜索</li></a> --%>
        </ul>
    </div>
    <%
		if((login.getPopedomid().indexOf(",209,") >=0)||(login.getPopedomid().indexOf(",210,") >=0)||(login.getPopedomid().indexOf(",211,") >=0)){
    %>
    <div  class="nmli">
        <h2>信息发布 &gt;&gt;</h2>
        <ul>
        
        	<%
            	if(login.getPopedomid().indexOf(",209,") >=0){
            %>
            <a href="<%=basepath %>/announceAction_queryPage.action"  target ="rightshowframe"><li>信息发布管理</li></a>
            <%
            	}
    		%>
    		
            <%
            	if(login.getPopedomid().indexOf(",210,") >=0){
            %>
            <a href="<%=basepath %>/industryStandardAction_queryPage.action"  target ="rightshowframe"><li>行业标准</li></a>
            <%
            	}
    		%>
    		
            <%
            	if(login.getPopedomid().indexOf(",211,") >=0){
            %>
            <!-- 
            <a href="<%=basepath %>/contractInfoAction_queryPage.action"  target ="rightshowframe"><li>合同模板</li></a>
        	 -->
        	<%
            	}
    		%>
    		
        </ul>
    </div>
    <%
            	}
    		%>
    <%
            	if(login.getPopedomid().indexOf(",212,") >=0){
            %>
    <div  class="nmli">
        <h2>企业统计报表 &gt;&gt;</h2>
        <ul>
            <a href="<%=basepath %>/queryCorpReportAction_queryPage.action"  target ="rightshowframe"><li>建筑业企业统计报表查询</li></a>
        </ul>
    </div>
    <%
            	}
    %>
    
    <div  class="nmli">
        <h2>统计分析 &gt;&gt;</h2>
        <ul>

        	<%
            	if(login.getPopedomid().indexOf(",214,") >=0){
            %>
            <a href="<%=basepath %>/constructionStatisticsAction_queryPage.action"  target ="rightshowframe"><li>项目报建统计</li></a>
			<%
            	}
    		%>
			<%
            	if(login.getPopedomid().indexOf(",215,") >=0){
            %>
			<a href="<%=basepath %>/filingCountAction_queryPage.action"  target ="rightshowframe"><li>合同备案统计(按项目类别)</li></a>
            <%
            	}
    		%>
            <%
            	if(login.getPopedomid().indexOf(",216,") >=0){
            %>
            <a href="<%=basepath %>/filingCategoryStatisticsAction_queryPage.action"  target ="rightshowframe"><li>合同备案统计(按合同类别)</li></a>
            <%
            	}
    		%>
            <%
            	if(login.getPopedomid().indexOf(",217,") >=0){
            %>
            <a href="<%=basepath %>/planCountAction_queryPage.action"  target ="rightshowframe"><li>施工图审统计</li></a>
            <%
            	}
    		%>
            <%
            	if(login.getPopedomid().indexOf(",218,") >=0){
            %>
            <a href="<%=basepath %>/qualityCountAction_queryPage.action"  target ="rightshowframe"><li>质量监督统计</li></a>
			<%
            	}
    		%>
			<%
            	if(login.getPopedomid().indexOf(",219,") >=0){
            %>
			<a href="<%=basepath %>/safetyCountAction_queryPage.action"  target ="rightshowframe"><li>安全监督手续统计</li></a>
			<%
            	}
    		%>
			<%
            	if(login.getPopedomid().indexOf(",220,") >=0){
            %>
			<a href="<%=basepath %>/permitCountAction_queryPage.action"  target ="rightshowframe"><li>施工许可统计</li></a>
            <%
            	}
    		%>
            <%
            	if(login.getPopedomid().indexOf(",221,") >=0){
            %>
            <a href="<%=basepath %>/readyCountAction_queryPage.action"  target ="rightshowframe"><li>竣工验收统计</li></a>
        	<%
            	}
    		%>
        </ul>
    </div>
    <%
            	if(login.getPopedomid().indexOf(",213,") >=0){
            %>
     <div  class="nmli">
        <h2>附件 &gt;&gt;</h2>
        <ul>
        	<a href="<%=basepath %>/accessoryAction_queryPage.action"  target ="rightshowframe"><li>附件提示</li></a>
        </ul>
     </div>
     <%
            	}
     %>
     
    <%
            	if(login.getPopedomid().indexOf(",213,") >=0){
    %>
     <div  class="nmli">
        <h2>日志 &gt;&gt;</h2>
        <ul>
        	<a href="<%=basepath %>/modifyCorpInfoLogAction_queryPage.action"  target ="rightshowframe"><li>企业信息修改日志</li></a>
        	<a href="<%=basepath %>/cityCountAction_queryCount.action"  target ="rightshowframe"><li>项目报建统计</li></a>
        </ul>
     </div>
     <%
            	}
     %>
</div>

</body>
</html>
