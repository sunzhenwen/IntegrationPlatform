<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业项目设计申请 </title>
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
		document.form1.action="<%=basepath %>/designAction_goList.action";
		document.form1.submit();
	}

	//查询项目
	function queryPrjName()
	{
		var url="<%=basepath %>/designSurveyPrjsAction_queryPage.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
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
	
	//上传
	function upload(id)
	{
		
		var uf = $("#uf").val();
		if(uf!="")
		{
			var isUnits = $("#isUnits").val();
			var actionUrl = "<%=basepath %>/fileUpload_uploadFile.action?id="+id+"&linkName=设计申请&isUnits="+isUnits+"&returnRoot=designSuccess";
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
		document.form1.action="<%=basepath %>/fileUpload_deleteFile.action?id="+uploadId+"&returnRoot=designSuccess";
		document.form1.submit();
	}
	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=designSuccess";
		document.form1.submit();
	}
</script>
<script type="text/javascript">
	var i = 99999;
    //添加行
	function onAddTR(trObj)
    {
    	i = i-1;
      	$(addTr).after("<tr><td><input type='text' name='designQualifications["+i+"].qualifName' class='required'/><strong><font color='#FF0000'>*</font></strong></td><td><input type='text' name='designQualifications["+i+"].certTypeName' class='required'/><strong><font color='#FF0000'>*</font></strong></td><td><input type='text' name='designQualifications["+i+"].titleLevelName' class='required' /><strong><font color='#FF0000'>*</font></strong></td><td><input type='text' name='designQualifications["+i+"].certId' class='required'/><strong><font color='#FF0000'>*</font></strong></td><td><a href='#' onclick='deleteCurrentRow(this)'>删除</a></td><tr/>");
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

	<form id="form1" name="form1" method="post" action="<%=basepath %>/designAction_modify.action" enctype="multipart/form-data">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>企业项目设计申请</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td align="left">
							<input id="prjName" type="text" readonly name="design.prjName" value="<s:property value="design.prjName"/>" class="required"/><strong><font color="#FF0000">*</font></strong><a href="#" onclick="queryPrjName()">选择</a>
							<input id="prjId" type="hidden" name="design.prjId" value="<s:property value="design.prjId"/>"/>
							<input id="prjNum" type="hidden" name="design.designId" value="<s:property value="design.designId"/>"/>
							<input type="hidden" name="design.corpName" value="<s:property value="design.corpName"/>"/>
							</td>
							<th>项目编号：</th>
							<td colspan="2" align="left">
							<input type="text" readonly name="design.prjNum" value="<s:property value="design.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>设计单位名称：</th>
							<td align="left">
							<input type="text" name="design.designCorpName" value="<s:property value="design.designCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>设计编码：</th>
							<td colspan="2" align="left">
							<input type="text" readonly name="design.designNum" value="<s:property value="design.designNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
                         </tr>
                         <tr>
                         	<th>设计单位组织机构代码：</th>
							<td align="left"> 
							<input type="text" name="design.designCorpCode" value="<s:property value="design.designCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	<th>是否添加资质：</th>
							<td colspan="2" align="left">
							<select id="isUnits" name="design.isUnits" onchange="checkForeignCorp()" class="required" >
	                    		<s:if test='design.isUnits==0'>
	                    			<option value="0" selected>是</option>
	                    			<option value="1">否</option>
	                    		</s:if>
	                    		<s:if test='design.isUnits==1'>
	                    			<option value="0">是</option>
	                    			<option value="1" selected>否</option>
	                    		</s:if>
                    		</select><strong><font color="#FF0000">*</font></strong>
							<input id="appDeptName" readonly type="hidden" name="design.appDeptName" value="<s:property value="design.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="design.appDept" value="<s:property value="design.appDept"/>"/>
							</td>
						</tr>
                        <tr>
                       		<th>附件上传：</th>
							<td align="left" colspan="4">
							<input id="uf" type="file" name="file">
							&nbsp;
							<input type="button" onclick="upload('<s:property value="design.designId"/>')" value="上传" />
							</td>
						</tr>
						<tr>
                       		<th>附件：</th>
							<td align="left" colspan="4">
							<s:iterator status="i" value="design.list">
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
                 	<s:iterator status="i" value="design.designQualifications" > 
                 	<tr>
                 		<td>
                 		<input type='text' name="designQualifications[<s:property value='#i.count'/>].qualifName" value="<s:property value="qualifName"/>"/><strong><font color="#FF0000">*</font></strong>
                 		</td>
                 		<td>
                 		<input type='text' name="designQualifications[<s:property value='#i.count'/>].certTypeName" value="<s:property value="certTypeName"/>"/><strong><font color="#FF0000">*</font></strong>
                 		<input type="hidden" name="designQualifications[<s:property value='#i.count'/>].id" value="<s:property value="id"/>"/>
                 		</td>
                 		<td>
                 		<input type="text" name="designQualifications[<s:property value='#i.count'/>].titleLevelName" value="<s:property value="titleLevelName"/>"/><strong><font color="#FF0000">*</font></strong>
                 		</td>
                 		<td>
                 		<input type='text' name="designQualifications[<s:property value='#i.count'/>].certId" value="<s:property value="certId"/>"/><strong><font color="#FF0000">*</font></strong>
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
