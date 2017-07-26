<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>现场质量安全监督审查明细</title>
<script type="text/javascript">
//下载
function downLoad(uploadId)
{
	document.form1.action="<%=basepath%>/fileUpload_downLoadFile.action?id="+ uploadId + "&returnRoot=scenesafe";
	document.form1.submit();
}
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/promiseApplyAction_queryPage.action";
		document.form1.submit();
	}
	//查询
	function goBack()
	{
		document.form1.action="<%=basepath%>/querscenesafeAction_querypage.action";
		document.form1.submit();
	}
	//查询项目
	function queryPrjName()
	{
		
		var url="<%=basepath %>/scenesafeAction_queryPagee.action";
		var newWin=window.showModalDialog(url,window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
</script>
</head>
<body>
	<div class="libiao">
		<form id="form1" name="form1" method="post" action="<%=basepath %>/scenesafeAction_addpage.action">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">现场质量安全监督审查</legend>
							<p style="margin-bottom: 10px; text-align: right;">
							 
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">

								<tr>
									<td>项目编号:</td>
									<td> <s:property value="scenesafe.prjnumm"/> 
										 </td>
									<td>施工许可证号:</td>
									<td> <s:property value="scenesafe.prjnumm"/> 
									</td>
								</tr>
								<tr>
									<td >项目名称:</td>
									<td colspan="3" align="left" >  <s:property value="scenesafe.prjnamee"/> 
									</td>														
								</tr>
								<tr>
									<td>检查人:</td>
									<td> <s:property value="scenesafe.jcporson"/> 
									</td>
									<td>检查时间:</td>
									<td> <s:property value="scenesafe.jcdate"/> 
									</td>
								</tr>
								<tr>
									<td>现场负责人:</td>
									<td> <s:property value="scenesafe.fzporson"/> 
									</td>
									    <td></td>
									    <td></td>
								</tr>
								<tr>
									<td>登记人:</td>
									<td> <s:property value="scenesafe.djporson"/> 
									</td>
									<td>登记时间:</td>
									<td> <s:property value="scenesafe.djdate"/> 
									</td>
								</tr>
								  <tr>
								  <td>涉及单位:</td>
                           <td align="left" colspan="3">
                            <s:if test='scenesafe.companyjc == "0"'>
                           <input type="checkbox" name="scenesafe.companyjc" value="0" checked  />
           					 涉及建设单位
                           </s:if>
                           <s:else>
                           <input type="checkbox" name="scenesafe.companyjc" value="0"  />
           					涉及建设单位
                           </s:else>
                           
                            <s:if test='scenesafe.companykc == "1"'>
                           <input type="checkbox" name="scenesafe.companykc" value="1" checked  />
           					涉及勘察单位
                           </s:if>
                           <s:else>
                           <input type="checkbox" name="scenesafe.companykc" value="1"  />
           					 涉及勘察单位
                           </s:else>
                           
                            <s:if test='scenesafe.companysj == "2"'>
                           <input type="checkbox" name="scenesafe.companysj" value="2" checked  />
           					涉及设计单位
                           </s:if>
                           <s:else>
                           <input type="checkbox" name="scenesafe.companysj" value="2"  />
           					涉及设计单位
                           </s:else>
                           
                            <s:if test='scenesafe.companysg == "3"'>
                           <input type="checkbox" name="scenesafe.companysg" value="3" checked  />
           					涉及施工单位
                           </s:if>
                           <s:else>
                           <input type="checkbox" name="scenesafe.companysg" value="3"  />
           					 涉及施工单位
                           </s:else>
                           
                            <s:if test='scenesafe.companyjl == "4"'>
                           <input type="checkbox" name="scenesafe.companyjl" value="0" checked  />
           					 涉及监理单位
                           </s:if>
                           <s:else>
                           <input type="checkbox" name="scenesafe.companyjl" value="0"  />
           					 涉及监理单位
                           </s:else>
                          
                          </td>
                         </tr>  
                         <tr>
                           
                         <td>检查内容描述：</td>
                         <td colspan="3" align="left" >  <s:property value="scenesafe.nrdescription"/> </td>
                         
                         </tr>
                          <tr>
                           
                         <td>检查结论：</td>
                         <td colspan="3" align="left" >  <s:property value="scenesafe.jcconclusion"/> </td>
                         
                         </tr>
                          <tr>
                           
                         <td>处理意见：</td>
                         <td colspan="3" align="left" >  <s:property value="scenesafe.clsuggestion"/> </td>
                         
                         </tr>
                          <tr>
                           
                         <td>处理依据：</td>
                         <td colspan="3" align="left" >  <s:property value="scenesafe.clgist"/> </td>
                         
                         </tr>
                         <tr>
									<td>附件：</td>
									<td align="left" colspan="3"><s:iterator status="i"
											value="scenesafe.list">
											<a href="#"
												onclick="downLoad('<s:property value="uploadId"/>')"><s:property
													value="fileFileName" />
											<br />
										</s:iterator></td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
				
			</table>
 				<tr>
              <td colspan="4" align="left" >现场质量安全明细表
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               
              </td>
              
              </tr>
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				onmouseover="changeto()" onmouseout="changeback()">
				<tr>
					<th>序号</th>
					<th>检查内容</th>
					<th>问题</th>
					<th>意见</th>
				</tr>
				 				<s:iterator status="t" value="scenesafe.construscenesafe" > 
                             <tr>          
                             <td><s:property value="#t.count"/> </td>            
                               <td> <s:property value="jcneirong"/> </td>
                               <td> <s:property value="question"/> </td>
                               <td> <s:property value="suggestion"/> </td>                               
                             </tr>
                              </s:iterator>  
			</table>
			 <div class="botn"> 
		        	<input type="image" src="<%=basepath %>/images/quxiao.jpg" onclick="goBack()" /> </div>
		</form>
	</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
	</div>
</body>
</html>