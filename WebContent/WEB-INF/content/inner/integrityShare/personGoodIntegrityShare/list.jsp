<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人员良好行为信息</title>
<script type="text/javascript">
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/personGoodIntegrityShareAction_queryPage.action";
		document.form1.submit();
	}
	function queryInfo()
	{
		document.form1.action="<%=basepath%>/personGoodIntegrityShareAction_queryInfoPage.action";
		document.form1.submit();
	}
	
	//增加
	function add()
	{
		document.form1.action="<%=basepath%>/personGoodIntegrityAction_addPage.action";
		document.form1.submit();
	}
	
	//返回
	function back()
	{
		document.form1.action="<%=basepath%>/queryIntegrityInfoAction_queryPage.action";
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

<body>

	<div class="ry_wrapp">
		<form id="form1" name="form1" method="post" action="">

			<div class="ry_content">
				<form>
					<div class="ry_main" cellpadding="0" cellspacing="0">
						<h2>人员良好行为信息搜索</h2>
						<table class="ry_left left">
							<tr>
								<td>登记日期：</td>
								<td colspan="3"><input id="time1"
									value="<s:date name="condition.startDate" format="yyyy-MM-dd" />"
									type="text" name="condition.startDate"
									onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
									<input id="time2"
									value="<s:date name="condition.endDate" format="yyyy-MM-dd" />"
									type="text" name="condition.endDate"
									onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</td>
							</tr>
							<tr>
								<td>人员名称：</td>
								<td><input type="text" name="condition.personName"
									value="<s:property value = "condition.personName"/>" /></td>
								<td>证件号码：</td>
								<td><input type="text" name="condition.idCard18"
									value="<s:property value = "condition.idCard18"/>" /></td>
							</tr>
							<tr>
								<td>公司名称：</td>
								<td><input type="text" name="condition.corpName"
									value="<s:property value = "condition.corpName"/>" /></td>
							</tr>
						</table>
						<table class="ry_right left">
							<tr>
								<td><s:if test="condition.personalID == 1"><input type="image" onclick="query()"
									src="<%=basepath%>/images/ry_look.png" /></s:if>
									<s:if test="condition.personalID != 1"><input type="image" onclick="queryInfo()"
									src="<%=basepath%>/images/ry_look.png" />
									</s:if>
									</td>
								<td>
								<%-- <s:if test='condition.personalID==1'><input type="image" onclick="add()"
									src="<%=basepath%>/images/tianjia.png" /></s:if> --%>
									<s:if test="condition.personalID != 1">
										<input type="image" onclick="back()"
											src="<%=basepath%>/images/ry_return.png" />
									</s:if>
									</td>
							</tr>
						</table>

					</div>
				</form>
				<div class="ry_liebiao">
					<p class="f16 fb">
						人员良好行为信息列表<img src="<%=basepath%>/images/ry_lie.png" />
					</p>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>序号</th>
								<th>人员名称</th>
								<th>人员证件号码</th>
								<th>所在企业名称</th>
								<th>工程名称</th>
								<th>奖励部门</th>
								<th>登记部门</th>
								<th>是否发布</th>
								<th>登记时间</th>
								<th>操作</th>
							</tr>

							<s:iterator status="i" value="currentPage.data">
								<tr style="font-size: x-small;">
									<td><s:property value="#i.count" /></td>
									<td><s:property value="personName" /></td>
									<td><s:property value="idCard18" /></td>
									<td><s:property value="corpName" /></td>
									<td><s:property value="prjName" /></td>
									<td><s:property value="awardDepartName" /></td>
									<td><s:property value="departName" /></td>
									<td><s:if test="isPublic==0">
							未发布
							</s:if> <s:if test="isPublic==1">
							已发布
							</s:if></td>
									<td><s:date name="createDate" format="yyyy-MM-dd" /></td>
									<td align='center'>
									<s:if test='condition.personalID==1'>
									<%-- <a href="personGoodIntegrityAction_modifyPage.action?goodCreditId=<s:property value="goodCreditId"/>"><span
											class="lbmingx">修改</span></a>&nbsp;&nbsp;<a
										href="personGoodIntegrityAction_deleteGoodInfo.action?goodCreditId=<s:property value="goodCreditId"/>"><span
											class="lbmingx">删除</span></a> --%>
											<a href="personGoodIntegrityShareAction_detailPage.action?goodCreditId=<s:property value="goodCreditId"/>"><span
											class="lbmingx">详细</span></a>
									</s:if>
									<s:if test='condition.personalID!=1'><a href="personGoodIntegrityShareAction_detailPage.action?goodCreditId=<s:property value="goodCreditId"/>"><span
											class="lbmingx">详细</span></a></s:if>
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
