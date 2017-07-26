<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业项目勘察申请 </title>
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
		document.form1.action="<%=basepath %>/surveyAction_goList.action";
		document.form1.submit();
	}

	function checkForeignCorp()
	{
		var node = $("#isUnits").val();
		if(node=="0")
		{
			$('#unitId').show();
		}else
		{
			$('#unitId').hide();
		}
	}
	//查询项目
	function queryPrjName()
	{
		var url="<%=basepath %>/designSurveyPrjsAction_queryPage.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
	
	//上传
	function upload(id)
	{
		
		var uf = $("#uf").val();
		if(uf!="")
		{
			var isUnits = $("#isUnits").val();
			var actionUrl = "<%=basepath %>/fileUpload_uploadFile.action?id="+id+"&linkName=勘察申请&isUnits="+isUnits+"&returnRoot=surveySuccess";
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
		document.form1.action="<%=basepath %>/fileUpload_deleteFile.action?id="+uploadId+"&returnRoot=surveySuccess";
		document.form1.submit();
	}
	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=surveySuccess";
		document.form1.submit();
	}
</script>
<script type="text/javascript">
	var i = 99999;
    //添加行
	function onAddTR(trObj)
    {
    	i = i-1;
      	$(addTr).after("<tr><td><input type='text' name='surveyQualification["+i+"].qualifName' class='required'/><strong><font color='#FF0000'>*</font></strong></td><td><input type='text' name='surveyQualification["+i+"].certTypeName' class='required'/><strong><font color='#FF0000'>*</font></strong></td><td><input type='text' name='surveyQualification["+i+"].titleLevelName' class='required' /><strong><font color='#FF0000'>*</font></strong></td><td><input type='text' name='surveyQualification["+i+"].certId' class='required'/><strong><font color='#FF0000'>*</font></strong></td><td><a href='#' onclick='deleteCurrentRow(this)'>删除</a></td><tr/>");
    }
    //删除指定行
    function deleteCurrentRow(obj){   
		var tr=obj.parentNode.parentNode;   
		var tbody=tr.parentNode;   
		tbody.removeChild(tr);   
	}   
</script>
</head>

<body onload="checkForeignCorp()" >
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="<%=basepath %>/surveyAction_modify.action" enctype="multipart/form-data">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>企业项目勘察申请</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td align="left">
							<input id="prjName" type="text" readonly name="survey.prjName" value="<s:property value="survey.prjName"/>" class="required"/><strong><font color="#FF0000">*</font></strong><a href="#" onclick="queryPrjName()">选择</a>
							<input id="prjId" type="hidden" name="survey.prjId" value="<s:property value="survey.prjId"/>"/>
							<input type="hidden" name="survey.surveyId" value="<s:property value="survey.surveyId"/>"/>
							<input type="hidden" name="survey.corpName" value="<s:property value="survey.corpName"/>"/>
							</td>
							<th>项目编号：</th>
							<td colspan="2" align="left">
							<input id="prjNum" type="text" readonly name="survey.prjNum" value="<s:property value="survey.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	
							<th>勘察单位名称：</th>
							<td align="left">
							<input type="text" name="survey.surveyCorpName" value="<s:property value="survey.surveyCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>勘察编码：</th>
							<td colspan="2" align="left">
							<input type="text" readonly name="survey.surveyNum" value="<s:property value="survey.surveyNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>勘察单位组织机构代码：</th>
							<td align="left">
							<input type="text" name="survey.surveyCorpCode" value="<s:property value="survey.surveyCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>审批单位：</th>
							<td colspan="2" align="left">
							<select id="isUnits" name="survey.isUnits" onchange="checkForeignCorp()" class="required" >
	                    		<s:if test='survey.isUnits==0'>
	                    			<option value="0" selected>是</option>
	                    			<option value="1">否</option>
	                    		</s:if>
	                    		<s:if test='survey.isUnits==1'>
	                    			<option value="0">是</option>
	                    			<option value="1" selected>否</option>
	                    		</s:if>
                    		</select><strong><font color="#FF0000">*</font></strong>
							<input id="appDeptName" type="hidden" name="survey.appDeptName" value="<s:property value="survey.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="survey.appDept" value="<s:property value="survey.appDept"/>"/>
							</td>
							
						</tr>
                        <tr>
                       		<th>附件上传：</th>
							<td align="left" colspan="4">
							<input id="uf" type="file" name="file">
							&nbsp;
							<input type="button" onclick="upload('<s:property value="survey.surveyId"/>')" value="上传" />
							</td>
						</tr>
						<tr>
                       		<th>附件：</th>
							<td align="left" colspan="4">
							<s:iterator status="i" value="survey.list">
							<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a>&nbsp;<a href="#" onclick="deleteFile('<s:property value="uploadId"/>')">删除</a><br />
							</s:iterator>
							</td>
						</tr>
                </tbody>  
                <tbody id="unitId">
                	<tr>
                       	<td colspan="5"><a href="#" onclick="onAddTR(this)">添加</a></td>
                    </tr>
                    <tr id="addTr">
                    	<th>资质名称：</th>
                      	<th>资质类型：</th>
                      	<th>资质等级：</th>
						<th>证书编号：</th>
						<th>操作</th>
                 	</tr>
                 	<s:iterator status="i" value="survey.surveyQualis" > 
                 	<tr>
                 		<td>
                 		<input type='text' name="surveyQualification[<s:property value='#i.count'/>].qualifName" value="<s:property value="qualifName"/>"/><strong><font color="#FF0000">*</font></strong>
                 		</td>
                 		<td>
                 		<input type='text' name="surveyQualification[<s:property value='#i.count'/>].certTypeName" value="<s:property value="certTypeName"/>"/><strong><font color="#FF0000">*</font></strong>
                 		<input type="hidden" name="surveyQualification[<s:property value='#i.count'/>].id" value="<s:property value="id"/>"/>
                 		</td>
                 		<td>
                 		<input type="text" name="surveyQualification[<s:property value='#i.count'/>].titleLevelName" value="<s:property value="titleLevelName"/>"/><strong><font color="#FF0000">*</font></strong>
                 		</td>
                 		<td>
                 		<input type='text' name="surveyQualification[<s:property value='#i.count'/>].certId" value="<s:property value="certId"/>"/><strong><font color="#FF0000">*</font></strong>
                 		</td>
                 		<td>
                 			<a href='#' onclick='deleteCurrentRow(this)'>删除</a>
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
