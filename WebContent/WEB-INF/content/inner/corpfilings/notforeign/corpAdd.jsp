<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>审批</title>
<script type="text/javascript" src="<%=basepath%>/js/validator.js"></script>
<script type="text/javascript">
	function validateForm() 
	{
		return Validator.Validate(form1,2);
	}
	function required () 
	{
		this.aa = new Array("corpName", "企业名称不能为空。", new Function ("varName", " return this[varName];"));
		this.ab = new Array("corp.licenseNum", "工商营业执照注册号不能为空。", new Function ("varName", " return this[varName];"));
		this.ac = new Array("corp.address", "企业营业地址不能为空。", new Function ("varName", " return this[varName];"));
		this.ad = new Array("corp.postalCode", "邮政编码不能为空。", new Function ("varName", " return this[varName];"));
		this.ae = new Array("corp.legalMan", "法定代表人姓名不能为空。", new Function ("varName", " return this[varName];"));
		this.af = new Array("corp.legalManIdCard", "法定代表人证件号码不能为空。", new Function ("varName", " return this[varName];"));
		this.ag = new Array("corp.legalManDuty", "法定代表职务不能为空。", new Function ("varName", " return this[varName];"));
		this.ah = new Array("corp.legaManProtitle", "法定代表职称不能为空。", new Function ("varName", " return this[varName];"));
		this.ai = new Array("corp.regPrin", "注册资本不能为空。", new Function ("varName", " return this[varName];"));
		this.aj = new Array("corp.factRegPrin", "实收资本不能为空。", new Function ("varName", " return this[varName];"));
		this.ak = new Array("corp.corpBirthDate", "成立日期不能为空。", new Function ("varName", " return this[varName];"));
		this.al = new Array("corp.officePhone", "办公电话不能为空。", new Function ("varName", " return this[varName];"));
		this.am = new Array("corp.fax", "传真号码不能为空。", new Function ("varName", " return this[varName];"));
		this.an = new Array("corp.linkMan", "联系人姓名不能为空。", new Function ("varName", " return this[varName];"));
		this.ao = new Array("corp.linkTel", "联系人办公电话不能为空。", new Function ("varName", " return this[varName];"));
		this.ap = new Array("corp.linkPhone", "联系人手机号码不能为空。", new Function ("varName", " return this[varName];"));
	}

	
	//textare限制I长度
	function checkMaxInput(txt)
	{
	       if (txt.value.length > 500)
	       txt.value = txt.value.substring(0, 500);
	}
	
	
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
		document.form1.action="<%=basepath %>/corpFilingsAction_goBack.action";
		document.form1.submit();
	}
	
	//查询市
	function queryCity(){
	       $(document).ready(function(){
	           //获取部门下拉列表的值
	           var provinceId = $("#provinceId").val();
	           $.ajax({
	               url: 'corpFilingsAction_queryCity.action',
	               type: 'post',
	               dataType: 'json',
	               data: 'provinceId='+provinceId,
	               success: function(data){
	            	   //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
	                   var items = eval("("+data+")");
	                   $("#cityId").empty();
	                   $("#areaId").empty();
	                   $("#cityId").append("<option value=''>请选择</option>");
	                   $("#areaId").append("<option value=''>请选择</option>");
	                   //循环items,i为循环下标,(默认i从0开始取值)
	                   $.each(items,function(i){
	                       $("#cityId").append("<option value='" + items[i].code+ "'>" + items[i].name + "</option>");
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
		                   $("#areaId").empty();
		                   //循环items,i为循环下标,(默认i从0开始取值)
		                   $.each(items,function(i){
		                       $("#areaId").append("<option value='" + items[i].code+ "'>" + items[i].name + "</option>");
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
		
		//操作提示信息
		function getMessage()
		{
			var message = document.getElementById("message").value;
			if(message != "")
			{
				alert(message);
			}
		}
</script>
</head>

<body onload="checkForeignCorp();getMessage()">
<input type="hidden" id="message" value="<s:property value="message" />" />
 
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#3874d3;">企业信息备案审批</h2>
         <form style="margin:50px;" id="form1" name="form1" method="post" action="<%=basepath %>/corpFilingsAction_addCorp.action" onsubmit="return validateForm()">
            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
               
                <tr>
                	<td>企业名称：</td>
                	<td>
                	<input type="text"  maxlength='200' id="corpName" value ="<s:property value = "corp.corpName"/>"  name="corp.corpName" class="required"  /><strong><font color="#FF0000">*</font></strong>
                	</td>
                    <td>组织机构代码：</td>
               		<td>
               		<input type = "text" name="corp.corpCode" value = "<s:property value = "corp.corpCode"/>" class="required" /><strong><font color="#FF0000">*</font></strong>
               		</td>
                </tr>
               
                <tr>
                    <td>是外商投资资：</td>
                    <td><select id="checkForeign" name="corp.checkForeign" onchange="checkForeignCorp()" class="required">
                    	<option value="">请选择</option>
                    	<option value="0" <s:if test='corp.checkForeign==0'>selected</s:if>>是</option>
						<option value="1" <s:if test='corp.checkForeign==1'>selected</s:if>>否</option>
					</select><strong><font color="#FF0000">*</font></strong>
                     </td>  
               
                    <td>工商营业执照注册号：</td>
                    <td><input type="text"  maxlength='30' id="corp.licenseNum" value ="<s:property value = "corp.licenseNum"/>"  name="corp.licenseNum" class="required" /><strong><font color="#FF0000">*</font></strong></td>
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
                    <td><input type="text"  maxlength='15' id="corp.assets" value ="<s:property value = "corp.assets"/>" name="corp.assets" class="{required:true,number:true}" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                 <tr id="foreignCorpName">
                	<td>外商投资者名称：</td>
                	<td>
                	<input type="text" maxlength='200' name="corp.foreignCorpName" value ="<s:property value = "corp.foreignCorpName"/>"  /><strong><font color="#FF0000">*</font></strong>
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
                	<input type="text"  maxlength='200' name="corp.percentTage" value ="<s:property value = "corp.percentTage"/>"  /><strong><font color="#FF0000">*</font></strong>
                	</td>
					<td>外商投资这类型 ：</td>
                	<td>
                	<select name="corp.foreignIvestor" >
                    	<option value="">请选择</option>
						<option value="0" <s:if test='corp.foreignIvestor==0'>selected</s:if>>境外企业</option>
						<option value="1" <s:if test='corp.foreignIvestor==1'>selected</s:if>>境外自然人</option>
					</select><strong><font color="#FF0000">*</font></strong>
                	</td>
                </tr>



                <tr>
                    <td>注册所在省(自治区、直辖市)：</td>
                    <td><select id="provinceId" name="corp.provinceNum" onchange="queryCity()" class="required">
                    <option value="">请选择</option>
                    <s:iterator value="provinces">
						<option value="<s:property value="code"/>" <s:if test='corp.provinceNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong>
                    </td>
                 
				
                    <td>注册所在地(市、州、盟)：
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
                    <td><input type="text"  maxlength='200' id="corp.address" value ="<s:property value = "corp.address"/>"  name="corp.address" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                <tr>
                    <td>企业营业地址邮政编码：</td>
                    <td><input type="text"  maxlength='6' id="corp.postalCode" value ="<s:property value = "corp.postalCode"/>"  name="corp.postalCode" />&nbsp;&nbsp;</td>
               
                    <td>法定代表人姓名：</td>
                    <td><input type="text"  maxlength='50' id="corp.legalMan" value ="<s:property value = "corp.legalMan"/>" name="corp.legalMan" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                <tr>
                    <td>法定代表人证件类型：</td>
                    <td><select id="" name="corp.idCardTypeNum" class="required" >
                    <option value="">请选择</option>
                    <s:iterator value="idCardType">
						<option value="<s:property value="code"/>" <s:if test='corp.idCardTypeNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong></td>
               
                    <td>法定代表人证件号码：</td>
                    <td><input type="text"  maxlength='30' id="corp.legalManIdCard" value ="<s:property value = "corp.legalManIdCard"/>" name="corp.legalManIdCard" class="{required:true,digits:true}" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                <tr>
                    <td>法定代表职务：</td>
                    <td><input type="text" id="corp.legalManDuty" value ="<s:property value = "corp.legalManDuty"/>" name="corp.legalManDuty" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                
                    <td>法定代表职称：</td>
                    <td><input type="text"  maxlength='50' id="corp.legaManProtitle" value ="<s:property value = "corp.legaManProtitle"/>"  name="corp.legaManProtitle" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
            
           
            
                
                <tr>
                    <td>企业登记注册类型：</td>
                    <td><select id="" name="corp.economicNum" class="required" >
                    <option value="">请选择</option>
                    <s:iterator value="economicNum">
						<option value="<s:property value="code"/>" <s:if test='corp.economicNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong></td>
                 
                    <td>注册资本（万元）：</td>
                    <td><input type="text"  maxlength='15' id="corp.regPrin" value ="<s:property value = "corp.regPrin"/>" name="corp.regPrin" class="{required:true,number:true}" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                    <tr><td>实收资本（万元）：</td>
                    <td><input type="text"  maxlength='15' id="corp.factRegPrin" value ="<s:property value = "corp.factRegPrin"/>" name="corp.factRegPrin" class="{required:true,number:true}" /><strong><font color="#FF0000">*</font></strong></td>
               
                    <td>注册资本币种：</td>
                    <td><select id="" name="corp.principalUnitNum" class="required" >
                    <option value="">请选择</option>
                    <s:iterator value="principalUnit">
						<option value="<s:property value="code"/>" <s:if test='corp.principalUnitNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong></td>
                    </tr>
                <tr>
                <td>成立日期：</td><td><input id="time1" type="text"  id="corp.corpBirthDate" value="<s:date name="corp.corpBirthDate" format="yyyy-MM-dd" />" name="corp.corpBirthDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
               <td>办公电话：</td><td><input type="text"  maxlength='30' id="corp.officePhone" value ="<s:property value = "corp.officePhone"/>" name="corp.officePhone" class="required" /><strong><font color="#FF0000">*</font></strong></td>
               </tr>
                <tr>
                    <td>传真号码：</td><td><input type="text"  maxlength='30' id="corp.fax" value ="<s:property value = "corp.fax"/>"  name="corp.fax" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                    
                    <td>联系人姓名：</td><td><input type="text" maxlength='50' id="corp.linkMan" value ="<s:property value = "corp.linkMan"/>"  name="corp.linkMan" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                <tr>
                    <td>联系人办公电话：</td><td><input type="text" maxlength='30' id="corp.linkTel" value ="<s:property value = "corp.linkTel"/>"  name="corp.linkTel" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                    
                    <td>联系人手机号码：</td><td><input type="text" maxlength='30' id="corp.linkPhone" value ="<s:property value = "corp.linkPhone"/>" name="corp.linkPhone" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                <tr>
                    <td>联系邮箱：</td><td><input type="text" maxlength='50'  name="corp.email" value ="<s:property value = "corp.email"/>" class="email" />&nbsp;&nbsp;</td>
                    
                    <td>企业网址：</td><td><input type="text" maxlength='200'  name="corp.url" value ="<s:property value = "corp.url"/>" class="url" />&nbsp;&nbsp;</td>
                </tr>
				<tr style="height:60px; border:0" >
                	<td >备注：</td>
                	<td colspan="3"><textarea  name="corp.description" ><s:property value = "corp.description"/></textarea></td>
                </tr>
                <tr style="height:60px; border:0">
                    <td >审批建议：</td>
               		<td colspan="3"> <textarea name="corp.applyOpinion" class="required"><s:property value = "corp.applyOpinion"/></textarea></td>
                    
                    
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
