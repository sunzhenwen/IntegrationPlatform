<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>外省企业项目备案</title>
<script type="text/javascript">

	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/otherPrjConstructorAction_projectById.action";
		document.form1.submit();
	}

	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=prjPersonSuccess";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">外省企业项目备案</h2>
			<form style="margin: 10px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable1" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

				<tr>
                         	<td width="17%">姓名：</td>
                            <td width="32%">
							<s:property value="projectPerson.personName"/>
							<input name="otherPrjId" readonly type="hidden" value="<s:property value="projectPerson.otherPrjId"/>" class="ipu1" />
							<input name="projectPerson.personId" readonly type="hidden" value="<s:property value="projectPerson.personId"/>" class="ipu1" />
							</td>
                            <td width="19%">证件号码：</td>
                            <td width="32%">
							<s:property value="projectPerson.cardNum"/>
							</td>
                            
                         </tr>
                         <tr>
                         	<td>类型：</td>
                            <td>
							<s:property value="projectPerson.staffTypeName"/>
							</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                         </tr>

					<tr>
                        <td colspan="4"><font color="red"><strong>外省建筑企业人员附件上传</strong></font></td>
                      </tr>
                      <s:iterator status="i" value="projectPerson.accessoryList">
							<tr>
                       		<td colspan="4" align="left">
                       		<s:property value="#i.count"/>、<s:property value="message"/>
                       		<br />
                       		<font color="#0000CC"><strong>附件下载</strong></font>
                       		<br />
                       		<br />
							<s:iterator status="k" value="list">
								<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a><br />
							</s:iterator>
                       		</td>
							</tr>
					  </s:iterator>
					  <tr>
                        <td colspan="4">&nbsp;</td>
                      </tr>
					  <tr>
                        <td colspan="4"><font color="red"><strong>外省监理企业人员附件上传</strong></font></td>
                      </tr>
                      <s:iterator status="i" value="projectPerson.accessoryLists">
							<tr>
                       		<td colspan="4" align="left">
                       		<s:property value="#i.count"/>、<s:property value="message"/>
                       		<br />
                       		<font color="#0000CC"><strong>附件下载</strong></font>
                       		<br />
                       		<br />
							<s:iterator status="k" value="list">
								<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a><br />
							</s:iterator>
                       		</td>
							</tr>
					  </s:iterator>		
                </table>
				
				<div class="sp_bton">
					<a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
				</div>
			</form>
		</div>
	</div>
	
	
</body>
</html>