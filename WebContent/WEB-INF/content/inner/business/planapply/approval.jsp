<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上报施工图审查审核</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
//附件下载
function downLoad(uploadId)
{
	document.form1.action="<%=basepath%>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=constructionPlansSuccess";
	document.form1.submit();
}
	
	//审核通过
	function applythrough()
	{
		var nm = document.getElementById("appId");
		if(nm.value != "")
		{
			document.form1.action="<%=basepath%>/planApplyAction_approvalSuccess.action";
			document.form1.submit();
		}else
		{
			alert("请输入审核意见!");	
		}
		//prn_preview();
	
	}
	//申请退回
	function applyBack()
	{
		var nmv = document.getElementById("appId");
		var nmv2 = document.getElementById("ch2");
		var nmv3 = document.getElementById("ch3");
			if(nmv2.value != ""){
				if(nmv3.value != ""){
					if(nmv.value != "")
					{
						document.form1.action="<%=basepath%>/planApplyAction_approvalFailed.action";
						document.form1.submit();
					}else
					{
						alert("请输入审核意见!");	
					}
				}else{
					alert("一次审查时违反强条条目!");	
				}
			}else{
				alert("一次审查时违反强条数!");	
			}
	
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/planApplyAction_goBack.action";
		document.form1.submit();
	}

	var LODOP; //声明为全局变量 
	function prn_preview() {
		CreatePrintPageAB();
		//	LODOP.SET_PRINT_PAGESIZE(0,"210mm","297mm","");
		//	LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
		//LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口

		LODOP.PREVIEW();
	};

	function CreatePrintPageAB() {
		LODOP = getLodop();
		LODOP.PRINT_INIT("上报施工图审查审核");
		var strHTML = "<body style='margin:0;background-color: white'>"
				+ document.getElementById("table03").innerHTML + "</body>";
		//LODOP.ADD_PRINT_HTM("10mm","10mm","RightMargin:15mm","BottomMargin:15mm",strHTML);
		LODOP.ADD_PRINT_HTM("5mm", 34, "RightMargin:0.9cm", "BottomMargin:9mm",
				strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
	};
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">施工图审核</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>施工图审查合格证书编号：</td>
						<td><s:property value="plan.censorNum" /> <input
							type="hidden" name="plan.censorId"
							value="<s:property value="plan.censorId"/>"><input
							type="hidden" name="plan.createDate"
							value="<s:property value="plan.createDate"/>"> <input
							type="hidden" name="plan.appDept"
							value="<s:property value="plan.appDept"/>"></td>
						<td>项目编号：</td>
						<td><s:property value="plan.prjNum" /></td>
					</tr>

					<tr>
						<td>项目名称：</td>
						<td colspan="3"><center><s:property value="plan.prjName" /> <input type="hidden"
							name="plan.prjNum" value="<s:property value="plan.prjNum"/>"></center></td>
						
					</tr>
					<tr style="height: 100px; border: 0">
						<td>建设规模：</td>
						<td colspan="3"><center><s:property value="plan.prjSize" /></center></td>
					</tr>
					<tr>
						<td>施工图审查机构组织机构代码：</td>
						<td><s:property value="plan.censorCorpCode" /></td>
						<td>审查完成日期：</td>
						<td><s:date name="plan.censorEDate" format="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>施工图审查机构名称：</td>
						<td><s:property value="plan.censorCorpName" /></td>
						<td>勘察单位名称：</td>
						<td><s:property value="plan.econCorpName" /></td>
					</tr>
					<tr>
						<td>勘察单位组织机构代码：</td>
						<td><s:property value="plan.econCorpCode" /></td>
						<td>勘察单位名称2：</td>
						<td><s:property value="plan.econCorpName2" /></td>
					</tr>
					<tr>
						<td>勘察单位组织机构代码2：</td>
						<td><s:property value="plan.econCorpCode2" /></td>
						<td>勘察单位名称3：</td>
						<td><s:property value="plan.econCorpName3" /></td>
					</tr>
					<tr>
						<td>勘察单位组织机构代码3：</td>
						<td><s:property value="plan.econCorpCode3" /></td>
						<td>设计单位名称：</td>
						<td><s:property value="plan.designCorpName" /></td>
					</tr>
					<tr>
						<td>设计单位组织机构代码：</td>
						<td><s:property value="plan.designCorpCode" /></td>
						<td>设计单位名称2：</td>
						<td><s:property value="plan.designCorpName2" /></td>
					</tr>
					<tr>
						<td>设计单位组织机构代码2：</td>
						<td><s:property value="plan.designCorpCode2" /></td>
						<td>设计单位名称3：</td>
						<td><s:property value="plan.designCorpName3" /></td>
					</tr>
					<tr>
						<td>设计单位组织机构代码3：</td>
						<td><s:property value="plan.designCorpCode3" /></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>一次审查时违反强条数：</td>
						<td><input type="text" id="ch2" class="required"
							name="plan.oneCensorWfqtCount" />(通过不用填写)</td>
						<td>一次审查时违反的强条条目：</td>
						<td><input type="text" id="ch3" class="required"
							name="plan.oneCensorWfqtContent" />(通过不用填写)</td>
					</tr>
					<tr>
						<td>申请企业组织机构代码：</td>
						<td><s:property value="plan.applyCorpCode" /></td>
						<td>申请企业名称：</td>
						<td><s:property value="plan.applyCorpName" /></td>
					</tr>
					<tr style="height: 60px; border: 0">
						<td>审核意见：</td>
						<td colspan="3"><textarea id="appId" name="plan.appOpinion"
								class="required"></textarea></td>
					</tr>
				</table>
				<h2>附件</h2>
				<s:iterator value="downloadlist" status="i">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><a href="#"
							onclick="downLoad('<s:property value="uploadId"/>')"><s:property
									value="fileFileName" /></a></td>
					</tr>
				</s:iterator>
				<div class="sp_bton">
					<a href="#"><span class="sp_first" onclick="applythrough()">审核通过</span></a>
					<a href="#"><span class="sp_second" onclick="applyBack()">申请退回</span></a>
					<a href="#"><span class="sp_last" onclick="goBack()">取消</span></a>
				</div>
			</form>
		</div>
	</div>
	<div id="table03" style="display: none">
		<p align="center">施工图审查审核表</p>

		<table border="1" width="100%" height="100%"
			style="border: solid 1px black; border-collapse: collapse">
			<tr>
				<td width="20%"><p align="center">施工图审查机构名称</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="plan.censorCorpName" />
					</p></td>
			</tr>

			<tr>
				<td width="20%"><p align="center">施工图审查合格书编号</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="plan.censorNum" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">项目编号</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="plan.prjNum" />
					</p></td>
			</tr>

			<tr>
				<td width="20%"><p align="center">项目名称</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="plan.prjName" />
					</p></td>
			</tr>


			<tr>
				<td width="20%"><p align="center">审查完成日期</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:date name="plan.censorEDate" format="yyyy-MM-dd" />
					</p></td>
			</tr>

			<tr>
				<td width="20%">
					<p align="center">&nbsp;</p>
					<p align="center">建设规模</p>
					<p align="center">&nbsp;</p>
				</td>
				<td width="80%" colspan="3">
					<p>&nbsp;</p>
					<p>
						&nbsp;
						<s:property value="plan.prjSize" />
					</p>
					<p>&nbsp;</p>
				</td>
			</tr>

			<tr>
				<td width="20%"><p align="center">勘察单位名称</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="plan.econCorpName" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">勘察单位名称2</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="plan.econCorpName2" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">勘察单位名称3</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="plan.econCorpName3" />
					</p></td>
			</tr>

			<tr>
				<td width="20%"><p align="center">设计单位名称</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="plan.designCorpName" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">设计单位名称2</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="plan.designCorpName2" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">设计单位名称3</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="plan.designCorpName3" />
					</p></td>
			</tr>

			<tr>
				<td width="20%"><p align="center">一次审查是否通过</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="plan.oneCensorIsPass" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">一次审查时违反强条数</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="plan.oneCensorWfqtCount" />
					</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">一次审查时违反的强条条目</p></td>
				<td width="80%" colspan="3"><p>
						&nbsp;
						<s:property value="plan.oneCensorWfqtContent" />
					</p></td>
			</tr>

			<tr>
				<td colspan="2" width="50%"><p>施工图审查机构意见：</p>
					<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; （公章）</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>经 办 人</p>
					<p>联系电话</p>
					<p>&nbsp;</p>
					<p align="right">年&nbsp;&nbsp; 月&nbsp;&nbsp; 日</p></td>
				<td colspan="2" width="50%"><p>审核单位意见：</p>
					<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; （公章）</p>
					<p>&nbsp;</p>
					<p>
						&nbsp;
						<s:property value="project.opinion" />
					</p>
					<p>&nbsp;</p>
					<p>经 办 人</p>
					<p>联系电话</p>
					<p>&nbsp;</p>
					<p align="right">年 &nbsp;&nbsp;月 &nbsp;&nbsp;日</p></td>
			</tr>
		</table>
	</div>


</body>
</html>