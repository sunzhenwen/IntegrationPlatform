<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业组织机构代码变更</title>
<script type="text/javascript">
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/codeChangeAction_queryPage.action";
		document.form1.submit();
	}
	
	//添加
	function add()
	{
		document.form1.action="<%=basepath%>/codeChangeAction_addPage.action";
		document.form1.submit();
	}

	//操作提示信息
	function getMessage() {
		var message = document.getElementById("message").value;
		if (message == "1") {
			alert("组织机构代码,变更成功!");
		}
		if (message == "2")
		{
			alert("组织机构代码变更失败,请联系技术人员!");
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
						<h2>组织机构代码变更(业务数据)</h2>
						<table class="ry_left left">
							<tr>
							<td>起始时间：</td>
							<td align="left"><input id="time1" type="text" name="condition.startDate" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /></td>
							<td>结束时间：</td>
							<td align="left"><input id="time2" type="text" name="condition.endDate" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /></td>
                        
							</tr>
							<tr>
								<td>企业名称：</td>
								<td>
								<input type="text" name="condition.corpName"
									value="<s:property value = "condition.corpName"/>" />
								</td>
								<td>&nbsp;</td>
								<td>
								&nbsp;
								</td>
							</tr>
							<tr>
								<td colspan="4">
								<font color="red">
								<strong>
								注:请在资质系统变更组织机构代码后,在由此进行一体化业务变更。
								</strong>
								</font>
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
						组织机构代码变更列表<img src="<%=basepath%>/images/ry_lie.png" />
					</p>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>序号</th>
								<th>企业名称</th>
								<th>变更前</th>
								<th>变更后</th>
								<th>变更时间</th>
							</tr>
							<s:iterator status="i" value="currentPage.data">
								<tr>
									<td><s:property value="#i.count" /></td>
									<td><s:property value="corpName" /></td>
									<td><s:property value="oldCode" /></td>
									<td><s:property value="newCode"/></td>
									<td><s:date name="createDate" format="yyyy-MM-dd" /></td>
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
