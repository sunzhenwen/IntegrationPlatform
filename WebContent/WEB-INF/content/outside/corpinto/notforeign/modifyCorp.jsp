<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css">
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<title>新企业录入表</title>
<script type="text/javascript">
	
	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            var check = /^([1-9]\d*|0)(\.\d*[1-9])?$/; 
	 			var regPrin = $("#regPrin").val();
				var fact = $("#fact").val();
				var assets = $("#assets").val();
	 			if (!check.exec(regPrin)) 
	 			{
	 				alert("注册资本不能为负数!");
	 			}else if(!check.exec(fact))
	 			{
	 				alert("实收资本不能为负数!");
	 			}else if(!check.exec(assets))
				{
					alert("净资产不能为负数!");
				}else if ($(":checkbox:checked").size() == 0)
				{
					alert("请至少选择一个企业类型!");
				}
	 			else
				{
					form.submit();
				}
	 		}  
	 	});
	});
	
	function checkMaxInput(txt)

	{
	       if (txt.value.length > 500)
	       txt.value = txt.value.substring(0, 500);
	}
	
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/corpAction_goBack1.action";
		document.form1.submit();
	}

	//查询市
	function queryCity() {
		$(document).ready(
			function() {
				//获取省
				var provinceId = $("#provinceId").val();
				//执行城市ajax查询
				$.ajax({
					url : 'corpAction_queryCity.action',
					type : 'post',
					dataType : 'json',
					data : 'provinceId=' + provinceId,
					success : function(data) {
						//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
						var items = eval("(" + data + ")");
						//清空城市列表避免重复
						$("#cityId").empty();
						$("#areaId").empty();
						$("#cityId").append("<option value=''>请选择</option>");
						$("#areaId").append("<option value=''>请选择</option>");
						//获取对象中标识用于判断选中
						var cityNum = '<s:property value="corp.cityNum"/>';
						//循环items,i为循环下标,(默认i从0开始取值)
						$.each(items,function(i) {
							//如果返回列表中有与对象中标识相等的执行
							if (items[i].code == cityNum) {
								//拼接判断默认选中
								$("#cityId").append("<option value='" + items[i].code+ "' selected >"+ items[i].name+ "</option>");
								//自动执行ajax查询区
								$.ajax({
									url : 'corpAction_queryArea.action',
									type : 'post',
									dataType : 'json',
									data : 'cityNum='+ cityNum,
									success : function(data) {
										//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
										var itemss = eval("("+ data + ")");
										//循环items,i为循环下标,(默认i从0开始取值)
										$("#areaId").empty();
										var area = '<s:property value="corp.countyNum"/>';
										$.each(itemss,function(i) {

											if (itemss[i].code == area) {
												$("#areaId").append("<option value='" + itemss[i].code+ "' selected >"+ itemss[i].name+ "</option>");
											} else {
												$("#areaId").append("<option value='" + itemss[i].code+ "' >"+ itemss[i].name+ "</option>");
											}
										});
									}
								});
							} else {
								//如果没有清空区，让用户自己选择
								$("#cityId").append("<option value='" + items[i].code+ "' >"+ items[i].name+ "</option>");
								$("#areaId").empty();
							}
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
						url : 'corpAction_queryArea.action',
						type : 'post',
						dataType : 'json',
						data : 'cityNum=' + cityNum,
						success : function(data) {
							//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
							var items = eval("(" + data + ")");
							//循环items,i为循环下标,(默认i从0开始取值)
							$("#areaId").empty();
							var area = '<s:property value="corp.countyNum"/>';
							$.each(items, function(i) {

								if (items[i].code == area) {
									$("#areaId").append(
											"<option value='" + items[i].code+ "' selected >"
													+ items[i].name
													+ "</option>");
								} else {
									$("#areaId").append(
											"<option value='" + items[i].code+ "' >"
													+ items[i].name
													+ "</option>");
								}
							});
						}
					});
				});
	}

	function checkForeignCorp() {
		var node = $("#checkForeign").val();
		if (node == "0") {

			$('#foreignCorpName').show();
			$('#percentTage').show();
		} else {
			$('#foreignCorpName').hide();
			$('#percentTage').hide();
		}
	}
</script>
</head>
<body onload="queryCity(),checkForeignCorp()">
	<form id="form1" name="form1" method="post" action="<%=basepath%>/corpAction_modifyCorp.action">
		<div class="qy_wrapp">
			<div class="head">
				<div class="head_a1">
					<p class="logo">
						<img src="images/lg.png">
					</p>
					<div class="head_a3">
						<div class="header-search">
							<a href="#">收藏本站</a> | <a href="#">联系我们</a>| <a href="#">安全退出</a>
						</div>
					</div>
				</div>
			</div>
			<div class="wz">
				<dl>
					<dt>当前位置：系统首页</dt>
				</dl>
			</div>

			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td valign="top">
						<div class="wr">
							<div class="tit">
								<img src="images/titico1.gif" /><strong>新企业基本信息修改表</strong>
								<!-- <p>
									注：标记为（<span class="red">*</span>）的为必填项
								</p> -->
							</div>
							<div class="main h384">
								<div class="list g2">
									<table id="tb" width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="15%"><label>企业名称：</label></td>
											<td width="37%">
											<input type="text" maxlength='200' value="<s:property value="corp.corpName" />" name="corp.corpName" class="required ipu1" />
											<strong><font color="#FF0000">*</font></strong> 
											<input type="hidden" value="<s:property value="corp.corpId" />" name="corp.corpId" /></td>
											<td width="12%"><label>组织机构代码：</label></td>
											<td width="36%"><s:property value="corp.corpCode" /> 
											<input type="hidden" value="<s:property value="corp.corpCode" />" name="corp.corpCode" /></td>
										</tr>
										<tr>
											<td><label>是否外商投资：</label></td>
											<td>
											<select id="checkForeign" name="corp.checkForeign" onchange="checkForeignCorp()" class="required">
												<option value="0" <s:if test='corp.checkForeign=="0"'>selected</s:if>>是</option>
												<option value="1" <s:if test='corp.checkForeign=="1"'>selected</s:if>>否</option>
											</select><strong><font color="#FF0000">*</font></strong>
											</td>
											<td><label>工商营业执照注册号：</label></td>
											<td>
											<input type="text" maxlength='30' value="<s:property value="corp.licenseNum" />" name="corp.licenseNum" class="required ipu1" />
											<strong><font color="#FF0000">*</font></strong>
											</td>
										</tr>

										<tr>
											<td><label>企业归属地：</label></td>
											<td>
											<select name="corp.spare1" class="required">
												<option value="230100" <s:if test='corp.spare1==230100'>selected</s:if>>哈尔滨</option>
												<option value="230200" <s:if test='corp.spare1==230200'>selected</s:if>>齐齐哈尔</option>
												<option value="231000" <s:if test='corp.spare1==231000'>selected</s:if>>牡丹江</option>
												<option value="230600" <s:if test='corp.spare1==230600'>selected</s:if>>大庆</option>
												<option value="230700" <s:if test='corp.spare1==230700'>selected</s:if>>伊春</option>
												<option value="230400" <s:if test='corp.spare1==230400'>selected</s:if>>鹤岗</option>
												<option value="230800" <s:if test='corp.spare1==230800'>selected</s:if>>佳木斯</option>
												<option value="231100" <s:if test='corp.spare1==231100'>selected</s:if>>黑河</option>
												<option value="232700" <s:if test='corp.spare1==232700'>selected</s:if>>大兴安岭地区</option>
												<option value="400021" <s:if test='corp.spare1==400021'>selected</s:if>>森工</option>
												<option value="400022" <s:if test='corp.spare1==400022'>selected</s:if>>绥芬河</option>
												<option value="400023" <s:if test='corp.spare1==400023'>selected</s:if>>抚远</option>
												<option value="230300" <s:if test='corp.spare1==230300'>selected</s:if>>鸡西</option>
												<option value="400020" <s:if test='corp.spare1==400020'>selected</s:if>>农垦</option>
												<option value="230900" <s:if test='corp.spare1==230900'>selected</s:if>>七台河</option>
												<option value="230500" <s:if test='corp.spare1==230500'>selected</s:if>>双鸭山</option>
												<option value="231200" <s:if test='corp.spare1==231200'>selected</s:if>>绥化</option>
											</select>
											<strong><font color="#FF0000">*</font></strong>
											</td>

											<td><label>净资产(万元)：</label></td>
											<td>
											<input id="assets" type="text" maxlength='15' value="<s:property value="corp.assets"/>" name="corp.assets" class="required number ipu1" />
											<strong><font color="#FF0000">*</font></strong>
											</td>
										</tr>



										<tr id="foreignCorpName">
											<td><label>外商投资者名称：</label></td>
											<td>
											<input type="text" maxlength='200' class="required ipu1" value="<s:property value="corp.foreignCorpName"/>" name="corp.foreignCorpName" />
											<strong><font color="#FF0000">*</font></strong>
											</td>
											<td><label>国籍或地域：</label></td>
											<td>
											<select name="corp.nationNume" class="required sel">
												<option value="">请选择</option>
												<s:iterator value="nations">
													<option value="<s:property value="code"/>"
														<s:if test='corp.nationNume==code'>selected</s:if>><s:property value="name" /></option>
												</s:iterator>
											</select>
											<strong><font color="#FF0000">*</font></strong>
											</td>
										</tr>
										<tr id="percentTage">
											<td><label>外商投资所占比例：</label></td>
											<td>
											<input type="text" maxlength='200' class="required ipu1" value="<s:property value="corp.percentTage"/>" name="corp.percentTage" />
											<strong><font color="#FF0000">*</font></strong>
											</td>
											<td><label>外商投资这类型 ：</label></td>
											<td>
											<select name="corp.foreignIvestor" class="required sel">
												<option value="0" <s:if test='corp.foreignIvestor==0'>selected</s:if>>境外企业</option>
												<option value="1" <s:if test='corp.foreignIvestor==1'>selected</s:if>>境外自然人</option>
											</select>
											<strong><font color="#FF0000">*</font></strong>
											</td>
										</tr>
										<tr>
											<td><label>注册所在省（自治区、直辖市）：</label></td>
											<td>
											
											<select id="provinceId" name="corp.provinceNum"
												onchange="queryCity()" class="required sel">
													<s:iterator value="provinces">
														<option value="<s:property value="code"/>"
															<s:if test='corp.provinceNum==code'>selected</s:if>><s:property
																value="name" /></option>
													</s:iterator>
											</select>
											 <!-- 
											 黑龙江省
											<input id="provinceId" type="hidden" name="corp.provinceNum" value="230000" />
											-->
											</td>


											<td><label>注册所在地（市、州、盟）：</label></td>
											<td>
											<select id="cityId" name="corp.cityNum" onchange="queryArea()" class="required">
											</select>
											<strong><font color="#FF0000">*</font></strong>
											</td>
										</tr>
										<tr>
											<td><label>注册所在县（区、市、旗）：</label></td>
											<td>
											<select id="areaId" name="corp.countyNum" class="required">
											</select>
											<strong><font color="#FF0000">*</font></strong>
											</td>
											<td><label>企业营业地址：</label></td>
											<td>
											<input type="text" maxlength='200' value="<s:property value="corp.address" />" name="corp.address" class="required ipu1" />
											<strong><font color="#FF0000">*</font></strong></td>
										</tr>
										<tr>
											<td><label>企业营业地址邮政编码：</label></td>
											<td>
											<input type="text" maxlength='6' value="<s:property value="corp.postalCode" />" name="corp.postalCode" class="required ipu1" /></td>

											<td><label>法定代表人姓名：</label></td>
											<td>
											<input type="text" maxlength='50' value="<s:property value="corp.legalMan" />" name="corp.legalMan" class="required ipu1" />
											<strong><font color="#FF0000">*</font></strong>
											</td>
										</tr>
										<tr>
											<td><label>法定代表人证件类型：</label></td>
											<td>
											<select id="" name="corp.idCardTypeNum" class="required sel">
												<s:iterator value="idCardType">
													<option value="<s:property value="code"/>"
														<s:if test='corp.idCardTypeNum==code'>selected</s:if>><s:property value="name" /></option>
												</s:iterator>
											</select><strong><font color="#FF0000">*</font></strong>
											</td>

											<td><label>法定代表人证件号码：</label></td>
											<td>
											<input type="text" maxlength='30' value="<s:property value="corp.legalManIdCard" />" name="corp.legalManIdCard" class="required ipu1" />
											<strong><font color="#FF0000">*</font></strong>
											</td>
										</tr>
										<tr>
											<td><label>法定代表职务：</label></td>
											<td>
											<input type="text" maxlength='50' value="<s:property value="corp.legalManDuty" />" name="corp.legalManDuty" class="required ipu1" />
											<strong><font color="#FF0000">*</font></strong></td>
											<td><label>法定代表职称：</label></td>
											<td>
											<input type="text" maxlength='50' value="<s:property value="corp.legaManProtitle" />" name="corp.legaManProtitle" class="required ipu1" />
											<strong><font color="#FF0000">*</font></strong></td>
										</tr>
										<tr>
											<td><label>企业登记注册类型：</label></td>
											<td>
											<select id="" name="corp.economicNum" class="required sel">
												<s:iterator value="economicNum">
													<option value="<s:property value="code"/>"
														<s:if test='corp.economicNum==code'>selected</s:if>><s:property value="name" /></option>
												</s:iterator>
											</select><strong><font color="#FF0000">*</font></strong>
											</td>

											<td><label>注册资本（万元）：</label></td>
											<td>
											<input id="regPrin" type="text" maxlength='15' value="<s:property value="corp.regPrin" />" name="corp.regPrin" class="required number ipu1" />
											<strong><font color="#FF0000">*</font></strong>
											</td>
										</tr>
										<tr>
											<td><label>实收资本（万元）：</label></td>
											<td>
											<input id="fact" type="text" maxlength='15' value="<s:property value="corp.factRegPrin" />" name="corp.factRegPrin" class="required number ipu1" />
											<strong><font color="#FF0000">*</font></strong></td>
											<td><label>注册资本币种：</label></td>
											<td>
											<select id="" name="corp.principalUnitNum" class="required sel">
												<s:iterator value="principalUnit">
													<option value="<s:property value="code"/>"
														<s:if test='corp.principalUnitNum==code'>selected</s:if>><s:property value="name" /></option>
												</s:iterator>
											</select><strong><font color="#FF0000">*</font></strong>
											</td>
										</tr>
										<tr>
											<td><label>成立日期：</label></td>
											<td>
											<input id="time1" type="text" value="<s:date name="corp.corpBirthDate" format="yyyy-MM-dd" />" name="corp.corpBirthDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required ipu1" />
												<strong><font color="#FF0000">*</font></strong>
											</td>
											<td><label>办公电话：</label></td>
											<td>
											<input type="text" maxlength='30' value="<s:property value="corp.officePhone" />" name="corp.officePhone" class="required ipu1" />
											<strong><font color="#FF0000">*</font></strong></td>
										</tr>
										<tr>
											<td><label>传真号码：</label></td>
											<td>
											<input type="text" maxlength='30' value="<s:property value="corp.fax" />" name="corp.fax" class="required ipu1" />
											<strong><font color="#FF0000">*</font></strong></td>

											<td><label>联系人姓名：</label></td>
											<td>
											<input type="text" maxlength='50' value="<s:property value="corp.linkMan" />" name="corp.linkMan" class="required ipu1" />
											<strong><font color="#FF0000">*</font></strong></td>
										</tr>
										<tr>
											<td><label>联系人办公电话：</label></td>
											<td>
											<input type="text" maxlength='30' value="<s:property value="corp.linkTel" />" name="corp.linkTel" class="required ipu1" />
											<strong><font color="#FF0000">*</font></strong>
											</td>

											<td><label>联系人手机号码：</label></td>
											<td>
											<input type="text" maxlength='30' value="<s:property value="corp.linkPhone" />" name="corp.linkPhone" class="required ipu1" />
											<strong><font color="#FF0000">*</font></strong></td>
										</tr>
										<tr>
											<td><label>联系邮箱：</label></td>
											<td>
											<input type="text" maxlength='50' value="<s:property value="corp.email" />" name="corp.email" class="email ipu1" />
											</td>

											<td><label>企业网址：</label></td>
											<td>
											<input type="text" maxlength='200' value="<s:property value="corp.url" />" name="corp.url" class="url ipu1" />
											</td>
										</tr>

										<tr>
											<td><label>建设单位：</label></td>
											<td align="center" valign="middle">
											<s:if test='corp.enterpriseType.contains("1")'>
												<input type="checkbox" name="corp.enterpriseType" value="1" class="sc " checked />
											</s:if> 
											<s:else>
												<input type="checkbox" name="corp.enterpriseType" value="1" class="sc" />
											</s:else>
											</td>
											<td><label>勘察单位：</label></td>
											<td align="center" valign="middle">
											<s:if test='corp.enterpriseType.contains("2")'>
												<input type="checkbox" name="corp.enterpriseType" value="2" class="sc" checked />
											</s:if> 
											<s:else>
												<input type="checkbox" name="corp.enterpriseType" value="2" class="sc" />
											</s:else>
											</td>
										</tr>
										<tr>
											<td><label>设计单位：</label></td>
											<td align="center" valign="middle">
											<s:if test='corp.enterpriseType.contains("3")'>
												<input type="checkbox" name="corp.enterpriseType" value="3"	class="sc" checked />
											</s:if> 
											<s:else>
												<input type="checkbox" name="corp.enterpriseType" value="3" class="sc" />
											</s:else>
											</td>
											<td><label>施工单位：</label></td>
											<td align="center" valign="middle">
											<s:if test='corp.enterpriseType.contains("4")'>
												<input type="checkbox" name="corp.enterpriseType" value="4" class="sc" checked />
											</s:if>
											<s:else>
												<input type="checkbox" name="corp.enterpriseType" value="4" class="sc" />
											</s:else>
											</td>
										</tr>
										<tr>
											<td><label>监理单位：</label></td>
											<td align="center" valign="middle">
											<s:if test='corp.enterpriseType.contains("5")'>
												<input type="checkbox" name="corp.enterpriseType" value="5" class="sc" checked />
											</s:if> 
											<s:else>
												<input type="checkbox" name="corp.enterpriseType" value="5" class="sc" />
											</s:else>
											</td>
											<td><label>图纸审查单位：</label></td>
											<td align="center" valign="middle">
											<s:if test='corp.enterpriseType.contains("6")'>
												<input type="checkbox" name="corp.enterpriseType" value="6" class="sc" checked />
											</s:if> 
											<s:else>
												<input type="checkbox" name="corp.enterpriseType" value="6" class="sc" />
											</s:else>
											</td>
										</tr>
										<tr>
											<td><label>检测单位：</label></td>
											<td align="center" valign="middle">
											<s:if test='corp.enterpriseType.contains("7")'>
												<input type="checkbox" name="corp.enterpriseType" value="7" class="sc" checked />
											</s:if> 
											<s:else>
												<input type="checkbox" name="corp.enterpriseType" value="7" class="sc" />
											</s:else>
											</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td><label>备注：</label></td>
											<td align="center" valign="middle">
											<textarea name="corp.description" cols="45" rows="5" class="ipu2"
													onKeyUp="checkMaxInput(this)"
													onKeyDown="checkMaxInput(this)"><s:property
														value="corp.description" /></textarea>&nbsp;&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</table>
									<div class="botn">
										<input type="image" src="<%=basepath%>/images/quxiao.jpg" onclick="goBack()" /> 
										<input type="image" src="<%=basepath%>/images/baocun.jpg" />
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="bot">Copyright © 2015 版权所有 黑龙江住房和城乡建设部建筑市场监管司 |
			技术支持：建设厅信息中心 哈尔滨天健高新技术有限公司 | 建议使用 IE 8及以上，1366*768及以上分辨率浏览</div>
</body>
</html>
