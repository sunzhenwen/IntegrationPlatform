<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>审批</title>
<script type="text/javascript">
	//查询市
	function queryCity() {
		$(document)
				.ready(
						function() {
							//获取省
							var provinceId = $("#provinceId").val();
							//执行城市ajax查询
							$
									.ajax({
										url : 'personBadIntegrityAction_queryCity.action',
										type : 'post',
										dataType : 'json',
										data : 'provinceId=' + provinceId,
										success : function(data) {
											//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
											var items = eval("(" + data + ")");
											//清空城市列表避免重复
											$("#cityId").empty();
											$("#areaId").empty();
											$("#cityId")
													.append(
															"<option value=''>请选择</option>");
											$("#areaId")
													.append(
															"<option value=''>请选择</option>");
											//获取对象中标识用于判断选中
											var cityNum = '<s:property value="personBadIntegrity.cityNum"/>';
											//循环items,i为循环下标,(默认i从0开始取值)
											$
													.each(
															items,
															function(i) {
																//如果返回列表中有与对象中标识相等的执行
																if (items[i].code == cityNum) {
																	//拼接判断默认选中
																	$("#cityId")
																			.append(
																					"<option value='" + items[i].code+ "' selected >"
																							+ items[i].name
																							+ "</option>");
																	//自动执行ajax查询区
																	$
																			.ajax({
																				url : 'personBadIntegrityAction_queryArea.action',
																				type : 'post',
																				dataType : 'json',
																				data : 'cityNum='
																						+ cityNum,
																				success : function(
																						data) {
																					//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
																					var itemss = eval("("
																							+ data
																							+ ")");
																					//循环items,i为循环下标,(默认i从0开始取值)
																					$(
																							"#areaId")
																							.empty();
																					var area = '<s:property value="personBadIntegrity.countyNum"/>';
																					$
																							.each(
																									itemss,
																									function(
																											i) {

																										if (itemss[i].code == area) {
																											$(
																													"#areaId")
																													.append(
																															"<option value='" + itemss[i].code+ "' selected >"
																																	+ itemss[i].name
																																	+ "</option>");
																										} else {
																											$(
																													"#areaId")
																													.append(
																															"<option value='" + itemss[i].code+ "' >"
																																	+ itemss[i].name
																																	+ "</option>");
																										}
																									});
																				}
																			});
																} else {
																	//如果没有清空区，让用户自己选择
																	$("#cityId")
																			.append(
																					"<option value='" + items[i].code+ "' >"
																							+ items[i].name
																							+ "</option>");
																	$("#areaId")
																			.empty();
																}

															});

										}
									});
						});
	}

	//查询区
	function queryArea() {
		$(document)
				.ready(
						function() {
							//获取部门下拉列表的值
							var cityNum = $("#cityId").val();
							$
									.ajax({
										url : 'personBadIntegrityAction_queryArea.action',
										type : 'post',
										dataType : 'json',
										data : 'cityNum=' + cityNum,
										success : function(data) {
											//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
											var items = eval("(" + data + ")");
											//循环items,i为循环下标,(默认i从0开始取值)
											$("#areaId").empty();
											var area = '<s:property value="personBadIntegrity.countyNum"/>';
											$
													.each(
															items,
															function(i) {

																if (items[i].code == area) {
																	$("#areaId")
																			.append(
																					"<option value='" + items[i].code+ "' selected >"
																							+ items[i].name
																							+ "</option>");
																} else {
																	$("#areaId")
																			.append(
																					"<option value='" + items[i].code+ "' >"
																							+ items[i].name
																							+ "</option>");
																}
															});
										}
									});
						});
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/personBadIntegrityShareAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>

<body onload="queryCity()">
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #3874d3;">企业不良行为信息</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="<%=basepath%>/personBadIntegrityAction_modify.action">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>姓名：</td>
						<td><s:property value="personBadIntegrity.personName"/></td>
						<td>证件类型：</td>
						<td><select name="personBadIntegrity.idCardTypeNum">
								<option value="">请选择</option>
								<s:iterator value="idCardTypeNums">
									<option value="<s:property value="code"/>"
										<s:if test='personBadIntegrity.idCardTypeNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>
					</tr>
					<tr>
						<td>证件号码：</td>
						<td><s:property value="personBadIntegrity.idCard18"/></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>企业名称：</td>
						<td><s:property value="personBadIntegrity.corpName"/></td>
						<td>组织机构代码：</td>
						<td><s:property value="personBadIntegrity.corpCode"/>
						</td>
					</tr>
					<tr>
						<td>人员类型：</td>
						<td><select name="personBadIntegrity.specialtyTypNum">
								<option value="">请选择</option>
								<s:iterator value="specialtyTypNums">
									<option value="<s:property value="code"/>"
										<s:if test='personBadIntegrity.specialtyTypNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>

						<td>项目编号：</td>
						<td><s:property value="personBadIntegrity.prjNum"/></td>
					</tr>

					<tr>
						<td>工程名称：</td>
						<td><s:property value="personBadIntegrity.prjName"/></td>

						<td>工程地址：</td>
						<td><s:property value="personBadIntegrity.address"/></td>
					</tr>



					<tr>
						<td>建设单位：</td>
						<td><s:property value="personBadIntegrity.buildCorpName"/></td>

						<td>建设单位组织机构代码：</td>
						<td><s:property value="personBadIntegrity.buildCorpCode"/></td>
					</tr>
					<tr>
						<td>不良行为发生所在省：</td>
						<td><select id="provinceId"
							name="personBadIntegrity.provinceNum" onchange="queryCity()"
							class="required">
								<option value="">请选择</option>
								<s:iterator value="provinces">
									<option value="<s:property value="code"/>"
										<s:if test='personBadIntegrity.provinceNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>
						<td>不良行为发生所在地市：</td>
						<td><select id="cityId" name="personBadIntegrity.cityNum"
							onchange="queryArea()" class="required">
								<option value="">请选择</option>
						</select></td>
					</tr>
					<tr>
						<td>不良行为发生所在区县：</td>
						<td><select id="areaId" name="personBadIntegrity.countyNum"
							class="required">
								<option value="">请选择</option>
						</select></td>

						<td>不良行为分类：</td>
						<td><select name="personBadIntegrity.creditClassNum">
								<option value="">请选择</option>
								<s:iterator value="creditClassNums">
									<option value="<s:property value="code"/>"
										<s:if test='personBadIntegrity.creditClassNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>
					</tr>
					<tr>
						<td>不良行为类别：</td>
						<td>
							<%-- <select name="personBadIntegrity.creditType">
									<option value="">请选择</option>
									<s:iterator value="creditType">
										<option value="<s:property value="code"/>"
											<s:if test='personBadIntegrity.creditClassNum==code'>selected</s:if>><s:property
												value="name" /></option>
									</s:iterator>
							</select> --%>
							<s:property value="personBadIntegrity.creditType"/>
						</td>
						<td>不良行为代码：</td>
						<td>
							<%-- <select name="personBadIntegrity.creditCode">
									<option value="">请选择</option>
									<s:iterator value="creditCodes">
										<option value="<s:property value="code"/>"><s:property
												value="name" /></option>
									</s:iterator>
							</select> --%>
							<s:property value="personBadIntegrity.creditCode"/>
						</td>
					</tr>
					<tr>
						<td>不良行为内容：</td>
						<td><s:property value="personBadIntegrity.content"/></td>
						<td>不良行为发生日期：</td>
						<td><s:date name="personBadIntegrity.happenDate" format="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td>处罚部门：</td>
						<td><s:property value="personBadIntegrity.punishDepartName"/></td>
						<td>处罚部门级别：</td>
						<td><select name="personBadIntegrity.punishDepartType"
							class="required">
								<option value="">请选择</option>
								<option value="0"
									<s:if test='personBadIntegrity.punishDepartType==0'>selected</s:if>>部级</option>
								<option value="1"
									<s:if test='personBadIntegrity.punishDepartType==1'>selected</s:if>>省市</option>
								<option value="2"
									<s:if test='personBadIntegrity.punishDepartType==2'>selected</s:if>>地市</option>
								<option value="3"
									<s:if test='personBadIntegrity.punishDepartType==3'>selected</s:if>>区县</option>
						</select></td>
					</tr>




					<tr>

						<td>处罚依据：</td>
						<td>
							<%-- <select name="personBadIntegrity.punishEvidence">
									<s:iterator value="puishEvidences">
										<option value="<s:property value="code"/>"><s:property
												value="name" /></option>
									</s:iterator>
							</select>  --%>
							<s:property value="personBadIntegrity.punishEvidence"/>
						</td>
						<td>处罚决定内容：</td>
						<td><s:property value="personBadIntegrity.punishContent"/></td>

					</tr>
					<tr>

						<td>处罚决定文号：</td>
						<td><s:property value="personBadIntegrity.punishNumber"/></td>
						<td>处罚日期：</td>
						<td><s:date name="personBadIntegrity.punishDate" format="yyyy-MM-dd"/></td>
					</tr>
					<tr>

						<td>处罚截止日期：</td>
						<td><s:date name="personBadIntegrity.punishEDate" format="yyyy-MM-dd"/></td>
						<td>处罚金额：</td>
						<td><s:property value="personBadIntegrity.punishMoney"/></td>
					</tr>
					<tr>
						<td>登记部门：</td>
						<td><s:property value="personBadIntegrity.departName"/>
							value="<s:property value="personBadIntegrity.departName"/>" /></td>
						<td>登记人姓名：</td>
						<td><s:property value="personBadIntegrity.userName"/>" /></td>

					</tr>
					<tr>
						<td>登记日期：</td>
						<td><s:date name="personBadIntegrity.createDate" format="yyyy-MM-dd"/>
						</td>
						<td>是否发布：</td>
						<td><select name="personBadIntegrity.isPublic"
							class="required">
								<option value="">请选择</option>
								<option value="0"
									<s:if test='personBadIntegrity.isPublic==0'>selected</s:if>>未发布</option>
								<option value="1"
									<s:if test='personBadIntegrity.isPublic==1'>selected</s:if>>已发布</option>
						</select> </td>
					</tr>
					<tr>

						<td>发布开始时间：</td>
						<td><s:date name="personBadIntegrity.publicBDate" format="yyyy-MM-dd"/></td>
						<td>发布结束时间：</td>
						<td><s:date name="personBadIntegrity.publicEDate" format="yyyy-MM-dd"/></td>
					</tr>
					<tr>

						<td>审核领导：</td>
						<td><s:property value="personBadIntegrity.auditUserName"/></td>
						<td>审核时间：</td>
						<td><s:date name="personBadIntegrity.auditDate" format="yyyy-MM-dd"/></td>
					</tr>
				</table>
				<div class="sp_bton">
					<a href="javascript:goBack()">返回上一步</a>
				</div>


			</form>
		</div>
	</div>
</body>
</html>
