<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css">
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<title>外省企业技术工人搜索</title>
<script type="text/javascript">
	//查询
	function querySkilledworker()
	{
		document.form1.action="<%=basepath%>/otherSkilledworkerAction_queryPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/otherSkilledworkerAction_goBack.action";
		document.form1.submit();
	}
	
	//增加
	function createSkilledworker()
	{
		document.form1.action="<%=basepath%>/otherSkilledworkerAction_createdPage.action";
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
	<input type="hidden" id="message"
		value="<s:property value="message" />" />
	<div class="ry_wrapp">
		<div class="head">
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
				<dt>当前位置：外省企业备案</dt>

			</dl>
		</div>
		<div class="main">
			<form id="form1" name="form1" method="post" action="">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>

						<td valign="top">
							<div class="wr">

								<div class="tit">
									<img src="images/titico2.gif" /><strong>外省企业技术工人搜索</strong></div>

									<div class="main " style="line-heigth: 24px;">
										<table width="98%" border="0" cellspacing="0" cellpadding="0"
											style="min-height: 100px;">
											<tr>
												<td width="12%"><label>人员名称：</label></td>
												<td><input type="text" name="condition.personName" class="ipu1"
													value="<s:property value="condition.personName"/>" /></td>
												<td width="12%"><label>证件号码：</label></td>
												<td><input type="text" name="condition.identityCard" class="ipu1"
													value="<s:property value="condition.identityCard"/>" /></td>
											</tr>
											<tr>
												<td><label>技术人员种类：</label></td>
												<td><select name="condition.skilledTypeNum" class="sel">
														<option value="">请选择</option>
														<s:iterator value="typedNums">
															<option value="<s:property value="code"/>"
																<s:if test='condition.skilledTypeNum==code'>selected</s:if>><s:property
																	value="name" /></option>
														</s:iterator>
												</select></td>
												<td><label>技术人员级别：</label></td>
												<td><select name="condition.skilledLevelNum" class="sel">
														<option value="">请选择</option>
														<s:iterator value="levelNums">
															<option value="<s:property value="code"/>"
																<s:if test='condition.skilledLevelNum==code'>selected</s:if>><s:property
																	value="name" /></option>
														</s:iterator>
												</select></td>

												<td><input type="button" onclick="querySkilledworker()"
													class="btn" value="搜索" /></td>
												<td><input type="button"
													onclick="createSkilledworker()" class="btn" value="添加" /></td>
												<td><input type="button" onclick="goBack()" class="btn"
													value="返回" /></td>
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
					外省企业技术工人列表<img src="images/ry_lie.png" />
				</p>
				<table class="" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<th>序号</th>
							<th>姓名</th>
							<th>身份证号</th>
							<th>技术工种类型</th>
							<th>证书编号</th>
							<th>修改</th>
						</tr>
						<s:iterator status="i" value="currentPage.data">
							<tr>
								<td><s:property value="#i.count" /></td>
								<td><s:property value="personName" /></td>
								<td><s:property value="identityCard" /></td>
								<td><s:property value="skilledType" /></td>
								<td><s:property value="certificateNum" /></td>
								<td><a
									href="otherSkilledworkerAction_modifiedPage.action?personId=<s:property value="personId"/>">
										<span>修改</span>
								</a>&nbsp; <a
									href="otherSkilledworkerAction_delete.action?personId=<s:property value="personId"/>">
										<span>删除</span>
								</a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<%@include file="/WEB-INF/content/inc/page.jsp"%>
			</div>
		</div>

		<%@include file="/WEB-INF/content/outside/footer.jsp"%>
	</div>
</body>
</html>
