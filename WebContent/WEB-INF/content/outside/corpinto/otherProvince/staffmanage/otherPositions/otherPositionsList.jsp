<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css">
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<title>外省企业现场管理人员</title>
<script type="text/javascript">
	//查询
	function queryConstructor()
	{
		document.form1.action="<%=basepath %>/otherPositionsAction_queryPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/otherPositionsAction_goBack.action";
		document.form1.submit();
	}
	
	//添加
	function add()
	{
		document.form1.action="<%=basepath%>/otherPositionsAction_addPage.action";
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
			<input type="hidden" id="message" value="<s:property value="message" />" />
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
	</div>
	<div class="main">
		<form id="form1" name="form1" method="post" action="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>

					<td valign="top">
						<div class="wr">

							<div class="tit">
								<img src="images/titico2.gif" /><strong>外省企业现场管理人员搜索</strong>
							</div>

							<div class="main " style="line-heigth: 24px;">
								<table width="98%" border="0" cellspacing="0" cellpadding="0"
									style="min-height: 100px;">
									<tr>
										<td width="12%"><label>人员名称：</label></td>
										<td><input type="text" name="condition.personName" class="ipu1"
											value="<s:property value="condition.personName"/>" /></td>
										<td width="12%"><label>身份证号：</label></td>
										<td><input type="text" name="condition.cardId" class="ipu1"
											value="<s:property value="condition.cardId"/>" /></td>
									</tr>
								</table>
								<table class="ry_right right">
									<tr>
										<td><input type="button" 
											class="btn" value="搜索" onclick="queryConstructor()" /></td>
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
		外省企业现场管理人员列表<img src="<%=basepath%>/images/ry_lie.png" />
		</p>
		<table class="" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>证件号码</th>
					<th>岗位名称</th>
					<th>证书编号</th>
					<th>企业名称</th>
					<th>添加日期</th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count"/> </td>
                        <td><s:property value="name"/></td>
                        <td>
                        <s:if test="sex==0">
                        	男
                        </s:if>
                        <s:else>
                        	女
                        </s:else>
                        </td>
                        <td><s:property value="cardId"/></td>
                        <td><s:property value="duty"/></td>
                        <td><s:property value="certNum"/></td>
                        <td><s:property value="entName"/></td>
						<td><s:date name="createDate" format="yyyy-MM-dd" /></td>
						<td><a
							href="otherPositionsAction_modifiedPage.action?personId=<s:property value="personId"/>"><span>修改</span></a>&nbsp;<a
							href="otherPositionsAction_delete.action?personId=<s:property value="personId"/>"><span>删除</span></a></td>

					</tr>
				</s:iterator>

			</tbody>
		</table>
		<%@include file="/WEB-INF/content/inc/page.jsp"%>
	</div>
	<%@include file="/WEB-INF/content/outside/footer.jsp"%>
	
</body>
</html>
