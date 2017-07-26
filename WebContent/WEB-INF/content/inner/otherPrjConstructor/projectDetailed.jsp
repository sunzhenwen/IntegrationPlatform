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
		document.form1.action="<%=basepath %>/otherPrjConstructorAction_queryPage.action";
		document.form1.submit();
	}


	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=OtherProjectSuccess";
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
                        <td width="17%"><label>项目名称：</label></td>
                        <td width="32%">
						<s:property value="construction.prjName"/>
						</td>
                        <td width="19%"><label>项目编号：</label></td>
                        <td width="32%">
						<s:property value="construction.prjNum"/>
						</td>
                      </tr>
                      <tr>
                        <td><label>企业名称：</label></td>
                        <td>
						<s:property value="construction.corpName"/>
                        </td>
                        <td><label>组织机构代码：</label></td>
                        <td>
						<s:property value="construction.corpCode"/>
                        </td>
                      </tr>

					<tr>
                        <td align="left" colspan="4"><font color="red"><strong>建筑企业外省附件上传</strong></font></td>
                      </tr>
                      <s:iterator status="i" value="construction.accessoryList">
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
                        <td colspan="4"><font color="red"><strong>监理企业外省附件上传</strong></font></td>
                      </tr>
                      <s:iterator status="i" value="construction.accessoryLists">
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
                      
                      <tr align="center">
                        <td colspan="4">
                        <div class="ry_liebiao">
						<table width="100%" cellpadding="0" cellspacing="0">
						<tbody>
						<tr>
                        <td colspan="5"><font color="red"><strong>项目人员</strong></font></td>
                      </tr>
						<tr>
							<td width="20%">
								序号
							</td>
						  	<td width="20%">
								姓名
							</td>
							<td width="20%">
								身份证号
							</td>
							<td width="20%">
								角色
							</td>
							<td width="20%">
								详细
							</td>
	                	</tr>
	                	
	                	
	                	<s:iterator status="i" value="construction.staffList">
							<tr>
							<td>
								<s:property value="#i.count"/>
							</td>
						  	<td>
								<s:property value="personName"/>
							</td>
							<td>
								<s:property value="cardNum"/>
							</td>
							<td>
								<s:property value="staffTypeName"/>
							</td>
							<td>
			<a href="otherPrjConstructorAction_personDetailed.action?personId=<s:property value="personId"/>"><span>查看</span></a>
							</td>
	                	</tr>
					  </s:iterator>
	                	
	                	</tbody>
						</table>
						</div>
						</td>
                    </tr>				
                </table>
				
				<div class="sp_bton">
					<a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
				</div>
			</form>
		</div>
	</div>
	
	
</body>
</html>