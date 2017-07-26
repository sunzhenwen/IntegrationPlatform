<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>建筑企业统计报表 </title>
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
		document.form1.action="<%=basepath %>/corpReportAction_goList.action";
		document.form1.submit();
	}

</script>

</head>

<body>
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="<%=basepath %>/corpReportAction_modify.action">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>建筑企业统计报表</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th align="left" colspan="6">企业名称：
							<input type="text" readonly name="corpReport.corpName" value="<s:property value="corpReport.corpName"/>
							" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input type="hidden" name="corpReport.corpCode" value="<s:property value="corpCode"/>"/>
							<input type="hidden" name="corpReport.provinceNum" value="<s:property value="provinceNum"/>"/>
							<input type="hidden" name="corpReport.cityNum" value="<s:property value="cityNum"/>"/>
							<input type="hidden" name="corpReport.countyNum" value="<s:property value="countyNum"/>"/>
							<input type="hidden" name="corpReport.id" value="<s:property value="corpReport.id"/>"/>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input size="4" id="time3" value="<s:property value="corpReport.reportYear"/>" type="text" name="corpReport.reportYear" onFocus="WdatePicker({dateFmt:'yyyy',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" />
							<strong><font color="#FF0000">*</font></strong>
							年
							
							
							<select name="corpReport.quarter" class="required">
								<option value="0">请选择</option>
								<s:if test="corpReport.quarter==1">
								<option value="1" selected>一</option>
								<option value="2" >二</option>
								<option value="3" >三</option>
								<option value="4" >四</option>
								</s:if>
								<s:elseif test="corpReport.quarter==2">
								<option value="1" >一</option>
								<option value="2" selected>二</option>
								<option value="3" >三</option>
								<option value="4" >四</option>
								</s:elseif>
								<s:elseif test="corpReport.quarter==3">
								<option value="1" >一</option>
								<option value="2" >二</option>
								<option value="3" selected>三</option>
								<option value="4" >四</option>
								</s:elseif>
								<s:else>
								<option value="1">一</option>
								<option value="2" >二</option>
								<option value="3" >三</option>
								<option value="4" selected>四</option>
								</s:else>
							</select><strong><font color="#FF0000">*</font></strong>
							
							季度
							
							</th>
						 </tr>
                         <tr>
                         	<th colspan="3" align="left">指示名称</th>
							<th>计量单位</th>
							<th colspan="2">自年初累计</th>
                         </tr>
                         <tr>
                         	<td style="border-bottom-style:none;" colspan="3">签订合同</td>
							<th>万元</th>
							<td colspan="2" align="left">
							<input type="text" maxlength='50' name="corpReport.signContract"  value="<s:property value="corpReport.signContract"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                        <tr>
                         	<td style="border-top-style:none;border-bottom-style:none;"></td>
							<td colspan="2" align="left">上年结转合同额</td>
							<th>万元</th>
							<td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.lastYearContract"  value="<s:property value="corpReport.lastYearContract"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
						</tr>
                        <tr>
                         	<td style="border-top-style:none"></td>
							<td colspan="2">本年新签合同额</td>
							<th>万元</th>
							<td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.thisYearContract" value="<s:property value="corpReport.thisYearContract"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
						</tr>
                        <tr>
                       		<td style="border-bottom-style:none;" colspan="3">建筑业总产值</td>
							<th>万元</th>
							<td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.totalOutput" value="<s:property value="corpReport.totalOutput"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                       		<td style="border-top-style:none;border-bottom-style:none;">&nbsp;</td>
							<td colspan="2" align="left">省外</td>
							<th>万元</th>
							<td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.provinceOutside" value="<s:property value="corpReport.provinceOutside"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                       		<td style="border-top-style:none;border-bottom-style:none;">&nbsp;</td>
							<td colspan="2">国外</td>
							<th>万元</th>
							<td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.abroad" value="<s:property value="corpReport.abroad"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                       		<td style="border-top-style:none;border-bottom-style:none;">&nbsp;</td>
							<td colspan="2">建筑工程</td>
							<th>万元</th>
							<td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.construction" value="<s:property value="corpReport.construction"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <td style="border-top-style:none;border-bottom-style:none;">&nbsp;</td>
                          <td colspan="2">安装工程</td>
                          <th>万元</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.erection" value="<s:property value="corpReport.erection"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <td style="border-top-style:none;">&nbsp;</td>
                          <td colspan="2">装饰装修工程</td>
                          <th>万元</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.decorate" value="<s:property value="corpReport.decorate"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <td style="border-bottom-style:none;" colspan="3">工程结算收入</td>
                          <th>万元</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.settlementIncome" value="<s:property value="corpReport.settlementIncome"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <td style="border-top-style:none"></td>
                          <td colspan="2">工程结算成本</td>
                          <th>万元</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.settlementCost" value="<s:property value="corpReport.settlementCost"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <th colspan="3">增加值</th>
                          <th>万元</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.addedValue" value="<s:property value="corpReport.addedValue"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <th colspan="3">从业人员劳动报酬</th>
                          <th>万元</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.reward" value="<s:property value="corpReport.reward"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <td style="border-bottom-style:none;" colspan="3">利税总额</td>
                          <th>万元</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.totalProfit" value="<s:property value="corpReport.totalProfit"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <td style="border-top-style:none">&nbsp;</td>
                          <td colspan="2">利润总额</td>
                          <th>万元</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.profit" value="<s:property value="corpReport.profit"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <td style="border-bottom-style:none;" colspan="3">从业人员</td>
                          <th>人</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.employee" value="<s:property value="corpReport.employee"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <td style="border-bottom-style:none;border-top-style:none;">&nbsp;</td>
                          <td colspan="2">注册建造师</td>
                          <th>人</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.registered" value="<s:property value="corpReport.registered"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <td style="border-bottom-style:none;border-top-style:none;">&nbsp;</td>
                          <td colspan="2">中级以上职称人员</td>
                          <th>人</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.ultimate" value="<s:property value="corpReport.ultimate"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <td style="border-bottom-style:none;border-top-style:none;">&nbsp;</td>
                          <td colspan="2">持证岗位人员</td>
                          <th>人</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.post" value="<s:property value="corpReport.post"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <td style="border-top-style:none">&nbsp;</td>
                          <td colspan="2">中级以上技术工人</td>
                          <th>人</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.technology" value="<s:property value="corpReport.technology"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <th colspan="3">技术装备率</th>
                          <th>元/人</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.technicalEquipment" value="<s:property value="corpReport.technicalEquipment"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <th colspan="3">劳动生产率</th>
                          <th>元/人</th>
                          <td colspan="2" align="left"><input type="text" maxlength='50' name="corpReport.laborProduction" value="<s:property value="corpReport.laborProduction"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                          <td align="left" colspan="6" style="border-bottom-style:none;border-left-style:none;border-right-style:none;">
                          单位负责人：<input type="text" maxlength='50' name="corpReport.legalMan" value="<s:property value="corpReport.legalMan"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          填表人：<input type="text" maxlength='50' name="corpReport.fillOut" value="<s:property value="corpReport.fillOut"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          联系电话：<input type="text" maxlength='50' name="corpReport.linkPhone" value="<s:property value="corpReport.linkPhone"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
                          </td>
                        </tr>
                        <tr>
                          <td colspan="6" align="left" style="border-top-style:none;border-bottom-style:none;border-left-style:none;border-right-style:none;">增加值计算公式：本年提取的公定资产折旧+应付工资+应付福利费+管理费用中的劳动待业保险金、税金+工程结算税金及附加+工程结算利润。</td>
                        </tr>
                        
                  </tbody>  
                
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
		            <!-- <input type="image"src="<%=basepath %>/images/baocun.jpg" /> -->
            	</div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
