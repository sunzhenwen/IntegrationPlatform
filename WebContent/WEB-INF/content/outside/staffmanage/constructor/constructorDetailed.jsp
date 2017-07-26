<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册执业人员基本情况 </title>
<script type="text/javascript">
	//查询
	function queryConstructor()
	{
		document.form1.action="<%=basepath %>/constructorAction_queryPage.action";
		document.form1.submit();
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/constructorAction_queryPage.action";
		document.form1.submit();
	}
</script>
</head>

<body >
<form id="form1" name="form1" method="post" action="">
	<div class="ry_wrapp">
    	
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>注册执业人员基本信息</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>姓名：</th>
                            <td><s:property value="constructor.personName"/></td>
                            <th>证件类型：</th>
                            <td><s:property value="constructor.idCardTypeName"/></td>
                            
                         </tr>
                         <tr>
                         	<th>证件号码：</th>
                            <td><s:property value="constructor.idCard"/></td>
                            <th>注册类型及等级：</th>
                            <td><s:property value="constructor.sepecialtyTypName"/></td>
                           
                          
                         </tr>
                           <tr>
                         	<th>注册证书编号：</th>
                            <td><s:property value="constructor.certNum"/></td>
                            <th>发证日期：</th>
                            <td><s:date name="constructor.awardDate" format="yyyy-MM-dd" /></td>
                          
                          
                         </tr>
                         <tr>
                         	<th>发证单位：</th>
                            <td><s:property value="constructor.awardDepart"/></td>
                            <th>执业印章号：</th>
                            <td><s:property value="constructor.stampNum"/></td>
                           
                         </tr>
                         
                           <tr>
                         	<th>注册有效期：</th>
                            <td><s:date name="constructor.effectDate" format="yyyy-MM-dd" /></td>
                            <th>所在企业行业类型（1-8）：</th>
                            <td><s:property value="constructor.callingTypeName"/></td>
                          
                         </tr>
                         <tr>
                         	<th>所在企业名称：</th>
                            <td><s:property value="constructor.corpName"/></td>
                            <th>所在企业组织代码证（1-8）：</th>
                            <td><s:property value="constructor.corpCode"/></td>
                            
                          
                         </tr>
                         <tr>
                         	<th>所在企业证书编号：</th>
                            <td><s:property value="constructor.certId"/></td>
                            <th>注册专业编号（1-8）：</th>
                            <td><s:property value="constructor.regTradeTypeNum"/></td>
                            
                          
                         </tr>
                           <tr>
                         	<th>注册开始日期：</th>
                            <td><s:date name="constructor.tradeTypeAwardDate" format="yyyy-MM-dd" /></td>
                            <th>注册截止日期（1-8）：</th>
                            <td><s:date name="constructor.tradeTypeEffectDate" format="yyyy-MM-dd" /></td>
                        </tr>
                         <tr>
                         	<th>职业资格状态：</th>
                            <td><s:property value="constructor.stateName"/></td>
                      </tr>
                      
             	</tbody>  
                </table>
                 <div class="botn"> 
        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
            </div>
                
                </div> 
            </div>
                 
         </div>
         	
    
        <%@include file="/WEB-INF/content/outside/footer.jsp"%> 
    </div>
	</form>
</body>
</html>
