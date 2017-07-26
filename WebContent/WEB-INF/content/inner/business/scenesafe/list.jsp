<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报施工许可项目审核</title>
<script type="text/javascript" src="jquery-1.11.1.js"></script>
<script type="text/javascript">
var i = 0;
//添加行
function onAddTR(trObj)
{
	 i = i+1;
	//alert(i);
  	$(addTr).after("<tr><td><input id='constructorNamezzry["+i+"]' type='text' name='construscenesafe["+i+"].jcneirong' value='<s:property value='construscenesafe["+i+"].jcneirong'/>'/></td><td><input id='constructorNamezzrygw["+i+"]' type='text' name='construscenesafe["+i+"].question' value='<s:property value='construscenesafe["+i+"].question'/>'/></td><td><input id='constructorNamezzrykh["+i+"]' type='text' name='construscenesafe["+i+"].suggestion' value='<s:property value='construscenesafe["+i+"].suggestion'/>'/></td><td><a href='#' onclick='deleteCurrentRow(this)'>删除</a></td></tr>");
  	// document.getElementById("constructorNamezzry["+i+"]").foucs();
  
}
//删除指定行
function deleteCurrentRow(obj){      
	i=i-1; 
	var tr=obj.parentNode.parentNode;   
	var tbody=tr.parentNode;   
	tbody.removeChild(tr); 
	 
}   
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/promiseApplyAction_queryPage.action";
		document.form1.submit();
	}
	//查询项目
	function queryPrjName()
	{
		
		var url="<%=basepath %>/scenesafeAction_queryPagee.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
	//上传
	function upload(id)
	{
		
		var uf = $("#uf").val();
		if(uf!="")
		{
			//var isUnits = $("#isUnits").val();
			var actionUrl = "<%=basepath%>/fileUpload_uploadFile.action?id="+id+"&linkName=现场安全&isUnits=1&returnRoot=scenesafe";
			actionUrl = encodeURI(actionUrl);
			actionUrl = encodeURI(actionUrl);
			alert(actionUrl);
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
		document.form1.action="<%=basepath%>/fileUpload_deleteFile.action?id="+uploadId+"&returnRoot=scenesafe";
		document.form1.submit();
	}
	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath%>/fileUpload_downLoadFile.action?id="
				+ uploadId + "&returnRoot=scenesafe";
		document.form1.submit();
	}
	//查询
	function goBack()
	{
		document.form1.action="<%=basepath%>/querscenesafeAction_querypagey.action";
		document.form1.submit();
	}
	
	function checkreadonly()  
	{  
	      
  
	 document.getElementById("builderlicencenum").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("prjnumm").style.backgroundColor="#EBEBE4"; 
	 document.getElementById("prjnamee").style.backgroundColor="#EBEBE4"; 
	    
	}  
	//保存
	function save(){
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            var check = /^([1-9]\d*|0)(\.\d*[1-9])?$/; 
	 			//var sectionName = $("#sectionName").val();
	 			var prjnamee = $("#prjnamee").val();
	 			 if(prjnamee=="" || prjnamee==null)
 				{
 					alert("请选择项目名称!");
 				}else
	 			{
 					$("#form1").attr("action", "<%=basepath %>/scenesafeAction_addpage.action");
 					document.getElementById("form1").submit();
 					//form.submit();
	 			}
	 			
	        }   
	 	});
	});
	}

</script>

