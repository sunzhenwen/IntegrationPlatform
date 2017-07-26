<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css">
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<title>外省企业项目备案</title>
<script type="text/javascript">
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/otherProjectAction_queryPage.action";
		document.form1.submit();
	}
	
	//添加
	function add()
	{
		document.form1.action="<%=basepath%>/otherProjectAction_addPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/otherProjectAction_goBack.action";
		document.form1.submit();
	}

	//操作提示信息
	function getMessage() {
		var message = document.getElementById("message").value;
		if (message != "") {
			alert(message);
		}
	}
</script>
</head>

<body onload="getMessage()">
	<div class="ry_wrapp">
		<div class="head">
			<input type="hidden" id="message"
				value="<s:property value="message" />" />
			<div class="head_a1">
				<p class="logo">
					<img src="images/lg.png">
				</p>
				<div class="head_a3">
					<div class="header-search">
					</div>
				</div>
			</div>
		</div>
		<div class="wz">
			<dl>
				<dt>当前位置：外省企业项目备案</dt>

			</dl>
		</div>
	</div>
	<div class="main">
		<form id="form1" name="form1" method="post" action="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>

					<td valign="top">
						<div class="wr">

							<div class="tit">
								<img src="images/titico2.gif" /><strong>外省企业项目备案</strong>
							</div>

							<div class="main " style="line-heigth: 24px;">
								<table width="98%" border="0" cellspacing="0" cellpadding="0"
									style="min-height: 100px;">
									<tr>
										<td width="12%"><label>起始时间：</label></td>
										<td>
										<input id="time1" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" type="text" name="condition.startDate" class="ipu1" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
										</td>
										<td width="12%"><label>截止时间：</label></td>
										<td>
										<input id="time2" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" type="text" name="condition.endDate" class="ipu1" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
										</td>
									</tr>
									<tr>
										<td width="12%"><label>项目名称：</label></td>
										<td><input type="text" name="condition.prjName" class="ipu1"
											value="<s:property value="condition.prjName"/>" /></td>
										<td width="12%"><label>项目编号：</label></td>
										<td><input type="text" name="condition.prjNum" class="ipu1"
											value="<s:property value="condition.prjNum"/>" /></td>
									</tr>
								</table>
								<table class="ry_right right">
									<tr>
										<td><input type="button" 
											class="btn" value="搜索" onclick="query()" /></td>
										<td><input type="button" 
											class="btn" value="添加" onclick="add()" /></td>
										<td><input type="button" 
											class="btn" value="返回" onclick="goBack()" /></td>

									</tr>
								</table>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="ry_liebiao">
		<p class="f16 pd10 fb">
			外省企业项目备案列表<img src="<%=basepath%>/images/ry_lie.png" />
		</p>
		<table class="" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<th>序号</th>
					<th>项目名称</th>
					<th>项目编号</th>
					<th>备案日期</th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="prjName" /></td>
						<td><s:property value="prjNum" /></td>
						<td><s:date name="createDate" format="yyyy-MM-dd" /></td>
						<td>
						<a href="otherProjectAction_modifyPage.action?otherPrjId=<s:property value="otherPrjId"/>">
						<span>修改</span>
						</a>
						&nbsp;
						<a href="otherProjectAction_delete.action?otherPrjId=<s:property value="otherPrjId"/>">
						<span>删除</span>
						</a>
						&nbsp;
						<a href="otherProjectAction_delete.action?otherPrjId=<s:property value="otherPrjId"/>">
						<span>查看</span>
						</a>
						</td>

					</tr>
				</s:iterator>

			</tbody>
		</table>
		<%@include file="/WEB-INF/content/inc/page.jsp"%>
	</div>
	<%@include file="/WEB-INF/content/outside/footer.jsp"%>
	
</body>
</html>
