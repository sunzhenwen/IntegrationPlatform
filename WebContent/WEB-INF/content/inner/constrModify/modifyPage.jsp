<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报项目审核查询</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/constrModifyAction_goBack.action";
		document.form1.submit();
	}
	
	//保存修改
	function save()
	{
		document.form1.action="<%=basepath%>/constrModifyAction_update.action";
		document.form1.submit();
	}
	
	//查询市
	function queryCity(){
       $(document).ready(function(){
           //获取部门下拉列表的值
           var provinceId = $("#provinceId").val();
           var checkCityNum = $("#checkCityNum").val();
           $.ajax({
               url: 'constrModifyAction_queryCity.action',
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
                	   if(checkCityNum==items[i].code)
                		{
                		   $("#cityId").append("<option value='" + items[i].code+ "' selected>" + items[i].name + "</option>");
                		}else
                		{
                			$("#cityId").append("<option value='" + items[i].code+ "'>" + items[i].name + "</option>");	
                		}
                	});
                   queryArea();
               }
           });
       });
   }

	//查询区
	function queryArea(){
       $(document).ready(function(){
           //获取部门下拉列表的值
           var cityNum = $("#cityId").val();
           var checkCountyNum = $("#checkCountyNum").val();
           $.ajax({
               url: 'constrModifyAction_queryArea.action',
               type: 'post',
               dataType: 'json',
               data: 'cityNum='+cityNum,
               success: function(data){
            	   //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
                   var items = eval("("+data+")");
                   $("#areaId").empty();
                   //循环items,i为循环下标,(默认i从0开始取值)
                   $.each(items,function(i){
                	if(checkCountyNum==items[i].code)
               		{
                		$("#areaId").append("<option value='" + items[i].code+ "' selected>" + items[i].name + "</option>");
               		}else
               		{
               			$("#areaId").append("<option value='" + items[i].code+ "'>" + items[i].name + "</option>");	
               		}
                	   
                   });  
               }
           });
       });
   }
	

	//上传
	function upload(count,id,accessotyId,linkName)
	{
		var uid = "#uf"+count;
		var uf = $(uid).val();
		if(uf!="")
		{
			var isUnits = $("#isUnits").val();
			var actionUrl = "<%=basepath %>/fileUpload_uploadFile.action?id="+id+"&accessotyId="+accessotyId+"&linkName="+linkName+"&returnRoot=constrSuccess";
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
		document.form1.action="<%=basepath %>/fileUpload_deleteFile.action?id="+uploadId+"&returnRoot=constrSuccess";
		document.form1.submit();
	}
	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=constrSuccess";
		document.form1.submit();
	}
