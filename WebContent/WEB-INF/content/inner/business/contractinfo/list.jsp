<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>合同信息内容</title>
<script type="text/javascript">
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/contractInfoAction_queryPage.action";
		document.form1.submit();
	}
	
	//添加
	function add()
	{
		document.form1.action="<%=basepath%>/contractInfoAction_addPage.action";
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

			<div class="ry_content">
				<form>
					<div class="ry_main" cellpadding="0" cellspacing="0">
						<h2>合同信息搜索</h2>
						<table class="ry_left left">
							
							<tr>
								<td>名称：</td>
								<td>
								<input type="text" name="condition.conName"
									value="<s:property value = "condition.conName"/>" />
								</td>
								<td>类型：</td>
								<td>
								<input type="text" name="condition.announceName"
									value="<s:property value = "condition.announceName"/>" />
								</td>
							</tr>
						</table>
						<table class="ry_right left">
							<tr>
								<td><input type="image" onclick="query()"
									src="<%=basepath%>/images/ry_look.png" /></td>
								<td><input type="image" onclick="add()"
									src="<%=basepath%>/images/tianjia.png" /></td>
							</tr>
						</table>

					</div>
				</form>
				<div class="ry_liebiao">
					<p class="f16 fb">
						合同信息列表<img src="<%=basepath%>/images/ry_lie.png" />
					</p>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>序号</th>
								<th>名称</th>
								<th>合同类别</th>
								<th>排序</th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
							<s:iterator status="i" value="currentPage.data">
								<tr>
									<td><s:property value="#i.count" /></td>
									<td><s:property value="conName" /></td>
									<td>
										<s:if test="conType==1">建设工程施工合同（发改法规[2011]3018号）</s:if> 
										<s:if test="conType==2">建设工程施工合同（建市[2010]88号）</s:if> 
										<s:if test="conType==3">黑龙江省建设工程施工专业分包合同</s:if>
										<s:if test="conType==4">黑龙江省建设工程施工劳务分包合同 </s:if> 
									</td>
									<td><s:property value="pNumber"/></td>
									<td><s:date name="createDate" format="yyyy-MM-dd" /></td>
									<td align='center'>
									<a href="contractInfoAction_modifyPage.action?conId=<s:property value="conID"/>"><span class="lbmingx">修改</span></a>
									<a href="contractInfoAction_deleteMethod.action?conId=<s:property value="conID"/>"><span class="lbmingx">删除</span></a>
									</td>
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
