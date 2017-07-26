<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>竣工验收共享查询</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/readyShareAction_goBack.action";
		document.form1.submit();
	}
	//下载
	function downLoad(uploadId)
	{
		document.form1.action="<%=basepath %>/fileUpload_downLoadFile.action?id="+uploadId;
		document.form1.submit();
	}
	
	//查询单位工程信息
	function querySingleProject(){
		var prjNum = $("#prjNum").val();
		var prjId = $("#prjId").val();
		var url = "<%=basepath %>/innerSingleProjectAction_queryPage.action?prjNum="+prjNum+"&prjId="+prjId+"&condition.prjId="+prjId+"&condition.linkName=6&linkName=6";
		var newWin=window.showModalDialog(url,window,'dialogHeight:900px;dialogWidth:1300px;dialogLeft:100px;dialogTop:100px;');
		newWin.open();
	}
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">竣工验收共享查询</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>工程名称：</td>
						<td colspan="3" align="center" valign="middle"><div align="center"><s:property value="complete.projectName" /></div></td>
					</tr>

					<tr>
						<td>项目名称：</td>
						<td><s:property value="complete.prjName" /> <input
							type="hidden" id="prjNum" name="complete.prjNum"
							value="<s:property value="complete.prjNum"/>"> <input
							type="hidden" id="completeId" name="complete.completeId"
							value="<s:property value="complete.completeId"/>"><input
							type="hidden" name="complete.createDate"
							value="<s:property value="complete.createDate"/>"> <input
							type="hidden" name="complete.appDept"
							value="<s:property value="complete.appDept"/>">
							<input id="prjId" type="hidden" readonly name="complete.prjId" value="<s:property value="complete.prjId"/>" class="required"/>
							</td>
						<td>项目编号：</td>
						<td><s:property value="complete.prjNum" /></td>
					</tr>

					<tr>
						<td>竣工备案编号：</td>
						<td><s:property value="complete.prjFinishNum" /></td>
						<td>施工许可证编号：</td>
						<td><s:property value="complete.builderLicenceNum" /></td>
					</tr>
					<tr>
						<td>质量检测机构名称：</td>
						<td><s:property value="complete.qcCorpName" /></td>
						<td>质量检测机构组织机构代码：</td>
						<td><s:property value="complete.qcCorpCode" /></td>
					</tr>
					<tr>
						<td>实际造价(万元)：</td>
						<td><s:property value="complete.factCost" /></td>
						<td>实际面积(平方米)：</td>
						<td><s:property value="complete.factArea" /></td>
					</tr>
					<tr>
						<td>实际建设规模：</td>
						<td><s:property value="complete.factSize" /></td>
						<td>结构体系：</td>
						<td><s:if test="complete.prjStructureTypeNum==1">砖混结构</s:if>
							<s:if test="complete.prjStructureTypeNum==2">底框结构</s:if> <s:if
								test="complete.prjStructureTypeNum==3">框架结构</s:if> <s:if
								test="complete.prjStructureTypeNum==4">框架－剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==5">剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==6">板柱-剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==7">短肢墙剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==8">部分框支剪力墙结构</s:if> <s:if
								test="complete.prjStructureTypeNum==9">框-筒体结构</s:if> <s:if
								test="complete.prjStructureTypeNum==10">筒中筒结构</s:if> <s:if
								test="complete.prjStructureTypeNum==11">异型柱框架结构</s:if> <s:if
								test="complete.prjStructureTypeNum==12">复杂高层结构</s:if> <s:if
								test="complete.prjStructureTypeNum==13">混合结构</s:if> <s:if
								test="complete.prjStructureTypeNum==14">钢结构</s:if> <s:if
								test="complete.prjStructureTypeNum==15">排架结构</s:if> <s:if
								test="complete.prjStructureTypeNum==99">其他</s:if></td>
					</tr>
					<tr>
						<td>实际开工日期：</td>
						<td><s:date name="complete.BDate" format="yyyy-MM-dd" /></td>
						<td>实际竣工验收日期：</td>
						<td><s:date name="complete.EDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>记录登记日期：</td>
						<td><s:date name="complete.createDate" format="yyyy-MM-dd" /></td>
						<td>&nbsp;&nbsp;</td>
						<td>&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4" align="left"><center><strong>
						<a href="#" onclick="querySingleProject()">
						单体工程(点击查看)
						</a></strong></center>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					 </tr>
					<tr>
                      	<td>附件：</td>
						<td align="left" colspan="3">
						<s:iterator status="i" value="complete.list">
						<a href="#" onclick="downLoad('<s:property value="uploadId"/>')"><s:property value="fileFileName"/></a>&nbsp;<br />
						</s:iterator>
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