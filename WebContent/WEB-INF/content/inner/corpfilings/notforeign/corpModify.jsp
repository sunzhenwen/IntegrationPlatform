<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>审批</title>
<script type="text/javascript">
	
	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            form.submit();
	        }    
	 	});
	});
	
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
	
	//查询市
	function queryCity(){
	       $(document).ready(function(){
	           //获取省
	           var provinceId = $("#provinceId").val();
	           //执行城市ajax查询
	           $.ajax({
	               url: 'corpFilingsAction_queryCity.action',
	               type: 'post',
	               dataType: 'json',
	               data: 'provinceId='+provinceId,
	               success: function(data){
	            	   //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
	                   var items = eval("("+data+")");
	                   //清空城市列表避免重复
	            	   $("#cityId").empty();
	            	   $("#areaId").empty();
	                   $("#cityId").append("<option value=''>请选择</option>");
	                   $("#areaId").append("<option value=''>请选择</option>");
	                   //获取对象中标识用于判断选中
	                   var cityNum='<s:property value="corp.cityNum"/>';
	                   //循环items,i为循环下标,(默认i从0开始取值)
	                   $.each(items,function(i){
	                	   //如果返回列表中有与对象中标识相等的执行
	                	   if(items[i].code==cityNum)
	                       {
	                		    //拼接判断默认选中
	                		    $("#cityId").append("<option value='" + items[i].code+ "' selected >" + items[i].name + "</option>");
	                		    //自动执行ajax查询区
	                		    $.ajax({
	         		               url: 'corpFilingsAction_queryArea.action',
	         		               type: 'post',
	         		               dataType: 'json',
	         		               data: 'cityNum='+cityNum,
	         		               success: function(data){
	         		            	   //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
	         		                   var itemss = eval("("+data+")");
	         		            	   //循环items,i为循环下标,(默认i从0开始取值)
	         		                   $("#areaId").empty();
	         		                   var area ='<s:property value="corp.countyNum"/>';
	         		                   $.each(itemss,function(i){
	         		                   
	         		                	   if(itemss[i].code==area)
	         		                       {
	         		                		    $("#areaId").append("<option value='" + itemss[i].code+ "' selected >" + itemss[i].name + "</option>");
	         		                       }else
	         		                       {
	         		                    	    $("#areaId").append("<option value='" + itemss[i].code+ "' >" + itemss[i].name + "</option>");
	         		                       }
	         		                	});  
	         		               }
	         		           });
	                       }else
	                       {
	                    	    //如果没有清空区，让用户自己选择
	                       		$("#cityId").append("<option value='" + items[i].code+ "' >" + items[i].name + "</option>");
	                       		$("#areaId").empty();
	                       }
	                	   
	                   });
	                   
	               }
	           });
	       });
	   }
	
		//查询区
		function queryArea(){
				$(document).ready(function(){
		           //获取部门下拉列表的值
		           var cityNum = $("#cityId").val();
		           $.ajax({
		               url: 'corpFilingsAction_queryArea.action',
		               type: 'post',
		               dataType: 'json',
		               data: 'cityNum='+cityNum,
		               success: function(data){
		            	   //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
		                   var items = eval("("+data+")");
		                   //循环items,i为循环下标,(默认i从0开始取值)
		                   $("#areaId").empty();
		                   var area ='<s:property value="corp.countyNum"/>';
		                   $.each(items,function(i){
		                   
		                	   if(items[i].code==area)
		                       {
		                		    $("#areaId").append("<option value='" + items[i].code+ "' selected >" + items[i].name + "</option>");
		                       }else
		                       {
		                       		$("#areaId").append("<option value='" + items[i].code+ "' >" + items[i].name + "</option>");
		                       }
		                	});  
		               }
		           });
		       });
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
</script>
</head>

<body onload="queryCity(),checkForeignCorp()">
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#3874d3;">企业信息备案审批</h2>
         <form style="margin:50px;" id="form1" name="form1" method="post" action="<%=basepath %>/corpFilingsAction_modifyCorp.action">
			<table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
               
                <tr>
                	<td>企业名称：</td>
                	<td>
					<input type="text"  maxlength='200'  value="<s:property value="corp.corpName" />" name="corp.corpName" class="required" /><strong><font color="#FF0000">*</font></strong>
                	<input type="hidden" value="<s:property value="corp.corpId" />" name="corp.corpId" />
					</td>
                    <td>组织机构代码：</td>
               		<td>
					<input type="text" value="<s:property value="corp.corpCode" />" name="corp.corpCode" class="required" /><strong><font color="#FF0000">*</font></strong>
					</td>
                   
                </tr>
                <tr>
                	<td>是否外商投资：</td>
                    <td><select id="checkForeign" name="corp.checkForeign" onchange="checkForeignCorp()" class="required">
                    	<option value="0" <s:if test='corp.checkForeign==0'>selected</s:if>>是</option>
                    	<option value="1" <s:if test='corp.checkForeign==1'>selected</s:if>>否</option>
					</select><strong><font color="#FF0000">*</font></strong>
                     </td>  
               
                    <td>工商营业执照注册号：</td>
                    <td><input type="text" maxlength='30'  value="<s:property value="corp.licenseNum" />" name="corp.licenseNum" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                
				<tr>
                	<td>企业归属地：</td>
                    <td><select name="corp.spare1" class="required">
                       <option value="">请选择</option>
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
    				</select><strong><font color="#FF0000">*</font></strong>
                     </td>  
               
                    <td>净资产：</td>
                    <td><input type="text"  maxlength='15' value="<s:property value="corp.assets"/>"  name="corp.assets" class="{required:true,number:true}" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>



				<tr id="foreignCorpName">
                	<td>外商投资者名称：</td>
                	<td>
                	<input type="text" maxlength='200' value="<s:property value="corp.foreignCorpName"/>" name="corp.foreignCorpName"  /><strong><font color="#FF0000">*</font></strong>
                	</td>
					<td>国籍或地域：</td>
                	<td>
                	<select name="corp.nationNume" >
                    	<option value="">请选择</option>
                    	<s:iterator value="nations">
						<option value="<s:property value="code"/>" <s:if test='corp.nationNume==code'>selected</s:if>><s:property value="name"/></option>
						
						</s:iterator>
					</select><strong><font color="#FF0000">*</font></strong>
                	</td>
                </tr>
                <tr id="percentTage">
                	<td>外商投资所占比例：</td>
                	<td>
                	<input type="text"  maxlength='200' value="<s:property value="corp.percentTage"/>" name="corp.percentTage"  /><strong><font color="#FF0000">*</font></strong>
                	</td>
					<td>外商投资这类型 ：</td>
                	<td>
                	<select name="corp.foreignIvestor" >
                    	<option value="0" <s:if test='corp.foreignIvestor==0'>selected</s:if>>境外企业</option>
						<option value="1" <s:if test='corp.foreignIvestor==1'>selected</s:if>>境外自然人</option>
					</select><strong><font color="#FF0000">*</font></strong>
                	</td>
                </tr>
                










                <tr>
                    <td>注册所在省（自治区、直辖市）：</td>
                    <td><select id="provinceId" name="corp.provinceNum" onchange="queryCity()" class="required" >
                    <s:iterator value="provinces">
						<option value="<s:property value="code"/>" <s:if test='corp.provinceNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong>
                    </td>
                 
				
                    <td>注册所在地（市、州、盟）：
                    </td>
                    <td><select id="cityId" name="corp.cityNum" onchange="queryArea()" class="required" >
                    <s:iterator value="citys">
						<option value="<s:property value="code"/>" <s:if test='corp.cityNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong>
                        </td>
                </tr>
                <tr>
                    <td>注册所在县（区、市、旗）：</td>
                    <td><select id="areaId" name="corp.countyNum" class="required" >
                	 <s:iterator value="areas">
						<option value="<s:property value="code"/>" <s:if test='corp.countyNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong>
                    </td>
                
                    <td>企业营业地址：</td>
                    <td><input type="text" maxlength='200'  value="<s:property value="corp.address" />" name="corp.address" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                <tr>
                    <td>企业营业地址邮政编码：</td>
                    <td><input type="text" maxlength='6'  value="<s:property value="corp.postalCode" />" name="corp.postalCode" />&nbsp;&nbsp;</td>
               
                    <td>法定代表人姓名：</td>
                    <td><input type="text" maxlength='50'  value="<s:property value="corp.legalMan" />" name="corp.legalMan" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                <tr>
                    <td>法定代表人证件类型：</td>
                    <td><select id="" name="corp.idCardTypeNum" >
                    <s:iterator value="idCardType">
						<option value="<s:property value="code"/>" <s:if test='corp.idCardTypeNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong></td>
               
                    <td>法定代表人证件号码：</td>
                    <td><input type="text" maxlength='30'  value="<s:property value="corp.legalManIdCard" />" name="corp.legalManIdCard" class="{required:true,digits:true}" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                <tr>
                    <td>法定代表职务：</td>
                    <td><input type="text"  maxlength='50'  value="<s:property value="corp.legalManDuty" />" name="corp.legalManDuty" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                
                    <td>法定代表职称：</td>
                    <td><input type="text" maxlength='50'  value="<s:property value="corp.legaManProtitle" />" name="corp.legaManProtitle" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
            
           
            
                
                <tr>
                    <td>企业登记注册类型：</td>
                    <td><select id="" name="corp.economicNum" >
                    <s:iterator value="economicNum">
						<option value="<s:property value="code"/>" <s:if test='corp.economicNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong></td>
                 
                    <td>注册资本（万元）：</td>
                    <td><input type="text" maxlength='15'  value="<s:property value="corp.regPrin" />" name="corp.regPrin" class="{required:true,number:true}" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                    <tr><td>实收资本（万元）：</td>
                    <td><input type="text"  maxlength='15'  value="<s:property value="corp.factRegPrin" />" name="corp.factRegPrin" class="{required:true,number:true}" /><strong><font color="#FF0000">*</font></strong></td>
               
                    <td>注册资本币种：</td>
                    <td><select id="" name="corp.principalUnitNum" >
                    <s:iterator value="principalUnit">
						<option value="<s:property value="code"/>" <s:if test='corp.principalUnitNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong></td>
                    </tr>
                <tr>
                <td>成立日期：</td><td><input id="time1" type="text" value="<s:date name="corp.corpBirthDate" format="yyyy-MM-dd" />" name="corp.corpBirthDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
               <td>办公电话：</td><td><input type="text" maxlength='30'  value="<s:property value="corp.officePhone" />" name="corp.officePhone" class="required" /><strong><font color="#FF0000">*</font></strong></td>
               </tr>
                <tr>
                    <td>传真号码：</td><td><input type="text" maxlength='30'  value="<s:property value="corp.fax" />" name="corp.fax" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                    
                    <td>联系人姓名：</td><td><input type="text" maxlength='50'  value="<s:property value="corp.linkMan" />" name="corp.linkMan" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                <tr>
                    <td>联系人办公电话：</td><td><input type="text" maxlength='30'  value="<s:property value="corp.linkTel" />" name="corp.linkTel" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                    
                    <td>联系人手机号码：</td><td><input type="text" maxlength='30'  value="<s:property value="corp.linkPhone" />" name="corp.linkPhone" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                <tr>
                    <td>联系邮箱：</td><td><input type="text" maxlength='50'  value="<s:property value="corp.email" />" name="corp.email" class="email" />&nbsp;&nbsp;</td>
                    
                    <td>企业网址：</td><td><input type="text" maxlength='200'  value="<s:property value="corp.url" />" name="corp.url" class="url" />&nbsp;&nbsp;</td>
                </tr>
				<tr style="height:60px; border:0">
                	<td >备注：</td>
                	<td colspan="3"><textarea name="corp.description"><s:property value="corp.description" /></textarea></td>
                </tr>
                <tr style="height:60px; border:0">
                    <td >审批建议：</td>
               		<td colspan="3"> <textarea name="corp.applyOpinion"><s:property value="corp.applyOpinion"/></textarea> </td>
                </tr>
               
           
            </table>
            <div class="sp_bton"> 
        	<input type="image" src="<%=basepath %>/images/tongguolv.png" />
            <input type="image" onclick="goBack()" src="<%=basepath %>/images/quxiao.png" />
            </div>
       
        
 		</form>
    	</div>
  </div>
</body>
</html>
