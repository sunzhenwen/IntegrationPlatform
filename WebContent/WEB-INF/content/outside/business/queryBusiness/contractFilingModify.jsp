<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业合同备案申请 </title>
<script type="text/javascript">

	//查询合同
	function fileWorld(conId)
	{
		window.open('<%=basepath %>/queryContractFilingAction_fileWorld.action?conId='+conId);  
	}
	
	//查询合同
	function currencyFileWorld(inCommon,conType)
	{
		window.open('<%=basepath %>/queryContractFilingAction_currencyFileWorld.action?inCommon='+inCommon+'&conType='+conType+''); 
	}
	
	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/queryContractFilingAction_goList.action";
		document.form1.submit();
	}
	
</script>

</head>

<body>
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">

	<form id="form1" name="form1" method="post" action="<%=basepath %>/contractFilingAction_modify.action">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>企业合同备案</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td align="left">
							<input id="prjName" type="text" readonly name="contractFiling.prjName" value="<s:property value="contractFiling.prjName"/>" class="required"/>
							<input id="prjId" type="hidden" readonly name="contractFiling.prjId" value="<s:property value="contractFiling.prjId"/>" class="required"/>
							<input type="hidden" readonly name="contractFiling.recordId" value="<s:property value="contractFiling.recordId"/>" class="required"/>
							</td>
							<th>项目编号：</th>
							<td align="left">
							<input id="prjNum" type="text" readonly name="contractFiling.prjNum" value="<s:property value="contractFiling.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>申请企业名称：</th>
							<td align="left"> 
							<input type="text" readonly name="contractFiling.applyCorpName" value="<s:property value="contractFiling.applyCorpName"/>" class="required"/>
							</td>
							<th>申请企业代码：</th>
							<td align="left">
							<input type="text" readonly name="contractFiling.applyCorpCode" value="<s:property value="contractFiling.applyCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
                         	<th>合同备案编号：</th>
							<td align="left">
							<input type="text" readonly name="contractFiling.recordNum" value="<s:property value="contractFiling.recordNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	<th>合同编号：</th>
							<td align="left">
							<input type="text" name="contractFiling.contractNum" value="<s:property value="contractFiling.contractNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
							
                         </tr>
                         <tr>
                         	<th>合同类别：</th>
							<td align="left">
							<select name="contractFiling.contractTypeNum" class="required">
     							<option value="">请选择</option>
	      						<s:iterator value="contractTypeNums">
	          						<option value="<s:property value="code"/>"<s:if test='contractFiling.contractTypeNum==code'>selected</s:if>><s:property value="name"/></option>
	      						</s:iterator>
							</select><strong><font color="#FF0000">*</font></strong>
							</td>
                         	<th>合同金额(万元)：</th>
							<td align="left">
							<input type="text" name="contractFiling.contractMoney" value="<s:property value="contractFiling.contractMoney"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
							
						</tr>
						<tr>
							
                         	<th>合同签订日期：</th>
							<td align="left"> 
							<input id="time1" type="text" name="contractFiling.contractDate" value="<s:date name="contractFiling.contractDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>发包单位名称：</th>
							<td align="left">
							<input type="text" name="contractFiling.propietorCorpName" value="<s:property value="contractFiling.propietorCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
						<tr>
							
                         	<th>发包单位组织机构代码：</th>
							<td align="left">
							<input type="text" name="contractFiling.propietorCorpCode" value="<s:property value="contractFiling.propietorCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
							<th>承包单位名称：</th>
							<td align="left">
							<input type="text" name="contractFiling.contractorCorpName" value="<s:property value="contractFiling.contractorCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                        <tr>
                        	
                         	<th>承包单位组织机构代码：</th>
							<td align="left">
							<input type="text" name="contractFiling.contractorCorpCode" value="<s:property value="contractFiling.contractorCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>联合体承包单位名称：</th>
							<td align="left">
							<input type="text" name="contractFiling.unionCorpName" value="<s:property value="contractFiling.unionCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							
						</tr>
                        <tr>
                        	
                         	<th>联合体承包单位组织代码：</th>
							<td align="left">
							<input type="text" name="contractFiling.unionCorpCode" value="<s:property value="contractFiling.unionCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="appDeptName" readonly type="hidden" name="contractFiling.appDeptName" value="<s:property value="contractFiling.appDeptName"/>" class="required"/>
							<input id="appDept" type="hidden" name="contractFiling.appDept" value="<s:property value="contractFiling.appDept"/>"/>
							</td>
							<th>&nbsp;</th>
							<td>&nbsp;</td>
						</tr>
						<tr>
                       		<th>建设规模：</th>
							<td colspan="4" align="left">
							<textarea name="contractFiling.prjSize" id="textarea" cols="100" rows="5"><s:property value="contractFiling.prjSize"/></textarea>
							</td>
						</tr>
						<tr>
                       		<th>附件：</th>
							<td align="left" colspan="3">
							<s:iterator status="i" value="contractFiling.list">
							<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a><br />
							</s:iterator>
							</td>
						</tr>
						
							<s:if test="contractFiling.contractTypeNum==301||contractFiling.contractTypeNum==302||contractFiling.contractTypeNum==303">
							<tr>
                       		<th>合同打印：</th>
							<td align="left" colspan="3">
							<s:iterator status="i" value="worldList">
							<s:if test="inCommon==0">
							<s:property value="#i.count"/>、<a href="#" onclick="currencyFileWorld('<s:property value="inCommon"/>','<s:property value="conType"/>')"><s:property value="zhConName"/>(打印)</a><br />
							</s:if>
							<s:else>
							<s:property value="#i.count"/>、<a href="#" onclick="fileWorld('<s:property value="conId"/>')"><s:property value="zhConName"/>(打印)</a><br />
							</s:else>
							</s:iterator>
							<!-- 
							<a href="#" onclick="fileWorld('<s:property value="contractFiling.recordId"/>')">合同打印</a><br />
							 -->
							</td>
							</tr>
							</s:if>
						
				</tbody>  
                </table>
                 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" />
		        </div>
                
                </div> 
            </div>
                 
         </div>
    	</form>
    </div>
</body>
</html>
