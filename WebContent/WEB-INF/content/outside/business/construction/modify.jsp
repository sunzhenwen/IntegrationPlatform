<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业项目报建 </title>
<script type="text/javascript">
	
	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            var check = /^([1-9]\d*|0)(\.\d*[1-9])?$/; 
	 			var allInvest = $("#allInvest").val();
	 			if (!check.exec(allInvest)) 
	 			{
	 				alert("总投资不能为负数!");
	 			}else
	 			{
	 				if(appDeptName=="" || appDeptName==null)
	 				{
	 					alert("请选择审批单位!");	
	 				}else
		 			{
		 				form.submit();
		 			}
	 			}
	        }    
	 	});
	});

	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/constructionAction_goList.action";
		document.form1.submit();
	}

	//查询市
	function queryCity(){
	       $(document).ready(function(){
	           //获取省
	           var provinceId = $("#provinceId").val();
	           //执行城市ajax查询
	           $.ajax({
	               url: 'constructionAction_queryCity.action',
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
	                   var cityNum='<s:property value="construction.cityNum"/>';
	                   //循环items,i为循环下标,(默认i从0开始取值)
	                   $.each(items,function(i){
	                	   //如果返回列表中有与对象中标识相等的执行
	                	   if(items[i].code==cityNum)
	                       {
	                		    //拼接判断默认选中
	                		    $("#cityId").append("<option value='" + items[i].code+ "' selected >" + items[i].name + "</option>");
	                		    //自动执行ajax查询区
	                		    $.ajax({
	         		               url: 'constructionAction_queryArea.action',
	         		               type: 'post',
	         		               dataType: 'json',
	         		               data: 'cityNum='+cityNum,
	         		               success: function(data){
	         		            	   //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
	         		                   var itemss = eval("("+data+")");
	         		            	   //循环items,i为循环下标,(默认i从0开始取值)
	         		                   $("#areaId").empty();
	         		                   var area ='<s:property value="construction.countyNum"/>';
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
		               url: 'constructionAction_queryArea.action',
		               type: 'post',
		               dataType: 'json',
		               data: 'cityNum='+cityNum,
		               success: function(data){
		            	   //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
		                   var items = eval("("+data+")");
		                   //循环items,i为循环下标,(默认i从0开始取值)
		                   $("#areaId").empty();
		                   var area ='<s:property value="construction.countyNum"/>';
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
	
	//查询审批部门
	function queryCorp()
	{
		var url="<%=basepath %>/constructionAction_queryAppDept.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
	
	//上传
	function upload(count,id,accessotyId,linkName)
	{
		var uid = "#uf"+count;
		var uf = $(uid).val();
		if(uf!="")
		{
			var isUnits = $("#isUnits").val();
			var actionUrl = "<%=basepath %>/fileUpload_uploadFile.action?id="+id+"&accessotyId="+accessotyId+"&linkName="+linkName+"&returnRoot=constructionSuccess";
			actionUrl = encodeURI(actionUrl);
			actionUrl = encodeURI(actionUrl);
			document.form1.action=actionUrl;
			document.form1.submit();
		}else
		{
			alert("请选择要上传的附件!");
		}
	}
	//删除
	function deleteFile(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_deleteFile.action?id="+uploadId+"&returnRoot=constructionSuccess";
		document.form1.submit();
	}
	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=constructionSuccess";
		document.form1.submit();
	}
	
	//清空项目规模里的初始文字
	function clearText()
	{
		var text = document.getElementById("textarea").value;
		if(text == "最多填写500字！"){
			document.getElementById("textarea").value = "" ;
		}
	}
	
</script>

</head>

<body onload="queryCity()" >
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">
	
	<form id="form1" name="form1" method="post" action="<%=basepath %>/constructionAction_modify.action" enctype="multipart/form-data">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>企业项目报建</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td colspan="3" align="left">
							<input type="text" size="100" maxlength='50'  name="construction.prjName" value="<s:property value="construction.prjName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input type="hidden" name="construction.prjId" value="<s:property value="construction.prjId"/>"/>
							</td>
						</tr>
                         <tr>
                        	<th>项目编号：</th>
							<td colspan="3" align="left">
							<input type="text" size="100" readonly maxlength='50'  name="construction.prjNum" value="<s:property value="construction.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
                         </tr>
                         <tr>
                         	<th>项目分类：</th>
							<td colspan="3" align="left">
							<select name="construction.prjTypeNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="prjTypeNums">
	          						<option value="<s:property value="code"/>"<s:if test='construction.prjTypeNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
						<tr>
                         	<th>建设单位名称：</th>
							<td colspan="3" align="left">
							<input type="text" size="100" readonly name="construction.buildCorpName" value="<s:property value="construction.buildCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                        <tr>
                         	<th>建设单位组织机构代码/统一社会信用代码：</th>
							<td colspan="3" align="left">
							<input type="text" size="100" readonly name="construction.buildCorpCode" value="<s:property value="construction.buildCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
						<tr>
                         	
							<th>项目所在地市：</th>
							<td   align="left">
							<select id="cityId" name="construction.cityNum" onchange="queryArea()" class="required" >
                    			<option value="">请选择</option>
                			</select><strong><font color="#FF0000">*</font></strong>
							<input id="provinceId" type="hidden" name="construction.provinceNum" value="<s:property value="construction.provinceNum"/>" class="required"/>
							</td>
							<th>项目所在区县：</th>
							<td   align="left">
							<select id="areaId" name="construction.countyNum" class="required" >
		                		<option value="">请选择</option>
		                	</select><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
						<tr>
                         	<th>建设地址：</th>
							<td colspan="3" align="left">
							<input type="text" size="100" maxlength='50' name="construction.address" value="<s:property value="construction.address"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                        <tr>
                         	
							<th>立项文号：</th>
							<td align="left"><input type="text" maxlength='50' name="construction.prjApprovalNum"  value="<s:property value="construction.prjApprovalNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
							<th>立项级别：</th>
							<td align="left">
							<select name="construction.prjApprovalLevelNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="prjApprovalLevelNums">
	          						<option value="<s:property value="code"/>"<s:if test='construction.prjApprovalLevelNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
						<tr>
                        	<th>建设用地规划许可证编号：</th>
							<td align="left"><input type="text" maxlength='50' name="construction.buldPlanNum" value="<s:property value="construction.buldPlanNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
							<th>建设工程规划许可证编号：</th>
							<td align="left"><input type="text" maxlength='50' name="construction.projectPlanNum" value="<s:property value="construction.projectPlanNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
						</tr>
						<tr>
                       		<th>总投资(万元)：</th>
							<td align="left"><input id="allInvest" type="text" maxlength='50' name="construction.allInvest" value="<s:property value="construction.allInvest"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                        	<th>总面积(平方米)：</th>
							<td align="left"><input type="text" maxlength='50'  name="construction.allArea" value="<s:property value="construction.allArea"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
						</tr>
                        <tr>
                       		
                        	<th>建设性质：</th>
							<td align="left">
							<select name="construction.prjPropertyNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="prjPropertyNums">
	          						<option value="<s:property value="code"/>"<s:if test='construction.prjPropertyNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>工程用途：</th>
							<td align="left">
							<select name="construction.prjFuncitonNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="prjFuncitonNums">
	          						<option value="<s:property value="code"/>"<s:if test='construction.prjFuncitonNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
                        </tr>
                        <tr>
                        	<th>建设单位项目负责人：</th>
							<td align="left">
							<input type="text" maxlength='50' name="construction.projectManager" value="<s:property value="construction.projectManager"/>" /><strong><font color="#FF0000">*</font></strong>
							</td>
                       		<th>建设单位联系电话：</th>
							<td align="left">
							<input type="text" maxlength='50'  name="construction.unitPhone" value="<s:property value="construction.unitPhone"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                        <tr>
                       		<th><strong><font color="#FF0000">受理单位：</font></strong></th>
							<td colspan="3" align="left">
							<input id="appDeptName" size="100" readonly type="text" name="construction.appDeptName" value="<s:property value="construction.appDeptName"/>" class="required"/>&nbsp;&nbsp;
							<a href="#" onclick="queryCorp()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							<input id="appDeptId" type="hidden" name="construction.appDept" value="<s:property value="construction.appDept"/>"/>
							</td>
						</tr>
                        <tr>
                       		<th>开工日期：</th>
							<td align="left"><input id="time1" type="text" name="construction.BDate" value="<s:date name="construction.BDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
							<th>竣工日期：</th>
							<td align="left"><input id="time2" type="text" name="construction.EDate" value="<s:date name="construction.EDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                        </tr>
                        <tr>
                       		<th>建设规模：</th>
							<td colspan="3" align="left">
							<textarea name="construction.prjSize" id="textarea" cols="100" rows="5" maxlength="500"  onfocus="clearText()"><s:property value="construction.prjSize"/></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="5" >
								<font color="red">*上传的附件最好为文档、图片、压缩包等形式的单个文件，且小于20M</font>
							</td>
						</tr>
						<s:iterator status="i" value="construction.accessoryList">
							<tr>
                       		<td style="background:#f5f5f5;" align="left"><s:property value="#i.count"/>、<s:property value="message"/></td>
							<td colspan="5">
							<input id="uf<s:property value="#i.count"/>" type="file" name="file">
							&nbsp;
							<input type="button" onclick="upload('<s:property value="#i.count"/>','<s:property value="construction.prjId"/>','<s:property value="id"/>','<s:property value="linkName"/>')" value="上传" />
							&nbsp;<br />
							<s:iterator status="k" value="list">
								<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a>&nbsp;<a href="#" onclick="deleteFile('<s:property value="uploadId"/>')">删除</a><br />
							</s:iterator>
							</td>
							</tr>
						</s:iterator>
                        
                </tbody>  
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
		            <input type="image"src="<%=basepath %>/images/baocun.jpg" />
            	</div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
