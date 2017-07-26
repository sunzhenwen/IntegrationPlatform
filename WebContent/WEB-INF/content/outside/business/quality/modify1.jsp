<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业安全监督申请 </title>
<script type="text/javascript" src="jquery-1.11.1.js"></script>
<style type="text/css">
table { border-collapse:collapse;width:100%; border:1px solid #000;}
table td{height:22px; border:1px solid #000;}
table.fulltable{width:100%;border:none;}
</style>
<script type="text/javascript">
function load()
{
var row = document.getElementById("row");
var roww = document.getElementById("roww");
var row2 = document.getElementById("row2");
var roww2 = document.getElementById("roww2");
if(row!=null){
	roww.style.display = "none";  
	
}
if(row2!=null){
	roww2.style.display = "none";  
	
}
}

	//保存
	function save(){
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	 			var prjName = $("#prjName").val();
	 			if(prjName=="" || prjName==null)
 				{
 					alert("请选择项目名称!");
 				}else
	 			{
 					$("#form1").attr("action", "<%=basepath %>/safetyAction_modify.action");
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
		document.form1.action="<%=basepath %>/safetyAction_goList.action";
		document.form1.submit();
	}
	
	//查询项目
	function queryPrjName()
	{
		var url="<%=basepath %>/qualityPrjsAction_queryPageModify.action";
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
			var actionUrl = "<%=basepath %>/fileUpload_uploadFile.action?id="+id+"&accessotyId="+accessotyId+"&linkName="+linkName+"&returnRoot=safetySuccess";
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
		document.form1.action="<%=basepath %>/fileUpload_deleteFile.action?id="+uploadId+"&returnRoot=safetySuccess";
		document.form1.submit();
	}
	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=safetySuccess";
		document.form1.submit();
	}
	
	//查询勘察单位信息
	function queryPrjNameKC()
	{   
		var prjnum = document.getElementById("prjNum").value;
		var url="<%=basepath %>/QualitykcAction_queryPagekc.action?prjnum="+prjnum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	
	//查询设计单位
	function queryPrjNameSJ()
	{   
		var prjnum = document.getElementById("prjNum").value;
		var url="<%=basepath %>/QualitySJAction_queryPageSJ.action?prjnum="+prjnum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//查询监理单位
	function queryPrjNameJL() 
	{   
		var prjnum = document.getElementById("prjNum").value;
		var url="<%=basepath %>/QualityjlAction_queryPagejl.action?prjnum="+prjnum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//查询安全责任人 
	function queryPrjNameAQFZ() 
	{   
		var personaqfz = document.getElementById("contractorCorpNamezb").value;
		var url="<%=basepath %>/QualityanfzAction_queryPageanfz.action?personanfz="+personaqfz;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//查询项目负责人
	function queryPrjNameXMFZ() 
	{   
		var contractorCorpNamezb = document.getElementById("contractorCorpNamezb").value;
		var url="<%=basepath %>/QualityanxmfzAction_queryPageanxmfz.action?contractorCorpNamezb="+contractorCorpNamezb;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//查询专业分包项目负责人 
	function queryPrjNameFBFZR() 
	{   
		var contractorCorpNamefb = document.getElementById("contractorCorpNamefb[0]").value;
		var url="<%=basepath %>/QualityfbfzrAction_queryPagefbfzr.action?contractorCorpNamefb="+contractorCorpNamefb+"&&l="+l;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//查询专职人员 
	function queryPrjNameZZRY1() 
	{ 
		var properties = new Array();
		var contractorCorpNamezb = document.getElementById("contractorCorpNamezb").value;
		var url="<%=basepath %>/QualityzzryAction_queryPagezzry.action?contractorCorpNamezb="+contractorCorpNamezb;
		//var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		//newWin.open()
		properties = window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		
		
	}
	function queryPrjNameZZRY() 
	{   
	   
		var contractorCorpNamezb = document.getElementById("contractorCorpNamezb").value;
		var url="<%=basepath %>/QualityzzryAction_queryPagezzry.action?contractorCorpNamezb="+contractorCorpNamezb+"&&i="+i;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open(); 
			
	}
	//查询总承包单位
	function queryPrjNameZB() 
	{   
		var prjnum = document.getElementById("prjNum").value;
		var url="<%=basepath %>/QualityzbAction_queryPagezb.action?prjnum="+prjnum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//查询专业分包单位 
	function queryPrjNameFB() 
	{   
		//alert(k);
		var url="<%=basepath %>/QualityfbAction_queryPagefb.action?k="+k;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//查询劳务分包单位 
	function queryPrjNameLW() 
	{   
		var propertiess = new Array();
		//alert(j);
		var url="<%=basepath %>/QualitylwAction_queryPagelw.action?j="+j;
		//var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		propertiess = window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		$("#ffff").empty();
		for(var i=0;i<properties.length;i++)
		{
			
			if(typeof(propertiess[i]) != "undefined")
			{
        		//alert(properties[i]);
				var strs= new Array(); //定义一数组  
				strs = propertiess[i].split(",");
				var p1 = strs[0];
				var p2 = strs[1];
				
				//$("#asdf").append("<option value="+p1+" selected='selected' disabled='disabled'>"+p2+"</option>");
				$("#fffff").append("<input type='checkbox' name="+p1+" checked='checked' />"+p2+"<br />");
				
			}
			
		}
		//alert(document.getElementById('asdf').value)
	}
	
	//查询单体工程信息
	function querySingleProject()
	{ 
		var prjNum = $("#prjNum").val();
		var prjId = $("#prjId").val();
		var url = "<%=basepath %>/singleProjectAction_queryPage.action?prjNum="+prjNum+"&prjId="+prjId+"&condition.prjId="+prjId+"&condition.linkName=4&linkName=4";
		var newWin=window.showModalDialog(url,window,'dialogHeight:900px;dialogWidth:1300px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
</script>
<script type="text/javascript">
	var i = 0;
	var k = 0;
	var j = 0;
	var l = 0;
	var m = 0; 
	var q = 0;
	var z = 0;
    //添加行
	function onAddTR(trObj)
    {
    	 if(m==0){
    		 i=0;
    	 }else{
    		 i = i+1;   
    	 }
   	       
    	//alert(i);
      	$(addTr).after("<tr><td align='left'><input id='constructorNamezzry["+i+"]' type='text' name='constructionSafety["+i+"].safetyManageName' value='<s:property value='constructionSafety["+i+"].safetyManageName'/>' class='required' /><strong><font color='#FF0000'>*</font></strong></td><td align='left'><input id='constructorNamezzrygw["+i+"]' type='text' name='constructionSafety["+i+"].safetyManageNum' value='<s:property value='constructionSafety["+i+"].safetyManageNum'/>' class='required' /><strong><font color='#FF0000'>*</font></strong></td><td align='left'><input id='constructorNamezzrykh["+i+"]' type='text' name='constructionSafety["+i+"].safetyManagecheckNum' value='<s:property value='constructionSafety["+i+"].safetyManagecheckNum'/>' class='required' /><strong><font color='#FF0000'>*</font></strong></td><td><a href='#' onclick='deleteCurrentRow(this)'>删除</a></td></tr>");
        m=1;
      	document.getElementById("constructorNamezzry["+i+"]").foucs();
    }
  
	//添加行    
	function onAddTRs(trObj)
    {
		 if(q==0){
    		 k=0;
    		 l=0;
    	 }else{
    		 k = k+1;
    	     l = l+1;  
    	 }
	 	
    	//alert(k);
      		$(addTrs).after("<tr>"
        +"<td colspan='4'>"
        +"<table class='fulltable' width='100%' cellpadding='0' cellspacing='0'>"
        +"  <tr>"
        +"<td>单位名称</td>"
        +"<td align='left'><input type='text' id='contractorCorpNamefb["+k+"]' name='majors["+k+"].majorName' value='<s:property value='majors["+k+"].majorName'/>'/></td>"
        +"<td>分包分部分项工程名称</td>"
        +"<td align='left'><input type='text' name='majors["+k+"].majorProject' value='<s:property value='majors["+k+"].majorProject'/>'/></td>"
      +"</tr>"
      +"<tr>"
       	+"<td>安全生产许可证有效期</td>"
        +"<td align='left'><input id='constructorNamefbdate["+k+"]' type='text' name='majors["+k+"].majorLicenseDate' value='<s:date name='majors["+k+"].majorLicenseDate' format='yyyy-MM-dd' />' onFocus='WdatePicker({dateFmt:\"yyyy-MM-dd\",alwaysUseStartDate:true,isShowClear:true,readOnly:true})' /></td>"
        +"<td>项目负责人</td>"
        +"<td align='left'><input type='text' id='FNamee["+l+"]' name='majors["+k+"].majorStaff' value='<s:property value='majors["+k+"].majorStaff'/>'/><a href='#' onclick='queryPrjNameFBFZR()' style='float:right;'><span style='border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;'>选择</span></a></td>"
      +"</tr>"
      +"<tr>"
        +"<td>安全考核证号</td>"
        +"<td align='left'><input type='text' id='FCertNumberr["+l+"]'  name='majors["+k+"].majorCardNum' value='<s:property value='majors["+k+"].majorCardNum'/>'/></td>"
        +"<td>联系电话</td>"
        +"<td align='left'><input type='text' name='majors["+k+"].majorPhone' value='<s:property value='majors["+k+"].majorPhone'/>'/></td>"
      +"</tr>"
        +"</table><a href='#' onclick='deleteCurrentRowlk(this)'>删除</a>"
        +"</td>"
      +"</tr>");
     q=1;
      	document.getElementById("FCertNumberr[0]").foucs();
    }
    
	
	//添加行
	function onAddTRss(trObj)
    {
	 
		if(z==0){
   		 j=0;
   		 }else{
   		 j = j+1;   
   		 }
		
    	//alert(j);
      	$(addTrss).after("<tr>"
                +"<td colspan='4'>"
                +"<table class='fulltable' width='100%' cellpadding='0' cellspacing='0'>"
                +"<tr>"
                +"<td>单位名称</td>"
                +"<td align='left'><input type='text' id='contractorCorpNamelw["+j+"]' name='labours["+j+"].labourName' value='<s:property value='labours["+j+"].labourName'/>'/></td>"
                +"<td>安全生产许可证有效期</td>"
                +"<td align='left'><input id='constructorNamelwdate["+j+"]' type='text' name='labours["+j+"].labourLicenseDate' value='<s:date name='labours["+j+"].labourLicenseDate' format='yyyy-MM-dd' />' onFocus='WdatePicker({dateFmt:\"yyyy-MM-dd\",alwaysUseStartDate:true,isShowClear:true,readOnly:true})' /></td>"
                +"</tr>"
                +"<tr>"
                +"<td>现场负责人</td>"
                +"<td align='left'><input type='text' name='labours["+j+"].labourStaff' value='<s:property value='labours["+j+"].labourStaff'/>'/></td>"
                +"<td>联系电话</td>"
                +"<td align='left'><input type='text' name='labours["+j+"].labourPhone' value='<s:property value='labours["+j+"].labourPhone'/>'/></td>"
                +"</tr>"
                +"</table><a href='#' onclick='deleteCurrentRowj(this)'>删除</a>"
                +"</td>"
                +"</tr>");
      	        z=1;
		document.getElementById("constructorNamelwdate[0]").foucs();

    }
	 //删除指定行
    function deleteCurrentRow(obj){      
    	
		 if(i!=0){			 
			 i=i-1; 
			
		 }else{ 
			 i=0;
			
		 }
		 
		var tr=obj.parentNode.parentNode;   
		var tbody=tr.parentNode;   
		tbody.removeChild(tr); 
		document.getElementById("constructorNamezzry[0]").foucs();
	}    //删除指定行
    function deleteCurrentRowlk(obj){      
    	
 		if(k!=0){
			 
 			k=k-1;
 	    	l=l-1;
		 }else{
			 
			 k=0;
			 l=0;
		 }
		var tr=obj.parentNode.parentNode;   
		var tbody=tr.parentNode;   
		tbody.removeChild(tr); 
		
		
		document.getElementById("constructorNamefbdate[0]").foucs();
	} 
    //删除指定行
    function deleteCurrentRowj(obj){      
    	 
 		if(j!=0){
			 
			 j=j-1; 
		 }else{
			 
			 j=0;
		 }
		var tr=obj.parentNode.parentNode;   
		var tbody=tr.parentNode;   
		tbody.removeChild(tr); 
		document.getElementById("constructorNamefbdate[0]").foucs();
	}  
</script>
</head>

<body onload="load()" >
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="" enctype="multipart/form-data">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>企业安全监督申请</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>                        	
							 <td colspan="3" align="left">
 							<input id="prjName" type="text" readonly=false style="color:#707070" name="safety.prjName" value="<s:property value="safety.prjName"/>" size="108" class="required"/><strong><font color="#FF0000">*</font></strong><a href="#" onclick="queryPrjName()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							<input id="prjId" type="hidden" readonly name="safety.prjId" value="<s:property value="safety.prjId"/>" class="required"/>
							<input id="safetyId" type="hidden" readonly name="safety.safetyId" value="<s:property value="safety.safetyId"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         
                         <th>项目编号：</th>
							<td align="left">
							<input id="prjNum" type="text" readonly=false style="color:#707070" name="safety.prjNum" value="<s:property value="safety.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td><th></th><td></td>
                         </tr>
                         <tr>
                         	<th>申请企业名称：</th>
							<td align="left">
							<input type="text" readonly=false style="color:#707070" name="safety.applyCorpName" value="<s:property value="safety.applyCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>申请企业代码：</th>
							<td align="left">
							<input type="text" readonly=false style="color:#707070" name="safety.applyCorpCode" value="<s:property value="safety.applyCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="appDeptName" readonly type="hidden" name="safety.appDeptName" value="<s:property value="safety.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="safety.appDept" value="<s:property value="safety.appDept"/>"/>
							</td>
                         </tr>
                         <tr>
							<th>安全监督编号：</th>
							<td colspan="3" align="left">
							  	  
								<input type="text" size="108" readonly=false style="color:#707070" name="safety.safetyNum" value="<s:property value="safety.safetyNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                         <tr>
                           <td colspan="4" align="left"><strong>工程概况</strong></td>
                         </tr>
                         <tr>
                         	<th>工程名称</th>
                            <td colspan="3" align="left">
 							   <input id='sectionName' type="text" name="safety.projectName" value="<s:property value="safety.projectName"/>" size="108" class="required"/><strong><font color="#FF0000">*</font></strong><a href="#" onclick="queryPrjNameZB()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a></td>
                         </tr>
                         <tr>
                           <th>工程地点</th>
                            <td colspan="3" align="left">
                            <input id='projectAddress' name="safety.projectAddress" type="text" value="<s:property value="safety.projectAddress"/>" size="108" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                         <tr>
                           <th>合同开工日期</th>
                           <td align="left"><input id="contractstart" type="text" name="safety.proStartDate" value="<s:date name="safety.proStartDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                           <th>合同竣工日期</th>
                           <td align="left"><input id="contractend" type="text" name="safety.proEndDate" value="<s:date name="safety.proEndDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                         <tr>
                           <th>工程类型</th>
                           <td>
                           <select name="safety.projectType" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="projectTypes">
	          						<option value="<s:property value="code"/>"<s:if test='safety.projectType==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
                           </td>
                           <th>安全生产标准化创建目标</th>
                           <td align="left"><input type="text" name="safety.safetyTarget" value="<s:property value="safety.safetyTarget"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                         <tr>
                           <td align="left" colspan="4">
                          
                           <s:if test='safety.newlyBuild == "0"'>
                           <input type="checkbox" name="safety.newlyBuild" value="0" checked  />
           					 新建
                           </s:if>
                           <s:else>
                           <input type="checkbox" name="safety.newlyBuild" value="0"  />
           					 新建
                           </s:else>
                           <s:if test='safety.extend == "1"'>
                           <input type="checkbox" name="safety.extend" value="1" checked />
                           	改建
                           </s:if>
                           <s:else>
                           <input type="checkbox" name="safety.extend" value="1"  />
                           	改建
                           </s:else>
                           <s:if test='safety.other == "2"'>
                           <input type="checkbox" name="safety.expankj" value="2" checked />
                           	扩建
                           </s:if>
                           <s:else>
                           <input type="checkbox" name="safety.expankj" value="2"  />
                           	扩建
                           </s:else>
                           
                           <s:if test='safety.other == "3"'>
                           <input type="checkbox" name="safety.other" value="3" checked />
                           	其它
                           </s:if>
                           <s:else>
                           <input type="checkbox" name="safety.other" value="3"  />
                           	其它
                           </s:else>
                           	<tr>
                           </td>
                         </tr>
                         
                          
                         <tr>
                           <th>勘察单位全称</th>
                           <td colspan="3" align="left">
                            <input id='contractorCorpName' type="text" name="safety.policingName" size="108" value="<s:property value="safety.policingName"/>" class="required"/><strong><font color="#FF0000">*</font></strong><a href="javascript:queryPrjNameKC()" onclick=""><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a></td>
                           </tr>
                            <tr>
                           <th>设计单位全称</th>                          
                           <td colspan="3" align="left">
                            <input id='contractorCorpNamesj' type="text" size="108" name="safety.designName" value="<s:property value="safety.designName"/>" class="required"/><strong><font color="#FF0000">*</font></strong><a href="javascript:queryPrjNameSJ()" onclick=""><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a></td>
                            </tr>
                         <tr>
                           <th>设计单位项目负责人</th>
                           <td align="left"><input id='constructorNamesj' type="text" name="safety.designStaff" value="<s:property value="safety.designStaff"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                        	<input id='contractorCorpCode' type="hidden" readonly name="safety.contractorCorpCode" value="<s:property value="safety.contractorCorpCode"/>" class="required"/></td>
                        	<th>勘察单位项目负责人</th>
                           <td align="left"><input id='constructorName' type="text" name="safety.policingStaff" value="<s:property value="safety.policingStaff"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                         </tr>                       
                         <tr>
                           <th>建设单位全称</th>
                           <td align="left"><input readonly=false style="color:#707070" id='buildCorpName' type="text" name="safety.buildingName" value="<s:property value="safety.buildingName"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                           <th>建设单位项目负责人</th>
                           <td align="left"><input id='projectManager' type="text" name="safety.buildingStaff" value="<s:property value="safety.buildingStaff"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                         <tr>
                           <th>建设单位联系电话</th>
                           <td align="left"><input id='unitPhone' type="text" name="safety.buildingPhone" value="<s:property value="safety.buildingPhone"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                           <td>&nbsp;</td>
                           <td>&nbsp;</td>
                         </tr>
                         <tr>
                           <td align="left" colspan="4"><strong>监理单位</strong></td>
                         </tr>
                         <tr>
                           <th>单位全称</th>
                             <td colspan="3" align="left">
                              <input id='contractorCorpNamejl' type="text" name="safety.supervisionName" size="108" value="<s:property value="safety.supervisionName"/>" /><a href="javascript:queryPrjNameJL()" onclick=""><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a></td>
                           
                         </tr>
                         <tr>
                           <th>项目总监姓名</th>
                           <td align="left"><input id='directorName' type="text" name="safety.supervisionStaff" value="<s:property value="safety.supervisionStaff"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                           <th>项目总监注册证书号</th>
                           <td align="left"><input id='directorIdCard' type="text" name="safety.supervisionNum" value="<s:property value="safety.supervisionNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                         <tr>
                           <th>项目总监联系电话</th>
                           <td align="left"><input id='phoneJLL' type="text" name="safety.supervisionPhone" value="<s:property value="safety.supervisionPhone"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                           <td>&nbsp;</td>
                           <td>&nbsp;</td>
                         </tr>
                         <tr>
                           <th>安全监理姓名</th>
                           <td align="left"><input id='safetyName' type="text" name="safety.probationStaff" value="<s:property value="safety.probationStaff"/>" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                           <th>安全监理注册证书号</th>
                           <td align="left"><input id='safetyIdCard' type="text" name="safety.probationNum" value="<s:property value="safety.probationNum"/>" /></td>
                         </tr>
                         <tr>
                           <th>安全监理联系电话</th>
                           <td align="left"><input id='phoneAQ' type="text" name="safety.probationPhone" value="<s:property value="safety.probationPhone"/>" /></td>
                           <th>安全监理证号</th>
                           <td align="left"><input type="text" name="safety.probationSafeNum" value="<s:property value="safety.probationSafeNum"/>" /></td>
                         </tr>
                         <tr>
                           <td align="left" colspan="4"><strong>施工总承包单位</strong></td>
                         </tr>
                         <tr>
                           <th>单位全称</th>
                           <td colspan="3" align="left">
                            <input id='contractorCorpNamezb' size="108" type="text" name="safety.contractName" value="<s:property value="safety.contractName"/>" /></td>                           
                         </tr> 
                         <tr>
                         <tr>
                           <th>安全管理负责人</th>
                            <td colspan="3" align="left">
                              <input id='FName' type="text" name="safety.contractAdmin" size="108" value="<s:property value="safety.contractAdmin"/>" class="required"/><strong><font color="#FF0000">*</font></strong><a href="javascript:queryPrjNameAQFZ()" onclick=""><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a></td>
                           </tr>
                         <tr>
                         <th>安全考核证号</th>
                           <td align="left"><input id='FCertNumber' type="text" name="safety.contractSafeNum" value="<s:property value="safety.contractSafeNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                         <th>联系电话</th>
                           <td align="left"><input type="text" name="safety.contractPhone" value="<s:property value="safety.contractPhone"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                         </tr>      
                         
                         <tr>
                         <th>项目负责人姓名</th>
                           <td colspan="3" align="left">
                              <input id='constructorNameXMFZ' type="text" name="safety.contractProStaff" size="108" value="<s:property value="safety.contractProStaff"/>" class="required"/><strong><font color="#FF0000">*</font></strong><a href="javascript:queryPrjNameXMFZ()" onclick=""><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a></td>
                         </tr>
                         
                         <tr>
                           <th>项目负责人注册证号</th>
                           <td align="left"><input id='constructorNameZSBH' type="text" name="safety.contractStaffRegNum" value="<s:property value="safety.contractStaffRegNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                           <th>项目负责人考核证号</th>
                           <td align="left"><input id='constructorNameKHBH' type="text" name="safety.contractStaffNum" value="<s:property value="safety.contractStaffNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                            <tr>               
                           
                           
                           <th>项目负责人联系电话</th>
                           <td align="left"><input id='phonezcb' type="text" name="safety.contractProStaffPhone" value="<s:property value="safety.contractProStaffPhone"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                          <th></th>
                          <td></td>
                           
                         </tr>
                         
                         <tr>
                           <td align="left" colspan="4">
                           	现场专职安全管理人员     	 
                           	<a href="javascript:queryPrjNameZZRY()" onclick="" style="float:right;"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a><a href="javascript:onAddTR(this)" onclick="" style="float:right;"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">添加</span></a>
                           </td>
                         </tr>
                         
                              <td colspan="4">
                           <table class="fulltable" width="100%" cellpadding="0" cellspacing="0">
                             
                             <tr>                         
                         	<th>姓名</th>
                         	<th>岗位证号</th>
							<th>安全考核证号</th>
							<th>操作</th>  
							</tr>
							<tr id="addTr">	</tr> 
							 <tr style="display:none" ><td align="left"><input id='constructorNamezzry[0]' type='text' name='constructionSafety[0].safetyManageName' class="required" value='<s:property value='constructionSafety[0].safetyManageName'/>'/><strong><font color="#FF0000">*</font></strong></td>
							    <td align="left"><input id='constructorNamezzrygw[0]' type='text' name='constructionSafety[0].safetyManageNum' class="required" value='<s:property value='constructionSafety[0].safetyManageNum'/>'/><strong><font color="#FF0000">*</font></strong></td>
							    <td align="left"><input id='constructorNamezzrykh[0]' type='text' name='constructionSafety[0].safetyManagecheckNum' class="required" value='<s:property value='constructionSafety[0].safetyManagecheckNum'/>'/><strong><font color="#FF0000">*</font></strong></td>
							    <td></td> </tr>
							 <s:iterator status="t" value="safety.csList" > 
                             <tr>                      
                               <td align="left"><input type="text" name="constructionSafety[<s:property value='#t.count'/>].safetyManageName" value="<s:property value="safetyManageName"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                               <td align="left"><input type="text" name="constructionSafety[<s:property value='#t.count'/>].safetyManageNum" value="<s:property value="safetyManageNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                               <td align="left">	<input type="text" name="constructionSafety[<s:property value='#t.count'/>].safetyManagecheckNum" value="<s:property value="safetyManagecheckNum" />" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                               <td><a href='#' onclick='deleteCurrentRow(this)'>删除</a>
                               </td>  
                             </tr>
                              </s:iterator>  
                                   
                                 
                                  	              	             
                        </table></td>                      
                         <tr>
                           <th height="78" colspan="4">&nbsp;</th>
                         </tr>                        
                         <tr>
                           <td colspan="4" align="left">
                           <strong>专业分包单位</strong>                          
                           <a href="javascript:queryPrjNameFB()" onclick="" style="float:right;"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>	<a href="javascript:onAddTRs(this)" onclick="" style="float:right;"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">添加</span></a>
                           </td>
                         </tr>
                        
                        
                         <tr id="addTrs"></tr>    
 						<tr>
                           <td colspan="4">
                           <table  id="roww" class="fulltable" width="100%" cellpadding="0" cellspacing="0">
                             <tr>
                           <td>单位名称</td>
                           <td align="left"><input type="text" id='contractorCorpNamefb[0]' name="majors[0].majorName" value="<s:property value="majors[0].majorName"/>"/></td>
                           <td>分包分部分项工程名称</td>
                           <td align="left"><input type="text" name="majors[0].majorProject" value="<s:property value="majors[0].majorProject"/>"/></td>
                         </tr>
                         <tr>
                           <td>安全生产许可证有效期</td>
                           <td align="left"><input id="constructorNamefbdate[0]" type="text" name="majors[0].majorLicenseDate" value="<s:date name="majors[0].majorLicenseDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /></td>
                           <td>项目负责人</td>
                           <td align="left"><input id='FNamee[0]'  type="text" name="majors[0].majorStaff" value="<s:property value="majors[0].majorStaff"/>"/><a href="#" onclick="queryPrjNameFBFZR()" style="float:right;"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a></td>
                         </tr>
                         <tr>
                           <td>安全考核证号</td>
                           <td align="left"><input type="text" id='FCertNumberr[0]' name="majors[0].majorCardNum" value="<s:property value="majors[0].majorCardNum"/>"/></td>
                           <td>联系电话</td>
                           <td align="left"><input type="text" name="majors[0].majorPhone" value="<s:property value="majors[0].majorPhone"/>"/></td>
                         </tr>
                           </table>
                           
                           </td>
                         </tr> 
                           <s:iterator status="y" value="safety.majors" > 
                         <tr>
                           <td colspan="4">
                           <table id="row" class="fulltable" width="100%" cellpadding="0" cellspacing="0">
                             <tr>
                           <td>单位名称</td>
                           <td align="left"><input type="text" name="majors[<s:property value='#y.count'/>].majorName" value="<s:property value="majorName"/>"/></td>
                           <td>分包分部分项工程名称</td>
                           <td align="left"><input type="text" name="majors[<s:property value='#y.count'/>].majorProject" value="<s:property value="majorProject"/>"/></td>
                         </tr>
                         <tr>
                           <td>安全生产许可证有效期</td>
                           <td align="left"><input id="0" type="text" name="majors[<s:property value='#y.count'/>].majorLicenseDate" value="<s:date name="majorLicenseDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /></td>
                           <td>项目负责人</td>
                           <td align="left"><input type="text" name="majors[<s:property value='#y.count'/>].majorStaff" value="<s:property value="majorStaff"/>"/> <a href="javascript:queryPrjNameFBFZR()" onclick="" style="float:right;"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a></td>
                         </tr>
                         <tr>
                           <td>安全考核证号</td>
                           <td align="left"><input type="text" name="majors[<s:property value='#y.count'/>].majorCardNum" value="<s:property value="majorCardNum"/>"/></td>
                           <td>联系电话</td>
                           <td align="left"><input type="text" name="majors[<s:property value='#y.count'/>].majorPhone" value="<s:property value="majorPhone"/>"/></td>
                         </tr>
                           </table>
                           <a href='#' onclick='deleteCurrentRowlk(this)'>删除</a>
                           </td>
                         </tr>
                         </s:iterator>                
                         <tr>
                           <td colspan="4" align="left">
                            <strong>劳务分包单位</strong>
                        
                           <a href="javascript:queryPrjNameLW()" onclick="" style="float:right;"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>	<a href="#" onclick="onAddTRss(this)" style="float:right;"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">添加</span></a>
                           </td>
                         </tr>
                         
                         <tr id="addTrss"></tr>
                         <tr>
                           <td colspan="4">
                           <table  id="roww2"  class="fulltable" width="100%" cellpadding="0" cellspacing="0">
                          <tr>
                           <td>单位名称</td>
                           <td align="left"><input type="text" id='contractorCorpNamelw[0]'  name="labours[0].labourName" value="<s:property value="labours[0].labourName"/>"/></td>
                           <td>安全生产许可证有效期</td>
                           <td align="left"><input id="constructorNamelwdate[0]" type="text" name="labours[0].labourLicenseDate" value="<s:date name="labours[0].labourLicenseDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /></td>
                          </tr>
                          <tr>
                        	<td>现场负责人</td>
                           <td align="left"><input type="text" name="labours[0].labourStaff" value="<s:property value="labours[0].labourStaff"/>"/></td>
                           <td>联系电话</td>
                           <td align="left"><input type="text" name="labours[0].labourPhone" value="<s:property value="labours[0].labourPhone"/>"/></td>                                                                       
                          </tr> 
                             </table>
                           </td>
                         </tr>
                         <s:iterator status="i" value="safety.labours" > 
                         <tr>
                           <td colspan="4">
                           <table id="row2" class="fulltable" width="100%" cellpadding="0" cellspacing="0">
                          <tr>
                           <td>单位名称</td>
                           <td align="left"><input type="text" name="labours[<s:property value='#i.count'/>].labourName" value="<s:property value="labourName"/>"/></td>
                           <td>安全生产许可证有效期</td>
                           <td align="left"><input id="0" type="text" name="labours[<s:property value='#i.count'/>].labourLicenseDate" value="<s:date name="labourLicenseDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /></td>
                         </tr>
                         <tr>
                           <td>现场负责人</td>
                           <td align="left"><input type="text" name="labours[<s:property value='#i.count'/>].labourStaff" value="<s:property value="labourStaff"/>"/></td>
                           <td>联系电话</td>
                           <td align="left"><input type="text" name="labours[<s:property value='#i.count'/>].labourPhone" value="<s:property value="labourPhone"/>"/></td>                                                    
                         </tr>
                              </table>
              						<a href='#' onclick='deleteCurrentRowj(this)'>删除</a>  
              						</td>
              						</tr>
	                 	</s:iterator>
	            		
                </tbody>  
                
                </table>
                <table class="" cellpadding="0" cellspacing="0">
                	<s:iterator status="i" value="safety.accessoryList">
							<tr>
                       		<th width="400"><s:property value="#i.count"/>、<s:property value="message"/></th>
							<td width="399" colspan="5" align="left">
							<input id="uf<s:property value="#i.count"/>" type="file" name="file">
							&nbsp;
							<input type="button" onclick="upload('<s:property value="#i.count"/>','<s:property value="safety.safetyId"/>','<s:property value="id"/>','<s:property value="linkName"/>')" value="上传" />
							&nbsp;<br />
							<s:iterator status="k" value="list">
								<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a>&nbsp;<a href="#" onclick="deleteFile('<s:property value="uploadId"/>')">删除</a><br />
							</s:iterator>
							</td>
							</tr>
						</s:iterator>
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
		            
		            <input type="image"src="<%=basepath %>/images/baocun.jpg" onclick="save()" />
            		<a href="#" onclick="querySingleProject()">
						<input type="image"src="<%=basepath %>/images/dtgc.jpg" />
		            </a>
            	</div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
