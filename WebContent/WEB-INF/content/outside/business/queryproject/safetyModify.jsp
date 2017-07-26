<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业安全监督申请 </title>
<base  target="_self" />
<script type="text/javascript" src="jquery-1.11.1.js"></script>
<style type="text/css">
table { border-collapse:collapse;width:100%; border:1px solid #000;}
table td{height:22px; border:1px solid #000;}
table.fulltable{width:100%;border:none;}
</style>
<script type="text/javascript">

	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	 			var prjName = $("#prjName").val();
	 			if(prjName=="" || prjName==null)
 				{
 					alert("请选择项目名称!");
 				}else
	 			{
	 				form.submit();
	 			}
	        }    
	 	});
	});

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
	function upload(id)
	{
		var uf = $("#uf").val();
		if(uf!="")
		{
			//var isUnits = $("#isUnits").val();
			var actionUrl = "<%=basepath %>/fileUpload_uploadFile.action?id="+id+"&linkName=安全监督&isUnits=1&returnRoot=safetySuccess";
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
		
		var url="<%=basepath %>/QualitykcAction_queryPagekc.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	
	//查询设计单位
	function queryPrjNameSJ()
	{   
		
		var url="<%=basepath %>/QualitySJAction_queryPageSJ.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//查询监理单位
	function queryPrjNameJL() 
	{   
		
		var url="<%=basepath %>/QualityjlAction_queryPagejl.action";
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
		var contractorCorpNamefb = document.getElementById("contractorCorpNamefb[1]").value;
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
	
	
</script>
<script type="text/javascript">
	var i = 1;
	var k = 1;
	var j = 1;
	var l = 1;
    //添加行
	function onAddTR(trObj)
    {
    	 i = i+1;
    	//alert(i);
      	$(addTr).after("<tr><td><input id='constructorNamezzry["+i+"]' type='text' name='constructionSafety["+i+"].safetyManageName' value='<s:property value='constructionSafety["+i+"].safetyManageName'/>'/></td><td><input id='constructorNamezzrygw["+i+"]' type='text' name='constructionSafety["+i+"].safetyManageNum' value='<s:property value='constructionSafety["+i+"].safetyManageNum'/>'/></td><td><input id='constructorNamezzrykh["+i+"]' type='text' name='constructionSafety["+i+"].safetyManagecheckNum' value='<s:property value='constructionSafety["+i+"].safetyManagecheckNum'/>'/></td><td><a href='#' onclick='deleteCurrentRow(this)'>删除</a></td></tr>");
      	 document.getElementById("constructorNamezzry["+i+"]").foucs();
    }
  
	//添加行    
	function onAddTRs(trObj)
    {
    	k = k+1;
    	l = l+1;
    	//alert(k);
      	$(addTrs).after("<tr>"
        +"<td colspan='4'>"
        +"<table class='fulltable' width='100%' cellpadding='0' cellspacing='0'>"
        +"  <tr>"
        +"<td>单位名称</td>"
        +"<td><input type='text' id='contractorCorpNamefb["+k+"]' name='majors["+k+"].majorName' value='<s:property value='majors["+k+"].majorName'/>'/></td>"
        +"<td>分包分部分项工程名称</td>"
        +"<td><input type='text' name='majors["+k+"].majorProject' value='<s:property value='majors["+k+"].majorProject'/>'/></td>"
      +"</tr>"
      +"<tr>"
       	+"<td>安全生产许可证有效期</td>"
        +"<td><input id='constructorNamefbdate["+k+"]' type='text' name='majors["+k+"].majorLicenseDate' value='<s:date name='majors["+k+"].majorLicenseDate' format='yyyy-MM-dd' />' onFocus='WdatePicker({dateFmt:\"yyyy-MM-dd\",alwaysUseStartDate:true,isShowClear:true,readOnly:true})' /></td>"
        +"<td>项目负责人</td>"
        +"<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' id='FNamee["+l+"]' name='majors["+k+"].majorStaff' value='<s:property value='majors["+k+"].majorStaff'/>'/><a href='#' onclick='queryPrjNameFBFZR()'><span style='border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;'>选择</span></a></td>"
      +"</tr>"
      +"<tr>"
        +"<td>安全考核证号</td>"
        +"<td><input type='text' id='FCertNumberr["+l+"]'  name='majors["+k+"].majorCardNum' value='<s:property value='majors["+k+"].majorCardNum'/>'/></td>"
        +"<td>联系电话</td>"
        +"<td><input type='text' name='majors["+k+"].majorPhone' value='<s:property value='majors["+k+"].majorPhone'/>'/></td>"
      +"</tr>"
        +"</table><a href='#' onclick='deleteCurrentRow(this)'>删除</a>"
        +"</td>"
      +"</tr>");
      	document.getElementById("FCertNumberr[1]").foucs();
    }
    
	
	//添加行
	function onAddTRss(trObj)
    {
    	j = j+1;
    	//alert(j);
      	$(addTrss).after("<tr>"
                +"<td colspan='4'>"
                +"<table class='fulltable' width='100%' cellpadding='0' cellspacing='0'>"
                +"<tr>"
                +"<td>单位名称</td>"
                +"<td><input type='text' id='contractorCorpNamelw["+j+"]' name='labours["+j+"].labourName' value='<s:property value='labours["+j+"].labourName'/>'/></td>"
                +"<td>安全生产许可证有效期</td>"
                +"<td><input id='constructorNamelwdate["+j+"]' type='text' name='labours["+j+"].labourLicenseDate' value='<s:date name='labours["+j+"].labourLicenseDate' format='yyyy-MM-dd' />' onFocus='WdatePicker({dateFmt:\"yyyy-MM-dd\",alwaysUseStartDate:true,isShowClear:true,readOnly:true})' /></td>"
                +"</tr>"
                +"<tr>"
                +"<td>现场负责人</td>"
                +"<td><input type='text' name='labours["+j+"].labourStaff' value='<s:property value='labours["+j+"].labourStaff'/>'/></td>"
                +"<td>联系电话</td>"
                +"<td><input type='text' name='labours["+j+"].labourPhone' value='<s:property value='labours["+j+"].labourPhone'/>'/></td>"
                +"</tr>"
                +"</table><a href='#' onclick='deleteCurrentRow(this)'>删除</a>"
                +"</td>"
                +"</tr>");
		document.getElementById("constructorNamelwdate[1]").foucs();

    }
	
    //删除指定行
    function deleteCurrentRow(obj){      
    	i=i-1;
    	j=j-1;
    	k=k-1;
    	l=l-1;
		var tr=obj.parentNode.parentNode;   
		var tbody=tr.parentNode;   
		tbody.removeChild(tr); 
		document.getElementById("constructorNamefbdate[1]").foucs();
	}  
	//查询单体工程信息
	function querySingleProject()
	{  
		var prjNum = $("#prjNum").val();
		var prjId = $("#prjId").val();
		var url = "<%=basepath %>/querySingleProjectAction_queryPage.action?prjNum="+prjNum+"&prjId="+prjId+"&condition.prjId="+prjId+"&condition.linkName=4&linkName=4";
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
              	<h2>企业安全监督申请</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>                        	
							 <td colspan="3" align="left">
 							<input id="prjName" type="text" readonly name="safety.prjName" value="<s:property value="safety.prjName"/>" size="115" class="required"/>
							<input id="prjId" type="hidden" readonly name="safety.prjId" value="<s:property value="safety.prjId"/>" class="required"/>
							<input id="safetyId" type="hidden" readonly name="safety.safetyId" value="<s:property value="safety.safetyId"/>" class="required"/>
							</td>
                         </tr>
                         <tr>
                         
                         <th>项目编号：</th>
							<td align="left">
							<input id="prjNum" type="text" readonly name="safety.prjNum" value="<s:property value="safety.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td><th></th><td></td>
                         </tr>
                         <tr>
                         	<th>申请企业名称：</th>
							<td align="left">
							<input type="text" name="safety.applyCorpName" value="<s:property value="safety.applyCorpName"/>" class="required"/>
							</td>
							<th>申请企业代码：</th>
							<td align="left">
							<input type="text" name="safety.applyCorpCode" value="<s:property value="safety.applyCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="appDeptName" readonly type="hidden" name="safety.appDeptName" value="<s:property value="safety.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="safety.appDept" value="<s:property value="safety.appDept"/>"/>
							</td>
                         </tr>
                         <tr>
							<th>安全监督编号：</th>
							<td colspan="3" align="left">
 								<input type="text" size="115" readonly name="safety.safetyNum" value="<s:property value="safety.safetyNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                         <tr>
                           <td colspan="4" align="left"><strong>工程概况</strong></td>
                         </tr>
                         <tr>
                         	<th>工程名称</th>
                            <td colspan="3" align="left">
 							   <input type="text" name="safety.projectName" value="<s:property value="safety.projectName"/>" size="115" class="required"/></td>
                         </tr>
                         <tr>
                           <th>工程地点</th>
                            <td colspan="3" align="left">
                            <input name="safety.projectAddress" type="text" value="<s:property value="safety.projectAddress"/>" size="115" class="required"/></td>
                         </tr>
                         <tr>
                           <th>合同开工日期</th>
                           <td align="left"><input id="time1" type="text" name="safety.proStartDate" value="<s:date name="safety.proStartDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /></td>
                           <th>合同竣工日期</th>
                           <td align="left"><input id="time2" type="text" name="safety.proEndDate" value="<s:date name="safety.proEndDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /></td>
                         </tr>
                         <tr>
                           <th>工程类型</th>
                           <td align="left">
                           <select name="safety.projectType" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="projectTypes">
	          						<option value="<s:property value="code"/>"<s:if test='safety.projectType==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select>
                           </td>
                           <th>安全生产标准化创建目标</th>
                           <td align="left"><input type="text" name="safety.safetyTarget" value="<s:property value="safety.safetyTarget"/>" class="required"/></td>
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
                           <input type="checkbox" name="safety.other" value="2" checked />
                           	其它
                           </s:if>
                           <s:else>
                           <input type="checkbox" name="safety.other" value="2"  />
                           	其它
                           </s:else>
                           	<tr>
                           </td>
                         </tr>
                         
                          
                         <tr>
                           <th>勘察单位全称</th>
                           <td colspan="3" align="left">
                            <input type="text" name="safety.policingName" size="115" value="<s:property value="safety.policingName"/>" class="required"/></td>
                           </tr>
                            <tr>
                           <th>设计单位全称</th>                          
                           <td colspan="3" align="left">
                            <input type="text" size="115" name="safety.designName" value="<s:property value="safety.designName"/>" class="required"/></td>
                            </tr>
                         <tr>
                           <th>设计单位项目负责人</th>
                           <td align="left"><input type="text" name="safety.designStaff" value="<s:property value="safety.designStaff"/>" class="required"/></td>
                        	<th>勘察单位项目负责人</th>
                           <td align="left"><input type="text" name="safety.policingStaff" value="<s:property value="safety.policingStaff"/>" class="required"/></td>
                         </tr>                       
                         <tr>
                           <th>建设单位全称</th>
                           <td align="left"><input type="text" name="safety.buildingName" value="<s:property value="safety.buildingName"/>" class="required"/></td>
                           <th>建设单位项目负责人</th>
                           <td align="left"><input type="text" name="safety.buildingStaff" value="<s:property value="safety.buildingStaff"/>" class="required"/></td>
                         </tr>
                         <tr>
                           <th>建设单位联系电话</th>
                           <td align="left"><input type="text" name="safety.buildingPhone" value="<s:property value="safety.buildingPhone"/>" class="required"/></td>
                           <td>&nbsp;</td>
                           <td>&nbsp;</td>
                         </tr>
                         <tr>
                           <td align="left" colspan="4"><strong>监理单位</strong></td>
                         </tr>
                         <tr>
                           <th>单位全称</th>
                             <td colspan="3" align="left">
                              <input type="text" name="safety.supervisionName" size="115" value="<s:property value="safety.supervisionName"/>" class="required"/></td>
                           
                         </tr>
                         <tr>
                           <th>项目总监姓名</th>
                           <td align="left"><input type="text" name="safety.supervisionStaff" value="<s:property value="safety.supervisionStaff"/>" class="required"/></td>
                           <th>项目总监注册证书号</th>
                           <td align="left"><input type="text" name="safety.supervisionNum" value="<s:property value="safety.supervisionNum"/>" class="required"/></td>
                         </tr>
                         <tr>
                           <th>项目总监联系电话</th>
                           <td align="left"><input type="text" name="safety.supervisionPhone" value="<s:property value="safety.supervisionPhone"/>" class="required"/></td>
                           <td>&nbsp;</td>
                           <td>&nbsp;</td>
                         </tr>
                         <tr>
                           <th>安全监理姓名</th>
                           <td align="left"><input type="text" name="safety.probationStaff" value="<s:property value="safety.probationStaff"/>" class="required"/></td>
                           <th>安全监理注册证书号</th>
                           <td align="left"><input type="text" name="safety.probationNum" value="<s:property value="safety.probationNum"/>" class="required"/></td>
                         </tr>
                         <tr>
                           <th>安全监理联系电话</th>
                           <td align="left"><input type="text" name="safety.probationPhone" value="<s:property value="safety.probationPhone"/>" class="required"/></td>
                           <th>安全监理证号</th>
                           <td align="left"><input type="text" name="safety.probationSafeNum" value="<s:property value="safety.probationSafeNum"/>" class="required"/></td>
                         </tr>
                         <tr>
                           <td align="left" colspan="4"><strong>施工总承包单位</strong></td>
                         </tr>
                         <tr>
                           <th>单位全称</th>
                           <td colspan="3" align="left">
                            <input id='contractorCorpNamezb' size="115" type="text" name="safety.contractName" value="<s:property value="safety.contractName"/>" class="required"/></td>                           
                         </tr> 
                         <tr>
                         <tr>
                           <th>安全管理负责人</th>
                            <td colspan="3" align="left">
                              <input type="text" name="safety.contractAdmin" size="115" value="<s:property value="safety.contractAdmin"/>" class="required"/></td>
                           </tr>
                         <tr>
                         <th>安全考核证号</th>
                           <td align="left"><input type="text" name="safety.contractSafeNum" value="<s:property value="safety.contractSafeNum"/>" class="required"/></td>
                         <th>联系电话</th>
                           <td align="left"><input type="text" name="safety.contractPhone" value="<s:property value="safety.contractPhone"/>" class="required"/></td>
                         </tr>      
                         
                         <tr>
                         <th>项目负责人姓名</th>
                           <td colspan="3" align="left">
                              <input type="text" name="safety.contractProStaff" size="115" value="<s:property value="safety.contractProStaff"/>" class="required"/></td>
                         </tr>
                         
                         <tr>
                           <th>项目负责人注册证号</th>
                           <td align="left"><input type="text" name="safety.contractStaffRegNum" value="<s:property value="safety.contractStaffRegNum"/>" class="required"/></td>
                           <th>项目负责人考核证号</th>
                           <td align="left"><input type="text" name="safety.contractStaffNum" value="<s:property value="safety.contractStaffNum"/>" class="required"/></td>
                         </tr>
                            <tr>               
                           
                           
                           <th>项目负责人联系电话</th>
                           <td align="left"><input type="text" name="safety.contractProStaffPhone" value="<s:property value="safety.contractProStaffPhone"/>" class="required"/></td>
                          <!--
                          <th>单位工程名称</th>
                          <td>
                             <input type="text" name="safety.unitProject" value="<s:property value="safety.unitProject"/>" class="required"/></td>
                           -->  
                         </tr>
                         
                         <tr>
                           <td align="left" colspan="4">
                           	  <strong>现场专职安全管理人员</strong>
                    
                           	
                           </td>
                         </tr>
                         
                              <td colspan="4" >
                           <table class="fulltable" width="100%" cellpadding="0" cellspacing="0">
                             <tr>                         
                         	<th>姓名</th>
                         	<th>岗位证号</th>
							<th>安全考核证号</th>
							
							</tr>
							  
							 <s:iterator status="t" value="safety.csList" > 
                             <tr>                      
                               <td><input type="text" name="constructionSafety[<s:property value='#t.count'/>].safetyManageName" value="<s:property value="safetyManageName"/>"/></td>
                               <td><input type="text" name="constructionSafety[<s:property value='#t.count'/>].safetyManageNum" value="<s:property value="safetyManageNum"/>"/></td>
                               <td><input type="text" name="constructionSafety[<s:property value='#t.count'/>].safetyManagecheckNum" value="<s:property value="safetyManagecheckNum"/>"/></td>
                                 
                             </tr>
                              </s:iterator>                 	             
                        </table></td>                      
                                                
                         <tr>
                           <td colspan="4" align="left">
                           <strong>专业分包单位</strong>
                              </td>
                         </tr>
                         
                         <s:iterator status="y" value="safety.majors" > 
                         <tr>
                           <td colspan="4">
                           <table class="fulltable" width="100%" cellpadding="0" cellspacing="0">
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
                           <td align="left"> <input type="text" name="majors[<s:property value='#y.count'/>].majorStaff" value="<s:property value="majorStaff"/>"/></td>
                         </tr>
                         <tr>
                           <td>安全考核证号</td>
                           <td align="left"><input type="text" name="majors[<s:property value='#y.count'/>].majorCardNum" value="<s:property value="majorCardNum"/>"/></td>
                           <td>联系电话</td>
                           <td align="left"><input type="text" name="majors[<s:property value='#y.count'/>].majorPhone" value="<s:property value="majorPhone"/>"/></td>
                         </tr>
                           </table>
                          
                           </td>
                         </tr>
                         </s:iterator>                       
                         <tr>
                           <td colspan="4" align="left">
                            <strong>劳务分包单位</strong>
                               </td>
                         </tr>
                         
                         
                         <s:iterator status="i" value="safety.labours" > 
                         <tr>
                           <td colspan="4">
                           <table class="fulltable" width="100%" cellpadding="0" cellspacing="0">
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
              						 
              						</td>
              						</tr>
	                 	</s:iterator>
	                 	<!-- 
	            		<tr>
                       		<th>附件上传：</th>
							<td align="left" colspan="3">
							<input id="uf" type="file" name="file">
							&nbsp;
							<input type="button" onclick="upload('<s:property value="safety.safetyId"/>')" value="上传" />
							</td>
						</tr>
						<tr>
                       		<th>附件：</th>
							<td align="left" colspan="3">
							<s:iterator status="i" value="safety.list">
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
