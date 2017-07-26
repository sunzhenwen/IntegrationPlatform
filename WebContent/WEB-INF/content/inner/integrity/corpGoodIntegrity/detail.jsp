<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业良好行为信息</title>
<script type="text/javascript" src="<%=basepath%>/js/validator.js"></script>
<script type="text/javascript">
	//查询市
	function queryCity() {
		$(document).ready(
				function() {
					//获取部门下拉列表的值
					var provinceId = $("#provinceId").val();
					$.ajax({
						url : 'corpGoodIntegrityAction_queryCity.action',
						type : 'post',
						dataType : 'json',
						data : 'provinceId=' + provinceId,
						success : function(data) {
							//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
							var items = eval("(" + data + ")");
							$("#cityId").empty();
							$("#areaId").empty();
							$("#cityId")
									.append("<option value=''>请选择</option>");
							$("#areaId")
									.append("<option value=''>请选择</option>");
							//循环items,i为循环下标,(默认i从0开始取值)
							$.each(items, function(i) {
								$("#cityId").append(
										"<option value='" + items[i].code+ "'>"
												+ items[i].name + "</option>");
							});
						}
					});
				});
	}

	//查询区
	function queryArea() {
		$(document).ready(
				function() {
					//获取部门下拉列表的值
					var cityNum = $("#cityId").val();
					$.ajax({
						url : 'corpGoodIntegrityAction_queryArea.action',
						type : 'post',
						dataType : 'json',
						data : 'cityNum=' + cityNum,
						success : function(data) {
							//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
							var items = eval("(" + data + ")");
							$("#areaId").empty();
							//循环items,i为循环下标,(默认i从0开始取值)
							$.each(items, function(i) {
								$("#areaId").append(
										"<option value='" + items[i].code+ "'>"
												+ items[i].name + "</option>");
							});
						}
					});
				});
	}
</script>
</head>

<body>

	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #3874d3;">企业良好行为信息</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="<%=basepath%>/corpGoodIntegrityAction_modifyGoodInfo.action"
				onsubmit="return validateForm()">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>企业名称：</td>
						<td><s:property value="corpGoodIntegrity.corpName"/>
						</td>
						<td>组织机构代码：</td>
						<td><s:property value="corpGoodIntegrity.corpCode"/>
						</td>
					</tr>

					<tr>
						<td>企业类型：</td>
						<td><select name="corpGoodIntegrity.certTypeNum">
								<option value="">请选择</option>
								<s:iterator value="certTypeNums">
									<option value="<s:property value="code"/>"
										<s:if test='corpGoodIntegrity.certTypeNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>

						<td>项目编号：</td>
						<td><s:property value="corpGoodIntegrity.prjNum"/></td>
					</tr>
					<tr>
						<td>工程名称：</td>
						<td><s:property value="corpGoodIntegrity.prjName"/></td>

						<td>工程地址：</td>
						<td><s:property value="corpGoodIntegrity.address"/></td>
					</tr>
					<tr>
						<td>建设单位：</td>
						<td><s:property value="corpGoodIntegrity.buildCorpName"/></td>

						<td>建设单位组织机构代码：</td>
						<td><s:property value="corpGoodIntegrity.buildCorpCode"/></td>
					</tr>
					<tr>
						<td>良好行为发生所在省：</td>
						<td><select id="provinceId"
							name="corpGoodIntegrity.provinceNum" onchange="queryCity()"
							class="required">
								<s:iterator value="provinces">
									<option value="<s:property value="code"/>"
										<s:if test='corpGoodIntegrity.provinceNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>


						<td>良好行为发生所在地市：</td>
						<td><select id="cityId" name="corpGoodIntegrity.cityNum"
							onchange="queryArea()" class="required">
								<s:iterator value="citys">
									<option value="<s:property value="code"/>"
										<s:if test='corpGoodIntegrity.cityNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>
					</tr>
					<tr>
						<td>良好行为发生所在区县：</td>
						<td><select id="areaId" name="corpGoodIntegrity.countyNum"
							class="required">
								<s:iterator value="areas">
									<option value="<s:property value="code"/>"
										<s:if test='corpGoodIntegrity.countyNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select></td>

						<td>奖励部门：</td>
						<td><s:property value="corpGoodIntegrity.awardDepartName"/></td>
					</tr>

					<tr>
						<td>奖励部门级别：</td>
						<td><select name="corpGoodIntegrity.awardDepartType"
							class="required">
								<option value="">请选择</option>
								<option value="0"
									<s:if test='corpGoodIntegrity.awardDepartType==0'>selected</s:if>>部级</option>
								<option value="1"
									<s:if test='corpGoodIntegrity.awardDepartType==1'>selected</s:if>>省市</option>
								<option value="2"
									<s:if test='corpGoodIntegrity.awardDepartType==2'>selected</s:if>>地市</option>
								<option value="3"
									<s:if test='corpGoodIntegrity.awardDepartType==3'>selected</s:if>>区县</option>
						</select></td>

						<td>奖励决定内容：</td>
						<td><s:property value="corpGoodIntegrity.awardContent"/></td>

					</tr>

					<tr>

						<td>奖励决定文号：</td>
						<td><s:property value="corpGoodIntegrity.awardNumber"/></td>
						<td>奖励日期：</td>
						<td><s:date name="corpGoodIntegrity.awardDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr>

						<td>发布开始时间：</td>
						<td><s:date name="corpGoodIntegrity.publicBDate" format="yyyy-MM-dd" /></td>
						<td>发布结束时间：</td>
						<td><s:date name="corpGoodIntegrity.publicEDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr>

						<td>审核领导：</td>
						<td><s:property value="corpGoodIntegrity.auditUserName"/></td>
						<td>审核时间：</td>
						<td><s:date name="corpGoodIntegrity.auditDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>是否发布：</td>
						<td><select name="corpGoodIntegrity.isPublic"
							class="required">
								<option value="">请选择</option>
								<option value="0"
									<s:if test='corpGoodIntegrity.isPublic==0'>selected</s:if>>未发布</option>
								<option value="1"
									<s:if test='corpGoodIntegrity.isPublic==1'>selected</s:if>>已发布</option>
						</select></td>
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
