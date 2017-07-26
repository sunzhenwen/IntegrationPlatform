<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人员良好行为信息</title>
<script type="text/javascript" src="<%=basepath%>/js/validator.js"></script>
<script type="text/javascript">
	
	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            form.submit();
	        }    
	 	});
	});
	
	//取消
	function goBack()
	{
		document.form1.action="<%=basepath%>/personGoodIntegrityAction_goBack.action";
		document.form1.submit();
	}

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
	
	//查询企业
	function queryCorp()
	{
		var url="<%=basepath %>/queryCorpsAction_queryPage.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
	
	//查询项目信息
	function queryProject()
	{
		var url="<%=basepath%>/queryProjectInfoAction_queryPage.action";
		var newWin = window
				.showModalDialog(url, window,
						'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
</script>
</head>

<body>

	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #3874d3;">人员良好行为信息</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="<%=basepath%>/personGoodIntegrityAction_addGoodInfo.action"
				onsubmit="return validateForm()">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>人员名称：</td>
						<td><input type="text" maxlength='200'
							name="personGoodIntegrity.personName" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>

						<td>证件类型：</td>
						<td><select name="personGoodIntegrity.idCardTypeNum">
								<option value="">请选择</option>
								<s:iterator value="idCardTypeNums">
									<option value="<s:property value="code"/>"
										<s:if test='personGoodIntegrity.idCardTypeNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>

					<tr>
						<td>证件号码：</td>
						<td><input type="text" maxlength='30'
							name="personGoodIntegrity.idCard18" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>

						<td>所在企业名称：</td>
						<td><input type="text" maxlength='30' id="corpName" readonly
							name="personGoodIntegrity.corpName" class="required" /><a href="#" onclick="queryCorp()">选择</a><strong><font
								color="#FF0000">*</font></strong><input id="economicNum" type="hidden" /><input id="economicName" type="hidden" /></td>
					</tr>

					<tr>
						<td>所在企业组织机构代码：</td>
						<td><input type="text" maxlength='10' id="corpCode" readonly
							name="personGoodIntegrity.corpCode" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>

						<td>人员类型：</td>
						<td><select name="personGoodIntegrity.specialtyTypeNum">
								<option value="">请选择</option>
								<s:iterator value="specialtyTypeNums">
									<option value="<s:property value="code"/>"
										<s:if test='personGoodIntegrity.specialtyTypeNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>

					<tr>
						<td>项目编号：</td>
						<td><input type="text" maxlength='30'   id="prjNum" readonly 
							name="personGoodIntegrity.prjNum" class="required" /><a href="#" onclick="queryProject()">选择</a><strong><font
								color="#FF0000">*</font></strong></td>

						<td>工程名称：</td>
						<td><input type="text" maxlength='30' id="prjName" readonly
							name="personGoodIntegrity.prjName" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>
					</tr>

					<tr>
						<td>工程地址：</td>
						<td><input type="text" maxlength='15' id="address" readonly
							name="personGoodIntegrity.address" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>

						<td>建设单位：</td>
						<td><input type="text" maxlength='15' id="buildCorpName" readonly
							name="personGoodIntegrity.buildCorpName" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>
					</tr>

					<tr>
						<td>建设单位组织机构代码：</td>
						<td><input type="text" maxlength='15' id="buildCorpCode" readonly
							name="personGoodIntegrity.buildCorpCode" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>

						<td>良好行为发生所在省：</td>
						<td><select id="provinceId"
							name="personGoodIntegrity.provinceNum" onchange="queryCity()"
							class="required">
								<option value="">请选择</option>
								<s:iterator value="provinces">
									<option value="<s:property value="code"/>"><s:property
											value="name" /></option>
								</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>

					<tr>
						<td>良好行为发生所在地市：</td>
						<td><select id="cityId" name="personGoodIntegrity.cityNum"
							onchange="queryArea()" class="required">
								<option value="">请选择</option>
						</select><strong><font color="#FF0000">*</font></strong></td>

						<td>良好行为发生所在区县：</td>
						<td><select id="areaId" name="personGoodIntegrity.countyNum"
							class="required">
								<option value="">请选择</option>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>

					<tr>
						<td>奖励部门：</td>
						<td><input type="text" maxlength='50'
							name="personGoodIntegrity.awardDepartName" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>

						<td>奖励部门级别：</td>
						<td><select name="personGoodIntegrity.awardDepartType"
							class="required">
								<option value="">请选择</option>
								<option value="0"
									<s:if test='corp.awardDepartType==0'>selected</s:if>>部级</option>
								<option value="1"
									<s:if test='corp.awardDepartType==1'>selected</s:if>>省市</option>
								<option value="2"
									<s:if test='corp.awardDepartType==2'>selected</s:if>>地市</option>
								<option value="3"
									<s:if test='corp.awardDepartType==3'>selected</s:if>>区县</option>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>

					<tr>
						<td>奖励决定内容：</td>
						<td><input type="text" maxlength='800'
							name="personGoodIntegrity.awardContent" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>

						<td>奖励决定文号：</td>
						<td><input type="text" maxlength='15'
							name="personGoodIntegrity.awardNumber" class="required" /><strong><font
								color="#FF0000">*</font></strong></td>
					</tr>

					<tr>
						<td>奖励日期：</td>
						<td><input id="time99" type="text"
							name="personGoodIntegrity.awardDate"
							onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /><strong><font
								color="#FF0000">*</font></strong></td>

						<td>是否发布：</td>
						<td><select name="personGoodIntegrity.isPublic"
							class="required">
								<option value="">请选择</option>
								<option value="0"
									<s:if test='personGoodIntegrity.isPublic==0'>selected</s:if>>未发布</option>
								<option value="1"
									<s:if test='personGoodIntegrity.isPublic==1'>selected</s:if>>已发布</option>
						</select><strong><font color="#FF0000">*</font></strong></td>
					</tr>

					<tr>
						<td>发布开始时间：</td>
						<td><input id="time1" type="text"
							name="personGoodIntegrity.publicBDate"
							onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /><strong><font
								color="#FF0000">*</font></strong></td>

						<td>发布结束时间：</td>
						<td><input id="time2" type="text"
							name="personGoodIntegrity.publicEDate"
							onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /><strong><font
								color="#FF0000">*</font></strong></td>
					</tr>

					<tr>
						<td>审核领导：</td>
						<td><input type="text" maxlength='200'
							name="personGoodIntegrity.auditUserName" /><strong><font
								color="#FF0000">*</font></strong></td>

						<td>审核时间：</td>
						<td><input id="time3" type="text"
							name="personGoodIntegrity.auditDate"
							onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /><strong><font
								color="#FF0000">*</font></strong></td>
					</tr>

				</table>
				<div class="sp_bton">
					<input type="image" src="<%=basepath%>/images/baocun.jpg" /> <input
						type="image" onclick="goBack()"
						src="<%=basepath%>/images/quxiao.jpg" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>
