<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>附件内容</title>
<script type="text/javascript">
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/accessoryAction_queryPage.action";
		document.form1.submit();
	}
	
	//添加
	function add()
	{
		document.form1.action="<%=basepath%>/accessoryAction_addPage.action";
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
		<form id="form1" name="form1" method="post" action="">
			<form>
				<div class="ry_main" cellpadding="0" cellspacing="0">
					<h2>附件信息</h2>
					<table class="ry_left left">
						<tr>
							<td>环节名称：</td>
							<td>
							<input type="text" name="condition.message"
								value="<s:property value="condition.message"/>" />
							</td>
							<td>附件提示信息：</td>
							<td>
							<select name="condition.linkNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="linkNames">
	          						<option value="<s:property value="code"/>"<s:if test='condition.linkNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select>
							</td>
						</tr>
					</table>
					<table class="ry_right left">
						<tr>
							<td><input type="image" src="<%=basepath %>/images/ry_look.png" onclick="query()" /></td>
							<td><input type="image" onclick="add()" src="<%=basepath%>/images/tianjia.png" /></td>
							
						</tr>
					</table>
				</div>
			</form>

			<div class="ry_content">
				<div class="ry_liebiao">
					<p class="f16 fb">
						附件列表<img src="<%=basepath%>/images/ry_lie.png" />
					</p>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th width="50px">序号</th>
								<th width="150px">环节名称</th>
								<th>附件提示信息</th>
								<th width="50px">附件序号</th>
								<th>操作</th>
							</tr>
							<s:iterator status="i" value="currentPage.data">
								<tr>
									<td><s:property value="#i.count" /></td>
									<td><s:property value="linkName" /></td>
									<td><s:property value="message" /></td>
									<td><s:property value="num" /></td>
									<td align='center' width="131px"><a
										href="accessoryAction_modifyPage.action?Id=<s:property value="id"/>"><span
											class="lbmingx">修改</span></a>
											<a href="accessoryAction_deleteMethod.action?Id=<s:property value="id"/>"><span
											class="lbmingx">删除</span></a>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>
