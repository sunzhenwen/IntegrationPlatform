<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业报表信息</title>
<script type="text/javascript" src="<%=basepath%>/js/validator.js"></script>
<script type="text/javascript">
	
	//取消
	function goBack()
	{
		document.form1.action="<%=basepath%>/queryCorpReportAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>

<body>

	<div class="qy_wrapp">
		<form id="form1" name="form1" method="post">

			<div class="ry_content">

				<div class="ry_lbxx">
					<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
						<h2>建筑企业统计报表详细</h2>
						<table class="" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<th align="left" colspan="6">企业名称： <s:property
											value="corpReport.corpName" /> <input type="hidden"
										name="corpReport.corpCode"
										value="<s:property value="corpCode"/>" /> <input
										type="hidden" name="corpReport.provinceNum"
										value="<s:property value="provinceNum"/>" /> <input
										type="hidden" name="corpReport.cityNum"
										value="<s:property value="cityNum"/>" /> <input type="hidden"
										name="corpReport.countyNum"
										value="<s:property value="countyNum"/>" /> <input
										type="hidden" name="corpReport.id"
										value="<s:property value="corpReport.id"/>" />
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<s:property value="corpReport.reportYear" /> 年 <s:if
											test="corpReport.quarter==1">第一季度</s:if> <s:if
											test="corpReport.quarter==2">第二季度</s:if> <s:if
											test="corpReport.quarter==3">第三季度</s:if> <s:if
											test="corpReport.quarter==4">第四季度</s:if>
									</th>
								</tr>
								<tr>
									<th colspan="3">指示名称</th>
									<th>计量单位</th>
									<th colspan="2">自年初累计</th>
								</tr>
								<tr>
									<td style="border-bottom-style: none;" colspan="3">签订合同</td>
									<th>万元</th>
									<td colspan="2"><s:property
											value="corpReport.signContract" /></td>
								</tr>
								<tr>
									<td style="border-top-style: none; border-bottom-style: none;"></td>
									<td colspan="2">上年结转合同额</td>
									<th>万元</th>
									<td colspan="2"><s:property
											value="corpReport.lastYearContract" /></td>
								</tr>
								<tr>
									<td style="border-top-style: none"></td>
									<td colspan="2">本年新签合同额</td>
									<th>万元</th>
									<td colspan="2"><s:property
											value="corpReport.thisYearContract" /></td>
								</tr>
								<tr>
									<td style="border-bottom-style: none;" colspan="3">建筑业总产值</td>
									<th>万元</th>
									<td colspan="2"><s:property value="corpReport.totalOutput" /></td>
								</tr>
								<tr>
									<td style="border-top-style: none; border-bottom-style: none;">&nbsp;</td>
									<td colspan="2">省外</td>
									<th>万元</th>
									<td colspan="2"><s:property
											value="corpReport.provinceOutside" /></td>
								</tr>
								<tr>
									<td style="border-top-style: none; border-bottom-style: none;">&nbsp;</td>
									<td colspan="2">国外</td>
									<th>万元</th>
									<td colspan="2"><s:property value="corpReport.abroad" /></td>
								</tr>
								<tr>
									<td style="border-top-style: none; border-bottom-style: none;">&nbsp;</td>
									<td colspan="2">建筑工程</td>
									<th>万元</th>
									<td colspan="2"><s:property
											value="corpReport.construction" /></td>
								</tr>
								<tr>
									<td style="border-top-style: none; border-bottom-style: none;">&nbsp;</td>
									<td colspan="2">安装工程</td>
									<th>万元</th>
									<td colspan="2"><s:property value="corpReport.erection" /></td>
								</tr>
								<tr>
									<td style="border-top-style: none;">&nbsp;</td>
									<td colspan="2">装饰装修工程</td>
									<th>万元</th>
									<td colspan="2"><s:property value="corpReport.decorate" /></td>
								</tr>
								<tr>
									<td style="border-bottom-style: none;" colspan="3">工程结算收入</td>
									<th>万元</th>
									<td colspan="2"><s:property
											value="corpReport.settlementIncome" /></td>
								</tr>
								<tr>
									<td style="border-top-style: none"></td>
									<td colspan="2">工程结算成本</td>
									<th>万元</th>
									<td colspan="2"><s:property
											value="corpReport.settlementCost" /></td>
								</tr>
								<tr>
									<th colspan="3">增加值</th>
									<th>万元</th>
									<td colspan="2"><s:property value="corpReport.addedValue" /></td>
								</tr>
								<tr>
									<th colspan="3">从业人员劳动报酬</th>
									<th>万元</th>
									<td colspan="2"><s:property value="corpReport.reward" /></td>
								</tr>
								<tr>
									<td style="border-bottom-style: none;" colspan="3">利税总额</td>
									<th>万元</th>
									<td colspan="2"><s:property value="corpReport.totalProfit" /></td>
								</tr>
								<tr>
									<td style="border-top-style: none">&nbsp;</td>
									<td colspan="2">利润总额</td>
									<th>万元</th>
									<td colspan="2"><s:property value="corpReport.profit" /></td>
								</tr>
								<tr>
									<td style="border-bottom-style: none;" colspan="3">从业人员</td>
									<th>人</th>
									<td colspan="2"><s:property value="corpReport.employee" /></td>
								</tr>
								<tr>
									<td style="border-bottom-style: none; border-top-style: none;">&nbsp;</td>
									<td colspan="2">注册建造师</td>
									<th>人</th>
									<td colspan="2"><s:property value="corpReport.registered" /></td>
								</tr>
								<tr>
									<td style="border-bottom-style: none; border-top-style: none;">&nbsp;</td>
									<td colspan="2">中级以上职称人员</td>
									<th>人</th>
									<td colspan="2"><s:property value="corpReport.ultimate" /></td>
								</tr>
								<tr>
									<td style="border-bottom-style: none; border-top-style: none;">&nbsp;</td>
									<td colspan="2">持证岗位人员</td>
									<th>人</th>
									<td colspan="2"><s:property value="corpReport.post" /></td>
								</tr>
								<tr>
									<td style="border-top-style: none">&nbsp;</td>
									<td colspan="2">中级以上技术工人</td>
									<th>人</th>
									<td colspan="2"><s:property value="corpReport.technology" /></td>
								</tr>
								<tr>
									<th colspan="3">技术装备率</th>
									<th>元/人</th>
									<td colspan="2"><s:property
											value="corpReport.technicalEquipment" /></td>
								</tr>
								<tr>
									<th colspan="3">劳动生产率</th>
									<th>元/人</th>
									<td colspan="2"><s:property
											value="corpReport.laborProduction" /></td>
								</tr>
								<tr>
									<td align="left" colspan="6"
										style="border-bottom-style: none; border-left-style: none; border-right-style: none;">
										单位负责人：<s:property value="corpReport.legalMan" />
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										填表人：<s:property value="corpReport.fillOut" />
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										联系电话：<s:property value="corpReport.linkPhone" />
									</td>
								</tr>
								<tr>
									<td colspan="6" align="left"
										style="border-top-style: none; border-bottom-style: none; border-left-style: none; border-right-style: none;">增加值计算公式：本年提取的公定资产折旧+应付工资+应付福利费+管理费用中的劳动待业保险金、税金+工程结算税金及附加+工程结算利润。</td>
								</tr>

							</tbody>

						</table>
						<div class="sp_bton">
							<input type="image" onclick="goBack()"
								src="<%=basepath%>/images/fanhui.jpg" />
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>


</body>
</html>
