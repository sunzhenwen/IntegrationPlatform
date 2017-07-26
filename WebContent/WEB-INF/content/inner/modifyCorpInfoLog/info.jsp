<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css">
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<title>企业信息修改详细</title>
<script type="text/javascript">
	
	
	
	function checkMaxInput(txt)

	{
	       if (txt.value.length > 500)
	       txt.value = txt.value.substring(0, 500);
	}
	
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/corpAction_goBack.action";
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
						var cityNum = '<s:property value="modifyCorpInfoLog.cityNum"/>';
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
										var area = '<s:property value="modifyCorpInfoLog.countyNum"/>';
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
							var area = '<s:property value="modifyCorpInfoLog.countyNum"/>';
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
	<form id="form1" name="form1" method="post" action="<%=basepath%>/corpAction_corpModify.action">
	<div class="tit">
		<img src="images/titico1.gif" /><strong>企业基本信息修改历史详细</strong>
	</div>
		<div class="qy_wrapp">

			<table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
				<tr>
					<td width="10px">修改时间：</td>
					<td colspan="2" style="text-align: center;"><s:date name="modifyCorpInfoLog.modifyDate" format="yyyy年MM月dd日"/> </td>
				</tr>
				<tr>
					<td>组织机构代码证号：</td>
					<td colspan="2" style="text-align: center;">${modifyCorpInfoLog.corpCode}</td>
				</tr>
				<tr>
					<td>备案系统：</td>
					<td colspan="2" style="text-align: center;">${modifyCorpInfoLog.modifyingLocation}</td>
				</tr>
				<tr>
                	<td></td>
                	<td style="text-align:center;">
                	变更前
                	</td>
                    <td style="text-align:center;">变更后</td>
                </tr>
               
                <tr style="" >
                    <td>企业名称：</td>
                    <s:if test="modifyCorpInfoLog.corpName1==modifyCorpInfoLog.corpName">
                    	<td style="text-align:center;">
	               			${modifyCorpInfoLog.corpName1}
	               		</td>
	                    <td style="text-align:center; padding-left:6px;">
							${modifyCorpInfoLog.corpName}
						</td>
                    </s:if><s:else>
	                    <td style="color: red; text-align: center">
	               			${modifyCorpInfoLog.corpName1}
	               		</td>
	                    <td style="text-align:center; padding-left:6px; color: red">
							${modifyCorpInfoLog.corpName}
						</td>
	                </s:else>
                </tr>
                 <tr>
                    <td>营业执照注册号：</td>
                    <s:if test="modifyCorpInfoLog.licenseNum1==modifyCorpInfoLog.licenseNum">
               		<td style="text-align:center;">
              			${modifyCorpInfoLog.licenseNum1}
                    </td>
                    <td style="text-align:center; padding-left:6px;">
                    	${modifyCorpInfoLog.licenseNum}
                    </td>
                    </s:if><s:else>
                    	<td style="color: red;text-align: center">
              				${modifyCorpInfoLog.licenseNum1}
	                    </td>
	                    <td style="text-align:center; padding-left:6px;color: red">
	                    	${modifyCorpInfoLog.licenseNum}
	                    </td>
                    </s:else>
                </tr>
                <tr>
                    <td>详细地址：</td>
                    <s:if test="modifyCorpInfoLog.address1==modifyCorpInfoLog.address">
	                    <td style="text-align:center;">
	               			${modifyCorpInfoLog.address1}
	                    </td>
	                    <td style="text-align:center; padding-left:6px;">
	                  		${modifyCorpInfoLog.address}
	                    </td>
                    </s:if><s:else>
	                    <td style="color: red;text-align: center">
	               			${modifyCorpInfoLog.address1}
	                    </td>
	                    <td style="text-align:center; padding-left:6px; color: red">
	                  		${modifyCorpInfoLog.address}
	                    </td>
                    </s:else>
                </tr>
                <tr>
					<td><label>企业归属地：</label></td>
					<td style="text-align:center;">
					<select name="modifyCorpInfoLog.spare1" class="required">
						<option value="230100" <s:if test='modifyCorpInfoLog.spare1==230100'>selected</s:if>>哈尔滨</option>
						<option value="230200" <s:if test='modifyCorpInfoLog.spare1==230200'>selected</s:if>>齐齐哈尔</option>
						<option value="231000" <s:if test='modifyCorpInfoLog.spare1==231000'>selected</s:if>>牡丹江</option>
						<option value="230600" <s:if test='modifyCorpInfoLog.spare1==230600'>selected</s:if>>大庆</option>
						<option value="230700" <s:if test='modifyCorpInfoLog.spare1==230700'>selected</s:if>>伊春</option>
						<option value="230400" <s:if test='modifyCorpInfoLog.spare1==230400'>selected</s:if>>鹤岗</option>
						<option value="230800" <s:if test='modifyCorpInfoLog.spare1==230800'>selected</s:if>>佳木斯</option>
						<option value="231100" <s:if test='modifyCorpInfoLog.spare1==231100'>selected</s:if>>黑河</option>
						<option value="232700" <s:if test='modifyCorpInfoLog.spare1==232700'>selected</s:if>>大兴安岭地区</option>
						<option value="400021" <s:if test='modifyCorpInfoLog.spare1==400021'>selected</s:if>>森工</option>
						<option value="400022" <s:if test='modifyCorpInfoLog.spare1==400022'>selected</s:if>>绥芬河</option>
						<option value="400023" <s:if test='modifyCorpInfoLog.spare1==400023'>selected</s:if>>抚远</option>
						<option value="230300" <s:if test='modifyCorpInfoLog.spare1==230300'>selected</s:if>>鸡西</option>
						<option value="400020" <s:if test='modifyCorpInfoLog.spare1==400020'>selected</s:if>>农垦</option>
						<option value="230900" <s:if test='modifyCorpInfoLog.spare1==230900'>selected</s:if>>七台河</option>
						<option value="230500" <s:if test='modifyCorpInfoLog.spare1==230500'>selected</s:if>>双鸭山</option>
						<option value="231200" <s:if test='modifyCorpInfoLog.spare1==231200'>selected</s:if>>绥化</option>
					</select>
					<strong><font color="#FF0000"></font></strong>
					</td>
					<td style="text-align:center;">
					<select name="modifyCorpInfoLog.spare11" class="required">
						<option value="230100" <s:if test='modifyCorpInfoLog.spare1==230100'>selected</s:if>>哈尔滨</option>
						<option value="230200" <s:if test='modifyCorpInfoLog.spare1==230200'>selected</s:if>>齐齐哈尔</option>
						<option value="231000" <s:if test='modifyCorpInfoLog.spare1==231000'>selected</s:if>>牡丹江</option>
						<option value="230600" <s:if test='modifyCorpInfoLog.spare1==230600'>selected</s:if>>大庆</option>
						<option value="230700" <s:if test='modifyCorpInfoLog.spare1==230700'>selected</s:if>>伊春</option>
						<option value="230400" <s:if test='modifyCorpInfoLog.spare1==230400'>selected</s:if>>鹤岗</option>
						<option value="230800" <s:if test='modifyCorpInfoLog.spare1==230800'>selected</s:if>>佳木斯</option>
						<option value="231100" <s:if test='modifyCorpInfoLog.spare1==231100'>selected</s:if>>黑河</option>
						<option value="232700" <s:if test='modifyCorpInfoLog.spare1==232700'>selected</s:if>>大兴安岭地区</option>
						<option value="400021" <s:if test='modifyCorpInfoLog.spare1==400021'>selected</s:if>>森工</option>
						<option value="400022" <s:if test='modifyCorpInfoLog.spare1==400022'>selected</s:if>>绥芬河</option>
						<option value="400023" <s:if test='modifyCorpInfoLog.spare1==400023'>selected</s:if>>抚远</option>
						<option value="230300" <s:if test='modifyCorpInfoLog.spare1==230300'>selected</s:if>>鸡西</option>
						<option value="400020" <s:if test='modifyCorpInfoLog.spare1==400020'>selected</s:if>>农垦</option>
						<option value="230900" <s:if test='modifyCorpInfoLog.spare1==230900'>selected</s:if>>七台河</option>
						<option value="230500" <s:if test='modifyCorpInfoLog.spare1==230500'>selected</s:if>>双鸭山</option>
						<option value="231200" <s:if test='modifyCorpInfoLog.spare1==231200'>selected</s:if>>绥化</option>
					</select>
					<strong><font color="#FF0000"></font></strong>
					</td>
				</tr>
				<tr>
					<td><label>企业登记注册类型：</label></td>
					<td style="text-align:center;">
					<select id="" name="modifyCorpInfoLog.economicNum" class="required sel">
						<s:iterator value="economicNum">
							<option value="<s:property value="code"/>"
								<s:if test='modifyCorpInfoLog.economicNum==code'>selected</s:if>><s:property value="name" /></option>
						</s:iterator>
					</select><strong><font color="#FF0000"></font></strong>
					</td>
					<td style="text-align:center;">
					<select id="" name="modifyCorpInfoLog.economicnum1" class="required sel">
						<s:iterator value="economicNum">
							<option value="<s:property value="code"/>"
								<s:if test='modifyCorpInfoLog.economicnum1==code'>selected</s:if>><s:property value="name" /></option>
						</s:iterator>
					</select><strong><font color="#FF0000"></font></strong>
					</td>
				</tr>
          		<tr>
                    <td>注册资本(万元)：</td>
                    <s:if test="modifyCorpInfoLog.regprin1==modifyCorpInfoLog.regprin">
	                    <td style="text-align:center;">
	               			${modifyCorpInfoLog.regprin1}
	                    </td>
	                    <td style="text-align:center; padding-left:6px;">
	                  		${modifyCorpInfoLog.regprin}
	                    </td>
                    </s:if><s:else>
	                    <td style="color: red;text-align: center" >
	               			${modifyCorpInfoLog.regprin1}
	                    </td>
	                    <td style="text-align:center; padding-left:6px; color: red">
	                  		${modifyCorpInfoLog.regprin}
	                    </td>
                    </s:else>
                </tr>
                <tr>
                    <td>实收资本(万元)：</td>
                    <s:if test="modifyCorpInfoLog.factRegprin1==modifyCorpInfoLog.factRegprin">
	                    <td style="text-align:center;">
	               			${modifyCorpInfoLog.factRegprin1}
	                    </td>
	                    <td style="text-align:center; padding-left:6px;">
	                  		${modifyCorpInfoLog.factRegprin}
	                    </td>
                    </s:if><s:else>
	                    <td style="color: red;text-align: center" >
	               			${modifyCorpInfoLog.factRegprin1}
	                    </td>
	                    <td style="text-align:center; padding-left:6px; color: red">
	                  		${modifyCorpInfoLog.factRegprin}
	                    </td>
                    </s:else>
                </tr>
                <tr>
                    <td>固定资产(万元)：</td>
                    <s:if test="modifyCorpInfoLog.assets1==modifyCorpInfoLog.assets">
	                    <td style="text-align:center;">
	               			${modifyCorpInfoLog.assets1}
	                    </td>
	                    <td style="text-align:center; padding-left:6px;">
	                  		${modifyCorpInfoLog.assets}
	                    </td>
                    </s:if><s:else>
	                    <td style="color: red;text-align: center" >
	               			${modifyCorpInfoLog.assets1}
	                    </td>
	                    <td style="text-align:center; padding-left:6px; color: red">
	                  		${modifyCorpInfoLog.assets}
	                    </td>
                    </s:else>
                </tr>
                <tr>
                    <td>法定代表人：</td>
                    <s:if test="modifyCorpInfoLog.legalMan1==modifyCorpInfoLog.legalMan">
	                    <td style="text-align:center;">
	               			${modifyCorpInfoLog.legalMan1}
	               		</td>
	                    <td style="text-align:center; padding-left:6px;">
	                    	${modifyCorpInfoLog.legalMan}
	                    </td>
                    </s:if><s:else>
	                    <td style="color: red;text-align: center">
	               			${modifyCorpInfoLog.legalMan1}
	               		</td>
	                    <td style="text-align:center; padding-left:6px; color: red">
	                    	${modifyCorpInfoLog.legalMan}
	                    </td>
                    </s:else>
                </tr>
                <tr>
					<td><label>法定代表人证件类型：</label></td>
					<td style="text-align:center;">
					<select id="" name="modifyCorpInfoLog.idCardTypeNum" class="required sel">
						<s:iterator value="idCardType">
							<option value="<s:property value="code"/>"
								<s:if test='modifyCorpInfoLog.idCardTypeNum==code'>selected</s:if>><s:property value="name" /></option>
						</s:iterator>
					</select><strong><font color="#FF0000"></font></strong>
					</td>
					<td style="text-align:center;">
					<select id="" name="modifyCorpInfoLog.idCardTypeNum1" class="required sel">
						<s:iterator value="idCardType">
							<option value="<s:property value="code"/>"
								<s:if test='modifyCorpInfoLog.idCardTypeNum1==code'>selected</s:if>><s:property value="name" /></option>
						</s:iterator>
					</select><strong><font color="#FF0000"></font></strong>
					</td>

				</tr>
                <tr>
                    <td>法人证件号：</td>
                    <s:if test="modifyCorpInfoLog.legalManIdCard==modifyCorpInfoLog.legalManIdCard">
	                    <td style="text-align:center;">
	               			${modifyCorpInfoLog.legalManIdCard1}
	               		</td>
	                    <td style="text-align:center; padding-left:6px;">
	                    	${modifyCorpInfoLog.legalManIdCard}
	                    </td>
                    </s:if><s:else>
	                    <td style="color: red;text-align: center">
	               			${modifyCorpInfoLog.legalManIdCard1}
	               		</td>
	                    <td style="text-align:center; padding-left:6px; color: red">
	                    	${modifyCorpInfoLog.legalManIdCard}
	                    </td>
                    </s:else>
                </tr>
                <tr>
                    <td>法人职称：</td>
                    <s:if test="modifyCorpInfoLog.legalManDuty1==modifyCorpInfoLog.legalManDuty">
	                    <td style="text-align:center;">
	               			${modifyCorpInfoLog.legalManDuty1}
	               		</td>
	                    <td style="text-align:center; padding-left:6px;">
	                    	${modifyCorpInfoLog.legalManDuty}
	                    </td>
                    </s:if><s:else>
	                    <td style="color: red;text-align: center">
	               			${modifyCorpInfoLog.legalManDuty1}
	               		</td>
	                    <td style="text-align:center; padding-left:6px; color: red">
	                    	${modifyCorpInfoLog.legalManDuty}
	                    </td>
                    </s:else>
                </tr>
                <tr>
                    <td>法人职务：</td>
                    <s:if test="modifyCorpInfoLog.legaManProTitle1==modifyCorpInfoLog.legaManProTitle">
	                    <td style="text-align:center;">
	               			${modifyCorpInfoLog.legaManProTitle1}
	               		</td>
	                    <td style="text-align:center; padding-left:6px;">
	                    	${modifyCorpInfoLog.legaManProTitle}
	                    </td>
                    </s:if><s:else>
	                    <td style="color: red;text-align: center">
	               			${modifyCorpInfoLog.legaManProTitle1}
	               		</td>
	                    <td style="text-align:center; padding-left:6px; color: red">
	                    	${modifyCorpInfoLog.legaManProTitle}
	                    </td>
                    </s:else>
                </tr>
                <tr>
                    <td>公司成立日期：</td>
                    <s:if test="modifyCorpInfoLog.corpBirthDate1==modifyCorpInfoLog.corpBirthDate">
	                    <td style="text-align:center;">
	               			${modifyCorpInfoLog.corpBirthDate1}
	               		</td>
	                    <td style="text-align:center; padding-left:6px;">
	                    	${modifyCorpInfoLog.corpBirthDate}
	                    </td>
                    </s:if><s:else>
	                    <td style="color: red;text-align: center">
	               			${modifyCorpInfoLog.corpBirthDate1}
	               		</td>
	                    <td style="text-align:center; padding-left:6px; color: red">
	                    	${modifyCorpInfoLog.corpBirthDate}
	                    </td>
                    </s:else>
                </tr>
                <tr>
                	<td><label>注册所在省（自治区、直辖市）：</label></td>
					<td style="text-align:center;">
					<select id="provinceId" name="modifyCorpInfoLog.provinceNum" onchange="queryArea()" class="required">
						<s:iterator value="provinces">
							<option value="<s:property value="code"/>"
								<s:if test='modifyCorpInfoLog.provinceNum==code'>selected</s:if>><s:property
									value="name" /></option>
						</s:iterator>
					</select>
					<strong><font color="#FF0000"></font></strong>
					</td>
					<td style="text-align:center;">
					<select id="provinceId1" name="modifyCorpInfoLog.provinceNum1" onchange="queryArea()" class="required">
						<s:iterator value="provinces">
							<option value="<s:property value="code"/>"
								<s:if test='modifyCorpInfoLog.provinceNum1==code'>selected</s:if>><s:property
									value="name" /></option>
						</s:iterator>
					</select>
					<strong><font color="#FF0000"></font></strong>
					</td>
                </tr>
                <tr>
                	<td><label>注册所在地（市、州、盟）：</label></td>
					<td style="text-align:center;">
					<select id="cityId" name="modifyCorpInfoLog.cityNum" onchange="queryArea()" class="required">
						<s:iterator value="citys">
							<option value="<s:property value="code"/>"
								<s:if test='modifyCorpInfoLog.cityNum==code'>selected</s:if>><s:property
									value="name" /></option>
						</s:iterator>
					</select>
					<strong><font color="#FF0000"></font></strong>
					</td>
					<td style="text-align:center;">
					<select id="cityId1" name="modifyCorpInfoLog.cityNum1" onchange="queryArea()" class="required">
						<s:iterator value="citys1">
							<option value="<s:property value="code"/>"
								<s:if test='modifyCorpInfoLog.cityNum1==code'>selected</s:if>><s:property
									value="name" /></option>
						</s:iterator>
					</select>
					<strong><font color="#FF0000"></font></strong>
					</td>
                </tr>
                <tr>
                	<td><label>注册所在县（区、市、旗）：</label></td>
					<td style="text-align:center;">
					<select id="areaId" name="modifyCorpInfoLog.countyNum" onchange="queryArea()" class="required">
						<s:iterator value="areas">
							<option value="<s:property value="code"/>"
								<s:if test='modifyCorpInfoLog.countyNum==code'>selected</s:if>><s:property
									value="name" /></option>
						</s:iterator>
					</select>
					<strong><font color="#FF0000"></font></strong>
					</td>
					<td style="text-align:center;">
					<select id="areaId1" name="modifyCorpInfoLog.countyNum1" onchange="queryArea()" class="required">
						<s:iterator value="areas1">
							<option value="<s:property value="code"/>"
								<s:if test='modifyCorpInfoLog.countyNum1==code'>selected</s:if>><s:property
									value="name" /></option>
						</s:iterator>
					</select>
					<strong><font color="#FF0000"></font></strong>
					</td>
                </tr>
            </table>
            <div class="sp_bton">
				<a href="#"><span class="sp_last" onclick="javascript:history.go(-1);">返回</span></a>
			</div>
		</div>
</body>
</html>
