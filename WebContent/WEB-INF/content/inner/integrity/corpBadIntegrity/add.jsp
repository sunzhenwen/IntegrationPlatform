<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业不良行为信息</title>
<script type="text/javascript" src="<%=basepath%>/js/validator.js"></script>
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
		document.form1.action="<%=basepath %>/corpBadIntegrityAction_goBack.action";
		document.form1.submit();
	}
	
	//查询市
	function queryCity(){
	       $(document).ready(function(){
	           //获取部门下拉列表的值
	           var provinceId = $("#provinceId").val();
	           $.ajax({
	               url: 'corpBadIntegrityAction_queryCity.action',
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
		               url: 'corpBadIntegrityAction_queryArea.action',
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
		
		//查询企业
		function queryCorp()
		{
			var url="<%=basepath %>/queryCorpsAction_queryPage.action";
			var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
			newWin.open()
		}
		
		//不良行为代码
		function queryCreditCode()
		{
			var url="<%=basepath %>/queryCreditCodeAction_queryPage.action";
			var newCreditCode=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1400px;');
			newCreditCode.open()
		}
		
		//查询项目信息
		function queryProject()
		{
			var url="<%=basepath%>/queryProjectInfoAction_queryPage.action";
			var newWin = window
					.showModalDialog(url, window,
							'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
			newWin.open()
		}
</script>
</head>

<body>
 
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#3874d3;">企业不良行为信息</h2>
         <form style="margin:50px;" id="form1" name="form1" method="post" action="<%=basepath %>/corpBadIntegrityAction_add.action" >
            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
               
               	<tr>
                	<td>不良行为分类：</td>
                	<td>
                	<select name="corpBadIntegrity.creditClassNum" >
                    	<option value="">请选择</option>
                    	<s:iterator value="creditClassNums">
						<option value="<s:property value="code"/>" <s:if test='corpBadIntegrity.creditClassNum==code'>selected</s:if>><s:property value="name"/></option>
						</s:iterator>
					</select><strong><font color="#FF0000">*</font></strong>
                	</td>
                    <td>企业类型：</td>
               			<td>
						<input type="hidden" id="economicNum"  readonly name="corpBadIntegrity.certTypeNum" />
						<input type="text" id="economicName"  readonly />
						<strong><font color="#FF0000">*</font></strong></td>
                </tr>
               
                <tr>
                	<td>企业名称：</td>
                	<td>
                	<input id="corpName" readonly type="text" maxlength='200' name="corpBadIntegrity.corpName" class="required"  /><a href="#" onclick="queryCorp()">选择</a>
                	</td>
                    <td>组织机构代码：</td>
               		<td>
               		<input id="corpCode" readonly type="text" name="corpBadIntegrity.corpCode" class="required" /><strong><font color="#FF0000">*</font></strong>
               		</td>
                </tr>
               
                <tr>
                    <td>项目编号：</td>
                    <td><input type="text" id="prjNum" readonly maxlength='30' name="corpBadIntegrity.prjNum" class="required" /><a href="#" onclick="queryProject()">选择</a><strong><font color="#FF0000">*</font></strong></td>
                    <td>工程名称：</td>
                    <td>
                    <input type="text" id="prjName" readonly maxlength='30' name="corpBadIntegrity.prjName" class="required" /><strong><font color="#FF0000">*</font></strong>
                    </td>  
               </tr>
                 <tr>
                   <td>工程地址：</td>
                    <td><input type="text"  id="address"  readonly maxlength='15' name="corpBadIntegrity.address" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                    <td>建设单位：</td>
                    <td>
                    <input type="text" id="buildCorpName" readonly maxlength='15' name="corpBadIntegrity.buildCorpName" class="required" /><strong><font color="#FF0000">*</font></strong>
                     </td>  
               </tr>
                <tr>
                    <td>建设单位组织机构代码：</td>
                    <td>
                    <input type="text"  id="buildCorpCode"  readonly maxlength='15' name="corpBadIntegrity.buildCorpCode" class="required" /><strong><font color="#FF0000">*</font></strong>
                    </td>
                	<td>不良行为发生所在省：</td>
                    <td>
                    <select id="provinceId" name="corpBadIntegrity.provinceNum" onchange="queryCity()" class="required">
                    <option value="">请选择</option>
                    <s:iterator value="provinces">
						<option value="<s:property value="code"/>"><s:property value="name"/></option>
					</s:iterator>
                	</select><strong><font color="#FF0000">*</font></strong>
                    </td>
                </tr>
                <tr>
                    
                	<td>不良行为发生所在地市：</td>
                    <td>
                    <select id="cityId" name="corpBadIntegrity.cityNum" onchange="queryArea()" class="required" >
                    <option value="">请选择</option>
                	</select><strong><font color="#FF0000">*</font></strong>
                    </td>
                    <td>不良行为发生所在区县：</td>
                    <td>
                    <select id="areaId" name="corpBadIntegrity.countyNum" class="required" >
                	<option value="">请选择</option>
                	</select><strong><font color="#FF0000">*</font></strong>
                    </td>
                </tr>
                <tr>
                	<td>不良行为内容：</td>
                    <td><input type="text" maxlength='30' name="corpBadIntegrity.content" class="{required:true,digits:true}" /><strong><font color="#FF0000">*</font></strong></td>
                	<td>不良行为发生日期：</td>
                    <td><input id="time95" type="text" name="corpBadIntegrity.happenDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                <tr>
               		<td>处罚部门：</td>
                    <td><input type="text"  maxlength='50' name="corpBadIntegrity.punishDepartName" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                	<td>不良行为代码：</td>
                    <td>
                    <input type="text" readonly id="beHviorCode" name="corpBadIntegrity.creditCode" class="required" /><a href="#" onclick="queryCreditCode()">选择</a>
                    <input type="hidden" id="beHavior" name="corpBadIntegrity.creditType" />
                    <input type="hidden" id="punishBasis" name="corpBadIntegrity.punishEvidence" />
					</td>
                	
                </tr>
                <tr>
                	
                	<td>处罚部门级别：</td>
                    <td>
					<select name="corpBadIntegrity.punishDepartType" class="required">
                       <option value="">请选择</option>
				       <option value="0" <s:if test='corpBadIntegrity.punishDepartType==0'>selected</s:if>>部级</option>
				       <option value="1" <s:if test='corpBadIntegrity.punishDepartType==1'>selected</s:if>>省市</option>
				       <option value="2" <s:if test='corpBadIntegrity.punishDepartType==2'>selected</s:if>>地市</option>
				       <option value="3" <s:if test='corpBadIntegrity.punishDepartType==3'>selected</s:if>>区县</option>
				    </select><strong><font color="#FF0000">*</font></strong>
					</td>
					<td>处罚决定内容：</td>
                    <td><input type="text"  maxlength='15' name="corpBadIntegrity.punishContent" class="{required:true,number:true}" /><strong><font color="#FF0000">*</font></strong></td>
               		
				</tr>
           		<tr>
                    <td>处罚决定文号：</td>
                    <td><input type="text"  maxlength='15' name="corpBadIntegrity.punishNumber" class="{required:true,number:true}" /><strong><font color="#FF0000">*</font></strong></td>
                    <td>处罚日期：</td>
               		<td><input id="time99" type="text" name="corpBadIntegrity.punishDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                    
                </tr>
                <tr>
                    <td>处罚截止日期：</td>
               		<td><input id="time98" type="text" name="corpBadIntegrity.punishEDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
               		<td>处罚金额：</td>
                    <td>
                    <input type="text"  maxlength='30' name="corpBadIntegrity.punishMoney" class="required" /><strong><font color="#FF0000">*</font></strong>
                    </td>
                </tr>
                <tr>
               		<td>登记部门：</td>
                    <td>
                    <input type="text" readonly name="corpBadIntegrity.departName" value="<s:property value="departName"/>" />
                    <input type="hidden" name="corpBadIntegrity.departId" value="<s:property value="departId"/>" />
                    </td>
                    <td>登记人姓名：</td>
                    <td>
                    <input type="text" readonly name="corpBadIntegrity.userName" value="<s:property value="userName"/>" />
                    </td>
               </tr>
                <tr>
                    
                    <td>登记日期：</td>
                    <td>
                    <input type="text" readonly name="corpBadIntegrity.createDate" value="<s:date name="createDate" format="yyyy-MM-dd"/>" />
                    </td>
                    <td>审核领导：</td>
                    <td><input type="text" maxlength='200'  name="corpBadIntegrity.auditUserName" /><strong><font color="#FF0000">*</font></strong></td>
                	
                </tr>
                <tr>
                    <td>审核时间：</td>
                    <td>
                    <input id="time3" type="text" name="corpBadIntegrity.auditDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /><strong><font color="#FF0000">*</font></strong>
                    </td>
                    <td>是否发布：</td>
                    <td>
					<select name="corpBadIntegrity.isPublic" class="required">
                       <option value="">请选择</option>
				       <option value="0" <s:if test='corpBadIntegrity.isPublic==0'>selected</s:if>>未发布</option>
				       <option value="1" <s:if test='corpBadIntegrity.isPublic==1'>selected</s:if>>已发布</option>
				    </select><strong><font color="#FF0000">*</font></strong>
					</td>
                </tr>
                <tr>
                    
                    <td>发布开始时间：</td>
                    <td>
                    <input id="time1" value="<s:date name="corpBadIntegrity.publicBDate" format="yyyy-MM-dd"/>" type="text" name="corpBadIntegrity.publicBDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /><strong><font color="#FF0000">*</font></strong>
                    </td>
                    <td>发布结束时间：</td>
                    <td>
                    <input id="time2" value="<s:date name="corpBadIntegrity.publicEDate" format="yyyy-MM-dd"/>" type="text" name="corpBadIntegrity.publicEDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /><strong><font color="#FF0000">*</font></strong>
                    </td>
                </tr>
           	</table>
            <div class="sp_bton"> 
            <input type="image" src="<%=basepath %>/images/baocun.jpg" />
            <input type="image" onclick="goBack()" src="<%=basepath %>/images/quxiao.jpg" />
        	</div>
       
        
 		</form>
    	</div>
  </div>
</body>
</html>
