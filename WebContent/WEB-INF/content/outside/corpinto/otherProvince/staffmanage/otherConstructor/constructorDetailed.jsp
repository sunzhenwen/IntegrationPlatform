<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>外省企业注册执业人员</title>
<link rel="stylesheet" href="css/style.css" type="text/css" >
<link href="css/style20151026.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	//查询
	function queryConstructor()
	{
		document.form1.action="<%=basepath %>/OtherConstructorAction_queryPage.action";
		document.form1.submit();
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

<div class="tit"><img src="images/titico1.gif"/><strong>外省企业注册执业人员详细</strong><p>注：标记为（<span class="red">*</span>）的为必填项</p></div>
            <div class="main h384">
            	<div class="list g2">
                	<form id="form1" name="form1" method="post" action="">
                	<table id="tb" width="100%" border="0" cellspacing="0" cellpadding="0" >
                      <tr>
                         	<td width="17%">姓名：</td>
                            <td width="32%">
							<input type="text" value="<s:property value="constructor.personName"/>" class="ipu1" />
							</td>
                            <td width="19%">证件类型：</td>
                            <td width="32%">
							<input type="text" value="<s:property value="constructor.idCardTypeName"/>" class="ipu1" />
							
							</td>
                            
                         </tr>
                         <tr>
                         	<td>证件号码：</td>
                            <td>
							<input type="text" value="<s:property value="constructor.idCard"/>" class="ipu1" />
							
							</td>
                            <td>注册类型及等级：</td>
                            <td>
							<input type="text" value="<s:property value="constructor.sepecialtyTypName"/>" class="ipu1" />
							
							</td>
                           
                          
                         </tr>
                           <tr>
                         	<td>注册证书编号：</td>
                            <td>
							<input type="text" value="<s:property value="constructor.certNum"/>" class="ipu1" />
							
							</td>
                            <td>发证日期：</td>
                            <td>
							<input type="text" value="<s:date name="constructor.awardDate" format="yyyy-MM-dd" />" class="ipu1" />
							
							</td>
                          
                          
                         </tr>
                         <tr>
                         	<td>发证单位：</td>
                            <td>
							<input type="text" value="<s:property value="constructor.awardDepart"/>" class="ipu1" />
							
							</td>
                            <td>执业印章号：</td>
                            <td>
							<input type="text" value="<s:property value="constructor.stampNum"/>" class="ipu1" />
							
							</td>
                           
                         </tr>
                         
                           <tr>
                         	<td>注册有效期：</td>
                            <td>
							<input type="text" value="<s:date name="constructor.effectDate" format="yyyy-MM-dd" />" class="ipu1" />
							
							</td>
                            <td>所在企业行业类型（1-8）：</td>
                            <td>
							<input type="text" value="<s:property value="constructor.callingTypeName"/>" class="ipu1" />
							
							</td>
                          
                         </tr>
                         <tr>
                         	<td>所在企业名称：</td>
                            <td>
							<input type="text" value="<s:property value="constructor.corpName"/>" class="ipu1" />
							
							</td>
                            <td>所在企业组织代码证（1-8）：</td>
                            <td>
							<input type="text" value="<s:property value="constructor.corpCode"/>" class="ipu1" />
							
							</td>
                            
                          
                         </tr>
                         <tr>
                         	<td>所在企业证书编号：</td>
                            <td>
							<input type="text" value="<s:property value="constructor.certId"/>" class="ipu1" />
							
							</td>
                            <td>注册专业编号（1-8）：</td>
                            <td>
							<input type="text" value="<s:property value="constructor.regTradeTypeNum"/>" class="ipu1" />
							
							</td>
                            
                          
                         </tr>
                           <tr>
                         	<td>注册开始日期：</td>
                            <td>
							<input type="text" value="<s:date name="constructor.tradeTypeAwardDate" format="yyyy-MM-dd" />" class="ipu1" />
							
							</td>
                            <td>注册截止日期（1-8）：</td>
                            <td>
							<input type="text" value="<s:date name="constructor.tradeTypeEffectDate" format="yyyy-MM-dd" />" class="ipu1" />
							
							</td>
                        </tr>
                         <tr>
                         	<td>职业资格状态：</td>
                            <td>
							<input type="text" value="<s:property value="constructor.stateName"/>" class="ipu1" />
							
							</td>
							<td>&nbsp;</td>
                            <td>
							&nbsp;
							</td>
                      </tr>
                       <tr>
                        <td>&nbsp;</td>
                        <td>
						<input type="button" class="btn" value="返回" onclick="goBack()" />
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
