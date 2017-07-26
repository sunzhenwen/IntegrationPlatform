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
										url : 'corpBadIntegrityAction_queryCity.action',
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
											var cityNum = '<s:property value="corpBadIntegrity.cityNum"/>';
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
																				url : 'corpBadIntegrityAction_queryArea.action',
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
																					var area = '<s:property value="corpBadIntegrity.countyNum"/>';
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
										url : 'corpBadIntegrityAction_queryArea.action',
										type : 'post',
										dataType : 'json',
										data : 'cityNum=' + cityNum,
										success : function(data) {
											//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
											var items = eval("(" + data + ")");
											//循环items,i为循环下标,(默认i从0开始取值)
											$("#areaId").empty();
											var area = '<s:property value="corpBadIntegrity.countyNum"/>';
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
</script>
</head>

<body onload="queryCity()">
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #3874d3;">企业不良行为信息</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="<%=basepath%>/corpBadIntegrityAction_modify.action">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>企业名称：</td>
						<td><s:property value="corpBadIntegrity.corpName"/></td>
						<td>组织机构代码：</td>
						<td><s:property value="corpBadIntegrity.corpCode"/>
						</td>
					</tr>
					<tr>
						<td>企业类型：</td>
						<td><select name="corpBadIntegrity.certTypeNum">
								<option value="">请选择</option>
								<s:iterator value="certTypeNums">
									<option value="<s:property value="code"/>"
										<s:if test='corpBadIntegrity.certTypeNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>

						<td>项目编号：</td>
						<td><s:property value="corpBadIntegrity.prjNum"/></td>
					</tr>

					<tr>
						<td>工程名称：</td>
						<td><s:property value="corpBadIntegrity.prjName"/></td>

						<td>工程地址：</td>
						<td><s:property value="corpBadIntegrity.address"/></td>
					</tr>



					<tr>
						<td>建设单位：</td>
						<td><s:property value="corpBadIntegrity.buildCorpName"/></td>

						<td>建设单位组织机构代码：</td>
						<td><s:property value="corpBadIntegrity.buildCorpCode"/></td>
					</tr>
					<tr>
						<td>不良行为发生所在省：</td>
						<td><select id="provinceId"
							name="corpBadIntegrity.provinceNum" onchange="queryCity()"
							class="required">
								<option value="">请选择</option>
								<s:iterator value="provinces">
									<option value="<s:property value="code"/>"
										<s:if test='corpBadIntegrity.provinceNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>
						<td>不良行为发生所在地市：</td>
						<td><select id="cityId" name="corpBadIntegrity.cityNum"
							onchange="queryArea()" class="required">
								<option value="">请选择</option>
						</select></td>
					</tr>
					<tr>
						<td>不良行为发生所在区县：</td>
						<td><select id="areaId" name="corpBadIntegrity.countyNum"
							class="required">
								<option value="">请选择</option>
						</select></td>

						<td>不良行为分类：</td>
						<td><select name="corpBadIntegrity.creditClassNum">
								<option value="">请选择</option>
								<s:iterator value="creditClassNums">
									<option value="<s:property value="code"/>"
										<s:if test='corpBadIntegrity.creditClassNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>
					</tr>
					<tr>
						<td>不良行为类别：</td>
						<td><select name="corpBadIntegrity.creditType">
								<option value="">请选择</option>
								<s:iterator value="creditType">
									<option value="<s:property value="code"/>"
										<s:if test='corpBadIntegrity.creditClassNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>
						<td>不良行为代码：</td>
						<td><select name="corpBadIntegrity.creditCode">
								<option value="">请选择</option>
								<s:iterator value="creditCodes">
									<option value="<s:property value="code"/>"><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>
					</tr>
					<tr>
						<td>不良行为内容：</td>
						<td><s:property value="corpBadIntegrity.content"/></td>
						<td>不良行为发生日期：</td>
						<td><s:date name="corpBadIntegrity.happenDate" format="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td>处罚部门：</td>
						<td><s:property value="corpBadIntegrity.punishDepartName"/></td>
						<td>处罚部门级别：</td>
						<td><select name="corpBadIntegrity.punishDepartType"
							class="required">
								<option value="">请选择</option>
								<option value="0"
									<s:if test='corpBadIntegrity.punishDepartType==0'>selected</s:if>>部级</option>
								<option value="1"
									<s:if test='corpBadIntegrity.punishDepartType==1'>selected</s:if>>省市</option>
								<option value="2"
									<s:if test='corpBadIntegrity.punishDepartType==2'>selected</s:if>>地市</option>
								<option value="3"
									<s:if test='corpBadIntegrity.punishDepartType==3'>selected</s:if>>区县</option>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>

					<tr>

						<td>处罚依据：</td>
						<td><select name="corpBadIntegrity.punishEvidence">
								<s:iterator value="puishEvidences">
									<option value="<s:property value="code"/>"><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>
						<td>处罚决定内容：</td>
						<td><input type="text"
							value="<s:property value="corpBadIntegrity.punishContent"/>"
							name="corpBadIntegrity.punishContent"
							class="{required:true,number:true}" /></td>

					</tr>
					<tr>

						<td>处罚决定文号：</td>
						<td><s:property value="corpBadIntegrity.punishNumber"/></td>
						<td>处罚日期：</td>
						<td><s:date name="corpBadIntegrity.punishDate" format="yyyy-MM-dd"/></td>
					</tr>
					<tr>

						<td>处罚截止日期：</td>
						<td><s:date name="corpBadIntegrity.punishEDate" format="yyyy-MM-dd"/></td>
						<td>处罚金额：</td>
						<td><s:property value="corpBadIntegrity.punishMoney"/></td>
					</tr>
					<tr>
						<td>登记部门：</td>
						<td><s:property value="corpBadIntegrity.departName"/></td>
						<td>登记人姓名：</td>
						<td><s:property value="corpBadIntegrity.userName"/></td>

					</tr>
					<tr>
						<td>登记日期：</td>
						<td><s:date name="corpBadIntegrity.createDate" format="yyyy-MM-dd"/>
						</td>
						<td>是否发布：</td>
						<td><select name="corpBadIntegrity.isPublic" class="required">
								<option value="">请选择</option>
								<option value="0"
									<s:if test='corpBadIntegrity.isPublic==0'>selected</s:if>>未发布</option>
								<option value="1"
									<s:if test='corpBadIntegrity.isPublic==1'>selected</s:if>>已发布</option>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					<tr>

						<td>发布开始时间：</td>
						<td><s:date name="corpBadIntegrity.publicBDate" format="yyyy-MM-dd"/></td>
						<td>发布结束时间：</td>
						<td><s:date name="corpBadIntegrity.publicEDate" format="yyyy-MM-dd"/></td>
					</tr>
					<tr>

						<td>审核领导：</td>
						<td><s:property value="corpBadIntegrity.auditUserName"/></td>
						<td>审核时间：</td>
						<td><s:date name="corpBadIntegrity.auditDate" format="yyyy-MM-dd"/></td>
					</tr>
				</table>
				<div class="sp_bton">
					<a href="javascript:history.go(-1)">返回上一步</a>
				</div>


			</form>
		</div>
	</div>
</body>
</html>
