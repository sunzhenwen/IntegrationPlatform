<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>授权 </title>
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
		document.form1.action="<%=basepath %>/authorizationAction_goList.action";
		document.form1.submit();
	}
	//查询项目
	function queryPrjName()
	{
		var url="<%=basepath %>/queryAuPrjsAction_queryPage.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
	//查询企业
	function queryCorpName()
	{
		var url1="<%=basepath %>/queryAuCorpAction_queryPage.action";
		var newWin1=window.showModalDialog(url1,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin1.open()
	}
</script>

</head>

<body>
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="<%=basepath %>/authorizationAction_add.action">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>授权</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td colspan="2" align="left">
							<input id="prjName" type="text" maxlength='50'  name="authorization.prjName" value="<s:property value="authorization.prjName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<a href="#" onclick="queryPrjName()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							
							<input id="prjId" type="hidden" readonly name="authorization.prjId" value="<s:property value="authorization.prjId"/>" class="required"/>
							<input id="appDeptName" readonly type="hidden" name="authorization.appDeptName" value="<s:property value="authorization.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="authorization.appDept" value="<s:property value="authorization.appDept"/>"/>
							</td>
							<th>项目编号：</th>
							<td colspan="2" align="left">
							<input id="prjNum" type="text" maxlength='50'  name="authorization.prjNum" value="<s:property value="authorization.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>建设单位名称：</th>
							<td colspan="2" align="left">
							<input id="buildCorpName" type="text" readonly  name="authorization.corpName" value="<s:property value="authorization.corpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>建设单位组织机构代码：</th>
							<td colspan="2" align="left">
							<input id="buildCorpCode" type="text" readonly name="authorization.corpCode" value="<s:property value="authorization.corpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>被授权企业名称：</th>
							<td colspan="2" align="left">
							<input id="auCorpName" type="text" readonly  name="authorization.auCorpName" value="<s:property value="authorization.auCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<a href="#" onclick="queryCorpName()"><span style="border-radius:6px; background:#497fe1; padding:4px 14px; color:#fff; font-size:12px;">选择</span></a>
							
							</td>
							<th>被授权企业组织机构代码：</th>
							<td colspan="2" align="left">
							<input id="auCorpCode" type="text" readonly name="authorization.auCorpCode" value="<s:property value="authorization.auCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>企业类型：</th>
							<td colspan="2" align="left">
							<select name="authorization.enterpriseType" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="enterpriseTypes">
	          						<option value="<s:property value="code"/>"><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>&nbsp;</th>
							<td colspan="2">
							&nbsp;
							</td>
                         </tr>
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
