<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>审批</title>
<script type="text/javascript">
	
	function checkMaxInput(txt)
	{
	       if (txt.value.length > 500)
	       txt.value = txt.value.substring(0, 500);
	}
	
	
	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/corpFilingsAction_goBack.action";
		document.form1.submit();
	}
	
	function checkForeignCorp()
	{
		var node = $("#checkForeign").val();
		if(node=="0")
		{
			
			$('#foreignCorpName').show();
			$('#percentTage').show();
		}else
		{
			$('#foreignCorpName').hide();
			$('#percentTage').hide();
		}
	}
	
	//审批通过
	function applythrough()
	{
		var nm = document.getElementById("appId");
		if(nm.value != "")
		{
			document.form1.action="<%=basepath %>/corpFilingsAction_applythrough.action";
			document.form1.submit();
		}else
		{
			alert("请输入审批意见!");	
		}
	}
	
	//申请退回
	function applyBack()
	{
		var nmv = document.getElementById("appId");
		if(nmv.value != "")
		{
			document.form1.action="<%=basepath %>/corpFilingsAction_applyThroughBack.action";
			document.form1.submit();
		}else
		{
			alert("请输入审批意见!");	
		}
	}
</script>
</head>

<body onload="checkForeignCorp()">
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#3874d3;">企业信息备案审批</h2>
         <form style="margin:50px;" id="form1" name="form1" method="post" action="">
			<table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
               
                <tr>
                	<td>企业名称：</td>
                	<td>
					<s:property value="corp.corpName" />
                	<input type="hidden" value="<s:property value="corp.corpId" />" name="corp.corpId" />
                	<input type="hidden" value="<s:property value="corp.corpName" />" name="corp.corpName" />
                	<input type="hidden" value="<s:property value="corp.corpCode" />" name="corp.corpCode" />
                	<input type="hidden" value="<s:property value="corp.appType" />" name="corp.appType" />
                	<input type="text" value="<s:property value="corp.spare1" />" name="corp.spare1" />
                	</td>
                    <td>组织机构代码：</td>
               		<td>
					<s:property value="corp.corpCode" />
					</td>
                   
                </tr>
                <tr>
                	<td>是否外商投资：</td>
                    <td>
                    <input type="hidden" value="<s:property value="corp.checkForeign" />" id="checkForeign" />
                    <s:if test='corp.checkForeign==0'>
                    	是
                    </s:if>
                    <s:if test='corp.checkForeign==1'>
                    	否
                    </s:if>
                    </td>  
               
                    <td>工商营业执照注册号：</td>
                    <td><s:property value="corp.licenseNum" /></td>
                </tr>
                
				<tr>
                	<td>企业归属地：</td>
                    <td>
                    <s:if test='corp.spare1==230100'>哈尔滨</s:if>
			       <s:if test='corp.spare1==230200'>齐齐哈尔</s:if>
			       <s:if test='corp.spare1==231000'>牡丹江</s:if>
			       <s:if test='corp.spare1==230600'>大庆</s:if>
			       <s:if test='corp.spare1==230700'>伊春</s:if>
			       <s:if test='corp.spare1==230400'>鹤岗</s:if>
			       <s:if test='corp.spare1==230800'>佳木斯</s:if>
			       <s:if test='corp.spare1==231100'>黑河</s:if>
			       <s:if test='corp.spare1==232700'>大兴安岭地区</s:if>
			       <s:if test='corp.spare1==400021'>森工</s:if>
			       <s:if test='corp.spare1==400022'>绥芬河</s:if>
			       <s:if test='corp.spare1==400023'>抚远</s:if>
			       <s:if test='corp.spare1==230300'>鸡西</s:if>
			       <s:if test='corp.spare1==400020'>农垦</s:if>
			       <s:if test='corp.spare1==230900'>七台河</s:if>
			       <s:if test='corp.spare1==230500'>双鸭山</s:if>
			       <s:if test='corp.spare1==231200'>绥化</s:if>
                     </td>  
               
                    <td>净资产：</td>
                    <td><s:property value="corp.assets"/></td>
                </tr>



				<tr id="foreignCorpName">
                	<td>外商投资者名称：</td>
                	<td>
                	<s:property value="corp.foreignCorpName"/>
                	</td>
					<td>国籍或地域：</td>
                	<td>
                		<s:iterator value="nations">
						<s:if test='corp.nationNume==code'><s:property value="name"/></s:if>
						</s:iterator>
					</td>
                </tr>
                <tr id="percentTage">
                	<td>外商投资所占比例：</td>
                	<td>
                	<s:property value="corp.percentTage"/>
                	</td>
					<td>外商投资这类型 ：</td>
                	<td>
                	<s:if test='corp.foreignIvestor==0'>境外企业</s:if>
                	<s:if test='corp.foreignIvestor==1'>境外自然人</s:if>
                	</td>
                </tr>
                <tr>
                    <td>注册所在省（自治区、直辖市）：</td>
                    <td>
                    <s:iterator value="provinces">
						<s:if test='corp.provinceNum==code'><s:property value="name"/></s:if>
					</s:iterator>
                	</td>
                	<td>注册所在地（市、州、盟）：
                    </td>
                    <td>
                    <s:iterator value="citys">
						<s:if test='corp.cityNum==code'><s:property value="name"/></s:if>
					</s:iterator>
                    
                    </td>
                </tr>
                <tr>
                    <td>注册所在县（区、市、旗）：</td>
                    <td>
                	<s:iterator value="areas">
						<s:if test='corp.countyNum==code'><s:property value="name"/></s:if>
					</s:iterator>
                    </td>
                
                    <td>企业营业地址：</td>
                    <td><s:property value="corp.address" /></td>
                </tr>
                <tr>
                    <td>企业营业地址邮政编码：</td>
                    <td><s:property value="corp.postalCode" /></td>
               
                    <td>法定代表人姓名：</td>
                    <td><s:property value="corp.legalMan" /></td>
                </tr>
                <tr>
                    <td>法定代表人证件类型：</td>
                    <td>
                    <s:iterator value="idCardType">
						<s:if test='corp.idCardTypeNum==code'><s:property value="name"/></s:if>
					</s:iterator>
                	</td>
               
                    <td>法定代表人证件号码：</td>
                    <td><s:property value="corp.legalManIdCard" /></td>
                </tr>
                <tr>
                    <td>法定代表职务：</td>
                    <td><s:property value="corp.legalManDuty" /></td>
                
                    <td>法定代表职称：</td>
                    <td><s:property value="corp.legaManProtitle" /></td>
                </tr>
            	<tr>
                    <td>企业登记注册类型：</td>
                    <td>
                    <s:iterator value="economicNum">
						<s:if test='corp.economicNum==code'><s:property value="name"/></s:if>
					</s:iterator>
                	</td>
                 
                    <td>注册资本（万元）：</td>
                    <td><s:property value="corp.regPrin" /></td>
                </tr>
                    <tr><td>实收资本（万元）：</td>
                    <td><s:property value="corp.factRegPrin" /></td>
               
                    <td>注册资本币种：</td>
                    <td>
                    <s:iterator value="principalUnit">
						<s:if test='corp.principalUnitNum==code'><s:property value="name"/></s:if>
					</s:iterator>
                	</td>
                    </tr>
                <tr>
                <td>成立日期：</td><td><s:date name="corp.corpBirthDate" format="yyyy-MM-dd" /></td>
               <td>办公电话：</td><td><s:property value="corp.officePhone" /></td>
               </tr>
                <tr>
                    <td>传真号码：</td><td><s:property value="corp.fax" /></td>
                    
                    <td>联系人姓名：</td><td><s:property value="corp.linkMan" /></td>
                </tr>
                <tr>
                    <td>联系人办公电话：</td><td><s:property value="corp.linkTel" /></td>
                    
                    <td>联系人手机号码：</td><td><s:property value="corp.linkPhone" /></td>
                </tr>
                <tr>
                    <td>联系邮箱：</td><td><s:property value="corp.email" /></td>
                    
                    <td>企业网址：</td><td><s:property value="corp.url" /></td>
                </tr>
				<tr style="height:60px; border:0">
                	<td >备注：</td>
                	<td colspan="3"><textarea name="corp.description"><s:property value="corp.description" /></textarea></td>
                </tr>
                <tr style="height:60px; border:0">
                    <td >审批建议：</td>
               		<td colspan="3"> <textarea id="appId" name="corp.applyOpinion"><s:property value="corp.applyOpinion"/></textarea> </td>
                </tr>
               
           
            </table>
            <div class="sp_bton"> 
        	<input type="image" onclick="applythrough()" src="<%=basepath %>/images/tongguolv.png" />
        	<input type="image" onclick="applyBack()" src="<%=basepath %>/images/weitongguo.png" />
            <input type="image" onclick="goBack()" src="<%=basepath %>/images/quxiao.png" />
            </div>
       
        
 		</form>
    	</div>
  </div>
</body>
</html>
