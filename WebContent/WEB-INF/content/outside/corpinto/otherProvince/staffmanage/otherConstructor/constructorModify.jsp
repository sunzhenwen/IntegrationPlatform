<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外省企业注册执业人员</title>
<link rel="stylesheet" href="css/style.css" type="text/css" >
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

	//验证字段
	function check()
	{
		var check = true;
		if(document.getElementById('name').value==""){
			alert("请输入姓名!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('idCardType').value==""){
	   		alert("请选择证件类型!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('cardId').value==""){
	   		alert("请输入证件号码!");
	   		check = false;
	   		return check;
	   	}
		if(document.getElementById('cardId').value!=""){
	   		var re = /^[0-9]*[1-9][0-9]*$/;//判断正整数
	   		if(re.test(document.getElementById('cardId').value) === false)
	   		{
	   			alert("证件号码不合法!");
	       		check = false;
	       		return check;
	   		}
	   	}
	   	if(document.getElementById('sexNum').value==""){
	   		alert("请选择性别!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('sepecialtyTypNum').value==""){
	   		alert("请选择注册类型及等级!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('callingTypeNum').value==""){
	   		alert("请选择所在企业行业类型!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('certNum').value==""){
	   		alert("请输入注册证书编号!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('time1').value==""){
	   		alert("请选择发证日期!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('awardDepart').value==""){
	   		alert("请输入发证单位!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('stampNum').value==""){
	   		alert("请输入执业印章号!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('time2').value==""){
	   		alert("请选择注册有效期!");
	   		check = false;
	   		return check;
		}
		
		
		
		
		if(document.getElementById('certId').value==""){
	   		alert("请输入所在企业证书编号!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('time3').value==""){
	   		alert("请选择注册开始日期!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('time4').value==""){
	   		alert("请选择注册截止日期!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('regTradeTypeNum').value==""){
	   		alert("请选择人员注册专业!");
	   		check = false;
	   		return check;
		}
		if(document.getElementById('state').value==""){
	   		alert("请选择执业资格状态!");
	   		check = false;
	   		return check;
		}
		
		return check;
	}

	//保存
	function save()
	{
		if(check())
		{
			document.form1.action="<%=basepath %>/otherConstructorAction_modify.action";
			document.form1.submit();
		}
		
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/otherConstructorAction_queryPage.action";
		document.form1.submit();
	}
</script>
</head>

<body>
	<div class="qy_wrapp">
    	<div class="head">
            <div class="head_a1">
               <p class="logo"><img src="images/lg.png"></p>
                 <div class="head_a3">
                     <div class="header-search"> 
                     </div>
                 </div>
            </div>
        </div>
     
     
     
     
     
           <div class="wz">
            	<dl>
                	<dt>当前位置：外省企业备案</dt>
                    
                </dl>
      </div>    
     
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
   
    <td valign="top">
    	<div class="wr">

<div class="tit"><img src="images/titico1.gif"/><strong>外省企业注册执业人员添加</strong><p>注：标记为（<span class="red">*</span>）的为必填项</p></div>
            <div class="main h384">
            	<div class="list g2">
                	<form id="form1" name="form1" method="post" action="">
                	<table id="tb" width="100%" border="0" cellspacing="0" cellpadding="0" >
                      <tr>
                         	<td width="17%">姓名：</td>
                            <td width="32%">
							<input id="name" name="constructor.personName" type="text" value="<s:property value="constructor.personName"/>" class="ipu1" />
							<input name="constructor.personId" type="hidden" value="<s:property value="constructor.personId"/>" class="ipu1" />
							<span class="red">*</span>
							</td>
                            <td width="19%">证件类型：</td>
                            <td width="32%">
							<select id="idCardType" name="constructor.idCardTypeNum" class="sel">
							<option value="">请选择</option>
							<s:iterator value="idCardTypeNums">
								<option value="<s:property value = "code" />"<s:if test='constructor.idCardTypeNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							<span class="red">*</span>
							</td>
                            
                         </tr>
                         <tr>
                         	<td>证件号码：</td>
                            <td>
							<input id="cardId" name="constructor.idCard" type="text" value="<s:property value="constructor.idCard"/>" class="ipu1" />
							<span class="red">*</span>
							</td>
                            <td>性别：</td>
                            <td>
							<select id="sexNum" name="constructor.sexNum" class="sel">
							<option value="">请选择</option>
							<s:if test="constructor.sexNum==0">
								<option value="0" selected>男</option>
								<option value="1">女</option>
							</s:if>
							<s:else>
								<option value="0">男</option>
								<option value="1" selected>女</option>
							</s:else>
							</select>
							<span class="red">*</span>
							</td>
                           
                          
                         </tr>
                         
                         
                         <tr>
                         	<td>生日：</td>
                            <td>
							<input id="time5" type="text" name="constructor.birthday" value="<s:date name="constructor.birthday" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="ipu1" />
							</td>
                            <td>民族：</td>
                            <td>
							<select name="constructor.nationAlityNum" class="sel">
							<option value="">请选择</option>
							<s:iterator value="nationAlityNums">
								<option value="<s:property value = "code" />"<s:if test='constructor.nationAlityNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							</td>
                         </tr>
                         <tr>
                         	<td>学历：</td>
                            <td>
							<select name="constructor.eduLevelNum" class="sel">
							<option value="">请选择</option>
							<s:iterator value="eduLevelNums">
								<option value="<s:property value = "code" />"<s:if test='constructor.eduLevelNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							</td>
                            <td>学位：</td>
                            <td>
							<select name="constructor.degreeNum" class="sel">
							<option value="">请选择</option>
							<s:iterator value="degreeNums">
								<option value="<s:property value = "code" />"<s:if test='constructor.degreeNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							</td>
                           
                          
                         </tr>
                         <tr>
                         	<td>手机号码：</td>
                            <td>
							<input name="constructor.mobile" type="text" value="<s:property value="constructor.mobile"/>" class="ipu1" />
							</td>
                            <td>注册类型及等级：</td>
                            <td>
							<select id="sepecialtyTypNum" name="constructor.sepecialtyTypNum" class="sel">
							<option value="">请选择</option>
							<s:iterator value="sepecialtyTypNums">
								<option value="<s:property value = "code" />"<s:if test='constructor.sepecialtyTypNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							<span class="red">*</span>
							</td>
                           
                          
                         </tr>
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                           <tr>
                         	<td>注册证书编号：</td>
                            <td>
							<input id="certNum" name="constructor.certNum" type="text" value="<s:property value="constructor.certNum"/>" class="ipu1" />
							<span class="red">*</span>
							</td>
                            <td>发证日期：</td>
                            <td>
							<input id="time1" type="text" name="constructor.awardDate" value="<s:date name="constructor.awardDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="ipu1" />
							<span class="red">*</span>
							</td>
                          
                          
                         </tr>
                         <tr>
                         	<td>发证单位：</td>
                            <td>
							<input id="awardDepart" name="constructor.awardDepart" type="text" value="<s:property value="constructor.awardDepart"/>" class="ipu1" />
							<span class="red">*</span>
							</td>
                            <td>执业印章号：</td>
                            <td>
							<input id="stampNum" name="constructor.stampNum" type="text" value="<s:property value="constructor.stampNum"/>" class="ipu1" />
							<span class="red">*</span>
							</td>
                           
                         </tr>
                         
                           <tr>
                         	<td>注册有效期：</td>
                            <td>
							<input id="time2" type="text" name="constructor.effectDate" value="<s:date name="constructor.effectDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="ipu1" />
							<span class="red">*</span>
							</td>
                            <td>所在企业行业类型（1-8）：</td>
                            <td>
							<select id="callingTypeNum" name="constructor.callingTypeNum" class="sel">
							<option value="">请选择</option>
							<s:iterator value="callingTypeNums">
								<option value="<s:property value = "code" />"<s:if test='constructor.callingTypeNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							<span class="red">*</span>
							</td>
                          
                         </tr>
                         
                         <tr>
                         	<td>所在企业证书编号：</td>
                            <td>
							<input id="certId" name="constructor.certId" type="text" value="<s:property value="constructor.certId"/>" class="ipu1" />
							<span class="red">*</span>
							</td>
                            <td>注册开始日期：</td>
                            <td>
							<input id="time3" type="text" name="constructor.tradeTypeAwardDate" value="<s:date name="constructor.tradeTypeAwardDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="ipu1" />
							<span class="red">*</span>
							</td>
                            
                          
                         </tr>
                           <tr>
                         	
                            <td>注册截止日期（1-8）：</td>
                            <td>
							<input id="time4" type="text" name="constructor.tradeTypeEffectDate" value="<s:date name="constructor.tradeTypeEffectDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="ipu1" />
							<span class="red">*</span>
							</td>
							<td>人员注册专业：</td>
                            <td>
							<select id="regTradeTypeNum" name="constructor.regTradeTypeNum" class="sel">
							<option value="">请选择</option>
							<s:iterator value="regTradeTypeNums">
								<option value="<s:property value = "code" />"<s:if test='constructor.regTradeTypeNum==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							<span class="red">*</span>
							</td>
                        </tr>
                        
                        
                        
                        <tr>
                         	
							<td>增项人员注册专业1：</td>
                            <td>
							<select name="constructor.regTradeTypeNum1" class="sel">
							<option value="">请选择</option>
							<s:iterator value="regTradeTypeNums">
								<option value="<s:property value = "code" />"<s:if test='constructor.regTradeTypeNum1==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							</td>
							<td>增项人员注册专业2：</td>
                            <td>
							<select name="constructor.regTradeTypeNum2" class="sel">
							<option value="">请选择</option>
							<s:iterator value="regTradeTypeNums">
								<option value="<s:property value = "code" />"<s:if test='constructor.regTradeTypeNum2==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							</td>
                      </tr>
                        
                      <tr>
                         	
							<td>增项人员注册专业3：</td>
                            <td>
							<select name="constructor.regTradeTypeNum3" class="sel">
							<option value="">请选择</option>
							<s:iterator value="regTradeTypeNums">
								<option value="<s:property value = "code" />"<s:if test='constructor.regTradeTypeNum3==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							</td>
							<td>职业资格状态：</td>
                            <td>
							<select id="state" name="constructor.state" class="sel">
							<option value="">请选择</option>
							<s:iterator value="states">
								<option value="<s:property value = "code" />"<s:if test='constructor.state==code'>selected</s:if>><s:property value="name" /></option>
							</s:iterator>
							</select>
							<span class="red">*</span>
							</td>
                      </tr>
        
                       <tr>
                        <td>&nbsp;</td>
                        <td>
						<input type="button" class="btn" value="返回" onclick="goBack()" />
						<input type="button" class="btn" value="保存" onclick="save()" />
						</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                    </table>
                    </form>
                </div>
            </div>
   		</div>
    </td>
  </tr>
</table>

</div>

<%@include file="/WEB-INF/content/outside/footer.jsp"%> 
</body>
</html>
