<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目信息</title>
<script type="text/javascript">
	//查询
	function queryTitle()
	{
		document.form1.action="<%=basepath %>/queryProjectAction_queryPage.action";
		document.form1.submit();
	}
	function goBack() {
		document.form1.action="<%=basepath%>/queryProjectAction_goBack.action";
		document.form1.submit();
	}
</script>
<link rel="stylesheet" type="text/css" href="css/base.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<div class="ry_wrapp">

		<div class="ry_content">
			<form id="form1" name="form1" method="post" action="">
				<div class="ry_main" cellpadding="0" cellspacing="0">
					<h2>项目进度查询</h2>
            	<table class="ry_left left">
                	<tr>
                        <td>项目名称：</td>
                        <td>
                        <input type="text" name="condition.prjName" value="<s:property value="condition.prjName"/>" />
						</td>
                        <td>项目编号：</td>
                        <td>
                        <input type="text" name="condition.prjNum" value="<s:property value="condition.prjNum"/>" />
						</td>
                    </tr>
				</table>	
                <table class="ry_right left">
                	<tr>
                        <td><input type="image" src="<%=basepath %>/images/ry_look.png" onclick="queryTitle()" /></td>
                        <td><input type="image" src="<%=basepath %>/images/ry_return.png" onclick="goBack()" /></td>
                    </tr>
                </table>
				</div>
			</form>
			 <div class="ry_liebiao">
				<p class="f16 pd10 fb">项目进度查询<img src="<%=basepath %>/images/ry_lie.png" /></p>
				<table cellpadding="0" cellspacing="0">
					<tr>
						<th>序号</th>
						<th>项目名称</th>
						<th>项目编号</th>
						<th>建设单位</th>
						<th>操作</th>
					</tr>
					<s:iterator status="i" value="currentPage.data">
						<tr>
							<td><s:property value="#i.count" /></td>
							<td><s:property value="prjName" /></td>
							<td><s:property value="prjNum" /></td>
							<td><s:property value="buildCorpName" /></td>
							<td><a href="queryProjectAction_queryProjectInfo.action?prjNum=<s:property value="prjNum"/>&prjID=<s:property value="prjId"/>" target="_blank"><span>查看</span></a></td>
						</tr>
					</s:iterator>
				</table>
				<div class="ry_fenye"></div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>