<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>工程质量监督注册</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
  
//附件下载
function downLoad(uploadId)
{
	document.form1.action="<%=basepath%>/fileUpload_downLoadFile.action?id="+uploadId+"&returnRoot=qualitySuccess";
	document.form1.submit();
}
	//审核通过
	function applythrough()
	{
		var nm = document.getElementById("appId");
		var num = document.getElementById("jianduNum");
		var num2 = document.getElementById("wenjianNum");
		if(num2.value != ""){
			if(num.value != ""){
				if(nm.value != "")
				{
					document.form1.action="<%=basepath%>/qualityApplyAction_applySuccess.action";
					document.form1.submit();
				}else
				{
					alert("请输入审核意见!");	
				}
			}else{
				alert("请输入监督注册号！")
			}
		}else{
			alert("请输入文件编号！")
		}
		
		
		//prn_preview();
	
	}
	//申请退回
	function applyBack()
	{
		var nmv = document.getElementById("appId");
		if(nmv.value != "")
		{
			document.form1.action="<%=basepath%>/qualityApplyAction_applyFaile.action";
			document.form1.submit();
		}else
		{
			alert("请输入审核意见!");	
		}
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/qualityApplyAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">质量勘察审核</h2>
			<form id="form1" name="form1" method="post"
				action="<%=basepath%>/qualityAction_modify.action"
				enctype="multipart/form-data">

				<div class="ry_content">

					<div class="ry_lbxx">
						<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
							<h2>企业质量监督申请</h2>
							<table class="" cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<th>项目名称：</th>
										<td><s:property value="quality.prjName" /><input
											id="prjId" type="hidden" readonly name="quality.prjNum"
											value="<s:property value="quality.prjNum"/>" class="required" />
											<input type="hidden" readonly name="quality.qualityId"
											value="<s:property value="quality.qualityId"/>"
											class="required" /> <input type="hidden"
											name="quality.createDate"
											value="<s:property value="quality.createDate"/>"> <input
											type="hidden" name="quality.appDept"
											value="<s:property value="quality.appDept"/>"></td>
										<th>项目编号：</th>
										<td><s:property value="quality.prjNum" /></td>
									</tr>
									<tr>
										<th>申请企业名称：</th>
										<td><s:property value="quality.applyCorpName" /></td>
										<th>申请企业代码：</th>
										<td><s:property value="quality.applyCorpCode" /></td>
									</tr>
									<tr>
										<td colspan="4" align="left">概况</td>
									</tr>
									<tr>
										<th>工程名称：</th>
										<td><s:property value="quality.projectName" /></td>
										<th>结构/层数：</th>
										<td><s:property value="quality.configuration" /></td>
									</tr>
									<tr>
										<th>工程地点：</th>
										<td><s:property value="quality.projectAddress" /></td>
										<th>联系人：</th>
										<td><s:property value="quality.contact" /></td>
									</tr>
									<tr>
										<th>建设面积(㎡)：</th>
										<td ><s:property value="quality.constructionArea" />㎡</td>
										<th>工程总造价(万元)：</th>
										<td><s:property value="quality.expensive" />万元</td>
									</tr>
									<tr>
										<th>计划开工日期：</th>
										<td><s:date name="quality.startDate" format="yyyy-MM-dd" />
										</td>
										<th>计划竣工日期：</th>
										<td><s:date name="quality.endDate" format="yyyy-MM-dd" />
										</td>
									</tr>
									<tr>
										<th>建设单位：</th>
										<td><s:property value="quality.developmentOrganization" />
										</td>
										<th>建设单位资质等级：</th>
										<td><s:property
												value="quality.developmentQualificationLevel" /></td>
									</tr>
									<tr>
										<th>建设单位项目负责人：</th>
										<td><s:property value="quality.developmentCharge" /></td>
										<th>建设单位联系电话：</th>
										<td><s:property value="quality.developmentPhone" /></td>
									</tr>
									<tr>
										<th>勘察单位：</th>
										<td><s:property value="quality.surveyUnit" /></td>
										<th>勘察单位资质等级：</th>
										<td><s:property
												value="quality.surveyUnitQualificationLevel" /></td>
									</tr>
									<tr>
										<th>勘察单位项目负责人：</th>
										<td><s:property value="quality.surveyUnitCharge" /></td>
										<th>勘察单位联系电话：</th>
										<td><s:property value="quality.surveyUnitPhone" /></td>
									</tr>
									<tr>
										<th>设计单位：</th>
										<td><s:property value="quality.designUnit" /></td>
										<th>设计单位资质等级：</th>
										<td><s:property
												value="quality.designUnitQualificationLevel" /></td>
									</tr>
									<tr>
										<th>设计单位项目负责人：</th>
										<td><s:property value="quality.designUnitCharge" /></td>
										<th>设计单位联系电话：</th>
										<td><s:property value="quality.designUnitPhone" /></td>
									</tr>
									<tr>
										<th>监理单位：</th>
										<td><s:property value="quality.supervisionUnit" /></td>
										<th>监理单位资质等级：</th>
										<td><s:property value="quality.supervisionUnitQualLevel" />
										</td>
									</tr>
									<tr>
										<th>监理单位总监理工程师：</th>
										<td><s:property value="quality.supervisionUnitEngineer" />
										</td>
										<th>监理单位联系电话：</th>
										<td><s:property value="quality.supervisionUnitPhone" /></td>
									</tr>
									<tr>
										<th>施工单位：</th>
										<td><s:property value="quality.constructionUnit" /></td>
										<th>施工单位资质等级：</th>
										<td><s:property value="quality.constructionUnitQualLevel" />
										</td>
									</tr>
									<tr>
										<th>施工单位项目经理：</th>
										<td><s:property
												value="quality.constructionUnitProjectManager" /></td>
										<th>施工单位联系电话 ：</th>
										<td><s:property value="quality.constructionUnitPhone" />
										</td>
									</tr>
									<tr>
										<th>施工图审查机构：</th>
										<td><s:property value="quality.constructionPlans" /></td>
										<th>类别 ：</th>
										<td><s:property value="quality.constructionPlansType" />
										</td>
									</tr>
									<tr>
										<th>施工图审查机构项目经理：</th>
										<td><s:property value="quality.constructionPlansCharge" />
										</td>
										<th>施工图审查机构联系电话 ：</th>
										<td><s:property value="quality.constructionPlansPhone" />
										</td>
									</tr>
									<!-- 
									<tr>
										<td colspan="4" align="left">承包资料</td>
									</tr>
									<tr>
										<th>资料名称</th>
										<th>文件号</th>
										<th>资料名称</th>
										<th>文件号</th>
									</tr>
									<tr>
										<th>施工合同</th>
										<td><s:property
												value="quality.constructionContractFileNum" /></td>
										<th>建设单位项目负责人及项目机构组成</th>
										<td><s:property value="quality.developmentOrganFileNum" />
										</td>
									</tr>
									<tr>
										<th>施工组织设计</th>
										<td><s:property value="quality.constructionOrganFileNum" />
										</td>
										<th>施工单位项目负责人及项目机构组成</th>
										<td><s:property value="quality.onstructionUnitFileNum" />
										</td>
									</tr>
									<tr>
										<th>施工图审查报告和批准书</th>
										<td><s:property value="quality.constructionPlansFileNum" />
										</td>
										<th>监理单位项目负责人及项目机构组成</th>
										<td><s:property value="quality.supervisionUnitFileNum" />
										</td>
									</tr>
									<tr>
										<th>监理合同</th>
										<td><s:property
												value="quality.supervisionContractFileNum" /></td>
										<th>施工现场项目负责人、技术人员资格证书</th>
										<td><s:property value="quality.constructionSiteFileNum" />
										</td>
									</tr>
									<tr>
										<th>监理规划</th>
										<td><s:property value="quality.supervisionPlanFileNum" />
										</td>
										<th>质量检查员岗位证书</th>
										<td><s:property value="quality.qualityTestingFileNum" />
										</td>
									</tr>
									<tr>
										<th>消防设计审查合格书面证明文件</th>
										<td><s:property value="quality.fireControlFileNum" /></td>
										<th>现场监理人员注册执业证书</th>
										<td><s:property value="quality.fieldSupervisionFileNum" />
										</td>
									</tr>
									 -->
									<tr>
										<td>监督注册号：(如不通过，可以不填写。)</td>
										<td><input type="text" id="jianduNum"
											name="quality.jianduzhuceNum" /></td>
										<td>文件编号：(如不通过，可以不填写。)</td>
										<td><input type="text" id="wenjianNum"
											name="quality.wenjianNum" /></td>
									</tr>
									<tr style="height: 60px; border: 0">
										<td>审核意见：</td>
										<td colspan="3"><textarea id="appId" cols="75" rows ="5"
												name="quality.appOpinion" class="required"></textarea></td>
									</tr>
								</tbody>
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
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>



	<!-- 打印页面部分 隐藏 -->
	<div id="table03" style="display: none">
		<p align="center">工程质量监督注册表</p>
		<p align="left">(一)概况</p>
		<table border="1" width="100%" height="50%"
			style="border: solid 1px black; border-collapse: collapse">
			<tr>
				<td width="20%"><p align="center">工程名称</p></td>
				<td width="30%" colspan="2"><p>&nbsp;</p></td>
				<td width="20%" colspan="2"><p align="center">结构/层数</p></td>
				<td width="30%" colspan="2"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">工程地点</p></td>
				<td width="30%" colspan="2"><p>&nbsp;</p></td>
				<td width="20%" colspan="2"><p align="center">联系人</p></td>
				<td width="30%" colspan="2"><p>&nbsp;</p></td>
			</tr>

			<tr>
				<td width="20%"><p align="center">
						建设面积（m<sup>2</sup>）
					</p></td>
				<td width="80%" colspan="6"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="20%"><p align="center">安装工程量（万元）</p></td>
				<td width="80%" colspan="6"><p>&nbsp;</p></td>
			</tr>

			<tr>
				<td width="20%"><p align="center">安装总造价（万元）</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%" colspan="3"><p align="center">监督费（元）</p></td>
				<td width="30%" colspan="2"><p>&nbsp;</p></td>
			</tr>

			<tr>
				<td width="20%"><p align="center">计划开工日期</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%" colspan="3"><p align="center">计划竣工日期</p></td>
				<td width="30%" colspan="2"><p>&nbsp;</p></td>
			</tr>

			<tr>
				<td width="20%" rowspan="2"><p align="center">建设单位</p></td>
				<td width="25%" rowspan="2"><p>&nbsp;</p></td>
				<td width="15%" rowspan="2" colspan="2"><p align="center">资质等级
					</p></td>
				<td width="10%" rowspan="2"><p>&nbsp;</p></td>
				<td width="15%"><p>&nbsp;项目负责人</p></td>
				<td width="15%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="15%"><p>&nbsp;联系电话</p></td>
				<td width="15%"><p>&nbsp;</p></td>
			</tr>

			<tr>
				<td width="20%" rowspan="2"><p align="center">勘察单位</p></td>
				<td width="25%" rowspan="2"><p>&nbsp;</p></td>
				<td width="15%" rowspan="2" colspan="2"><p align="center">资质等级
					</p></td>
				<td width="10%" rowspan="2"><p>&nbsp;</p></td>
				<td width="15%"><p>&nbsp;项目负责人</p></td>
				<td width="15%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="15%"><p>&nbsp;联系电话</p></td>
				<td width="15%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="20%" rowspan="2"><p align="center">设计单位</p></td>
				<td width="25%" rowspan="2"><p>&nbsp;</p></td>
				<td width="15%" rowspan="2" colspan="2"><p align="center">资质等级
					</p></td>
				<td width="10%" rowspan="2"><p>&nbsp;</p></td>
				<td width="15%"><p>&nbsp;项目负责人</p></td>
				<td width="15%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="15%"><p>&nbsp;联系电话</p></td>
				<td width="15%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="20%" rowspan="2"><p align="center">监理单位</p></td>
				<td width="25%" rowspan="2"><p>&nbsp;</p></td>
				<td width="15%" rowspan="2" colspan="2"><p align="center">资质等级
					</p></td>
				<td width="10%" rowspan="2"><p>&nbsp;</p></td>
				<td width="15%"><p>&nbsp;总监理工程师</p></td>
				<td width="15%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="15%"><p>&nbsp;联系电话</p></td>
				<td width="15%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="20%" rowspan="2"><p align="center">施工单位</p></td>
				<td width="25%" rowspan="2"><p>&nbsp;</p></td>
				<td width="15%" rowspan="2" colspan="2"><p align="center">资质等级
					</p></td>
				<td width="10%" rowspan="2"><p>&nbsp;</p></td>
				<td width="15%"><p>&nbsp;项目经理</p></td>
				<td width="15%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="15%"><p>&nbsp;联系电话</p></td>
				<td width="15%"><p>&nbsp;</p></td>
			</tr>

			<tr>
				<td width="20%" rowspan="2"><p align="center">施工图审查机构</p></td>
				<td width="25%" rowspan="2"><p>&nbsp;</p></td>
				<td width="15%" rowspan="2" colspan="2"><p align="center">类别
					</p></td>
				<td width="10%" rowspan="2"><p>&nbsp;</p></td>
				<td width="15%"><p>&nbsp;项目负责人</p></td>
				<td width="15%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="15%"><p>&nbsp;联系电话</p></td>
				<td width="15%"><p>&nbsp;</p></td>
			</tr>
		</table>
		<p align="left">(二)呈报资料</p>
		<table border="1" width="100%" height="32%"
			style="border: solid 1px black; border-collapse: collapse">
			<tr>
				<td width="30%"><p align="center">资料名称</p></td>
				<td width="20%"><p align="center">文件号</p></td>
				<td width="30%"><p align="center">资料名称</p></td>
				<td width="20%"><p align="center">文件号</p></td>
			</tr>
			<tr>
				<td width="30%"><p align="center">施工合同</p></td>
				<td width="20%"><p>&nbsp;</p></td>
				<td width="30%"><p align="center">建设单位项目负责人及项目机构组成</p></td>
				<td width="20%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="30%"><p align="center">施工组织设计</p></td>
				<td width="20%"><p>&nbsp;</p></td>
				<td width="30%"><p align="center">施工单位项目负责人及项目机构组成</p></td>
				<td width="20%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="30%"><p align="center">施工图审查报告和批准书</p></td>
				<td width="20%"><p>&nbsp;</p></td>
				<td width="30%"><p align="center">监理单位项目负责人及项目机构组成</p></td>
				<td width="20%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="30%"><p align="center">监理合同</p></td>
				<td width="20%"><p>&nbsp;</p></td>
				<td width="30%"><p align="center">施工现场项目负责人、技术人员资格证书</p></td>
				<td width="20%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="30%"><p align="center">监理规划</p></td>
				<td width="20%"><p>&nbsp;</p></td>
				<td width="30%"><p align="center">质量检查员岗位证书</p></td>
				<td width="20%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="30%"><p align="center">消防设计审查合格书面证明文件</p></td>
				<td width="20%"><p>&nbsp;</p></td>
				<td width="30%"><p align="center">现场监理人员注册执业证书</p></td>
				<td width="20%"><p>&nbsp;</p></td>
			</tr>
		</table>

		<div id="Content">
			    
			<div id="Content-Left" style="float: left;">经办人：</div>
			    
			<div id="Content-Main" style="float: right;">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</div>
		</div>
	</div>
	<script language="javascript" type="text/javascript">
		var LODOP; //声明为全局变量 
		function prn_preview() {
			CreatePrintPageA();
			LODOP.NewPage();
			CreatePrintPageB();
			LODOP.NewPage();
			CreatePrintPageC();

			LODOP.SET_PRINT_PAGESIZE(0, 0, 0, "A4");
			//LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
			LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW", 1);//打印后自动关闭预览窗口
			LODOP.PREVIEW();
		};
		function CreatePrintPageA() {
			LODOP = getLodop();
			LODOP.PRINT_INIT("工程质量监督注册表");
			var strHTML = "<body style='margin:0;background-color: white'>"
					+ document.getElementById("table03").innerHTML + "</body>";
			LODOP.ADD_PRINT_HTM("10mm", "10mm", "RightMargin:10mm",
					"BottomMargin:10mm", strHTML);
			//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
			LODOP.ADD_PRINT_TEXT(9, 628, 164, 25, "监督注册号：");
			LODOP.ADD_PRINT_TEXT(80, 627, 109, 25, "文件编号 ZJ01-01");
		};

		//工程质量监督通知书
		function CreatePrintPageB() {
			//LODOP=getLodop();  
			//LODOP.PRINT_INIT("质量监督");
			//LODOP.PRINT_INITA(0,0,794,1123,"行政审核");
			//LODOP.SET_PRINT_PAGESIZE(0,2100,2970,"");
			//LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",true);
			LODOP.ADD_PRINT_TEXT(13, 583, 179, 30, "监督注册号：");
			LODOP.ADD_PRINT_TEXT(41, 582, 111, 30, "文件编号 ZJ01-02");

			LODOP.ADD_PRINT_TEXT(255, 229, 439, 40, "工程质量监督通知书");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 25);
			LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
			LODOP.SET_PRINT_STYLEA(0, "LetterSpacing", 5);

			LODOP.ADD_PRINT_TEXT(682, 130, 150, 35, "单位工程名称");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
			//LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",3);
			LODOP.ADD_PRINT_TEXT(717, 130, 150, 35, "建设单位");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
			LODOP.SET_PRINT_STYLEA(0, "LetterSpacing", 14);
			LODOP.ADD_PRINT_TEXT(750, 130, 150, 35, "监督机构");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
			LODOP.SET_PRINT_STYLEA(0, "LetterSpacing", 14);
			LODOP.ADD_PRINT_TEXT(848, 229, 479, 33, "黑龙江省工程质量监督总站监制");
			LODOP.SET_PRINT_STYLEA(0, "LetterSpacing", 3);
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);

			LODOP.ADD_PRINT_TEXT(682, 260, 470, 35, ":");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
			LODOP.ADD_PRINT_TEXT(717, 260, 470, 35, ":");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
			LODOP.ADD_PRINT_TEXT(750, 260, 470, 35, ":");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
		};

		//工程质量监督通知书2
		function CreatePrintPageC() {
			//LODOP=getLodop();  
			//LODOP.PRINT_INIT("质量监督2");
			LODOP
					.ADD_PRINT_TEXT(
							"30mm",
							"20mm",
							"170mm",
							572,
							"XXXX公司:\n"
									+ "    你单位建设的XXXXXXXXXX某工程，我站根据《建设工程质量管理条例》、《黑龙江省建设工程质量监督管理条例》等有关规定，对所提供资料进行了审查，现准予办理工程质量监督注册手续。\n"
									+ "    我站将依据国家、省有关法律、法规和工程建设强制性标准等规定，对责任主体履行质量责任的行为、工程实体质量、混凝土预制构件及预拌混凝土质量、有关工程质量的技术文件和资料进行监督检查和监督巡查；对工程竣工验收实施监督；对责任主体违法违规行为进行调查取证和核实，依据《黑龙江省建设工程质量监督管理条例》实施行政处罚。\n"
									+ "    请按照《建设工程质量责任主体质量行为资料》所列内容做好准备，接受监督检查。\n"
									+ "    我站将在你单位办理监督注册手续后7个工作日内向工程参建各方进行《工程质量监督工作方案》交底，请你单位组织建设项目负责人、施工单位项目负责人、总监理工程师和其他质量责任主体有关人员参加。\n"
									+ "    欢迎对我站及工作人员的工作进行监督，监督电话：XXXX。");
			//LODOP.SET_PRINT_STYLEA(0,"LetterSpacing",3);
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
			LODOP.ADD_PRINT_TEXT(696, 425, 233, 96, "联系人：XXXX\n联系电话：XXXX");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
			LODOP.ADD_PRINT_TEXT(847, 357, 360, 85, "XXXX工程质量监督站\n    年  月  日");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
			LODOP.SET_PRINT_STYLEA(0, "LetterSpacing", 3);
		};
	</script>
</body>
</html>