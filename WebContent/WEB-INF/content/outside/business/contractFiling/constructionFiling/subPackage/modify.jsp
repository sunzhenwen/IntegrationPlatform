<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>施工分包合同备案 </title>
<script type="text/javascript">

	//保存
	function save(){
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            var check = /^([1-9]\d*|0)(\.\d*[1-9])?$/; 
	 			var allInvest = $("#contractMoney").val();
	 			var recordNum = $("#recordNum").val();
	 			if (!check.exec(allInvest)) 
	 			{
	 				alert("合同金额不能为负数!");
	 			}else
	 			{
	 				if(recordNum=="" || recordNum==null)
	 				{
	 					alert("总包合同!");
	 				}else
		 			{
	 					$("#form1").attr("action", "<%=basepath %>/subPackageAction_modify.action");
	 					document.getElementById("form1").submit();
	 					//form.submit();
		 			}
	 			}
	        }    
	 	});
	});
	}
	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/subPackageAction_goList.action";
		document.form1.submit();
	}
	//查询总包合同
	function queryContractor()
	{
		var url3="<%=basepath %>/mainContractorAction_queryPage.action";
		var newWin3=window.showModalDialog(url3,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin3.open()
	}
	
	//上传
	function upload(count,id,accessotyId,linkName)
	{
		var uid = "#uf"+count;
		var uf = $(uid).val();
		if(uf!="")
		{
			//var isUnits = $("#isUnits").val();
			var actionUrl = "<%=basepath %>/fileUpload_uploadFile.action?id="+id+"&accessotyId="+accessotyId+"&linkName="+linkName+"&returnRoot=subPackageContrFiling";
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
		document.form1.action="<%=basepath %>/fileUpload_deleteFile.action?id="+uploadId+"&returnRoot=subPackageContrFiling";
		document.form1.submit();
	}
	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=subPackageContrFiling";
		document.form1.submit();
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
              	<h2>施工分包合同备案</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                		 <tr>
                         	<th>总包合同：</th>
							<td colspan="4" align="left">
							<input id="recordNum" size="100" type="text" name="contractFiling.mainRecordNum" value="<s:property value="contractFiling.mainRecordNum"/>" class="required"/>
							<a href="#" onclick="queryContractor()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							
							</td>
                         </tr>
                		 <tr>
                		 	<th>合同备案编号：</th>
							<td colspan="4" align="left">
							<input size="100" type="text" readonly name="contractFiling.recordNum" value="<s:property value="contractFiling.recordNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                		 </tr>
                         <tr>
                         	<th>项目名称：</th>
							<td colspan="4" align="left">
							<input id="prjName" size="100" type="text" name="contractFiling.prjName" value="<s:property value="contractFiling.prjName"/>" class="required"/>
							<strong><font color="#FF0000">*</font></strong>
							<input id="prjId" type="hidden" readonly name="contractFiling.prjId" value="<s:property value="contractFiling.prjId"/>" class="required"/>
							<input type="hidden" name="contractFiling.contractTypeNum" value="<s:property value="contractFiling.contractTypeNum"/>" class="required"/>
							<input type="hidden" name="contractFiling.contrType" value="<s:property value="contractFiling.contrType"/>" class="required"/>
							<input type="hidden" readonly name="contractFiling.recordId" value="<s:property value="contractFiling.recordId"/>" class="required"/>
							<!-- 
							<input id="qualificationsTypeName" type="hidden" name="contractFiling.qualificationsTypeName" value="<s:property value="contractFiling.qualificationsTypeName"/>"/>
							<input id="specialtyTypeName" type="hidden" name="contractFiling.specialtyTypeName" value="<s:property value="contractFiling.specialtyTypeName"/>"/>
							<input id="ratingName" type="hidden" name="contractFiling.ratingName" value="<s:property value="contractFiling.ratingName"/>" />
							<input id="qualificationsType" type="hidden" name="contractFiling.qualificationsType" value="<s:property value="contractFiling.qualificationsType"/>"/>
							<input id="specialtyType" type="hidden" name="contractFiling.specialtyType" value="<s:property value="contractFiling.specialtyType"/>" />
							<input id="rating" type="hidden" name="contractFiling.rating" value="<s:property value="contractFiling.rating"/>" />
							 -->
							</td>
						 </tr>
                         <tr>
                         	
							<th>标段名称：</th>
							<td colspan="4" align="left">
							<input id="sectionName" size="100" type="text" value="<s:property value="contractFiling.sectionName"/>" />
							</td>
                         </tr>
                         <tr>
                         	<th>工程名称：</th>
							<td colspan="4" align="left">
							<input id="projectName" size="100" type="text" name="contractFiling.sectionName" value="<s:property value="contractFiling.sectionName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                         <tr>
                         	<th>项目编号：</th>
							<td align="left">
							<input id="prjNum" type="text" readonly name="contractFiling.prjNum" value="<s:property value="contractFiling.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>中标通知书编号：</th>
							<td align="left">
							<input id="tenderNum" type="text" name="contractFiling.tenderNum" value="<s:property value="contractFiling.tenderNum"/>" />
							</td>
                         </tr>
                         <tr>
                         	<th>工程造价(万元)：</th>
							<td align="left">
							<input id="projectCost" type="text" name="contractFiling.projectCost" value="<s:property value="contractFiling.projectCost"/>"  class="required number" />
							</td>
                         	<th>项目地址：</th>
							<td align="left">
							<input id="projectAddress" type="text" name="contractFiling.projectAddress" value="<s:property value="contractFiling.projectAddress"/>"  />
							</td>
							
                         </tr>
                         
                         <tr>
                         	
                         	<th>合同编号：</th>
							<td align="left">
							<input id="contractNum" type="text" name="contractFiling.contractNum" value="<s:property value="contractFiling.contractNum"/>" />
							</td>
							<th>建筑面积：</th>
							<td align="left">
							<input id="area" type="text" name="contractFiling.area" value="<s:property value="contractFiling.area"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
                         </tr>
                         <tr>
                         	
                         	<th>合同金额(万元)：</th>
							<td align="left">
							<input id="contractMoney" type="text" name="contractFiling.contractMoney" value="<s:property value="contractFiling.contractMoney"/>" class="required number"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>合同签订日期：</th>
							<td align="left">
							<input id="time1" type="text" name="contractFiling.contractDate" value="<s:date name="contractFiling.contractDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
						<tr>
							
							<th>发包单位名称：</th>
							<td align="left">
							<input id="propietorCorpName" type="text" name="contractFiling.propietorCorpName" value="<s:property value="contractFiling.propietorCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>发包单位组织机构代码：</th>
							<td align="left">
							<input id="propietorCorpCode" type="text" name="contractFiling.propietorCorpCode" value="<s:property value="contractFiling.propietorCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
						<tr>
                         	<th>承包单位名称：</th>
							<td colspan="4" align="left">
							<input id="contractorCorpName" size="100" type="text" name="contractFiling.contractorCorpName" value="<s:property value="contractFiling.contractorCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
						</tr>
						<tr>
							<th>承包单位组织机构代码：</th>
							<td align="left">
							<input id="contractorCorpCode" type="text" name="contractFiling.contractorCorpCode" value="<s:property value="contractFiling.contractorCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>资质等级：</th>
							<td align="left">
							<input id="titleLeve" type="text" name="contractFiling.titleLeve" value="<s:property value="contractFiling.titleLeve"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
						<tr>
                         	<th>项目负责人：</th>
							<td align="left">
							<input id="constructorName" type="text" name="contractFiling.constructorName" value="<s:property value="contractFiling.constructorName"/>" class="required"/>
							</td>
							<th>单位联系电话：</th>
							<td align="left">
							<input id="phone" type="text" name="contractFiling.phone" value="<s:property value="contractFiling.phone"/>" class="required"/>
							</td>
                         </tr>
                        <tr>
                        	<th>联合体承包单位名称：</th>
							<td align="left">
							<input id="unionCorpName" type="text" name="contractFiling.unionCorpName" value="<s:property value="contractFiling.unionCorpName"/>" />
							</td>
							<th>联合体承包单位组织代码：</th>
							<td align="left">
							<input id="unionCorpCode" type="text" name="contractFiling.unionCorpCode" value="<s:property value="contractFiling.unionCorpCode"/>" />
							<input id="appDeptName" readonly type="hidden" name="contractFiling.appDeptName" value="<s:property value="contractFiling.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="contractFiling.appDept" value="<s:property value="contractFiling.appDept"/>"/>
							</td>
						</tr>
                        <tr>
                         	<th>申请企业名称：</th>
							<td align="left">
							<input type="text" name="contractFiling.applyCorpName" value="<s:property value="contractFiling.applyCorpName"/>" class="required"/>
							</td>
							<th>申请企业代码：</th>
							<td align="left">
							<input id="corpCode" type="text" name="contractFiling.applyCorpCode" value="<s:property value="contractFiling.applyCorpCode"/>" class="required"/>
							</td>
                         </tr>
						<tr>
                       		<th>建设规模：</th>
							<td colspan="4" align="left">
							<textarea id="prjSize" name="contractFiling.prjSize" id="textarea" cols="100" rows="5"><s:property value="contractFiling.prjSize"/></textarea>
							</td>
						</tr>
						<tr>
                       		<th>审批意见：</th>
							<td colspan="4" align="left">
							<s:property value="contractFiling.appOpinion"/>
							</td>
						</tr>
						<tr>
							<td colspan="5" >
								<font color="red">*上传的附件最好为文档、图片、压缩包等形式的单个文件，且小于20M</font>
							</td>
						</tr>
						<s:iterator status="i" value="contractFiling.accessoryList">
							<tr>
                       		<td style="background:#f5f5f5;" align="left"><s:property value="#i.count"/>、<s:property value="message"/></td>
							<td align="left" colspan="5">
							<input id="uf<s:property value="#i.count"/>" type="file" name="file">
							&nbsp;
							<input type="button" onclick="upload('<s:property value="#i.count"/>','<s:property value="contractFiling.recordId"/>','<s:property value="id"/>','<s:property value="linkName"/>')" value="上传" />
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
		            <input type="image"src="<%=basepath %>/images/baocun.jpg" onclick="save()" />
            	</div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
