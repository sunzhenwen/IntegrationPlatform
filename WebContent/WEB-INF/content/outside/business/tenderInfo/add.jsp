<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业招投标信息 </title>
<script type="text/javascript">


	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/tenderInfoAction_add.action";
		document.form1.submit();
	}
	//操作提示信息
	function getMessage()
	{
		var message = document.getElementById("message").value;
		if(message != "")
		{
			alert(message);
		}
	}
	
	//查询项目
	function queryPrjName()
	{
		var url1="<%=basepath %>/queryPrjsAction_queryPage.action";
		var newWin1=window.showModalDialog(url1,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin1.open()
	}
	
</script>

</head>

<body onload="getMessage()">

	<div class="ry_wrapp">
	
	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>企业招投标信息</h2>
                <table class="" cellpadding="0" cellspacing="0">

                	<tbody>  
                		<tr>
                         	<th>项目名称：</th>
							<td colspan="2" align="left">
							<input id="prjName" type="text" name="tenderInfoAdd.prjName" />
<a href="#" onclick="queryPrjName()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
		<input id="message" type="hidden" value="<s:property value = "message"/>" />
		<input id="prjId" type="hidden"  />
		<input id="appDept" type="hidden"  />
		<input id="appDeptName" type="hidden"  />
							</td>
							<th>项目编号：</th>
							<td colspan="2" align="left">
							<input id="prjNum" type="text" name="tenderInfoAdd.prjNum" />
							</td>
                         </tr> 
                         <tr>
                         	<th>中标通知书编号：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.tenderNum" />
							</td>
							<th>标段名称：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.sectionName" />
							</td>
                         </tr>
                         <tr>
                         	<th>招标类型：
                         	</th>
							<td colspan="2" align="left">
							<select name="tenderInfoAdd.tenderClassNum">
								<s:iterator value="tenderClassNums">
									<option value="<s:property value="code"/>"><s:property value="name" /></option>
								</s:iterator>
							</select>
							</td>
							<th>招标方式：</th>
							<td colspan="2" align="left">
								<select name="tenderInfoAdd.tenderTypeNum" class="required">
								<s:iterator value="tenderTypeNums">
									<option value="<s:property value="code"/>"><s:property value="name" /></option>
								</s:iterator>
							</select>
							</td>
                         </tr>
                         <tr>
                         	<th>中标日期：</th>
							<td colspan="2" align="left">
							<input id="time1" type="text" name="tenderInfoAdd.tenderResultDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
							</td>
							<th>中标金额：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.tenderMoney" />万元
							</td>
						</tr>
                        <tr>
                         	<th>建设规模：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.prjSize" />
							</td>
							<th>面积(平方米)：</th>
							<td colspan="2" align="left">
							
							<input type="text" name="tenderInfoAdd.area" />
							</td>
						</tr>
						<tr>
                         	<th>项目地址：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.projectAddress" />
							</td>
							<th>工程造价：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.projectCost" />
							</td>
						</tr>
						<tr>
                         	<th>招标代理单位名称：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.agencyCorpName" />
							</td>
							<th>招标代理单位组织机构代码：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.agencyCorpCode" />
							</td>
						</tr>
                        <tr>
                       		<th>中标单位名称：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.tenderCorpName" />
							</td>
							<th>中标单位组织机构代码：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.tenderCorpCode" />
							</td>
                        </tr>
                        <tr>
                       		<th>发包单位名称：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.propietorCorpName" />
							</td>
							<th>发包单位住组织代码：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.propietorCorpCode" />
							</td>
                        </tr>
                        <tr>
                       		<th>联合体承包单位名称：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.unionCorpName" />
							</td>
							<th>联合体承包单位组织代码：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.unionCorpCode" />
							</td>
                        </tr>
    					<tr>
                       		<th>项目经理/总监理工程师姓名：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.constructorName"  />
							</td>
							<th>项目经理/总监理工程师证件类型：</th>
							<td colspan="2" align="left">
							<select name="tenderInfoAdd.idCardTypeNum" >
								<s:iterator value="idCardTypeNums">
									<option value="<s:property value="code"/>"><s:property value="name" /></option>
								</s:iterator>
							</select>
							</td>
                        </tr>
                        <tr>
                       		<th>项目经理/总监理工程师证件号码：</th>
							<td colspan="2" align="left">
							<input type="text" name="tenderInfoAdd.constructorIdCard" />
							</td>
							<th>&nbsp;</th>
							<td colspan="2" align="left">
							&nbsp;
							</td>
                        </tr>
                        
                </tbody> 
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/baocun.jpg" onclick="goBack()" />
		        </div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