</head>
<body onload="checkreadonly()" >  
	<div class="libiao">
		<form id="form1" name="form1" method="post" action="">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">现场质量安全监督审查</legend>
							<p style="margin-bottom: 10px; text-align: right;">
							<!--  <a href="#" onclick="query()"><span class="lbchx">保存</span></a>
								<a href="#" onclick="query()"><span class="lbchx">返回</span></a>-->
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">
								<tr>
									<td>项目编号:</td>
									<td align="left" ><input id="prjnumm" style="color:#707070"  readonly="true"  type="text" size="50" name="scenesafe.prjnumm"
										value="<s:property value="scenesafe.prjnumm"/>"  class="required"/></td>
									<td>施工许可证号:</td>
									<td align="left"><input id="builderlicencenum" style="color:#707070"  readonly="true"  type="text" size="50" name="scenesafe.builderlicencenum"
										value="<s:property value="scenesafe.prjnumm"/>" class="required" /></td>
								</tr>
								<tr>
									<td >项目名称:</td>
									<td align="left" colspan="3" >
									<input type="hidden"  name="scenesafe.permitid" value="<s:property value="scenesafe.permitid"/>"  /> 
									<input id="prjnamee" style="color:#707070"  readonly="true"  type="text" size="100" name="scenesafe.prjnamee" value="<s:property value="scenesafe.prjnamee"/>"  /><a href="#" onclick="queryPrjName()"><span class="lbchx">选择</span></a>
									</td>														
								</tr>
								<tr>
									<td>检查人:</td>
									<td align="left"><input type="text" size="50" name="scenesafe.jcporson"
										value="<s:property value="scenesafe.jcporson"/>" /></td>
									<td>检查时间:</td>
									<td align="left"><input type="text" size="50" name="scenesafe.jcdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})"
										value="<s:property value="scenesafe.jcdate"/>" /></td>
								</tr>
								<tr>
									<td>现场负责人:</td>
									<td align="left"><input type="text" size="50" name="scenesafe.fzporson"
										value="<s:property value="scenesafe.fzporson"/>" /></td>
									    <td></td>
									    <td></td>
								</tr>
								<tr>
									<td>登记人:</td>
									<td align="left"><input type="text" size="50" name="scenesafe.djporson"
										value="<s:property value="scenesafe.djporson"/>" /></td>
									<td>登记时间:</td>
									<td align="left"><input type="text" size="50" name="scenesafe.djdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})"
										value="<s:property value="scenesafe.djdate"/>" /></td>
								</tr>
								  <tr>
								  <td>涉及单位:</td>
                           <td align="left" colspan="3">
                           <!-- <s:if test="0==0"> checked="checked"</s:if> -->
                           	<input id="eee"  type="checkbox" name="scenesafe.companyjc" value="0" />涉及建设单位
                           	<input id='eeee' type="checkbox" name="scenesafe.companykc" value="1" />涉及勘察单位
                           	<input id='eeeeee' type="checkbox" name="scenesafe.companysj" value="2" />涉及设计单位
                           	<input id='eeeee' type="checkbox" name="scenesafe.companysg" value="3" />涉及施工单位
                           	<input id='eeeeeee' type="checkbox" name="scenesafe.companyjl" value="4" />涉及监理单位
                          </td>
                         </tr>  
                         <tr>                          
                         <td>检查内容描述：</td>
                         <td colspan="3" align="left" > <textarea rows=3 cols="90" name="scenesafe.nrdescription" ><s:property value="credibillity.punishevidence"/></textarea></td>                         
                         </tr>
                          <tr>                         
                         <td>检查结论：</td>
                         <td colspan="3" align="left" > <textarea rows=1 cols="90" name="scenesafe.jcconclusion"><s:property value="credibillity.punishevidence"/></textarea></td>                         
                         </tr>
                          <tr>                           
                         <td>处理意见： </td>
                         <td colspan="3" align="left" > <textarea rows=3 cols="90" name="scenesafe.clsuggestion"><s:property value="credibillity.punishevidence"/></textarea></td>                        
                         </tr>
                          <tr>                           
                         <td>处理依据：</td>
                         <td colspan="3" align="left" > <textarea rows=3 cols="90" name="scenesafe.clgist"><s:property value="credibillity.punishevidence"/></textarea></td>                        
                         </tr>                       	
							</table>
						</fieldset>
					</td>
				</tr>
				
			</table>
 				<tr>
              <td colspan="4" align="left"> 
                 <a href="#" onclick="onAddTR(this)" style="float:right;" ><span class="lbchx">添加</span></a>
              </td>
              
              </tr>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					
					<th>检查内容</th>
					<th>问题</th>
					<th>意见</th>
					<th>操作</th>
					
				</tr>
				<tr id="addTr">
						<td><input id='constructorNamezzry[1]' type='text' name='construscenesafe[0].jcneirong' value='<s:property value='construscenesafe[0].jcneirong'/>' /></td>
						<td><input id='constructorNamezzrygw[1]' type='text' name='construscenesafe[0].question' value='<s:property value='construscenesafe[0].question'/>'/></td>
						 <td><input id='constructorNamezzrykh[1]' type='text' name='construscenesafe[0].suggestion' value='<s:property value='construscenesafe[0].suggestion'/>'/></td>	 
						<td></td>
					</tr>			
			</table>
			 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
					<input type="image" src="<%=basepath %>/images/baocun.jpg"  onclick="save()"/>            		
            	</div>
		</form>
	</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
	</div>
</body>
</html>