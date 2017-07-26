<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>现场质量安全监督审查</title>
<script type="text/javascript">
	
	//查询
	function query()
	{ 
		prjnamee=document.getElementById("prjnamee").value;
		prjnumm=document.getElementById("prjnumm").value;
		document.form1.action="<%=basepath%>/queradminscenesafeAction_querypageytj.action?prjnamee="+prjnamee+"&&prjnumm="+prjnumm;
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="libiao">
		<form id="form1" name="form1" method="post" action="">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">现场质量安全监督审查</legend>
							<p style="margin-bottom: 10px; text-align: right;">
								<a href="#" onclick="query()"><span class="lbchx">查询</span></a>
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">

								<tr>
									<td>项目名称：</td>
									<td><input id="prjnamee" type="text" name="scenesafe.prjnamee"
										value="<s:property value=""/>" /></td>
									<td>项目编号：</td>
									<td><input id="prjnumm" type="text" name="scenesafe.prjnumm"
										value="<s:property value=""/>" /></td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>

			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				onmouseover="changeto()" onmouseout="changeback()">
				<tr>
					<th>序号</th>
					<th>项目名称</th>
					<th>项目编号</th>
					<th>施工许可证号</th>
					<th>检查人</th>
					<th>检查时间</th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="prjnamee" /></td>
						<td><s:property value="prjnumm" /></td>
						<td><s:property value="builderlicencenum" /></td>
						<td><s:property value="jcporson" /></td>
						<td><s:date name="jcdate" format="yyyy-MM-dd" /></td>
						<td align='center'>
						<a href="queradminscenesafeAction_querypageback.action?permitid=<s:property value="permitid"/>">详细</a>
						 
						</td>
					</tr>
				</s:iterator>

			</table>
		</form>
	</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
	</div>
</body>
</html>