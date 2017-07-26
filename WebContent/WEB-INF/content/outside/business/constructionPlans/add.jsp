<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/outside/outtop.jsp"%>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>施工图审查申请</title>
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
		document.form1.action="<%=basepath%>/constructionPlansAction_goList.action";
		document.form1.submit();
	}

	//查询项目
	function queryPrjName()
	{
		var url="<%=basepath%>/queryPrjsAction_queryPage.action";
		var newWin = window.showModalDialog(url, window,'dialogHeight:800px;dialogWidth:1200px;dialogLeft:100px;dialogTop:100px;');
		newWin.open()
	}
</script>

</head>

<body>
	<input type="hidden" id="message"
		value="<s:property value="message" />" />
	<div class="ry_wrapp">

		<form id="form1" name="form1" method="post"
			action="<%=basepath%>/constructionPlansAction_add.action">

			<div class="ry_content">

				<div class="ry_lbxx">
					<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
						<h2>施工图审查申请</h2>
						<table class="" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<th>项目名称：</th>
									<td align="left"><input id="prjName" type="text" readonly
										name="constructionPlans.prjName"
										value="<s:property value="constructionPlans.prjName"/>"
										class="required" /><strong><font color="#FF0000">*</font></strong><a href="#" onclick="queryPrjName()"><font color="#FF0000">选择</font></a>
										<input id="prjId" type="hidden" readonly
										name="constructionPlans.prjId"
										value="<s:property value="constructionPlans.prjId"/>"
										class="required" /></td>
									<th>项目编号：</th>
									<td align="left"><input id="prjNum" type="text" readonly
										name="constructionPlans.prjNum"
										value="<s:property value="constructionPlans.prjNum"/>"
										class="required" /><strong><font color="#FF0000">*</font></strong>
									</td>
								</tr>
								<tr>
									<th>申请企业名称：</th>
									<td align="left"><input type="text"
										name="constructionPlans.applyCorpName"
										value="<s:property value="corpName"/>" class="required" /><strong><font color="#FF0000">*</font></strong></td>
									<th>申请企业代码：</th>
									<td align="left"><input id="corpCode" type="text"
										name="constructionPlans.applyCorpCode"
										value="<s:property value="corpCode"/>" class="required" /><strong><font
											color="#FF0000">*</font></strong></td>
								</tr>
								<tr>
									<th>施工图审查机构名称：</th>
									<td align="left"><input type="text"
										name="constructionPlans.censorCorpName"
										value="<s:property value="constructionPlans.censorCorpName"/>"
										class="required" /><strong><font color="#FF0000">*</font></strong>
									</td>
									<th>施工图审查机构组织机构代码：</th>
									<td align="left"><input type="text"
										name="constructionPlans.censorCorpCode"
										value="<s:property value="constructionPlans.censorCorpCode"/>"
										class="required" /><strong><font color="#FF0000">*</font></strong>
									</td>
								</tr>
								<tr>
									<th>审查完成日期：</th>
									<td align="left"><input id="time1" type="text"
										name="constructionPlans.censorEDate"
										value="<s:date name="constructionPlans.censorEDate" format="yyyy-MM-dd" />"
										onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})"
										class="required" /><strong><font color="#FF0000">*</font></strong>
									</td>
									<th>建设规模：</th>
									<td align="left">
									
									<textarea name="constructionPlans.prjSize" id="textarea" cols="35" rows="6"><s:property value="constructionPlans.prjSize"/></textarea>
									</td>

								</tr>
								<tr>
									<th>勘察单位名称：</th>
									<td align="left"><input type="text"
										name="constructionPlans.econCorpName"
										value="<s:property value="constructionPlans.econCorpName"/>" />
									</td>
									<th>勘察单位组织机构代码：</th>
									<td align="left"><input type="text"
										name="constructionPlans.econCorpCode"
										value="<s:property value="constructionPlans.econCorpCode"/>" />
									</td>

								</tr>
								<tr>
									<th>勘察单位名称2：</th>
									<td align="left"><input type="text"
										name="constructionPlans.econCorpName2"
										value="<s:property value="constructionPlans.econCorpName2"/>" />
									</td>
									<th>勘察单位组织机构代码2：</th>
									<td align="left"><input type="text"
										name="constructionPlans.econCorpCode2"
										value="<s:property value="constructionPlans.econCorpCode2"/>" />
									</td>

								</tr>
								<tr>
									<th>勘察单位名称3：</th>
									<td align="left"><input type="text"
										name="constructionPlans.econCorpName3"
										value="<s:property value="constructionPlans.econCorpName3"/>" />
									</td>
									<th>勘察单位组织机构代码3：</th>
									<td align="left"><input type="text"
										name="constructionPlans.econCorpCode3"
										value="<s:property value="constructionPlans.econCorpCode3"/>" />
									</td>

								</tr>
								<tr>
									<th>设计单位名称：</th>
									<td align="left"><input type="text"
										name="constructionPlans.designCorpName"
										value="<s:property value="constructionPlans.designCorpName"/>"
										class="required" /><strong><font color="#FF0000">*</font></strong>
									</td>
									<th>设计单位组织机构代码：</th>
									<td align="left"><input type="text"
										name="constructionPlans.designCorpCode"
										value="<s:property value="constructionPlans.designCorpCode"/>"
										class="required" /><strong><font color="#FF0000">*</font></strong>
									</td>

								</tr>
								<tr>
									<th>设计单位名称2：</th>
									<td align="left"><input type="text"
										name="constructionPlans.designCorpName2"
										value="<s:property value="constructionPlans.designCorpName2"/>" />
									</td>
									<th>设计单位组织机构代码2：</th>
									<td align="left"><input type="text"
										name="constructionPlans.designCorpCode2"
										value="<s:property value="constructionPlans.designCorpCode2"/>" />
									</td>

								</tr>
								<tr>
									<th>设计单位名称3：</th>
									<td align="left"><input type="text"
										name="constructionPlans.designCorpName3"
										value="<s:property value="constructionPlans.designCorpName3"/>" />
									</td>
									<th>设计单位组织机构代码3：</th>
									<td align="left"><input type="text"
										name="constructionPlans.designCorpCode3"
										value="<s:property value="constructionPlans.designCorpCode3"/>" />
										<input id="appDeptName" readonly type="hidden"
										name="constructionPlans.appDeptName"
										value="<s:property value="constructionPlans.appDeptName"/>"
										class="required" /> <input id="appDept" type="hidden"
										name="constructionPlans.appDept"
										value="<s:property value="constructionPlans.appDept"/>" /></td>

								</tr>



							</tbody>
						</table>
						<div class="botn">
							<input type="image" src="<%=basepath%>/images/quxiao.jpg"
								onclick="goBack()" /> <input type="image"
								src="<%=basepath%>/images/shangbao.jpg" />
						</div>

					</div>
				</div>

			</div>
		</form>
	</div>
</body>
</html>
