<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<html>
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
	//保存
	function save(){
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            var check = /^([1-9]\d*|0)(\.\d*[1-9])?$/; 
	 			var sectionName = $("#sectionName").val();
	 			var prjName = $("#prjName").val();
	 			 if(prjName=="" || prjName==null)
 				{
 					alert("请选择项目名称!");
 				}else if(sectionName=="" || sectionName==null)
 				{
 					alert("请选择标段名称!");
 				}else
	 			{
 					$("#form1").attr("action", "<%=basepath %>/safetyAction_add.action");
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
		document.form1.action="<%=basepath  %>/safetyAction_goList.action";
		document.form1.submit();
	}
	
	//查询项目
	function queryPrjName()
	{
		
		var url="<%=basepath %>/qualityPrjsAction_queryPage.action?checkType=1";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//查询勘察单位信息
	function queryPrjNameKC()
	{   
		var prjnum=document.getElementById("prjNum").value;	  
		var url="<%=basepath %>/QualitykcAction_queryPagekc.action?condition.prjNum="+prjnum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	
	//查询设计单位
	function queryPrjNameSJ()
	{   
		var prjnum=document.getElementById("prjNum").value;	  
		var url="<%=basepath %>/QualitySJAction_queryPageSJ.action?condition.prjNum="+prjnum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//查询监理单位
	function queryPrjNameJL() 
	{   
		var prjnum=document.getElementById("prjNum").value;	  
		var url="<%=basepath %>/QualityjlAction_queryPagejl.action?condition.prjNum="+prjnum;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//查询安全管理负责人
	function queryPrjNameAQFZ() 
	{   
		var personaqfz = document.getElementById("contractorCorpNamezb").value;	
		var url="<%=basepath %>/QualityanfzAction_queryPageanfz.action?personaqfz="+personaqfz;
		url=encodeURI(url);
		url=encodeURI(url);
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//查询项目负责人
	function queryPrjNameXMFZ() 
	{   
		var contractorCorpNamezb = document.getElementById("contractorCorpNamezb").value;
		var url="<%=basepath %>/QualityanxmfzAction_queryPageanxmfz.action?condition.corpname="+contractorCorpNamezb+"&corpname="+contractorCorpNamezb;
		url=encodeURI(url);
		url=encodeURI(url);
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//查询专业分包项目负责人 
	function queryPrjNameFBFZR() 
	{   
		var contractorCorpNamefb = document.getElementById("contractorCorpNamefb["+k+"]").value;
		var url="<%=basepath %>/QualityfbfzrAction_queryPagefbfzr.action?contractorCorpNamefb="+contractorCorpNamefb+"&&l="+l;
		url=encodeURI(url);
		url=encodeURI(url);
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
	
	//现场专职安全管理人员
	function queryPrjNameZZRY() 
	{   
	   
		var contractorCorpNamezb = document.getElementById("contractorCorpNamezb").value;
		var url="<%=basepath %>/QualityzzryAction_queryPagezzry.action?condition.corpname="+contractorCorpNamezb+"&&i="+i+"&corpname="+contractorCorpNamezb;
		url=encodeURI(url);
		url=encodeURI(url);
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
		var prjnum = document.getElementById("prjNum").value;
		var url="<%=basepath %>/QualityfbAction_queryPagefb.action?condition.prjNum="+prjnum+"&k="+k;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//查询劳务分包单位 
	function queryPrjNameLW() 
	{   
		var prjnum = document.getElementById("prjNum").value;
		var url="<%=basepath %>/QualitylwAction_queryPagelw.action?condition.prjNum="+prjnum+"&j="+j;
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//信息查询
	function queryPrjid(){
		var prjnum = document.getElementById("prjNum").value;
		//alert(prjnum);
		//var ii = layer.load('查询中');
		$.ajax({
			url: '<%=basepath %>/qualityPrjsAction_queryPagee.action',
			data: 'prjnum='+prjnum, //这里是要传递的参数　　
			type: 'post',
			dataType: 'json',
			//async: false,
			success: function(data) {  //回调函数，result，返回值 
				var items = eval("("+data+")");
         	   //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
				//alert(data);	
         	    document.getElementById("projectAddress").value=items[0].projectAddress;//工程地点
				//document.getElementById("contractorCorpName").value=items[0].contractorCorpName;//设计单位名称
				//document.getElementById("contractorCorpNameKC").value=items[0].contractorCorpNameKC;//勘察单位名称
				//document.getElementById("constructorName").value=items[0].constructorName;//设计单位项目经理姓名
				//document.getElementById("constructorNameKC").value=items[0].constructorNameKC;//勘察单位项目经理名称
				//document.getElementById("contractorCorpNameJL").value=items[0].contractorCorpNameJL;//监理单位全称
				//document.getElementById("directorName").value=items[0].directorName;//监理项目总监 
				//document.getElementById("directorIdCard").value=items[0].directorIdCard;//项目总监注册证书号
				//document.getElementById("phoneJL").value=items[0].phoneJL;//项目总监联系电话
				//document.getElementById("safetyName").value=items[0].safetyName;//安全监理姓名
				//document.getElementById("safetyIdCard").value=items[0].safetyIdCard;//安全监理注册证书号
				//document.getElementById("contractorCorpNameZCB").value=items[0].contractorCorpNameZCB;//总承包单位全称
				//document.getElementById("constructorNameZCB").value=items[0].constructorNameZCB;//总承包项目经理
				//document.getElementById("phoneZCB").value=items[0].phoneZCB;//总承包项目经理联系电话 
				//document.getElementById("securityName").value=items[0].securityName;//安全员 
				
				//document.getElementById("phone").value=items[0].phone;
				//document.getElementById("phoneKC").value=items[0].phoneKC;

				// $("#cityId").empty();
			//layer.close(ii); 
			//if(data.result=='false'){
			//layer.msg(data.message);
			//}else{	
			//alert();
			//}
	    }
	});
}
</script>
<script type="text/javascript">
	var i = 0;
	var k = 0;
	var j = 0;
	var l = 0;
    //添加行
	function onAddTR(trObj)
    {
    	i = i+1;
    	$(addTr).after("<tr><td align='left'><input id='constructorNamezzry["+i+"]' type='text' name='constructionSafety["+i+"].safetyManageName' value='<s:property value='constructionSafety["+i+"].safetyManageName'/>' class='required' /><strong><font color='#FF0000'>*</font></strong></td><td align='left'><input id='constructorNamezzrygw["+i+"]' type='text' name='constructionSafety["+i+"].safetyManageNum' value='<s:property value='constructionSafety["+i+"].safetyManageNum'/>' class='required' /><strong><font color='#FF0000'>*</font></strong></td><td align='left'><input id='constructorNamezzrykh["+i+"]' type='text' name='constructionSafety["+i+"].safetyManagecheckNum' value='<s:property value='constructionSafety["+i+"].safetyManagecheckNum'/>' class='required' /><strong><font color='#FF0000'>*</font></strong></td><td><a href='#' onclick='deleteCurrentRow(this)'>删除</a></td></tr>");
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

    }
	
    //删除指定行
    function deleteCurrentRow(obj){      

    	
    	i=i-1;
    	
		var tr=obj.parentNode.parentNode;   
		var tbody=tr.parentNode;   
		tbody.removeChild(tr); 
		document.getElementById("constructorNamefbdate[0]").foucs();
	}    //删除指定行
    function deleteCurrentRowlk(obj){      
    	k=k-1;
    	l=l-1;
		var tr=obj.parentNode.parentNode;   
		var tbody=tr.parentNode;   
		tbody.removeChild(tr); 
		document.getElementById("constructorNamefbdate[0]").foucs();
	} 
    //删除指定行
    function deleteCurrentRowj(obj){      
    	j=j-1;
		var tr=obj.parentNode.parentNode;   
		var tbody=tr.parentNode;   
		tbody.removeChild(tr); 
		 
	} 
    
    function checkreadonly()  
	{  
	 document.getElementById("prjName").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("prjNum").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("qiye").style.backgroundColor="#EBEBE4"; 	
	 document.getElementById("daima").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("projectAddress").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("contractorCorpName").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("contractorCorpNamesj").style.backgroundColor="#EBEBE4"; 
     document.getElementById("constructorName").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("constructorNamesj").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("buildCorpName").style.backgroundColor="#EBEBE4"; 	
	 document.getElementById("projectManager").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("unitPhone").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("contractorCorpNamejl").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("contractorCorpNamezb").style.backgroundColor="#EBEBE4"; 
     document.getElementById("FName").style.backgroundColor="#EBEBE4"; 	
	 document.getElementById("FCertNumber").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("constructorNameXMFZ").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("constructorNameZSBH").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("constructorNameKHBH").style.backgroundColor="#EBEBE4";
	}  
    
    
    

</script>
</head>
    
<body onload="checkreadonly()">
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>企业安全监督申请</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>  
                	<tr>
                           <th>项目名称：</th>
                           <td colspan="3" align="left">
                       
                           <input id="prjName" type="text" readonly=false style="color:#707070" name="safety.prjName" value="<s:property value="safety.prjName"/>" size="108" class="required"/><strong><font color="#FF0000">*</font></strong><a href="#" onclick="queryPrjName()">&nbsp;&nbsp;<span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							<input id="prjId" type="hidden" readonly name="safety.prjId" value="<s:property value="safety.prjId"/>" class="required"/>
							<input type="hidden" readonly name="safety.safetyId" value="<s:property value="safety.safetyId"/>" class="required"/></td>
                           
                         </tr>
                	 
                         <tr>   
							<th>项目编号</th>
							<td  align="left">
							<input id="prjNum" type="text" readonly=false style="color:#707070" name="safety.prjNum" value="<s:property value="safety.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td><th></th><td></td>
                         </tr>
                         <tr>
                         	<th>申请企业名称</th>
							<td  align="left">
							<input  id="qiye" type="text" readonly=false style="color:#707070" name="safety.applyCorpName" value="<s:property value="corpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>申请企业代码</th>
							<td align="left">
							<input id="daima" type="text" readonly=false style="color:#707070" name="safety.applyCorpCode" value="<s:property value="corpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="appDeptName" readonly type="hidden" name="safety.appDeptName" value="<s:property value="safety.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="safety.appDept" value="<s:property value="safety.appDept"/>"/>
							</td>
                         </tr>
                         <tr>
                           <td colspan="4" align="left"><strong>工程概况</strong></td>
                         </tr>
                         <tr>
                         	<th>工程名称<strong></th>
                            <td colspan="3" align="left">
							<input  id='sectionName' type="text" name="safety.projectName" value="<s:property value="safety.projectName"/>" size="108"  class="required"/><strong><font color="#FF0000">*</font></strong>
							<a href="#" onclick="queryPrjNameZB()">&nbsp;&nbsp;<span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a></td>
                         </tr>
                         <tr>
                           <th>工程地点</th>
                           <td colspan="3" align="left">
                           <input id='projectAddress' style="color:#707070" name="safety.projectAddress" type="text" value="<s:property value="safety.projectAddress"/>" size="108"  /><strong><font color="#FF0000">*</font></strong></td>
                           
                         </tr>
                         <tr>
                           <th>合同开工日期</th>
                           <td align="left"><input id="contractstart" type="text" name="safety.proStartDate" value="<s:date name="safety.proStartDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" /><strong><font color="#FF0000">*</font></strong></td>
                           <th>合同竣工日期</th>
                           <td align="left"><input id="contractend" type="text" name="safety.proEndDate" value="<s:date name="safety.proEndDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})"  /><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                         <tr>
                           <th>工程类型</th>
                           <td>
                           <select name="safety.projectType" >
     							<option value="">请选择</option>
	      						<s:iterator value="projectTypes">
	          						<option value="<s:property value="code"/>"<s:if test='safety.projectType==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select>
							<strong><font color="#FF0000">*</font></strong>
                           </td>
                           <th></th>
                           <td></td>
                         </tr>
                         <tr>
                         <th>安全生产标准化创建目标</th>
                         <td colspan="3" align="left">
                          <input type="text" name="safety.safetyTarget" value="<s:property value="safety.safetyTarget"/>" size="108" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                         <tr>
                           <th>建筑规模(建筑面积或体积)</th>
                           <td align="left"><input type="text" name="safety.scale" value="<s:property value="safety.scale"/>" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                           <th>工程总造价(万元)</th>
                           <td align="left"><input type="text" name="safety.cost" value="<s:property value="safety.cost"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                         
                         
 
                         </tr>
                         
                         <tr>
                           <th>结构/层次</th>
                           <td align="left"><input type="text" name="safety.structure" value="<s:property value="safety.structure"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                           <th>建筑总高度</th>
                           <td align="left"><input type="text" name="safety.height" value="<s:property value="safety.height"/>" class="required number"/><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                         
                         <tr>
                           <td align="left" colspan="4">
                            	<input id="eee"  type="checkbox" name="safety.newlyBuild" value="0" />新建
                           	<input id='eeee' type="checkbox" name="safety.extend" value="1" />改建
                           	 <input id='eeeeee' type="checkbox" name="safety.other" value="2" />扩建
                           	<input id='eeeee' type="checkbox" name="safety.other" value="3" />其它
                          </td>
                         </tr>  
                         
                         
                         <tr>
                         <th>勘察单位全称</th>
                          <td colspan="3" align="left">
                         <input id='contractorCorpName' style="color:#707070" type="text" name="safety.policingName" value="<s:property value="safety.policingName"/>" size="108"  /><strong><font color="#FF0000">*</font></strong>
                         <a href="javascript:queryPrjNameKC()" onclick="">&nbsp;&nbsp;<span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
                         </td>
                         </tr>
                         
                          <tr>
                         <th>设计单位全称</th>
                          <td colspan="3" align="left">
                         <input id='contractorCorpNamesj' style="color:#707070" type="text" name="safety.designName" value="<s:property value="contractorCorpNamesj"/>" size="108" /><strong><font color="#FF0000">*</font></strong>
                         <a href="javascript:queryPrjNameSJ()" onclick=""> <span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
                         </td>
                         <input id='contractorCorpCode' type="hidden" readonly name="safety.contractorCorpCode" value="<s:property value="safety.contractorCorpCode"/>" /></td>
                         </tr> 
                                               
                         <tr>
                           <th>勘察单位项目负责人</th>
                           <td align="left"><input style="color:#707070" id='constructorName'   type="text" name="safety.policingStaff" value="<s:property value="safety.policingStaff"/>" /><strong><font color="#FF0000">*</font></strong></td>
                        <th>设计单位项目负责人</th>
                           <td align="left"><input id='constructorNamesj' style="color:#707070"   type="text" name="safety.designStaff" value="<s:property value="constructorNamesj"/>" /><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                         <tr>
                           <th>建设单位全称</th>
                           <td align="left"><input  style="color:#707070" id='buildCorpName' type="text" name="safety.buildingName" value="<s:property value=" "/>" /><strong><font color="#FF0000">*</font></strong></td>
                           <th>建设单位项目负责人</th>
                           <td align="left"><input id='projectManager' style="color:#707070"   type="text" name="safety.buildingStaff" value="<s:property value=" "/>" /><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                         <tr>
                           <th>建设单位联系电话</th>
                           <td align="left"><input id='unitPhone' style="color:#707070"   type="text" name="safety.buildingPhone" value="<s:property value=" "/>"  /><strong><font color="#FF0000">*</font></strong></td>
                           <td>&nbsp;</td>
                           <td>&nbsp;</td>
                         </tr>
                         <tr>
                           <td align="left" colspan="4"><strong>监理单位</strong></td>
                         </tr>
                         <tr>
                           <th>单位全称</th>
                           <td colspan="3" align="left">
                          <input id='contractorCorpNamejl' style="color:#707070"    type="text" name="safety.supervisionName" value="<s:property value="safety.supervisionName"/>" size="108"  />
                          <a href="javascript:queryPrjNameJL()" onclick="">&nbsp;&nbsp;<span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a></td>                        
                         </tr>
                         <tr>
                           <th>项目总监姓名</th>
                           <td align="left"><input id='directorName'  type="text" name="safety.supervisionStaff" value="<s:property value="safety.supervisionStaff"/>"  /><strong><font color="#FF0000">*</font></strong></td>
                           <th>项目总监注册证书号</th>
                           <td align="left"><input id='directorIdCard' type="text" name="safety.supervisionNum" value="<s:property value="safety.supervisionNum"/>"  /><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                         <tr>
                           <th>项目总监联系电话</th>
                           <td align="left"><input id='phoneJLL' type="text" name="safety.supervisionPhone" value="<s:property value="safety.supervisionPhone"/>"  /><strong><font color="#FF0000">*</font></strong></td>
                           <td>&nbsp;</td>
                           <td>&nbsp;</td>
                         </tr>
                         <tr>
                           <th>安全监理姓名</th>
                           <td align="left"><input id='safetyName' type="text" name="safety.probationStaff" value="<s:property value="safety.probationStaff"/>"  /><strong><font color="#FF0000">*</font></strong></td>
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
                             <input id='contractorCorpNamezb'style="color:#707070"   type="text" name="safety.contractName" size="108"  value="<s:property value="safety.contractName"/>" /></td>                          
                         </tr>
                         <tr>
                           <th>安全管理负责人</th>
                           <td colspan="3" align="left">
                            <input id='FName' type="text" style="color:#707070"   name="safety.contractAdmin" value="<s:property value="safety.contractAdmin"/>" size="108"  /><strong><font color="#FF0000">*</font></strong><a href="javascript:queryPrjNameAQFZ()" onclick="">&nbsp;&nbsp;<span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a></td>
                           
                         </tr>
                         <tr>
                           
                           <th>安全考核证号</th>
                           <td align="left"><input id='FCertNumber' style="color:#707070"   type="text" name="safety.contractSafeNum" value="<s:property value="safety.contractSafeNum"/>"  /><strong><font color="#FF0000">*</font></strong></td>
                         <th>联系电话</th>
                           <td align="left"><input type="text"  name="safety.contractPhone" value="<s:property value="safety.contractPhone"/>"  /><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                         <tr>
                           <th>项目负责人姓名</th>
                           <td colspan="3" align="left" >
                            <input id='constructorNameXMFZ' type="text" style="color:#707070"   name="safety.contractProStaff" value="<s:property value="safety.contractProStaff"/>" size="108" /><strong><font color="#FF0000">*</font></strong><a href="javascript:queryPrjNameXMFZ()" onclick="">&nbsp;&nbsp;<span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a></td>
                         </tr>
                         <tr>
                           <th>项目负责人注册证号</th>
                           <td align="left"><input id='constructorNameZSBH' style="color:#707070"  type="text" name="safety.contractStaffRegNum" value="<s:property value="safety.contractStaffRegNum"/>"  /><strong><font color="#FF0000">*</font></strong></td>
                           <th>项目负责人考核证号</th>
                           <td align="left"><input id='constructorNameKHBH' style="color:#707070"   type="text" name="safety.contractStaffNum" value="<s:property value="safety.contractStaffNum"/>"  /><strong><font color="#FF0000">*</font></strong></td>
                         </tr>
                         <tr>
                         <tr>
                           <th>项目负责人联系电话</th>
                           <td align="left"><input id='phonezcb' type="text" name="safety.contractProStaffPhone" value="<s:property value="safety.contractProStaffPhone"/>"  /><strong><font color="#FF0000">*</font></strong></td>
                           <td>&nbsp;</td>
                           <td>&nbsp;</td>
                         </tr>
                           <td align="left" colspan="4">
                           	<strong>现场专职安全管理人员</strong>
                             
                           <a href="javascript:queryPrjNameZZRY()" onclick="" style="float:right;" ><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a><a href="javascript:onAddTR(this)" onclick="" style="float:right;" ><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">添加</span></a>  
                          
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
							<tr id="addTr"></tr>
							<tr>
								<td align="left"><input id='constructorNamezzry[0]' type='text' name='constructionSafety[0].safetyManageName' value='<s:property value='constructionSafety[0].safetyManageName'/>' class="required"/><strong><font color='#FF0000'>*</font></strong></td>
							    <td align="left"><input id='constructorNamezzrygw[0]' type='text' name='constructionSafety[0].safetyManageNum' value='<s:property value='constructionSafety[0].safetyManageNum'/>' class="required"/><strong><font color='#FF0000'>*</font></strong></td>
							    <td align="left"><input id='constructorNamezzrykh[0]' type='text' name='constructionSafety[0].safetyManagecheckNum' value='<s:property value='constructionSafety[0].safetyManagecheckNum'/>' class="required"/><strong><font color='#FF0000'>*</font></strong></td>
							    <td></td>
							</tr>                     	             
                        </table></td>

                         <tr>
                          
                           <td colspan="4" align="left">
                           <strong>专业分包单位</strong>                          
                         <a href="javascript:queryPrjNameFB()" onclick="" style="float:right;" ><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>	
                         <a href="javascript:onAddTRs(this)" onclick="" style="float:right;" ><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">添加</span></a>
                           </td>
                         </tr>
                         <tr id="addTrs">
                           <td colspan="4">
                           <table class="fulltable" width="100%" cellpadding="0" cellspacing="0">
                             <tr>
                           <td>单位名称</td>
                           <td align="left"><input id='contractorCorpNamefb[0]' type="text" name="majors[0].majorName" value="<s:property value="majors[0].majorName"/>" /></td>
                           <td>分包分部分项工程名称</td>
                           <td align="left"><input type="text" name="majors[0].majorProject" value="<s:property value="majors[0].majorProject"/>"  /></td>
                         </tr>
                         <tr>
                           <td>安全生产许可证有效期</td>
                           <td align="left"><input id="constructorNamefbdate[0]" type="text" name="majors[0].majorLicenseDate" value="<s:date name="majors[0].majorLicenseDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})"  /></td>
                           <td>项目负责人</td>
                           <td align="left"><input id='FNamee[0]' type="text" name="majors[0].majorStaff" value="<s:property value="majors[0].majorStaff"/>"   /><a href="javascript:queryPrjNameFBFZR()" onclick="" style="float:right;"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a></td>
                         </tr>
                         <tr>
                           <td>安全考核证号</td>
                           <td align="left"><input  id='FCertNumberr[0]' type="text" name="majors[0].majorCardNum" value="<s:property value="majors[0].majorCardNum"/>"  /></td>
                           <td>联系电话</td>
                           <td align="left"><input id='' type="text" name="majors[0].majorPhone" value="<s:property value="majors[0].majorPhone"/>"  /></td>
                         </tr>
                           </table>
                           
                           </td>
                         </tr>
                         <tr>
                           <td colspan="4" align="left">
                           <strong>劳务分包单位</strong>
                            	 
                           <a href="javascript:queryPrjNameLW()" onclick="" style="float:right;"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>	
                           <a href="javascript:onAddTRss(this)" onclick="" style="float:right;"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">添加</span></a>
                           </td>
                         </tr>
                         <tr id="addTrss">
                           <td colspan="4">
                           <table class="fulltable" width="100%" cellpadding="0" cellspacing="0">
                           <tr>
                           
                            <td>单位名称</td>
                         <td align="left"><input id='contractorCorpNamelw[0]' type="text" name="labours[0].labourName" value="<s:property value="labours[0].labourName"/>"  /></td>
                           <td>安全生产许可证有效期</td>
                           <td align="left"><input id="constructorNamelwdate[0]" type="text" name="labours[0].labourLicenseDate" value="<s:date name="labours[0].labourLicenseDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})"  /></td>
                         </tr>
                         <tr>
                           <td>现场负责人</td>
                           <td align="left"><input id='constructorNamelw' type="text" name="labours[0].labourStaff" value="<s:property value="labours[0].labourStaff"/>"  /></td>
                           <td>联系电话</td>
                           <td align="left"><input id='phonezlw't ype="text" name="labours[0].labourPhone" value="<s:property value="labours[0].labourPhone"/>" /></td>
                         </tr>
                           </table>
                           </td>
                         </tr>
                   
                         
                  </tbody>  
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
		            <input type="image"src="<%=basepath %>/images/shangbao.jpg"  onclick="save()"/>
            	</div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