</script>
</head>
<body onload="queryCity()">
	
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">项目报建修改</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post" action="" enctype="multipart/form-data">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>项目编号：</td>
						<td>
						<s:property value="project.prjNum" /> 
						<input type="hidden" name="project.prjId" value="<s:property value="project.prjId"/>" />
						</td>
						<td>项目名称：</td>
						<td>
						<input type="text" maxlength='50'  name="project.prjName" value="<s:property value="project.prjName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
						
						</td>
					</tr>

					<tr>
						<td>项目分类：</td>
						<td>
						<select name="project.prjTypeNum" class="required">
    						<option value="">请选择</option>
      						<s:iterator value="prjTypeNums">
          						<option value="<s:property value="code"/>"<s:if test='project.prjTypeNum==code'>selected</s:if>><s:property value="name"/></option>
      						</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong>
						</td>
						<td>建设单位名称：</td>
						<td>
						<input type="text" name="project.buildCorpName" value="<s:property value="project.buildCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>
					<tr>
						<td>建设单位组织机构代码证：</td>
						<td>
						<input type="text" name="project.buildCorpCode" value="<s:property value="project.buildCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
						</td>
						<td>项目所在省：</td>
						<td>
						
						<select id="provinceId" name="project.provinceNum" onchange="queryCity()" class="required">
		                    <option value="">请选择</option>
		                    <s:iterator value="provinces">
								<option value="<s:property value="code"/>"<s:if test='project.provinceNum==code'>selected</s:if>><s:property value="name"/></option>
							</s:iterator>
	                	</select><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>
					<tr>
						<td>项目所在市：</td>
						<td>
						<select id="cityId" name="project.cityNum" onchange="queryArea()" class="required" >
                    		<option value="">请选择</option>
                		</select><strong><font color="#FF0000">*</font></strong>
                		<input id="checkCityNum" type="hidden" value="<s:property value="project.cityNum"/>" />
						</td>
						<td>项目所在地：</td>
						<td>
						<select id="areaId" name="project.countyNum" class="required" >
	                		<option value="">请选择</option>
	                	</select><strong><font color="#FF0000">*</font></strong>
	                	<input id="checkCountyNum" type="hidden" value="<s:property value="project.countyNum"/>" />
						
						</td>
					</tr>
					<tr>
						<td>立项文号：</td>
						<td>
						<input type="text" maxlength='50' name="project.prjApprovalNum"  value="<s:property value="project.prjApprovalNum"/>" />
						</td>
						<td>立项级别：</td>
						<td>
						<select name="project.prjApprovalLevelNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="prjApprovalLevelNums">
	          						<option value="<s:property value="code"/>"<s:if test='project.prjApprovalLevelNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>
					<tr>
						<td>建设用地规划许可证编号：</td>
						<td align="left"><input type="text" maxlength='50' name="project.buldPlanNum" value="<s:property value="project.buldPlanNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                       	<td>建设工程规划许可证编号：</td>
						<td align="left"><input type="text" maxlength='50' name="project.projectPlanNum" value="<s:property value="project.projectPlanNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td width="100px" nowrap>总投资(万元)：</td>
						<td align="left"><input id="allInvest" type="text" maxlength='50' name="project.allInvest" value="<s:property value="project.allInvest"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                       	<td width="100px" nowrap>总面积(平方米)：</td>
						<td align="left"><input type="text" maxlength='50'  name="project.allArea" value="<s:property value="project.allArea"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>开工日期：</td>
						<td align="left"><input id="time1" type="text" name="project.beginDate" value="<s:date name="project.beginDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
						<td>竣工日期：</td>
						<td align="left"><input id="time2" type="text" name="project.endDate" value="<s:date name="project.endDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
					</tr>
					<tr>
						<td>建设性质：</td>
						<td>
						<select name="project.prjPropertyNum" class="required">
     						<option value="">请选择</option>
	      					<s:iterator value="prjPropertyNums">
	          					<option value="<s:property value="code"/>"<s:if test='project.prjPropertyNum==code'>selected</s:if>><s:property value="name"/></option>
	      					</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong>
						</td>
						<td>工程用途：</td>
						<td>
						<select name="project.prjFunctionNum" class="required">
    						<option value="">请选择</option>
      						<s:iterator value="prjFuncitonNums">
          						<option value="<s:property value="code"/>"<s:if test='project.prjFunctionNum==code'>selected</s:if>><s:property value="name"/></option>
      						</s:iterator>
						</select><strong><font color="#FF0000">*</font></strong>
						</td>
					</tr>
					<tr>
						<td>登记日期：</td>
						<td><s:date name="project.createDate" format="yyyy-MM-dd" />
							<input type="hidden" name="project.createDate"
							value="<s:property value="project.createDate" />" /></td>
						<td></td>
						<td></td>
					</tr>
					<tr style="height: 60px; border: 0">
						<td>建设规模：</td>
						<td colspan="3">
						<center>
						<textarea name="project.prjSize" id="textarea" cols="100" rows="5"><s:property value="project.prjSize"/></textarea>
						</center>
						</td>
					</tr>
					
					<tr>
						<td>详细地址：</td>
						<td colspan="3">
						<div align="center">
						<textarea name="project.address" id="textarea" cols="100" rows="5"><s:property value="project.address"/></textarea>
						</div>
						</td>
					</tr>
					<tr style="height: 60px; border: 0">
						<td>审核结果：</td>
						<td colspan="3"><div align="center"><s:if test="project.processSteps==2">项目报建通过</s:if> <s:if
								test="project.processSteps==3">待合同备案、施工图审处理。。</s:if> <s:if
								test="project.processSteps==4">待质量监督、安全监督处理。。</s:if> <s:if
								test="project.processSteps==5">带施工许可处理。。</s:if> <s:if
								test="project.processSteps==6">待竣工验收处理。。</s:if> <s:if
								test="project.processSteps==7">竣工验收通过</s:if> <s:if
								test="project.appType==2">项目报建不通过</s:if></div></td>
					</tr>
					<s:iterator status="i" value="project.accessoryList">
						<tr>
                      		<td align="left"><s:property value="#i.count"/>、<s:property value="message"/></td>
						<td colspan="5">
						<input id="uf<s:property value="#i.count"/>" type="file" name="file">
						&nbsp;
						<input type="button" onclick="upload('<s:property value="#i.count"/>','<s:property value="project.prjId"/>','<s:property value="id"/>','<s:property value="linkName"/>')" value="上传" />
						&nbsp;<br />
						<s:iterator status="k" value="list">
							<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a>&nbsp;<a href="#" onclick="deleteFile('<s:property value="uploadId"/>')">删除</a><br />
						</s:iterator>
						</td>
						</tr>
					</s:iterator>
				</table>
				
				<div class="sp_bton">
					<a href="#"><span class="sp_last" onclick="save()">保存</span></a>
					<a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
				</div>
			</form>
		</div>
	</div>



</body>
</html>