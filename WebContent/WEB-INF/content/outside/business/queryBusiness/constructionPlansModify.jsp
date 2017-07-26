<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp" %> 
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>施工图审查申请 </title>
<script type="text/javascript">

	
	//取消
	function goBack()
	{
		document.form1.action="<%=basepath %>/queryConstructionPlansAction_goList.action";
		document.form1.submit();
	}
	
</script>

</head>

<body>
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="ry_wrapp">
	
	<form id="form1" name="form1" method="post" action="<%=basepath %>/constructionPlansAction_modify.action">
      
        <div class="ry_content">
        
            <div class="ry_lbxx">
            	<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
              	<h2>施工图审查申请</h2>
                <table class="" cellpadding="0" cellspacing="0">
                	<tbody>   
                         <tr>
                         	<th>项目名称：</th>
							<td align="left">
							<input id="prjName" type="text" readonly name="constructionPlans.prjName" value="<s:property value="constructionPlans.prjName"/>" class="required"/>
							<input id="prjId" type="hidden" readonly name="constructionPlans.prjId" value="<s:property value="constructionPlans.prjId"/>" class="required"/>
							<input type="hidden" readonly name="constructionPlans.censorId" value="<s:property value="constructionPlans.censorId"/>" class="required"/>
							</td>
							<th>项目编号：</th>
							<td align="left">
							<input id="prjNum" type="text" readonly name="constructionPlans.prjNum" value="<s:property value="constructionPlans.prjNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <!-- 
                         <tr>
                         	<th>申请企业名称：</th>
							<td align="left">
							<input type="text" readonly name="constructionPlans.applyCorpName" value="<s:property value="constructionPlans.applyCorpName"/>" class="required"/>
							</td>
							<th>申请企业代码：</th>
							<td align="left">
							<input type="text" readonly name="constructionPlans.applyCorpCode" value="<s:property value="constructionPlans.applyCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                          -->
                         <tr>
                         	<th>施工图审查机构名称：</th>
							<td align="left">
							<input type="text" name="constructionPlans.censorCorpName" value="<s:property value="constructionPlans.censorCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>施工图审查机构组织机构代码：</th>
							<td align="left">
							<input type="text" name="constructionPlans.censorCorpCode" value="<s:property value="constructionPlans.censorCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         </tr>
                         <tr>
							<th>施工图审查合格证书编号：</th>
							<td align="left">
								<input type="text" readonly name="constructionPlans.censorNum" value="<s:property value="constructionPlans.censorNum"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>审查完成日期：</th>
							<td align="left">
							<input id="time1" type="text" name="constructionPlans.censorEDate" value="<s:date name="constructionPlans.censorEDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong>
							</td>
						</tr>
                         
						<tr>
							<th>勘察单位名称：</th>
							<td align="left">
							<input type="text" name="constructionPlans.econCorpName" value="<s:property value="constructionPlans.econCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>勘察单位组织机构代码：</th>
							<td align="left">
							<input type="text" name="constructionPlans.econCorpCode" value="<s:property value="constructionPlans.econCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	
						</tr>
						<tr>
							<th>勘察单位名称2：</th>
							<td align="left">
							<input type="text" name="constructionPlans.econCorpName2" value="<s:property value="constructionPlans.econCorpName2"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>勘察单位组织机构代码2：</th>
							<td align="left">
							<input type="text" name="constructionPlans.econCorpCode2" value="<s:property value="constructionPlans.econCorpCode2"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	
						</tr>
                        <tr>
                        	<th>勘察单位名称3：</th>
							<td align="left">
							<input type="text" name="constructionPlans.econCorpName3" value="<s:property value="constructionPlans.econCorpName3"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>勘察单位组织机构代码3：</th>
							<td align="left">
							<input type="text" name="constructionPlans.econCorpCode3" value="<s:property value="constructionPlans.econCorpCode3"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	
						</tr>
                        <tr>
                        	<th>设计单位名称：</th>
							<td align="left">
							<input type="text" name="constructionPlans.designCorpName" value="<s:property value="constructionPlans.designCorpName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>设计单位组织机构代码：</th>
							<td align="left">
							<input type="text" name="constructionPlans.designCorpCode" value="<s:property value="constructionPlans.designCorpCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	
						</tr>
						<tr>
							<th>设计单位名称2：</th>
							<td align="left">
							<input type="text" name="constructionPlans.designCorpName2" value="<s:property value="constructionPlans.designCorpName2"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>设计单位组织机构代码2：</th>
							<td align="left">
							<input type="text" name="constructionPlans.designCorpCode2" value="<s:property value="constructionPlans.designCorpCode2"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	
						</tr>
						<tr>
							<th>设计单位名称3：</th>
							<td align="left">
							<input type="text" name="constructionPlans.designCorpName3" value="<s:property value="constructionPlans.designCorpName3"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>设计单位组织机构代码3：</th>
							<td align="left">
							<input type="text" name="constructionPlans.designCorpCode3" value="<s:property value="constructionPlans.designCorpCode3"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	
						</tr>
						<tr>
							<th>一次审查是否通过：</th>
							<td align="left">
							<select name="constructionPlans.oneCensorIsPass" class="required">
     							<option value="">请选择</option>
     							<s:if test="constructionPlans.oneCensorIsPass==1">
     							<option value="1" selected>通过</option>
	      						<option value="0">未通过</option>
     							</s:if>
     							<s:else>
     							<option value="1">通过</option>
	      						<option value="0" selected>未通过</option>
     							</s:else>
	      					</select><strong><font color="#FF0000">*</font></strong>
							</td>
							<th>一次审查时违反强条数：</th>
							<td align="left">
							<input type="text" name="constructionPlans.oneCensorWfqtCount" value="<s:property value="constructionPlans.oneCensorWfqtCount"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							</td>
                         	
						</tr>
						<tr>
							<th>一次审查时违反强条条目：</th>
							<td align="left">
							<input type="text" name="constructionPlans.oneCensorWfqtContent" value="<s:property value="constructionPlans.oneCensorWfqtContent"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
							<input id="appDeptName" readonly type="hidden" name="constructionPlans.appDeptName" value="<s:property value="constructionPlans.appDeptName"/>" class="required"/>
							<input id="appDeptId" type="hidden" name="constructionPlans.appDept" value="<s:property value="constructionPlans.appDept"/>"/>
							</td>
							<th>&nbsp;</th>
							<td>
							&nbsp;
							</td>
                         	
						</tr>
						<tr>
                       		<th>建设规模：</th>
							<td colspan="3" align="left">
							<textarea name="constructionPlans.prjSize" cols="100" rows="5"><s:property value="constructionPlans.prjSize"/></textarea>
							</td>
						</tr>
						<tr>
                       		<th>附件：</th>
							<td align="left" colspan="3">
							<s:iterator status="i" value="constructionPlans.list">
							<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a><br />
							</s:iterator>
							</td>
						</tr>
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
