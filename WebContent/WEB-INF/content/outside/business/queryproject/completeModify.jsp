<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>竣工验收备案申请 </title>
<base  target="_self" />
<script type="text/javascript">

	//保存
	function save(){
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	 			var check = /^([1-9]\d*|0)(\.\d*[1-9])?$/; 
	 			var factCost = $("#factCost").val();
	 			var prjName = $("#prjName").val();
	 			if (!check.exec(factCost)) 
	 			{
	 				alert("实际造价不能为负数!");
	 			}else if(prjName=="" || prjName==null)
 				{
 					alert("请选择项目名称!");
 				}else
	 			{
 					$("#form1").attr("action", "<%=basepath %>/completeAction_modify.action");
 					document.getElementById("form1").submit();
 					//form.submit();
	 			}
	        }    
	 	});
	});
	}
	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/completeAction_goList.action";
		document.form1.submit();
	}
	
	//查询项目
	function queryPrjName()
	{
		var url="<%=basepath %>/queryCompletePrjsAction_queryPage.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		//newWin.open()
	}
	//查询施工许可信息
	function queryTenderInfo()
	{
		var prjNum = $("#prjNum").val();
		var url="<%=basepath %>/completePermitInfoAction_queryPage.action?condition.prjNum="+prjNum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		//newWin.open()
	}
	//上传
	function upload(id)
	{
		
		var uf = $("#uf").val();
		if(uf!="")
		{
			//var isUnits = $("#isUnits").val();
			var actionUrl = "<%=basepath %>/fileUpload_uploadFile.action?id="+id+"&linkName=竣工验收&isUnits=1&returnRoot=completeSuccess";
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
		document.form1.action="<%=basepath %>/fileUpload_deleteFile.action?id="+uploadId+"&returnRoot=completeSuccess";
		document.form1.submit();
	}
	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=completeSuccess";
		document.form1.submit();
	}
	//查询单体工程信息
	function querySingleProject()
	{ 
		var prjNum = $("#prjNum").val();
		var prjId = $("#prjId").val();
		var url = "<%=basepath %>/querySingleProjectAction_queryPage.action?prjNum="+prjNum+"&prjId="+prjId+"&condition.prjId="+prjId+"&condition.linkName=6&linkName=6";
		var newWin=window.showModalDialog(url,window,'dialogHeight:900px;dialogWidth:1300px;dialogLeft:100px;dialogTop:100px;');
		//newWin.open();
	}
</script>

</head>

<body>
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="" enctype="multipart/form-data">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>竣工验收</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td colspan="4" align="left">
							<input id="prjName" size="100" type="text" readonly name="complete.prjName" value="<s:property value="complete.prjName"/>" class="required"/>
							<input id="prjId" type="hidden" readonly name="complete.prjId" value="<s:property value="complete.prjId"/>" class="required"/>
							<input id="completeId" type="hidden" readonly name="complete.completeId" value="<s:property value="complete.completeId"/>" class="required"/>
							</td>
							
                         </tr>
                         <tr>
                         	<th>标段名称：</th>
							<td colspan="4" align="left">
							<input id="sectionName" size="100" type="text" name="complete.sectionName" value="<s:property value="complete.sectionName"/>" />
							</td>
                         </tr>
                         <tr>

							<th>项目编号：</th>
							<td align="left"> 
							<input id="prjNum" type="text" readonly name="complete.prjNum" value="<s:property value="complete.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>中标通知书编号：</th>
							<td align="left">
							<input id="tenderNum" readonly type="text" name="complete.tenderNum" value="<s:property value="complete.tenderNum"/>" />
							</td>
                         </tr>

                         <tr>
                         	<th>申请企业名称：</th>
							<td align="left">
							<input type="text" name="complete.applyCorpName" value="<s:property value="complete.applyCorpName"/>" class="required"/>
							</td>
							<th>申请企业代码：</th>
							<td align="left">
							<input type="text" name="complete.applyCorpCode" value="<s:property value="complete.applyCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="appDeptName" readonly type="hidden" name="complete.appDeptName" value="<s:property value="complete.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="complete.appDept" value="<s:property value="complete.appDept"/>"/>
							</td>
                         </tr>
                        <tr>
                         	<th>竣工备案编号：</th>
							<td align="left">
								<input type="text" readonly name="complete.prjFinishNum" value="<s:property value="complete.prjFinishNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	<th>工程名称：</th>
							<td align="left">
							<input id="projectName" type="text" name="complete.projectName" value="<s:property value="complete.projectName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                         <tr>
                         	<th>施工许可证编号：</th>
							<td align="left">
							<input id="builderLicenceNum" type="text" name="complete.builderLicenceNum" value="<s:property value="complete.builderLicenceNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>质量检测机构名称：</th>
							<td align="left">
							<input id="qcCorpName" type="text" name="complete.qcCorpName" value="<s:property value="complete.qcCorpName"/>" class="required"/>
							</td>
							
                         </tr>
                         <tr>
                         	<th>质量检测机构组织机构代码：</th>
							<td align="left">
							<input id="qcCorpCode" type="text" name="complete.qcCorpCode" value="<s:property value="complete.qcCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>实际造价(万元)：</th>
							<td align="left">
							<input id="factCost" type="text" name="complete.factCost" value="<s:property value="complete.factCost"/>" class="required number"/>
							</td>
							
                         </tr>
                         <tr>
                         	<th>实际面积(平方米)：</th>
							<td align="left">
							<input id="factArea" type="text" name="complete.factArea" value="<s:property value="complete.factArea"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>体系结构：</th>
							<td align="left">
							<select name="complete.prjStructureTypeNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="prjStructureTypeNums">
	          						<option value="<s:property value="code"/>"<s:if test='complete.prjStructureTypeNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							
							</td>
							
                         </tr>
                         <tr>
                         	
							<th>实际开工日期：</th>
							<td align="left">
							<input id="time1" type="text" name="complete.BDate" value="<s:date name="complete.BDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>实际竣工验收日期：</th>
							<td align="left">
							<input id="time2" type="text" name="complete.EDate" value="<s:date name="complete.EDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>

						<tr>
                         	
							<th>实际建设规模：</th>
							<td align="left" colspan="3">
							<textarea id="factSize" name="complete.factSize" cols="100" rows="5"><s:property value="complete.factSize"/></textarea>
							</td>
							
                         </tr>
                         <tr>
                         	
							<th>备注：</th>
							<td align="left" colspan="3">
							<textarea id="mark" name="complete.mark" cols="100" rows="5"><s:property value="complete.mark"/></textarea>
							</td>
							
                         </tr>
                         <!-- 
                         <tr>
                       		<th>附件上传：</th>
							<td align="left" colspan="3">
							<input id="uf" type="file" name="file">
							&nbsp;
							<input type="button" onclick="upload('<s:property value="complete.completeId"/>')" value="上传" />
							</td>
						</tr>
						<tr>
                       		<th>附件：</th>
							<td align="left" colspan="3">
							<s:iterator status="i" value="complete.list">
							<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a>&nbsp;<a href="#" onclick="deleteFile('<s:property value="uploadId"/>')">删除</a><br />
							</s:iterator>
							</td>
						</tr>
						 -->
                </tbody>  
                </table>
                <a href="#" onclick="querySingleProject()">
						<input type="image"src="<%=basepath %>/images/dtgc.jpg" />
		        </a>
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>